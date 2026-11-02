package com.google.zxing;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class FormatException extends ReaderException {

    /* renamed from: e, reason: collision with root package name */
    public static final FormatException f4109e;

    static {
        FormatException formatException = new FormatException();
        f4109e = formatException;
        formatException.setStackTrace(ReaderException.NO_TRACE);
    }

    private FormatException() {
    }

    public FormatException(Throwable th) {
        super(th);
    }

    public static FormatException getFormatInstance() {
        return ReaderException.isStackTrace ? new FormatException() : f4109e;
    }

    public static FormatException getFormatInstance(Throwable th) {
        return ReaderException.isStackTrace ? new FormatException(th) : f4109e;
    }
}
