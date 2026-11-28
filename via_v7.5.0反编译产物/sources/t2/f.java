package t2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class f implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f12341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12342b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f12343c;

    public f(String str, String str2, byte[] bArr) {
        this.f12342b = str;
        this.f12343c = str2;
        this.f12341a = bArr;
    }

    @Override // t2.y
    public String a() {
        return this.f12343c;
    }

    @Override // t2.y
    public InputStream b() {
        if (e()) {
            return null;
        }
        return new ByteArrayInputStream(this.f12341a);
    }

    @Override // t2.y
    public v2.b0.d.b c() {
        byte[] bArrD = d();
        if (bArrD == null) {
            return null;
        }
        return v2.b0.d.b.a().b(bArrD).c(this.f12342b).a();
    }

    public final byte[] d() {
        if (e()) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream.write(this.f12341a);
                    gZIPOutputStream.finish();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    gZIPOutputStream.close();
                    byteArrayOutputStream.close();
                    return byteArray;
                } catch (Throwable th) {
                    try {
                        gZIPOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        } catch (IOException unused) {
            return null;
        }
    }

    public final boolean e() {
        byte[] bArr = this.f12341a;
        return bArr == null || bArr.length == 0;
    }
}
