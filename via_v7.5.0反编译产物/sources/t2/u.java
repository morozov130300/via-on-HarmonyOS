package t2;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class u implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f12463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12464b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f12465c;

    public u(String str, String str2, File file) {
        this.f12464b = str;
        this.f12465c = str2;
        this.f12463a = file;
    }

    /* JADX WARN: Code duplicated, block: B:51:0x0057 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private byte[] d() {
        byte[] bArr = new byte[8192];
        try {
            InputStream inputStreamB = b();
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    if (inputStreamB == null) {
                        gZIPOutputStream.close();
                        byteArrayOutputStream.close();
                        if (inputStreamB != null) {
                            inputStreamB.close();
                        }
                        return null;
                    }
                    while (true) {
                        try {
                            int i10 = inputStreamB.read(bArr);
                            if (i10 <= 0) {
                                gZIPOutputStream.finish();
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                gZIPOutputStream.close();
                                byteArrayOutputStream.close();
                                inputStreamB.close();
                                return byteArray;
                            }
                            gZIPOutputStream.write(bArr, 0, i10);
                        } catch (Throwable th) {
                            try {
                                gZIPOutputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    byteArrayOutputStream.close();
                    throw th4;
                }
            } catch (Throwable th5) {
                if (inputStreamB != null) {
                    try {
                        inputStreamB.close();
                    } catch (Throwable th6) {
                        th5.addSuppressed(th6);
                    }
                }
                throw th5;
            }
            if (inputStreamB != null) {
                inputStreamB.close();
            }
            throw th5;
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // t2.y
    public String a() {
        return this.f12465c;
    }

    @Override // t2.y
    public InputStream b() {
        if (this.f12463a.exists() && this.f12463a.isFile()) {
            try {
                return new FileInputStream(this.f12463a);
            } catch (FileNotFoundException unused) {
            }
        }
        return null;
    }

    @Override // t2.y
    public v2.b0.d.b c() {
        byte[] bArrD = d();
        if (bArrD != null) {
            return v2.b0.d.b.a().b(bArrD).c(this.f12464b).a();
        }
        return null;
    }
}
