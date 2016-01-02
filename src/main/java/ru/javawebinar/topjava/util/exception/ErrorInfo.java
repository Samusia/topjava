package ru.javawebinar.topjava.util.exception;

/**
 * Created by Samusia
 * on 02.01.2016.
 */
public class ErrorInfo {
    public final String url;
    public final String cause;
    public final String detail;

    public ErrorInfo(CharSequence url, Throwable ex) {
        this.url = url.toString();
        this.cause = ex.getClass().getSimpleName();
        this.detail = ex.getLocalizedMessage();
    }
}
