package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class e implements Iterator {

    /* renamed from: e, reason: collision with root package name */
    public int f3471e = 0;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ f f3472j;

    public e(f fVar) {
        this.f3472j = fVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3471e < this.f3472j.t();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        if (this.f3471e < this.f3472j.t()) {
            f fVar = this.f3472j;
            int i10 = this.f3471e;
            this.f3471e = i10 + 1;
            return fVar.u(i10);
        }
        throw new NoSuchElementException("Out of bounds index: " + this.f3471e);
    }
}
