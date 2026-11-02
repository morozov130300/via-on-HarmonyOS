package c9;

import android.os.Bundle;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class f {
    public static a a(Bundle bundle) {
        if (bundle == null || bundle.isEmpty() || bundle.getInt("a_type") != 1) {
            return null;
        }
        z zVar = new z();
        zVar.e(bundle.getString("w_title"));
        zVar.f(bundle.getString("w_url"));
        zVar.d(bundle.getString("w_content"));
        return zVar;
    }

    public static Bundle b(a aVar) {
        if (aVar == null || !(aVar instanceof z)) {
            return null;
        }
        z zVar = (z) aVar;
        Bundle bundle = new Bundle();
        bundle.putInt("a_type", 1);
        bundle.putString("w_title", zVar.getTitle());
        bundle.putString("w_url", zVar.c());
        bundle.putString("w_content", zVar.b());
        return bundle;
    }
}
