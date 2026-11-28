package j9;

import android.util.Base64;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
import x8.b0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class j implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z9.d f6747a;

    public j(z9.d dVar) {
        this.f6747a = dVar;
    }

    @Override // j9.c
    public String a() {
        try {
            Map mapF = this.f6747a.f();
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry entry : mapF.entrySet()) {
                if (entry.getKey() != null && !((String) entry.getKey()).isEmpty()) {
                    jSONObject.put((String) entry.getKey(), y9.c.l((y9.b) entry.getValue()));
                }
            }
            String strTrim = jSONObject.toString().trim();
            Charset charset = k8.a.f7218a;
            return new String(Base64.encode(strTrim.getBytes(charset), 0), charset);
        } catch (Exception e10) {
            tc.a.e(e10);
            return null;
        }
    }

    @Override // j9.c
    public boolean b(String str) {
        if (b0.a(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(Base64.decode(str, 0), k8.a.f7219b));
            Iterator<String> itKeys = jSONObject.keys();
            HashMap map = new HashMap();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, y9.c.j(jSONObject.optJSONObject(next)));
            }
            return this.f6747a.a(map);
        } catch (Exception e10) {
            tc.a.e(e10);
            return false;
        }
    }

    @Override // j9.c
    public String getKey() {
        return "conf";
    }
}
