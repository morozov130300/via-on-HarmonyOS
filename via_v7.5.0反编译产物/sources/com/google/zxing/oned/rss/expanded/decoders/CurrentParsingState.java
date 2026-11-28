package com.google.zxing.oned.rss.expanded.decoders;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class CurrentParsingState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3448a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public State f3449b = State.NUMERIC;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public enum State {
        NUMERIC,
        ALPHA,
        ISO_IEC_646
    }

    public int a() {
        return this.f3448a;
    }

    public void b(int i10) {
        this.f3448a += i10;
    }

    public boolean c() {
        return this.f3449b == State.ALPHA;
    }

    public boolean d() {
        return this.f3449b == State.ISO_IEC_646;
    }

    public void e() {
        this.f3449b = State.ALPHA;
    }

    public void f() {
        this.f3449b = State.ISO_IEC_646;
    }

    public void g() {
        this.f3449b = State.NUMERIC;
    }

    public void h(int i10) {
        this.f3448a = i10;
    }
}
