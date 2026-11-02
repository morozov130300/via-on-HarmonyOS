package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class m implements Iterator {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Iterator f3614e;

    public m(Iterator it) {
        this.f3614e = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3614e.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return new v((String) this.f3614e.next());
    }
}
