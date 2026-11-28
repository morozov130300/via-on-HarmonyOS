package x8;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class d4 implements Closeable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InputStream f14556c;

    public d4(InputStream inputStream) {
        this.f14556c = inputStream;
    }

    public void a(File file) throws Throwable {
        b(this.f14556c, file);
    }

    public final void b(InputStream inputStream, File file) throws Throwable {
        ZipInputStream zipInputStream;
        BufferedInputStream bufferedInputStream = null;
        try {
            zipInputStream = new ZipInputStream(inputStream);
            try {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(zipInputStream);
                try {
                    String absolutePath = file.getAbsolutePath();
                    while (true) {
                        ZipEntry nextEntry = zipInputStream.getNextEntry();
                        if (nextEntry == null) {
                            com.tuyafeng.support.utils.j.a(bufferedInputStream2);
                            com.tuyafeng.support.utils.j.a(zipInputStream);
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
                                    int i10 = bufferedInputStream2.read(bArr);
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
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream = bufferedInputStream2;
                    com.tuyafeng.support.utils.j.a(bufferedInputStream);
                    com.tuyafeng.support.utils.j.a(zipInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            zipInputStream = null;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f14556c.close();
    }
}
