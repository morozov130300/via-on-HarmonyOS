package f2;

import com.google.android.gms.internal.measurement.cc;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class jb extends ib {

    /* renamed from: g, reason: collision with root package name */
    public final com.google.android.gms.internal.measurement.i3 f5396g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ b f5397h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jb(b bVar, String str, int i10, com.google.android.gms.internal.measurement.i3 i3Var) {
        super(str, i10);
        this.f5397h = bVar;
        this.f5396g = i3Var;
    }

    @Override // f2.ib
    public final int a() {
        return this.f5396g.D();
    }

    @Override // f2.ib
    public final boolean b() {
        return false;
    }

    @Override // f2.ib
    public final boolean c() {
        return true;
    }

    public final boolean k(Long l10, Long l11, com.google.android.gms.internal.measurement.d5 d5Var, boolean z10) {
        cc.b();
        boolean zB = this.f5397h.f5030a.z().B(this.f5363a, i3.Y);
        boolean zJ = this.f5396g.J();
        boolean zK = this.f5396g.K();
        boolean zL = this.f5396g.L();
        boolean z11 = zJ || zK || zL;
        Boolean boolJ = null;
        boolJ = null;
        boolJ = null;
        boolJ = null;
        boolJ = null;
        if (z10 && !z11) {
            this.f5397h.f5030a.d().v().c("Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(this.f5364b), this.f5396g.M() ? Integer.valueOf(this.f5396g.D()) : null);
            return true;
        }
        com.google.android.gms.internal.measurement.b3 b3VarE = this.f5396g.E();
        boolean zJ2 = b3VarE.J();
        if (d5Var.T()) {
            if (b3VarE.L()) {
                boolJ = ib.j(ib.h(d5Var.E(), b3VarE.F()), zJ2);
            } else {
                this.f5397h.f5030a.d().w().b("No number filter for long property. property", this.f5397h.f5030a.D().f(d5Var.I()));
            }
        } else if (d5Var.S()) {
            if (b3VarE.L()) {
                boolJ = ib.j(ib.g(d5Var.D(), b3VarE.F()), zJ2);
            } else {
                this.f5397h.f5030a.d().w().b("No number filter for double property. property", this.f5397h.f5030a.D().f(d5Var.I()));
            }
        } else if (!d5Var.V()) {
            this.f5397h.f5030a.d().w().b("User property has no value, property", this.f5397h.f5030a.D().f(d5Var.I()));
        } else if (b3VarE.N()) {
            boolJ = ib.j(ib.f(d5Var.J(), b3VarE.G(), this.f5397h.f5030a.d()), zJ2);
        } else if (!b3VarE.L()) {
            this.f5397h.f5030a.d().w().b("No string or number filter defined. property", this.f5397h.f5030a.D().f(d5Var.I()));
        } else if (ra.P(d5Var.J())) {
            boolJ = ib.j(ib.i(d5Var.J(), b3VarE.F()), zJ2);
        } else {
            this.f5397h.f5030a.d().w().c("Invalid user property value for Numeric number filter. property, value", this.f5397h.f5030a.D().f(d5Var.I()), d5Var.J());
        }
        this.f5397h.f5030a.d().v().b("Property filter result", boolJ == null ? "null" : boolJ);
        if (boolJ == null) {
            return false;
        }
        this.f5365c = Boolean.TRUE;
        if (zL && !boolJ.booleanValue()) {
            return true;
        }
        if (!z10 || this.f5396g.J()) {
            this.f5366d = boolJ;
        }
        if (boolJ.booleanValue() && z11 && d5Var.U()) {
            long jF = d5Var.F();
            if (l10 != null) {
                jF = l10.longValue();
            }
            if (zB && this.f5396g.J() && !this.f5396g.K() && l11 != null) {
                jF = l11.longValue();
            }
            if (this.f5396g.K()) {
                this.f5368f = Long.valueOf(jF);
            } else {
                this.f5367e = Long.valueOf(jF);
            }
        }
        return true;
    }
}
