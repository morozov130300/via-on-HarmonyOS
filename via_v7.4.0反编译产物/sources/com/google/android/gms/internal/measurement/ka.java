package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class ka implements x9 {

    /* renamed from: a, reason: collision with root package name */
    public final aa f3592a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3593b;

    /* renamed from: c, reason: collision with root package name */
    public final Object[] f3594c;

    /* renamed from: d, reason: collision with root package name */
    public final int f3595d;

    public ka(aa aaVar, String str, Object[] objArr) {
        this.f3592a = aaVar;
        this.f3593b = str;
        this.f3594c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < '\ud800') {
            this.f3595d = cCharAt;
            return;
        }
        int i10 = cCharAt & '\u1fff';
        int i11 = 1;
        int i12 = 13;
        while (true) {
            int i13 = i11 + 1;
            char cCharAt2 = str.charAt(i11);
            if (cCharAt2 < '\ud800') {
                this.f3595d = i10 | (cCharAt2 << i12);
                return;
            } else {
                i10 |= (cCharAt2 & '\u1fff') << i12;
                i12 += 13;
                i11 = i13;
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.x9
    public final boolean a() {
        return (this.f3595d & 2) == 2;
    }

    @Override // com.google.android.gms.internal.measurement.x9
    public final int b() {
        return (this.f3595d & 1) == 1 ? 1 : 2;
    }

    public final String c() {
        return this.f3593b;
    }

    public final Object[] d() {
        return this.f3594c;
    }

    @Override // com.google.android.gms.internal.measurement.x9
    public final aa zza() {
        return this.f3592a;
    }
}
