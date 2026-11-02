package lb;

import android.content.Context;
import android.graphics.drawable.Drawable;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class b {
    public static Drawable a(Context context, int i10, int i11) {
        return b(context, i10, i11 != 0 ? context.getString(i11) : null);
    }

    public static Drawable b(Context context, int i10, String str) {
        Drawable drawableA = (str == null || str.isEmpty()) ? null : a.c().a(str);
        return (drawableA != null || i10 == 0) ? drawableA : g6.f.e(context, i10);
    }

    public static void c(String str) {
        a.c().e(str);
    }
}
