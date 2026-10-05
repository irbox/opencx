package com.alphainventor.filemanager.ui

import android.content.Intent
import android.net.Uri
import android.webkit.MimeTypeMap
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
import androidx.core.content.FileProvider
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
    var currentDir by remember { mutableStateOf(initialDirectory) }
    var refreshKey by remember { mutableIntStateOf(0) }

    val files = remember(currentDir, refreshKey) {
        currentDir.listFiles()?.sortedWith(compareBy({ !it.isDirectory }, { it.name.lowercase() }))?.toList() ?: emptyList()
    }

    val selectedFiles = remember { mutableStateListOf<File>() }
    val dateFormat = remember { SimpleDateFormat("MMM d, yyyy", Locale.US) }
    var showNewFolderDialog by remember { mutableStateOf(false) }
    var newFolderName by remember { mutableStateOf("") }

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
                    IconButton(onClick = { showNewFolderDialog = true }) {
                        Icon(Icons.Rounded.CreateNewFolder, contentDescription = "New Folder")
                    }
                    IconButton(onClick = { refreshKey++ }) {
                        Icon(Icons.Rounded.Refresh, contentDescription = "Refresh")
                    }
                }
            )
        },
        bottomBar = {
            if (selectedFiles.isNotEmpty()) {
                BottomAppBar(containerColor = Color(0xFFF5F5F5)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Text("${selectedFiles.size} selected", fontWeight = FontWeight.Bold, modifier = Modifier.align(Alignment.CenterVertically))
                        Button(
                            onClick = {
                                selectedFiles.forEach { file ->
                                    if (file.isDirectory) file.deleteRecursively() else file.delete()
                                }
                                selectedFiles.clear()
                                refreshKey++
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
        if (files.isEmpty()) {
            Box(modifier = Modifier.fillMaxSize().padding(padding), contentAlignment = Alignment.Center) {
                Text("Folder is empty", color = Color.Gray)
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                items(files) { file ->
                    val isSelected = selectedFiles.contains(file)
                    ListItem(
                        modifier = Modifier.clickable {
                            if (file.isDirectory) {
                                currentDir = file
                                selectedFiles.clear()
                            } else {
                                // Launch real file in Android System viewer
                                try {
                                    val ext = file.extension.lowercase()
                                    val mime = MimeTypeMap.getSingleton().getMimeTypeFromExtension(ext) ?: "*/*"
                                    val uri: Uri = FileProvider.getUriForFile(context, "${context.packageName}.fileprovider", file)
                                    val intent = Intent(Intent.ACTION_VIEW).apply {
                                        setDataAndType(uri, mime)
                                        addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                                    }
                                    context.startActivity(Intent.createChooser(intent, "Open with"))
                                } catch (e: Exception) {
                                    // Fallback for restricted access
                                }
                            }
                        },
                        leadingContent = {
                            Icon(
                                imageVector = if (file.isDirectory) Icons.Rounded.Folder else Icons.AutoMirrored.Rounded.InsertDriveFile,
                                contentDescription = null,
                                tint = if (file.isDirectory) Color(0xFFFBC02D) else Color(0xFF90A4AE),
                                modifier = Modifier.size(38.dp)
                            )
                        },
                        headlineContent = { Text(file.name, fontWeight = FontWeight.Medium, maxLines = 1) },
                        supportingContent = {
                            val detail = if (file.isDirectory) {
                                "${file.listFiles()?.size ?: 0} items"
                            } else {
                                RealStorageEngine.formatSize(file.length())
                            }
                            Text("$detail  •  ${dateFormat.format(Date(file.lastModified()))}", fontSize = 12.sp)
                        },
                        trailingContent = {
                            Checkbox(
                                checked = isSelected,
                                onCheckedChange = { checked ->
                                    if (checked) selectedFiles.add(file) else selectedFiles.remove(file)
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
                            val newDir = File(currentDir, newFolderName.trim())
                            newDir.mkdirs()
                            newFolderName = ""
                            showNewFolderDialog = false
                            refreshKey++
                        }
                    }) { Text("OK") }
                },
                dismissButton = {
                    TextButton(onClick = { showNewFolderDialog = false }) { Text("Cancel") }
                }
            )
        }
    }
}
