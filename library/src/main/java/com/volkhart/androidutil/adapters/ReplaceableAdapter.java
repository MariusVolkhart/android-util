package com.volkhart.androidutil.adapters;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.List;

public abstract class ReplaceableAdapter<T> extends BindableAdapter<T> {
    public ReplaceableAdapter(Context context) {
        super(context);
    }

    /**
     * @param items may be modified by this class in the future.
     */
    public abstract void replaceWith(@NonNull List<T> items);

    public abstract void clear();
}
