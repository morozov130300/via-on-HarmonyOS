package t9;

import android.content.Context;
import pa.r;
import w9.n;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class a {
    public static void a(Context context, String str, Runnable runnable) {
        r.f().b(str);
        n.e().w(true);
        if (runnable != null) {
            runnable.run();
        }
    }
}
