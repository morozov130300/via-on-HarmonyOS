package f2;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.ke;
import java.util.HashMap;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class da extends aa {
    public da(pa paVar) {
        super(paVar);
    }

    public final ca i(String str) {
        ke.b();
        ca caVar = null;
        if (this.f5030a.z().B(null, i3.f5332s0)) {
            this.f5030a.d().v().a("sgtm feature flag enabled.");
            e6 e6VarR = this.f5039b.V().R(str);
            if (e6VarR == null) {
                return new ca(j(str));
            }
            if (e6VarR.Q()) {
                this.f5030a.d().v().a("sgtm upload enabled in manifest.");
                com.google.android.gms.internal.measurement.v3 v3VarT = this.f5039b.Z().t(e6VarR.l0());
                if (v3VarT != null) {
                    String strM = v3VarT.M();
                    if (!TextUtils.isEmpty(strM)) {
                        String strL = v3VarT.L();
                        this.f5030a.d().v().c("sgtm configured with upload_url, server_info", strM, true != TextUtils.isEmpty(strL) ? "N" : "Y");
                        if (TextUtils.isEmpty(strL)) {
                            this.f5030a.b();
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
        String strW = this.f5039b.Z().w(str);
        if (TextUtils.isEmpty(strW)) {
            return (String) i3.f5331s.a(null);
        }
        Uri uri = Uri.parse((String) i3.f5331s.a(null));
        Uri.Builder builderBuildUpon = uri.buildUpon();
        builderBuildUpon.authority(strW + "." + uri.getAuthority());
        return builderBuildUpon.build().toString();
    }
}
