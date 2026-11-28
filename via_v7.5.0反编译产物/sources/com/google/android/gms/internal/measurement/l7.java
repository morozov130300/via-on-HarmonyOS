package com.google.android.gms.internal.measurement;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class l7 extends j7 {
    public l7() {
        super(4);
    }

    public final l7 a(Object... objArr) {
        p7.b(objArr, 15);
        int i10 = this.f2873b;
        int i11 = i10 + 15;
        Object[] objArr2 = this.f2872a;
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
            this.f2872a = Arrays.copyOf(objArr2, i12);
            this.f2874c = false;
        } else if (this.f2874c) {
            this.f2872a = (Object[]) objArr2.clone();
            this.f2874c = false;
        }
        System.arraycopy(objArr, 0, this.f2872a, this.f2873b, 15);
        this.f2873b += 15;
        return this;
    }

    public final zzja b() {
        this.f2874c = true;
        return zzja.zzg(this.f2872a, this.f2873b);
    }
}
