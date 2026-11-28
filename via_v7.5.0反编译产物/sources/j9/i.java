package j9;

import android.util.Base64;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import u9.l;
import x8.b0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class i implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w9.a f6745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f6746b;

    public i(w9.a aVar, l lVar) {
        this.f6745a = aVar;
        this.f6746b = lVar;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x004e A[Catch: Exception -> 0x003d, JSONException -> 0x003f, TryCatch #1 {JSONException -> 0x003f, blocks: (B:6:0x002b, B:8:0x0036, B:19:0x004e, B:20:0x0053, B:15:0x0041, B:17:0x0048), top: B:29:0x002b, outer: #0 }] */
    @Override // j9.c
    public String a() {
        try {
            int iO0 = this.f6746b.o0();
            int iO1 = this.f6746b.o0();
            List<ga.c> listE = this.f6745a.z().e();
            JSONArray jSONArray = new JSONArray();
            for (ga.c cVar : listE) {
                try {
                    JSONObject jSONObjectW = cVar.w();
                    if (cVar.h() == 1 && iO0 == cVar.d()) {
                        jSONObjectW.put("selected", true);
                    } else if (cVar.h() == 2 && iO1 == cVar.d()) {
                        jSONObjectW.put("selected", true);
                    }
                    jSONArray.put(jSONObjectW);
                } catch (JSONException e10) {
                    tc.a.j(e10);
                }
            }
            String strTrim = jSONArray.toString().trim();
            Charset charset = k8.a.f7218a;
            return new String(Base64.encode(strTrim.getBytes(charset), 0), charset);
        } catch (Exception e11) {
            tc.a.j(e11);
            return "";
        }
    }

    @Override // j9.c
    public boolean b(String str) {
        ga.c cVarG;
        if (b0.a(str)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(new String(Base64.decode(str, 0), k8.a.f7219b));
            ArrayList arrayList = new ArrayList();
            ArrayList<ga.c> arrayList2 = new ArrayList();
            int iV = this.f6746b.V();
            int length = jSONArray.length();
            String strA = null;
            for (int i10 = 0; i10 < length; i10++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                ga.c cVarN = ga.c.n(jSONObject);
                if (cVarN != null) {
                    arrayList.add(cVarN);
                    if (cVarN.h() == 1 && cVarN.d() == iV) {
                        strA = cVarN.a();
                    }
                    if (jSONObject.optBoolean("selected", false)) {
                        arrayList2.add(cVarN);
                    }
                }
            }
            boolean zH = !arrayList.isEmpty() ? this.f6745a.z().h(arrayList) : false;
            w9.d.d().a();
            if (strA != null && (cVarG = this.f6745a.z().g(strA, 1)) != null) {
                this.f6746b.F2(cVarG.d());
            }
            if (!arrayList2.isEmpty()) {
                for (ga.c cVar : arrayList2) {
                    ga.c cVarG2 = this.f6745a.z().g(cVar.a(), cVar.h());
                    if (cVarG2 != null) {
                        if (cVarG2.h() == 1) {
                            this.f6746b.J(cVarG2.d());
                        } else if (cVarG2.h() == 2) {
                            this.f6746b.s(cVarG2.d());
                        }
                    }
                }
            }
            return zH;
        } catch (Exception e10) {
            tc.a.j(e10);
            return false;
        }
    }

    @Override // j9.c
    public String getKey() {
        return "kvdata";
    }
}
