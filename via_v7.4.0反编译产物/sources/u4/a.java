package u4;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import w4.c;
import w4.d;
import x4.b;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    public static final String f12817b = "a";

    /* renamed from: c, reason: collision with root package name */
    public static final WebResourceResponse f12818c = new WebResourceResponse("text/plain", "UTF-8", new ByteArrayInputStream(new byte[0]));

    /* renamed from: d, reason: collision with root package name */
    public static final WebResourceResponse f12819d = new WebResourceResponse("image/gif", "UTF-8", new ByteArrayInputStream(Base64.decode("R0lGODlhAQABAID/AMDAwAAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw==", 0)));

    /* renamed from: a, reason: collision with root package name */
    public final b f12820a;

    public a(b bVar) {
        this.f12820a = bVar;
    }

    public static a m(Context context, String str, String str2, boolean z10, int i10) {
        return new a(new x4.a(new a5.a(context), new y4.a(str), new z4.a(str2), z10, i10));
    }

    public void a(String str) {
        if (str == null || str.isEmpty() || str.charAt(0) == '!') {
            return;
        }
        this.f12820a.e(str);
    }

    public boolean b(String str) {
        return this.f12820a.g(str) != null;
    }

    public JSONObject c(int i10) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            String strP = this.f12820a.p();
            if (!TextUtils.isEmpty(strP) && (i10 < 0 || strP.length() <= i10)) {
                jSONObject.put("custom", strP);
            }
            List<c> listJ = this.f12820a.j();
            if (!listJ.isEmpty()) {
                StringBuilder sb2 = new StringBuilder();
                for (c cVar : listJ) {
                    if (cVar.e() != null && !cVar.e().isEmpty()) {
                        sb2.append(new c(cVar.e()).o());
                        sb2.append("\n");
                    }
                }
                jSONObject.put("subscribed", sb2.toString());
            }
            return jSONObject;
        } catch (Exception e10) {
            e10.printStackTrace();
            return jSONObject;
        }
    }

    public String d() {
        return this.f12820a.l();
    }

    public String e(String str) {
        return this.f12820a.h(str);
    }

    public List f() {
        return this.f12820a.j();
    }

    public boolean g() {
        return this.f12820a.f();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006d A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean h(String str) {
        int i10;
        int i11;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull("custom")) {
                i11 = this.f12820a.n(jSONObject.optString("custom")) ? 1 : 0;
                try {
                    if (!jSONObject.isNull("subscribed")) {
                        ArrayList arrayList = new ArrayList();
                        for (String str2 : jSONObject.optString("subscribed").split("\n")) {
                            c cVarG = c.g(str2);
                            if (cVarG != null) {
                                arrayList.add(cVarG);
                            }
                        }
                        if (this.f12820a.b(arrayList)) {
                            i11++;
                        }
                    }
                } catch (Exception e10) {
                    i10 = i11;
                    e = e10;
                    e.printStackTrace();
                    i11 = i10;
                    if (i11 > 0) {
                    }
                    if (i11 <= 0) {
                    }
                }
            }
        } catch (Exception e11) {
            e = e11;
            i10 = 0;
        }
        if (i11 > 0) {
            i();
        }
        return i11 <= 0;
    }

    public void i() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.f12820a.o();
        b5.a.a(f12817b, "load all filters done, cost: " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + "ms");
    }

    public d j(WebResourceRequest webResourceRequest, String str) {
        return this.f12820a.m(webResourceRequest, str);
    }

    public d k(String str, int i10, String str2) {
        return this.f12820a.c(str, i10, str2);
    }

    public d l(String str, String str2) {
        return this.f12820a.q(str, str2);
    }

    public void n(String str) {
        if (str == null || str.isEmpty() || str.charAt(0) == '!') {
            return;
        }
        this.f12820a.d(str);
    }

    public void o(List list) {
        if (this.f12820a.i(list)) {
            this.f12820a.o();
        }
    }

    public void p(boolean z10) {
        if (this.f12820a.k(z10)) {
            this.f12820a.o();
        }
    }

    public boolean q(WebResourceRequest webResourceRequest, String str) {
        d dVarJ = j(webResourceRequest, str);
        return (dVarJ == null || dVarJ.g()) ? false : true;
    }

    public boolean r(String str, String str2) {
        d dVarL = l(str, str2);
        return (dVarL == null || dVarL.g()) ? false : true;
    }

    public boolean s(String str, String str2) {
        d dVarK = k(str, (str == null ? 0 : b5.c.k(str, str2)) | 4096, str2);
        return (dVarK == null || dVarK.g()) ? false : true;
    }
}
