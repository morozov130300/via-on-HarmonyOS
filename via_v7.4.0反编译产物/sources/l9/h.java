package l9;

import android.text.TextUtils;
import android.util.Base64;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;
import z8.d0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class h implements c {

    /* renamed from: a, reason: collision with root package name */
    public final p5.c f8457a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f8458b;

    public h(p5.c cVar, boolean z10) {
        this.f8457a = cVar;
        this.f8458b = z10;
    }

    @Override // l9.c
    public String a() {
        if (this.f8458b) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        try {
            List listO = this.f8457a.o();
            Collections.reverse(listO);
            Iterator it = listO.iterator();
            while (it.hasNext()) {
                JSONObject jSONObjectC = c((r5.c) it.next());
                if (jSONObjectC != null) {
                    sb2.append(jSONObjectC);
                    sb2.append("\n");
                }
            }
            String strTrim = sb2.toString().trim();
            Charset charset = m8.a.f8676a;
            return new String(Base64.encode(strTrim.getBytes(charset), 0), charset);
        } catch (Exception e10) {
            pc.a.d(e10);
            return "";
        }
    }

    @Override // l9.c
    public boolean b(String str) throws IOException {
        if (d0.a(str)) {
            return false;
        }
        try {
            String str2 = new String(Base64.decode(str, 0), m8.a.f8677b);
            if (str2.isEmpty()) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<r5.a> arrayList2 = new ArrayList();
            Charset charset = m8.a.f8676a;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(str2.getBytes(charset)), charset));
            boolean z10 = false;
            while (true) {
                String line = bufferedReader.readLine();
                if (TextUtils.isEmpty(line)) {
                    break;
                }
                JSONObject jSONObject = new JSONObject(line);
                if (jSONObject.has("codeV2")) {
                    r5.a aVarD = d(jSONObject);
                    if (aVarD != null) {
                        arrayList2.add(aVarD);
                    }
                } else {
                    if (!z10 && jSONObject.has("code")) {
                        z10 = true;
                    }
                    if (z10) {
                        n9.a aVarL = n9.a.l(jSONObject);
                        if (aVarL.j()) {
                            arrayList.add(aVarL);
                        }
                    } else {
                        Iterator<String> itKeys = jSONObject.keys();
                        while (itKeys.hasNext()) {
                            n9.a aVar = new n9.a();
                            aVar.u(itKeys.next());
                            aVar.n((String) jSONObject.get(aVar.h()));
                            arrayList.add(aVar);
                        }
                    }
                }
            }
            bufferedReader.close();
            List listB = ia.d.b(arrayList);
            if (listB != null) {
                arrayList2.addAll(listB);
            }
            if (arrayList2.size() > 0) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                for (r5.a aVar2 : arrayList2) {
                    aVar2.d().l(jCurrentTimeMillis);
                    aVar2.d().s(jCurrentTimeMillis);
                    jCurrentTimeMillis += 8;
                }
                ia.d.a(this.f8457a, arrayList2);
                p5.c cVar = this.f8457a;
                Objects.requireNonNull(cVar);
                z8.h.b(new g(cVar));
            }
            return true;
        } catch (Exception e10) {
            pc.a.d(e10);
            return false;
        }
    }

    public final JSONObject c(r5.c cVar) throws JSONException {
        if (cVar == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("scriptId", this.f8457a.B(cVar.e()));
            jSONObject.put("enabled", cVar.j());
            jSONObject.put("url", cVar.b());
            jSONObject.put("codeV2", this.f8457a.g(cVar.e()));
            return jSONObject;
        } catch (Exception e10) {
            e10.printStackTrace();
            return jSONObject;
        }
    }

    public final r5.a d(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return null;
        }
        boolean zOptBoolean = jSONObject.optBoolean("enabled");
        String strOptString = jSONObject.optString("url");
        String strOptString2 = jSONObject.optString("codeV2");
        String strOptString3 = jSONObject.optString("scriptId");
        r5.a aVarF = r5.a.f(strOptString2, strOptString);
        if (aVarF != null) {
            if (strOptString3 != null && !strOptString3.isEmpty()) {
                aVarF.a().B(strOptString3);
            }
            aVarF.g(zOptBoolean);
        }
        return aVarF;
    }

    @Override // l9.c
    public String getKey() {
        return "other";
    }
}
