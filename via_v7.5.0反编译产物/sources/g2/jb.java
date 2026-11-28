package g2;

import com.google.android.gms.internal.measurement.cc;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class jb extends ib {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.google.android.gms.internal.measurement.i3 f5012g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ b f5013h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jb(b bVar, String str, int i10, com.google.android.gms.internal.measurement.i3 i3Var) {
        super(str, i10);
        this.f5013h = bVar;
        this.f5012g = i3Var;
    }

    @Override // g2.ib
    public final int a() {
        return this.f5012g.D();
    }

    @Override // g2.ib
    public final boolean b() {
        return false;
    }

    @Override // g2.ib
    public final boolean c() {
        return true;
    }

    public final boolean k(Long l10, Long l11, com.google.android.gms.internal.measurement.d5 d5Var, boolean z10) {
        cc.b();
        boolean zB = this.f5013h.f4646a.z().B(this.f4979a, i3.Y);
        boolean zJ = this.f5012g.J();
        boolean zK = this.f5012g.K();
        boolean zL = this.f5012g.L();
        boolean z11 = zJ || zK || zL;
        Boolean boolJ = null;
        boolJ = null;
        boolJ = null;
        boolJ = null;
        boolJ = null;
        if (z10 && !z11) {
            this.f5013h.f4646a.d().v().c("Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(this.f4980b), this.f5012g.M() ? Integer.valueOf(this.f5012g.D()) : null);
            return true;
        }
        com.google.android.gms.internal.measurement.b3 b3VarE = this.f5012g.E();
        boolean zJ2 = b3VarE.J();
        if (d5Var.T()) {
            if (b3VarE.L()) {
                boolJ = ib.j(ib.h(d5Var.E(), b3VarE.F()), zJ2);
            } else {
                this.f5013h.f4646a.d().w().b("No number filter for long property. property", this.f5013h.f4646a.D().f(d5Var.I()));
            }
        } else if (d5Var.S()) {
            if (b3VarE.L()) {
                boolJ = ib.j(ib.g(d5Var.D(), b3VarE.F()), zJ2);
            } else {
                this.f5013h.f4646a.d().w().b("No number filter for double property. property", this.f5013h.f4646a.D().f(d5Var.I()));
            }
        } else if (!d5Var.V()) {
            this.f5013h.f4646a.d().w().b("User property has no value, property", this.f5013h.f4646a.D().f(d5Var.I()));
        } else if (b3VarE.N()) {
            boolJ = ib.j(ib.f(d5Var.J(), b3VarE.G(), this.f5013h.f4646a.d()), zJ2);
        } else if (!b3VarE.L()) {
            this.f5013h.f4646a.d().w().b("No string or number filter defined. property", this.f5013h.f4646a.D().f(d5Var.I()));
        } else if (ra.P(d5Var.J())) {
            boolJ = ib.j(ib.i(d5Var.J(), b3VarE.F()), zJ2);
        } else {
            this.f5013h.f4646a.d().w().c("Invalid user property value for Numeric number filter. property, value", this.f5013h.f4646a.D().f(d5Var.I()), d5Var.J());
        }
        this.f5013h.f4646a.d().v().b("Property filter result", boolJ == null ? "null" : boolJ);
        if (boolJ == null) {
            return false;
        }
        this.f4981c = Boolean.TRUE;
        if (zL && !boolJ.booleanValue()) {
            return true;
        }
        if (!z10 || this.f5012g.J()) {
            this.f4982d = boolJ;
        }
        if (boolJ.booleanValue() && z11 && d5Var.U()) {
            long jF = d5Var.F();
            if (l10 != null) {
                jF = l10.longValue();
            }
            if (zB && this.f5012g.J() && !this.f5012g.K() && l11 != null) {
                jF = l11.longValue();
            }
            if (this.f5012g.K()) {
                this.f4984f = Long.valueOf(jF);
            } else {
                this.f4983e = Long.valueOf(jF);
            }
        }
        return true;
    }
}
