package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class z8 extends o {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f3212e;

    public z8(c cVar) {
        this.f3212e = cVar;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.google.android.gms.internal.measurement.o, com.google.android.gms.internal.measurement.r
    public final r o(String str, q4 q4Var, List list) {
        switch (str.hashCode()) {
            case 21624207:
                if (str.equals("getEventName")) {
                    r5.h("getEventName", 0, list);
                    return new v(this.f3212e.b().d());
                }
                break;
            case 45521504:
                if (str.equals("getTimestamp")) {
                    r5.h("getTimestamp", 0, list);
                    return new j(Double.valueOf(this.f3212e.b().a()));
                }
                break;
            case 146575578:
                if (str.equals("getParamValue")) {
                    r5.h("getParamValue", 1, list);
                    return t6.b(this.f3212e.b().c(q4Var.b((r) list.get(0)).f()));
                }
                break;
            case 700587132:
                if (str.equals("getParams")) {
                    r5.h("getParams", 0, list);
                    Map mapE = this.f3212e.b().e();
                    o oVar = new o();
                    for (String str2 : mapE.keySet()) {
                        oVar.n(str2, t6.b(mapE.get(str2)));
                    }
                    return oVar;
                }
                break;
            case 920706790:
                if (str.equals("setParamValue")) {
                    r5.h("setParamValue", 2, list);
                    String strF = q4Var.b((r) list.get(0)).f();
                    r rVarB = q4Var.b((r) list.get(1));
                    this.f3212e.b().g(strF, r5.f(rVarB));
                    return rVarB;
                }
                break;
            case 1570616835:
                if (str.equals("setEventName")) {
                    r5.h("setEventName", 1, list);
                    r rVarB2 = q4Var.b((r) list.get(0));
                    if (r.f3013a.equals(rVarB2) || r.f3014b.equals(rVarB2)) {
                        throw new IllegalArgumentException("Illegal event name");
                    }
                    this.f3212e.b().f(rVarB2.f());
                    return new v(rVarB2.f());
                }
                break;
        }
        return super.o(str, q4Var, list);
    }
}
