package f2;

import android.util.Log;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class s3 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f5665e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ String f5666j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f5667k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f5668l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f5669m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ v3 f5670n;

    public s3(v3 v3Var, int i10, String str, Object obj, Object obj2, Object obj3) {
        this.f5670n = v3Var;
        this.f5665e = i10;
        this.f5666j = str;
        this.f5667k = obj;
        this.f5668l = obj2;
        this.f5669m = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        l4 l4VarF = this.f5670n.f5030a.F();
        if (!l4VarF.n()) {
            Log.println(6, this.f5670n.D(), "Persisted config not initialized. Not logging error/warn");
            return;
        }
        v3 v3Var = this.f5670n;
        if (v3Var.f5747c == 0) {
            if (v3Var.f5030a.z().H()) {
                v3 v3Var2 = this.f5670n;
                v3Var2.f5030a.b();
                v3Var2.f5747c = 'C';
            } else {
                v3 v3Var3 = this.f5670n;
                v3Var3.f5030a.b();
                v3Var3.f5747c = 'c';
            }
        }
        v3 v3Var4 = this.f5670n;
        if (v3Var4.f5748d < 0) {
            v3Var4.f5030a.z().q();
            v3Var4.f5748d = 79000L;
        }
        char cCharAt = "01VDIWEA?".charAt(this.f5665e);
        v3 v3Var5 = this.f5670n;
        String strSubstring = "2" + cCharAt + v3Var5.f5747c + v3Var5.f5748d + ":" + v3.A(true, this.f5666j, this.f5667k, this.f5668l, this.f5669m);
        if (strSubstring.length() > 1024) {
            strSubstring = this.f5666j.substring(0, 1024);
        }
        j4 j4Var = l4VarF.f5430d;
        if (j4Var != null) {
            j4Var.b(strSubstring, 1L);
        }
    }
}
