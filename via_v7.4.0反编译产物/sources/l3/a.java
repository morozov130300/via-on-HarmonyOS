package l3;

import j3.j;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    public static final long f8393d = TimeUnit.HOURS.toMillis(24);

    /* renamed from: e, reason: collision with root package name */
    public static final long f8394e = TimeUnit.MINUTES.toMillis(30);

    /* renamed from: a, reason: collision with root package name */
    public final j f8395a = j.c();

    /* renamed from: b, reason: collision with root package name */
    public long f8396b;

    /* renamed from: c, reason: collision with root package name */
    public int f8397c;

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
            return f8393d;
        }
        double dPow = Math.pow(2.0d, this.f8397c);
        double dE = this.f8395a.e();
        Double.isNaN(dE);
        return (long) Math.min(dPow + dE, f8394e);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean b() {
        boolean z10;
        if (this.f8397c != 0) {
            z10 = this.f8395a.a() > this.f8396b;
        }
        return z10;
    }

    public final synchronized void e() {
        this.f8397c = 0;
    }

    public synchronized void f(int i10) {
        if (d(i10)) {
            e();
            return;
        }
        this.f8397c++;
        this.f8396b = this.f8395a.a() + a(i10);
    }
}
