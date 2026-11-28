package lb;

import android.content.Context;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class g {
    public static Drawable a(Context context, int i10, int i11) {
        return b(context, i10, i11 != 0 ? context.getString(i11) : null);
    }

    public static Drawable b(Context context, int i10, String str) {
        Drawable drawableE = i10 != 0 ? com.tuyafeng.support.utils.f.e(context, i10) : null;
        return (str == null || str.isEmpty()) ? drawableE : f.i().f(str, drawableE);
    }

    public static Drawable c(Context context, int i10, int i11) {
        return d(context, i10, i11 != 0 ? context.getString(i11) : null);
    }

    public static Drawable d(Context context, int i10, String str) {
        return f.i().h(str, i10 != 0 ? com.tuyafeng.support.utils.f.e(context, i10) : null);
    }

    public static void e(String str) {
        f.i().k(str);
    }
}
