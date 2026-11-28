package r8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f12058a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f12059b = null;

    @Override // r8.e
    public void a(String str, Map map) {
        if (this.f12058a.isEmpty()) {
            if (this.f12059b == null) {
                this.f12059b = new ArrayList();
            }
            this.f12059b.add(x.d.a(str, map));
        } else {
            e();
            Iterator it = this.f12058a.iterator();
            while (it.hasNext()) {
                ((d) it.next()).a(str, map);
            }
        }
    }

    @Override // r8.e
    public void b(String str, String str2, Throwable th) {
        if (this.f12058a.isEmpty()) {
            return;
        }
        Iterator it = this.f12058a.iterator();
        while (it.hasNext()) {
            ((d) it.next()).b(str, str2, th);
        }
    }

    @Override // r8.e
    public List c() {
        return Collections.unmodifiableList(this.f12058a);
    }

    @Override // r8.e
    public void d(d dVar) {
        if (dVar == null) {
            return;
        }
        this.f12058a.add(dVar);
    }

    public final void e() {
        if (this.f12059b == null || this.f12058a.isEmpty()) {
            return;
        }
        for (x.d dVar : this.f12059b) {
            Iterator it = this.f12058a.iterator();
            while (it.hasNext()) {
                ((d) it.next()).a((String) dVar.f14455a, (Map) dVar.f14456b);
            }
        }
        this.f12059b.clear();
        this.f12059b = null;
    }
}
