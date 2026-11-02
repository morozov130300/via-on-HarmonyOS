package l9;

import android.util.Base64;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import w9.l;
import z8.d0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class i implements c {

    /* renamed from: a, reason: collision with root package name */
    public final y9.a f8459a;

    /* renamed from: b, reason: collision with root package name */
    public final l f8460b;

    public i(y9.a aVar, l lVar) {
        this.f8459a = aVar;
        this.f8460b = lVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004e A[Catch: Exception -> 0x003d, JSONException -> 0x003f, TryCatch #1 {JSONException -> 0x003f, blocks: (B:6:0x002b, B:8:0x0036, B:19:0x004e, B:20:0x0053, B:15:0x0041, B:17:0x0048), top: B:29:0x002b, outer: #0 }] */
    @Override // l9.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a() throws JSONException {
        try {
            int iL0 = this.f8460b.l0();
            int iL02 = this.f8460b.l0();
            List<ja.c> listE = this.f8459a.z().e();
            JSONArray jSONArray = new JSONArray();
            for (ja.c cVar : listE) {
                try {
                    JSONObject jSONObjectW = cVar.w();
                    if (cVar.h() != 1 || iL0 != cVar.d()) {
                        if (cVar.h() == 2 && iL02 == cVar.d()) {
                            jSONObjectW.put("selected", true);
                        }
                        jSONArray.put(jSONObjectW);
                    }
                } catch (JSONException e10) {
                    pc.a.i(e10);
                }
            }
            String strTrim = jSONArray.toString().trim();
            Charset charset = m8.a.f8676a;
            return new String(Base64.encode(strTrim.getBytes(charset), 0), charset);
        } catch (Exception e11) {
            pc.a.i(e11);
            return "";
        }
    }

    @Override // l9.c
    public boolean b(String str) throws JSONException {
        if (d0.a(str)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(new String(Base64.decode(str, 0), m8.a.f8677b));
            ArrayList arrayList = new ArrayList();
            ArrayList<ja.c> arrayList2 = new ArrayList();
            int length = jSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                ja.c cVarN = ja.c.n(jSONObject);
                if (cVarN != null) {
                    arrayList.add(cVarN);
                    if (jSONObject.optBoolean("selected", false)) {
                        arrayList2.add(cVarN);
                    }
                }
            }
            boolean zG = !arrayList.isEmpty() ? this.f8459a.z().g(arrayList) : false;
            if (!arrayList2.isEmpty()) {
                for (ja.c cVar : arrayList2) {
                    ja.c cVarF = this.f8459a.z().f(cVar.a(), cVar.h());
                    if (cVarF != null) {
                        if (cVarF.h() == 1) {
                            this.f8460b.I(cVarF.d());
                        } else if (cVarF.h() == 2) {
                            this.f8460b.q(cVarF.d());
                        }
                    }
                }
            }
            return zG;
        } catch (Exception e10) {
            pc.a.i(e10);
            return false;
        }
    }

    @Override // l9.c
    public String getKey() {
        return "kvdata";
    }
}
