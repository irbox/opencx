package com.alphainventor.filemanager.ui.screen;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.compose.foundation.background;
import androidx.compose.foundation.clickable;
import androidx.compose.foundation.layout.Box;
import androidx.compose.foundation.layout.Column;
import androidx.compose.foundation.layout.Row;
import androidx.compose.foundation.layout.Spacer;
import androidx.compose.foundation.layout.fillMaxHeight;
import androidx.compose.foundation.layout.fillMaxSize;
import androidx.compose.foundation.layout.fillMaxWidth;
import androidx.compose.foundation.layout.height;
import androidx.compose.foundation.layout.padding;
import androidx.compose.foundation.layout.size;
import androidx.compose.foundation.layout.width;
import androidx.compose.foundation.lazy.LazyColumn;
import androidx.compose.foundation.lazy.items;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.ArrowBack;
import androidx.compose.material.icons.filled.MoreVert;
import androidx.compose.material.icons.filled.Search;
import androidx.compose.material3.CenterAlignedTopAppBar;
import androidx.compose.material3.CircularProgressIndicator;
import androidx.compose.material3.ExperimentalMaterial3Api;
import androidx.compose.material3.Icon;
import androidx.compose.material3.IconButton;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.Scaffold;
import androidx.compose.material3.Text;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.getValue;
import androidx.compose.runtime.livedata.observeAsState;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.overflow.TextOverflow;
import androidx.compose.ui.unit.dp;
import androidx.compose.ui.unit.sp;

import com.alphainventor.filemanager.contract.FileInfo;
import com.alphainventor.filemanager.ui.state.FileBrowserUiState;
import com.alphainventor.filemanager.viewmodel.FileExplorerViewModel;

import java.util.List;

/**
 * Main file browser screen composable.
 *
 * <p>This displays the current directory contents and handles user interactions like:
 * - Navigating between directories
 * - Selecting files for operations
 * - Displaying error states and loading indicators
 * - Sorting and filtering options</p>
 */
public class FileBrowserScreen {

    private FileBrowserScreen() {
        // No-op
    }

    @Composable
    public static void Content(@NonNull FileExplorerViewModel viewModel,
                              @NonNull Context context) {
        FileBrowserUiState uiState = observeUiState(viewModel);
        FileBrowserScreenContent(viewModel, context, uiState);
    }

    @Composable
    private static FileBrowserUiState observeUiState(@NonNull FileExplorerViewModel viewModel) {
        final FileBrowserUiState[] state = {FileBrowserUiState.builder().build()};
        final FileBrowserUiState[] result = observeAsState(null).getValue();
        return result != null ? result : state[0];
    }

    @Composable
    @OptIn(ExperimentalMaterial3Api.class)
    private static void FileBrowserScreenContent(@NonNull FileExplorerViewModel viewModel,
                                                @NonNull Context context,
                                                @NonNull FileBrowserUiState uiState) {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            text = uiState.getCurrentPath(),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            fontSize = 14.sp
                        );
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = { viewModel.navigateUp(); }
                        ) {
                            Icon(Icons.Filled.ArrowBack, contentDescription = "Back");
                        };
                    },
                    actions = {
                        IconButton(
                            onClick = { /* Show search */ }
                        ) {
                            Icon(Icons.Filled.Search, contentDescription = "Search");
                        };
                        IconButton(
                            onClick = { /* Show menu */ }
                        ) {
                            Icon(Icons.Filled.MoreVert, contentDescription = "More");
                        };
                    }
                );
            },
            content = { innerPadding ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                ) {
                    if (uiState.isLoading()) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator(
                                modifier = Modifier.size(48.dp)
                            );
                        };
                    } else if (uiState.hasError()) {
                        ErrorContent(viewModel, uiState);
                    } else if (uiState.getFiles().isEmpty()) {
                        EmptyStateContent();
                    } else {
                        FileListContent(viewModel, context, uiState.getFiles());
                    }
                };
            }
        );
    }

    @Composable
    private static void FileListContent(@NonNull FileExplorerViewModel viewModel,
                                       @NonNull Context context,
                                       @NonNull List<FileInfo> files) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(files) { file ->
                FileListItem(file, viewModel, context);
            };
        };
    }

    @Composable
    private static void FileListItem(@NonNull FileInfo file,
                                    @NonNull FileExplorerViewModel viewModel,
                                    @NonNull Context context) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { handleFileClick(file, viewModel); }
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // File icon placeholder
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(MaterialTheme.colorScheme.surfaceVariant),
                contentAlignment = Alignment.Center
            ) {
                Text(file.getDisplayName().substring(0, 1).toUpperCase(),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface);
            };
            Spacer(modifier = Modifier.width(12.dp));
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = file.getDisplayName(),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                );
                Text(
                    text = file.getFormattedSize(0) + " · " + file.getFormattedDate(0),
                    fontSize = 12.sp,
                    color = Color.Gray,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                );
            };
        };
    }

    @Composable
    private static void ErrorContent(@NonNull FileExplorerViewModel viewModel,
                                    @NonNull FileBrowserUiState uiState) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Error Loading Directory",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                );
                Spacer(modifier = Modifier.height(8.dp));
                Text(
                    text = uiState.getError() != null ? uiState.getError().getMessage() : "Unknown error",
                    fontSize = 12.sp,
                    color = Color.Gray
                );
            };
        };
    }

    @Composable
    private static void EmptyStateContent() {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "No Files",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                );
                Spacer(modifier = Modifier.height(8.dp));
                Text(
                    text = "This directory is empty",
                    fontSize = 12.sp,
                    color = Color.Gray
                );
            };
        };
    }

    private static void handleFileClick(@NonNull FileInfo file,
                                       @NonNull FileExplorerViewModel viewModel) {
        if (file.isDirectory()) {
            viewModel.navigateToDirectory(file.getPath());
        }
    }
}
