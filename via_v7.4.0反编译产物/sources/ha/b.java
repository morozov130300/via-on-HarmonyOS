package ha;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b implements g {

    /* renamed from: a, reason: collision with root package name */
    public final h f6453a;

    /* renamed from: b, reason: collision with root package name */
    public List f6454b;

    public b(h hVar) {
        this.f6453a = hVar;
    }

    public static /* synthetic */ int d(n9.d dVar, n9.d dVar2) {
        if (dVar.b() == dVar2.b()) {
            return 0;
        }
        return dVar.b() > dVar2.b() ? -1 : 1;
    }

    @Override // ha.g
    public boolean a(n9.d dVar) {
        if (!this.f6453a.a(dVar)) {
            return false;
        }
        List list = this.f6454b;
        if (list != null) {
            int size = list.size() - 1;
            while (true) {
                if (size >= 0) {
                    if (dVar.f() != null && dVar.f().equals(((n9.d) this.f6454b.get(size)).f())) {
                        this.f6454b.remove(size);
                        break;
                    }
                    size--;
                } else {
                    break;
                }
            }
        }
        return true;
    }

    @Override // ha.g
    public List b(boolean z10) {
        List list;
        if (z10 && (list = this.f6454b) != null) {
            return list;
        }
        List list2 = this.f6454b;
        if (list2 == null) {
            this.f6454b = new ArrayList();
        } else {
            list2.clear();
        }
        this.f6454b.addAll(this.f6453a.b());
        e();
        return this.f6454b;
    }

    @Override // ha.g
    public List c(String str) {
        ArrayList arrayList = new ArrayList();
        String lowerCase = str == null ? "" : str.toLowerCase(Locale.ROOT);
        if (this.f6454b == null) {
            b(false);
        }
        List<n9.d> list = this.f6454b;
        if (list != null) {
            for (n9.d dVar : list) {
                String strD = dVar.d();
                if (strD != null && strD.toLowerCase(Locale.ROOT).contains(lowerCase)) {
                    arrayList.add(dVar);
                }
            }
        }
        return arrayList;
    }

    public final void e() {
        List list = this.f6454b;
        if (list == null || list.size() <= 1) {
            return;
        }
        Collections.sort(this.f6454b, new Comparator() { // from class: ha.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return b.d((n9.d) obj, (n9.d) obj2);
            }
        });
    }
}
