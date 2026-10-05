package com.alphainventor.filemanager.ui.navigation;

import androidx.annotation.NonNull;
import androidx.navigation.NavType;
import androidx.navigation.navArgument;

/**
 * Navigation destinations and route definitions for the file explorer.
 *
 * <p>This defines all possible navigation states and transitions in the app.</p>
 */
public class FileExplorerDestinations {

    private FileExplorerDestinations() {
        // No-op
    }

    /**
     * Home screen showing the file browser.
     */
    public static final class FileBrowser {
        public static final String ROUTE = "file_browser";
        public static final String ROUTE_WITH_PATH = "file_browser/{path}";

        @NonNull
        public static String routeWithPath(@NonNull String path) {
            return "file_browser/" + path.replace("/", "%2F");
        }
    }

    /**
     * File detail screen (preview, properties, actions).
     */
    public static final class FileDetail {
        public static final String ROUTE = "file_detail";
        public static final String ROUTE_WITH_PATH = "file_detail/{path}";
        public static final String PATH_ARGUMENT = "path";

        @NonNull
        public static String routeWithPath(@NonNull String path) {
            return "file_detail/" + path.replace("/", "%2F");
        }
    }

    /**
     * File operation progress screen (copy, delete, extract, etc.).
     */
    public static final class FileOperation {
        public static final String ROUTE = "file_operation";
        public static final String ROUTE_WITH_OPERATION_ID = "file_operation/{operationId}";
        public static final String OPERATION_ID_ARGUMENT = "operationId";

        @NonNull
        public static String routeWithOperationId(@NonNull String operationId) {
            return "file_operation/" + operationId;
        }
    }

    /**
     * Settings/preferences screen.
     */
    public static final class Settings {
        public static final String ROUTE = "settings";
    }

    /**
     * Search screen.
     */
    public static final class Search {
        public static final String ROUTE = "search";
        public static final String ROUTE_WITH_PATH = "search/{rootPath}";
        public static final String ROOT_PATH_ARGUMENT = "rootPath";

        @NonNull
        public static String routeWithPath(@NonNull String rootPath) {
            return "search/" + rootPath.replace("/", "%2F");
        }
    }
}
