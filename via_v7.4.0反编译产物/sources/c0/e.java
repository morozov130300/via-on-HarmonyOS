package c0;

import c0.b;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: d, reason: collision with root package name */
    public double f2211d;

    /* renamed from: e, reason: collision with root package name */
    public double f2212e;

    /* renamed from: f, reason: collision with root package name */
    public double f2213f;

    /* renamed from: g, reason: collision with root package name */
    public double f2214g;

    /* renamed from: h, reason: collision with root package name */
    public double f2215h;

    /* renamed from: a, reason: collision with root package name */
    public double f2208a = Math.sqrt(1500.0d);

    /* renamed from: b, reason: collision with root package name */
    public double f2209b = 0.5d;

    /* renamed from: c, reason: collision with root package name */
    public boolean f2210c = false;

    /* renamed from: i, reason: collision with root package name */
    public double f2216i = Double.MAX_VALUE;

    /* renamed from: j, reason: collision with root package name */
    public final b.o f2217j = new b.o();

    public float a() {
        return (float) this.f2216i;
    }

    public final void b() {
        if (this.f2210c) {
            return;
        }
        if (this.f2216i == Double.MAX_VALUE) {
            throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
        }
        double d10 = this.f2209b;
        if (d10 > 1.0d) {
            double d11 = this.f2208a;
            this.f2213f = ((-d10) * d11) + (d11 * Math.sqrt((d10 * d10) - 1.0d));
            double d12 = this.f2209b;
            double d13 = this.f2208a;
            this.f2214g = ((-d12) * d13) - (d13 * Math.sqrt((d12 * d12) - 1.0d));
        } else if (d10 >= 0.0d && d10 < 1.0d) {
            this.f2215h = this.f2208a * Math.sqrt(1.0d - (d10 * d10));
        }
        this.f2210c = true;
    }

    public boolean c(float f10, float f11) {
        return ((double) Math.abs(f11)) < this.f2212e && ((double) Math.abs(f10 - a())) < this.f2211d;
    }

    public e d(float f10) {
        if (f10 < 0.0f) {
            throw new IllegalArgumentException("Damping ratio must be non-negative");
        }
        this.f2209b = f10;
        this.f2210c = false;
        return this;
    }

    public e e(float f10) {
        this.f2216i = f10;
        return this;
    }

    public e f(float f10) {
        if (f10 <= 0.0f) {
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        this.f2208a = Math.sqrt(f10);
        this.f2210c = false;
        return this;
    }

    public void g(double d10) {
        double dAbs = Math.abs(d10);
        this.f2211d = dAbs;
        this.f2212e = dAbs * 62.5d;
    }

    public b.o h(double d10, double d11, long j10) {
        double dPow;
        double dCos;
        b();
        double d12 = j10;
        Double.isNaN(d12);
        double d13 = d12 / 1000.0d;
        double d14 = d10 - this.f2216i;
        double d15 = this.f2209b;
        if (d15 > 1.0d) {
            double d16 = this.f2214g;
            double d17 = this.f2213f;
            double d18 = d14 - (((d16 * d14) - d11) / (d16 - d17));
            double d19 = ((d14 * d16) - d11) / (d16 - d17);
            dPow = (Math.pow(2.718281828459045d, d16 * d13) * d18) + (Math.pow(2.718281828459045d, this.f2213f * d13) * d19);
            double d20 = this.f2214g;
            double dPow2 = d18 * d20 * Math.pow(2.718281828459045d, d20 * d13);
            double d21 = this.f2213f;
            dCos = dPow2 + (d19 * d21 * Math.pow(2.718281828459045d, d21 * d13));
        } else if (d15 == 1.0d) {
            double d22 = this.f2208a;
            double d23 = d11 + (d22 * d14);
            double d24 = d14 + (d23 * d13);
            dPow = Math.pow(2.718281828459045d, (-d22) * d13) * d24;
            double dPow3 = d24 * Math.pow(2.718281828459045d, (-this.f2208a) * d13);
            double d25 = this.f2208a;
            dCos = (d23 * Math.pow(2.718281828459045d, (-d25) * d13)) + (dPow3 * (-d25));
        } else {
            double d26 = 1.0d / this.f2215h;
            double d27 = this.f2208a;
            double d28 = d26 * ((d15 * d27 * d14) + d11);
            dPow = Math.pow(2.718281828459045d, (-d15) * d27 * d13) * ((Math.cos(this.f2215h * d13) * d14) + (Math.sin(this.f2215h * d13) * d28));
            double d29 = this.f2208a;
            double d30 = this.f2209b;
            double d31 = (-d29) * dPow * d30;
            double dPow4 = Math.pow(2.718281828459045d, (-d30) * d29 * d13);
            double d32 = this.f2215h;
            double dSin = (-d32) * d14 * Math.sin(d32 * d13);
            double d33 = this.f2215h;
            dCos = d31 + (dPow4 * (dSin + (d28 * d33 * Math.cos(d33 * d13))));
        }
        b.o oVar = this.f2217j;
        oVar.f2205a = (float) (dPow + this.f2216i);
        oVar.f2206b = (float) dCos;
        return oVar;
    }
}
