package g2;

import android.content.SharedPreferences;
import android.util.Pair;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class j4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f4991c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f4992d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ l4 f4993e;

    public /* synthetic */ j4(l4 l4Var, String str, long j10, i4 i4Var) {
        this.f4993e = l4Var;
        u1.f.d("health_monitor");
        u1.f.a(j10 > 0);
        this.f4989a = "health_monitor:start";
        this.f4990b = "health_monitor:count";
        this.f4991c = "health_monitor:value";
        this.f4992d = j10;
    }

    public final Pair a() {
        long jAbs;
        this.f4993e.h();
        this.f4993e.h();
        long jC = c();
        if (jC == 0) {
            d();
            jAbs = 0;
        } else {
            jAbs = Math.abs(jC - this.f4993e.f4646a.a().a());
        }
        long j10 = this.f4992d;
        if (jAbs < j10) {
            return null;
        }
        if (jAbs > j10 + j10) {
            d();
            return null;
        }
        String string = this.f4993e.o().getString(this.f4991c, null);
        long j11 = this.f4993e.o().getLong(this.f4990b, 0L);
        d();
        return (string == null || j11 <= 0) ? l4.f5044y : new Pair(string, Long.valueOf(j11));
    }

    public final void b(String str, long j10) {
        this.f4993e.h();
        if (c() == 0) {
            d();
        }
        if (str == null) {
            str = "";
        }
        long j11 = this.f4993e.o().getLong(this.f4990b, 0L);
        if (j11 <= 0) {
            SharedPreferences.Editor editorEdit = this.f4993e.o().edit();
            editorEdit.putString(this.f4991c, str);
            editorEdit.putLong(this.f4990b, 1L);
            editorEdit.apply();
            return;
        }
        long jNextLong = this.f4993e.f4646a.N().u().nextLong() & Long.MAX_VALUE;
        long j12 = j11 + 1;
        long j13 = Long.MAX_VALUE / j12;
        SharedPreferences.Editor editorEdit2 = this.f4993e.o().edit();
        if (jNextLong < j13) {
            editorEdit2.putString(this.f4991c, str);
        }
        editorEdit2.putLong(this.f4990b, j12);
        editorEdit2.apply();
    }

    public final long c() {
        return this.f4993e.o().getLong(this.f4989a, 0L);
    }

    public final void d() {
        this.f4993e.h();
        long jA = this.f4993e.f4646a.a().a();
        SharedPreferences.Editor editorEdit = this.f4993e.o().edit();
        editorEdit.remove(this.f4990b);
        editorEdit.remove(this.f4991c);
        editorEdit.putLong(this.f4989a, jA);
        editorEdit.apply();
    }
}
