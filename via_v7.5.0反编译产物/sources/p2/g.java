package p2;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import h2.i;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import t2.m;
import t2.s;
import t2.t;
import t2.v;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f11560a;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements h2.a {
        @Override // h2.a
        public Object a(h2.f fVar) {
            if (fVar.k()) {
                return null;
            }
            q2.f.f().e("Error fetching settings.", fVar.g());
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b implements Callable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f11561c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ m f11562e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ com.google.firebase.crashlytics.internal.settings.a f11563m;

        public b(boolean z10, m mVar, com.google.firebase.crashlytics.internal.settings.a aVar) {
            this.f11561c = z10;
            this.f11562e = mVar;
            this.f11563m = aVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void call() {
            if (!this.f11561c) {
                return null;
            }
            this.f11562e.g(this.f11563m);
            return null;
        }
    }

    public g(m mVar) {
        this.f11560a = mVar;
    }

    public static g a(i2.e eVar, k3.e eVar2, j3.a aVar, j3.a aVar2) {
        Context contextJ = eVar.j();
        String packageName = contextJ.getPackageName();
        q2.f.f().g("Initializing Firebase Crashlytics " + m.i() + " for " + packageName);
        y2.g gVar = new y2.g(contextJ);
        s sVar = new s(eVar);
        v vVar = new v(contextJ, packageName, eVar2, sVar);
        q2.d dVar = new q2.d(aVar);
        d dVar2 = new d(aVar2);
        m mVar = new m(eVar, vVar, dVar, sVar, dVar2.e(), dVar2.d(), gVar, t.c("Crashlytics Exception Handler"));
        String strC = eVar.n().c();
        String strO = CommonUtils.o(contextJ);
        List<t2.e> listL = CommonUtils.l(contextJ);
        q2.f.f().b("Mapping file ID is: " + strO);
        for (t2.e eVar3 : listL) {
            q2.f.f().b(String.format("Build id for %s on %s: %s", eVar3.c(), eVar3.a(), eVar3.b()));
        }
        try {
            t2.a aVarA = t2.a.a(contextJ, vVar, strC, strO, listL, new q2.e(contextJ));
            q2.f.f().i("Installer package name is: " + aVarA.f12326d);
            ExecutorService executorServiceC = t.c("com.google.firebase.crashlytics.startup");
            com.google.firebase.crashlytics.internal.settings.a aVarL = com.google.firebase.crashlytics.internal.settings.a.l(contextJ, strC, vVar, new x2.b(), aVarA.f12328f, aVarA.f12329g, gVar, sVar);
            aVarL.p(executorServiceC).e(executorServiceC, new a());
            i.c(executorServiceC, new b(mVar.n(aVarA, aVarL), mVar, aVarL));
            return new g(mVar);
        } catch (PackageManager.NameNotFoundException e10) {
            q2.f.f().e("Error retrieving app package info.", e10);
            return null;
        }
    }
}
