package org.opencx.app.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.automirrored.rounded.InsertDriveFile
import androidx.compose.material.icons.automirrored.rounded.ViewList
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import org.opencx.app.data.FileItem
import org.opencx.app.data.FileRepository
import org.opencx.app.data.SortMode
import org.opencx.app.data.StorageRepository
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FileExplorerScreen(
    initialDirectory: File,
    onBack: () -> Unit
) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    var currentDir by remember { mutableStateOf(initialDirectory) }
    var fileItems by remember { mutableStateOf<List<FileItem>>(emptyList()) }
    val selectedFiles = remember { mutableStateListOf<File>() }

    var sortMode by remember { mutableStateOf(SortMode.NAME_ASC) }
    var showSortDialog by remember { mutableStateOf(false) }
    var showNewFolderDialog by remember { mutableStateOf(false) }
    var newFolderName by remember { mutableStateOf("") }
    val dateFormat = remember { SimpleDateFormat("MMM d, yyyy", Locale.US) }

    suspend fun reload() {
        fileItems = FileRepository.getDirectoryContents(currentDir, sortMode)
    }

    LaunchedEffect(currentDir, sortMode) {
        reload()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(currentDir.name.ifEmpty { "Storage" }, fontWeight = FontWeight.Bold, maxLines = 1)
                        Text(currentDir.absolutePath, fontSize = 11.sp, color = Color.Gray, maxLines = 1)
                    }
                },
                navigationIcon = {
                    IconButton(onClick = {
                        val parent = currentDir.parentFile
                        if (parent != null && parent.canRead()) currentDir = parent else onBack()
                    }) {
                        Icon(Icons.AutoMirrored.Rounded.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = { showSortDialog = true }) {
                        Icon(Icons.AutoMirrored.Rounded.ViewList, contentDescription = "Sort")
                    }
                    IconButton(onClick = { showNewFolderDialog = true }) {
                        Icon(Icons.Rounded.CreateNewFolder, contentDescription = "New Folder")
                    }
                }
            )
        },
        bottomBar = {
            if (selectedFiles.isNotEmpty()) {
                BottomAppBar(containerColor = Color(0xFFF5F5F5)) {
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("${selectedFiles.size} selected", fontWeight = FontWeight.Bold)
                        Button(
                            onClick = {
                                scope.launch {
                                    FileRepository.deleteFiles(selectedFiles.toList())
                                    selectedFiles.clear()
                                    reload()
                                }
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
                        ) {
                            Text("Delete")
                        }
                    }
                }
            }
        }
    ) { padding ->
        if (fileItems.isEmpty()) {
            Box(modifier = Modifier.fillMaxSize().padding(padding), contentAlignment = Alignment.Center) {
                Text("Folder is empty", color = Color.Gray)
            }
        } else {
            LazyColumn(modifier = Modifier.fillMaxSize().padding(padding)) {
                items(fileItems) { item ->
                    val isSelected = selectedFiles.contains(item.file)
                    ListItem(
                        modifier = Modifier.clickable {
                            if (item.isDirectory) {
                                currentDir = item.file
                                selectedFiles.clear()
                            } else {
                                FileRepository.openFile(context, item.file)
                            }
                        },
                        leadingContent = {
                            Icon(
                                imageVector = if (item.isDirectory) Icons.Rounded.Folder else Icons.AutoMirrored.Rounded.InsertDriveFile,
                                contentDescription = null,
                                tint = if (item.isDirectory) Color(0xFFFBC02D) else Color(0xFF90A4AE),
                                modifier = Modifier.size(38.dp)
                            )
                        },
                        headlineContent = { Text(item.name, fontWeight = FontWeight.Medium, maxLines = 1) },
                        supportingContent = {
                            val detail = if (item.isDirectory) "${item.childCount} items" else StorageRepository.formatSize(item.size)
                            Text("$detail  •  ${dateFormat.format(Date(item.lastModified))}", fontSize = 12.sp)
                        },
                        trailingContent = {
                            Checkbox(
                                checked = isSelected,
                                onCheckedChange = { checked ->
                                    if (checked) selectedFiles.add(item.file) else selectedFiles.remove(item.file)
                                }
                            )
                        }
                    )
                    HorizontalDivider(color = Color(0xFFF0F0F0))
                }
            }
        }

        // Real Create Folder Dialog
        if (showNewFolderDialog) {
            AlertDialog(
                onDismissRequest = { showNewFolderDialog = false },
                title = { Text("Create Folder") },
                text = {
                    OutlinedTextField(
                        value = newFolderName,
                        onValueChange = { newFolderName = it },
                        label = { Text("Folder Name") },
                        singleLine = true
                    )
                },
                confirmButton = {
                    TextButton(onClick = {
                        if (newFolderName.isNotBlank()) {
                            scope.launch {
                                FileRepository.createFolder(currentDir, newFolderName)
                                newFolderName = ""
                                showNewFolderDialog = false
                                reload()
                            }
                        }
                    }) { Text("OK") }
                },
                dismissButton = {
                    TextButton(onClick = { showNewFolderDialog = false }) { Text("Cancel") }
                }
            )
        }

        // Real Sort By Dialog (Screenshot 21)
        if (showSortDialog) {
            AlertDialog(
                onDismissRequest = { showSortDialog = false },
                title = { Text("Sort By") },
                text = {
                    Column {
                        listOf(
                            "Name (A-Z)" to SortMode.NAME_ASC,
                            "Name (Z-A)" to SortMode.NAME_DESC,
                            "Size (Smallest)" to SortMode.SIZE_ASC,
                            "Size (Largest)" to SortMode.SIZE_DESC,
                            "Date (Newest)" to SortMode.DATE_DESC,
                            "Date (Oldest)" to SortMode.DATE_ASC
                        ).forEach { (label, mode) ->
                            Row(
                                modifier = Modifier.fillMaxWidth().clickable { sortMode = mode; showSortDialog = false }.padding(vertical = 10.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                RadioButton(selected = sortMode == mode, onClick = null)
                                Spacer(modifier = Modifier.width(12.dp))
                                Text(label)
                            }
                        }
                    }
                },
                confirmButton = { TextButton(onClick = { showSortDialog = false }) { Text("Close") } }
            )
        }
    }
}
