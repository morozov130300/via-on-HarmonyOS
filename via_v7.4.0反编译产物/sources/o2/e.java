package o2;

import android.os.Bundle;
import j2.a;
import java.util.Locale;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class e implements a.b {

    /* renamed from: a, reason: collision with root package name */
    public q2.b f10340a;

    /* renamed from: b, reason: collision with root package name */
    public q2.b f10341b;

    public static void b(q2.b bVar, String str, Bundle bundle) {
        if (bVar == null) {
            return;
        }
        bVar.onEvent(str, bundle);
    }

    @Override // j2.a.b
    public void a(int i10, Bundle bundle) {
        String string;
        p2.f.f().i(String.format(Locale.US, "Analytics listener received message. ID: %d, Extras: %s", Integer.valueOf(i10), bundle));
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
        b("clx".equals(bundle.getString("_o")) ? this.f10340a : this.f10341b, str, bundle);
    }

    public void d(q2.b bVar) {
        this.f10341b = bVar;
    }

    public void e(q2.b bVar) {
        this.f10340a = bVar;
    }
}
