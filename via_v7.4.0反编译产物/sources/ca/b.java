package ca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import z8.h;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b implements d {

    /* renamed from: a, reason: collision with root package name */
    public final da.c f3058a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f3059b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public Map f3060c = null;

    public b(da.c cVar) {
        this.f3058a = cVar;
        h.b(new Runnable() { // from class: ca.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f3057e.m();
            }
        });
    }

    @Override // ca.d
    public boolean a(Map map) {
        this.f3058a.a(map);
        m();
        return map.size() > 0;
    }

    @Override // ca.d
    public void b(String str) {
        if (this.f3059b.remove(str) != null) {
            this.f3058a.b(str);
        }
    }

    @Override // ca.d
    public boolean c(String str, String str2) {
        ba.b bVar;
        if (str == null || str.isEmpty() || str2 == null || str2.isEmpty() || str.equals(str2) || this.f3059b.containsKey(str2) || (bVar = (ba.b) this.f3059b.get(str)) == null || !this.f3058a.c(str, str2)) {
            return false;
        }
        this.f3059b.remove(str);
        this.f3059b.put(str2, bVar);
        return true;
    }

    @Override // ca.d
    public ba.b d(String str, boolean z10) {
        Map map;
        ba.d dVar;
        if (str == null || str.isEmpty()) {
            return null;
        }
        ba.b bVar = (ba.b) this.f3059b.get(str);
        if (!z10 && (map = this.f3060c) != null && (dVar = (ba.d) map.get(str)) != null) {
            if (dVar.c() || dVar.b() == null) {
                k(str);
            } else {
                int iA = dVar.a();
                if (iA == 0) {
                    return dVar.b();
                }
                if (iA == 1) {
                    return ba.c.a(bVar, dVar.b());
                }
            }
        }
        return bVar;
    }

    @Override // ca.d
    public ba.b e(String str) {
        return d(str, false);
    }

    @Override // ca.d
    public void f(String str, ba.d dVar) {
        if (str == null || str.isEmpty() || dVar == null || dVar.b() == null || dVar.c()) {
            return;
        }
        if (this.f3060c == null) {
            this.f3060c = new HashMap();
        }
        this.f3060c.put(str, dVar);
    }

    @Override // ca.d
    public void g(String str, ba.b bVar) {
        if (str == null || str.isEmpty() || bVar == null || bVar.r()) {
            return;
        }
        this.f3059b.put(str, bVar);
        this.f3058a.e(str, bVar);
    }

    @Override // ca.d
    public Map h() {
        m();
        return this.f3059b;
    }

    @Override // ca.d
    public ba.a i(String str) {
        ba.b bVarD = d(str, false);
        return bVarD == null ? new ba.a() : ba.c.c(bVarD);
    }

    @Override // ca.d
    public List j() {
        ArrayList arrayList = new ArrayList(this.f3059b.keySet());
        Collections.sort(arrayList);
        return arrayList;
    }

    @Override // ca.d
    public void k(String str) {
        if (this.f3060c == null || str == null || str.isEmpty()) {
            return;
        }
        this.f3060c.remove(str);
        if (this.f3060c.isEmpty()) {
            this.f3060c = null;
        }
    }

    public final void m() {
        this.f3059b.clear();
        this.f3059b.putAll(this.f3058a.d());
    }
}
