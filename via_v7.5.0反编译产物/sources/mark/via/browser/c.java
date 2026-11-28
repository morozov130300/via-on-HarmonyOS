package mark.via.browser;

import android.R;
import android.content.DialogInterface;
import android.view.View;
import android.webkit.WebView;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WebView f9039a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public q9.b f9041c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f9043e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f9044f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public q5.k f9045g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f9040b = new HashSet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f9042d = "";

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface a {
        void a(String str);

        void b(String str, String str2);
    }

    public c(WebView webView) {
        this.f9039a = webView;
    }

    public static /* synthetic */ void a(c cVar, long j10, q9.b bVar, String str, String str2, View view, q5.k.p pVar) {
        if (cVar.f9043e == j10 && cVar.f9041c == bVar) {
            a aVar = cVar.f9044f;
            bVar.b(c6.b.f1959a.c(str));
            cVar.n();
            aVar.b(str2, str);
        }
    }

    public static /* synthetic */ void b(c cVar, long j10, DialogInterface dialogInterface) {
        if (cVar.f9043e != j10) {
            return;
        }
        cVar.f9045g = null;
        Iterator it = cVar.f9040b.iterator();
        while (it.hasNext()) {
            ((q9.b) it.next()).b("window.__setMarkerPaused(false);");
        }
    }

    public static c f(WebView webView) {
        c cVar = (c) webView.getTag(w7.p.D0);
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c(webView);
        webView.setTag(w7.p.D0, cVar2);
        return cVar2;
    }

    public void c() {
        n();
        this.f9040b.clear();
    }

    public final void d(String str) {
        q9.b bVar;
        if (this.f9044f == null || (bVar = this.f9041c) == null || this.f9045g != null) {
            return;
        }
        bVar.b(str);
    }

    public void e() {
        d("window.__markParent();");
    }

    public void g(q9.b bVar, JSONObject jSONObject) {
        if (this.f9044f != null && this.f9045g == null && this.f9040b.contains(bVar) && jSONObject.optLong("session") == this.f9043e) {
            String strOptString = jSONObject.optString("filter");
            if (strOptString.isEmpty()) {
                return;
            }
            q9.b bVar2 = this.f9041c;
            if (bVar2 != null && bVar2 != bVar) {
                bVar2.b("window.__clearMarker();");
            }
            this.f9041c = bVar;
            this.f9042d = strOptString;
            this.f9044f.a(strOptString);
        }
    }

    public void h(q9.b bVar) {
        this.f9040b.add(bVar);
        if (this.f9044f != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("window.__setMarkerEnabled(true,");
            sb2.append(this.f9043e);
            sb2.append(");window.__setMarkerPaused(");
            sb2.append(this.f9045g != null);
            sb2.append(");");
            bVar.b(sb2.toString());
        }
    }

    public void i(q9.b bVar) {
        this.f9040b.remove(bVar);
        if (this.f9041c == bVar) {
            this.f9041c = null;
            this.f9042d = "";
            q5.k kVar = this.f9045g;
            if (kVar != null) {
                kVar.o();
            }
            a aVar = this.f9044f;
            if (aVar != null) {
                aVar.a("");
            }
        }
    }

    public void j() {
        final q9.b bVar;
        if (this.f9044f == null || (bVar = this.f9041c) == null || this.f9045g != null) {
            return;
        }
        final String str = this.f9042d;
        final String host = bVar.f9564c.getHost();
        final long j10 = this.f9043e;
        Iterator it = this.f9040b.iterator();
        while (it.hasNext()) {
            ((q9.b) it.next()).b("window.__setMarkerPaused(true);");
        }
        q5.k kVarW = q5.k.l(this.f9039a.getContext()).f0(w7.u.M).K(this.f9039a.getContext().getString(w7.u.H3) + "(" + str + ")").X(R.string.ok, new q5.k.m() { // from class: mark.via.browser.a
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                c.a(this.f8989a, j10, bVar, str, host, view, pVar);
            }
        }).P(R.string.cancel, null).W(new DialogInterface.OnDismissListener() { // from class: mark.via.browser.b
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                c.b(this.f9021c, j10, dialogInterface);
            }
        });
        this.f9045g = kVarW;
        kVarW.h0();
    }

    public void k(boolean z10) {
        d(c6.b.f1959a.d(z10));
    }

    public void l() {
        d("window.__markChild();");
    }

    public void m(a aVar) {
        n();
        this.f9044f = aVar;
        Iterator it = this.f9040b.iterator();
        while (it.hasNext()) {
            ((q9.b) it.next()).b("window.__setMarkerEnabled(true," + this.f9043e + ");");
        }
    }

    public void n() {
        this.f9044f = null;
        this.f9043e++;
        this.f9041c = null;
        this.f9042d = "";
        q5.k kVar = this.f9045g;
        if (kVar != null) {
            kVar.o();
        }
        this.f9045g = null;
        Iterator it = this.f9040b.iterator();
        while (it.hasNext()) {
            ((q9.b) it.next()).b("window.__setMarkerEnabled(false);");
        }
    }
}
