package org.opencx.app.ui

import android.os.Environment
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
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.opencx.app.data.MediaUsage
import org.opencx.app.data.StorageEngine
import java.io.File

data class Action(val label: String, val icon: ImageVector, val color: Color, val run: () -> Unit)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardView(onNavigate: (File) -> Unit) {
    val ctx = LocalContext.current
    var tab by remember { mutableIntStateOf(0) }
    val volumes = remember { StorageEngine.queryVolumes() }
    val primary = volumes.firstOrNull() ?: return
    var media by remember { mutableStateOf(MediaUsage()) }

    LaunchedEffect(Unit) { media = StorageEngine.queryMediaUsage(ctx) }

    Scaffold(
        topBar = { TopAppBar(title = { Text("OpenCX", color = Color.White, fontWeight = FontWeight.Bold) }, colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF00B0D7))) }
    ) { pad ->
        Column(modifier = Modifier.fillMaxSize().padding(pad)) {
            // Cyan Donut Ring Gauge
            Box(modifier = Modifier.fillMaxWidth().height(180.dp).background(Color(0xFF00B0D7)).padding(16.dp), contentAlignment = Alignment.Center) {
                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceAround) {
                    Box(contentAlignment = Alignment.Center, modifier = Modifier.size(120.dp)) {
                        Canvas(modifier = Modifier.fillMaxSize()) {
                            drawArc(Color.White.copy(0.3f), -90f, 360f, false, style = Stroke(10.dp.toPx(), cap = StrokeCap.Round))
                            drawArc(Color.White, -90f, 360f * primary.pct, false, style = Stroke(10.dp.toPx(), cap = StrokeCap.Round))
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("${(primary.pct * 100).toInt()}%", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Color.White)
                            Text("${StorageEngine.humanSize(primary.used)} / ${StorageEngine.humanSize(primary.total)}", fontSize = 10.sp, color = Color.White)
                        }
                    }
                    Column {
                        Text("Images: ${StorageEngine.humanSize(media.img)}", color = Color.White, fontSize = 12.sp)
                        Text("Audio: ${StorageEngine.humanSize(media.audio)}", color = Color.White, fontSize = 12.sp)
                        Text("Video: ${StorageEngine.humanSize(media.video)}", color = Color.White, fontSize = 12.sp)
                    }
                }
            }

            TabRow(selectedTabIndex = tab, containerColor = Color.White, contentColor = Color(0xFF00B0D7)) {
                Tab(selected = tab == 0, onClick = { tab = 0 }, text = { Text("LOCAL", fontWeight = FontWeight.Bold) })
                Tab(selected = tab == 1, onClick = { tab = 1 }, text = { Text("LIBRARY", fontWeight = FontWeight.Bold) })
            }

            val actions = if (tab == 0) listOf(
                Action("Main storage", Icons.Rounded.Smartphone, Color(0xFFF57C00)) { onNavigate(Environment.getExternalStorageDirectory()) },
                Action("Root (/)", Icons.Rounded.Memory, Color(0xFF37474F)) { onNavigate(File("/")) },
                Action("System (/sys)", Icons.Rounded.Terminal, Color(0xFF455A64)) { onNavigate(File("/sys")) },
                Action("Downloads", Icons.Rounded.Download, Color(0xFF00ACC1)) { onNavigate(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)) },
                Action("Android Data", Icons.Rounded.Android, Color(0xFF7CB342)) { onNavigate(File(Environment.getExternalStorageDirectory(), "Android/data")) },
                Action("Recycle Bin", Icons.Rounded.Delete, Color(0xFF757575)) {
                    val t = File(Environment.getExternalStorageDirectory(), ".opencx_trash").apply { mkdirs() }
                    onNavigate(t)
                }
            ) else listOf(
                Action("Images", Icons.Rounded.Image, Color(0xFF7E57C2)) { onNavigate(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)) },
                Action("Audio", Icons.Rounded.MusicNote, Color(0xFF00897B)) { onNavigate(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC)) },
                Action("Videos", Icons.Rounded.PlayCircle, Color(0xFFE53935)) { onNavigate(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES)) },
                Action("Documents", Icons.AutoMirrored.Rounded.Article, Color(0xFF1E88E5)) { onNavigate(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)) }
            )

            LazyVerticalGrid(columns = GridCells.Fixed(3), modifier = Modifier.fillMaxSize().padding(12.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
                items(actions) { a ->
                    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.clickable { a.run() }.padding(8.dp)) {
                        Box(modifier = Modifier.size(56.dp).clip(CircleShape).background(a.color), contentAlignment = Alignment.Center) {
                            Icon(a.icon, null, tint = Color.White, modifier = Modifier.size(30.dp))
                        }
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(a.label, fontSize = 12.sp, fontWeight = FontWeight.Medium)
                    }
                }
            }
        }
    }
}
