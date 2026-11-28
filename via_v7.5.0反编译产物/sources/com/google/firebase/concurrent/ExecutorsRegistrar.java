package com.google.firebase.concurrent;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.StrictMode;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.concurrent.UiExecutor;
import j3.b;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import m2.a;
import m2.d;
import n2.b0;
import n2.c;
import n2.e;
import n2.h;
import n2.u;
import o2.o;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ThreadPoolCreation"})
public class ExecutorsRegistrar implements ComponentRegistrar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f3293a = new u(new b() { // from class: o2.s
        @Override // j3.b
        public final Object get() {
            return ExecutorsRegistrar.m(Executors.newFixedThreadPool(4, ExecutorsRegistrar.k("Firebase Background", 10, ExecutorsRegistrar.i())));
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final u f3294b = new u(new b() { // from class: o2.t
        @Override // j3.b
        public final Object get() {
            return ExecutorsRegistrar.m(Executors.newFixedThreadPool(Math.max(2, Runtime.getRuntime().availableProcessors()), ExecutorsRegistrar.k("Firebase Lite", 0, ExecutorsRegistrar.l())));
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final u f3295c = new u(new b() { // from class: o2.u
        @Override // j3.b
        public final Object get() {
            return ExecutorsRegistrar.m(Executors.newCachedThreadPool(ExecutorsRegistrar.j("Firebase Blocking", 11)));
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final u f3296d = new u(new b() { // from class: o2.v
        @Override // j3.b
        public final Object get() {
            return Executors.newSingleThreadScheduledExecutor(ExecutorsRegistrar.j("Firebase Scheduler", 0));
        }
    });

    public static /* synthetic */ ScheduledExecutorService a(e eVar) {
        return (ScheduledExecutorService) f3294b.get();
    }

    public static /* synthetic */ ScheduledExecutorService e(e eVar) {
        return (ScheduledExecutorService) f3295c.get();
    }

    public static /* synthetic */ ScheduledExecutorService g(e eVar) {
        return (ScheduledExecutorService) f3293a.get();
    }

    public static StrictMode.ThreadPolicy i() {
        StrictMode.ThreadPolicy.Builder builderDetectNetwork = new StrictMode.ThreadPolicy.Builder().detectNetwork();
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 23) {
            builderDetectNetwork.detectResourceMismatches();
            if (i10 >= 26) {
                builderDetectNetwork.detectUnbufferedIo();
            }
        }
        return builderDetectNetwork.penaltyLog().build();
    }

    public static ThreadFactory j(String str, int i10) {
        return new o2.b(str, i10, null);
    }

    public static ThreadFactory k(String str, int i10, StrictMode.ThreadPolicy threadPolicy) {
        return new o2.b(str, i10, threadPolicy);
    }

    public static StrictMode.ThreadPolicy l() {
        return new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build();
    }

    public static ScheduledExecutorService m(ExecutorService executorService) {
        return new o(executorService, (ScheduledExecutorService) f3296d.get());
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List getComponents() {
        return Arrays.asList(c.f(b0.a(a.class, ScheduledExecutorService.class), b0.a(a.class, ExecutorService.class), b0.a(a.class, Executor.class)).e(new h() { // from class: o2.w
            @Override // n2.h
            public final Object a(n2.e eVar) {
                return ExecutorsRegistrar.g(eVar);
            }
        }).c(), c.f(b0.a(m2.b.class, ScheduledExecutorService.class), b0.a(m2.b.class, ExecutorService.class), b0.a(m2.b.class, Executor.class)).e(new h() { // from class: o2.x
            @Override // n2.h
            public final Object a(n2.e eVar) {
                return ExecutorsRegistrar.e(eVar);
            }
        }).c(), c.f(b0.a(m2.c.class, ScheduledExecutorService.class), b0.a(m2.c.class, ExecutorService.class), b0.a(m2.c.class, Executor.class)).e(new h() { // from class: o2.y
            @Override // n2.h
            public final Object a(n2.e eVar) {
                return ExecutorsRegistrar.a(eVar);
            }
        }).c(), c.e(b0.a(d.class, Executor.class)).e(new h() { // from class: o2.z
            @Override // n2.h
            public final Object a(n2.e eVar) {
                return UiExecutor.INSTANCE;
            }
        }).c());
    }
}
