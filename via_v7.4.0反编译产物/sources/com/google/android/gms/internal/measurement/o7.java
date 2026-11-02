package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class o7 extends q7 {

    /* renamed from: e, reason: collision with root package name */
    public boolean f3646e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f3647j;

    public o7(Object obj) {
        this.f3647j = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.f3646e;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f3646e) {
            throw new NoSuchElementException();
        }
        this.f3646e = true;
        return this.f3647j;
    }
}
