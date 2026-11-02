package k2;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.l7;
import com.google.android.gms.internal.measurement.zzja;
import com.google.android.gms.internal.measurement.zzjb;
import f2.i6;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final zzjb f8110a = zzjb.zzi("_in", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", "campaign_details", "_ug", "_iapx", "_exp_set", "_exp_clear", "_exp_activate", "_exp_timeout", "_exp_expire");

    /* renamed from: b, reason: collision with root package name */
    public static final zzja f8111b = zzja.zzj("_e", "_f", "_iap", "_s", "_au", "_ui", "_cd");

    /* renamed from: c, reason: collision with root package name */
    public static final zzja f8112c = zzja.zzi("auto", "app", "am");

    /* renamed from: d, reason: collision with root package name */
    public static final zzja f8113d = zzja.zzh("_r", "_dbg");

    /* renamed from: e, reason: collision with root package name */
    public static final zzja f8114e;

    /* renamed from: f, reason: collision with root package name */
    public static final zzja f8115f;

    static {
        l7 l7Var = new l7();
        l7Var.a(i6.f5350a);
        l7Var.a(i6.f5351b);
        f8114e = l7Var.b();
        f8115f = zzja.zzh("^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$");
    }

    public static boolean a(String str, String str2, Bundle bundle) {
        if (!"_cmp".equals(str2)) {
            return true;
        }
        if (!d(str) || bundle == null) {
            return false;
        }
        zzja zzjaVar = f8113d;
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
        if (f8111b.contains(str)) {
            return false;
        }
        if (bundle == null) {
            return true;
        }
        zzja zzjaVar = f8113d;
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
        return !f8110a.contains(str);
    }

    public static boolean d(String str) {
        return !f8112c.contains(str);
    }
}
