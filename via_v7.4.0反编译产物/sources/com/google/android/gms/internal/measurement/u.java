package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class u implements Iterator {

    /* renamed from: e, reason: collision with root package name */
    public int f3804e = 0;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ v f3805j;

    public u(v vVar) {
        this.f3805j = vVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3804e < this.f3805j.f3831e.length();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        int i10 = this.f3804e;
        v vVar = this.f3805j;
        if (i10 >= vVar.f3831e.length()) {
            throw new NoSuchElementException();
        }
        String str = vVar.f3831e;
        this.f3804e = i10 + 1;
        return new v(String.valueOf(str.charAt(i10)));
    }
}
