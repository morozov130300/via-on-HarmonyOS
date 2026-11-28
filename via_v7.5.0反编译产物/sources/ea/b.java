package ea;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f4322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f4323b;

    public b(h hVar) {
        this.f4322a = hVar;
    }

    public static /* synthetic */ int d(l9.d dVar, l9.d dVar2) {
        if (dVar.b() == dVar2.b()) {
            return 0;
        }
        return dVar.b() > dVar2.b() ? -1 : 1;
    }

    @Override // ea.g
    public boolean a(l9.d dVar) {
        if (!this.f4322a.a(dVar)) {
            return false;
        }
        List list = this.f4323b;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (dVar.f() != null && dVar.f().equals(((l9.d) this.f4323b.get(size)).f())) {
                    this.f4323b.remove(size);
                    break;
                }
            }
        }
        return true;
    }

    @Override // ea.g
    public List b(boolean z10) {
        List list;
        if (z10 && (list = this.f4323b) != null) {
            return list;
        }
        List list2 = this.f4323b;
        if (list2 == null) {
            this.f4323b = new ArrayList();
        } else {
            list2.clear();
        }
        this.f4323b.addAll(this.f4322a.b());
        e();
        return this.f4323b;
    }

    @Override // ea.g
    public List c(String str) {
        ArrayList arrayList = new ArrayList();
        String lowerCase = str == null ? "" : str.toLowerCase(Locale.ROOT);
        if (this.f4323b == null) {
            b(false);
        }
        List<l9.d> list = this.f4323b;
        if (list != null) {
            for (l9.d dVar : list) {
                String strD = dVar.d();
                if (strD != null && strD.toLowerCase(Locale.ROOT).contains(lowerCase)) {
                    arrayList.add(dVar);
                }
            }
        }
        return arrayList;
    }

    public final void e() {
        List list = this.f4323b;
        if (list == null || list.size() <= 1) {
            return;
        }
        Collections.sort(this.f4323b, new Comparator() { // from class: ea.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return b.d((l9.d) obj, (l9.d) obj2);
            }
        });
    }
}
