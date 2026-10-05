package com.alphainventor.filemanager.contract;

import androidx.annotation.Nullable;

/**
 * Extended file attributes specific to a file system.
 * 
 * Different file systems expose different attributes:
 * - Local: DOS attributes, extended attributes
 * - SMB: DOS attributes, creation time
 * - SFTP: Unix permissions, owner, group
 * - Archive: compression ratio, CRC
 */
public interface FileAttributes {
    /**
     * Get attribute value by name.
     *
     * @param name attribute name
     * @return attribute value, or null if not present
     */
    @Nullable
    Object getAttribute(String name);

    /**
     * Get all attribute names.
     *
     * @return array of attribute names
     */
    String[] getAttributeNames();

    /**
     * Check if attribute exists.
     */
    default boolean hasAttribute(String name) {
        return getAttribute(name) != null;
    }

    /**
     * Get attribute as string.
     */
    @Nullable
    default String getAsString(String name) {
        Object value = getAttribute(name);
        return value != null ? value.toString() : null;
    }

    /**
     * Get attribute as integer.
     */
    default int getAsInt(String name, int defaultValue) {
        Object value = getAttribute(name);
        if (value instanceof Integer) {
            return (Integer) value;
        } else if (value instanceof Number) {
            return ((Number) value).intValue();
        } else if (value instanceof String) {
            try {
                return Integer.parseInt((String) value);
            } catch (NumberFormatException e) {
                return defaultValue;
            }
        }
        return defaultValue;
    }

    /**
     * Get attribute as long.
     */
    default long getAsLong(String name, long defaultValue) {
        Object value = getAttribute(name);
        if (value instanceof Long) {
            return (Long) value;
        } else if (value instanceof Number) {
            return ((Number) value).longValue();
        } else if (value instanceof String) {
            try {
                return Long.parseLong((String) value);
            } catch (NumberFormatException e) {
                return defaultValue;
            }
        }
        return defaultValue;
    }

    /**
     * Get attribute as boolean.
     */
    default boolean getAsBoolean(String name, boolean defaultValue) {
        Object value = getAttribute(name);
        if (value instanceof Boolean) {
            return (Boolean) value;
        } else if (value instanceof String) {
            String str = (String) value;
            return str.equalsIgnoreCase("true") || str.equals("1");
        }
        return defaultValue;
    }
}
