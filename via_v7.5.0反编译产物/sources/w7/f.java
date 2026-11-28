package w7;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile f f13697b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f13698a;

    public static f a() {
        if (f13697b == null) {
            synchronized (f.class) {
                try {
                    if (f13697b == null) {
                        f13697b = new f();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f13697b;
    }

    public Drawable b() {
        if (this.f13698a == null) {
            this.f13698a = new ColorDrawable(-1);
        }
        return this.f13698a;
    }

    public void c(Drawable drawable) {
        this.f13698a = drawable;
    }
}
