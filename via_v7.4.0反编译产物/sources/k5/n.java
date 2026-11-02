package k5;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Build;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructStatVfs;
import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class n implements c {

    /* renamed from: a, reason: collision with root package name */
    public final BufferedOutputStream f8133a;

    /* renamed from: b, reason: collision with root package name */
    public final AssetFileDescriptor f8134b;

    /* renamed from: c, reason: collision with root package name */
    public final FileDescriptor f8135c;

    public n(ContentResolver contentResolver, Uri uri) throws FileNotFoundException {
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "rw", null);
        this.f8134b = assetFileDescriptorOpenAssetFileDescriptor;
        if (assetFileDescriptorOpenAssetFileDescriptor == null) {
            throw new FileNotFoundException("Unable to create stream");
        }
        FileDescriptor fileDescriptor = assetFileDescriptorOpenAssetFileDescriptor.getFileDescriptor();
        this.f8135c = fileDescriptor;
        this.f8133a = new BufferedOutputStream(new FileOutputStream(fileDescriptor));
    }

    public static c e(ContentResolver contentResolver, Uri uri) {
        return new n(contentResolver, uri);
    }

    @Override // k5.c
    public void a(long j10) throws IOException, ErrnoException {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        try {
            try {
                if (d(this.f8135c) < j10 - Os.fstat(this.f8135c).st_size) {
                    throw new IOException("write failed: ENOSPC(No space left on device)");
                }
                Os.posix_fallocate(this.f8135c, 0L, j10);
            } catch (Exception unused) {
                Os.ftruncate(this.f8135c, j10);
            }
        } catch (Exception e10) {
            throw new IOException(e10);
        }
    }

    @Override // k5.c
    public void b() throws IOException {
        this.f8133a.flush();
        this.f8135c.sync();
    }

    @Override // k5.c
    public void c(long j10) throws IOException, ErrnoException {
        if (Build.VERSION.SDK_INT < 21) {
            throw new UnsupportedOperationException();
        }
        try {
            Os.lseek(this.f8135c, j10, OsConstants.SEEK_SET);
        } catch (Exception e10) {
            throw new IOException(e10);
        }
    }

    @Override // k5.c
    public void close() throws IOException {
        this.f8133a.close();
        this.f8134b.close();
    }

    public final long d(FileDescriptor fileDescriptor) throws IOException, ErrnoException {
        try {
            StructStatVfs structStatVfsFstatvfs = Os.fstatvfs(fileDescriptor);
            return structStatVfsFstatvfs.f_bavail * structStatVfsFstatvfs.f_bsize;
        } catch (Exception e10) {
            throw new IOException(e10);
        }
    }

    @Override // k5.c
    public long getLength() {
        return this.f8134b.getLength();
    }

    @Override // k5.c
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        this.f8133a.write(bArr, i10, i11);
    }
}
