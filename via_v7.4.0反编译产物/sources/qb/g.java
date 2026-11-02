package qb;

import android.os.Bundle;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class g {
    public static f a(Bundle bundle) {
        if (bundle == null || bundle.isEmpty()) {
            return null;
        }
        return new f(bundle.getString("URL", ""), bundle.getString("USERNAME", ""), bundle.getString("PASSWORD", ""), bundle.getBoolean("DIGEST_AUTH", false), bundle.getString("PATH", ""));
    }

    public static Bundle b(f fVar) {
        if (fVar == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("URL", fVar.c());
        bundle.putString("USERNAME", fVar.f());
        bundle.putString("PASSWORD", fVar.d());
        bundle.putBoolean("DIGEST_AUTH", fVar.g());
        bundle.putString("PATH", fVar.e());
        return bundle;
    }
}
