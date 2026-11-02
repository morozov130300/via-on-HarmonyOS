package lb;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import java.io.File;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    public static a f8466c;

    /* renamed from: a, reason: collision with root package name */
    public String f8467a = null;

    /* renamed from: b, reason: collision with root package name */
    public final k.e f8468b = new k.e(32);

    public static Drawable b(String str) {
        Bitmap bitmapC;
        if (str == null || str.isEmpty() || !new File(str).exists() || (bitmapC = z8.i.c(str, 96, 96)) == null) {
            return null;
        }
        return new BitmapDrawable((Resources) null, bitmapC);
    }

    public static a c() {
        if (f8466c == null) {
            f8466c = new a();
        }
        return f8466c;
    }

    public Drawable a(String str) {
        Drawable.ConstantState constantState;
        String str2 = this.f8467a;
        if (str2 == null || str2.isEmpty() || str == null || !str.startsWith("ic_")) {
            return null;
        }
        Drawable.ConstantState constantState2 = (Drawable.ConstantState) this.f8468b.d(str);
        Drawable drawableNewDrawable = constantState2 != null ? constantState2.newDrawable() : b(d(this.f8467a, str));
        boolean z10 = drawableNewDrawable instanceof DrawableContainer;
        if (drawableNewDrawable != null) {
            Drawable.ConstantState constantState3 = drawableNewDrawable.getConstantState();
            if (constantState3 != null) {
                this.f8468b.e(str, constantState3);
            }
            if (z10 && (constantState = drawableNewDrawable.getConstantState()) != null) {
                return constantState.newDrawable();
            }
        }
        return drawableNewDrawable;
    }

    public final String d(String str, String str2) {
        if (str == null || str.isEmpty() || str2 == null || str2.isEmpty()) {
            return null;
        }
        return str + File.separator + str2 + ".png";
    }

    public void e(String str) {
        this.f8467a = str;
    }
}
