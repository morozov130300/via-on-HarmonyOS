package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class o7 extends q7 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2945c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f2946e;

    public o7(Object obj) {
        this.f2946e = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.f2945c;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f2945c) {
            throw new NoSuchElementException();
        }
        this.f2945c = true;
        return this.f2946e;
    }
}
