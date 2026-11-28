package ob;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.n;
import mark.via.common.rx.AutoDisposeViewModel;
import x8.c1;
import x8.t1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class m extends AutoDisposeViewModel {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final n f11103f = new n();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final n f11104g = new n();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public qb.f f11105h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f11106i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f11107j;

    public void l() {
        this.f11104g.m(null);
    }

    public final String m() {
        String strN = c1.n(this.f11107j);
        if (strN.isEmpty()) {
            return strN;
        }
        if (strN.charAt(0) != '/') {
            strN = '/' + strN;
        }
        return (strN.length() <= 1 || strN.charAt(strN.length() - 1) != '/') ? strN : strN.substring(0, strN.length() - 1);
    }

    public qb.f n() {
        if (this.f11105h == null) {
            if (x8.f.h()) {
                this.f11105h = new qb.f("https://dav.jianguoyun.com/dav/", "", "", false, null);
            } else {
                this.f11105h = new qb.f();
            }
        }
        return this.f11105h;
    }

    public LiveData o() {
        return this.f11103f;
    }

    public String p() {
        return this.f11107j;
    }

    public LiveData q() {
        return this.f11104g;
    }

    public boolean r() {
        return this.f11106i;
    }

    public void s(String str, String str2) {
        this.f11104g.m(new qb.f(str, str2, null, this.f11106i, m()));
    }

    public void t(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        qb.f fVarN = n();
        if (t1.a(fVarN.c(), str) && t1.a(fVarN.f(), str2) && (str3 == null || str3.isEmpty())) {
            str3 = fVarN.d();
        }
        this.f11104g.m(new qb.f(str, str2, str3, this.f11106i, m()));
    }

    public void u(qb.f fVar) {
        this.f11105h = fVar;
        if (fVar != null) {
            v(fVar.g());
            x(fVar.e());
        } else {
            v(false);
            x(null);
        }
    }

    public void v(boolean z10) {
        this.f11106i = z10;
    }

    public void w(int i10) {
        this.f11103f.m(Integer.valueOf(i10));
    }

    public void x(String str) {
        this.f11107j = str;
    }
}
