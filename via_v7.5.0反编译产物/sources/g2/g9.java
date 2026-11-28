package g2;

import android.content.pm.PackageManager;
import android.util.Pair;
import com.google.android.gms.measurement.internal.zzha;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class g9 extends ba {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f4832d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h4 f4833e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h4 f4834f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final h4 f4835g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final h4 f4836h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final h4 f4837i;

    public g9(pa paVar) {
        super(paVar);
        this.f4832d = new HashMap();
        l4 l4VarF = this.f4646a.F();
        l4VarF.getClass();
        this.f4833e = new h4(l4VarF, "last_delete_stale", 0L);
        l4 l4VarF2 = this.f4646a.F();
        l4VarF2.getClass();
        this.f4834f = new h4(l4VarF2, "backoff", 0L);
        l4 l4VarF3 = this.f4646a.F();
        l4VarF3.getClass();
        this.f4835g = new h4(l4VarF3, "last_upload", 0L);
        l4 l4VarF4 = this.f4646a.F();
        l4VarF4.getClass();
        this.f4836h = new h4(l4VarF4, "last_upload_attempt", 0L);
        l4 l4VarF5 = this.f4646a.F();
        l4VarF5.getClass();
        this.f4837i = new h4(l4VarF5, "midnight_offset", 0L);
    }

    @Override // g2.ba
    public final boolean l() {
        return false;
    }

    public final Pair m(String str) {
        f9 f9Var;
        q1.a.C0113a c0113aA;
        h();
        long jB = this.f4646a.a().b();
        f9 f9Var2 = (f9) this.f4832d.get(str);
        if (f9Var2 != null && jB < f9Var2.f4807c) {
            return new Pair(f9Var2.f4805a, Boolean.valueOf(f9Var2.f4806b));
        }
        q1.a.b(true);
        long jR = this.f4646a.z().r(str, i3.f4915c) + jB;
        try {
            long jR2 = this.f4646a.z().r(str, i3.f4917d);
            if (jR2 > 0) {
                try {
                    c0113aA = q1.a.a(this.f4646a.c());
                } catch (PackageManager.NameNotFoundException unused) {
                    if (f9Var2 != null && jB < f9Var2.f4807c + jR2) {
                        return new Pair(f9Var2.f4805a, Boolean.valueOf(f9Var2.f4806b));
                    }
                    c0113aA = null;
                }
            } else {
                c0113aA = q1.a.a(this.f4646a.c());
            }
            if (c0113aA == null) {
                return new Pair("00000000-0000-0000-0000-000000000000", Boolean.FALSE);
            }
            String strA = c0113aA.a();
            f9Var = strA != null ? new f9(strA, c0113aA.b(), jR) : new f9("", c0113aA.b(), jR);
            this.f4832d.put(str, f9Var);
            q1.a.b(false);
            return new Pair(f9Var.f4805a, Boolean.valueOf(f9Var.f4806b));
        } catch (Exception e10) {
            this.f4646a.d().q().b("Unable to get advertising id", e10);
            f9Var = new f9("", false, jR);
        }
    }

    public final Pair n(String str, f6 f6Var) {
        return f6Var.j(zzha.AD_STORAGE) ? m(str) : new Pair("", Boolean.FALSE);
    }

    public final String o(String str, boolean z10) {
        h();
        String str2 = z10 ? (String) m(str).first : "00000000-0000-0000-0000-000000000000";
        MessageDigest messageDigestT = wa.t();
        if (messageDigestT == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, messageDigestT.digest(str2.getBytes())));
    }
}
