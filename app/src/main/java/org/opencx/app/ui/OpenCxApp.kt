package org.opencx.app.ui

import android.os.Environment
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import java.io.File

enum class Screen { DASHBOARD, EXPLORER, ANALYZER, NETWORK, SETTINGS }

@Composable
fun OpenCxApp() {
    var currentScreen by remember { mutableStateOf(Screen.DASHBOARD) }
    var currentPath by remember { mutableStateOf(Environment.getExternalStorageDirectory()) }

    MaterialTheme(
        colorScheme = lightColorScheme(
            primary = CxCyan,
            onPrimary = Color.White,
            background = Color(0xFFF7F9FA),
            surface = Color.White
        )
    ) {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            when (currentScreen) {
                Screen.DASHBOARD -> DashboardScreen(
                    onNavigateFolder = { folder ->
                        currentPath = folder
                        currentScreen = Screen.EXPLORER
                    },
                    onOpenAnalyzer = { currentScreen = Screen.ANALYZER },
                    onOpenNetwork = { currentScreen = Screen.NETWORK },
                    onOpenSettings = { currentScreen = Screen.SETTINGS }
                )
                Screen.EXPLORER -> FileExplorerScreen(
                    initialDirectory = currentPath,
                    onBack = { currentScreen = Screen.DASHBOARD }
                )
                Screen.ANALYZER -> StorageAnalyzerScreen(onBack = { currentScreen = Screen.DASHBOARD })
                Screen.NETWORK -> NetworkFtpScreen(onBack = { currentScreen = Screen.DASHBOARD })
                Screen.SETTINGS -> SettingsScreen(onBack = { currentScreen = Screen.DASHBOARD })
            }
        }
    }
}
