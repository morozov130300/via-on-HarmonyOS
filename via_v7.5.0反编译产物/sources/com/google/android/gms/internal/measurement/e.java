package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class e implements Iterator {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2770c = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ f f2771e;

    public e(f fVar) {
        this.f2771e = fVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f2770c < this.f2771e.t();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        if (this.f2770c < this.f2771e.t()) {
            f fVar = this.f2771e;
            int i10 = this.f2770c;
            this.f2770c = i10 + 1;
            return fVar.u(i10);
        }
        throw new NoSuchElementException("Out of bounds index: " + this.f2770c);
    }
}
