package d0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f3838d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public double f3839e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public double f3840f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public double f3841g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public double f3842h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f3835a = Math.sqrt(1500.0d);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f3836b = 0.5d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3837c = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public double f3843i = Double.MAX_VALUE;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b.o f3844j = new b.o();

    public float a() {
        return (float) this.f3843i;
    }

    public final void b() {
        if (this.f3837c) {
            return;
        }
        if (this.f3843i == Double.MAX_VALUE) {
            throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
        }
        double d10 = this.f3836b;
        if (d10 > 1.0d) {
            double d11 = this.f3835a;
            this.f3840f = ((-d10) * d11) + (d11 * Math.sqrt((d10 * d10) - 1.0d));
            double d12 = this.f3836b;
            double d13 = this.f3835a;
            this.f3841g = ((-d12) * d13) - (d13 * Math.sqrt((d12 * d12) - 1.0d));
        } else if (d10 >= 0.0d && d10 < 1.0d) {
            this.f3842h = this.f3835a * Math.sqrt(1.0d - (d10 * d10));
        }
        this.f3837c = true;
    }

    public boolean c(float f10, float f11) {
        return ((double) Math.abs(f11)) < this.f3839e && ((double) Math.abs(f10 - a())) < this.f3838d;
    }

    public e d(float f10) {
        if (f10 < 0.0f) {
            throw new IllegalArgumentException("Damping ratio must be non-negative");
        }
        this.f3836b = f10;
        this.f3837c = false;
        return this;
    }

    public e e(float f10) {
        this.f3843i = f10;
        return this;
    }

    public e f(float f10) {
        if (f10 <= 0.0f) {
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        this.f3835a = Math.sqrt(f10);
        this.f3837c = false;
        return this;
    }

    public void g(double d10) {
        double dAbs = Math.abs(d10);
        this.f3838d = dAbs;
        this.f3839e = dAbs * 62.5d;
    }

    public b.o h(double d10, double d11, long j10) {
        double dPow;
        double dCos;
        b();
        double d12 = j10;
        Double.isNaN(d12);
        double d13 = d12 / 1000.0d;
        double d14 = d10 - this.f3843i;
        double d15 = this.f3836b;
        if (d15 > 1.0d) {
            double d16 = this.f3841g;
            double d17 = this.f3840f;
            double d18 = d14 - (((d16 * d14) - d11) / (d16 - d17));
            double d19 = ((d14 * d16) - d11) / (d16 - d17);
            dPow = (Math.pow(2.718281828459045d, d16 * d13) * d18) + (Math.pow(2.718281828459045d, this.f3840f * d13) * d19);
            double d20 = this.f3841g;
            double dPow2 = d18 * d20 * Math.pow(2.718281828459045d, d20 * d13);
            double d21 = this.f3840f;
            dCos = dPow2 + (d19 * d21 * Math.pow(2.718281828459045d, d21 * d13));
        } else if (d15 == 1.0d) {
            double d22 = this.f3835a;
            double d23 = d11 + (d22 * d14);
            double d24 = d14 + (d23 * d13);
            dPow = Math.pow(2.718281828459045d, (-d22) * d13) * d24;
            double dPow3 = d24 * Math.pow(2.718281828459045d, (-this.f3835a) * d13);
            double d25 = this.f3835a;
            dCos = (d23 * Math.pow(2.718281828459045d, (-d25) * d13)) + (dPow3 * (-d25));
        } else {
            double d26 = 1.0d / this.f3842h;
            double d27 = this.f3835a;
            double d28 = d26 * ((d15 * d27 * d14) + d11);
            dPow = Math.pow(2.718281828459045d, (-d15) * d27 * d13) * ((Math.cos(this.f3842h * d13) * d14) + (Math.sin(this.f3842h * d13) * d28));
            double d29 = this.f3835a;
            double d30 = this.f3836b;
            double d31 = (-d29) * dPow * d30;
            double dPow4 = Math.pow(2.718281828459045d, (-d30) * d29 * d13);
            double d32 = this.f3842h;
            double dSin = (-d32) * d14 * Math.sin(d32 * d13);
            double d33 = this.f3842h;
            dCos = d31 + (dPow4 * (dSin + (d28 * d33 * Math.cos(d33 * d13))));
        }
        b.o oVar = this.f3844j;
        oVar.f3832a = (float) (dPow + this.f3843i);
        oVar.f3833b = (float) dCos;
        return oVar;
    }
}
