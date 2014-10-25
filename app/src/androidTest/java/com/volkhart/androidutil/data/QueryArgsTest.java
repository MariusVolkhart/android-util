package com.volkhart.androidutil.data;

import android.net.Uri;

import junit.framework.TestCase;

import static org.assertj.core.api.Assertions.assertThat;

public class QueryArgsTest extends TestCase {

    Uri.Builder base;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        base = new Uri.Builder()
                .scheme("http")
                .authority("example.com");
    }

    public void testEmptyParams() {
        Uri uri = base.build();
        QueryArgs args = new QueryArgs(uri);
        assertThat(args.selection).isNull();
        assertThat(args.selectionArgs).isNull();
    }

    public void testOneParam() {
        String key = "key";
        String value = "value";
        Uri uri = base
                .appendQueryParameter(key, value)
                .build();

        QueryArgs args = new QueryArgs(uri);
        assertThat(args.selection).isEqualTo("key=?");
        assertThat(args.selectionArgs).containsExactly(value);
    }

    public void testTwoParams() {
        String key1 = "key1";
        String key2 = "key2";
        String value1 = "value1";
        String value2 = "value2";
        Uri uri = base
                .appendQueryParameter(key1, value1)
                .appendQueryParameter(key2, value2)
                .build();

        QueryArgs args = new QueryArgs(uri);
        assertThat(args.selection).isEqualTo("key1=? and key2=?");
        assertThat(args.selectionArgs).containsExactly(value1, value2);
    }

    public void testBooleanConversion() {
        String trueKey = "key1";
        String falseKey = "key2";
        Uri uri = base
                .appendQueryParameter(trueKey, "true")
                .appendQueryParameter(falseKey, "false")
                .build();

        QueryArgs args = new QueryArgs(uri);
        assertThat(args.selectionArgs).containsExactly("1", "0");
    }
}
