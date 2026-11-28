package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class f implements Iterable, r, n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SortedMap f2788c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map f2789e;

    public f() {
        this.f2788c = new TreeMap();
        this.f2789e = new TreeMap();
    }

    public final void A(int i10) {
        int iIntValue = ((Integer) this.f2788c.lastKey()).intValue();
        if (i10 > iIntValue || i10 < 0) {
            return;
        }
        this.f2788c.remove(Integer.valueOf(i10));
        if (i10 == iIntValue) {
            SortedMap sortedMap = this.f2788c;
            int i11 = i10 - 1;
            Integer numValueOf = Integer.valueOf(i11);
            if (sortedMap.containsKey(numValueOf) || i11 < 0) {
                return;
            }
            this.f2788c.put(numValueOf, r.f3013a);
            return;
        }
        while (true) {
            i10++;
            if (i10 > ((Integer) this.f2788c.lastKey()).intValue()) {
                return;
            }
            SortedMap sortedMap2 = this.f2788c;
            Integer numValueOf2 = Integer.valueOf(i10);
            r rVar = (r) sortedMap2.get(numValueOf2);
            if (rVar != null) {
                this.f2788c.put(Integer.valueOf(i10 - 1), rVar);
                this.f2788c.remove(numValueOf2);
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
            this.f2788c.remove(Integer.valueOf(i10));
        } else {
            this.f2788c.put(Integer.valueOf(i10), rVar);
        }
    }

    public final boolean C(int i10) {
        if (i10 >= 0 && i10 <= ((Integer) this.f2788c.lastKey()).intValue()) {
            return this.f2788c.containsKey(Integer.valueOf(i10));
        }
        throw new IndexOutOfBoundsException("Out of bounds index: " + i10);
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final r c() {
        f fVar = new f();
        for (Map.Entry entry : this.f2788c.entrySet()) {
            if (entry.getValue() instanceof n) {
                fVar.f2788c.put((Integer) entry.getKey(), (r) entry.getValue());
            } else {
                fVar.f2788c.put((Integer) entry.getKey(), ((r) entry.getValue()).c());
            }
        }
        return fVar;
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final Double e() {
        if (this.f2788c.size() == 1) {
            return u(0).e();
        }
        return this.f2788c.size() <= 0 ? Double.valueOf(0.0d) : Double.valueOf(Double.NaN);
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
        if (this.f2788c.isEmpty()) {
            return fVar.f2788c.isEmpty();
        }
        for (int iIntValue = ((Integer) this.f2788c.firstKey()).intValue(); iIntValue <= ((Integer) this.f2788c.lastKey()).intValue(); iIntValue++) {
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
        return new d(this, this.f2788c.keySet().iterator(), this.f2789e.keySet().iterator());
    }

    public final int hashCode() {
        return this.f2788c.hashCode() * 31;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new e(this);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final boolean k(String str) {
        return Name.LENGTH.equals(str) || this.f2789e.containsKey(str);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final void n(String str, r rVar) {
        if (rVar == null) {
            this.f2789e.remove(str);
        } else {
            this.f2789e.put(str, rVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final r o(String str, q4 q4Var, List list) {
        return ("concat".equals(str) || "every".equals(str) || "filter".equals(str) || "forEach".equals(str) || "indexOf".equals(str) || "join".equals(str) || "lastIndexOf".equals(str) || "map".equals(str) || "pop".equals(str) || "push".equals(str) || "reduce".equals(str) || "reduceRight".equals(str) || "reverse".equals(str) || "shift".equals(str) || "slice".equals(str) || "some".equals(str) || "sort".equals(str) || "splice".equals(str) || "toString".equals(str) || "unshift".equals(str)) ? e0.a(str, this, q4Var, list) : l.a(this, new v(str), q4Var, list);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final r p(String str) {
        r rVar;
        if (Name.LENGTH.equals(str)) {
            return new j(Double.valueOf(t()));
        }
        return (!k(str) || (rVar = (r) this.f2789e.get(str)) == null) ? r.f3013a : rVar;
    }

    public final int s() {
        return this.f2788c.size();
    }

    public final int t() {
        if (this.f2788c.isEmpty()) {
            return 0;
        }
        return ((Integer) this.f2788c.lastKey()).intValue() + 1;
    }

    public final String toString() {
        return v(",");
    }

    public final r u(int i10) {
        r rVar;
        if (i10 < t()) {
            return (!C(i10) || (rVar = (r) this.f2788c.get(Integer.valueOf(i10))) == null) ? r.f3013a : rVar;
        }
        throw new IndexOutOfBoundsException("Attempting to get element outside of current array");
    }

    public final String v(String str) {
        String str2;
        StringBuilder sb2 = new StringBuilder();
        if (!this.f2788c.isEmpty()) {
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
        return this.f2788c.keySet().iterator();
    }

    public final List x() {
        ArrayList arrayList = new ArrayList(t());
        for (int i10 = 0; i10 < t(); i10++) {
            arrayList.add(u(i10));
        }
        return arrayList;
    }

    public final void y() {
        this.f2788c.clear();
    }

    public final void z(int i10, r rVar) {
        if (i10 < 0) {
            throw new IllegalArgumentException("Invalid value index: " + i10);
        }
        if (i10 >= t()) {
            B(i10, rVar);
            return;
        }
        for (int iIntValue = ((Integer) this.f2788c.lastKey()).intValue(); iIntValue >= i10; iIntValue--) {
            SortedMap sortedMap = this.f2788c;
            Integer numValueOf = Integer.valueOf(iIntValue);
            r rVar2 = (r) sortedMap.get(numValueOf);
            if (rVar2 != null) {
                B(iIntValue + 1, rVar2);
                this.f2788c.remove(numValueOf);
            }
        }
        B(i10, rVar);
    }

    public f(List list) {
        this();
        if (list != null) {
            for (int i10 = 0; i10 < list.size(); i10++) {
                B(i10, (r) list.get(i10));
            }
        }
    }
}
