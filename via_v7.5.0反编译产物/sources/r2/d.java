package r2;

import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class d implements b, s2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s2.a f11964a;

    public static String b(String str, Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        for (String str2 : bundle.keySet()) {
            jSONObject2.put(str2, bundle.get(str2));
        }
        jSONObject.put("name", str);
        jSONObject.put("parameters", jSONObject2);
        return jSONObject.toString();
    }

    @Override // s2.b
    public void a(s2.a aVar) {
        this.f11964a = aVar;
        q2.f.f().b("Registered Firebase Analytics event receiver for breadcrumbs");
    }

    @Override // r2.b
    public void onEvent(String str, Bundle bundle) {
        s2.a aVar = this.f11964a;
        if (aVar != null) {
            try {
                aVar.a("$A$:" + b(str, bundle));
            } catch (JSONException unused) {
                q2.f.f().k("Unable to serialize Firebase Analytics event to breadcrumb.");
            }
        }
    }
}
