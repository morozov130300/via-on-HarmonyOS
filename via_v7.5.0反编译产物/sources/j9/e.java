package j9;

import android.text.TextUtils;
import android.util.Base64;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import la.s;
import org.json.JSONObject;
import u9.n;
import x8.b0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class e implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w9.a f6739a;

    public e(w9.a aVar) {
        this.f6739a = aVar;
    }

    @Override // j9.c
    public String a() {
        StringBuilder sb2 = new StringBuilder();
        try {
            List<l9.b> listH = s.f().h();
            JSONObject jSONObject = new JSONObject();
            for (l9.b bVar : listH) {
                jSONObject.put("title", bVar.e());
                jSONObject.put("url", bVar.g());
                jSONObject.put("order", bVar.d());
                sb2.append(jSONObject);
                sb2.append("\n");
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
            if (!TextUtils.isEmpty(str2)) {
                ArrayList arrayList = new ArrayList();
                Charset charset = k8.a.f7218a;
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(str2.getBytes(charset)), charset));
                while (true) {
                    String line = bufferedReader.readLine();
                    if (TextUtils.isEmpty(line)) {
                        bufferedReader.close();
                        this.f6739a.j(arrayList);
                        n.e().u(true);
                        return true;
                    }
                    l9.b bVarC = c(line);
                    if (bVarC != null) {
                        arrayList.add(bVarC);
                    }
                }
            }
        } catch (Exception e10) {
            tc.a.e(e10);
        }
        return false;
    }

    public final l9.b c(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                l9.b bVar = new l9.b();
                bVar.o(jSONObject.getString("title"));
                bVar.q(jSONObject.getString("url"));
                bVar.n(jSONObject.getInt("order"));
                return bVar;
            } catch (Exception e10) {
                tc.a.j(e10);
            }
        }
        return null;
    }

    @Override // j9.c
    public String getKey() {
        return "favorite";
    }
}
