package g2;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class cb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h5 f4694a;

    public cb(h5 h5Var) {
        this.f4694a = h5Var;
    }

    public final void a(String str, Bundle bundle) {
        String string;
        this.f4694a.f().h();
        if (this.f4694a.o()) {
            return;
        }
        if (bundle.isEmpty()) {
            string = null;
        } else {
            if (true == str.isEmpty()) {
                str = "auto";
            }
            Uri.Builder builder = new Uri.Builder();
            builder.path(str);
            for (String str2 : bundle.keySet()) {
                builder.appendQueryParameter(str2, bundle.getString(str2));
            }
            string = builder.build().toString();
        }
        if (TextUtils.isEmpty(string)) {
            return;
        }
        this.f4694a.F().f5064v.b(string);
        this.f4694a.F().f5065w.b(this.f4694a.a().a());
    }

    public final void b() {
        this.f4694a.f().h();
        if (d()) {
            if (e()) {
                this.f4694a.F().f5064v.b(null);
                Bundle bundle = new Bundle();
                bundle.putString("source", "(not set)");
                bundle.putString("medium", "(not set)");
                bundle.putString("_cis", "intent");
                bundle.putLong("_cc", 1L);
                this.f4694a.I().u("auto", "_cmpx", bundle);
            } else {
                String strA = this.f4694a.F().f5064v.a();
                if (TextUtils.isEmpty(strA)) {
                    this.f4694a.d().t().a("Cache still valid but referrer not found");
                } else {
                    long jA = this.f4694a.F().f5065w.a() / 3600000;
                    Uri uri = Uri.parse(strA);
                    Bundle bundle2 = new Bundle();
                    Pair pair = new Pair(uri.getPath(), bundle2);
                    for (String str : uri.getQueryParameterNames()) {
                        bundle2.putString(str, uri.getQueryParameter(str));
                    }
                    ((Bundle) pair.second).putLong("_cc", (jA - 1) * 3600000);
                    Object obj = pair.first;
                    this.f4694a.I().u(obj == null ? "app" : (String) obj, "_cmp", (Bundle) pair.second);
                }
                this.f4694a.F().f5064v.b(null);
            }
            this.f4694a.F().f5065w.b(0L);
        }
    }

    public final void c() {
        if (d() && e()) {
            this.f4694a.F().f5064v.b(null);
        }
    }

    public final boolean d() {
        return this.f4694a.F().f5065w.a() > 0;
    }

    public final boolean e() {
        return d() && this.f4694a.a().a() - this.f4694a.F().f5065w.a() > this.f4694a.z().r(null, i3.U);
    }
}
