package c6;

import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class c implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f1964a;

    public c(JSONObject json) {
        kotlin.jvm.internal.h.f(json, "json");
        this.f1964a = json;
    }

    @Override // c6.l
    public String a() {
        if (this.f1964a.length() == 1) {
            return this.f1964a.keys().next();
        }
        return null;
    }

    @Override // c6.l
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public JSONObject b(String key) {
        kotlin.jvm.internal.h.f(key, "key");
        return this.f1964a.optJSONObject(key);
    }
}
