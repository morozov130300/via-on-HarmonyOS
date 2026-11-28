package t2;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.util.Base64;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.DeliveryMechanism;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.SortedSet;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final FilenameFilter f12354s = new FilenameFilter() { // from class: t2.j
        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            return str.startsWith(".ae");
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f12355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s f12356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f12357c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u2.h f12358d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h f12359e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final v f12360f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final y2.g f12361g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final t2.a f12362h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final u2.c f12363i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final q2.a f12364j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final r2.a f12365k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final n0 f12366l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public q f12367m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public a3.g f12368n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final h2.g f12369o = new h2.g();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final h2.g f12370p = new h2.g();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final h2.g f12371q = new h2.g();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final AtomicBoolean f12372r = new AtomicBoolean(false);

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements q.a {
        public a() {
        }

        @Override // t2.q.a
        public void a(a3.g gVar, Thread thread, Throwable th) throws Throwable {
            k.this.H(gVar, thread, th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b implements Callable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f12374c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Throwable f12375e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ Thread f12376m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ a3.g f12377n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ boolean f12378o;

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public class a implements h2.e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Executor f12380a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f12381b;

            public a(Executor executor, String str) {
                this.f12380a = executor;
                this.f12381b = str;
            }

            @Override // h2.e
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public h2.f a(a3.d dVar) {
                if (dVar != null) {
                    return h2.i.g(k.this.M(), k.this.f12366l.u(this.f12380a, b.this.f12378o ? this.f12381b : null));
                }
                q2.f.f().k("Received null app settings, cannot send reports at crash time.");
                return h2.i.e(null);
            }
        }

        public b(long j10, Throwable th, Thread thread, a3.g gVar, boolean z10) {
            this.f12374c = j10;
            this.f12375e = th;
            this.f12376m = thread;
            this.f12377n = gVar;
            this.f12378o = z10;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public h2.f call() {
            long jF = k.F(this.f12374c);
            String strB = k.this.B();
            if (strB == null) {
                q2.f.f().d("Tried to write a fatal exception while no session was open.");
                return h2.i.e(null);
            }
            k.this.f12357c.a();
            k.this.f12366l.q(this.f12375e, this.f12376m, strB, jF);
            k.this.w(this.f12374c);
            k.this.t(this.f12377n);
            k.this.v(new t2.g(k.this.f12360f).toString());
            if (!k.this.f12356b.d()) {
                return h2.i.e(null);
            }
            Executor executorC = k.this.f12359e.c();
            return this.f12377n.a().m(executorC, new a(executorC, strB));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class c implements h2.e {
        public c() {
        }

        @Override // h2.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public h2.f a(Void r10) {
            return h2.i.e(Boolean.TRUE);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class d implements h2.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h2.f f12384a;

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public class a implements Callable {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Boolean f12386c;

            /* JADX INFO: renamed from: t2.k$d$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
            public class C0123a implements h2.e {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Executor f12388a;

                public C0123a(Executor executor) {
                    this.f12388a = executor;
                }

                @Override // h2.e
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public h2.f a(a3.d dVar) {
                    if (dVar == null) {
                        q2.f.f().k("Received null app settings at app startup. Cannot send cached reports");
                        return h2.i.e(null);
                    }
                    k.this.M();
                    k.this.f12366l.t(this.f12388a);
                    k.this.f12371q.e(null);
                    return h2.i.e(null);
                }
            }

            public a(Boolean bool) {
                this.f12386c = bool;
            }

            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public h2.f call() {
                if (this.f12386c.booleanValue()) {
                    q2.f.f().b("Sending cached crash reports...");
                    k.this.f12356b.c(this.f12386c.booleanValue());
                    Executor executorC = k.this.f12359e.c();
                    return d.this.f12384a.m(executorC, new C0123a(executorC));
                }
                q2.f.f().i("Deleting cached crash reports...");
                k.r(k.this.K());
                k.this.f12366l.s();
                k.this.f12371q.e(null);
                return h2.i.e(null);
            }
        }

        public d(h2.f fVar) {
            this.f12384a = fVar;
        }

        @Override // h2.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public h2.f a(Boolean bool) {
            return k.this.f12359e.h(new a(bool));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class e implements Callable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f12390c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f12391e;

        public e(long j10, String str) {
            this.f12390c = j10;
            this.f12391e = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void call() {
            if (k.this.J()) {
                return null;
            }
            k.this.f12363i.g(this.f12390c, this.f12391e);
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class f implements Callable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f12393c;

        public f(String str) {
            this.f12393c = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void call() {
            k.this.v(this.f12393c);
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class g implements Callable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f12395c;

        public g(long j10) {
            this.f12395c = j10;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void call() {
            Bundle bundle = new Bundle();
            bundle.putInt("fatal", 1);
            bundle.putLong("timestamp", this.f12395c);
            k.this.f12365k.a("_ae", bundle);
            return null;
        }
    }

    public k(Context context, h hVar, v vVar, s sVar, y2.g gVar, n nVar, t2.a aVar, u2.h hVar2, u2.c cVar, n0 n0Var, q2.a aVar2, r2.a aVar3) {
        this.f12355a = context;
        this.f12359e = hVar;
        this.f12360f = vVar;
        this.f12356b = sVar;
        this.f12361g = gVar;
        this.f12357c = nVar;
        this.f12362h = aVar;
        this.f12358d = hVar2;
        this.f12363i = cVar;
        this.f12364j = aVar2;
        this.f12365k = aVar3;
        this.f12366l = n0Var;
    }

    public static boolean A() {
        try {
            Class.forName("com.google.firebase.crash.FirebaseCrash");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static long C() {
        return F(System.currentTimeMillis());
    }

    public static List D(q2.g gVar, String str, y2.g gVar2, byte[] bArr) {
        File fileO = gVar2.o(str, "user-data");
        File fileO2 = gVar2.o(str, "keys");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new t2.f("logs_file", "logs", bArr));
        arrayList.add(new u("crash_meta_file", "metadata", gVar.g()));
        arrayList.add(new u("session_meta_file", "session", gVar.f()));
        arrayList.add(new u("app_meta_file", "app", gVar.a()));
        arrayList.add(new u("device_meta_file", "device", gVar.c()));
        arrayList.add(new u("os_meta_file", "os", gVar.b()));
        arrayList.add(O(gVar));
        arrayList.add(new u("user_meta_file", "user", fileO));
        arrayList.add(new u("keys_file", "keys", fileO2));
        return arrayList;
    }

    public static long F(long j10) {
        return j10 / 1000;
    }

    public static boolean N(String str, File file, v2.b0.a aVar) {
        if (file == null || !file.exists()) {
            q2.f.f().k("No minidump data found for session " + str);
        }
        if (aVar == null) {
            q2.f.f().g("No Tombstones data found for session " + str);
        }
        return (file == null || !file.exists()) && aVar == null;
    }

    public static y O(q2.g gVar) {
        File fileE = gVar.e();
        return (fileE == null || !fileE.exists()) ? new t2.f("minidump_file", "minidump", new byte[]{0}) : new u("minidump_file", "minidump", fileE);
    }

    public static byte[] Q(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int i10 = inputStream.read(bArr);
            if (i10 == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i10);
        }
    }

    public static v2.d0.a o(v vVar, t2.a aVar) {
        return v2.d0.a.b(vVar.f(), aVar.f12328f, aVar.f12329g, vVar.a(), DeliveryMechanism.determineFrom(aVar.f12326d).getId(), aVar.f12330h);
    }

    public static v2.d0.b p() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return v2.d0.b.c(CommonUtils.m(), Build.MODEL, Runtime.getRuntime().availableProcessors(), CommonUtils.t(), ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize()), CommonUtils.z(), CommonUtils.n(), Build.MANUFACTURER, Build.PRODUCT);
    }

    public static v2.d0.c q() {
        return v2.d0.c.a(Build.VERSION.RELEASE, Build.VERSION.CODENAME, CommonUtils.A());
    }

    public static void r(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((File) it.next()).delete();
        }
    }

    public final String B() {
        SortedSet sortedSetM = this.f12366l.m();
        if (sortedSetM.isEmpty()) {
            return null;
        }
        return (String) sortedSetM.first();
    }

    public final InputStream E(String str) {
        ClassLoader classLoader = getClass().getClassLoader();
        if (classLoader == null) {
            q2.f.f().k("Couldn't get Class Loader");
            return null;
        }
        InputStream resourceAsStream = classLoader.getResourceAsStream(str);
        if (resourceAsStream != null) {
            return resourceAsStream;
        }
        q2.f.f().g("No version control information found");
        return null;
    }

    public String G() {
        InputStream inputStreamE = E("META-INF/version-control-info.textproto");
        if (inputStreamE == null) {
            return null;
        }
        q2.f.f().b("Read version control info");
        return Base64.encodeToString(Q(inputStreamE), 0);
    }

    public void H(a3.g gVar, Thread thread, Throwable th) throws Throwable {
        I(gVar, thread, th, false);
    }

    public synchronized void I(a3.g gVar, Thread thread, Throwable th, boolean z10) throws Throwable {
        try {
            try {
                q2.f.f().b("Handling uncaught exception \"" + th + "\" from thread " + thread.getName());
                try {
                    u0.f(this.f12359e.h(new b(System.currentTimeMillis(), th, thread, gVar, z10)));
                } catch (TimeoutException unused) {
                    q2.f.f().d("Cannot send reports. Timed out while fetching settings.");
                } catch (Exception e10) {
                    q2.f.f().e("Error handling uncaught exception", e10);
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public boolean J() {
        q qVar = this.f12367m;
        return qVar != null && qVar.a();
    }

    public List K() {
        return this.f12361g.f(f12354s);
    }

    public final h2.f L(long j10) {
        if (A()) {
            q2.f.f().k("Skipping logging Crashlytics event to Firebase, FirebaseCrash exists");
            return h2.i.e(null);
        }
        q2.f.f().b("Logging app exception event to Firebase Analytics");
        return h2.i.c(new ScheduledThreadPoolExecutor(1), new g(j10));
    }

    public final h2.f M() {
        ArrayList arrayList = new ArrayList();
        for (File file : K()) {
            try {
                arrayList.add(L(Long.parseLong(file.getName().substring(3))));
            } catch (NumberFormatException unused) {
                q2.f.f().k("Could not parse app exception timestamp from file " + file.getName());
            }
            file.delete();
        }
        return h2.i.f(arrayList);
    }

    public void P(String str) {
        this.f12359e.g(new f(str));
    }

    public void R() {
        try {
            String strG = G();
            if (strG != null) {
                S("com.crashlytics.version-control-info", strG);
                q2.f.f().g("Saved version control info");
            }
        } catch (IOException e10) {
            q2.f.f().l("Unable to save version control info", e10);
        }
    }

    public void S(String str, String str2) {
        try {
            this.f12358d.h(str, str2);
        } catch (IllegalArgumentException e10) {
            Context context = this.f12355a;
            if (context != null && CommonUtils.x(context)) {
                throw e10;
            }
            q2.f.f().d("Attempting to set custom attribute with null key, ignoring.");
        }
    }

    public h2.f T(h2.f fVar) {
        if (this.f12366l.l()) {
            q2.f.f().i("Crash reports are available to be sent.");
            return U().l(new d(fVar));
        }
        q2.f.f().i("No crash reports are available to be sent.");
        this.f12369o.e(Boolean.FALSE);
        return h2.i.e(null);
    }

    public final h2.f U() {
        if (this.f12356b.d()) {
            q2.f.f().b("Automatic data collection is enabled. Allowing upload.");
            this.f12369o.e(Boolean.FALSE);
            return h2.i.e(Boolean.TRUE);
        }
        q2.f.f().b("Automatic data collection is disabled.");
        q2.f.f().i("Notifying that unsent reports are available.");
        this.f12369o.e(Boolean.TRUE);
        h2.f fVarL = this.f12356b.g().l(new c());
        q2.f.f().b("Waiting for send/deleteUnsentReports to be called.");
        return u0.i(fVarL, this.f12370p.a());
    }

    public final void V(String str) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 30) {
            q2.f.f().i("ANR feature enabled, but device is API " + i10);
            return;
        }
        List historicalProcessExitReasons = ((ActivityManager) this.f12355a.getSystemService("activity")).getHistoricalProcessExitReasons(null, 0, 0);
        if (historicalProcessExitReasons.size() != 0) {
            this.f12366l.r(str, historicalProcessExitReasons, new u2.c(this.f12361g, str), u2.h.f(str, this.f12361g, this.f12359e));
        } else {
            q2.f.f().i("No ApplicationExitInfo available. Session: " + str);
        }
    }

    public void W(long j10, String str) {
        this.f12359e.g(new e(j10, str));
    }

    public boolean s() {
        if (!this.f12357c.c()) {
            String strB = B();
            return strB != null && this.f12364j.d(strB);
        }
        q2.f.f().i("Found previous crash marker.");
        this.f12357c.d();
        return true;
    }

    public void t(a3.g gVar) {
        u(false, gVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void u(boolean z10, a3.g gVar) {
        ArrayList arrayList = new ArrayList(this.f12366l.m());
        if (arrayList.size() <= z10) {
            q2.f.f().i("No open sessions to be closed.");
            return;
        }
        String str = (String) arrayList.get(z10 ? 1 : 0);
        if (gVar.b().f31b.f39b) {
            V(str);
        } else {
            q2.f.f().i("ANR feature disabled.");
        }
        if (this.f12364j.d(str)) {
            y(str);
        }
        this.f12366l.i(C(), z10 != 0 ? (String) arrayList.get(0) : null);
    }

    public final void v(String str) {
        long jC = C();
        q2.f.f().b("Opening a new session with ID " + str);
        this.f12364j.c(str, String.format(Locale.US, "Crashlytics Android SDK/%s", m.i()), jC, v2.d0.b(o(this.f12360f, this.f12362h), q(), p()));
        this.f12363i.e(str);
        this.f12366l.n(str, jC);
    }

    public final void w(long j10) {
        try {
            if (this.f12361g.e(".ae" + j10).createNewFile()) {
            } else {
                throw new IOException("Create new file failed.");
            }
        } catch (IOException e10) {
            q2.f.f().l("Could not create app exception marker file.", e10);
        }
    }

    public void x(String str, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, a3.g gVar) {
        this.f12368n = gVar;
        P(str);
        q qVar = new q(new a(), gVar, uncaughtExceptionHandler, this.f12364j);
        this.f12367m = qVar;
        Thread.setDefaultUncaughtExceptionHandler(qVar);
    }

    public final void y(String str) {
        q2.f.f().i("Finalizing native report for session " + str);
        q2.g gVarA = this.f12364j.a(str);
        File fileE = gVarA.e();
        v2.b0.a aVarD = gVarA.d();
        if (N(str, fileE, aVarD)) {
            q2.f.f().k("No native core present");
            return;
        }
        long jLastModified = fileE.lastModified();
        u2.c cVar = new u2.c(this.f12361g, str);
        File fileI = this.f12361g.i(str);
        if (!fileI.isDirectory()) {
            q2.f.f().k("Couldn't create directory to store native session files, aborting.");
            return;
        }
        w(jLastModified);
        List listD = D(gVarA, str, this.f12361g, cVar.b());
        z.b(fileI, listD);
        q2.f.f().b("CrashlyticsController#finalizePreviousNativeSession");
        this.f12366l.h(str, listD, aVarD);
        cVar.a();
    }

    public boolean z(a3.g gVar) {
        this.f12359e.b();
        if (J()) {
            q2.f.f().k("Skipping session finalization because a crash has already occurred.");
            return false;
        }
        q2.f.f().i("Finalizing previously open sessions.");
        try {
            u(true, gVar);
            q2.f.f().i("Closed all previously open sessions.");
            return true;
        } catch (Exception e10) {
            q2.f.f().e("Unable to finalize previously open sessions.", e10);
            return false;
        }
    }
}
