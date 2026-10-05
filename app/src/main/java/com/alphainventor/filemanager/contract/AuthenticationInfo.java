package com.alphainventor.filemanager.contract;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Authentication state for a file system.
 */
public class AuthenticationInfo {
    private final String username;
    private final String hostname;
    private final int port;
    private final boolean authenticated;
    private final long authenticatedAt;
    private final Long expiresAt;

    public AuthenticationInfo(@NonNull String username,
                              @NonNull String hostname,
                              int port,
                              boolean authenticated,
                              @Nullable Long expiresAt) {
        this.username = username;
        this.hostname = hostname;
        this.port = port;
        this.authenticated = authenticated;
        this.authenticatedAt = System.currentTimeMillis();
        this.expiresAt = expiresAt;
    }

    @NonNull
    public String getUsername() {
        return username;
    }

    @NonNull
    public String getHostname() {
        return hostname;
    }

    public int getPort() {
        return port;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public long getAuthenticatedAt() {
        return authenticatedAt;
    }

    /**
     * Check if authentication has expired.
     */
    public boolean isExpired() {
        if (expiresAt == null) return false;
        return System.currentTimeMillis() > expiresAt;
    }

    @Nullable
    public Long getExpiresAt() {
        return expiresAt;
    }

    @Override
    @NonNull
    public String toString() {
        return "AuthenticationInfo{" +
                "username='" + username + '\'' +
                ", hostname='" + hostname + '\'' +
                ", port=" + port +
                ", authenticated=" + authenticated +
                ", expired=" + isExpired() +
                '}';
    }
}
