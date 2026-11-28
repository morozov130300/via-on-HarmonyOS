package ga;

import org.json.JSONException;
import org.json.JSONObject;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f5596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f5597c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f5598d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f5599e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f5600f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f5601g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f5602h;

    public c() {
    }

    public static c i(int i10, String str) {
        return j(i10, str, null);
    }

    public static c j(int i10, String str, String str2) {
        c cVar = new c(i10, str, str2, 2);
        long jCurrentTimeMillis = System.currentTimeMillis();
        cVar.s(jCurrentTimeMillis);
        cVar.p(jCurrentTimeMillis);
        return cVar;
    }

    public static c k(String str, String str2) {
        return j(0, str, str2);
    }

    public static c l(int i10, String str, String str2) {
        c cVar = new c(i10, str, str2, 1);
        long jCurrentTimeMillis = System.currentTimeMillis();
        cVar.s(jCurrentTimeMillis);
        cVar.p(jCurrentTimeMillis);
        return cVar;
    }

    public static c m(String str, String str2) {
        return l(0, str, str2);
    }

    public static c n(JSONObject jSONObject) {
        c cVar = null;
        if (jSONObject != null && jSONObject.length() > 0) {
            try {
                c cVar2 = new c();
                try {
                    cVar2.r(jSONObject.optInt(Name.MARK));
                    cVar2.u(jSONObject.optString("title"));
                    cVar2.o(jSONObject.optString("content"));
                    cVar2.t(jSONObject.optString("note"));
                    cVar2.q(jSONObject.optInt("flag"));
                    cVar2.v(jSONObject.optInt("type"));
                    cVar2.s(jSONObject.optLong("lastUpdatedAt"));
                    cVar2.p(jSONObject.optLong("createdAt"));
                    return cVar2;
                } catch (Exception e10) {
                    e = e10;
                    cVar = cVar2;
                    e.printStackTrace();
                    return cVar;
                }
            } catch (Exception e11) {
                e = e11;
            }
        }
        return cVar;
    }

    public String a() {
        return this.f5597c;
    }

    public long b() {
        return this.f5602h;
    }

    public int c() {
        return this.f5599e;
    }

    public int d() {
        return this.f5595a;
    }

    public long e() {
        return this.f5601g;
    }

    public String f() {
        return this.f5598d;
    }

    public String g() {
        return this.f5596b;
    }

    public int h() {
        return this.f5600f;
    }

    public void o(String str) {
        if (str != null && str.isEmpty()) {
            str = null;
        }
        this.f5597c = str;
    }

    public void p(long j10) {
        this.f5602h = j10;
    }

    public void q(int i10) {
        this.f5599e = i10;
    }

    public void r(int i10) {
        this.f5595a = i10;
    }

    public void s(long j10) {
        this.f5601g = j10;
    }

    public void t(String str) {
        if (str != null && str.isEmpty()) {
            str = null;
        }
        this.f5598d = str;
    }

    public String toString() {
        return "SettingsData{id=" + this.f5595a + ", key='" + this.f5596b + "', content='" + this.f5597c + "', note='" + this.f5598d + "', flag=" + this.f5599e + ", type=" + this.f5600f + ", lastUpdatedAt=" + this.f5601g + ", createdAt=" + this.f5602h + '}';
    }

    public void u(String str) {
        if (str != null && str.isEmpty()) {
            str = null;
        }
        this.f5596b = str;
    }

    public void v(int i10) {
        this.f5600f = i10;
    }

    public JSONObject w() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(Name.MARK, Integer.valueOf(this.f5595a));
            jSONObject.putOpt("title", this.f5596b);
            jSONObject.putOpt("content", this.f5597c);
            jSONObject.putOpt("note", this.f5598d);
            jSONObject.putOpt("flag", Integer.valueOf(this.f5599e));
            jSONObject.putOpt("type", Integer.valueOf(this.f5600f));
            jSONObject.putOpt("lastUpdatedAt", Long.valueOf(this.f5601g));
            jSONObject.putOpt("createdAt", Long.valueOf(this.f5602h));
            return jSONObject;
        } catch (JSONException e10) {
            e10.printStackTrace();
            return jSONObject;
        }
    }

    public c(int i10, String str, String str2, int i11) {
        this.f5595a = i10;
        this.f5596b = str;
        this.f5597c = str2;
        this.f5600f = i11;
    }
}
