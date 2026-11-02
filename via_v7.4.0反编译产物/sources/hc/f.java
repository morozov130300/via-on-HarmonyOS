package hc;

import kc.y;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class f implements nc.b {

    /* renamed from: a, reason: collision with root package name */
    public final y f6885a;

    /* renamed from: b, reason: collision with root package name */
    public final char f6886b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f6887c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f6888d;

    /* renamed from: e, reason: collision with root package name */
    public f f6889e;

    /* renamed from: f, reason: collision with root package name */
    public f f6890f;

    /* renamed from: g, reason: collision with root package name */
    public int f6891g = 1;

    /* renamed from: h, reason: collision with root package name */
    public int f6892h = 1;

    public f(y yVar, char c10, boolean z10, boolean z11, f fVar) {
        this.f6885a = yVar;
        this.f6886b = c10;
        this.f6887c = z10;
        this.f6888d = z11;
        this.f6889e = fVar;
    }

    @Override // nc.b
    public int a() {
        return this.f6892h;
    }

    @Override // nc.b
    public boolean b() {
        return this.f6887c;
    }

    @Override // nc.b
    public boolean c() {
        return this.f6888d;
    }

    @Override // nc.b
    public int length() {
        return this.f6891g;
    }
}
