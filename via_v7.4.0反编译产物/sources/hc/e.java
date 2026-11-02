package hc;

import kc.y;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final y f6878a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6879b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f6880c;

    /* renamed from: d, reason: collision with root package name */
    public final e f6881d;

    /* renamed from: e, reason: collision with root package name */
    public final f f6882e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f6883f = true;

    /* renamed from: g, reason: collision with root package name */
    public boolean f6884g = false;

    public e(y yVar, int i10, e eVar, f fVar, boolean z10) {
        this.f6878a = yVar;
        this.f6879b = i10;
        this.f6880c = z10;
        this.f6881d = eVar;
        this.f6882e = fVar;
    }

    public static e a(y yVar, int i10, e eVar, f fVar) {
        return new e(yVar, i10, eVar, fVar, true);
    }

    public static e b(y yVar, int i10, e eVar, f fVar) {
        return new e(yVar, i10, eVar, fVar, false);
    }
}
