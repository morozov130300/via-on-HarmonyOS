package f2;

import android.content.pm.PackageManager;
import android.util.Pair;
import com.google.android.gms.measurement.internal.zzha;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import p1.a;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class g9 extends ba {

    /* renamed from: d, reason: collision with root package name */
    public final Map f5216d;

    /* renamed from: e, reason: collision with root package name */
    public final h4 f5217e;

    /* renamed from: f, reason: collision with root package name */
    public final h4 f5218f;

    /* renamed from: g, reason: collision with root package name */
    public final h4 f5219g;

    /* renamed from: h, reason: collision with root package name */
    public final h4 f5220h;

    /* renamed from: i, reason: collision with root package name */
    public final h4 f5221i;

    public g9(pa paVar) {
        super(paVar);
        this.f5216d = new HashMap();
        l4 l4VarF = this.f5030a.F();
        l4VarF.getClass();
        this.f5217e = new h4(l4VarF, "last_delete_stale", 0L);
        l4 l4VarF2 = this.f5030a.F();
        l4VarF2.getClass();
        this.f5218f = new h4(l4VarF2, "backoff", 0L);
        l4 l4VarF3 = this.f5030a.F();
        l4VarF3.getClass();
        this.f5219g = new h4(l4VarF3, "last_upload", 0L);
        l4 l4VarF4 = this.f5030a.F();
        l4VarF4.getClass();
        this.f5220h = new h4(l4VarF4, "last_upload_attempt", 0L);
        l4 l4VarF5 = this.f5030a.F();
        l4VarF5.getClass();
        this.f5221i = new h4(l4VarF5, "midnight_offset", 0L);
    }

    @Override // f2.ba
    public final boolean l() {
        return false;
    }

    public final Pair m(String str) {
        f9 f9Var;
        a.C0109a c0109aA;
        h();
        long jB = this.f5030a.a().b();
        f9 f9Var2 = (f9) this.f5216d.get(str);
        if (f9Var2 != null && jB < f9Var2.f5191c) {
            return new Pair(f9Var2.f5189a, Boolean.valueOf(f9Var2.f5190b));
        }
        p1.a.b(true);
        long jR = this.f5030a.z().r(str, i3.f5299c) + jB;
        try {
            long jR2 = this.f5030a.z().r(str, i3.f5301d);
            if (jR2 > 0) {
                try {
                    c0109aA = p1.a.a(this.f5030a.c());
                } catch (PackageManager.NameNotFoundException unused) {
                    if (f9Var2 != null && jB < f9Var2.f5191c + jR2) {
                        return new Pair(f9Var2.f5189a, Boolean.valueOf(f9Var2.f5190b));
                    }
                    c0109aA = null;
                }
            } else {
                c0109aA = p1.a.a(this.f5030a.c());
            }
        } catch (Exception e10) {
            this.f5030a.d().q().b("Unable to get advertising id", e10);
            f9Var = new f9("", false, jR);
        }
        if (c0109aA == null) {
            return new Pair("00000000-0000-0000-0000-000000000000", Boolean.FALSE);
        }
        String strA = c0109aA.a();
        f9Var = strA != null ? new f9(strA, c0109aA.b(), jR) : new f9("", c0109aA.b(), jR);
        this.f5216d.put(str, f9Var);
        p1.a.b(false);
        return new Pair(f9Var.f5189a, Boolean.valueOf(f9Var.f5190b));
    }

    public final Pair n(String str, f6 f6Var) {
        return f6Var.j(zzha.AD_STORAGE) ? m(str) : new Pair("", Boolean.FALSE);
    }

    public final String o(String str, boolean z10) throws NoSuchAlgorithmException {
        h();
        String str2 = z10 ? (String) m(str).first : "00000000-0000-0000-0000-000000000000";
        MessageDigest messageDigestT = wa.t();
        if (messageDigestT == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, messageDigestT.digest(str2.getBytes())));
    }
}
