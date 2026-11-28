package j9;

import android.text.TextUtils;
import android.util.Base64;
import java.nio.charset.Charset;
import org.json.JSONObject;
import x8.b0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u4.a f6736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6737b;

    public a(u4.a aVar, int i10) {
        this.f6736a = aVar;
        this.f6737b = i10;
    }

    @Override // j9.c
    public String a() {
        u4.a aVar = this.f6736a;
        if (aVar == null) {
            return null;
        }
        JSONObject jSONObjectC = aVar.c(this.f6737b);
        if (jSONObjectC.length() <= 0) {
            return null;
        }
        String strTrim = jSONObjectC.toString().trim();
        Charset charset = k8.a.f7218a;
        return new String(Base64.encode(strTrim.getBytes(charset), 0), charset);
    }

    @Override // j9.c
    public boolean b(String str) {
        if (b0.a(str)) {
            return false;
        }
        try {
            String str2 = new String(Base64.decode(str, 0), k8.a.f7218a);
            return !TextUtils.isEmpty(str2) && this.f6736a.h(str2);
        } catch (Exception e10) {
            tc.a.e(e10);
        }
    }

    @Override // j9.c
    public String getKey() {
        return "adrules";
    }
}
