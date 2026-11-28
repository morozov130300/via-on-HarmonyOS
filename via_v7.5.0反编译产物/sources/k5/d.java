package k5;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BufferedOutputStream f7207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FileDescriptor f7208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RandomAccessFile f7209c;

    public d(File file) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        this.f7209c = randomAccessFile;
        this.f7208b = randomAccessFile.getFD();
        this.f7207a = new BufferedOutputStream(new FileOutputStream(randomAccessFile.getFD()));
    }

    public static c d(File file) {
        return new d(file);
    }

    @Override // k5.c
    public void a(long j10) throws IOException {
        this.f7209c.setLength(j10);
    }

    @Override // k5.c
    public void b() throws IOException {
        this.f7207a.flush();
        this.f7208b.sync();
    }

    @Override // k5.c
    public void c(long j10) throws IOException {
        this.f7209c.seek(j10);
    }

    @Override // k5.c
    public void close() throws IOException {
        try {
            this.f7207a.close();
        } finally {
            this.f7209c.close();
        }
    }

    @Override // k5.c
    public long getLength() {
        return this.f7209c.length();
    }

    @Override // k5.c
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        this.f7207a.write(bArr, i10, i11);
    }
}
