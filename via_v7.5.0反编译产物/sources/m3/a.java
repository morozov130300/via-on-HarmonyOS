package m3;

import java.util.concurrent.TimeUnit;
import k3.j;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f7867d = TimeUnit.HOURS.toMillis(24);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f7868e = TimeUnit.MINUTES.toMillis(30);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f7869a = j.c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f7870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7871c;

    public static boolean c(int i10) {
        if (i10 != 429) {
            return i10 >= 500 && i10 < 600;
        }
        return true;
    }

    public static boolean d(int i10) {
        return (i10 >= 200 && i10 < 300) || i10 == 401 || i10 == 404;
    }

    public final synchronized long a(int i10) {
        if (!c(i10)) {
            return f7867d;
        }
        double dPow = Math.pow(2.0d, this.f7871c);
        double dE = this.f7869a.e();
        Double.isNaN(dE);
        return (long) Math.min(dPow + dE, f7868e);
    }

    public synchronized boolean b() {
        return this.f7871c == 0 || this.f7869a.a() > this.f7870b;
    }

    public final synchronized void e() {
        this.f7871c = 0;
    }

    public synchronized void f(int i10) {
        if (d(i10)) {
            e();
            return;
        }
        this.f7871c++;
        this.f7870b = this.f7869a.a() + a(i10);
    }
}
