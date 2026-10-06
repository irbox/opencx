package org.opencx.app.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.opencx.app.data.StorageRepository

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NetworkFtpScreen(onBack: () -> Unit) {
    var isRunning by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Access from network") },
                navigationIcon = {
                    IconButton(onClick = onBack) { Icon(Icons.AutoMirrored.Rounded.ArrowBack, contentDescription = "Back") }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(padding).padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(Icons.Rounded.Laptop, contentDescription = null, modifier = Modifier.size(90.dp), tint = CxCyan)
            Spacer(modifier = Modifier.height(24.dp))

            if (isRunning) {
                Surface(
                    color = Color.Black,
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp),
                    modifier = Modifier.fillMaxWidth().padding(16.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("ftp://10.x.x.x:3293", color = Color.Yellow, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("Username: pc", color = Color.White)
                        Text("Password: (random active)", color = Color.White)
                    }
                }
            } else {
                Text("Start the service to access files from another device.", color = Color.Gray)
            }

            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = { isRunning = !isRunning },
                colors = ButtonDefaults.buttonColors(containerColor = CxCyan)
            ) {
                Text(if (isRunning) "STOP SERVICE" else "START SERVICE")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StorageAnalyzerScreen(onBack: () -> Unit) {
    val volume = remember { StorageRepository.getMainStorageVolume() }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Analyze storage") },
                navigationIcon = {
                    IconButton(onClick = onBack) { Icon(Icons.AutoMirrored.Rounded.ArrowBack, contentDescription = "Back") }
                }
            )
        }
    ) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(16.dp)) {
            Text("Main storage: ${StorageRepository.formatSize(volume.totalBytes - volume.usedBytes)} free", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text("${(volume.percent * 100).toInt()}% Used", color = CxCyan, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(16.dp))
            LinearProgressIndicator(
                progress = { volume.percent },
                modifier = Modifier.fillMaxWidth().height(12.dp),
                color = CxCyan
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Settings") },
                navigationIcon = {
                    IconButton(onClick = onBack) { Icon(Icons.AutoMirrored.Rounded.ArrowBack, contentDescription = "Back") }
                }
            )
        }
    ) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(16.dp)) {
            Text("OpenCX Version 1.0.0", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text("Clean architecture: Jetpack Compose + Material 3 Expressive")
            Text("Toolchain: AGP 8.8.2 | Kotlin 2.1.0 | Java 21 LTS")
        }
    }
}
