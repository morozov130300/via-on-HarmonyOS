package f2;

import com.google.android.gms.internal.measurement.cc;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class eb {

    /* renamed from: a, reason: collision with root package name */
    public String f5160a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f5161b;

    /* renamed from: c, reason: collision with root package name */
    public com.google.android.gms.internal.measurement.z4 f5162c;

    /* renamed from: d, reason: collision with root package name */
    public BitSet f5163d;

    /* renamed from: e, reason: collision with root package name */
    public BitSet f5164e;

    /* renamed from: f, reason: collision with root package name */
    public Map f5165f;

    /* renamed from: g, reason: collision with root package name */
    public Map f5166g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ b f5167h;

    public /* synthetic */ eb(b bVar, String str, com.google.android.gms.internal.measurement.z4 z4Var, BitSet bitSet, BitSet bitSet2, Map map, Map map2, db dbVar) {
        this.f5167h = bVar;
        this.f5160a = str;
        this.f5163d = bitSet;
        this.f5164e = bitSet2;
        this.f5165f = map;
        this.f5166g = new k.a();
        for (Integer num : map2.keySet()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((Long) map2.get(num));
            this.f5166g.put(num, arrayList);
        }
        this.f5161b = false;
        this.f5162c = z4Var;
    }

    public /* synthetic */ eb(b bVar, String str, db dbVar) {
        this.f5167h = bVar;
        this.f5160a = str;
        this.f5161b = true;
        this.f5163d = new BitSet();
        this.f5164e = new BitSet();
        this.f5165f = new k.a();
        this.f5166g = new k.a();
    }

    public final com.google.android.gms.internal.measurement.f4 a(int i10) {
        ArrayList arrayList;
        List list;
        com.google.android.gms.internal.measurement.e4 e4VarE = com.google.android.gms.internal.measurement.f4.E();
        e4VarE.s(i10);
        e4VarE.u(this.f5161b);
        com.google.android.gms.internal.measurement.z4 z4Var = this.f5162c;
        if (z4Var != null) {
            e4VarE.v(z4Var);
        }
        com.google.android.gms.internal.measurement.y4 y4VarH = com.google.android.gms.internal.measurement.z4.H();
        y4VarH.t(ra.J(this.f5163d));
        y4VarH.v(ra.J(this.f5164e));
        Map map = this.f5165f;
        if (map == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList(map.size());
            for (Integer num : this.f5165f.keySet()) {
                int iIntValue = num.intValue();
                Long l10 = (Long) this.f5165f.get(num);
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
        Map map2 = this.f5166g;
        if (map2 == null) {
            list = Collections.EMPTY_LIST;
        } else {
            ArrayList arrayList3 = new ArrayList(map2.size());
            for (Integer num2 : this.f5166g.keySet()) {
                com.google.android.gms.internal.measurement.a5 a5VarG = com.google.android.gms.internal.measurement.b5.G();
                a5VarG.t(num2.intValue());
                List list2 = (List) this.f5166g.get(num2);
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
        if (ibVar.f5365c != null) {
            this.f5164e.set(iA, true);
        }
        Boolean bool = ibVar.f5366d;
        if (bool != null) {
            this.f5163d.set(iA, bool.booleanValue());
        }
        if (ibVar.f5367e != null) {
            Map map = this.f5165f;
            Integer numValueOf = Integer.valueOf(iA);
            Long l10 = (Long) map.get(numValueOf);
            long jLongValue = ibVar.f5367e.longValue() / 1000;
            if (l10 == null || jLongValue > l10.longValue()) {
                this.f5165f.put(numValueOf, Long.valueOf(jLongValue));
            }
        }
        if (ibVar.f5368f != null) {
            Map map2 = this.f5166g;
            Integer numValueOf2 = Integer.valueOf(iA);
            List arrayList = (List) map2.get(numValueOf2);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.f5166g.put(numValueOf2, arrayList);
            }
            if (ibVar.c()) {
                arrayList.clear();
            }
            cc.b();
            g gVarZ = this.f5167h.f5030a.z();
            String str = this.f5160a;
            h3 h3Var = i3.f5296a0;
            if (gVarZ.B(str, h3Var) && ibVar.b()) {
                arrayList.clear();
            }
            cc.b();
            if (!this.f5167h.f5030a.z().B(this.f5160a, h3Var)) {
                arrayList.add(Long.valueOf(ibVar.f5368f.longValue() / 1000));
                return;
            }
            Long lValueOf = Long.valueOf(ibVar.f5368f.longValue() / 1000);
            if (arrayList.contains(lValueOf)) {
                return;
            }
            arrayList.add(lValueOf);
        }
    }
}
