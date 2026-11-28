package z9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import x8.h;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final aa.c f15530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f15531b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map f15532c = null;

    public b(aa.c cVar) {
        this.f15530a = cVar;
        h.b(new Runnable() { // from class: z9.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f15529c.m();
            }
        });
    }

    @Override // z9.d
    public boolean a(Map map) {
        this.f15530a.a(map);
        m();
        return map.size() > 0;
    }

    @Override // z9.d
    public void b(String str) {
        if (this.f15531b.remove(str) != null) {
            this.f15530a.b(str);
        }
    }

    @Override // z9.d
    public boolean c(String str, String str2) {
        y9.b bVar;
        if (str == null || str.isEmpty() || str2 == null || str2.isEmpty() || str.equals(str2) || this.f15531b.containsKey(str2) || (bVar = (y9.b) this.f15531b.get(str)) == null || !this.f15530a.c(str, str2)) {
            return false;
        }
        this.f15531b.remove(str);
        this.f15531b.put(str2, bVar);
        return true;
    }

    @Override // z9.d
    public y9.b d(String str, boolean z10) {
        Map map;
        y9.d dVar;
        if (str == null || str.isEmpty()) {
            return null;
        }
        y9.b bVar = (y9.b) this.f15531b.get(str);
        if (!z10 && (map = this.f15532c) != null && (dVar = (y9.d) map.get(str)) != null) {
            if (dVar.c() || dVar.b() == null) {
                j(str);
            } else {
                int iA = dVar.a();
                if (iA == 0) {
                    return dVar.b();
                }
                if (iA == 1) {
                    return y9.c.a(bVar, dVar.b());
                }
            }
        }
        return bVar;
    }

    @Override // z9.d
    public y9.b e(String str) {
        return d(str, false);
    }

    @Override // z9.d
    public Map f() {
        m();
        return this.f15531b;
    }

    @Override // z9.d
    public void g(String str, y9.d dVar) {
        if (str == null || str.isEmpty() || dVar == null || dVar.b() == null || dVar.c()) {
            return;
        }
        if (this.f15532c == null) {
            this.f15532c = new HashMap();
        }
        this.f15532c.put(str, dVar);
    }

    @Override // z9.d
    public y9.a h(String str) {
        y9.b bVarD = d(str, false);
        return bVarD == null ? new y9.a() : y9.c.c(bVarD);
    }

    @Override // z9.d
    public List i() {
        ArrayList arrayList = new ArrayList(this.f15531b.keySet());
        Collections.sort(arrayList);
        return arrayList;
    }

    @Override // z9.d
    public void j(String str) {
        if (this.f15532c == null || str == null || str.isEmpty()) {
            return;
        }
        this.f15532c.remove(str);
        if (this.f15532c.isEmpty()) {
            this.f15532c = null;
        }
    }

    @Override // z9.d
    public void k(String str, y9.b bVar) {
        if (str == null || str.isEmpty() || bVar == null || bVar.r()) {
            return;
        }
        this.f15531b.put(str, bVar);
        this.f15530a.e(str, bVar);
    }

    public final void m() {
        this.f15531b.clear();
        this.f15531b.putAll(this.f15530a.d());
    }
}
