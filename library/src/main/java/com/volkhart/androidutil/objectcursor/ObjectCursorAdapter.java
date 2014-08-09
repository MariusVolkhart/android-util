package com.volkhart.androidutil.objectcursor;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;

public abstract class ObjectCursorAdapter<T> extends CursorAdapter {
    private final LayoutInflater inflater;

    /**
     * Sets the flags to 0
     */
    public ObjectCursorAdapter(Context context, ObjectCursor<T> cursor) {
        this(context, cursor, 0);
    }

    public ObjectCursorAdapter(Context context, ObjectCursor<T> cursor, int flags) {
        super(context, cursor, flags);
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public ObjectCursor<T> getCursor() {
        return (ObjectCursor<T>) super.getCursor();
    }

    @Override
    public T getItem(int position) {
        ObjectCursor<T> cursor = (ObjectCursor<T>) super.getItem(position);
        if (cursor != null) {
            return cursor.getModel();
        } else {
            return null;
        }
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return newView(getCursor().getModel(), inflater, parent);
    }

    /**
     * Create a new instance of a view for the specified position.
     */
    public abstract View newView(T item, LayoutInflater inflater, ViewGroup parent);

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        bindView(view, getCursor().getModel());
    }

    /**
     * Bind the data for the specified {@code position} to the view.
     */
    public abstract void bindView(View view, T item);
}
