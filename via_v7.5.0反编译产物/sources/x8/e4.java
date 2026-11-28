package x8;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class e4 implements Closeable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OutputStream f14564c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ZipOutputStream f14565e = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public BufferedOutputStream f14566m = null;

    public e4(OutputStream outputStream) {
        this.f14564c = outputStream;
    }

    public void a(File file, String str) throws Throwable {
        b();
        if (!file.exists()) {
            throw new FileNotFoundException(file.getAbsolutePath() + " does not exist");
        }
        if (str == null || str.isEmpty()) {
            str = file.getName();
        } else if (str.charAt(str.length() - 1) == '/') {
            str = str.substring(0, str.length() - 1);
        }
        e(this.f14565e, file, str, this.f14566m);
    }

    public final void b() {
        if (this.f14565e == null) {
            throw new IllegalStateException("zipStream is not initaliezed");
        }
    }

    public void c() {
        this.f14565e = new ZipOutputStream(this.f14564c);
        this.f14566m = new BufferedOutputStream(this.f14565e);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        BufferedOutputStream bufferedOutputStream = this.f14566m;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.close();
        }
        ZipOutputStream zipOutputStream = this.f14565e;
        if (zipOutputStream != null) {
            zipOutputStream.close();
        }
        OutputStream outputStream = this.f14564c;
        if (outputStream != null) {
            outputStream.close();
        }
    }

    public final void e(ZipOutputStream zipOutputStream, File file, String str, BufferedOutputStream bufferedOutputStream) throws Throwable {
        FileInputStream fileInputStream;
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                return;
            }
            if (fileArrListFiles.length == 0) {
                zipOutputStream.putNextEntry(new ZipEntry(str + "/"));
                zipOutputStream.closeEntry();
                return;
            }
            for (File file2 : fileArrListFiles) {
                e(zipOutputStream, file2, str + "/" + file2.getName(), bufferedOutputStream);
            }
            return;
        }
        BufferedInputStream bufferedInputStream = null;
        try {
            zipOutputStream.putNextEntry(new ZipEntry(str));
            fileInputStream = new FileInputStream(file);
            try {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(fileInputStream);
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int i10 = bufferedInputStream2.read(bArr);
                        if (i10 == -1) {
                            bufferedOutputStream.flush();
                            zipOutputStream.closeEntry();
                            com.tuyafeng.support.utils.j.a(bufferedInputStream2);
                            com.tuyafeng.support.utils.j.a(fileInputStream);
                            return;
                        }
                        bufferedOutputStream.write(bArr, 0, i10);
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream = bufferedInputStream2;
                    com.tuyafeng.support.utils.j.a(bufferedInputStream);
                    com.tuyafeng.support.utils.j.a(fileInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }
}
