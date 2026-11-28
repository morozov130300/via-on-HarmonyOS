package g2;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.measurement.jc;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class v3 extends b6 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public char f5363c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f5364d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f5365e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final t3 f5366f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final t3 f5367g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final t3 f5368h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final t3 f5369i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final t3 f5370j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final t3 f5371k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final t3 f5372l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final t3 f5373m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final t3 f5374n;

    public v3(h5 h5Var) {
        super(h5Var);
        this.f5363c = (char) 0;
        this.f5364d = -1L;
        this.f5366f = new t3(this, 6, false, false);
        this.f5367g = new t3(this, 6, true, false);
        this.f5368h = new t3(this, 6, false, true);
        this.f5369i = new t3(this, 5, false, false);
        this.f5370j = new t3(this, 5, true, false);
        this.f5371k = new t3(this, 5, false, true);
        this.f5372l = new t3(this, 4, false, false);
        this.f5373m = new t3(this, 3, false, false);
        this.f5374n = new t3(this, 2, false, false);
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
            if (obj instanceof u3) {
                return ((u3) obj).f5339a;
            }
            return z10 ? "-" : obj.toString();
        }
        Throwable th = (Throwable) obj;
        StringBuilder sb3 = new StringBuilder(z10 ? th.getClass().getName() : th.toString());
        String strC = C(h5.class.getCanonicalName());
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null && C(className).equals(strC)) {
                sb3.append(": ");
                sb3.append(stackTraceElement);
                break;
            }
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
                if (this.f5365e == null) {
                    if (this.f4646a.Q() != null) {
                        this.f5365e = this.f4646a.Q();
                    } else {
                        this.f5365e = this.f4646a.z().w();
                    }
                }
                u1.f.h(this.f5365e);
                str = this.f5365e;
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
        u1.f.h(str);
        e5 e5VarG = this.f4646a.G();
        if (e5VarG == null) {
            Log.println(6, D(), "Scheduler not set. Not logging error/warn");
        } else if (e5VarG.n()) {
            e5VarG.z(new s3(this, i10 >= 9 ? 8 : i10, str, obj, obj2, obj3));
        } else {
            Log.println(6, D(), "Scheduler not initialized. Not logging error/warn");
        }
    }

    @Override // g2.b6
    public final boolean j() {
        return false;
    }

    public final t3 q() {
        return this.f5373m;
    }

    public final t3 r() {
        return this.f5366f;
    }

    public final t3 s() {
        return this.f5368h;
    }

    public final t3 t() {
        return this.f5367g;
    }

    public final t3 u() {
        return this.f5372l;
    }

    public final t3 v() {
        return this.f5374n;
    }

    public final t3 w() {
        return this.f5369i;
    }

    public final t3 x() {
        return this.f5371k;
    }

    public final t3 y() {
        return this.f5370j;
    }
}
