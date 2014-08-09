package com.volkhart.androidutil.reporting;

import com.crashlytics.android.Crashlytics;

import timber.log.Timber;

/**
 * This Tree only logs INFO or higher messages. All messages are logged to Crashlytics.
 */
public class CrashlyticsTree extends Timber.HollowTree {

    @Override
    public void i(String message, Object... args) {
        Crashlytics.log(String.format(message, args));
    }

    @Override
    public void i(Throwable throwable, String message, Object... args) {
        Crashlytics.logException(throwable);
        i(message, args);
    }

    @Override
    public void w(String message, Object... args) {
        Crashlytics.log(String.format(message, args));
    }

    @Override
    public void w(Throwable throwable, String message, Object... args) {
        Crashlytics.logException(throwable);
        w(message, args);
    }

    @Override
    public void e(String message, Object... args) {
        Crashlytics.log(String.format(message, args));
    }

    @Override
    public void e(Throwable throwable, String message, Object... args) {
        Crashlytics.logException(throwable);
        e(message, args);
    }
}