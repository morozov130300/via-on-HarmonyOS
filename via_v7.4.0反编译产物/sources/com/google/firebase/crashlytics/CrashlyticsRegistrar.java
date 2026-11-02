package com.google.firebase.crashlytics;

import com.google.firebase.components.ComponentRegistrar;
import java.util.Arrays;
import java.util.List;
import m2.c;
import m2.e;
import m2.h;
import m2.r;
import o2.g;
import p2.a;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class CrashlyticsRegistrar implements ComponentRegistrar {
    public final g b(e eVar) {
        return g.a((h2.e) eVar.a(h2.e.class), (j3.e) eVar.a(j3.e.class), eVar.i(a.class), eVar.i(j2.a.class));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List getComponents() {
        return Arrays.asList(c.c(g.class).g("fire-cls").b(r.i(h2.e.class)).b(r.i(j3.e.class)).b(r.a(a.class)).b(r.a(j2.a.class)).e(new h() { // from class: o2.f
            @Override // m2.h
            public final Object a(m2.e eVar) {
                return this.f10342a.b(eVar);
            }
        }).d().c(), o3.h.b("fire-cls", "18.3.7"));
    }
}
