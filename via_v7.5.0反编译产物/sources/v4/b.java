package v4;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b implements a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f13356d = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f13357a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map f13358b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13359c;

    public b(int i10) {
        this.f13359c = i10;
    }

    @Override // v4.a
    public void a() {
        if (this.f13358b != null) {
            return;
        }
        this.f13358b = new HashMap();
        if (this.f13357a.isEmpty()) {
            return;
        }
        for (Map.Entry entry : this.f13357a.entrySet()) {
            this.f13358b.put(entry.getKey(), new HashSet(Arrays.asList((Object[]) entry.getValue())));
        }
        this.f13357a.clear();
    }

    public final Set b(String str) {
        Pair pairH = h(str);
        if (pairH == null) {
            return null;
        }
        Object obj = pairH.first;
        if (obj == null) {
            return (Set) pairH.second;
        }
        if (pairH.second == null) {
            return (Set) obj;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll((Collection) pairH.first);
        linkedHashSet.addAll((Collection) pairH.second);
        return linkedHashSet;
    }

    @Override // v4.a
    public void c() {
        Map map = this.f13358b;
        if (map == null) {
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            this.f13357a.put(entry.getKey(), ((Set) entry.getValue()).toArray(new String[0]));
        }
        this.f13358b.clear();
        this.f13358b = null;
        b5.a.a(f13356d, "load element filter done, total size: " + n());
    }

    @Override // v4.a
    public void d(w4.a aVar) {
        if (!aVar.c(1) || this.f13359c >= 105) {
            if (aVar.b() == null || aVar.b().length == 0) {
                k(aVar.a());
                return;
            }
            for (String str : aVar.b()) {
                if (str != null && str.length() > 2) {
                    j(aVar.a(), str);
                }
            }
        }
    }

    @Override // v4.a
    public void e(w4.a aVar) {
        if (aVar.b() == null || aVar.b().length == 0) {
            m(aVar.a());
            return;
        }
        for (String str : aVar.b()) {
            if (str == null || str.length() <= 2) {
                return;
            }
            l(aVar.a(), str);
        }
    }

    @Override // v4.a
    public String f(String str) {
        Set setB = b(str);
        if (setB == null || setB.isEmpty()) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        int size = setB.size();
        Iterator it = setB.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            i10++;
            sb2.append((String) it.next());
            if (i10 % 100 == 0 || i10 == size) {
                sb2.append("{display:none!important}\n");
            } else {
                sb2.append(',');
            }
        }
        return sb2.toString();
    }

    public final String[] g(String str) {
        return (String[]) this.f13357a.get(str);
    }

    public final Pair h(String str) {
        String[] strArrG = g(str);
        String strP = b5.c.p(str);
        String[] strArrG2 = !str.equals(strP) ? g(strP) : null;
        String[] strArrI = i();
        if ((strArrG == null || strArrG.length == 0) && ((strArrG2 == null || strArrG2.length == 0) && (strArrI == null || strArrI.length == 0))) {
            return null;
        }
        String[] strArrG3 = g('~' + str);
        String[] strArrG4 = str.equals(strP) ? null : g('~' + strP);
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        if (strArrG != null) {
            hashSet2.addAll(Arrays.asList(strArrG));
        }
        if (strArrG2 != null) {
            hashSet2.addAll(Arrays.asList(strArrG2));
        }
        if (strArrI != null) {
            hashSet.addAll(Arrays.asList(strArrI));
        }
        if (strArrG3 != null) {
            for (String str2 : strArrG3) {
                hashSet2.remove(str2);
                hashSet.remove(str2);
            }
        }
        if (strArrG4 != null) {
            for (String str3 : strArrG4) {
                hashSet2.remove(str3);
                hashSet.remove(str3);
            }
        }
        if (hashSet2.isEmpty()) {
            hashSet2 = null;
        }
        if (hashSet.isEmpty()) {
            hashSet = null;
        }
        if (hashSet2 == null && hashSet == null) {
            return null;
        }
        return new Pair(hashSet2, hashSet);
    }

    public final String[] i() {
        return g("");
    }

    public final void j(String str, String str2) {
        Set hashSet;
        if (str == null || str.isEmpty()) {
            return;
        }
        if (str2 == null) {
            str2 = "";
        }
        Map map = this.f13358b;
        if (map != null) {
            hashSet = (Set) map.get(str2);
            if (hashSet == null) {
                hashSet = new HashSet();
                this.f13358b.put(str2, hashSet);
            }
        } else {
            String[] strArr = (String[]) this.f13357a.get(str2);
            hashSet = new HashSet(strArr == null ? new ArrayList() : Arrays.asList(strArr));
        }
        hashSet.add(str);
        if (this.f13358b == null) {
            this.f13357a.put(str2, hashSet.toArray(new String[0]));
        }
    }

    public final void k(String str) {
        j(str, "");
    }

    public final void l(String str, String str2) {
        Set hashSet;
        if (str == null || str.isEmpty()) {
            return;
        }
        if (str2 == null) {
            str2 = "";
        }
        Map map = this.f13358b;
        if (map != null) {
            hashSet = (Set) map.get(str2);
            if (hashSet == null) {
                return;
            }
        } else {
            String[] strArr = (String[]) this.f13357a.get(str2);
            if (strArr == null) {
                return;
            } else {
                hashSet = new HashSet(Arrays.asList(strArr));
            }
        }
        hashSet.remove(str);
        if (!hashSet.isEmpty()) {
            if (this.f13358b == null) {
                this.f13357a.put(str2, hashSet.toArray(new String[0]));
            }
        } else {
            Map map2 = this.f13358b;
            if (map2 != null) {
                map2.remove(str2);
            } else {
                this.f13357a.remove(str2);
            }
        }
    }

    public final void m(String str) {
        l(str, "");
    }

    public int n() {
        return this.f13357a.size();
    }
}
