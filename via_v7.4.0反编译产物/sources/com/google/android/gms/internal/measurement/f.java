package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import org.simpleframework.xml.strategy.Name;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class f implements Iterable, r, n {

    /* renamed from: e, reason: collision with root package name */
    public final SortedMap f3489e;

    /* renamed from: j, reason: collision with root package name */
    public final Map f3490j;

    public f() {
        this.f3489e = new TreeMap();
        this.f3490j = new TreeMap();
    }

    public f(List list) {
        this();
        if (list != null) {
            for (int i10 = 0; i10 < list.size(); i10++) {
                B(i10, (r) list.get(i10));
            }
        }
    }

    public final void A(int i10) {
        int iIntValue = ((Integer) this.f3489e.lastKey()).intValue();
        if (i10 > iIntValue || i10 < 0) {
            return;
        }
        this.f3489e.remove(Integer.valueOf(i10));
        if (i10 == iIntValue) {
            SortedMap sortedMap = this.f3489e;
            int i11 = i10 - 1;
            Integer numValueOf = Integer.valueOf(i11);
            if (sortedMap.containsKey(numValueOf) || i11 < 0) {
                return;
            }
            this.f3489e.put(numValueOf, r.f3714a);
            return;
        }
        while (true) {
            i10++;
            if (i10 > ((Integer) this.f3489e.lastKey()).intValue()) {
                return;
            }
            SortedMap sortedMap2 = this.f3489e;
            Integer numValueOf2 = Integer.valueOf(i10);
            r rVar = (r) sortedMap2.get(numValueOf2);
            if (rVar != null) {
                this.f3489e.put(Integer.valueOf(i10 - 1), rVar);
                this.f3489e.remove(numValueOf2);
            }
        }
    }

    public final void B(int i10, r rVar) {
        if (i10 > 32468) {
            throw new IllegalStateException("Array too large");
        }
        if (i10 < 0) {
            throw new IndexOutOfBoundsException("Out of bounds index: " + i10);
        }
        if (rVar == null) {
            this.f3489e.remove(Integer.valueOf(i10));
        } else {
            this.f3489e.put(Integer.valueOf(i10), rVar);
        }
    }

    public final boolean C(int i10) {
        if (i10 >= 0 && i10 <= ((Integer) this.f3489e.lastKey()).intValue()) {
            return this.f3489e.containsKey(Integer.valueOf(i10));
        }
        throw new IndexOutOfBoundsException("Out of bounds index: " + i10);
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final r c() {
        f fVar = new f();
        for (Map.Entry entry : this.f3489e.entrySet()) {
            if (entry.getValue() instanceof n) {
                fVar.f3489e.put((Integer) entry.getKey(), (r) entry.getValue());
            } else {
                fVar.f3489e.put((Integer) entry.getKey(), ((r) entry.getValue()).c());
            }
        }
        return fVar;
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final Double e() {
        return this.f3489e.size() == 1 ? u(0).e() : this.f3489e.size() <= 0 ? Double.valueOf(0.0d) : Double.valueOf(Double.NaN);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (t() != fVar.t()) {
            return false;
        }
        if (this.f3489e.isEmpty()) {
            return fVar.f3489e.isEmpty();
        }
        for (int iIntValue = ((Integer) this.f3489e.firstKey()).intValue(); iIntValue <= ((Integer) this.f3489e.lastKey()).intValue(); iIntValue++) {
            if (!u(iIntValue).equals(fVar.u(iIntValue))) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final String f() {
        return v(",");
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final Boolean g() {
        return Boolean.TRUE;
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final Iterator h() {
        return new d(this, this.f3489e.keySet().iterator(), this.f3490j.keySet().iterator());
    }

    public final int hashCode() {
        return this.f3489e.hashCode() * 31;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new e(this);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final boolean k(String str) {
        return Name.LENGTH.equals(str) || this.f3490j.containsKey(str);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final void n(String str, r rVar) {
        if (rVar == null) {
            this.f3490j.remove(str);
        } else {
            this.f3490j.put(str, rVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final r o(String str, q4 q4Var, List list) {
        return ("concat".equals(str) || "every".equals(str) || "filter".equals(str) || "forEach".equals(str) || "indexOf".equals(str) || "join".equals(str) || "lastIndexOf".equals(str) || "map".equals(str) || "pop".equals(str) || "push".equals(str) || "reduce".equals(str) || "reduceRight".equals(str) || "reverse".equals(str) || "shift".equals(str) || "slice".equals(str) || "some".equals(str) || "sort".equals(str) || "splice".equals(str) || "toString".equals(str) || "unshift".equals(str)) ? e0.a(str, this, q4Var, list) : l.a(this, new v(str), q4Var, list);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final r p(String str) {
        r rVar;
        return Name.LENGTH.equals(str) ? new j(Double.valueOf(t())) : (!k(str) || (rVar = (r) this.f3490j.get(str)) == null) ? r.f3714a : rVar;
    }

    public final int s() {
        return this.f3489e.size();
    }

    public final int t() {
        if (this.f3489e.isEmpty()) {
            return 0;
        }
        return ((Integer) this.f3489e.lastKey()).intValue() + 1;
    }

    public final String toString() {
        return v(",");
    }

    public final r u(int i10) {
        r rVar;
        if (i10 < t()) {
            return (!C(i10) || (rVar = (r) this.f3489e.get(Integer.valueOf(i10))) == null) ? r.f3714a : rVar;
        }
        throw new IndexOutOfBoundsException("Attempting to get element outside of current array");
    }

    public final String v(String str) {
        String str2;
        StringBuilder sb2 = new StringBuilder();
        if (!this.f3489e.isEmpty()) {
            int i10 = 0;
            while (true) {
                str2 = str == null ? "" : str;
                if (i10 >= t()) {
                    break;
                }
                r rVarU = u(i10);
                sb2.append(str2);
                if (!(rVarU instanceof w) && !(rVarU instanceof p)) {
                    sb2.append(rVarU.f());
                }
                i10++;
            }
            sb2.delete(0, str2.length());
        }
        return sb2.toString();
    }

    public final Iterator w() {
        return this.f3489e.keySet().iterator();
    }

    public final List x() {
        ArrayList arrayList = new ArrayList(t());
        for (int i10 = 0; i10 < t(); i10++) {
            arrayList.add(u(i10));
        }
        return arrayList;
    }

    public final void y() {
        this.f3489e.clear();
    }

    public final void z(int i10, r rVar) {
        if (i10 < 0) {
            throw new IllegalArgumentException("Invalid value index: " + i10);
        }
        if (i10 >= t()) {
            B(i10, rVar);
            return;
        }
        for (int iIntValue = ((Integer) this.f3489e.lastKey()).intValue(); iIntValue >= i10; iIntValue--) {
            SortedMap sortedMap = this.f3489e;
            Integer numValueOf = Integer.valueOf(iIntValue);
            r rVar2 = (r) sortedMap.get(numValueOf);
            if (rVar2 != null) {
                B(iIntValue + 1, rVar2);
                this.f3489e.remove(numValueOf);
            }
        }
        B(i10, rVar);
    }
}
