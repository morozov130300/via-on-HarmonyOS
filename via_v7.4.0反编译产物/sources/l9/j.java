package l9;

import android.util.Base64;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import z8.d0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class j implements c {

    /* renamed from: a, reason: collision with root package name */
    public final ca.d f8461a;

    public j(ca.d dVar) {
        this.f8461a = dVar;
    }

    @Override // l9.c
    public String a() throws JSONException {
        try {
            Map mapH = this.f8461a.h();
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry entry : mapH.entrySet()) {
                if (entry.getKey() != null && !((String) entry.getKey()).isEmpty()) {
                    jSONObject.put((String) entry.getKey(), ba.c.l((ba.b) entry.getValue()));
                }
            }
            String strTrim = jSONObject.toString().trim();
            Charset charset = m8.a.f8676a;
            return new String(Base64.encode(strTrim.getBytes(charset), 0), charset);
        } catch (Exception e10) {
            pc.a.d(e10);
            return null;
        }
    }

    @Override // l9.c
    public boolean b(String str) {
        if (d0.a(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(Base64.decode(str, 0), m8.a.f8677b));
            Iterator<String> itKeys = jSONObject.keys();
            HashMap map = new HashMap();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, ba.c.j(jSONObject.optJSONObject(next)));
            }
            return this.f8461a.a(map);
        } catch (Exception e10) {
            pc.a.d(e10);
            return false;
        }
    }

    @Override // l9.c
    public String getKey() {
        return "conf";
    }
}
