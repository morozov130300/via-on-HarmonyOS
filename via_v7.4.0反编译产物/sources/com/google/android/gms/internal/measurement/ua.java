package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class ua implements Iterator {

    /* renamed from: e, reason: collision with root package name */
    public final Iterator f3826e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ va f3827j;

    public ua(va vaVar) {
        this.f3827j = vaVar;
        this.f3826e = vaVar.f3852e.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3826e.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.f3826e.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
