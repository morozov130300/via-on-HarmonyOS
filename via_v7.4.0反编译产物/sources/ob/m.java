package ob;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import mark.via.common.rx.AutoDisposeViewModel;
import z8.c1;
import z8.u1;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class m extends AutoDisposeViewModel {

    /* renamed from: f, reason: collision with root package name */
    public final androidx.lifecycle.l f10517f = new androidx.lifecycle.l();

    /* renamed from: g, reason: collision with root package name */
    public final androidx.lifecycle.l f10518g = new androidx.lifecycle.l();

    /* renamed from: h, reason: collision with root package name */
    public qb.f f10519h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f10520i;

    /* renamed from: j, reason: collision with root package name */
    public String f10521j;

    public void l() {
        this.f10518g.m(null);
    }

    public final String m() {
        String strM = c1.m(this.f10521j);
        if (strM.isEmpty()) {
            return strM;
        }
        if (strM.charAt(0) != '/') {
            strM = '/' + strM;
        }
        return (strM.length() <= 1 || strM.charAt(strM.length() - 1) != '/') ? strM : strM.substring(0, strM.length() - 1);
    }

    public qb.f n() {
        if (this.f10519h == null) {
            if (z8.f.h()) {
                this.f10519h = new qb.f("https://dav.jianguoyun.com/dav/", "", "", false, null);
            } else {
                this.f10519h = new qb.f();
            }
        }
        return this.f10519h;
    }

    public LiveData o() {
        return this.f10517f;
    }

    public String p() {
        return this.f10521j;
    }

    public LiveData q() {
        return this.f10518g;
    }

    public boolean r() {
        return this.f10520i;
    }

    public void s(String str, String str2) {
        this.f10518g.m(new qb.f(str, str2, null, this.f10520i, m()));
    }

    public void t(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        qb.f fVarN = n();
        if (u1.a(fVarN.c(), str) && u1.a(fVarN.f(), str2) && (str3 == null || str3.isEmpty())) {
            str3 = fVarN.d();
        }
        this.f10518g.m(new qb.f(str, str2, str3, this.f10520i, m()));
    }

    public void u(qb.f fVar) {
        this.f10519h = fVar;
        if (fVar != null) {
            v(fVar.g());
            x(fVar.e());
        } else {
            v(false);
            x(null);
        }
    }

    public void v(boolean z10) {
        this.f10520i = z10;
    }

    public void w(int i10) {
        this.f10517f.m(Integer.valueOf(i10));
    }

    public void x(String str) {
        this.f10521j = str;
    }
}
