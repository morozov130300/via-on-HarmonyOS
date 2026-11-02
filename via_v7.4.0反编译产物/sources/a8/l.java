package a8;

import android.graphics.drawable.Drawable;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public final Drawable f217a;

    /* renamed from: b, reason: collision with root package name */
    public final String f218b;

    public l(Drawable drawable, String str) {
        this.f217a = drawable;
        this.f218b = str;
    }

    public Drawable a() {
        return this.f217a;
    }

    public String b() {
        return this.f218b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return z8.u1.a(this.f218b, ((l) obj).f218b);
    }

    public int hashCode() {
        return z8.u1.b(this.f218b);
    }
}
