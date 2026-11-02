package f2;

import android.content.SharedPreferences;
import android.util.Pair;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class j4 {

    /* renamed from: a, reason: collision with root package name */
    public final String f5373a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5374b;

    /* renamed from: c, reason: collision with root package name */
    public final String f5375c;

    /* renamed from: d, reason: collision with root package name */
    public final long f5376d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ l4 f5377e;

    public /* synthetic */ j4(l4 l4Var, String str, long j10, i4 i4Var) {
        this.f5377e = l4Var;
        t1.f.d("health_monitor");
        t1.f.a(j10 > 0);
        this.f5373a = "health_monitor:start";
        this.f5374b = "health_monitor:count";
        this.f5375c = "health_monitor:value";
        this.f5376d = j10;
    }

    public final Pair a() {
        long jAbs;
        this.f5377e.h();
        this.f5377e.h();
        long jC = c();
        if (jC == 0) {
            d();
            jAbs = 0;
        } else {
            jAbs = Math.abs(jC - this.f5377e.f5030a.a().a());
        }
        long j10 = this.f5376d;
        if (jAbs < j10) {
            return null;
        }
        if (jAbs > j10 + j10) {
            d();
            return null;
        }
        String string = this.f5377e.o().getString(this.f5375c, null);
        long j11 = this.f5377e.o().getLong(this.f5374b, 0L);
        d();
        return (string == null || j11 <= 0) ? l4.f5428y : new Pair(string, Long.valueOf(j11));
    }

    public final void b(String str, long j10) {
        this.f5377e.h();
        if (c() == 0) {
            d();
        }
        if (str == null) {
            str = "";
        }
        long j11 = this.f5377e.o().getLong(this.f5374b, 0L);
        if (j11 <= 0) {
            SharedPreferences.Editor editorEdit = this.f5377e.o().edit();
            editorEdit.putString(this.f5375c, str);
            editorEdit.putLong(this.f5374b, 1L);
            editorEdit.apply();
            return;
        }
        long jNextLong = this.f5377e.f5030a.N().u().nextLong() & Long.MAX_VALUE;
        long j12 = j11 + 1;
        long j13 = Long.MAX_VALUE / j12;
        SharedPreferences.Editor editorEdit2 = this.f5377e.o().edit();
        if (jNextLong < j13) {
            editorEdit2.putString(this.f5375c, str);
        }
        editorEdit2.putLong(this.f5374b, j12);
        editorEdit2.apply();
    }

    public final long c() {
        return this.f5377e.o().getLong(this.f5373a, 0L);
    }

    public final void d() {
        this.f5377e.h();
        long jA = this.f5377e.f5030a.a().a();
        SharedPreferences.Editor editorEdit = this.f5377e.o().edit();
        editorEdit.remove(this.f5374b);
        editorEdit.remove(this.f5375c);
        editorEdit.putLong(this.f5373a, jA);
        editorEdit.apply();
    }
}
