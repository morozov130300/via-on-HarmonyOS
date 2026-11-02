package z2;

import android.text.TextUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import s2.m;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class c implements i {

    /* renamed from: a, reason: collision with root package name */
    public final String f14559a;

    /* renamed from: b, reason: collision with root package name */
    public final w2.b f14560b;

    /* renamed from: c, reason: collision with root package name */
    public final p2.f f14561c;

    public c(String str, w2.b bVar) {
        this(str, bVar, p2.f.f());
    }

    public c(String str, w2.b bVar, p2.f fVar) {
        if (str == null) {
            throw new IllegalArgumentException("url must not be null.");
        }
        this.f14561c = fVar;
        this.f14560b = bVar;
        this.f14559a = str;
    }

    @Override // z2.i
    public JSONObject a(h hVar, boolean z10) {
        if (!z10) {
            throw new RuntimeException("An invalid data collection token was used.");
        }
        try {
            Map mapF = f(hVar);
            w2.a aVarB = b(d(mapF), hVar);
            this.f14561c.b("Requesting settings from " + this.f14559a);
            this.f14561c.i("Settings query params were: " + mapF);
            return g(aVarB.c());
        } catch (IOException e10) {
            this.f14561c.e("Settings request failed.", e10);
            return null;
        }
    }

    public final w2.a b(w2.a aVar, h hVar) {
        c(aVar, "X-CRASHLYTICS-GOOGLE-APP-ID", hVar.f14576a);
        c(aVar, "X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        c(aVar, "X-CRASHLYTICS-API-CLIENT-VERSION", m.i());
        c(aVar, "Accept", "application/json");
        c(aVar, "X-CRASHLYTICS-DEVICE-MODEL", hVar.f14577b);
        c(aVar, "X-CRASHLYTICS-OS-BUILD-VERSION", hVar.f14578c);
        c(aVar, "X-CRASHLYTICS-OS-DISPLAY-VERSION", hVar.f14579d);
        c(aVar, "X-CRASHLYTICS-INSTALLATION-ID", hVar.f14580e.a());
        return aVar;
    }

    public final void c(w2.a aVar, String str, String str2) {
        if (str2 != null) {
            aVar.d(str, str2);
        }
    }

    public w2.a d(Map map) {
        return this.f14560b.a(this.f14559a, map).d("User-Agent", "Crashlytics Android SDK/" + m.i()).d("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
    }

    public final JSONObject e(String str) {
        try {
            return new JSONObject(str);
        } catch (Exception e10) {
            this.f14561c.l("Failed to parse settings JSON from " + this.f14559a, e10);
            this.f14561c.k("Settings response " + str);
            return null;
        }
    }

    public final Map f(h hVar) {
        HashMap map = new HashMap();
        map.put("build_version", hVar.f14583h);
        map.put("display_version", hVar.f14582g);
        map.put("source", Integer.toString(hVar.f14584i));
        String str = hVar.f14581f;
        if (!TextUtils.isEmpty(str)) {
            map.put("instance", str);
        }
        return map;
    }

    public JSONObject g(w2.c cVar) {
        int iB = cVar.b();
        this.f14561c.i("Settings response code was: " + iB);
        if (h(iB)) {
            return e(cVar.a());
        }
        this.f14561c.d("Settings request failed; (status: " + iB + ") from " + this.f14559a);
        return null;
    }

    public boolean h(int i10) {
        return i10 == 200 || i10 == 201 || i10 == 202 || i10 == 203;
    }
}
