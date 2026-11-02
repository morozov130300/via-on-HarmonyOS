package k5;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class d implements c {

    /* renamed from: a, reason: collision with root package name */
    public final BufferedOutputStream f8130a;

    /* renamed from: b, reason: collision with root package name */
    public final FileDescriptor f8131b;

    /* renamed from: c, reason: collision with root package name */
    public final RandomAccessFile f8132c;

    public d(File file) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        this.f8132c = randomAccessFile;
        this.f8131b = randomAccessFile.getFD();
        this.f8130a = new BufferedOutputStream(new FileOutputStream(randomAccessFile.getFD()));
    }

    public static c d(File file) {
        return new d(file);
    }

    @Override // k5.c
    public void a(long j10) throws IOException {
        this.f8132c.setLength(j10);
    }

    @Override // k5.c
    public void b() throws IOException {
        this.f8130a.flush();
        this.f8131b.sync();
    }

    @Override // k5.c
    public void c(long j10) throws IOException {
        this.f8132c.seek(j10);
    }

    @Override // k5.c
    public void close() throws IOException {
        this.f8130a.close();
        this.f8132c.close();
    }

    @Override // k5.c
    public long getLength() {
        return this.f8132c.length();
    }

    @Override // k5.c
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        this.f8130a.write(bArr, i10, i11);
    }
}
