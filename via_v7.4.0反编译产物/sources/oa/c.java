package oa;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class c implements e {

    /* renamed from: a, reason: collision with root package name */
    public final e f10495a;

    /* renamed from: b, reason: collision with root package name */
    public List f10496b = null;

    public c(e eVar) {
        this.f10495a = eVar;
    }

    @Override // oa.e
    public b a(String str) {
        return this.f10495a.a(str);
    }

    @Override // oa.e
    public List b() {
        return this.f10495a.b();
    }

    @Override // oa.e
    public d c(String str, String str2, String str3) {
        if (str != null) {
            String strTrim = str.trim();
            if (!strTrim.isEmpty() && str3 != null && !str3.isEmpty()) {
                d dVarG = g(strTrim, str2, str3);
                if (dVarG != null) {
                    return dVarG;
                }
                d dVarC = this.f10495a.c(strTrim, str2, str3);
                if (dVarC == null) {
                    return null;
                }
                f(dVarC);
                return dVarC;
            }
        }
        return null;
    }

    @Override // oa.e
    public List d() {
        return this.f10495a.d();
    }

    @Override // oa.e
    public b e(String str) {
        return this.f10495a.e(str);
    }

    public final void f(d dVar) {
        if (this.f10496b == null) {
            this.f10496b = new ArrayList();
        }
        this.f10496b.add(dVar);
    }

    public final d g(String str, String str2, String str3) {
        List<d> list = this.f10496b;
        if (list == null) {
            return null;
        }
        for (d dVar : list) {
            if (str.equals(dVar.a()) && str3.equals(dVar.c())) {
                return dVar;
            }
        }
        return null;
    }
}
