package com.volkhart.androidutil.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

import com.volkhart.androidutil.R;

public class PasswordEditText extends EditText {

    private final OnTouchListener mOnTouchListener = new OnTouchListener() {

        private int mPreviousInputType;

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            final int action = event.getAction();
            switch (action) {
                case MotionEvent.ACTION_DOWN:
                    mPreviousInputType = getInputType();
                    setInputType(EditorInfo.TYPE_CLASS_TEXT | EditorInfo.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD, true);
                    break;

                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                    setInputType(mPreviousInputType, true);
                    mPreviousInputType = -1;
                    break;
            }

            return false;
        }
    };

    public PasswordEditText(Context context) {
        super(context);
        setUp();
    }

    public PasswordEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        setUp();
    }

    public PasswordEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setUp();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mOnTouchListener.onTouch(this, event);
        return super.onTouchEvent(event);
    }

    private void setUp() {
        setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_password_quick_show, 0);
    }

    private void setInputType(int inputType, boolean keepState) {
        int selectionStart = -1;
        int selectionEnd = -1;
        if (keepState) {
            selectionStart = getSelectionStart();
            selectionEnd = getSelectionEnd();
        }
        setInputType(inputType);
        if (keepState) {
            setSelection(selectionStart, selectionEnd);
        }
    }
}
