package g2;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzas;
import com.google.android.gms.measurement.internal.zzau;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class q3 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicReference f5243b = new AtomicReference();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReference f5244c = new AtomicReference();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicReference f5245d = new AtomicReference();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p3 f5246a;

    public q3(p3 p3Var) {
        this.f5246a = p3Var;
    }

    public static final String g(String str, String[] strArr, String[] strArr2, AtomicReference atomicReference) {
        String str2;
        u1.f.h(strArr);
        u1.f.h(strArr2);
        u1.f.h(atomicReference);
        u1.f.a(strArr.length == strArr2.length);
        for (int i10 = 0; i10 < strArr.length; i10++) {
            Object obj = strArr[i10];
            if (str == obj || str.equals(obj)) {
                synchronized (atomicReference) {
                    try {
                        String[] strArr3 = (String[]) atomicReference.get();
                        if (strArr3 == null) {
                            strArr3 = new String[strArr2.length];
                            atomicReference.set(strArr3);
                        }
                        str2 = strArr3[i10];
                        if (str2 == null) {
                            str2 = strArr2[i10] + "(" + strArr[i10] + ")";
                            strArr3[i10] = str2;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return str2;
            }
        }
        return str;
    }

    public final String a(Object[] objArr) {
        if (objArr == null) {
            return "[]";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        for (Object obj : objArr) {
            String strB = obj instanceof Bundle ? b((Bundle) obj) : String.valueOf(obj);
            if (strB != null) {
                if (sb2.length() != 1) {
                    sb2.append(", ");
                }
                sb2.append(strB);
            }
        }
        sb2.append("]");
        return sb2.toString();
    }

    public final String b(Bundle bundle) {
        String strA;
        if (bundle == null) {
            return null;
        }
        if (!this.f5246a.zza()) {
            return bundle.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Bundle[{");
        for (String str : bundle.keySet()) {
            if (sb2.length() != 8) {
                sb2.append(", ");
            }
            sb2.append(e(str));
            sb2.append("=");
            Object obj = bundle.get(str);
            if (obj instanceof Bundle) {
                strA = a(new Object[]{obj});
            } else if (obj instanceof Object[]) {
                strA = a((Object[]) obj);
            } else {
                strA = obj instanceof ArrayList ? a(((ArrayList) obj).toArray()) : String.valueOf(obj);
            }
            sb2.append(strA);
        }
        sb2.append("}]");
        return sb2.toString();
    }

    public final String c(zzau zzauVar) {
        String string;
        if (!this.f5246a.zza()) {
            return zzauVar.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("origin=");
        sb2.append(zzauVar.f3265m);
        sb2.append(",name=");
        sb2.append(d(zzauVar.f3263c));
        sb2.append(",params=");
        zzas zzasVar = zzauVar.f3264e;
        if (zzasVar == null) {
            string = null;
        } else {
            string = !this.f5246a.zza() ? zzasVar.toString() : b(zzasVar.g());
        }
        sb2.append(string);
        return sb2.toString();
    }

    public final String d(String str) {
        if (str == null) {
            return null;
        }
        return !this.f5246a.zza() ? str : g(str, g6.f4824c, g6.f4822a, f5243b);
    }

    public final String e(String str) {
        if (str == null) {
            return null;
        }
        return !this.f5246a.zza() ? str : g(str, h6.f4889b, h6.f4888a, f5244c);
    }

    public final String f(String str) {
        if (str == null) {
            return null;
        }
        if (!this.f5246a.zza()) {
            return str;
        }
        if (!str.startsWith("_exp_")) {
            return g(str, i6.f4967b, i6.f4966a, f5245d);
        }
        return "experiment_id(" + str + ")";
    }
}
