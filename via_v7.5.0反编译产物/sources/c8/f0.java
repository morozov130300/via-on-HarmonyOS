package c8;

import android.os.Bundle;
import android.webkit.HttpAuthHandler;
import androidx.fragment.app.Fragment;
import java.util.HashMap;
import java.util.Map;
import mark.via.browser.ga;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class f0 extends q4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f2197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f2198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f2199c = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface a {
        void a(String str, String str2, String str3);
    }

    public f0(Fragment fragment, a aVar) {
        this.f2197a = fragment;
        this.f2198b = aVar;
    }

    public static /* synthetic */ void J(f0 f0Var, HttpAuthHandler httpAuthHandler, String str, String str2, String str3, Bundle bundle) {
        f0Var.getClass();
        String string = bundle.getString("username");
        String string2 = bundle.getString("password");
        if (com.tuyafeng.support.utils.p.f(string) || com.tuyafeng.support.utils.p.f(string2)) {
            httpAuthHandler.cancel();
        } else {
            httpAuthHandler.proceed(string, string2);
            if (!com.tuyafeng.support.utils.p.f(str)) {
                f0Var.f2199c.put(str, okhttp3.l.a(string, string2));
            }
            f0Var.f2198b.a(str2, string, string2);
        }
        f0Var.f2197a.L0().x("url");
    }

    public String K(String str) {
        return (String) this.f2199c.get(str);
    }

    @Override // q4.a
    public boolean u(t4.b bVar, final HttpAuthHandler httpAuthHandler, final String str, String str2) {
        if (!bVar.isShown()) {
            httpAuthHandler.cancel();
            return true;
        }
        final String str3 = "https://" + str;
        this.f2197a.L0().z1("url", this.f2197a, new androidx.fragment.app.i0() { // from class: c8.e0
            @Override // androidx.fragment.app.i0
            public final void a(String str4, Bundle bundle) {
                f0.J(this.f2189a, httpAuthHandler, str, str3, str4, bundle);
            }
        });
        ga.v3(str3).g3(this.f2197a.L0(), null);
        return true;
    }
}
