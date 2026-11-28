package ta;

import android.net.Uri;
import androidx.lifecycle.LiveData;
import c6.a2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import mark.via.browser.kd;
import mark.via.common.rx.AutoDisposeViewModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import w7.e0;
import z7.j0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class c0 extends AutoDisposeViewModel {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final qa.c f12605f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f12606g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final androidx.lifecycle.n f12607h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LiveData f12608i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final androidx.lifecycle.n f12609j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LiveData f12610k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final androidx.lifecycle.n f12611l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public LiveData f12612m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final i8.n f12613n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public LiveData f12614o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final androidx.lifecycle.n f12615p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public LiveData f12616q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final androidx.lifecycle.n f12617r;

    public c0() {
        androidx.lifecycle.n nVar = new androidx.lifecycle.n();
        this.f12607h = nVar;
        this.f12608i = nVar;
        androidx.lifecycle.n nVar2 = new androidx.lifecycle.n();
        this.f12609j = nVar2;
        this.f12610k = nVar2;
        androidx.lifecycle.n nVar3 = new androidx.lifecycle.n();
        this.f12611l = nVar3;
        this.f12612m = nVar3;
        i8.n nVar4 = new i8.n();
        this.f12613n = nVar4;
        this.f12614o = nVar4;
        androidx.lifecycle.n nVar5 = new androidx.lifecycle.n();
        this.f12615p = nVar5;
        this.f12616q = nVar5;
        this.f12617r = new androidx.lifecycle.n();
        this.f12605f = kd.c().f();
    }

    public static /* synthetic */ List l(c0 c0Var, String str) {
        List listH = c0Var.f12605f.H(str);
        return listH == null ? new ArrayList() : listH;
    }

    public static /* synthetic */ HashMap n(String str) throws JSONException {
        HashMap map = new HashMap();
        JSONObject jSONObject = new JSONObject(str);
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray(next);
            int length = jSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                arrayList.add(jSONArray.getString(i10));
            }
            if (!arrayList.isEmpty()) {
                Collections.sort(arrayList);
                map.put(next, arrayList);
            }
        }
        return map;
    }

    public void A(final String str) {
        ((autodispose2.r) r6.q.f(new Callable() { // from class: ta.z
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return c0.n(str);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.c(this))).a(new u6.f() { // from class: ta.a0
            @Override // u6.f
            public final void accept(Object obj) {
                this.f12600c.f12617r.m((HashMap) obj);
            }
        }, new e0());
    }

    public void B(ra.c cVar, boolean z10) {
        if (cVar == null) {
            return;
        }
        cVar.n(z10);
        this.f12605f.l(cVar.e(), cVar.j());
    }

    public void C(String str) {
        this.f12606g = str;
        w(str);
    }

    public void o() {
        ra.c cVar = (ra.c) this.f12612m.e();
        if (cVar == null) {
            return;
        }
        cVar.n(!cVar.j());
        this.f12615p.m(Boolean.valueOf(cVar.j()));
        this.f12605f.l(cVar.e(), cVar.j());
    }

    public boolean p() {
        Uri uri;
        String encodedAuthority;
        int iR = r();
        if (iR <= 0 || !a2.f1958a.t(this.f12606g) || (encodedAuthority = (uri = Uri.parse(this.f12606g)).getEncodedAuthority()) == null || encodedAuthority.isEmpty()) {
            return false;
        }
        String strSubstring = encodedAuthority.substring(encodedAuthority.lastIndexOf(64) + 1);
        if (strSubstring.isEmpty()) {
            return false;
        }
        String str = uri.getScheme() + "://" + strSubstring + "/*";
        ra.e eVarO = this.f12605f.o(iR);
        if (eVarO == null) {
            eVarO = new ra.e();
        }
        List listB = ua.c.b(eVarO.b(), eVarO.c());
        if (listB.contains(str)) {
            return true;
        }
        listB.add(str);
        eVarO.h(ua.c.d(listB));
        return this.f12605f.m(iR, eVarO);
    }

    public LiveData q() {
        return this.f12617r;
    }

    public int r() {
        if (this.f12612m.e() == null) {
            return 0;
        }
        return ((ra.c) this.f12612m.e()).e();
    }

    public String s() {
        return this.f12605f.B(r());
    }

    public List t() {
        Map map;
        String strB = this.f12605f.B(r());
        if (strB == null || (map = (Map) this.f12617r.e()) == null) {
            return null;
        }
        return (List) map.get(strB);
    }

    public ra.c u() {
        return (ra.c) this.f12612m.e();
    }

    public String v() {
        return this.f12606g;
    }

    public void w(final String str) {
        autodispose2.r rVar = (autodispose2.r) r6.q.f(new Callable() { // from class: ta.b0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return c0.l(this.f12602c, str);
            }
        }).l(s8.b.c(this));
        androidx.lifecycle.n nVar = this.f12609j;
        Objects.requireNonNull(nVar);
        rVar.a(new j0(nVar), new w7.a0());
    }

    public void x(v5.q qVar) {
        this.f12613n.m(qVar);
    }

    public void y(ra.c cVar) {
        this.f12611l.m(cVar);
    }

    public void z(int i10) {
        this.f12607h.m(Integer.valueOf(i10));
    }
}
