package g6;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class h {
    public static void a(Drawable drawable, int i10) {
        b(drawable, i10, PorterDuff.Mode.SRC_IN);
    }

    public static void b(Drawable drawable, int i10, PorterDuff.Mode mode) {
        if (drawable == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            drawable.setColorFilter(new PorterDuffColorFilter(i10, mode));
        } else {
            drawable.setColorFilter(i10, mode);
        }
    }
}
