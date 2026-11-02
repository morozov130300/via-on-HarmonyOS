package w4;

import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public String f13253a;

    /* renamed from: b, reason: collision with root package name */
    public String f13254b;

    /* renamed from: c, reason: collision with root package name */
    public String f13255c;

    /* renamed from: d, reason: collision with root package name */
    public String f13256d;

    /* renamed from: e, reason: collision with root package name */
    public String f13257e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f13258f;

    /* renamed from: g, reason: collision with root package name */
    public int f13259g;

    public c() {
        this.f13258f = false;
        this.f13259g = 0;
    }

    public c(String str) {
        this.f13258f = false;
        this.f13259g = 0;
        this.f13254b = str;
    }

    public c(String str, String str2, String str3, boolean z10) {
        this.f13259g = 0;
        this.f13254b = str;
        this.f13257e = str2;
        this.f13253a = str3;
        this.f13258f = z10;
    }

    public static c g(String str) {
        c cVar = new c();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.isNull("url")) {
                return null;
            }
            String strTrim = jSONObject.optString("url", "").trim();
            if (strTrim.isEmpty()) {
                return null;
            }
            cVar.n(strTrim);
            if (!jSONObject.isNull("filePath")) {
                cVar.i(jSONObject.getString("filePath"));
                if (!jSONObject.isNull("enabled")) {
                    cVar.h(jSONObject.getBoolean("enabled"));
                }
                if (!jSONObject.isNull("size")) {
                    cVar.l(jSONObject.getInt("size"));
                }
            }
            if (!jSONObject.isNull("title")) {
                cVar.m(jSONObject.getString("title"));
            }
            if (!jSONObject.isNull("homepage")) {
                cVar.j(jSONObject.getString("homepage"));
            }
            if (!jSONObject.isNull("license")) {
                cVar.k(jSONObject.getString("license"));
            }
            return cVar;
        } catch (Exception e10) {
            e10.printStackTrace();
            return cVar;
        }
    }

    public String a() {
        return this.f13257e;
    }

    public long b() {
        String str = this.f13257e;
        if (str != null && !str.isEmpty()) {
            File file = new File(this.f13257e);
            if (file.exists()) {
                return file.lastModified();
            }
        }
        return 0L;
    }

    public int c() {
        return this.f13259g;
    }

    public String d() {
        return this.f13253a;
    }

    public String e() {
        return this.f13254b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            String str = this.f13254b;
            String str2 = ((c) obj).f13254b;
            if (str != null) {
                return str.equals(str2);
            }
            if (str2 == null) {
                return true;
            }
        }
        return false;
    }

    public boolean f() {
        return this.f13258f;
    }

    public void h(boolean z10) {
        this.f13258f = z10;
    }

    public int hashCode() {
        String str = this.f13254b;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public void i(String str) {
        this.f13257e = str;
    }

    public void j(String str) {
        this.f13255c = str;
    }

    public void k(String str) {
        this.f13256d = str;
    }

    public void l(int i10) {
        this.f13259g = i10;
    }

    public void m(String str) {
        this.f13253a = str;
    }

    public void n(String str) {
        this.f13254b = str;
    }

    public String o() throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("title", this.f13253a);
            jSONObject.put("url", this.f13254b);
            jSONObject.put("homepage", this.f13255c);
            jSONObject.put("license", this.f13256d);
            jSONObject.put("filePath", this.f13257e);
            String str = this.f13257e;
            if (str != null && !str.isEmpty()) {
                jSONObject.put("enabled", this.f13258f);
                jSONObject.put("size", this.f13259g);
            }
            return jSONObject.toString();
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public String toString() {
        return "FilterSubscription{title='" + this.f13253a + "', url='" + this.f13254b + "', homepage='" + this.f13255c + "', license='" + this.f13256d + "', filePath='" + this.f13257e + "', enabled=" + this.f13258f + ", size=" + this.f13259g + '}';
    }
}
