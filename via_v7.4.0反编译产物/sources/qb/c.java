package qb;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f11449a;

    /* renamed from: b, reason: collision with root package name */
    public long f11450b;

    /* renamed from: c, reason: collision with root package name */
    public long f11451c;

    public c(String str) {
        this.f11449a = str;
    }

    public c(String str, long j10, long j11) {
        this.f11449a = str;
        this.f11450b = j10;
        this.f11451c = j11;
    }

    public static c a(JSONObject jSONObject) {
        return new c(jSONObject.optString("name"), jSONObject.optLong("modified", 0L), jSONObject.optLong("synced", 0L));
    }

    public String b() {
        return this.f11449a;
    }

    public long c() {
        return this.f11451c;
    }

    public long d() {
        return this.f11450b;
    }

    public void e(long j10) {
        this.f11451c = Math.max(this.f11450b, j10);
    }

    public void f(long j10) {
        this.f11450b = j10;
    }

    public JSONObject g() throws JSONException {
        if (this.f11450b == 0 || this.f11451c == 0) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.f11449a);
            jSONObject.put("modified", this.f11450b);
            jSONObject.put("synced", this.f11451c);
            return jSONObject;
        } catch (JSONException e10) {
            pc.a.i(e10);
            return jSONObject;
        }
    }

    public String toString() {
        return "SyncingFileIndex{fileName='" + this.f11449a + "', remoteModified=" + this.f11450b + ", lastSynced=" + this.f11451c + '}';
    }
}
