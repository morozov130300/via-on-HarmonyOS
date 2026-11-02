package b6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class c {

    /* renamed from: c, reason: collision with root package name */
    public static final int f1828c = f.f1835a;

    /* renamed from: d, reason: collision with root package name */
    public static final int f1829d = f.f1836b;

    /* renamed from: e, reason: collision with root package name */
    public static final int f1830e = f.f1837c;

    /* renamed from: f, reason: collision with root package name */
    public static final int f1831f = f.f1838d;

    /* renamed from: g, reason: collision with root package name */
    public static final int f1832g = f.f1839e;

    /* renamed from: a, reason: collision with root package name */
    public final int f1833a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1834b;

    public c(int i10, int i11) {
        this.f1833a = i10;
        this.f1834b = i11;
    }

    public static c b() {
        return new c(-2, 0);
    }

    public static c c() {
        return new c(-4, 0);
    }

    public static c d() {
        return new c(-5, 0);
    }

    public static c e(int i10) {
        return new c(0, i10);
    }

    public static c f() {
        return new c(-7, 0);
    }

    public static c g() {
        return new c(-6, 0);
    }

    public static c h() {
        return new c(-1, 0);
    }

    public View a(ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        return this.f1834b != 0 ? LayoutInflater.from(context).inflate(this.f1834b, viewGroup, false) : f.i(context, this.f1833a);
    }
}
