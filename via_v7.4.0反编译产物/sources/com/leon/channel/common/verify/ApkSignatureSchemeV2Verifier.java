package com.leon.channel.common.verify;

import f4.b;
import g4.a;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class ApkSignatureSchemeV2Verifier {

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class SignatureNotFoundException extends Exception {
        private static final long serialVersionUID = 1;

        public SignatureNotFoundException(String str) {
            super(str);
        }

        public SignatureNotFoundException(String str, Throwable th) {
            super(str, th);
        }
    }

    public static void a(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    public static b b(RandomAccessFile randomAccessFile, long j10) throws SignatureNotFoundException, IOException {
        if (j10 < 32) {
            throw new SignatureNotFoundException("APK too small for APK Signing Block. ZIP Central Directory offset: " + j10);
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(24);
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        byteBufferAllocate.order(byteOrder);
        randomAccessFile.seek(j10 - byteBufferAllocate.capacity());
        randomAccessFile.readFully(byteBufferAllocate.array(), byteBufferAllocate.arrayOffset(), byteBufferAllocate.capacity());
        if (byteBufferAllocate.getLong(8) != 2334950737559900225L || byteBufferAllocate.getLong(16) != 3617552046287187010L) {
            throw new SignatureNotFoundException("No APK Signing Block before ZIP Central Directory");
        }
        long j11 = byteBufferAllocate.getLong(0);
        if (j11 < byteBufferAllocate.capacity() || j11 > 2147483639) {
            throw new SignatureNotFoundException("APK Signing Block size out of range: " + j11);
        }
        int i10 = (int) (8 + j11);
        long j12 = j10 - i10;
        if (j12 < 0) {
            throw new SignatureNotFoundException("APK Signing Block offset out of range: " + j12);
        }
        ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(i10);
        byteBufferAllocate2.order(byteOrder);
        randomAccessFile.seek(j12);
        randomAccessFile.readFully(byteBufferAllocate2.array(), byteBufferAllocate2.arrayOffset(), byteBufferAllocate2.capacity());
        long j13 = byteBufferAllocate2.getLong(0);
        if (j13 == j11) {
            return b.a(byteBufferAllocate2, Long.valueOf(j12));
        }
        throw new SignatureNotFoundException("APK Signing Block sizes in header and footer do not match: " + j13 + " vs " + j11);
    }

    public static ByteBuffer c(ByteBuffer byteBuffer, int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("size: " + i10);
        }
        int iLimit = byteBuffer.limit();
        int iPosition = byteBuffer.position();
        int i11 = i10 + iPosition;
        if (i11 < iPosition || i11 > iLimit) {
            throw new BufferUnderflowException();
        }
        byteBuffer.limit(i11);
        try {
            ByteBuffer byteBufferSlice = byteBuffer.slice();
            byteBufferSlice.order(byteBuffer.order());
            byteBuffer.position(i11);
            return byteBufferSlice;
        } finally {
            byteBuffer.limit(iLimit);
        }
    }

    public static long d(ByteBuffer byteBuffer, long j10) throws SignatureNotFoundException {
        long jG = a.g(byteBuffer);
        if (jG < j10) {
            if (a.h(byteBuffer) + jG == j10) {
                return jG;
            }
            throw new SignatureNotFoundException("ZIP Central Directory is not immediately followed by End of Central Directory");
        }
        throw new SignatureNotFoundException("ZIP Central Directory offset out of range: " + jG + ". ZIP End of Central Directory offset: " + j10);
    }

    public static b e(RandomAccessFile randomAccessFile) throws SignatureNotFoundException, IOException {
        b bVarC = a.c(randomAccessFile);
        if (bVarC != null) {
            return bVarC;
        }
        throw new SignatureNotFoundException("Not an APK file: ZIP End of Central Directory record not found");
    }

    public static ByteBuffer f(ByteBuffer byteBuffer, int i10, int i11) {
        if (i10 < 0) {
            throw new IllegalArgumentException("start: " + i10);
        }
        if (i11 < i10) {
            throw new IllegalArgumentException("end < start: " + i11 + " < " + i10);
        }
        int iCapacity = byteBuffer.capacity();
        if (i11 > byteBuffer.capacity()) {
            throw new IllegalArgumentException("end > capacity: " + i11 + " > " + iCapacity);
        }
        int iLimit = byteBuffer.limit();
        int iPosition = byteBuffer.position();
        try {
            byteBuffer.position(0);
            byteBuffer.limit(i11);
            byteBuffer.position(i10);
            ByteBuffer byteBufferSlice = byteBuffer.slice();
            byteBufferSlice.order(byteBuffer.order());
            return byteBufferSlice;
        } finally {
            byteBuffer.position(0);
            byteBuffer.limit(iLimit);
            byteBuffer.position(iPosition);
        }
    }
}
