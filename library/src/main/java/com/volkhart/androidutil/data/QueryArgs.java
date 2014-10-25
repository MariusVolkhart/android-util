package com.volkhart.androidutil.data;

import android.net.Uri;

import java.util.Set;

public final class QueryArgs {
    public final String selection;
    public final String[] selectionArgs;

    /**
     * Extracts the query arguments from the specified Uri
     */
    public QueryArgs(Uri uri) {
        StringBuilder builder = new StringBuilder();
        Set<String> parameterNames = uri.getQueryParameterNames();
        if (parameterNames.size() == 0) {
            selection = null;
            selectionArgs = null;
            return;
        }
        selectionArgs = new String[parameterNames.size()];
        int i = 0;
        for (String queryArg : parameterNames) {
            String selectionArg = uri.getQueryParameter(queryArg);
            if ("true".equalsIgnoreCase(selectionArg)) {
                selectionArgs[i] = "1";     // SQLite doesn't have boolean
            } else if ("false".equalsIgnoreCase(selectionArg)) {
                selectionArgs[i] = "0";     // SQLite doesn't have boolean
            } else {
                selectionArgs[i] = selectionArg;
            }
            builder.append(queryArg);
            builder.append("=?");

            // If not yet at the last parameter..
            if (parameterNames.size() > i + 1) {
                builder.append(" and ");
            }
            i++;
        }
        selection = builder.toString();
    }
}
