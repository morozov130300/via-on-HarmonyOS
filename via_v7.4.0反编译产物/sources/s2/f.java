package s2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;
import u2.b0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class f implements y {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f11673a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11674b;

    /* renamed from: c, reason: collision with root package name */
    public final String f11675c;

    public f(String str, String str2, byte[] bArr) {
        this.f11674b = str;
        this.f11675c = str2;
        this.f11673a = bArr;
    }

    @Override // s2.y
    public String a() {
        return this.f11675c;
    }

    @Override // s2.y
    public InputStream b() {
        if (e()) {
            return null;
        }
        return new ByteArrayInputStream(this.f11673a);
    }

    @Override // s2.y
    public b0.d.b c() throws IOException {
        byte[] bArrD = d();
        if (bArrD == null) {
            return null;
        }
        return b0.d.b.a().b(bArrD).c(this.f11674b).a();
    }

    public final byte[] d() throws IOException {
        if (e()) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream.write(this.f11673a);
                    gZIPOutputStream.finish();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    gZIPOutputStream.close();
                    byteArrayOutputStream.close();
                    return byteArray;
                } finally {
                }
            } finally {
            }
        } catch (IOException unused) {
            return null;
        }
    }

    public final boolean e() {
        byte[] bArr = this.f11673a;
        return bArr == null || bArr.length == 0;
    }
}
