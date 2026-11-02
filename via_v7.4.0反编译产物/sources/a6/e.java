package a6;

import android.graphics.drawable.Drawable;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class e extends d {

    /* renamed from: b, reason: collision with root package name */
    public int f103b;

    /* renamed from: c, reason: collision with root package name */
    public Drawable f104c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f105d;

    public e(int i10, String str, Drawable drawable) {
        this(i10, str, drawable, false);
    }

    public e(int i10, String str, Drawable drawable, boolean z10) {
        super(str);
        this.f103b = i10;
        this.f104c = drawable;
        this.f105d = z10;
    }

    public Drawable c() {
        return this.f104c;
    }

    public int d() {
        return this.f103b;
    }

    public boolean e() {
        return this.f105d;
    }

    @Override // a6.d
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f103b == eVar.f103b && this.f105d == eVar.f105d;
    }

    @Override // a6.d
    public int hashCode() {
        return (((super.hashCode() * 31) + this.f103b) * 31) + (this.f105d ? 1 : 0);
    }
}
