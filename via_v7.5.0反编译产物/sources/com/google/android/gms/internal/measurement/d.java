package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class d implements Iterator {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Iterator f2733c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Iterator f2734e;

    public d(f fVar, Iterator it, Iterator it2) {
        this.f2733c = it;
        this.f2734e = it2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f2733c.hasNext()) {
            return true;
        }
        return this.f2734e.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        if (this.f2733c.hasNext()) {
            return new v(((Integer) this.f2733c.next()).toString());
        }
        if (this.f2734e.hasNext()) {
            return new v((String) this.f2734e.next());
        }
        throw new NoSuchElementException();
    }
}
