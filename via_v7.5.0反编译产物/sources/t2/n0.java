package t2;

import android.app.ApplicationExitInfo;
import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f12423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y2.e f12424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z2.b f12425c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u2.c f12426d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final u2.h f12427e;

    public n0(o oVar, y2.e eVar, z2.b bVar, u2.c cVar, u2.h hVar) {
        this.f12423a = oVar;
        this.f12424b = eVar;
        this.f12425c = bVar;
        this.f12426d = cVar;
        this.f12427e = hVar;
    }

    public static v2.b0.a e(ApplicationExitInfo applicationExitInfo) {
        String strF = null;
        try {
            InputStream traceInputStream = applicationExitInfo.getTraceInputStream();
            if (traceInputStream != null) {
                strF = f(traceInputStream);
            }
        } catch (IOException e10) {
            q2.f.f().k("Could not get input trace in application exit info: " + applicationExitInfo.toString() + " Error: " + e10);
        }
        return v2.b0.a.a().c(applicationExitInfo.getImportance()).e(applicationExitInfo.getProcessName()).g(applicationExitInfo.getReason()).i(applicationExitInfo.getTimestamp()).d(applicationExitInfo.getPid()).f(applicationExitInfo.getPss()).h(applicationExitInfo.getRss()).j(strF).a();
    }

    public static String f(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int i10 = inputStream.read(bArr);
            if (i10 == -1) {
                return byteArrayOutputStream.toString(StandardCharsets.UTF_8.name());
            }
            byteArrayOutputStream.write(bArr, 0, i10);
        }
    }

    public static n0 g(Context context, v vVar, y2.g gVar, a aVar, u2.c cVar, u2.h hVar, b3.d dVar, a3.g gVar2, a0 a0Var) {
        return new n0(new o(context, vVar, aVar, dVar, gVar2), new y2.e(gVar, gVar2), z2.b.b(context, gVar2, a0Var), cVar, hVar);
    }

    public static List k(Map map) {
        ArrayList arrayList = new ArrayList();
        arrayList.ensureCapacity(map.size());
        for (Map.Entry entry : map.entrySet()) {
            arrayList.add(v2.b0.c.a().b((String) entry.getKey()).c((String) entry.getValue()).a());
        }
        Collections.sort(arrayList, new Comparator() { // from class: t2.l0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((v2.b0.c) obj).b().compareTo(((v2.b0.c) obj2).b());
            }
        });
        return arrayList;
    }

    public final v2.b0.e.d c(v2.b0.e.d dVar) {
        return d(dVar, this.f12426d, this.f12427e);
    }

    public final v2.b0.e.d d(v2.b0.e.d dVar, u2.c cVar, u2.h hVar) {
        v2.b0.e.d.b bVarG = dVar.g();
        String strC = cVar.c();
        if (strC != null) {
            bVarG.d(v2.b0.e.d.AbstractC0147d.a().b(strC).a());
        } else {
            q2.f.f().i("No log data to include with this event.");
        }
        List listK = k(hVar.d());
        List listK2 = k(hVar.e());
        if (!listK.isEmpty() || !listK2.isEmpty()) {
            bVarG.b(dVar.b().g().c(v2.c0.c(listK)).e(v2.c0.c(listK2)).a());
        }
        return bVarG.a();
    }

    public void h(String str, List list, v2.b0.a aVar) {
        q2.f.f().b("SessionReportingCoordinator#finalizeSessionWithNativeEvent");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            v2.b0.d.b bVarC = ((y) it.next()).c();
            if (bVarC != null) {
                arrayList.add(bVarC);
            }
        }
        this.f12424b.l(str, v2.b0.d.a().b(v2.c0.c(arrayList)).a(), aVar);
    }

    public void i(long j10, String str) {
        this.f12424b.k(str, j10);
    }

    public final ApplicationExitInfo j(String str, List list) {
        long jQ = this.f12424b.q(str);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ApplicationExitInfo applicationExitInfoA = b0.a(it.next());
            if (applicationExitInfoA.getTimestamp() < jQ) {
                return null;
            }
            if (applicationExitInfoA.getReason() == 6) {
                return applicationExitInfoA;
            }
        }
        return null;
    }

    public boolean l() {
        return this.f12424b.r();
    }

    public SortedSet m() {
        return this.f12424b.p();
    }

    public void n(String str, long j10) {
        this.f12424b.x(this.f12423a.e(str, j10));
    }

    public final boolean o(h2.f fVar) {
        if (!fVar.k()) {
            q2.f.f().l("Crashlytics report could not be enqueued to DataTransport", fVar.g());
            return false;
        }
        p pVar = (p) fVar.h();
        q2.f.f().b("Crashlytics report successfully enqueued to DataTransport: " + pVar.d());
        File fileC = pVar.c();
        if (fileC.delete()) {
            q2.f.f().b("Deleted report file: " + fileC.getPath());
            return true;
        }
        q2.f.f().k("Crashlytics could not delete report file: " + fileC.getPath());
        return true;
    }

    public final void p(Throwable th, Thread thread, String str, String str2, long j10, boolean z10) {
        this.f12424b.w(c(this.f12423a.d(th, thread, str2, j10, 4, 8, z10)), str, str2.equals("crash"));
    }

    public void q(Throwable th, Thread thread, String str, long j10) {
        q2.f.f().i("Persisting fatal event for session " + str);
        p(th, thread, str, "crash", j10, true);
    }

    public void r(String str, List list, u2.c cVar, u2.h hVar) {
        ApplicationExitInfo applicationExitInfoJ = j(str, list);
        if (applicationExitInfoJ == null) {
            q2.f.f().i("No relevant ApplicationExitInfo occurred during session: " + str);
            return;
        }
        v2.b0.e.d dVarC = this.f12423a.c(e(applicationExitInfoJ));
        q2.f.f().b("Persisting anr for session " + str);
        this.f12424b.w(d(dVarC, cVar, hVar), str, true);
    }

    public void s() {
        this.f12424b.i();
    }

    public h2.f t(Executor executor) {
        return u(executor, null);
    }

    public h2.f u(Executor executor, String str) {
        List<p> listU = this.f12424b.u();
        ArrayList arrayList = new ArrayList();
        for (p pVar : listU) {
            if (str == null || str.equals(pVar.d())) {
                arrayList.add(this.f12425c.c(pVar, str != null).e(executor, new h2.a() { // from class: t2.m0
                    @Override // h2.a
                    public final Object a(h2.f fVar) {
                        return Boolean.valueOf(this.f12420a.o(fVar));
                    }
                }));
            }
        }
        return h2.i.f(arrayList);
    }
}
