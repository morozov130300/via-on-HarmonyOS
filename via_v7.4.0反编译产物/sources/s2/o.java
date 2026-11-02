package s2;

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
import u2.b0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class o {

    /* renamed from: f, reason: collision with root package name */
    public static final Map f11760f;

    /* renamed from: g, reason: collision with root package name */
    public static final String f11761g;

    /* renamed from: a, reason: collision with root package name */
    public final Context f11762a;

    /* renamed from: b, reason: collision with root package name */
    public final v f11763b;

    /* renamed from: c, reason: collision with root package name */
    public final a f11764c;

    /* renamed from: d, reason: collision with root package name */
    public final a3.d f11765d;

    /* renamed from: e, reason: collision with root package name */
    public final z2.g f11766e;

    static {
        HashMap map = new HashMap();
        f11760f = map;
        map.put("armeabi", 5);
        map.put("armeabi-v7a", 6);
        map.put("arm64-v8a", 9);
        map.put("x86", 0);
        map.put("x86_64", 1);
        f11761g = String.format(Locale.US, "Crashlytics Android SDK/%s", "18.3.7");
    }

    public o(Context context, v vVar, a aVar, a3.d dVar, z2.g gVar) {
        this.f11762a = context;
        this.f11763b = vVar;
        this.f11764c = aVar;
        this.f11765d = dVar;
        this.f11766e = gVar;
    }

    public static int f() {
        Integer num;
        String str = Build.CPU_ABI;
        if (TextUtils.isEmpty(str) || (num = (Integer) f11760f.get(str.toLowerCase(Locale.US))) == null) {
            return 7;
        }
        return num.intValue();
    }

    public final b0.a a(b0.a aVar) {
        u2.c0 c0VarC;
        if (!this.f11766e.b().f14563b.f14572c || this.f11764c.f11657c.size() <= 0) {
            c0VarC = null;
        } else {
            ArrayList arrayList = new ArrayList();
            for (e eVar : this.f11764c.f11657c) {
                arrayList.add(b0.a.AbstractC0128a.a().d(eVar.c()).b(eVar.a()).c(eVar.b()).a());
            }
            c0VarC = u2.c0.c(arrayList);
        }
        return b0.a.a().c(aVar.c()).e(aVar.e()).g(aVar.g()).i(aVar.i()).d(aVar.d()).f(aVar.f()).h(aVar.h()).j(aVar.j()).b(c0VarC).a();
    }

    public final b0.b b() {
        return u2.b0.b().i("18.3.7").e(this.f11764c.f11655a).f(this.f11763b.a()).c(this.f11764c.f11660f).d(this.f11764c.f11661g).h(4);
    }

    public b0.e.d c(b0.a aVar) {
        int i10 = this.f11762a.getResources().getConfiguration().orientation;
        return b0.e.d.a().f("anr").e(aVar.i()).b(j(i10, a(aVar))).c(k(i10)).a();
    }

    public b0.e.d d(Throwable th, Thread thread, String str, long j10, int i10, int i11, boolean z10) {
        int i12 = this.f11762a.getResources().getConfiguration().orientation;
        return b0.e.d.a().f(str).e(j10).b(i(i12, new a3.e(th, this.f11765d), thread, i10, i11, z10)).c(k(i12)).a();
    }

    public u2.b0 e(String str, long j10) {
        return b().j(s(str, j10)).a();
    }

    public final b0.e.d.a.b.AbstractC0132a g() {
        return b0.e.d.a.b.AbstractC0132a.a().b(0L).d(0L).c(this.f11764c.f11659e).e(this.f11764c.f11656b).a();
    }

    public final u2.c0 h() {
        return u2.c0.f(g());
    }

    public final b0.e.d.a i(int i10, a3.e eVar, Thread thread, int i11, int i12, boolean z10) {
        Boolean boolValueOf;
        ActivityManager.RunningAppProcessInfo runningAppProcessInfoJ = CommonUtils.j(this.f11764c.f11659e, this.f11762a);
        if (runningAppProcessInfoJ != null) {
            boolValueOf = Boolean.valueOf(runningAppProcessInfoJ.importance != 100);
        } else {
            boolValueOf = null;
        }
        return b0.e.d.a.a().b(boolValueOf).f(i10).d(n(eVar, thread, i11, i12, z10)).a();
    }

    public final b0.e.d.a j(int i10, b0.a aVar) {
        return b0.e.d.a.a().b(Boolean.valueOf(aVar.c() != 100)).f(i10).d(o(aVar)).a();
    }

    public final b0.e.d.c k(int i10) {
        d dVarA = d.a(this.f11762a);
        Float fB = dVarA.b();
        Double dValueOf = fB != null ? Double.valueOf(fB.doubleValue()) : null;
        int iC = dVarA.c();
        boolean zP = CommonUtils.p(this.f11762a);
        return b0.e.d.c.a().b(dValueOf).c(iC).f(zP).e(i10).g(CommonUtils.t() - CommonUtils.a(this.f11762a)).d(CommonUtils.b(Environment.getDataDirectory().getPath())).a();
    }

    public final b0.e.d.a.b.c l(a3.e eVar, int i10, int i11) {
        return m(eVar, i10, i11, 0);
    }

    public final b0.e.d.a.b.c m(a3.e eVar, int i10, int i11, int i12) {
        String str = eVar.f59b;
        String str2 = eVar.f58a;
        StackTraceElement[] stackTraceElementArr = eVar.f60c;
        int i13 = 0;
        if (stackTraceElementArr == null) {
            stackTraceElementArr = new StackTraceElement[0];
        }
        a3.e eVar2 = eVar.f61d;
        if (i12 >= i11) {
            a3.e eVar3 = eVar2;
            while (eVar3 != null) {
                eVar3 = eVar3.f61d;
                i13++;
            }
        }
        b0.e.d.a.b.c.AbstractC0135a abstractC0135aD = b0.e.d.a.b.c.a().f(str).e(str2).c(u2.c0.c(q(stackTraceElementArr, i10))).d(i13);
        if (eVar2 != null && i13 == 0) {
            abstractC0135aD.b(m(eVar2, i10, i11, i12 + 1));
        }
        return abstractC0135aD.a();
    }

    public final b0.e.d.a.b n(a3.e eVar, Thread thread, int i10, int i11, boolean z10) {
        return b0.e.d.a.b.a().f(y(eVar, thread, i10, z10)).d(l(eVar, i10, i11)).e(v()).c(h()).a();
    }

    public final b0.e.d.a.b o(b0.a aVar) {
        return b0.e.d.a.b.a().b(aVar).e(v()).c(h()).a();
    }

    public final b0.e.d.a.b.AbstractC0138e.AbstractC0140b p(StackTraceElement stackTraceElement, b0.e.d.a.b.AbstractC0138e.AbstractC0140b.AbstractC0141a abstractC0141a) {
        long lineNumber = 0;
        long jMax = stackTraceElement.isNativeMethod() ? Math.max(stackTraceElement.getLineNumber(), 0L) : 0L;
        String str = stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName();
        String fileName = stackTraceElement.getFileName();
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            lineNumber = stackTraceElement.getLineNumber();
        }
        return abstractC0141a.e(jMax).f(str).b(fileName).d(lineNumber).a();
    }

    public final u2.c0 q(StackTraceElement[] stackTraceElementArr, int i10) {
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            arrayList.add(p(stackTraceElement, b0.e.d.a.b.AbstractC0138e.AbstractC0140b.a().c(i10)));
        }
        return u2.c0.c(arrayList);
    }

    public final b0.e.a r() {
        return b0.e.a.a().e(this.f11763b.f()).g(this.f11764c.f11660f).d(this.f11764c.f11661g).f(this.f11763b.a()).b(this.f11764c.f11662h.d()).c(this.f11764c.f11662h.e()).a();
    }

    public final b0.e s(String str, long j10) {
        return b0.e.a().l(j10).i(str).g(f11761g).b(r()).k(u()).d(t()).h(3).a();
    }

    public final b0.e.c t() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        int iF = f();
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        long jT = CommonUtils.t();
        long blockCount = statFs.getBlockCount() * statFs.getBlockSize();
        boolean z10 = CommonUtils.z();
        int iN = CommonUtils.n();
        return b0.e.c.a().b(iF).f(Build.MODEL).c(iAvailableProcessors).h(jT).d(blockCount).i(z10).j(iN).e(Build.MANUFACTURER).g(Build.PRODUCT).a();
    }

    public final b0.e.AbstractC0143e u() {
        return b0.e.AbstractC0143e.a().d(3).e(Build.VERSION.RELEASE).b(Build.VERSION.CODENAME).c(CommonUtils.A()).a();
    }

    public final b0.e.d.a.b.AbstractC0136d v() {
        return b0.e.d.a.b.AbstractC0136d.a().d("0").c("0").b(0L).a();
    }

    public final b0.e.d.a.b.AbstractC0138e w(Thread thread, StackTraceElement[] stackTraceElementArr) {
        return x(thread, stackTraceElementArr, 0);
    }

    public final b0.e.d.a.b.AbstractC0138e x(Thread thread, StackTraceElement[] stackTraceElementArr, int i10) {
        return b0.e.d.a.b.AbstractC0138e.a().d(thread.getName()).c(i10).b(u2.c0.c(q(stackTraceElementArr, i10))).a();
    }

    public final u2.c0 y(a3.e eVar, Thread thread, int i10, boolean z10) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(x(thread, eVar.f60c, i10));
        if (z10) {
            for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
                Thread key = entry.getKey();
                if (!key.equals(thread)) {
                    arrayList.add(w(key, this.f11765d.a(entry.getValue())));
                }
            }
        }
        return u2.c0.c(arrayList);
    }
}
