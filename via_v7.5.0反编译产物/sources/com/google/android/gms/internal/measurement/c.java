package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f2718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f2719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f2720c;

    public c() {
        this.f2718a = new b("", 0L, null);
        this.f2719b = new b("", 0L, null);
        this.f2720c = new ArrayList();
    }

    public final b a() {
        return this.f2718a;
    }

    public final b b() {
        return this.f2719b;
    }

    public final List c() {
        return this.f2720c;
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        c cVar = new c(this.f2718a.clone());
        Iterator it = this.f2720c.iterator();
        while (it.hasNext()) {
            cVar.f2720c.add(((b) it.next()).clone());
        }
        return cVar;
    }

    public final void d(b bVar) {
        this.f2718a = bVar;
        this.f2719b = bVar.clone();
        this.f2720c.clear();
    }

    public final void e(String str, long j10, Map map) {
        this.f2720c.add(new b(str, j10, map));
    }

    public final void f(b bVar) {
        this.f2719b = bVar;
    }

    public c(b bVar) {
        this.f2718a = bVar;
        this.f2719b = bVar.clone();
        this.f2720c = new ArrayList();
    }
}
