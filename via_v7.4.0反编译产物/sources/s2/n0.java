package s2;

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
import u2.b0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class n0 {

    /* renamed from: a, reason: collision with root package name */
    public final o f11755a;

    /* renamed from: b, reason: collision with root package name */
    public final x2.e f11756b;

    /* renamed from: c, reason: collision with root package name */
    public final y2.b f11757c;

    /* renamed from: d, reason: collision with root package name */
    public final t2.c f11758d;

    /* renamed from: e, reason: collision with root package name */
    public final t2.h f11759e;

    public n0(o oVar, x2.e eVar, y2.b bVar, t2.c cVar, t2.h hVar) {
        this.f11755a = oVar;
        this.f11756b = eVar;
        this.f11757c = bVar;
        this.f11758d = cVar;
        this.f11759e = hVar;
    }

    public static b0.a e(ApplicationExitInfo applicationExitInfo) throws IOException {
        String strF = null;
        try {
            InputStream traceInputStream = applicationExitInfo.getTraceInputStream();
            if (traceInputStream != null) {
                strF = f(traceInputStream);
            }
        } catch (IOException e10) {
            p2.f.f().k("Could not get input trace in application exit info: " + applicationExitInfo.toString() + " Error: " + e10);
        }
        return b0.a.a().c(applicationExitInfo.getImportance()).e(applicationExitInfo.getProcessName()).g(applicationExitInfo.getReason()).i(applicationExitInfo.getTimestamp()).d(applicationExitInfo.getPid()).f(applicationExitInfo.getPss()).h(applicationExitInfo.getRss()).j(strF).a();
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

    public static n0 g(Context context, v vVar, x2.g gVar, a aVar, t2.c cVar, t2.h hVar, a3.d dVar, z2.g gVar2, a0 a0Var) {
        return new n0(new o(context, vVar, aVar, dVar, gVar2), new x2.e(gVar, gVar2), y2.b.b(context, gVar2, a0Var), cVar, hVar);
    }

    public static List k(Map map) {
        ArrayList arrayList = new ArrayList();
        arrayList.ensureCapacity(map.size());
        for (Map.Entry entry : map.entrySet()) {
            arrayList.add(b0.c.a().b((String) entry.getKey()).c((String) entry.getValue()).a());
        }
        Collections.sort(arrayList, new Comparator() { // from class: s2.l0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((b0.c) obj).b().compareTo(((b0.c) obj2).b());
            }
        });
        return arrayList;
    }

    public final b0.e.d c(b0.e.d dVar) {
        return d(dVar, this.f11758d, this.f11759e);
    }

    public final b0.e.d d(b0.e.d dVar, t2.c cVar, t2.h hVar) {
        b0.e.d.b bVarG = dVar.g();
        String strC = cVar.c();
        if (strC != null) {
            bVarG.d(b0.e.d.AbstractC0142d.a().b(strC).a());
        } else {
            p2.f.f().i("No log data to include with this event.");
        }
        List listK = k(hVar.d());
        List listK2 = k(hVar.e());
        if (!listK.isEmpty() || !listK2.isEmpty()) {
            bVarG.b(dVar.b().g().c(u2.c0.c(listK)).e(u2.c0.c(listK2)).a());
        }
        return bVarG.a();
    }

    public void h(String str, List list, b0.a aVar) {
        p2.f.f().b("SessionReportingCoordinator#finalizeSessionWithNativeEvent");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            b0.d.b bVarC = ((y) it.next()).c();
            if (bVarC != null) {
                arrayList.add(bVarC);
            }
        }
        this.f11756b.l(str, b0.d.a().b(u2.c0.c(arrayList)).a(), aVar);
    }

    public void i(long j10, String str) {
        this.f11756b.k(str, j10);
    }

    public final ApplicationExitInfo j(String str, List list) {
        long jQ = this.f11756b.q(str);
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
        return this.f11756b.r();
    }

    public SortedSet m() {
        return this.f11756b.p();
    }

    public void n(String str, long j10) {
        this.f11756b.x(this.f11755a.e(str, j10));
    }

    public final boolean o(g2.f fVar) {
        if (!fVar.k()) {
            p2.f.f().l("Crashlytics report could not be enqueued to DataTransport", fVar.g());
            return false;
        }
        p pVar = (p) fVar.h();
        p2.f.f().b("Crashlytics report successfully enqueued to DataTransport: " + pVar.d());
        File fileC = pVar.c();
        if (fileC.delete()) {
            p2.f.f().b("Deleted report file: " + fileC.getPath());
            return true;
        }
        p2.f.f().k("Crashlytics could not delete report file: " + fileC.getPath());
        return true;
    }

    public final void p(Throwable th, Thread thread, String str, String str2, long j10, boolean z10) {
        this.f11756b.w(c(this.f11755a.d(th, thread, str2, j10, 4, 8, z10)), str, str2.equals("crash"));
    }

    public void q(Throwable th, Thread thread, String str, long j10) {
        p2.f.f().i("Persisting fatal event for session " + str);
        p(th, thread, str, "crash", j10, true);
    }

    public void r(String str, List list, t2.c cVar, t2.h hVar) {
        ApplicationExitInfo applicationExitInfoJ = j(str, list);
        if (applicationExitInfoJ == null) {
            p2.f.f().i("No relevant ApplicationExitInfo occurred during session: " + str);
            return;
        }
        b0.e.d dVarC = this.f11755a.c(e(applicationExitInfoJ));
        p2.f.f().b("Persisting anr for session " + str);
        this.f11756b.w(d(dVarC, cVar, hVar), str, true);
    }

    public void s() {
        this.f11756b.i();
    }

    public g2.f t(Executor executor) {
        return u(executor, null);
    }

    public g2.f u(Executor executor, String str) {
        List<p> listU = this.f11756b.u();
        ArrayList arrayList = new ArrayList();
        for (p pVar : listU) {
            if (str == null || str.equals(pVar.d())) {
                arrayList.add(this.f11757c.c(pVar, str != null).e(executor, new g2.a() { // from class: s2.m0
                    @Override // g2.a
                    public final Object a(g2.f fVar) {
                        return Boolean.valueOf(this.f11752a.o(fVar));
                    }
                }));
            }
        }
        return g2.i.f(arrayList);
    }
}
