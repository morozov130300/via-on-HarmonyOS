package com.google.firebase.installations;

import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.installations.FirebaseInstallationsRegistrar;
import i3.i;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import k3.e;
import m2.b;
import n2.b0;
import n2.c;
import n2.h;
import n2.r;
import o2.a0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
@Keep
public class FirebaseInstallationsRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-installations";

    public static /* synthetic */ e a(n2.e eVar) {
        return new a((i2.e) eVar.a(i2.e.class), eVar.d(i.class), (ExecutorService) eVar.g(b0.a(m2.a.class, ExecutorService.class)), a0.a((Executor) eVar.g(b0.a(b.class, Executor.class))));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<c> getComponents() {
        return Arrays.asList(c.c(e.class).g(LIBRARY_NAME).b(r.i(i2.e.class)).b(r.h(i.class)).b(r.j(b0.a(m2.a.class, ExecutorService.class))).b(r.j(b0.a(b.class, Executor.class))).e(new h() { // from class: k3.f
            @Override // n2.h
            public final Object a(n2.e eVar) {
                return FirebaseInstallationsRegistrar.a(eVar);
            }
        }).c(), i3.h.a(), p3.h.b(LIBRARY_NAME, "17.1.3"));
    }
}
