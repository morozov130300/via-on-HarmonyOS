package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class d implements Iterator {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Iterator f3434e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Iterator f3435j;

    public d(f fVar, Iterator it, Iterator it2) {
        this.f3434e = it;
        this.f3435j = it2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f3434e.hasNext()) {
            return true;
        }
        return this.f3435j.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        if (this.f3434e.hasNext()) {
            return new v(((Integer) this.f3434e.next()).toString());
        }
        if (this.f3435j.hasNext()) {
            return new v((String) this.f3435j.next());
        }
        throw new NoSuchElementException();
    }
}
