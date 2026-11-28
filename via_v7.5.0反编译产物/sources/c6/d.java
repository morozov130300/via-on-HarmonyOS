package c6;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class d implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Writer f1971b;

    public d(String filePath) {
        kotlin.jvm.internal.h.f(filePath, "filePath");
        this.f1970a = filePath;
    }

    @Override // c6.d0
    public c0 a(String str) {
        if (str == null || str.length() == 0) {
            return c0.f1965c.a();
        }
        if (this.f1971b == null) {
            this.f1971b = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(this.f1970a), true)));
        }
        try {
            Writer writer = this.f1971b;
            if (writer != null) {
                writer.write(str);
            }
            return c0.f1965c.a();
        } catch (IOException e10) {
            return new c0(1001, "File write error: " + e10.getMessage());
        }
    }

    @Override // c6.d0
    public c0 b(String str) {
        close();
        this.f1971b = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(this.f1970a), false)));
        return a(str);
    }

    @Override // c6.d0
    public void close() {
        Writer writer = this.f1971b;
        if (writer == null) {
            return;
        }
        if (writer != null) {
            try {
                writer.flush();
            } catch (IOException unused) {
            }
        }
        try {
            Writer writer2 = this.f1971b;
            if (writer2 != null) {
                writer2.close();
            }
            this.f1971b = null;
        } catch (IOException unused2) {
        }
    }
}
