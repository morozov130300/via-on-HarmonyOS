package com.google.android.gms.internal.measurement;

import java.util.Arrays;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class l7 extends j7 {
    public l7() {
        super(4);
    }

    public final l7 a(Object... objArr) {
        p7.b(objArr, 15);
        int i10 = this.f3574b;
        int i11 = i10 + 15;
        Object[] objArr2 = this.f3573a;
        int length = objArr2.length;
        if (length < i11) {
            int i12 = length + (length >> 1) + 1;
            if (i12 < i11) {
                int iHighestOneBit = Integer.highestOneBit(i10 + 14);
                i12 = iHighestOneBit + iHighestOneBit;
            }
            if (i12 < 0) {
                i12 = Integer.MAX_VALUE;
            }
            this.f3573a = Arrays.copyOf(objArr2, i12);
            this.f3575c = false;
        } else if (this.f3575c) {
            this.f3573a = (Object[]) objArr2.clone();
            this.f3575c = false;
        }
        System.arraycopy(objArr, 0, this.f3573a, this.f3574b, 15);
        this.f3574b += 15;
        return this;
    }

    public final zzja b() {
        this.f3575c = true;
        return zzja.zzg(this.f3573a, this.f3574b);
    }
}
