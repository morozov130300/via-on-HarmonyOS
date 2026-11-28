package j9;

import android.text.TextUtils;
import android.util.Base64;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import x8.b0;
import x8.n;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m9.c f6738a;

    public b(m9.c cVar) {
        this.f6738a = cVar;
    }

    @Override // j9.c
    public String a() {
        StringBuilder sb2 = new StringBuilder();
        try {
            List<l9.b> listB = n.b(x.d.a(this.f6738a.j(), this.f6738a.u()));
            if (listB.isEmpty()) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            for (l9.b bVar : listB) {
                jSONObject.put("title", bVar.e());
                jSONObject.put("url", bVar.g());
                jSONObject.put("folder", bVar.b());
                jSONObject.put("order", bVar.d());
                jSONObject.put("updated_at", bVar.f());
                jSONObject.put("created_at", bVar.a());
                sb2.append(jSONObject);
                sb2.append("\n");
            }
            String strTrim = sb2.toString().trim();
            Charset charset = k8.a.f7218a;
            return new String(Base64.encode(strTrim.getBytes(charset), 0), charset);
        } catch (Exception e10) {
            tc.a.j(e10);
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
            Charset charset = k8.a.f7218a;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(str2.getBytes(charset)), charset));
            long jCurrentTimeMillis = (System.currentTimeMillis() / 1000) - 30;
            while (true) {
                String line = bufferedReader.readLine();
                if (TextUtils.isEmpty(line)) {
                    bufferedReader.close();
                    this.f6738a.A(n.c(arrayList));
                    u9.n.e().q(true);
                    return true;
                }
                l9.b bVarC = c(line);
                if (bVarC != null) {
                    if (bVarC.a() == 0) {
                        bVarC.k(jCurrentTimeMillis);
                    }
                    if (bVarC.f() == 0) {
                        bVarC.p(jCurrentTimeMillis);
                    }
                    jCurrentTimeMillis++;
                    arrayList.add(bVarC);
                }
            }
        } catch (Exception e10) {
            tc.a.j(e10);
            return false;
        }
    }

    public final l9.b c(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            l9.b bVar = new l9.b();
            bVar.q(jSONObject.getString("url"));
            if (bVar.g() != null && !bVar.g().isEmpty()) {
                bVar.o(jSONObject.optString("title", ""));
                bVar.l(jSONObject.optString("folder", ""));
                bVar.n(jSONObject.optInt("order", 0));
                bVar.p(jSONObject.optLong("updated_at", 0L));
                bVar.k(jSONObject.optLong("created_at", 0L));
                return bVar;
            }
            return null;
        } catch (Exception e10) {
            tc.a.j(e10);
            return null;
        }
    }

    @Override // j9.c
    public String getKey() {
        return "bookmark";
    }
}
