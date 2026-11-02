package h8;

import android.graphics.drawable.Drawable;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a {

    /* renamed from: g, reason: collision with root package name */
    public static final a f6405g = new a(22, null, null, false);

    /* renamed from: a, reason: collision with root package name */
    public final int f6406a;

    /* renamed from: b, reason: collision with root package name */
    public Drawable f6407b;

    /* renamed from: c, reason: collision with root package name */
    public String f6408c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f6409d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f6410e;

    /* renamed from: f, reason: collision with root package name */
    public String f6411f;

    public a(int i10, Drawable drawable, String str, boolean z10) {
        this(i10, drawable, str, z10, false);
    }

    public a(int i10, Drawable drawable, String str, boolean z10, boolean z11) {
        this.f6406a = i10;
        this.f6407b = drawable;
        this.f6408c = str;
        this.f6409d = z10;
        this.f6410e = z11;
    }

    public static a g() {
        return f6405g;
    }

    public String a() {
        String str = this.f6411f;
        return str == null ? this.f6408c : str;
    }

    public Drawable b() {
        return this.f6407b;
    }

    public int c() {
        return this.f6406a;
    }

    public String d() {
        return this.f6408c;
    }

    public boolean e() {
        return this.f6409d;
    }

    public boolean f() {
        return this.f6410e;
    }

    public void h(String str) {
        this.f6411f = str;
    }

    public void i(boolean z10) {
        this.f6409d = z10;
    }

    public void j(boolean z10) {
        this.f6410e = z10;
    }

    public void k(String str) {
        this.f6408c = str;
    }
}
