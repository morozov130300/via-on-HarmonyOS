package f2;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.measurement.jc;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class v3 extends b6 {

    /* renamed from: c, reason: collision with root package name */
    public char f5747c;

    /* renamed from: d, reason: collision with root package name */
    public long f5748d;

    /* renamed from: e, reason: collision with root package name */
    public String f5749e;

    /* renamed from: f, reason: collision with root package name */
    public final t3 f5750f;

    /* renamed from: g, reason: collision with root package name */
    public final t3 f5751g;

    /* renamed from: h, reason: collision with root package name */
    public final t3 f5752h;

    /* renamed from: i, reason: collision with root package name */
    public final t3 f5753i;

    /* renamed from: j, reason: collision with root package name */
    public final t3 f5754j;

    /* renamed from: k, reason: collision with root package name */
    public final t3 f5755k;

    /* renamed from: l, reason: collision with root package name */
    public final t3 f5756l;

    /* renamed from: m, reason: collision with root package name */
    public final t3 f5757m;

    /* renamed from: n, reason: collision with root package name */
    public final t3 f5758n;

    public v3(h5 h5Var) {
        super(h5Var);
        this.f5747c = (char) 0;
        this.f5748d = -1L;
        this.f5750f = new t3(this, 6, false, false);
        this.f5751g = new t3(this, 6, true, false);
        this.f5752h = new t3(this, 6, false, true);
        this.f5753i = new t3(this, 5, false, false);
        this.f5754j = new t3(this, 5, true, false);
        this.f5755k = new t3(this, 5, false, true);
        this.f5756l = new t3(this, 4, false, false);
        this.f5757m = new t3(this, 3, false, false);
        this.f5758n = new t3(this, 2, false, false);
    }

    public static String A(boolean z10, String str, Object obj, Object obj2, Object obj3) {
        String strB = B(z10, obj);
        String strB2 = B(z10, obj2);
        String strB3 = B(z10, obj3);
        StringBuilder sb2 = new StringBuilder();
        String str2 = "";
        if (str == null) {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            sb2.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(strB)) {
            sb2.append(str2);
            sb2.append(strB);
            str2 = ", ";
        }
        if (TextUtils.isEmpty(strB2)) {
            str3 = str2;
        } else {
            sb2.append(str2);
            sb2.append(strB2);
        }
        if (!TextUtils.isEmpty(strB3)) {
            sb2.append(str3);
            sb2.append(strB3);
        }
        return sb2.toString();
    }

    public static String B(boolean z10, Object obj) {
        String className;
        if (obj == null) {
            return "";
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf(((Integer) obj).intValue());
        }
        int i10 = 0;
        if (obj instanceof Long) {
            if (!z10) {
                return obj.toString();
            }
            Long l10 = (Long) obj;
            if (Math.abs(l10.longValue()) < 100) {
                return obj.toString();
            }
            char cCharAt = obj.toString().charAt(0);
            String strValueOf = String.valueOf(Math.abs(l10.longValue()));
            long jRound = Math.round(Math.pow(10.0d, strValueOf.length() - 1));
            long jRound2 = Math.round(Math.pow(10.0d, strValueOf.length()) - 1.0d);
            StringBuilder sb2 = new StringBuilder();
            String str = cCharAt == '-' ? "-" : "";
            sb2.append(str);
            sb2.append(jRound);
            sb2.append("...");
            sb2.append(str);
            sb2.append(jRound2);
            return sb2.toString();
        }
        if (obj instanceof Boolean) {
            return obj.toString();
        }
        if (!(obj instanceof Throwable)) {
            return obj instanceof u3 ? ((u3) obj).f5723a : z10 ? "-" : obj.toString();
        }
        Throwable th = (Throwable) obj;
        StringBuilder sb3 = new StringBuilder(z10 ? th.getClass().getName() : th.toString());
        String strC = C(h5.class.getCanonicalName());
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length = stackTrace.length;
        while (true) {
            if (i10 >= length) {
                break;
            }
            StackTraceElement stackTraceElement = stackTrace[i10];
            if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null && C(className).equals(strC)) {
                sb3.append(": ");
                sb3.append(stackTraceElement);
                break;
            }
            i10++;
        }
        return sb3.toString();
    }

    public static String C(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf != -1) {
            return str.substring(0, iLastIndexOf);
        }
        jc.b();
        return ((Boolean) i3.A0.a(null)).booleanValue() ? "" : str;
    }

    public static Object z(String str) {
        if (str == null) {
            return null;
        }
        return new u3(str);
    }

    public final String D() {
        String str;
        synchronized (this) {
            try {
                if (this.f5749e == null) {
                    if (this.f5030a.Q() != null) {
                        this.f5749e = this.f5030a.Q();
                    } else {
                        this.f5749e = this.f5030a.z().w();
                    }
                }
                t1.f.h(this.f5749e);
                str = this.f5749e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    public final void G(int i10, boolean z10, boolean z11, String str, Object obj, Object obj2, Object obj3) {
        if (!z10 && Log.isLoggable(D(), i10)) {
            Log.println(i10, D(), A(false, str, obj, obj2, obj3));
        }
        if (z11 || i10 < 5) {
            return;
        }
        t1.f.h(str);
        e5 e5VarG = this.f5030a.G();
        if (e5VarG == null) {
            Log.println(6, D(), "Scheduler not set. Not logging error/warn");
        } else if (e5VarG.n()) {
            e5VarG.z(new s3(this, i10 >= 9 ? 8 : i10, str, obj, obj2, obj3));
        } else {
            Log.println(6, D(), "Scheduler not initialized. Not logging error/warn");
        }
    }

    @Override // f2.b6
    public final boolean j() {
        return false;
    }

    public final t3 q() {
        return this.f5757m;
    }

    public final t3 r() {
        return this.f5750f;
    }

    public final t3 s() {
        return this.f5752h;
    }

    public final t3 t() {
        return this.f5751g;
    }

    public final t3 u() {
        return this.f5756l;
    }

    public final t3 v() {
        return this.f5758n;
    }

    public final t3 w() {
        return this.f5753i;
    }

    public final t3 x() {
        return this.f5755k;
    }

    public final t3 y() {
        return this.f5754j;
    }
}
