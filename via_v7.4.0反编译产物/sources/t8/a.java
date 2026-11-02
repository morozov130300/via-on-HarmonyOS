package t8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a implements e {

    /* renamed from: a, reason: collision with root package name */
    public final List f12283a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public List f12284b = null;

    @Override // t8.e
    public void a(String str, Map map) {
        if (this.f12283a.isEmpty()) {
            if (this.f12284b == null) {
                this.f12284b = new ArrayList();
            }
            this.f12284b.add(w.d.a(str, map));
        } else {
            d();
            Iterator it = this.f12283a.iterator();
            while (it.hasNext()) {
                ((d) it.next()).a(str, map);
            }
        }
    }

    @Override // t8.e
    public List b() {
        return Collections.unmodifiableList(this.f12283a);
    }

    @Override // t8.e
    public void c(d dVar) {
        if (dVar == null) {
            return;
        }
        this.f12283a.add(dVar);
    }

    public final void d() {
        if (this.f12284b == null || this.f12283a.isEmpty()) {
            return;
        }
        for (w.d dVar : this.f12284b) {
            Iterator it = this.f12283a.iterator();
            while (it.hasNext()) {
                ((d) it.next()).a((String) dVar.f13207a, (Map) dVar.f13208b);
            }
        }
        this.f12284b.clear();
        this.f12284b = null;
    }
}
