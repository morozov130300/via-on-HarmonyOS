package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class h8 extends j8 {

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f3531b;

    /* renamed from: c, reason: collision with root package name */
    public int f3532c;

    /* renamed from: d, reason: collision with root package name */
    public int f3533d;

    /* renamed from: e, reason: collision with root package name */
    public int f3534e;

    public /* synthetic */ h8(byte[] bArr, int i10, int i11, boolean z10, g8 g8Var) {
        super(null);
        this.f3534e = Integer.MAX_VALUE;
        this.f3531b = bArr;
        this.f3532c = 0;
    }

    public final int c(int i10) {
        int i11 = this.f3534e;
        this.f3534e = 0;
        int i12 = this.f3532c + this.f3533d;
        this.f3532c = i12;
        if (i12 <= 0) {
            this.f3533d = 0;
            return i11;
        }
        this.f3533d = i12;
        this.f3532c = 0;
        return i11;
    }
}
