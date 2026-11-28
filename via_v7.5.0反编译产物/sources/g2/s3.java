package g2;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class s3 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5281c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f5282e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f5283m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f5284n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Object f5285o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ v3 f5286p;

    public s3(v3 v3Var, int i10, String str, Object obj, Object obj2, Object obj3) {
        this.f5286p = v3Var;
        this.f5281c = i10;
        this.f5282e = str;
        this.f5283m = obj;
        this.f5284n = obj2;
        this.f5285o = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        l4 l4VarF = this.f5286p.f4646a.F();
        if (!l4VarF.n()) {
            Log.println(6, this.f5286p.D(), "Persisted config not initialized. Not logging error/warn");
            return;
        }
        v3 v3Var = this.f5286p;
        if (v3Var.f5363c == 0) {
            if (v3Var.f4646a.z().H()) {
                v3 v3Var2 = this.f5286p;
                v3Var2.f4646a.b();
                v3Var2.f5363c = 'C';
            } else {
                v3 v3Var3 = this.f5286p;
                v3Var3.f4646a.b();
                v3Var3.f5363c = 'c';
            }
        }
        v3 v3Var4 = this.f5286p;
        if (v3Var4.f5364d < 0) {
            v3Var4.f4646a.z().q();
            v3Var4.f5364d = 79000L;
        }
        char cCharAt = "01VDIWEA?".charAt(this.f5281c);
        v3 v3Var5 = this.f5286p;
        String strSubstring = "2" + cCharAt + v3Var5.f5363c + v3Var5.f5364d + ":" + v3.A(true, this.f5282e, this.f5283m, this.f5284n, this.f5285o);
        if (strSubstring.length() > 1024) {
            strSubstring = this.f5282e.substring(0, 1024);
        }
        j4 j4Var = l4VarF.f5046d;
        if (j4Var != null) {
            j4Var.b(strSubstring, 1L);
        }
    }
}
