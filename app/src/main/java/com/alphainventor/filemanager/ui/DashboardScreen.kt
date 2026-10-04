package com.alphainventor.filemanager.ui

import android.os.Environment
import android.os.StatFs
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.Article
import androidx.compose.material.icons.rounded.*
import androidx.compose.material.icons.automirrored.rounded.*
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

data class ActionButton(val label: String, val icon: ImageVector, val color: Color, val onClick: () -> Unit)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    onNavigateFolder: (File) -> Unit,
    onOpenAnalyzer: () -> Unit,
    onOpenNetwork: () -> Unit,
    onOpenSettings: () -> Unit
) {
    var selectedTab by remember { mutableIntStateOf(0) }
    var menuExpanded by remember { mutableStateOf(false) }

    val stat = remember {
        val path = Environment.getExternalStorageDirectory()
        val stat = StatFs(path.path)
        val total = stat.totalBytes
        val free = stat.availableBytes
        val used = total - free
        val pct = if (total > 0) (used.toFloat() / total.toFloat()) else 0f
        Triple(used / (1024L * 1024 * 1024), total / (1024L * 1024 * 1024), pct)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Cx File Explorer", color = Color.White, fontWeight = FontWeight.SemiBold) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = CxCyan),
                actions = {
                    IconButton(onClick = { /* Refresh */ }) {
                        Icon(Icons.Rounded.Refresh, contentDescription = "Refresh", tint = Color.White)
                    }
                    IconButton(onClick = { menuExpanded = true }) {
                        Icon(Icons.Rounded.MoreVert, contentDescription = "Menu", tint = Color.White)
                    }
                    DropdownMenu(expanded = menuExpanded, onDismissRequest = { menuExpanded = false }) {
                        DropdownMenuItem(
                            text = { Text("Settings") },
                            leadingIcon = { Icon(Icons.Rounded.Settings, contentDescription = null) },
                            onClick = { menuExpanded = false; onOpenSettings() }
                        )
                        DropdownMenuItem(
                            text = { Text("Refresh") },
                            leadingIcon = { Icon(Icons.Rounded.Refresh, contentDescription = null) },
                            onClick = { menuExpanded = false }
                        )
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            // --- Cyan Curved Header (Screenshots 1-3) ---
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(210.dp)
                    .background(CxCyan)
                    .padding(horizontal = 20.dp),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Donut Chart
                    Box(contentAlignment = Alignment.Center, modifier = Modifier.size(130.dp)) {
                        Canvas(modifier = Modifier.fillMaxSize()) {
                            drawArc(
                                color = Color.White.copy(alpha = 0.3f),
                                startAngle = -90f,
                                sweepAngle = 360f,
                                useCenter = false,
                                style = Stroke(width = 12.dp.toPx(), cap = StrokeCap.Round)
                            )
                            drawArc(
                                color = Color.White,
                                startAngle = -90f,
                                sweepAngle = 360f * stat.third,
                                useCenter = false,
                                style = Stroke(width = 12.dp.toPx(), cap = StrokeCap.Round)
                            )
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("${(stat.third * 100).toInt()}%", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.White)
                            Text("Main storage", fontSize = 11.sp, color = Color.White.copy(alpha = 0.9f))
                            Text("${stat.first} GB / ${stat.second} GB", fontSize = 10.sp, color = Color.White.copy(alpha = 0.9f))
                        }
                    }

                    // Quick Stats & Clean Button
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Column {
                            Text("Images", color = Color.White.copy(alpha = 0.9f), fontSize = 13.sp)
                            Text("Audio", color = Color.White.copy(alpha = 0.9f), fontSize = 13.sp)
                            Text("Videos", color = Color.White.copy(alpha = 0.9f), fontSize = 13.sp)
                        }
                        Spacer(modifier = Modifier.height(14.dp))
                        Button(
                            onClick = onOpenAnalyzer,
                            colors = ButtonDefaults.buttonColors(containerColor = Color.White.copy(alpha = 0.25f)),
                            shape = RoundedCornerShape(4.dp),
                            border = BorderStroke(1.dp, Color.White),
                            contentPadding = PaddingValues(horizontal = 28.dp, vertical = 6.dp)
                        ) {
                            Text("CLEAN", color = Color.White, fontWeight = FontWeight.Bold, letterSpacing = 1.sp)
                        }
                    }
                }
            }

            // --- 3 Tabs: LOCAL | LIBRARY | NETWORK (Screenshots 1, 4, 5) ---
            TabRow(
                selectedTabIndex = selectedTab,
                containerColor = Color.White,
                contentColor = CxCyan
            ) {
                Tab(selected = selectedTab == 0, onClick = { selectedTab = 0 }, text = { Text("LOCAL", fontWeight = FontWeight.Bold) })
                Tab(selected = selectedTab == 1, onClick = { selectedTab = 1 }, text = { Text("LIBRARY", fontWeight = FontWeight.Bold) })
                Tab(selected = selectedTab == 2, onClick = { selectedTab = 2 }, text = { Text("NETWORK", fontWeight = FontWeight.Bold) })
            }

            Spacer(modifier = Modifier.height(16.dp))

            // --- Circular Buttons Grid ---
            val localButtons = listOf(
                ActionButton("Main storage", Icons.Rounded.Smartphone, Color(0xFFF57C00)) { onNavigateFolder(Environment.getExternalStorageDirectory()) },
                ActionButton("SD card", Icons.Rounded.SdCard, Color(0xFF3F51B5)) { onNavigateFolder(Environment.getExternalStorageDirectory()) },
                ActionButton("System", Icons.Rounded.Memory, Color(0xFF37474F)) { onNavigateFolder(File("/sys")) },
                ActionButton("Downloads", Icons.Rounded.Download, Color(0xFF00ACC1)) { onNavigateFolder(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)) },
                ActionButton("Apps", Icons.Rounded.Android, Color(0xFF7CB342)) { /* Apps */ },
                ActionButton("Recycle Bin", Icons.Rounded.Delete, Color(0xFF757575)) { /* Recycle */ }
            )

            val libraryButtons = listOf(
                ActionButton("Images", Icons.Rounded.Image, Color(0xFF7E57C2)) { onNavigateFolder(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)) },
                ActionButton("Audio", Icons.Rounded.MusicNote, Color(0xFF00897B)) { onNavigateFolder(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC)) },
                ActionButton("Videos", Icons.Rounded.PlayCircle, Color(0xFFE53935)) { onNavigateFolder(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES)) },
                ActionButton("Documents", Icons.AutoMirrored.Rounded.Article, Color(0xFF1E88E5)) { onNavigateFolder(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)) },
                ActionButton("New files", Icons.Rounded.AccessTime, Color(0xFF546E7A)) { /* New Files */ }
            )

            val networkButtons = listOf(
                ActionButton("Access from net...", Icons.Rounded.Devices, Color(0xFFFBC02D)) { onOpenNetwork() },
                ActionButton("New location", Icons.Rounded.Add, Color(0xFF5C6BC0)) { /* Add Remote */ }
            )

            val currentButtons = when (selectedTab) {
                0 -> localButtons
                1 -> libraryButtons
                else -> networkButtons
            }

            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 12.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(currentButtons) { btn ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .clickable { btn.onClick() }
                            .padding(8.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(64.dp)
                                .clip(CircleShape)
                                .background(btn.color),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(btn.icon, contentDescription = btn.label, tint = Color.White, modifier = Modifier.size(34.dp))
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(btn.label, fontSize = 13.sp, fontWeight = FontWeight.Normal, color = Color.Black)
                    }
                }
            }
        }
    }
}
