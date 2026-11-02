package com.google.zxing.oned.rss.expanded.decoders;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class CurrentParsingState {

    /* renamed from: a, reason: collision with root package name */
    public int f4151a = 0;

    /* renamed from: b, reason: collision with root package name */
    public State f4152b = State.NUMERIC;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public enum State {
        NUMERIC,
        ALPHA,
        ISO_IEC_646
    }

    public int a() {
        return this.f4151a;
    }

    public void b(int i10) {
        this.f4151a += i10;
    }

    public boolean c() {
        return this.f4152b == State.ALPHA;
    }

    public boolean d() {
        return this.f4152b == State.ISO_IEC_646;
    }

    public void e() {
        this.f4152b = State.ALPHA;
    }

    public void f() {
        this.f4152b = State.ISO_IEC_646;
    }

    public void g() {
        this.f4152b = State.NUMERIC;
    }

    public void h(int i10) {
        this.f4151a = i10;
    }
}
