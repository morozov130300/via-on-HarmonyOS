package com.google.firebase.installations;

import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.installations.FirebaseInstallationsRegistrar;
import h3.i;
import j3.e;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import l2.b;
import m2.b0;
import m2.c;
import m2.h;
import m2.r;
import n2.a0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
@Keep
/* loaded from: classes.dex */
public class FirebaseInstallationsRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-installations";

    public static /* synthetic */ e a(m2.e eVar) {
        return new a((h2.e) eVar.a(h2.e.class), eVar.c(i.class), (ExecutorService) eVar.f(b0.a(l2.a.class, ExecutorService.class)), a0.a((Executor) eVar.f(b0.a(b.class, Executor.class))));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<c> getComponents() {
        return Arrays.asList(c.c(e.class).g(LIBRARY_NAME).b(r.i(h2.e.class)).b(r.h(i.class)).b(r.j(b0.a(l2.a.class, ExecutorService.class))).b(r.j(b0.a(b.class, Executor.class))).e(new h() { // from class: j3.f
            @Override // m2.h
            public final Object a(m2.e eVar) {
                return FirebaseInstallationsRegistrar.a(eVar);
            }
        }).c(), h3.h.a(), o3.h.b(LIBRARY_NAME, "17.1.3"));
    }
}
