package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class t implements Iterator {

    /* renamed from: e, reason: collision with root package name */
    public int f3773e = 0;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ v f3774j;

    public t(v vVar) {
        this.f3774j = vVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3773e < this.f3774j.f3831e.length();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        int i10 = this.f3773e;
        if (i10 >= this.f3774j.f3831e.length()) {
            throw new NoSuchElementException();
        }
        this.f3773e = i10 + 1;
        return new v(String.valueOf(i10));
    }
}
