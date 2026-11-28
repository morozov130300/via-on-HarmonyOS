package g2;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzha;
import java.util.EnumMap;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class f6 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f6 f4794c = new f6(null, null, 100);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EnumMap f4795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4796b;

    public f6(Boolean bool, Boolean bool2, int i10) {
        EnumMap enumMap = new EnumMap(zzha.class);
        this.f4795a = enumMap;
        enumMap.put(zzha.AD_STORAGE, bool);
        enumMap.put(zzha.ANALYTICS_STORAGE, bool2);
        this.f4796b = i10;
    }

    public static f6 b(Bundle bundle, int i10) {
        if (bundle == null) {
            return new f6(null, null, i10);
        }
        EnumMap enumMap = new EnumMap(zzha.class);
        for (zzha zzhaVar : zzha.values()) {
            enumMap.put(zzhaVar, p(bundle.getString(zzhaVar.zzd)));
        }
        return new f6(enumMap, i10);
    }

    public static f6 c(String str, int i10) {
        EnumMap enumMap = new EnumMap(zzha.class);
        if (str != null) {
            int i11 = 0;
            while (true) {
                zzha[] zzhaVarArr = zzha.zzc;
                int length = zzhaVarArr.length;
                if (i11 >= 2) {
                    break;
                }
                zzha zzhaVar = zzhaVarArr[i11];
                int i12 = i11 + 2;
                if (i12 < str.length()) {
                    char cCharAt = str.charAt(i12);
                    Boolean bool = null;
                    if (cCharAt != '-') {
                        if (cCharAt == '0') {
                            bool = Boolean.FALSE;
                        } else if (cCharAt == '1') {
                            bool = Boolean.TRUE;
                        }
                    }
                    enumMap.put(zzhaVar, bool);
                }
                i11++;
            }
        }
        return new f6(enumMap, i10);
    }

    public static String h(Bundle bundle) {
        String string;
        for (zzha zzhaVar : zzha.values()) {
            if (bundle.containsKey(zzhaVar.zzd) && (string = bundle.getString(zzhaVar.zzd)) != null && p(string) == null) {
                return string;
            }
        }
        return null;
    }

    public static boolean k(int i10, int i11) {
        return i10 <= i11;
    }

    public static final int o(Boolean bool) {
        if (bool == null) {
            return 0;
        }
        return bool.booleanValue() ? 1 : 2;
    }

    public static Boolean p(String str) {
        if (str == null) {
            return null;
        }
        if (str.equals("granted")) {
            return Boolean.TRUE;
        }
        if (str.equals("denied")) {
            return Boolean.FALSE;
        }
        return null;
    }

    public final int a() {
        return this.f4796b;
    }

    public final f6 d(f6 f6Var) {
        EnumMap enumMap = new EnumMap(zzha.class);
        for (zzha zzhaVar : zzha.values()) {
            Boolean boolValueOf = (Boolean) this.f4795a.get(zzhaVar);
            Boolean bool = (Boolean) f6Var.f4795a.get(zzhaVar);
            if (boolValueOf == null) {
                boolValueOf = bool;
            } else if (bool != null) {
                boolValueOf = Boolean.valueOf(boolValueOf.booleanValue() && bool.booleanValue());
            }
            enumMap.put(zzhaVar, boolValueOf);
        }
        return new f6(enumMap, 100);
    }

    public final f6 e(f6 f6Var) {
        EnumMap enumMap = new EnumMap(zzha.class);
        for (zzha zzhaVar : zzha.values()) {
            Boolean bool = (Boolean) this.f4795a.get(zzhaVar);
            if (bool == null) {
                bool = (Boolean) f6Var.f4795a.get(zzhaVar);
            }
            enumMap.put(zzhaVar, bool);
        }
        return new f6(enumMap, this.f4796b);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof f6)) {
            return false;
        }
        f6 f6Var = (f6) obj;
        for (zzha zzhaVar : zzha.values()) {
            if (o((Boolean) this.f4795a.get(zzhaVar)) != o((Boolean) f6Var.f4795a.get(zzhaVar))) {
                return false;
            }
        }
        return this.f4796b == f6Var.f4796b;
    }

    public final Boolean f() {
        return (Boolean) this.f4795a.get(zzha.AD_STORAGE);
    }

    public final Boolean g() {
        return (Boolean) this.f4795a.get(zzha.ANALYTICS_STORAGE);
    }

    public final int hashCode() {
        int iO = this.f4796b * 17;
        Iterator it = this.f4795a.values().iterator();
        while (it.hasNext()) {
            iO = (iO * 31) + o((Boolean) it.next());
        }
        return iO;
    }

    public final String i() {
        StringBuilder sb2 = new StringBuilder("G1");
        zzha[] zzhaVarArr = zzha.zzc;
        int length = zzhaVarArr.length;
        for (int i10 = 0; i10 < 2; i10++) {
            Boolean bool = (Boolean) this.f4795a.get(zzhaVarArr[i10]);
            sb2.append(bool == null ? '-' : bool.booleanValue() ? '1' : '0');
        }
        return sb2.toString();
    }

    public final boolean j(zzha zzhaVar) {
        Boolean bool = (Boolean) this.f4795a.get(zzhaVar);
        return bool == null || bool.booleanValue();
    }

    public final boolean l() {
        Iterator it = this.f4795a.values().iterator();
        while (it.hasNext()) {
            if (((Boolean) it.next()) != null) {
                return true;
            }
        }
        return false;
    }

    public final boolean m(f6 f6Var) {
        return n(f6Var, (zzha[]) this.f4795a.keySet().toArray(new zzha[0]));
    }

    public final boolean n(f6 f6Var, zzha... zzhaVarArr) {
        for (zzha zzhaVar : zzhaVarArr) {
            Boolean bool = (Boolean) this.f4795a.get(zzhaVar);
            Boolean bool2 = (Boolean) f6Var.f4795a.get(zzhaVar);
            Boolean bool3 = Boolean.FALSE;
            if (bool == bool3 && bool2 != bool3) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("settings: source=");
        sb2.append(this.f4796b);
        for (zzha zzhaVar : zzha.values()) {
            sb2.append(", ");
            sb2.append(zzhaVar.name());
            sb2.append("=");
            Boolean bool = (Boolean) this.f4795a.get(zzhaVar);
            if (bool == null) {
                sb2.append("uninitialized");
            } else {
                sb2.append(true != bool.booleanValue() ? "denied" : "granted");
            }
        }
        return sb2.toString();
    }

    public f6(EnumMap enumMap, int i10) {
        EnumMap enumMap2 = new EnumMap(zzha.class);
        this.f4795a = enumMap2;
        enumMap2.putAll(enumMap);
        this.f4796b = i10;
    }
}
