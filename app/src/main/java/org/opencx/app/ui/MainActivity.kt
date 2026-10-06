package org.opencx.app.ui

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import java.io.File

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && !Environment.isExternalStorageManager()) {
            startActivity(Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION, Uri.parse("package:$packageName")))
        }
        setContent {
            MaterialTheme(colorScheme = lightColorScheme(primary = Color(0xFF00B0D7))) {
                Surface(modifier = Modifier.fillMaxSize()) {
                    var inExplorer by remember { mutableStateOf(false) }
                    var targetDir by remember { mutableStateOf(Environment.getExternalStorageDirectory()) }

                    if (inExplorer) {
                        FileExplorerView(initial = targetDir, onBack = { inExplorer = false })
                    } else {
                        DashboardView(onNavigate = { targetDir = it; inExplorer = true })
                    }
                }
            }
        }
    }
}
