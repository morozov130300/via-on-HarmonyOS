package j9;

import android.util.Base64;
import java.nio.charset.Charset;
import org.json.JSONObject;
import u9.l;
import u9.n;
import x8.b0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class f implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f6740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f6741b;

    public f(l lVar, boolean z10) {
        this.f6740a = lVar;
        this.f6741b = z10;
    }

    @Override // j9.c
    public String a() {
        try {
            String strTrim = this.f6740a.P2(this.f6741b).toString().trim();
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
            String str2 = new String(Base64.decode(str, 0), k8.a.f7218a);
            if (str2.isEmpty()) {
                return false;
            }
            this.f6740a.k1(new JSONObject(str2));
            n.e().n(true).o(true);
            return true;
        } catch (Exception e10) {
            tc.a.e(e10);
            return false;
        }
    }

    @Override // j9.c
    public String getKey() {
        return "settings";
    }
}
