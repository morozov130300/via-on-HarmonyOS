package d8;

import java.util.HashMap;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    public static d f4594b;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f4595a = new HashMap();

    public static d c() {
        if (f4594b == null) {
            f4594b = new d();
        }
        return f4594b;
    }

    public boolean a(int i10, int i11, String str, boolean z10, boolean z11) {
        e(i10).a(i11, str, z10, z11);
        return !r1.e();
    }

    public void b(int i10) {
        e(i10).b();
    }

    public List d(int i10) {
        return e(i10).c();
    }

    public final c e(int i10) {
        c cVar = (c) this.f4595a.get(Integer.valueOf(i10));
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c();
        this.f4595a.put(Integer.valueOf(i10), cVar2);
        return cVar2;
    }

    public boolean f(int i10) {
        return !e(i10).d();
    }

    public boolean g(int i10) {
        return !e(i10).e();
    }

    public void h(int i10, int i11) {
        e(i10).f(i11);
    }

    public void i(int i10, int i11, String str) {
        c cVarE = e(i10);
        cVarE.b();
        cVarE.h(i11);
        cVarE.g(r9.g.a().a(str));
    }
}
