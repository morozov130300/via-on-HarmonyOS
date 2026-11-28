package u4;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import w4.c;
import w4.d;
import x4.b;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f12859b = "a";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final WebResourceResponse f12860c = new WebResourceResponse("text/plain", "UTF-8", new ByteArrayInputStream(new byte[0]));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final WebResourceResponse f12861d = new WebResourceResponse("image/gif", "UTF-8", new ByteArrayInputStream(Base64.decode("R0lGODlhAQABAID/AMDAwAAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw==", 0)));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f12862a;

    public a(b bVar) {
        this.f12862a = bVar;
    }

    public static a m(Context context, String str, String str2, boolean z10, int i10) {
        return new a(new x4.a(new a5.a(context), new y4.a(str), new z4.a(str2), z10, i10));
    }

    public void a(String str) {
        if (str == null || str.isEmpty() || str.charAt(0) == '!') {
            return;
        }
        this.f12862a.d(str);
    }

    public boolean b(String str) {
        return this.f12862a.f(str) != null;
    }

    public JSONObject c(int i10) {
        JSONObject jSONObject;
        synchronized (this.f12862a) {
            try {
                jSONObject = new JSONObject();
                try {
                    String strO = this.f12862a.o();
                    if (!TextUtils.isEmpty(strO) && (i10 < 0 || strO.length() <= i10)) {
                        jSONObject.put("custom", strO);
                    }
                    List<c> listI = this.f12862a.i();
                    if (!listI.isEmpty()) {
                        StringBuilder sb2 = new StringBuilder();
                        for (c cVar : listI) {
                            if (cVar.g() != null && !cVar.g().isEmpty()) {
                                sb2.append(new c(cVar.g()).q());
                                sb2.append("\n");
                            }
                        }
                        jSONObject.put("subscribed", sb2.toString());
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return jSONObject;
    }

    public String d() {
        return this.f12862a.k();
    }

    public String e(String str) {
        return this.f12862a.g(str);
    }

    public List f() {
        return this.f12862a.i();
    }

    public boolean g() {
        return this.f12862a.e();
    }

    public boolean h(String str) {
        int i10;
        int i11;
        synchronized (this.f12862a) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                i11 = (jSONObject.isNull("custom") || !this.f12862a.m(jSONObject.optString("custom"))) ? 0 : 1;
                try {
                    if (!jSONObject.isNull("subscribed")) {
                        ArrayList arrayList = new ArrayList();
                        for (String str2 : jSONObject.optString("subscribed").split("\n")) {
                            c cVarI = c.i(str2);
                            if (cVarI != null) {
                                arrayList.add(cVarI);
                            }
                        }
                        if (this.f12862a.a(arrayList)) {
                            i11++;
                        }
                    }
                } catch (Exception e10) {
                    i10 = i11;
                    e = e10;
                    e.printStackTrace();
                    i11 = i10;
                }
            } catch (Exception e11) {
                e = e11;
                i10 = 0;
            }
            if (i11 > 0) {
                i();
            }
            return i11 > 0;
        }
    }

    public void i() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.f12862a.n();
        b5.a.a(f12859b, "load all filters done, cost: " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + "ms");
    }

    public d j(WebResourceRequest webResourceRequest, String str) {
        return this.f12862a.l(webResourceRequest, str);
    }

    public d k(String str, int i10, String str2) {
        return this.f12862a.b(str, i10, str2);
    }

    public d l(String str, String str2) {
        return this.f12862a.p(str, str2);
    }

    public boolean n() {
        synchronized (this.f12862a) {
            try {
                List listI = this.f12862a.i();
                if (listI.isEmpty()) {
                    return false;
                }
                Iterator it = listI.iterator();
                while (it.hasNext()) {
                    b5.c.c((c) it.next());
                }
                if (!this.f12862a.h(listI)) {
                    return false;
                }
                this.f12862a.n();
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void o(String str) {
        if (str == null || str.isEmpty() || str.charAt(0) == '!') {
            return;
        }
        this.f12862a.c(str);
    }

    public boolean p(String str) {
        synchronized (this.f12862a) {
            try {
                if (!this.f12862a.m(str)) {
                    return false;
                }
                this.f12862a.n();
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void q(List list) {
        synchronized (this.f12862a) {
            try {
                if (this.f12862a.h(list)) {
                    this.f12862a.n();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void r(boolean z10) {
        synchronized (this.f12862a) {
            try {
                if (this.f12862a.j(z10)) {
                    this.f12862a.n();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean s(WebResourceRequest webResourceRequest, String str) {
        d dVarJ = j(webResourceRequest, str);
        return (dVarJ == null || dVarJ.g()) ? false : true;
    }

    public boolean t(String str, String str2) {
        d dVarL = l(str, str2);
        return (dVarL == null || dVarL.g()) ? false : true;
    }

    public boolean u(String str, String str2) {
        d dVarK = k(str, (str == null ? 0 : b5.c.k(str, str2)) | 4096, str2);
        return (dVarK == null || dVarK.g()) ? false : true;
    }
}
