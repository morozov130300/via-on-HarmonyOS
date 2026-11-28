package com.google.firebase.installations;

import android.text.TextUtils;
import com.google.firebase.installations.local.PersistedInstallation;
import com.google.firebase.installations.remote.InstallationResponse;
import com.google.firebase.installations.remote.TokenResult;
import com.google.firebase.installations.remote.c;
import h2.g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import k3.e;
import k3.h;
import k3.i;
import k3.j;
import n2.u;
import u1.f;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a implements e {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Object f3342m = new Object();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final ThreadFactory f3343n = new ThreadFactoryC0043a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i2.e f3344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f3345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PersistedInstallation f3346c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j f3347d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final u f3348e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h f3349f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f3350g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ExecutorService f3351h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Executor f3352i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f3353j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Set f3354k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List f3355l;

    /* JADX INFO: renamed from: com.google.firebase.installations.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class ThreadFactoryC0043a implements ThreadFactory {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicInteger f3356c = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, String.format("firebase-installations-executor-%d", Integer.valueOf(this.f3356c.getAndIncrement())));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3357a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f3358b;

        static {
            int[] iArr = new int[TokenResult.ResponseCode.values().length];
            f3358b = iArr;
            try {
                iArr[TokenResult.ResponseCode.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3358b[TokenResult.ResponseCode.BAD_CONFIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3358b[TokenResult.ResponseCode.AUTH_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[InstallationResponse.ResponseCode.values().length];
            f3357a = iArr2;
            try {
                iArr2[InstallationResponse.ResponseCode.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3357a[InstallationResponse.ResponseCode.BAD_CONFIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public a(final i2.e eVar, j3.b bVar, ExecutorService executorService, Executor executor) {
        this(executorService, executor, eVar, new c(eVar.j(), bVar), new PersistedInstallation(eVar), j.c(), new u(new j3.b() { // from class: k3.b
            @Override // j3.b
            public final Object get() {
                return com.google.firebase.installations.a.c(eVar);
            }
        }), new h());
    }

    public static /* synthetic */ l3.a c(i2.e eVar) {
        return new l3.a(eVar);
    }

    public static a m() {
        return n(i2.e.l());
    }

    public static a n(i2.e eVar) {
        f.b(eVar != null, "Null is not a valid value of FirebaseApp.");
        return (a) eVar.i(e.class);
    }

    public final h2.f d() {
        g gVar = new g();
        e(new k3.g(gVar));
        return gVar.a();
    }

    public final void e(i iVar) {
        synchronized (this.f3350g) {
            this.f3355l.add(iVar);
        }
    }

    public final void f(boolean z10) {
        com.google.firebase.installations.local.b bVarU;
        com.google.firebase.installations.local.b bVarO = o();
        try {
            if (bVarO.i() || bVarO.l()) {
                bVarU = u(bVarO);
            } else {
                if (!z10 && !this.f3347d.f(bVarO)) {
                    return;
                }
                bVarU = h(bVarO);
            }
            r(bVarU);
            y(bVarO, bVarU);
            if (bVarU.k()) {
                x(bVarU.d());
            }
            if (bVarU.i()) {
                v(new FirebaseInstallationsException(FirebaseInstallationsException.Status.BAD_CONFIG));
            } else if (bVarU.j()) {
                v(new IOException("Installation ID could not be validated with the Firebase servers (maybe it was deleted). Firebase Installations will need to create a new Installation ID and auth token. Please retry your last request."));
            } else {
                w(bVarU);
            }
        } catch (FirebaseInstallationsException e10) {
            v(e10);
        }
    }

    public final void g(final boolean z10) {
        com.google.firebase.installations.local.b bVarP = p();
        if (z10) {
            bVarP = bVarP.p();
        }
        w(bVarP);
        this.f3352i.execute(new Runnable() { // from class: k3.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f7181c.f(z10);
            }
        });
    }

    @Override // k3.e
    public h2.f getId() {
        s();
        String strK = k();
        if (strK != null) {
            return h2.i.e(strK);
        }
        h2.f fVarD = d();
        this.f3351h.execute(new Runnable() { // from class: k3.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f7180c.g(false);
            }
        });
        return fVarD;
    }

    public final com.google.firebase.installations.local.b h(com.google.firebase.installations.local.b bVar) throws FirebaseInstallationsException {
        TokenResult tokenResultE = this.f3345b.e(i(), bVar.d(), q(), bVar.f());
        int i10 = b.f3358b[tokenResultE.b().ordinal()];
        if (i10 == 1) {
            return bVar.o(tokenResultE.c(), tokenResultE.d(), this.f3347d.b());
        }
        if (i10 == 2) {
            return bVar.q("BAD CONFIG");
        }
        if (i10 != 3) {
            throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
        }
        x(null);
        return bVar.r();
    }

    public String i() {
        return this.f3344a.n().b();
    }

    public String j() {
        return this.f3344a.n().c();
    }

    public final synchronized String k() {
        return this.f3353j;
    }

    public final l3.a l() {
        return (l3.a) this.f3348e.get();
    }

    public final com.google.firebase.installations.local.b o() {
        com.google.firebase.installations.local.b bVarD;
        synchronized (f3342m) {
            try {
                k3.a aVarA = k3.a.a(this.f3344a.j(), "generatefid.lock");
                try {
                    bVarD = this.f3346c.d();
                    if (aVarA != null) {
                        aVarA.b();
                    }
                } catch (Throwable th) {
                    if (aVarA != null) {
                        aVarA.b();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return bVarD;
    }

    public final com.google.firebase.installations.local.b p() {
        com.google.firebase.installations.local.b bVarD;
        synchronized (f3342m) {
            try {
                k3.a aVarA = k3.a.a(this.f3344a.j(), "generatefid.lock");
                try {
                    bVarD = this.f3346c.d();
                    if (bVarD.j()) {
                        bVarD = this.f3346c.b(bVarD.t(t(bVarD)));
                    }
                    if (aVarA != null) {
                        aVarA.b();
                    }
                } catch (Throwable th) {
                    if (aVarA != null) {
                        aVarA.b();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return bVarD;
    }

    public String q() {
        return this.f3344a.n().e();
    }

    public final void r(com.google.firebase.installations.local.b bVar) {
        synchronized (f3342m) {
            try {
                k3.a aVarA = k3.a.a(this.f3344a.j(), "generatefid.lock");
                try {
                    this.f3346c.b(bVar);
                    if (aVarA != null) {
                        aVarA.b();
                    }
                } catch (Throwable th) {
                    if (aVarA != null) {
                        aVarA.b();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void s() {
        f.e(j(), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        f.e(q(), "Please set your Project ID. A valid Firebase Project ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        f.e(i(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
        f.b(j.h(j()), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        f.b(j.g(i()), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    public final String t(com.google.firebase.installations.local.b bVar) {
        if ((!this.f3344a.m().equals("CHIME_ANDROID_SDK") && !this.f3344a.u()) || !bVar.m()) {
            return this.f3349f.a();
        }
        String strF = l().f();
        return TextUtils.isEmpty(strF) ? this.f3349f.a() : strF;
    }

    public final com.google.firebase.installations.local.b u(com.google.firebase.installations.local.b bVar) throws FirebaseInstallationsException {
        InstallationResponse installationResponseD = this.f3345b.d(i(), bVar.d(), q(), j(), (bVar.d() == null || bVar.d().length() != 11) ? null : l().i());
        int i10 = b.f3357a[installationResponseD.e().ordinal()];
        if (i10 == 1) {
            return bVar.s(installationResponseD.c(), installationResponseD.d(), this.f3347d.b(), installationResponseD.b().c(), installationResponseD.b().d());
        }
        if (i10 == 2) {
            return bVar.q("BAD CONFIG");
        }
        throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
    }

    public final void v(Exception exc) {
        synchronized (this.f3350g) {
            try {
                Iterator it = this.f3355l.iterator();
                while (it.hasNext()) {
                    if (((i) it.next()).a(exc)) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void w(com.google.firebase.installations.local.b bVar) {
        synchronized (this.f3350g) {
            try {
                Iterator it = this.f3355l.iterator();
                while (it.hasNext()) {
                    if (((i) it.next()).b(bVar)) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized void x(String str) {
        this.f3353j = str;
    }

    public final synchronized void y(com.google.firebase.installations.local.b bVar, com.google.firebase.installations.local.b bVar2) {
        if (this.f3354k.size() != 0 && !TextUtils.equals(bVar.d(), bVar2.d())) {
            Iterator it = this.f3354k.iterator();
            if (it.hasNext()) {
                n.g.a(it.next());
                bVar2.d();
                throw null;
            }
        }
    }

    public a(ExecutorService executorService, Executor executor, i2.e eVar, c cVar, PersistedInstallation persistedInstallation, j jVar, u uVar, h hVar) {
        this.f3350g = new Object();
        this.f3354k = new HashSet();
        this.f3355l = new ArrayList();
        this.f3344a = eVar;
        this.f3345b = cVar;
        this.f3346c = persistedInstallation;
        this.f3347d = jVar;
        this.f3348e = uVar;
        this.f3349f = hVar;
        this.f3351h = executorService;
        this.f3352i = executor;
    }
}
