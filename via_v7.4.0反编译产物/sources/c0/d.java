package c0;

import c0.b;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class d extends b {
    public e A;
    public float B;
    public boolean C;

    public d(Object obj, c cVar) {
        super(obj, cVar);
        this.A = null;
        this.B = Float.MAX_VALUE;
        this.C = false;
    }

    @Override // c0.b
    public void j() {
        n();
        this.A.g(e());
        super.j();
    }

    @Override // c0.b
    public boolean l(long j10) {
        if (this.C) {
            float f10 = this.B;
            if (f10 != Float.MAX_VALUE) {
                this.A.e(f10);
                this.B = Float.MAX_VALUE;
            }
            this.f2194b = this.A.a();
            this.f2193a = 0.0f;
            this.C = false;
            return true;
        }
        if (this.B != Float.MAX_VALUE) {
            this.A.a();
            long j11 = j10 / 2;
            b.o oVarH = this.A.h(this.f2194b, this.f2193a, j11);
            this.A.e(this.B);
            this.B = Float.MAX_VALUE;
            b.o oVarH2 = this.A.h(oVarH.f2205a, oVarH.f2206b, j11);
            this.f2194b = oVarH2.f2205a;
            this.f2193a = oVarH2.f2206b;
        } else {
            b.o oVarH3 = this.A.h(this.f2194b, this.f2193a, j10);
            this.f2194b = oVarH3.f2205a;
            this.f2193a = oVarH3.f2206b;
        }
        float fMax = Math.max(this.f2194b, this.f2200h);
        this.f2194b = fMax;
        float fMin = Math.min(fMax, this.f2199g);
        this.f2194b = fMin;
        if (!m(fMin, this.f2193a)) {
            return false;
        }
        this.f2194b = this.A.a();
        this.f2193a = 0.0f;
        return true;
    }

    public boolean m(float f10, float f11) {
        return this.A.c(f10, f11);
    }

    public final void n() {
        e eVar = this.A;
        if (eVar == null) {
            throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
        }
        double dA = eVar.a();
        if (dA > this.f2199g) {
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        }
        if (dA < this.f2200h) {
            throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
        }
    }

    public d o(e eVar) {
        this.A = eVar;
        return this;
    }
}
