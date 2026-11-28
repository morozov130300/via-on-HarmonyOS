package w4;

import java.io.File;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f13642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f13643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f13644c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f13645d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f13646e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f13647f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f13648g;

    public c() {
        this.f13647f = false;
        this.f13648g = 0;
    }

    public static c i(String str) {
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
            cVar.p(strTrim);
            if (!jSONObject.isNull("filePath")) {
                cVar.k(jSONObject.getString("filePath"));
                if (!jSONObject.isNull("enabled")) {
                    cVar.j(jSONObject.getBoolean("enabled"));
                }
                if (!jSONObject.isNull("size")) {
                    cVar.n(jSONObject.getInt("size"));
                }
            }
            if (!jSONObject.isNull("title")) {
                cVar.o(jSONObject.getString("title"));
            }
            if (!jSONObject.isNull("homepage")) {
                cVar.l(jSONObject.getString("homepage"));
            }
            if (!jSONObject.isNull("license")) {
                cVar.m(jSONObject.getString("license"));
            }
            return cVar;
        } catch (Exception e10) {
            e10.printStackTrace();
            return cVar;
        }
    }

    public String a() {
        return this.f13646e;
    }

    public String b() {
        return this.f13644c;
    }

    public long c() {
        String str = this.f13646e;
        if (str != null && !str.isEmpty()) {
            File file = new File(this.f13646e);
            if (file.exists()) {
                return file.lastModified();
            }
        }
        return 0L;
    }

    public String d() {
        return this.f13645d;
    }

    public int e() {
        return this.f13648g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            String str = this.f13643b;
            String str2 = ((c) obj).f13643b;
            if (str != null) {
                return str.equals(str2);
            }
            if (str2 == null) {
                return true;
            }
        }
        return false;
    }

    public String f() {
        return this.f13642a;
    }

    public String g() {
        return this.f13643b;
    }

    public boolean h() {
        return this.f13647f;
    }

    public int hashCode() {
        String str = this.f13643b;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public void j(boolean z10) {
        this.f13647f = z10;
    }

    public void k(String str) {
        this.f13646e = str;
    }

    public void l(String str) {
        this.f13644c = str;
    }

    public void m(String str) {
        this.f13645d = str;
    }

    public void n(int i10) {
        this.f13648g = i10;
    }

    public void o(String str) {
        this.f13642a = str;
    }

    public void p(String str) {
        this.f13643b = str;
    }

    public String q() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("title", this.f13642a);
            jSONObject.put("url", this.f13643b);
            jSONObject.put("homepage", this.f13644c);
            jSONObject.put("license", this.f13645d);
            jSONObject.put("filePath", this.f13646e);
            String str = this.f13646e;
            if (str != null && !str.isEmpty()) {
                jSONObject.put("enabled", this.f13647f);
                jSONObject.put("size", this.f13648g);
            }
            return jSONObject.toString();
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public String toString() {
        return "FilterSubscription{title='" + this.f13642a + "', url='" + this.f13643b + "', homepage='" + this.f13644c + "', license='" + this.f13645d + "', filePath='" + this.f13646e + "', enabled=" + this.f13647f + ", size=" + this.f13648g + '}';
    }

    public c(c cVar) {
        this.f13647f = false;
        this.f13648g = 0;
        this.f13642a = cVar.f13642a;
        this.f13643b = cVar.f13643b;
        this.f13644c = cVar.f13644c;
        this.f13645d = cVar.f13645d;
        this.f13646e = cVar.f13646e;
        this.f13647f = cVar.f13647f;
        this.f13648g = cVar.f13648g;
    }

    public c(String str) {
        this.f13647f = false;
        this.f13648g = 0;
        this.f13643b = str;
    }

    public c(String str, String str2, String str3, boolean z10) {
        this.f13648g = 0;
        this.f13643b = str;
        this.f13646e = str2;
        this.f13642a = str3;
        this.f13647f = z10;
    }
}
