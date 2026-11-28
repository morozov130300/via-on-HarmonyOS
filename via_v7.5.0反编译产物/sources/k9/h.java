package k9;

import java.io.File;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class h implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f7234a;

    public h(File file) {
        this.f7234a = file;
    }

    @Override // k9.c
    public File a(String str) {
        if (str == null || !c6.i.f2031a.a(str)) {
            return null;
        }
        return new File(this.f7234a, str);
    }

    @Override // k9.c
    public long b(String str) {
        File fileA = a(str);
        if (fileA == null || !fileA.exists()) {
            return 0L;
        }
        return fileA.lastModified();
    }

    @Override // k9.c
    public boolean c() {
        return false;
    }
}
