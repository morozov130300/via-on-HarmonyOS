package t2;

import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y2.g f12422b;

    public n(String str, y2.g gVar) {
        this.f12421a = str;
        this.f12422b = gVar;
    }

    public boolean a() {
        try {
            return b().createNewFile();
        } catch (IOException e10) {
            q2.f.f().e("Error creating marker: " + this.f12421a, e10);
            return false;
        }
    }

    public final File b() {
        return this.f12422b.e(this.f12421a);
    }

    public boolean c() {
        return b().exists();
    }

    public boolean d() {
        return b().delete();
    }
}
