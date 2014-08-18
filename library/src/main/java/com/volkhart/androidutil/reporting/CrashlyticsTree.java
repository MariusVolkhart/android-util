package com.volkhart.androidutil.reporting;

import com.crashlytics.android.Crashlytics;

import timber.log.Timber;

/**
 * All messages are logged to Crashlytics.
 */
public class CrashlyticsTree extends Timber.HollowTree {

    @Override
    public void v(String message, Object... args) {
        Crashlytics.log(String.format(message, args));
    }

    @Override
    public void v(Throwable throwable, String message, Object... args) {
        v(message, args);
        Crashlytics.logException(throwable);
    }

    @Override
    public void d(String message, Object... args) {
        Crashlytics.log(String.format(message, args));
    }

    @Override
    public void d(Throwable throwable, String message, Object... args) {
        d(message, args);
        Crashlytics.logException(throwable);
    }

    @Override
    public void i(String message, Object... args) {
        Crashlytics.log(String.format(message, args));
    }

    @Override
    public void i(Throwable throwable, String message, Object... args) {
        i(message, args);
        Crashlytics.logException(throwable);
    }

    @Override
    public void w(String message, Object... args) {
        Crashlytics.log(String.format(message, args));
    }

    @Override
    public void w(Throwable throwable, String message, Object... args) {
        w(message, args);
        Crashlytics.logException(throwable);
    }

    @Override
    public void e(String message, Object... args) {
        Crashlytics.log(String.format(message, args));
    }

    @Override
    public void e(Throwable throwable, String message, Object... args) {
        e(message, args);
        Crashlytics.logException(throwable);
    }
}