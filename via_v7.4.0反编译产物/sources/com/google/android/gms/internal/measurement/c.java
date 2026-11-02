package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public b f3419a;

    /* renamed from: b, reason: collision with root package name */
    public b f3420b;

    /* renamed from: c, reason: collision with root package name */
    public final List f3421c;

    public c() {
        this.f3419a = new b("", 0L, null);
        this.f3420b = new b("", 0L, null);
        this.f3421c = new ArrayList();
    }

    public c(b bVar) {
        this.f3419a = bVar;
        this.f3420b = bVar.clone();
        this.f3421c = new ArrayList();
    }

    public final b a() {
        return this.f3419a;
    }

    public final b b() {
        return this.f3420b;
    }

    public final List c() {
        return this.f3421c;
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        c cVar = new c(this.f3419a.clone());
        Iterator it = this.f3421c.iterator();
        while (it.hasNext()) {
            cVar.f3421c.add(((b) it.next()).clone());
        }
        return cVar;
    }

    public final void d(b bVar) {
        this.f3419a = bVar;
        this.f3420b = bVar.clone();
        this.f3421c.clear();
    }

    public final void e(String str, long j10, Map map) {
        this.f3421c.add(new b(str, j10, map));
    }

    public final void f(b bVar) {
        this.f3420b = bVar;
    }
}
