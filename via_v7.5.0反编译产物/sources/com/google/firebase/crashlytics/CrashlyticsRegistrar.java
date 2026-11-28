package com.google.firebase.crashlytics;

import com.google.firebase.components.ComponentRegistrar;
import java.util.Arrays;
import java.util.List;
import n2.c;
import n2.e;
import n2.h;
import n2.r;
import p2.g;
import q2.a;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class CrashlyticsRegistrar implements ComponentRegistrar {
    public final g b(e eVar) {
        return g.a((i2.e) eVar.a(i2.e.class), (k3.e) eVar.a(k3.e.class), eVar.i(a.class), eVar.i(k2.a.class));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List getComponents() {
        return Arrays.asList(c.c(g.class).g("fire-cls").b(r.i(i2.e.class)).b(r.i(k3.e.class)).b(r.a(a.class)).b(r.a(k2.a.class)).e(new h() { // from class: p2.f
            @Override // n2.h
            public final Object a(n2.e eVar) {
                return this.f11559a.b(eVar);
            }
        }).d().c(), p3.h.b("fire-cls", "18.3.7"));
    }
}
