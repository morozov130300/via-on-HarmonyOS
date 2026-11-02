package t8;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import x7.u;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b implements d {

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f12285c;

    /* renamed from: a, reason: collision with root package name */
    public boolean f12286a = false;

    /* renamed from: b, reason: collision with root package name */
    public FirebaseAnalytics f12287b;

    static {
        f12285c = Build.VERSION.SDK_INT >= 21;
    }

    public b(Context context) {
        if (f12285c) {
            if (!h2.e.k(context).isEmpty()) {
                this.f12287b = FirebaseAnalytics.getInstance(context);
                return;
            }
            h2.e.r(context, c.a(context.getString(u.U5)));
            this.f12287b = FirebaseAnalytics.getInstance(context);
            pc.a.a("init firebase", new Object[0]);
        }
    }

    @Override // t8.d
    public void a(String str, Map map) {
        Bundle bundle;
        if (this.f12286a) {
            if (map == null || map.isEmpty()) {
                bundle = null;
            } else {
                bundle = new Bundle();
                for (Map.Entry entry : map.entrySet()) {
                    bundle.putString((String) entry.getKey(), (String) entry.getValue());
                }
            }
            this.f12287b.a(str, bundle);
            pc.a.a("log event: %s", str);
        }
    }

    @Override // t8.d
    public void setEnabled(boolean z10) {
        this.f12286a = f12285c && z10;
    }
}
