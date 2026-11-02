package f2;

import android.util.Log;
import com.google.android.gms.internal.measurement.cc;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class hb extends ib {

    /* renamed from: g, reason: collision with root package name */
    public final com.google.android.gms.internal.measurement.z2 f5285g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ b f5286h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hb(b bVar, String str, int i10, com.google.android.gms.internal.measurement.z2 z2Var) {
        super(str, i10);
        this.f5286h = bVar;
        this.f5285g = z2Var;
    }

    @Override // f2.ib
    public final int a() {
        return this.f5285g.E();
    }

    @Override // f2.ib
    public final boolean b() {
        return this.f5285g.Q();
    }

    @Override // f2.ib
    public final boolean c() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0113  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean k(Long l10, Long l11, com.google.android.gms.internal.measurement.j4 j4Var, long j10, q qVar, boolean z10) {
        Boolean boolI;
        cc.b();
        boolean zB = this.f5286h.f5030a.z().B(this.f5363a, i3.f5296a0);
        long j11 = this.f5285g.P() ? qVar.f5617e : j10;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        Boolean bool = null;
        if (Log.isLoggable(this.f5286h.f5030a.d().D(), 2)) {
            this.f5286h.f5030a.d().v().d("Evaluating filter. audience, filter, event", Integer.valueOf(this.f5364b), this.f5285g.R() ? Integer.valueOf(this.f5285g.E()) : null, this.f5286h.f5030a.D().d(this.f5285g.J()));
            this.f5286h.f5030a.d().v().b("Filter definition", this.f5286h.f5039b.g0().G(this.f5285g));
        }
        if (!this.f5285g.R() || this.f5285g.E() > 256) {
            this.f5286h.f5030a.d().w().c("Invalid event filter ID. appId, id", v3.z(this.f5363a), String.valueOf(this.f5285g.R() ? Integer.valueOf(this.f5285g.E()) : null));
            return false;
        }
        boolean z11 = this.f5285g.N() || this.f5285g.O() || this.f5285g.P();
        if (z10 && !z11) {
            this.f5286h.f5030a.d().v().c("Event filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(this.f5364b), this.f5285g.R() ? Integer.valueOf(this.f5285g.E()) : null);
            return true;
        }
        com.google.android.gms.internal.measurement.z2 z2Var = this.f5285g;
        String strK = j4Var.K();
        if (!z2Var.Q()) {
            HashSet hashSet = new HashSet();
            Iterator it = z2Var.K().iterator();
            while (true) {
                if (!it.hasNext()) {
                    k.a aVar = new k.a();
                    Iterator it2 = j4Var.L().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            Iterator it3 = z2Var.K().iterator();
                            while (true) {
                                if (!it3.hasNext()) {
                                    bool = Boolean.TRUE;
                                    break;
                                }
                                com.google.android.gms.internal.measurement.b3 b3Var = (com.google.android.gms.internal.measurement.b3) it3.next();
                                boolean z12 = b3Var.K() && b3Var.J();
                                String strH = b3Var.H();
                                if (strH.isEmpty()) {
                                    this.f5286h.f5030a.d().w().b("Event has empty param name. event", this.f5286h.f5030a.D().d(strK));
                                    break;
                                }
                                Object obj = aVar.get(strH);
                                if (obj instanceof Long) {
                                    if (!b3Var.L()) {
                                        this.f5286h.f5030a.d().w().c("No number filter for long param. event, param", this.f5286h.f5030a.D().d(strK), this.f5286h.f5030a.D().e(strH));
                                        break;
                                    }
                                    Boolean boolH = ib.h(((Long) obj).longValue(), b3Var.F());
                                    if (boolH == null) {
                                        break;
                                    }
                                    if (boolH.booleanValue() == z12) {
                                        bool = Boolean.FALSE;
                                        break;
                                    }
                                } else if (obj instanceof Double) {
                                    if (!b3Var.L()) {
                                        this.f5286h.f5030a.d().w().c("No number filter for double param. event, param", this.f5286h.f5030a.D().d(strK), this.f5286h.f5030a.D().e(strH));
                                        break;
                                    }
                                    Boolean boolG = ib.g(((Double) obj).doubleValue(), b3Var.F());
                                    if (boolG == null) {
                                        break;
                                    }
                                    if (boolG.booleanValue() == z12) {
                                        bool = Boolean.FALSE;
                                        break;
                                    }
                                } else if (obj instanceof String) {
                                    if (!b3Var.N()) {
                                        if (!b3Var.L()) {
                                            this.f5286h.f5030a.d().w().c("No filter for String param. event, param", this.f5286h.f5030a.D().d(strK), this.f5286h.f5030a.D().e(strH));
                                            break;
                                        }
                                        String str = (String) obj;
                                        if (!ra.P(str)) {
                                            this.f5286h.f5030a.d().w().c("Invalid param value for number filter. event, param", this.f5286h.f5030a.D().d(strK), this.f5286h.f5030a.D().e(strH));
                                            break;
                                        }
                                        boolI = ib.i(str, b3Var.F());
                                    } else {
                                        boolI = ib.f((String) obj, b3Var.G(), this.f5286h.f5030a.d());
                                    }
                                    if (boolI == null) {
                                        break;
                                    }
                                    if (boolI.booleanValue() == z12) {
                                        bool = Boolean.FALSE;
                                        break;
                                    }
                                } else if (obj == null) {
                                    this.f5286h.f5030a.d().v().c("Missing param for filter. event, param", this.f5286h.f5030a.D().d(strK), this.f5286h.f5030a.D().e(strH));
                                    bool = Boolean.FALSE;
                                } else {
                                    this.f5286h.f5030a.d().w().c("Unknown param type. event, param", this.f5286h.f5030a.D().d(strK), this.f5286h.f5030a.D().e(strH));
                                }
                            }
                        } else {
                            com.google.android.gms.internal.measurement.n4 n4Var = (com.google.android.gms.internal.measurement.n4) it2.next();
                            if (hashSet.contains(n4Var.J())) {
                                if (!n4Var.Y()) {
                                    if (!n4Var.W()) {
                                        if (!n4Var.a0()) {
                                            this.f5286h.f5030a.d().w().c("Unknown value for param. event, param", this.f5286h.f5030a.D().d(strK), this.f5286h.f5030a.D().e(n4Var.J()));
                                            break;
                                        }
                                        aVar.put(n4Var.J(), n4Var.K());
                                    } else {
                                        aVar.put(n4Var.J(), n4Var.W() ? Double.valueOf(n4Var.D()) : null);
                                    }
                                } else {
                                    aVar.put(n4Var.J(), n4Var.Y() ? Long.valueOf(n4Var.G()) : null);
                                }
                            }
                        }
                    }
                } else {
                    com.google.android.gms.internal.measurement.b3 b3Var2 = (com.google.android.gms.internal.measurement.b3) it.next();
                    if (b3Var2.H().isEmpty()) {
                        this.f5286h.f5030a.d().w().b("null or empty param name in filter. event", this.f5286h.f5030a.D().d(strK));
                        break;
                    }
                    hashSet.add(b3Var2.H());
                }
            }
        } else {
            Boolean boolH2 = ib.h(j11, z2Var.I());
            if (boolH2 != null) {
                if (!boolH2.booleanValue()) {
                    bool = Boolean.FALSE;
                }
            }
        }
        this.f5286h.f5030a.d().v().b("Event filter result", bool == null ? "null" : bool);
        if (bool == null) {
            return false;
        }
        Boolean bool2 = Boolean.TRUE;
        this.f5365c = bool2;
        if (!bool.booleanValue()) {
            return true;
        }
        this.f5366d = bool2;
        if (z11 && j4Var.W()) {
            Long lValueOf = Long.valueOf(j4Var.G());
            if (this.f5285g.O()) {
                if (!zB || !this.f5285g.Q()) {
                    l10 = lValueOf;
                }
                this.f5368f = l10;
            } else {
                if (zB && this.f5285g.Q()) {
                    lValueOf = l11;
                }
                this.f5367e = lValueOf;
            }
        }
        return true;
    }
}
