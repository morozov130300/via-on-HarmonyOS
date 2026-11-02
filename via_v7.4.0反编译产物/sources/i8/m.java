package i8;

import android.graphics.drawable.Drawable;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public final int f7075a;

    /* renamed from: b, reason: collision with root package name */
    public Drawable f7076b;

    /* renamed from: c, reason: collision with root package name */
    public String f7077c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f7078d;

    public m(int i10, Drawable drawable, String str, boolean z10) {
        this.f7075a = i10;
        this.f7076b = drawable;
        this.f7077c = str;
        this.f7078d = z10;
    }

    public Drawable a() {
        return this.f7076b;
    }

    public int b() {
        return this.f7075a;
    }

    public String c() {
        return this.f7077c;
    }

    public void d(boolean z10) {
        this.f7078d = z10;
    }

    public String toString() {
        return "BrowserMenuWrapper{id=" + this.f7075a + ", title='" + this.f7077c + "', isAdded=" + this.f7078d + '}';
    }
}
