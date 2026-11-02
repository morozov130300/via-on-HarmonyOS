package s2;

import java.io.File;
import java.io.IOException;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    public final String f11753a;

    /* renamed from: b, reason: collision with root package name */
    public final x2.g f11754b;

    public n(String str, x2.g gVar) {
        this.f11753a = str;
        this.f11754b = gVar;
    }

    public boolean a() {
        try {
            return b().createNewFile();
        } catch (IOException e10) {
            p2.f.f().e("Error creating marker: " + this.f11753a, e10);
            return false;
        }
    }

    public final File b() {
        return this.f11754b.e(this.f11753a);
    }

    public boolean c() {
        return b().exists();
    }

    public boolean d() {
        return b().delete();
    }
}
