package f2;

import android.content.SharedPreferences;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class h4 {

    /* renamed from: a, reason: collision with root package name */
    public final String f5241a;

    /* renamed from: b, reason: collision with root package name */
    public final long f5242b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f5243c;

    /* renamed from: d, reason: collision with root package name */
    public long f5244d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ l4 f5245e;

    public h4(l4 l4Var, String str, long j10) {
        this.f5245e = l4Var;
        t1.f.d(str);
        this.f5241a = str;
        this.f5242b = j10;
    }

    public final long a() {
        if (!this.f5243c) {
            this.f5243c = true;
            this.f5244d = this.f5245e.o().getLong(this.f5241a, this.f5242b);
        }
        return this.f5244d;
    }

    public final void b(long j10) {
        SharedPreferences.Editor editorEdit = this.f5245e.o().edit();
        editorEdit.putLong(this.f5241a, j10);
        editorEdit.apply();
        this.f5244d = j10;
    }
}
