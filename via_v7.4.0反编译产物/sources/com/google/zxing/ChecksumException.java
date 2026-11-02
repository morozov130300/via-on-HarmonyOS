package com.google.zxing;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class ChecksumException extends ReaderException {

    /* renamed from: e, reason: collision with root package name */
    public static final ChecksumException f4106e;

    static {
        ChecksumException checksumException = new ChecksumException();
        f4106e = checksumException;
        checksumException.setStackTrace(ReaderException.NO_TRACE);
    }

    private ChecksumException() {
    }

    public ChecksumException(Throwable th) {
        super(th);
    }

    public static ChecksumException getChecksumInstance() {
        return ReaderException.isStackTrace ? new ChecksumException() : f4106e;
    }

    public static ChecksumException getChecksumInstance(Throwable th) {
        return ReaderException.isStackTrace ? new ChecksumException(th) : f4106e;
    }
}
