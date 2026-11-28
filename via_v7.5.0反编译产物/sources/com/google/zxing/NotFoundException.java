package com.google.zxing;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class NotFoundException extends ReaderException {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final NotFoundException f3407c;

    static {
        NotFoundException notFoundException = new NotFoundException();
        f3407c = notFoundException;
        notFoundException.setStackTrace(ReaderException.NO_TRACE);
    }

    private NotFoundException() {
    }

    public static NotFoundException getNotFoundInstance() {
        return ReaderException.isStackTrace ? new NotFoundException() : f3407c;
    }
}
