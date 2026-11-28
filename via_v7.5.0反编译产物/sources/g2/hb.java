package g2;

import android.util.Log;
import com.google.android.gms.internal.measurement.cc;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class hb extends ib {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.google.android.gms.internal.measurement.z2 f4901g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ b f4902h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hb(b bVar, String str, int i10, com.google.android.gms.internal.measurement.z2 z2Var) {
        super(str, i10);
        this.f4902h = bVar;
        this.f4901g = z2Var;
    }

    @Override // g2.ib
    public final int a() {
        return this.f4901g.E();
    }

    @Override // g2.ib
    public final boolean b() {
        return this.f4901g.Q();
    }

    @Override // g2.ib
    public final boolean c() {
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x02e5  */
    /* JADX WARN: Code duplicated, block: B:105:0x02f3  */
    /* JADX WARN: Code duplicated, block: B:107:0x02f9  */
    /* JADX WARN: Code duplicated, block: B:108:0x030c  */
    /* JADX WARN: Code duplicated, block: B:110:0x0312  */
    /* JADX WARN: Code duplicated, block: B:112:0x031a  */
    /* JADX WARN: Code duplicated, block: B:115:0x0326  */
    /* JADX WARN: Code duplicated, block: B:121:0x0387 A[EDGE_INSN: B:121:0x0387->B:124:0x03df BREAK  A[LOOP:0: B:40:0x0120->B:45:0x0155]] */
    /* JADX WARN: Code duplicated, block: B:122:0x03b3 A[EDGE_INSN: B:122:0x03b3->B:124:0x03df BREAK  A[LOOP:0: B:40:0x0120->B:45:0x0155]] */
    /* JADX WARN: Code duplicated, block: B:157:0x015d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:158:0x0136 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:159:0x01fd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:160:0x0180 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:161:0x019e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:162:0x0186 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:163:0x01bc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:164:0x01ce A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:165:0x01a4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:167:0x016a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:171:0x03dd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:172:0x022a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:173:0x029e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:174:0x0257 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:175:0x03df A[EDGE_INSN: B:175:0x03df->B:124:0x03df BREAK  A[LOOP:0: B:40:0x0120->B:45:0x0155], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:176:0x029a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:177:0x03df A[EDGE_INSN: B:177:0x03df->B:124:0x03df BREAK  A[LOOP:0: B:40:0x0120->B:45:0x0155], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:178:0x02eb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:179:0x0251 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:180:0x02ef A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:181:0x02a8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:182:0x02a2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:183:0x0385 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:184:0x035b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:185:0x0330 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:186:0x03df A[EDGE_INSN: B:186:0x03df->B:124:0x03df BREAK  A[LOOP:0: B:40:0x0120->B:45:0x0155], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:187:0x032c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:189:0x0205 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:190:0x0205 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:191:0x0205 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x0113  */
    /* JADX WARN: Code duplicated, block: B:42:0x0126  */
    /* JADX WARN: Code duplicated, block: B:45:0x0155 A[LOOP:0: B:40:0x0120->B:45:0x0155, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:49:0x0170  */
    /* JADX WARN: Code duplicated, block: B:55:0x0190  */
    /* JADX WARN: Code duplicated, block: B:56:0x0199  */
    /* JADX WARN: Code duplicated, block: B:62:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:63:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:67:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:72:0x020b  */
    /* JADX WARN: Code duplicated, block: B:77:0x021f  */
    /* JADX WARN: Code duplicated, block: B:81:0x0249  */
    /* JADX WARN: Code duplicated, block: B:86:0x0282  */
    /* JADX WARN: Code duplicated, block: B:89:0x0294  */
    /* JADX WARN: Code duplicated, block: B:97:0x02d3  */
    public final boolean k(Long l10, Long l11, com.google.android.gms.internal.measurement.j4 j4Var, long j10, q qVar, boolean z10) {
        HashSet hashSet;
        Iterator it;
        k.a aVar;
        Iterator it2;
        Iterator it3;
        com.google.android.gms.internal.measurement.b3 b3Var;
        boolean z11;
        String strH;
        Object obj;
        Boolean boolH;
        Boolean boolG;
        String str;
        Boolean boolI;
        com.google.android.gms.internal.measurement.n4 n4Var;
        Long lValueOf;
        Double dValueOf;
        com.google.android.gms.internal.measurement.b3 b3Var2;
        cc.b();
        boolean zB = this.f4902h.f4646a.z().B(this.f4979a, i3.f4912a0);
        long j11 = this.f4901g.P() ? qVar.f5233e : j10;
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
        if (Log.isLoggable(this.f4902h.f4646a.d().D(), 2)) {
            this.f4902h.f4646a.d().v().d("Evaluating filter. audience, filter, event", Integer.valueOf(this.f4980b), this.f4901g.R() ? Integer.valueOf(this.f4901g.E()) : null, this.f4902h.f4646a.D().d(this.f4901g.J()));
            this.f4902h.f4646a.d().v().b("Filter definition", this.f4902h.f4655b.g0().G(this.f4901g));
        }
        if (!this.f4901g.R() || this.f4901g.E() > 256) {
            this.f4902h.f4646a.d().w().c("Invalid event filter ID. appId, id", v3.z(this.f4979a), String.valueOf(this.f4901g.R() ? Integer.valueOf(this.f4901g.E()) : null));
            return false;
        }
        boolean z12 = this.f4901g.N() || this.f4901g.O() || this.f4901g.P();
        if (z10 && !z12) {
            this.f4902h.f4646a.d().v().c("Event filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(this.f4980b), this.f4901g.R() ? Integer.valueOf(this.f4901g.E()) : null);
            return true;
        }
        com.google.android.gms.internal.measurement.z2 z2Var = this.f4901g;
        String strK = j4Var.K();
        if (!z2Var.Q()) {
            hashSet = new HashSet();
            it = z2Var.K().iterator();
            while (true) {
                if (it.hasNext()) {
                    aVar = new k.a();
                    it2 = j4Var.L().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            it3 = z2Var.K().iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    bool = Boolean.TRUE;
                                    break;
                                }
                                b3Var = (com.google.android.gms.internal.measurement.b3) it3.next();
                                if (b3Var.K() || !b3Var.J()) {
                                    z11 = false;
                                } else {
                                    z11 = true;
                                }
                                strH = b3Var.H();
                                if (strH.isEmpty()) {
                                    obj = aVar.get(strH);
                                    if (obj instanceof Long) {
                                        if (obj instanceof Double) {
                                            if (obj instanceof String) {
                                                if (obj == null) {
                                                    this.f4902h.f4646a.d().w().c("Unknown param type. event, param", this.f4902h.f4646a.D().d(strK), this.f4902h.f4646a.D().e(strH));
                                                    break;
                                                }
                                                this.f4902h.f4646a.d().v().c("Missing param for filter. event, param", this.f4902h.f4646a.D().d(strK), this.f4902h.f4646a.D().e(strH));
                                                bool = Boolean.FALSE;
                                                break;
                                            }
                                            if (b3Var.N()) {
                                                if (b3Var.L()) {
                                                    this.f4902h.f4646a.d().w().c("No filter for String param. event, param", this.f4902h.f4646a.D().d(strK), this.f4902h.f4646a.D().e(strH));
                                                    break;
                                                }
                                                str = (String) obj;
                                                if (ra.P(str)) {
                                                    this.f4902h.f4646a.d().w().c("Invalid param value for number filter. event, param", this.f4902h.f4646a.D().d(strK), this.f4902h.f4646a.D().e(strH));
                                                    break;
                                                }
                                                boolI = ib.i(str, b3Var.F());
                                            } else {
                                                boolI = ib.f((String) obj, b3Var.G(), this.f4902h.f4646a.d());
                                            }
                                            if (boolI != null) {
                                                break;
                                            }
                                            if (boolI.booleanValue() == z11) {
                                                bool = Boolean.FALSE;
                                                break;
                                            }
                                        } else {
                                            if (b3Var.L()) {
                                                this.f4902h.f4646a.d().w().c("No number filter for double param. event, param", this.f4902h.f4646a.D().d(strK), this.f4902h.f4646a.D().e(strH));
                                                break;
                                            }
                                            boolG = ib.g(((Double) obj).doubleValue(), b3Var.F());
                                            if (boolG != null) {
                                                break;
                                            }
                                            if (boolG.booleanValue() == z11) {
                                                bool = Boolean.FALSE;
                                                break;
                                            }
                                        }
                                    } else {
                                        if (b3Var.L()) {
                                            this.f4902h.f4646a.d().w().c("No number filter for long param. event, param", this.f4902h.f4646a.D().d(strK), this.f4902h.f4646a.D().e(strH));
                                            break;
                                        }
                                        boolH = ib.h(((Long) obj).longValue(), b3Var.F());
                                        if (boolH != null) {
                                            break;
                                        }
                                        if (boolH.booleanValue() == z11) {
                                            bool = Boolean.FALSE;
                                            break;
                                        }
                                    }
                                } else {
                                    this.f4902h.f4646a.d().w().b("Event has empty param name. event", this.f4902h.f4646a.D().d(strK));
                                    break;
                                }
                            }
                        } else {
                            n4Var = (com.google.android.gms.internal.measurement.n4) it2.next();
                            if (!hashSet.contains(n4Var.J())) {
                                if (n4Var.Y()) {
                                    if (n4Var.W()) {
                                        if (n4Var.a0()) {
                                            this.f4902h.f4646a.d().w().c("Unknown value for param. event, param", this.f4902h.f4646a.D().d(strK), this.f4902h.f4646a.D().e(n4Var.J()));
                                            break;
                                        }
                                        aVar.put(n4Var.J(), n4Var.K());
                                    } else {
                                        String strJ = n4Var.J();
                                        if (n4Var.W()) {
                                            dValueOf = Double.valueOf(n4Var.D());
                                        } else {
                                            dValueOf = null;
                                        }
                                        aVar.put(strJ, dValueOf);
                                    }
                                } else {
                                    String strJ2 = n4Var.J();
                                    if (n4Var.Y()) {
                                        lValueOf = Long.valueOf(n4Var.G());
                                    } else {
                                        lValueOf = null;
                                    }
                                    aVar.put(strJ2, lValueOf);
                                }
                            }
                        }
                    }
                } else {
                    b3Var2 = (com.google.android.gms.internal.measurement.b3) it.next();
                    if (b3Var2.H().isEmpty()) {
                        this.f4902h.f4646a.d().w().b("null or empty param name in filter. event", this.f4902h.f4646a.D().d(strK));
                        break;
                    }
                    hashSet.add(b3Var2.H());
                }
            }
        } else {
            Boolean boolH2 = ib.h(j11, z2Var.I());
            if (boolH2 != null) {
                if (boolH2.booleanValue()) {
                    hashSet = new HashSet();
                    it = z2Var.K().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            aVar = new k.a();
                            it2 = j4Var.L().iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    it3 = z2Var.K().iterator();
                                    while (true) {
                                        if (it3.hasNext()) {
                                            bool = Boolean.TRUE;
                                            break;
                                        }
                                        b3Var = (com.google.android.gms.internal.measurement.b3) it3.next();
                                        if (b3Var.K()) {
                                            z11 = false;
                                        } else {
                                            z11 = false;
                                        }
                                        strH = b3Var.H();
                                        if (strH.isEmpty()) {
                                            obj = aVar.get(strH);
                                            if (obj instanceof Long) {
                                                if (obj instanceof Double) {
                                                    if (obj instanceof String) {
                                                        if (obj == null) {
                                                            this.f4902h.f4646a.d().w().c("Unknown param type. event, param", this.f4902h.f4646a.D().d(strK), this.f4902h.f4646a.D().e(strH));
                                                            break;
                                                        }
                                                        this.f4902h.f4646a.d().v().c("Missing param for filter. event, param", this.f4902h.f4646a.D().d(strK), this.f4902h.f4646a.D().e(strH));
                                                        bool = Boolean.FALSE;
                                                        break;
                                                    }
                                                    if (b3Var.N()) {
                                                        if (b3Var.L()) {
                                                            this.f4902h.f4646a.d().w().c("No filter for String param. event, param", this.f4902h.f4646a.D().d(strK), this.f4902h.f4646a.D().e(strH));
                                                            break;
                                                        }
                                                        str = (String) obj;
                                                        if (ra.P(str)) {
                                                            this.f4902h.f4646a.d().w().c("Invalid param value for number filter. event, param", this.f4902h.f4646a.D().d(strK), this.f4902h.f4646a.D().e(strH));
                                                            break;
                                                        }
                                                        boolI = ib.i(str, b3Var.F());
                                                    } else {
                                                        boolI = ib.f((String) obj, b3Var.G(), this.f4902h.f4646a.d());
                                                    }
                                                    if (boolI != null) {
                                                        break;
                                                        break;
                                                    }
                                                    if (boolI.booleanValue() == z11) {
                                                        bool = Boolean.FALSE;
                                                        break;
                                                    }
                                                } else if (b3Var.L()) {
                                                    boolG = ib.g(((Double) obj).doubleValue(), b3Var.F());
                                                    if (boolG != null) {
                                                        break;
                                                        break;
                                                    }
                                                    if (boolG.booleanValue() == z11) {
                                                        bool = Boolean.FALSE;
                                                        break;
                                                    }
                                                } else {
                                                    this.f4902h.f4646a.d().w().c("No number filter for double param. event, param", this.f4902h.f4646a.D().d(strK), this.f4902h.f4646a.D().e(strH));
                                                    break;
                                                }
                                            } else if (b3Var.L()) {
                                                boolH = ib.h(((Long) obj).longValue(), b3Var.F());
                                                if (boolH != null) {
                                                    break;
                                                    break;
                                                }
                                                if (boolH.booleanValue() == z11) {
                                                    bool = Boolean.FALSE;
                                                    break;
                                                }
                                            } else {
                                                this.f4902h.f4646a.d().w().c("No number filter for long param. event, param", this.f4902h.f4646a.D().d(strK), this.f4902h.f4646a.D().e(strH));
                                                break;
                                            }
                                        } else {
                                            this.f4902h.f4646a.d().w().b("Event has empty param name. event", this.f4902h.f4646a.D().d(strK));
                                            break;
                                        }
                                    }
                                } else {
                                    n4Var = (com.google.android.gms.internal.measurement.n4) it2.next();
                                    if (!hashSet.contains(n4Var.J())) {
                                        if (n4Var.Y()) {
                                            if (n4Var.W()) {
                                                if (n4Var.a0()) {
                                                    this.f4902h.f4646a.d().w().c("Unknown value for param. event, param", this.f4902h.f4646a.D().d(strK), this.f4902h.f4646a.D().e(n4Var.J()));
                                                    break;
                                                }
                                                aVar.put(n4Var.J(), n4Var.K());
                                            } else {
                                                String strJ3 = n4Var.J();
                                                if (n4Var.W()) {
                                                    dValueOf = Double.valueOf(n4Var.D());
                                                } else {
                                                    dValueOf = null;
                                                }
                                                aVar.put(strJ3, dValueOf);
                                            }
                                        } else {
                                            String strJ4 = n4Var.J();
                                            if (n4Var.Y()) {
                                                lValueOf = Long.valueOf(n4Var.G());
                                            } else {
                                                lValueOf = null;
                                            }
                                            aVar.put(strJ4, lValueOf);
                                        }
                                    }
                                }
                            }
                        } else {
                            b3Var2 = (com.google.android.gms.internal.measurement.b3) it.next();
                            if (b3Var2.H().isEmpty()) {
                                this.f4902h.f4646a.d().w().b("null or empty param name in filter. event", this.f4902h.f4646a.D().d(strK));
                                break;
                            }
                            hashSet.add(b3Var2.H());
                        }
                    }
                } else {
                    bool = Boolean.FALSE;
                }
            }
        }
        this.f4902h.f4646a.d().v().b("Event filter result", bool == null ? "null" : bool);
        if (bool == null) {
            return false;
        }
        Boolean bool2 = Boolean.TRUE;
        this.f4981c = bool2;
        if (!bool.booleanValue()) {
            return true;
        }
        this.f4982d = bool2;
        if (z12 && j4Var.W()) {
            Long lValueOf2 = Long.valueOf(j4Var.G());
            if (this.f4901g.O()) {
                if (!zB || !this.f4901g.Q()) {
                    l10 = lValueOf2;
                }
                this.f4984f = l10;
            } else {
                if (zB && this.f4901g.Q()) {
                    lValueOf2 = l11;
                }
                this.f4983e = lValueOf2;
            }
        }
        return true;
    }
}
