package com.alphainventor.filemanager.ui

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FileExplorerScreen(
    initialDirectory: File,
    onBack: () -> Unit
) {
    var currentDir by remember { mutableStateOf(initialDirectory) }
    val files by remember(currentDir) {
        derivedStateOf {
            currentDir.listFiles()?.sortedWith(compareBy({ !it.isDirectory }, { it.name.lowercase() })) ?: emptyList()
        }
    }

    val selectedFiles = remember { mutableStateListOf<File>() }
    val dateFormat = remember { SimpleDateFormat("MMM d, yyyy", Locale.US) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(currentDir.name.ifEmpty { "Storage" }) },
                navigationIcon = {
                    IconButton(onClick = {
                        val parent = currentDir.parentFile
                        if (parent != null && parent.canRead()) currentDir = parent else onBack()
                    }) {
                        Icon(Icons.AutoMirrored.Rounded.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = { /* Toggle View */ }) {
                        Icon(Icons.AutoMirrored.Rounded.ViewList, contentDescription = "View")
                    }
                    IconButton(onClick = { /* Options */ }) {
                        Icon(Icons.Rounded.MoreVert, contentDescription = "Options")
                    }
                }
            )
        },
        bottomBar = {
            if (selectedFiles.isNotEmpty()) {
                BottomAppBar(containerColor = Color(0xFFEEEEEE)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        TextButton(onClick = { /* Copy */ }) { Text("Copy") }
                        TextButton(onClick = { /* Move */ }) { Text("Move") }
                        TextButton(onClick = { /* Rename */ }) { Text("Rename") }
                        TextButton(onClick = {
                            selectedFiles.forEach { it.deleteRecursively() }
                            selectedFiles.clear()
                            currentDir = File(currentDir.absolutePath)
                        }) { Text("Delete", color = MaterialTheme.colorScheme.error) }
                    }
                }
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            items(files) { file ->
                val isSelected = selectedFiles.contains(file)
                ListItem(
                    modifier = Modifier.clickable {
                        if (file.isDirectory) currentDir = file
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
                            val kb = file.length() / 1024
                            if (kb > 1024) "${kb / 1024} MB" else "$kb KB"
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
}
