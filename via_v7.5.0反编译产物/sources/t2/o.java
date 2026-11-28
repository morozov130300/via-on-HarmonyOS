package t2;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map f12428f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f12429g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f12430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v f12431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f12432c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b3.d f12433d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a3.g f12434e;

    static {
        HashMap map = new HashMap();
        f12428f = map;
        map.put("armeabi", 5);
        map.put("armeabi-v7a", 6);
        map.put("arm64-v8a", 9);
        map.put("x86", 0);
        map.put("x86_64", 1);
        f12429g = String.format(Locale.US, "Crashlytics Android SDK/%s", "18.3.7");
    }

    public o(Context context, v vVar, a aVar, b3.d dVar, a3.g gVar) {
        this.f12430a = context;
        this.f12431b = vVar;
        this.f12432c = aVar;
        this.f12433d = dVar;
        this.f12434e = gVar;
    }

    public static int f() {
        Integer num;
        String str = Build.CPU_ABI;
        if (TextUtils.isEmpty(str) || (num = (Integer) f12428f.get(str.toLowerCase(Locale.US))) == null) {
            return 7;
        }
        return num.intValue();
    }

    public final v2.b0.a a(v2.b0.a aVar) {
        v2.c0 c0VarC;
        if (!this.f12434e.b().f31b.f40c || this.f12432c.f12325c.size() <= 0) {
            c0VarC = null;
        } else {
            ArrayList arrayList = new ArrayList();
            for (e eVar : this.f12432c.f12325c) {
                arrayList.add(v2.b0.a.AbstractC0133a.a().d(eVar.c()).b(eVar.a()).c(eVar.b()).a());
            }
            c0VarC = v2.c0.c(arrayList);
        }
        return v2.b0.a.a().c(aVar.c()).e(aVar.e()).g(aVar.g()).i(aVar.i()).d(aVar.d()).f(aVar.f()).h(aVar.h()).j(aVar.j()).b(c0VarC).a();
    }

    public final v2.b0.b b() {
        return v2.b0.b().i("18.3.7").e(this.f12432c.f12323a).f(this.f12431b.a()).c(this.f12432c.f12328f).d(this.f12432c.f12329g).h(4);
    }

    public v2.b0.e.d c(v2.b0.a aVar) {
        int i10 = this.f12430a.getResources().getConfiguration().orientation;
        return v2.b0.e.d.a().f("anr").e(aVar.i()).b(j(i10, a(aVar))).c(k(i10)).a();
    }

    public v2.b0.e.d d(Throwable th, Thread thread, String str, long j10, int i10, int i11, boolean z10) {
        int i12 = this.f12430a.getResources().getConfiguration().orientation;
        return v2.b0.e.d.a().f(str).e(j10).b(i(i12, new b3.e(th, this.f12433d), thread, i10, i11, z10)).c(k(i12)).a();
    }

    public v2.b0 e(String str, long j10) {
        return b().j(s(str, j10)).a();
    }

    public final v2.b0.e.d.a.b.AbstractC0137a g() {
        return v2.b0.e.d.a.b.AbstractC0137a.a().b(0L).d(0L).c(this.f12432c.f12327e).e(this.f12432c.f12324b).a();
    }

    public final v2.c0 h() {
        return v2.c0.f(g());
    }

    public final v2.b0.e.d.a i(int i10, b3.e eVar, Thread thread, int i11, int i12, boolean z10) {
        Boolean boolValueOf;
        ActivityManager.RunningAppProcessInfo runningAppProcessInfoJ = CommonUtils.j(this.f12432c.f12327e, this.f12430a);
        if (runningAppProcessInfoJ != null) {
            boolValueOf = Boolean.valueOf(runningAppProcessInfoJ.importance != 100);
        } else {
            boolValueOf = null;
        }
        return v2.b0.e.d.a.a().b(boolValueOf).f(i10).d(n(eVar, thread, i11, i12, z10)).a();
    }

    public final v2.b0.e.d.a j(int i10, v2.b0.a aVar) {
        return v2.b0.e.d.a.a().b(Boolean.valueOf(aVar.c() != 100)).f(i10).d(o(aVar)).a();
    }

    public final v2.b0.e.d.c k(int i10) {
        d dVarA = d.a(this.f12430a);
        Float fB = dVarA.b();
        Double dValueOf = fB != null ? Double.valueOf(fB.doubleValue()) : null;
        int iC = dVarA.c();
        boolean zP = CommonUtils.p(this.f12430a);
        return v2.b0.e.d.c.a().b(dValueOf).c(iC).f(zP).e(i10).g(CommonUtils.t() - CommonUtils.a(this.f12430a)).d(CommonUtils.b(Environment.getDataDirectory().getPath())).a();
    }

    public final v2.b0.e.d.a.b.c l(b3.e eVar, int i10, int i11) {
        return m(eVar, i10, i11, 0);
    }

    public final v2.b0.e.d.a.b.c m(b3.e eVar, int i10, int i11, int i12) {
        String str = eVar.f1726b;
        String str2 = eVar.f1725a;
        StackTraceElement[] stackTraceElementArr = eVar.f1727c;
        int i13 = 0;
        if (stackTraceElementArr == null) {
            stackTraceElementArr = new StackTraceElement[0];
        }
        b3.e eVar2 = eVar.f1728d;
        if (i12 >= i11) {
            b3.e eVar3 = eVar2;
            while (eVar3 != null) {
                eVar3 = eVar3.f1728d;
                i13++;
            }
        }
        v2.b0.e.d.a.b.c.AbstractC0140a abstractC0140aD = v2.b0.e.d.a.b.c.a().f(str).e(str2).c(v2.c0.c(q(stackTraceElementArr, i10))).d(i13);
        if (eVar2 != null && i13 == 0) {
            abstractC0140aD.b(m(eVar2, i10, i11, i12 + 1));
        }
        return abstractC0140aD.a();
    }

    public final v2.b0.e.d.a.b n(b3.e eVar, Thread thread, int i10, int i11, boolean z10) {
        return v2.b0.e.d.a.b.a().f(y(eVar, thread, i10, z10)).d(l(eVar, i10, i11)).e(v()).c(h()).a();
    }

    public final v2.b0.e.d.a.b o(v2.b0.a aVar) {
        return v2.b0.e.d.a.b.a().b(aVar).e(v()).c(h()).a();
    }

    public final v2.b0.e.d.a.b.AbstractC0143e.AbstractC0145b p(StackTraceElement stackTraceElement, v2.b0.e.d.a.b.AbstractC0143e.AbstractC0145b.AbstractC0146a abstractC0146a) {
        long lineNumber = 0;
        long jMax = stackTraceElement.isNativeMethod() ? Math.max(stackTraceElement.getLineNumber(), 0L) : 0L;
        String str = stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName();
        String fileName = stackTraceElement.getFileName();
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            lineNumber = stackTraceElement.getLineNumber();
        }
        return abstractC0146a.e(jMax).f(str).b(fileName).d(lineNumber).a();
    }

    public final v2.c0 q(StackTraceElement[] stackTraceElementArr, int i10) {
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            arrayList.add(p(stackTraceElement, v2.b0.e.d.a.b.AbstractC0143e.AbstractC0145b.a().c(i10)));
        }
        return v2.c0.c(arrayList);
    }

    public final v2.b0.e.a r() {
        return v2.b0.e.a.a().e(this.f12431b.f()).g(this.f12432c.f12328f).d(this.f12432c.f12329g).f(this.f12431b.a()).b(this.f12432c.f12330h.d()).c(this.f12432c.f12330h.e()).a();
    }

    public final v2.b0.e s(String str, long j10) {
        return v2.b0.e.a().l(j10).i(str).g(f12429g).b(r()).k(u()).d(t()).h(3).a();
    }

    public final v2.b0.e.c t() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        int iF = f();
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        long jT = CommonUtils.t();
        long blockCount = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        boolean z10 = CommonUtils.z();
        int iN = CommonUtils.n();
        String str = Build.MANUFACTURER;
        return v2.b0.e.c.a().b(iF).f(Build.MODEL).c(iAvailableProcessors).h(jT).d(blockCount).i(z10).j(iN).e(str).g(Build.PRODUCT).a();
    }

    public final v2.b0.e.AbstractC0148e u() {
        return v2.b0.e.AbstractC0148e.a().d(3).e(Build.VERSION.RELEASE).b(Build.VERSION.CODENAME).c(CommonUtils.A()).a();
    }

    public final v2.b0.e.d.a.b.AbstractC0141d v() {
        return v2.b0.e.d.a.b.AbstractC0141d.a().d("0").c("0").b(0L).a();
    }

    public final v2.b0.e.d.a.b.AbstractC0143e w(Thread thread, StackTraceElement[] stackTraceElementArr) {
        return x(thread, stackTraceElementArr, 0);
    }

    public final v2.b0.e.d.a.b.AbstractC0143e x(Thread thread, StackTraceElement[] stackTraceElementArr, int i10) {
        return v2.b0.e.d.a.b.AbstractC0143e.a().d(thread.getName()).c(i10).b(v2.c0.c(q(stackTraceElementArr, i10))).a();
    }

    public final v2.c0 y(b3.e eVar, Thread thread, int i10, boolean z10) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(x(thread, eVar.f1727c, i10));
        if (z10) {
            for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
                Thread key = entry.getKey();
                if (!key.equals(thread)) {
                    arrayList.add(w(key, this.f12433d.a(entry.getValue())));
                }
            }
        }
        return v2.c0.c(arrayList);
    }
}
