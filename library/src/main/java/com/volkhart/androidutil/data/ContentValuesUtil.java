package com.volkhart.androidutil.data;

import android.content.ContentValues;

public final class ContentValuesUtil {
    private ContentValuesUtil() {
    }

    public static ContentValues of(String key, String value) {
        ContentValues values = new ContentValues(1);
        values.put(key, value);
        return values;
    }

    public static ContentValues of(String key, Byte value) {
        ContentValues values = new ContentValues(1);
        values.put(key, value);
        return values;
    }

    public static ContentValues of(String key, Short value) {
        ContentValues values = new ContentValues(1);
        values.put(key, value);
        return values;
    }

    public static ContentValues of(String key, Integer value) {
        ContentValues values = new ContentValues(1);
        values.put(key, value);
        return values;
    }

    public static ContentValues of(String key, Long value) {
        ContentValues values = new ContentValues(1);
        values.put(key, value);
        return values;
    }

    public static ContentValues of(String key, Float value) {
        ContentValues values = new ContentValues(1);
        values.put(key, value);
        return values;
    }

    public static ContentValues of(String key, Double value) {
        ContentValues values = new ContentValues(1);
        values.put(key, value);
        return values;
    }

    public static ContentValues of(String key, byte[] value) {
        ContentValues values = new ContentValues(1);
        values.put(key, value);
        return values;
    }

    public static ContentValues of(String key, Boolean value) {
        ContentValues values = new ContentValues(1);
        values.put(key, value);
        return values;
    }
}
