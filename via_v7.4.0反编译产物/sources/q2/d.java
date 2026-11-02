package q2;

import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class d implements b, r2.b {

    /* renamed from: a, reason: collision with root package name */
    public r2.a f11274a;

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

    @Override // r2.b
    public void a(r2.a aVar) {
        this.f11274a = aVar;
        p2.f.f().b("Registered Firebase Analytics event receiver for breadcrumbs");
    }

    @Override // q2.b
    public void onEvent(String str, Bundle bundle) {
        r2.a aVar = this.f11274a;
        if (aVar != null) {
            try {
                aVar.a("$A$:" + b(str, bundle));
            } catch (JSONException unused) {
                p2.f.f().k("Unable to serialize Firebase Analytics event to breadcrumb.");
            }
        }
    }
}
