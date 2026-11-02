package i6;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class c implements k {

    /* renamed from: a, reason: collision with root package name */
    public final String f6983a;

    /* renamed from: b, reason: collision with root package name */
    public Writer f6984b;

    public c(String filePath) {
        kotlin.jvm.internal.h.f(filePath, "filePath");
        this.f6983a = filePath;
    }

    @Override // i6.k
    public j a(String str) throws IOException {
        if (str == null || str.length() == 0) {
            return j.f7007c.a();
        }
        if (this.f6984b == null) {
            this.f6984b = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(this.f6983a), true)));
        }
        try {
            Writer writer = this.f6984b;
            if (writer != null) {
                writer.write(str);
            }
            return j.f7007c.a();
        } catch (IOException e10) {
            return new j(1001, "File write error: " + e10.getMessage());
        }
    }

    @Override // i6.k
    public j b(String str) throws IOException {
        close();
        this.f6984b = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(this.f6983a), false)));
        return a(str);
    }

    @Override // i6.k
    public void close() throws IOException {
        Writer writer = this.f6984b;
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
            Writer writer2 = this.f6984b;
            if (writer2 != null) {
                writer2.close();
            }
            this.f6984b = null;
        } catch (IOException unused2) {
        }
    }
}
