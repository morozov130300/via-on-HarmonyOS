package m9;

import java.io.File;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class h implements c {

    /* renamed from: a, reason: collision with root package name */
    public final File f8693a;

    public h(File file) {
        this.f8693a = file;
    }

    @Override // m9.c
    public File a(String str) {
        return new File(this.f8693a, str);
    }

    @Override // m9.c
    public long b(String str) {
        File fileA = a(str);
        if (fileA == null || !fileA.exists()) {
            return 0L;
        }
        return fileA.lastModified();
    }

    @Override // m9.c
    public boolean c() {
        return false;
    }
}
