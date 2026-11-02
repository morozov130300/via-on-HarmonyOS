package com.google.zxing;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class NotFoundException extends ReaderException {

    /* renamed from: e, reason: collision with root package name */
    public static final NotFoundException f4110e;

    static {
        NotFoundException notFoundException = new NotFoundException();
        f4110e = notFoundException;
        notFoundException.setStackTrace(ReaderException.NO_TRACE);
    }

    private NotFoundException() {
    }

    public static NotFoundException getNotFoundInstance() {
        return ReaderException.isStackTrace ? new NotFoundException() : f4110e;
    }
}
