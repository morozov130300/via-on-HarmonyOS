package g2;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.ke;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class da extends aa {
    public da(pa paVar) {
        super(paVar);
    }

    public final ca i(String str) {
        ke.b();
        ca caVar = null;
        if (this.f4646a.z().B(null, i3.f4948s0)) {
            this.f4646a.d().v().a("sgtm feature flag enabled.");
            e6 e6VarR = this.f4655b.V().R(str);
            if (e6VarR == null) {
                return new ca(j(str));
            }
            if (e6VarR.Q()) {
                this.f4646a.d().v().a("sgtm upload enabled in manifest.");
                com.google.android.gms.internal.measurement.v3 v3VarT = this.f4655b.Z().t(e6VarR.l0());
                if (v3VarT != null) {
                    String strM = v3VarT.M();
                    if (!TextUtils.isEmpty(strM)) {
                        String strL = v3VarT.L();
                        this.f4646a.d().v().c("sgtm configured with upload_url, server_info", strM, true != TextUtils.isEmpty(strL) ? "N" : "Y");
                        if (TextUtils.isEmpty(strL)) {
                            this.f4646a.b();
                            caVar = new ca(strM);
                        } else {
                            HashMap map = new HashMap();
                            map.put("x-google-sgtm-server-info", strL);
                            caVar = new ca(strM, map);
                        }
                    }
                }
            }
            if (caVar != null) {
                return caVar;
            }
        }
        return new ca(j(str));
    }

    public final String j(String str) throws Throwable {
        String strW = this.f4655b.Z().w(str);
        if (TextUtils.isEmpty(strW)) {
            return (String) i3.f4947s.a(null);
        }
        Uri uri = Uri.parse((String) i3.f4947s.a(null));
        Uri.Builder builderBuildUpon = uri.buildUpon();
        builderBuildUpon.authority(strW + "." + uri.getAuthority());
        return builderBuildUpon.build().toString();
    }
}
