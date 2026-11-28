package qb;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f11860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f11861c;

    public c(String str) {
        this.f11859a = str;
    }

    public static c a(JSONObject jSONObject) {
        return new c(jSONObject.optString("name"), jSONObject.optLong("modified", 0L), jSONObject.optLong("synced", 0L));
    }

    public String b() {
        return this.f11859a;
    }

    public long c() {
        return this.f11861c;
    }

    public long d() {
        return this.f11860b;
    }

    public void e(long j10) {
        this.f11861c = Math.max(this.f11860b, j10);
    }

    public void f(long j10) {
        this.f11860b = j10;
    }

    public JSONObject g() {
        if (this.f11860b == 0 || this.f11861c == 0) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.f11859a);
            jSONObject.put("modified", this.f11860b);
            jSONObject.put("synced", this.f11861c);
            return jSONObject;
        } catch (JSONException e10) {
            tc.a.j(e10);
            return jSONObject;
        }
    }

    public String toString() {
        return "SyncingFileIndex{fileName='" + this.f11859a + "', remoteModified=" + this.f11860b + ", lastSynced=" + this.f11861c + '}';
    }

    public c(String str, long j10, long j11) {
        this.f11859a = str;
        this.f11860b = j10;
        this.f11861c = j11;
    }
}
