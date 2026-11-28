package r8;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import w7.u;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b implements d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f12060c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f12061a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FirebaseAnalytics f12062b;

    static {
        f12060c = Build.VERSION.SDK_INT >= 21;
    }

    public b(Context context) {
        if (f12060c) {
            if (!i2.e.k(context).isEmpty()) {
                this.f12062b = FirebaseAnalytics.getInstance(context);
                return;
            }
            i2.e.r(context, c.a(context.getString(u.f14057g6)));
            this.f12062b = FirebaseAnalytics.getInstance(context);
            tc.a.a("init firebase", new Object[0]);
        }
    }

    @Override // r8.d
    public void a(String str, Map map) {
        Bundle bundle;
        if (this.f12061a) {
            if (map == null || map.isEmpty()) {
                bundle = null;
            } else {
                bundle = new Bundle();
                for (Map.Entry entry : map.entrySet()) {
                    bundle.putString((String) entry.getKey(), (String) entry.getValue());
                }
            }
            this.f12062b.a(str, bundle);
            tc.a.a("log event: %s", str);
        }
    }

    @Override // r8.d
    public void b(String str, String str2, Throwable th) {
        if (this.f12061a) {
            tc.a.a("log crash: %s", str);
        }
    }

    @Override // r8.d
    public void setEnabled(boolean z10) {
        this.f12061a = f12060c && z10;
    }
}
