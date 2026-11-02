package x7;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class f {

    /* renamed from: b, reason: collision with root package name */
    public static volatile f f13630b;

    /* renamed from: a, reason: collision with root package name */
    public Drawable f13631a;

    public static f a() {
        if (f13630b == null) {
            synchronized (f.class) {
                try {
                    if (f13630b == null) {
                        f13630b = new f();
                    }
                } finally {
                }
            }
        }
        return f13630b;
    }

    public Drawable b() {
        if (this.f13631a == null) {
            this.f13631a = new ColorDrawable(-1);
        }
        return this.f13631a;
    }

    public void c(Drawable drawable) {
        this.f13631a = drawable;
    }
}
