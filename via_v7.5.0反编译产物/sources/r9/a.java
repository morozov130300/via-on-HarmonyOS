package r9;

import android.content.Context;
import la.s;
import u9.n;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static void a(Context context, String str, Runnable runnable) {
        s.f().b(str);
        n.e().u(true);
        if (runnable != null) {
            runnable.run();
        }
    }
}
