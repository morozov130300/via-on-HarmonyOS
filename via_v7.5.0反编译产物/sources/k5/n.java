package k5;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Build;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructStatVfs;
import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class n implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BufferedOutputStream f7210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AssetFileDescriptor f7211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FileDescriptor f7212c;

    public n(ContentResolver contentResolver, Uri uri) throws FileNotFoundException {
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "rw", null);
        this.f7211b = assetFileDescriptorOpenAssetFileDescriptor;
        if (assetFileDescriptorOpenAssetFileDescriptor == null) {
            throw new FileNotFoundException("Unable to create stream");
        }
        FileDescriptor fileDescriptor = assetFileDescriptorOpenAssetFileDescriptor.getFileDescriptor();
        this.f7212c = fileDescriptor;
        this.f7210a = new BufferedOutputStream(new FileOutputStream(fileDescriptor));
    }

    public static c e(ContentResolver contentResolver, Uri uri) {
        return new n(contentResolver, uri);
    }

    @Override // k5.c
    public void a(long j10) throws IOException {
        if (j10 < 0) {
            throw new IOException("Negative file length");
        }
        long length = getLength();
        if (length == j10) {
            return;
        }
        if (j10 > length) {
            try {
                if (d(this.f7212c) < j10 - length) {
                    throw new IOException("write failed: ENOSPC(No space left on device)");
                }
                Os.posix_fallocate(this.f7212c, 0L, j10);
                return;
            } catch (Exception unused) {
            }
        }
        try {
            Os.ftruncate(this.f7212c, j10);
        } catch (Exception e10) {
            throw new IOException(e10);
        }
    }

    @Override // k5.c
    public void b() throws IOException {
        this.f7210a.flush();
        this.f7212c.sync();
    }

    @Override // k5.c
    public void c(long j10) throws IOException {
        if (Build.VERSION.SDK_INT < 21) {
            throw new UnsupportedOperationException();
        }
        try {
            Os.lseek(this.f7212c, j10, OsConstants.SEEK_SET);
        } catch (Exception e10) {
            throw new IOException(e10);
        }
    }

    @Override // k5.c
    public void close() throws IOException {
        try {
            this.f7210a.close();
        } finally {
            this.f7211b.close();
        }
    }

    public final long d(FileDescriptor fileDescriptor) throws IOException {
        try {
            StructStatVfs structStatVfsFstatvfs = Os.fstatvfs(fileDescriptor);
            return structStatVfsFstatvfs.f_bavail * structStatVfsFstatvfs.f_bsize;
        } catch (Exception e10) {
            throw new IOException(e10);
        }
    }

    @Override // k5.c
    public long getLength() throws IOException {
        try {
            return Os.fstat(this.f7212c).st_size;
        } catch (Exception e10) {
            throw new IOException(e10);
        }
    }

    @Override // k5.c
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        this.f7210a.write(bArr, i10, i11);
    }
}
