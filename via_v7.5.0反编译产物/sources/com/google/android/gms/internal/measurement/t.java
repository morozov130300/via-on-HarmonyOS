package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class t implements Iterator {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3072c = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ v f3073e;

    public t(v vVar) {
        this.f3073e = vVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3072c < this.f3073e.f3130c.length();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        int i10 = this.f3072c;
        if (i10 >= this.f3073e.f3130c.length()) {
            throw new NoSuchElementException();
        }
        this.f3072c = i10 + 1;
        return new v(String.valueOf(i10));
    }
}
