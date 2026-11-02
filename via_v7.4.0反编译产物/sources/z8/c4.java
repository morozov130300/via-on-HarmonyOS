package z8;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class c4 implements Closeable {

    /* renamed from: e, reason: collision with root package name */
    public final InputStream f14683e;

    public c4(InputStream inputStream) {
        this.f14683e = inputStream;
    }

    public void a(File file) throws Throwable {
        b(this.f14683e, file);
    }

    public final void b(InputStream inputStream, File file) throws Throwable {
        ZipInputStream zipInputStream;
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            zipInputStream = new ZipInputStream(inputStream);
            try {
                bufferedInputStream = new BufferedInputStream(zipInputStream);
            } catch (Throwable th) {
                th = th;
            }
            try {
                String absolutePath = file.getAbsolutePath();
                while (true) {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry == null) {
                        g6.j.a(bufferedInputStream);
                        g6.j.a(zipInputStream);
                        return;
                    }
                    File file2 = new File(file, nextEntry.getName());
                    if (file2.getCanonicalPath().startsWith(absolutePath)) {
                        if (nextEntry.isDirectory()) {
                            file2.mkdirs();
                        } else {
                            if (file2.getParentFile() != null) {
                                file2.getParentFile().mkdirs();
                            }
                            file2.createNewFile();
                            FileOutputStream fileOutputStream = new FileOutputStream(file2);
                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                            byte[] bArr = new byte[4096];
                            while (true) {
                                int i10 = bufferedInputStream.read(bArr);
                                if (i10 == -1) {
                                    break;
                                } else {
                                    bufferedOutputStream.write(bArr, 0, i10);
                                }
                            }
                            bufferedOutputStream.flush();
                            bufferedOutputStream.close();
                            fileOutputStream.close();
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream2 = bufferedInputStream;
                g6.j.a(bufferedInputStream2);
                g6.j.a(zipInputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            zipInputStream = null;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f14683e.close();
    }
}
