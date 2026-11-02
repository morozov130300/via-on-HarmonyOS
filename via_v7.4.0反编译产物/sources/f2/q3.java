package f2;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzas;
import com.google.android.gms.measurement.internal.zzau;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class q3 {

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicReference f5627b = new AtomicReference();

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicReference f5628c = new AtomicReference();

    /* renamed from: d, reason: collision with root package name */
    public static final AtomicReference f5629d = new AtomicReference();

    /* renamed from: a, reason: collision with root package name */
    public final p3 f5630a;

    public q3(p3 p3Var) {
        this.f5630a = p3Var;
    }

    public static final String g(String str, String[] strArr, String[] strArr2, AtomicReference atomicReference) {
        String str2;
        t1.f.h(strArr);
        t1.f.h(strArr2);
        t1.f.h(atomicReference);
        t1.f.a(strArr.length == strArr2.length);
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
        if (bundle == null) {
            return null;
        }
        if (!this.f5630a.zza()) {
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
            sb2.append(obj instanceof Bundle ? a(new Object[]{obj}) : obj instanceof Object[] ? a((Object[]) obj) : obj instanceof ArrayList ? a(((ArrayList) obj).toArray()) : String.valueOf(obj));
        }
        sb2.append("}]");
        return sb2.toString();
    }

    public final String c(zzau zzauVar) {
        if (!this.f5630a.zza()) {
            return zzauVar.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("origin=");
        sb2.append(zzauVar.f3966k);
        sb2.append(",name=");
        sb2.append(d(zzauVar.f3964e));
        sb2.append(",params=");
        zzas zzasVar = zzauVar.f3965j;
        sb2.append(zzasVar == null ? null : !this.f5630a.zza() ? zzasVar.toString() : b(zzasVar.g()));
        return sb2.toString();
    }

    public final String d(String str) {
        if (str == null) {
            return null;
        }
        return !this.f5630a.zza() ? str : g(str, g6.f5208c, g6.f5206a, f5627b);
    }

    public final String e(String str) {
        if (str == null) {
            return null;
        }
        return !this.f5630a.zza() ? str : g(str, h6.f5273b, h6.f5272a, f5628c);
    }

    public final String f(String str) {
        if (str == null) {
            return null;
        }
        if (!this.f5630a.zza()) {
            return str;
        }
        if (!str.startsWith("_exp_")) {
            return g(str, i6.f5351b, i6.f5350a, f5629d);
        }
        return "experiment_id(" + str + ")";
    }
}
