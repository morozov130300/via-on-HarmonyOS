package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class ua implements Iterator {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Iterator f3125c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ va f3126e;

    public ua(va vaVar) {
        this.f3126e = vaVar;
        this.f3125c = vaVar.f3151c.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3125c.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.f3125c.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
