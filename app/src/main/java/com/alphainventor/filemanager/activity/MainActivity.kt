package com.alphainventor.filemanager.activity

import android.os.Bundle
import android.os.Environment
import android.os.StatFs
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cxinventor.file.explorer.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(colorScheme = darkColorScheme()) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    OpenCxDashboard()
                }
            }
        }
    }
}

data class CategoryItem(val titleRes: Int, val icon: ImageVector, val color: Color)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OpenCxDashboard() {
    val stat = remember {
        val path = Environment.getDataDirectory()
        val stat = StatFs(path.path)
        val total = stat.totalBytes
        val free = stat.availableBytes
        val used = total - free
        val percent = if (total > 0) (used.toFloat() / total.toFloat()) else 0f
        Triple(used / (1024 * 1024 * 1024), total / (1024 * 1024 * 1024), percent)
    }

    val categories = remember {
        listOf(
            CategoryItem(R.string.category_images, Icons.Rounded.Image, Color(0xFFE57373)),
            CategoryItem(R.string.category_audio, Icons.Rounded.Audiotrack, Color(0xFFFFB74D)),
            CategoryItem(R.string.category_videos, Icons.Rounded.VideoLibrary, Color(0xFF81C784)),
            CategoryItem(R.string.category_docs, Icons.Rounded.Description, Color(0xFF64B5F6)),
            CategoryItem(R.string.category_downloads, Icons.Rounded.Download, Color(0xFFBA68C8)),
            CategoryItem(R.string.category_apps, Icons.Rounded.Apps, Color(0xFF4DB6AC)),
            CategoryItem(R.string.category_recycle_bin, Icons.Rounded.Delete, Color(0xFFA1887F))
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("OpenCX Explorer", fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            // --- Storage Card ---
            ElevatedCard(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(stringResource(R.string.storage_main), fontWeight = FontWeight.SemiBold)
                        Text("${stat.first} GB / ${stat.second} GB", color = MaterialTheme.colorScheme.primary)
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    LinearProgressIndicator(
                        progress = { stat.third },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(10.dp)
                            .clip(RoundedCornerShape(5.dp)),
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
            Text("Categories", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(12.dp))

            // --- Category Grid ---
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(categories) { item ->
                    ElevatedCard(
                        modifier = Modifier
                            .aspectRatio(1f)
                            .clickable { /* Navigate to category */ },
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = null,
                                tint = item.color,
                                modifier = Modifier.size(36.dp)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = stringResource(item.titleRes),
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }
                }
            }
        }
    }
}
