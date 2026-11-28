package d0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
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

    @Override // d0.b
    public void j() {
        n();
        this.A.g(e());
        super.j();
    }

    @Override // d0.b
    public boolean l(long j10) {
        if (this.C) {
            float f10 = this.B;
            if (f10 != Float.MAX_VALUE) {
                this.A.e(f10);
                this.B = Float.MAX_VALUE;
            }
            this.f3821b = this.A.a();
            this.f3820a = 0.0f;
            this.C = false;
            return true;
        }
        if (this.B != Float.MAX_VALUE) {
            this.A.a();
            long j11 = j10 / 2;
            b.o oVarH = this.A.h(this.f3821b, this.f3820a, j11);
            this.A.e(this.B);
            this.B = Float.MAX_VALUE;
            b.o oVarH2 = this.A.h(oVarH.f3832a, oVarH.f3833b, j11);
            this.f3821b = oVarH2.f3832a;
            this.f3820a = oVarH2.f3833b;
        } else {
            b.o oVarH3 = this.A.h(this.f3821b, this.f3820a, j10);
            this.f3821b = oVarH3.f3832a;
            this.f3820a = oVarH3.f3833b;
        }
        float fMax = Math.max(this.f3821b, this.f3827h);
        this.f3821b = fMax;
        float fMin = Math.min(fMax, this.f3826g);
        this.f3821b = fMin;
        if (!m(fMin, this.f3820a)) {
            return false;
        }
        this.f3821b = this.A.a();
        this.f3820a = 0.0f;
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
        if (dA > this.f3826g) {
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        }
        if (dA < this.f3827h) {
            throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
        }
    }

    public d o(e eVar) {
        this.A = eVar;
        return this;
    }
}
