package j9;

import android.text.TextUtils;
import android.util.Base64;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.json.JSONObject;
import x8.b0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class h implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final qa.c f6743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f6744b;

    public h(qa.c cVar, boolean z10) {
        this.f6743a = cVar;
        this.f6744b = z10;
    }

    @Override // j9.c
    public String a() {
        if (this.f6744b) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        try {
            List listQ = this.f6743a.q();
            Collections.reverse(listQ);
            Iterator it = listQ.iterator();
            while (it.hasNext()) {
                JSONObject jSONObjectC = c((ra.c) it.next());
                if (jSONObjectC != null) {
                    sb2.append(jSONObjectC);
                    sb2.append("\n");
                }
            }
            String strTrim = sb2.toString().trim();
            Charset charset = k8.a.f7218a;
            return new String(Base64.encode(strTrim.getBytes(charset), 0), charset);
        } catch (Exception e10) {
            tc.a.e(e10);
            return "";
        }
    }

    @Override // j9.c
    public boolean b(String str) {
        if (b0.a(str)) {
            return false;
        }
        try {
            String str2 = new String(Base64.decode(str, 0), k8.a.f7219b);
            if (str2.isEmpty()) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<ra.a> arrayList2 = new ArrayList();
            Charset charset = k8.a.f7218a;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(str2.getBytes(charset)), charset));
            boolean z10 = false;
            while (true) {
                String line = bufferedReader.readLine();
                if (TextUtils.isEmpty(line)) {
                    break;
                }
                JSONObject jSONObject = new JSONObject(line);
                if (jSONObject.has("codeV2")) {
                    ra.a aVarD = d(jSONObject);
                    if (aVarD != null) {
                        arrayList2.add(aVarD);
                    }
                } else {
                    if (!z10 && jSONObject.has("code")) {
                        z10 = true;
                    }
                    if (z10) {
                        l9.a aVarL = l9.a.l(jSONObject);
                        if (aVarL.j()) {
                            arrayList.add(aVarL);
                        }
                    } else {
                        Iterator<String> itKeys = jSONObject.keys();
                        while (itKeys.hasNext()) {
                            l9.a aVar = new l9.a();
                            aVar.u(itKeys.next());
                            aVar.n((String) jSONObject.get(aVar.h()));
                            arrayList.add(aVar);
                        }
                    }
                }
            }
            bufferedReader.close();
            List listB = fa.d.b(arrayList);
            if (listB != null) {
                arrayList2.addAll(listB);
            }
            if (arrayList2.size() > 0) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                for (ra.a aVar2 : arrayList2) {
                    aVar2.c().l(jCurrentTimeMillis);
                    aVar2.c().s(jCurrentTimeMillis);
                    jCurrentTimeMillis += 8;
                }
                fa.d.a(this.f6743a, arrayList2);
                qa.c cVar = this.f6743a;
                Objects.requireNonNull(cVar);
                x8.h.b(new g(cVar));
            }
            return true;
        } catch (Exception e10) {
            tc.a.e(e10);
            return false;
        }
    }

    public final JSONObject c(ra.c cVar) {
        if (cVar == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("scriptId", this.f6743a.B(cVar.e()));
            jSONObject.put("enabled", cVar.j());
            jSONObject.put("url", cVar.b());
            jSONObject.put("codeV2", this.f6743a.f(cVar.e()));
            return jSONObject;
        } catch (Exception e10) {
            e10.printStackTrace();
            return jSONObject;
        }
    }

    public final ra.a d(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return null;
        }
        boolean zOptBoolean = jSONObject.optBoolean("enabled");
        String strOptString = jSONObject.optString("url");
        String strOptString2 = jSONObject.optString("codeV2");
        String strOptString3 = jSONObject.optString("scriptId");
        ra.a aVarE = ra.a.e(strOptString2, strOptString);
        if (aVarE != null) {
            if (strOptString3 != null && !strOptString3.isEmpty()) {
                aVarE.a().A(strOptString3);
            }
            aVarE.f(zOptBoolean);
        }
        return aVarE;
    }

    @Override // j9.c
    public String getKey() {
        return "other";
    }
}
