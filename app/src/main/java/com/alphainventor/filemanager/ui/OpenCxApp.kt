package com.alphainventor.filemanager.ui

import android.os.Environment
import android.os.StatFs
import androidx.compose.animation.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.io.File

val CxCyan = Color(0xFF00B0D7)
val CxCyanDark = Color(0xFF0091B3)

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
