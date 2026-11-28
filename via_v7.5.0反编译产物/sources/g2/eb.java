package g2;

import com.google.android.gms.internal.measurement.cc;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class eb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f4776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f4777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.google.android.gms.internal.measurement.z4 f4778c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BitSet f4779d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BitSet f4780e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map f4781f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map f4782g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ b f4783h;

    public /* synthetic */ eb(b bVar, String str, db dbVar) {
        this.f4783h = bVar;
        this.f4776a = str;
        this.f4777b = true;
        this.f4779d = new BitSet();
        this.f4780e = new BitSet();
        this.f4781f = new k.a();
        this.f4782g = new k.a();
    }

    public final com.google.android.gms.internal.measurement.f4 a(int i10) {
        ArrayList arrayList;
        List list;
        com.google.android.gms.internal.measurement.e4 e4VarE = com.google.android.gms.internal.measurement.f4.E();
        e4VarE.s(i10);
        e4VarE.u(this.f4777b);
        com.google.android.gms.internal.measurement.z4 z4Var = this.f4778c;
        if (z4Var != null) {
            e4VarE.v(z4Var);
        }
        com.google.android.gms.internal.measurement.y4 y4VarH = com.google.android.gms.internal.measurement.z4.H();
        y4VarH.t(ra.J(this.f4779d));
        y4VarH.v(ra.J(this.f4780e));
        Map map = this.f4781f;
        if (map == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList(map.size());
            for (Integer num : this.f4781f.keySet()) {
                int iIntValue = num.intValue();
                Long l10 = (Long) this.f4781f.get(num);
                if (l10 != null) {
                    com.google.android.gms.internal.measurement.g4 g4VarF = com.google.android.gms.internal.measurement.h4.F();
                    g4VarF.t(iIntValue);
                    g4VarF.s(l10.longValue());
                    arrayList2.add((com.google.android.gms.internal.measurement.h4) g4VarF.o());
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            y4VarH.s(arrayList);
        }
        Map map2 = this.f4782g;
        if (map2 == null) {
            list = Collections.EMPTY_LIST;
        } else {
            ArrayList arrayList3 = new ArrayList(map2.size());
            for (Integer num2 : this.f4782g.keySet()) {
                com.google.android.gms.internal.measurement.a5 a5VarG = com.google.android.gms.internal.measurement.b5.G();
                a5VarG.t(num2.intValue());
                List list2 = (List) this.f4782g.get(num2);
                if (list2 != null) {
                    Collections.sort(list2);
                    a5VarG.s(list2);
                }
                arrayList3.add((com.google.android.gms.internal.measurement.b5) a5VarG.o());
            }
            list = arrayList3;
        }
        y4VarH.u(list);
        e4VarE.t(y4VarH);
        return (com.google.android.gms.internal.measurement.f4) e4VarE.o();
    }

    public final void c(ib ibVar) {
        int iA = ibVar.a();
        if (ibVar.f4981c != null) {
            this.f4780e.set(iA, true);
        }
        Boolean bool = ibVar.f4982d;
        if (bool != null) {
            this.f4779d.set(iA, bool.booleanValue());
        }
        if (ibVar.f4983e != null) {
            Map map = this.f4781f;
            Integer numValueOf = Integer.valueOf(iA);
            Long l10 = (Long) map.get(numValueOf);
            long jLongValue = ibVar.f4983e.longValue() / 1000;
            if (l10 == null || jLongValue > l10.longValue()) {
                this.f4781f.put(numValueOf, Long.valueOf(jLongValue));
            }
        }
        if (ibVar.f4984f != null) {
            Map map2 = this.f4782g;
            Integer numValueOf2 = Integer.valueOf(iA);
            List arrayList = (List) map2.get(numValueOf2);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.f4782g.put(numValueOf2, arrayList);
            }
            if (ibVar.c()) {
                arrayList.clear();
            }
            cc.b();
            g gVarZ = this.f4783h.f4646a.z();
            String str = this.f4776a;
            h3 h3Var = i3.f4912a0;
            if (gVarZ.B(str, h3Var) && ibVar.b()) {
                arrayList.clear();
            }
            cc.b();
            if (!this.f4783h.f4646a.z().B(this.f4776a, h3Var)) {
                arrayList.add(Long.valueOf(ibVar.f4984f.longValue() / 1000));
                return;
            }
            Long lValueOf = Long.valueOf(ibVar.f4984f.longValue() / 1000);
            if (arrayList.contains(lValueOf)) {
                return;
            }
            arrayList.add(lValueOf);
        }
    }

    public /* synthetic */ eb(b bVar, String str, com.google.android.gms.internal.measurement.z4 z4Var, BitSet bitSet, BitSet bitSet2, Map map, Map map2, db dbVar) {
        this.f4783h = bVar;
        this.f4776a = str;
        this.f4779d = bitSet;
        this.f4780e = bitSet2;
        this.f4781f = map;
        this.f4782g = new k.a();
        for (Integer num : map2.keySet()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((Long) map2.get(num));
            this.f4782g.put(num, arrayList);
        }
        this.f4777b = false;
        this.f4778c = z4Var;
    }
}
