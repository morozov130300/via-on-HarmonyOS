package s2;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;
import u2.b0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class u implements y {

    /* renamed from: a, reason: collision with root package name */
    public final File f11795a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11796b;

    /* renamed from: c, reason: collision with root package name */
    public final String f11797c;

    public u(String str, String str2, File file) {
        this.f11796b = str;
        this.f11797c = str2;
        this.f11795a = file;
    }

    private byte[] d() throws IOException {
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
                        } finally {
                        }
                    }
                } finally {
                }
            } finally {
            }
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // s2.y
    public String a() {
        return this.f11797c;
    }

    @Override // s2.y
    public InputStream b() {
        if (this.f11795a.exists() && this.f11795a.isFile()) {
            try {
                return new FileInputStream(this.f11795a);
            } catch (FileNotFoundException unused) {
            }
        }
        return null;
    }

    @Override // s2.y
    public b0.d.b c() throws IOException {
        byte[] bArrD = d();
        if (bArrD != null) {
            return b0.d.b.a().b(bArrD).c(this.f11796b).a();
        }
        return null;
    }
}
