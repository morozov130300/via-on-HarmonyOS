package l2;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.l7;
import com.google.android.gms.internal.measurement.zzja;
import com.google.android.gms.internal.measurement.zzjb;
import g2.i6;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zzjb f7457a = zzjb.zzi("_in", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", "campaign_details", "_ug", "_iapx", "_exp_set", "_exp_clear", "_exp_activate", "_exp_timeout", "_exp_expire");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final zzja f7458b = zzja.zzj("_e", "_f", "_iap", "_s", "_au", "_ui", "_cd");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final zzja f7459c = zzja.zzi("auto", "app", "am");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final zzja f7460d = zzja.zzh("_r", "_dbg");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final zzja f7461e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final zzja f7462f;

    static {
        l7 l7Var = new l7();
        l7Var.a(i6.f4966a);
        l7Var.a(i6.f4967b);
        f7461e = l7Var.b();
        f7462f = zzja.zzh("^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$");
    }

    public static boolean a(String str, String str2, Bundle bundle) {
        if (!"_cmp".equals(str2)) {
            return true;
        }
        if (!d(str) || bundle == null) {
            return false;
        }
        zzja zzjaVar = f7460d;
        int size = zzjaVar.size();
        int i10 = 0;
        while (i10 < size) {
            boolean zContainsKey = bundle.containsKey((String) zzjaVar.get(i10));
            i10++;
            if (zContainsKey) {
                return false;
            }
        }
        int iHashCode = str.hashCode();
        if (iHashCode != 101200) {
            if (iHashCode != 101230) {
                if (iHashCode == 3142703 && str.equals("fiam")) {
                    bundle.putString("_cis", "fiam_integration");
                    return true;
                }
            } else if (str.equals("fdl")) {
                bundle.putString("_cis", "fdl_integration");
                return true;
            }
        } else if (str.equals("fcm")) {
            bundle.putString("_cis", "fcm_integration");
            return true;
        }
        return false;
    }

    public static boolean b(String str, Bundle bundle) {
        if (f7458b.contains(str)) {
            return false;
        }
        if (bundle == null) {
            return true;
        }
        zzja zzjaVar = f7460d;
        int size = zzjaVar.size();
        int i10 = 0;
        while (i10 < size) {
            boolean zContainsKey = bundle.containsKey((String) zzjaVar.get(i10));
            i10++;
            if (zContainsKey) {
                return false;
            }
        }
        return true;
    }

    public static boolean c(String str) {
        return !f7457a.contains(str);
    }

    public static boolean d(String str) {
        return !f7459c.contains(str);
    }
}
