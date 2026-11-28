package a3;

import android.text.TextUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import t2.m;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class c implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f27a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x2.b f28b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q2.f f29c;

    public c(String str, x2.b bVar) {
        this(str, bVar, q2.f.f());
    }

    @Override // a3.i
    public JSONObject a(h hVar, boolean z10) {
        if (!z10) {
            throw new RuntimeException("An invalid data collection token was used.");
        }
        try {
            Map mapF = f(hVar);
            x2.a aVarB = b(d(mapF), hVar);
            this.f29c.b("Requesting settings from " + this.f27a);
            this.f29c.i("Settings query params were: " + mapF);
            return g(aVarB.c());
        } catch (IOException e10) {
            this.f29c.e("Settings request failed.", e10);
            return null;
        }
    }

    public final x2.a b(x2.a aVar, h hVar) {
        c(aVar, "X-CRASHLYTICS-GOOGLE-APP-ID", hVar.f44a);
        c(aVar, "X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        c(aVar, "X-CRASHLYTICS-API-CLIENT-VERSION", m.i());
        c(aVar, "Accept", "application/json");
        c(aVar, "X-CRASHLYTICS-DEVICE-MODEL", hVar.f45b);
        c(aVar, "X-CRASHLYTICS-OS-BUILD-VERSION", hVar.f46c);
        c(aVar, "X-CRASHLYTICS-OS-DISPLAY-VERSION", hVar.f47d);
        c(aVar, "X-CRASHLYTICS-INSTALLATION-ID", hVar.f48e.a());
        return aVar;
    }

    public final void c(x2.a aVar, String str, String str2) {
        if (str2 != null) {
            aVar.d(str, str2);
        }
    }

    public x2.a d(Map map) {
        return this.f28b.a(this.f27a, map).d("User-Agent", "Crashlytics Android SDK/" + m.i()).d("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
    }

    public final JSONObject e(String str) {
        try {
            return new JSONObject(str);
        } catch (Exception e10) {
            this.f29c.l("Failed to parse settings JSON from " + this.f27a, e10);
            this.f29c.k("Settings response " + str);
            return null;
        }
    }

    public final Map f(h hVar) {
        HashMap map = new HashMap();
        map.put("build_version", hVar.f51h);
        map.put("display_version", hVar.f50g);
        map.put("source", Integer.toString(hVar.f52i));
        String str = hVar.f49f;
        if (!TextUtils.isEmpty(str)) {
            map.put("instance", str);
        }
        return map;
    }

    public JSONObject g(x2.c cVar) {
        int iB = cVar.b();
        this.f29c.i("Settings response code was: " + iB);
        if (h(iB)) {
            return e(cVar.a());
        }
        this.f29c.d("Settings request failed; (status: " + iB + ") from " + this.f27a);
        return null;
    }

    public boolean h(int i10) {
        return i10 == 200 || i10 == 201 || i10 == 202 || i10 == 203;
    }

    public c(String str, x2.b bVar, q2.f fVar) {
        if (str == null) {
            throw new IllegalArgumentException("url must not be null.");
        }
        this.f29c = fVar;
        this.f28b = bVar;
        this.f27a = str;
    }
}
