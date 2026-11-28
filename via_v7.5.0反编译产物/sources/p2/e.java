package p2;

import android.os.Bundle;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class e implements k2.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public r2.b f11557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public r2.b f11558b;

    public static void b(r2.b bVar, String str, Bundle bundle) {
        if (bVar == null) {
            return;
        }
        bVar.onEvent(str, bundle);
    }

    @Override // k2.a.b
    public void a(int i10, Bundle bundle) {
        String string;
        q2.f.f().i(String.format(Locale.US, "Analytics listener received message. ID: %d, Extras: %s", Integer.valueOf(i10), bundle));
        if (bundle == null || (string = bundle.getString("name")) == null) {
            return;
        }
        Bundle bundle2 = bundle.getBundle("params");
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        c(string, bundle2);
    }

    public final void c(String str, Bundle bundle) {
        b("clx".equals(bundle.getString("_o")) ? this.f11557a : this.f11558b, str, bundle);
    }

    public void d(r2.b bVar) {
        this.f11558b = bVar;
    }

    public void e(r2.b bVar) {
        this.f11557a = bVar;
    }
}
