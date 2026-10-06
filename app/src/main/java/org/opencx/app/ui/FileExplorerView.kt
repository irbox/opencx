package org.opencx.app.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.automirrored.rounded.InsertDriveFile
import androidx.compose.material.icons.automirrored.rounded.Sort
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import org.opencx.app.data.Entry
import org.opencx.app.data.FileEngine
import org.opencx.app.data.SortKey
import org.opencx.app.data.StorageEngine
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FileExplorerView(initial: File, onBack: () -> Unit) {
    val ctx = LocalContext.current
    val scope = rememberCoroutineScope()
    var currentDir by remember { mutableStateOf(initial) }
    var items by remember { mutableStateOf<List<Entry>>(emptyList()) }
    val selection = remember { mutableStateListOf<File>() }
    var sortKey by remember { mutableStateOf(SortKey.NAME) }
    var sortDesc by remember { mutableStateOf(false) }
    var newFolderDialog by remember { mutableStateOf(false) }
    var newFolderName by remember { mutableStateOf("") }
    val df = remember { SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.US) }

    suspend fun refresh() { items = FileEngine.list(currentDir, sortKey, sortDesc) }
    LaunchedEffect(currentDir, sortKey, sortDesc) { refresh() }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(currentDir.name.ifEmpty { "/" }, fontWeight = FontWeight.Bold, maxLines = 1)
                        Text(currentDir.absolutePath, fontSize = 11.sp, fontFamily = FontFamily.Monospace, color = Color.Gray, maxLines = 1)
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { currentDir.parentFile?.takeIf { it.canRead() }?.let { currentDir = it } ?: onBack() }) {
                        Icon(Icons.AutoMirrored.Rounded.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = { sortDesc = !sortDesc }) { Icon(Icons.AutoMirrored.Rounded.Sort, contentDescription = "Sort") }
                    IconButton(onClick = { newFolderDialog = true }) { Icon(Icons.Rounded.CreateNewFolder, contentDescription = "New Folder") }
                }
            )
        },
        bottomBar = {
            if (selection.isNotEmpty()) {
                BottomAppBar {
                    Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                        Text("${selection.size} selected", fontWeight = FontWeight.Bold)
                        Button(onClick = { scope.launch { FileEngine.delete(selection.toList()); selection.clear(); refresh() } }, colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)) {
                            Text("Delete (${selection.size})")
                        }
                    }
                }
            }
        }
    ) { pad ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(pad)) {
            items(items) { item ->
                val selected = selection.contains(item.file)
                ListItem(
                    modifier = Modifier.clickable {
                        if (item.isDir) { currentDir = item.file; selection.clear() } else FileEngine.open(ctx, item.file)
                    },
                    leadingContent = {
                        Icon(
                            if (item.isDir) Icons.Rounded.Folder else Icons.AutoMirrored.Rounded.InsertDriveFile,
                            null,
                            tint = if (item.isDir) Color(0xFFFBC02D) else Color(0xFF90A4AE),
                            modifier = Modifier.size(36.dp)
                        )
                    },
                    headlineContent = { Text(item.file.name, fontWeight = FontWeight.Medium, maxLines = 1) },
                    supportingContent = {
                        val meta = if (item.isDir) "${item.itemsCount} items" else StorageEngine.humanSize(item.size)
                        Text("$meta | ${item.permissions} | ${df.format(Date(item.mtime))}", fontSize = 11.sp, fontFamily = FontFamily.Monospace)
                    },
                    trailingContent = {
                        Checkbox(checked = selected, onCheckedChange = { if (it) selection.add(item.file) else selection.remove(item.file) })
                    }
                )
                HorizontalDivider(color = Color(0xFFEEEEEE))
            }
        }

        if (newFolderDialog) {
            AlertDialog(
                onDismissRequest = { newFolderDialog = false },
                title = { Text("New Directory") },
                text = { OutlinedTextField(value = newFolderName, onValueChange = { newFolderName = it }, singleLine = true) },
                confirmButton = {
                    TextButton(onClick = {
                        scope.launch { if (newFolderName.isNotBlank()) FileEngine.mkdir(currentDir, newFolderName); newFolderName = ""; newFolderDialog = false; refresh() }
                    }) { Text("Create") }
                },
                dismissButton = { TextButton(onClick = { newFolderDialog = false }) { Text("Cancel") } }
            )
        }
    }
}
