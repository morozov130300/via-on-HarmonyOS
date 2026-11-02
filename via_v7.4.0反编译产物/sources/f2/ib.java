package f2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.PatternSyntaxException;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class ib {

    /* renamed from: a, reason: collision with root package name */
    public final String f5363a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5364b;

    /* renamed from: c, reason: collision with root package name */
    public Boolean f5365c;

    /* renamed from: d, reason: collision with root package name */
    public Boolean f5366d;

    /* renamed from: e, reason: collision with root package name */
    public Long f5367e;

    /* renamed from: f, reason: collision with root package name */
    public Long f5368f;

    public ib(String str, int i10) {
        this.f5363a = str;
        this.f5364b = i10;
    }

    public static Boolean d(String str, int i10, boolean z10, String str2, List list, String str3, v3 v3Var) {
        if (i10 == 7) {
            if (list == null || list.isEmpty()) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z10 && i10 != 2) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (i10 - 1) {
            case 1:
                if (str3 != null) {
                    try {
                        break;
                    } catch (PatternSyntaxException unused) {
                        if (v3Var != null) {
                            v3Var.w().b("Invalid regular expression in REGEXP audience filter. expression", str3);
                        }
                        return null;
                    }
                }
                break;
            case 6:
                if (list != null) {
                    break;
                }
                break;
        }
        return null;
    }

    public static Boolean e(BigDecimal bigDecimal, com.google.android.gms.internal.measurement.g3 g3Var, double d10) {
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        t1.f.h(g3Var);
        if (g3Var.J()) {
            if (g3Var.O() != 1) {
                if (g3Var.O() == 5) {
                    if (!g3Var.N() || !g3Var.M()) {
                        return null;
                    }
                } else if (!g3Var.K()) {
                    return null;
                }
                int iO = g3Var.O();
                if (g3Var.O() == 5) {
                    if (ra.P(g3Var.H()) && ra.P(g3Var.G())) {
                        try {
                            BigDecimal bigDecimal5 = new BigDecimal(g3Var.H());
                            bigDecimal4 = new BigDecimal(g3Var.G());
                            bigDecimal3 = bigDecimal5;
                            bigDecimal2 = null;
                        } catch (NumberFormatException unused) {
                        }
                    }
                    return null;
                }
                if (!ra.P(g3Var.F())) {
                    return null;
                }
                try {
                    bigDecimal2 = new BigDecimal(g3Var.F());
                    bigDecimal3 = null;
                    bigDecimal4 = null;
                } catch (NumberFormatException unused2) {
                }
                if (iO == 5) {
                    if (bigDecimal3 == null) {
                        return null;
                    }
                } else if (bigDecimal2 == null) {
                    return null;
                }
                int i10 = iO - 1;
                if (i10 == 1) {
                    if (bigDecimal2 == null) {
                        return null;
                    }
                    return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) < 0);
                }
                if (i10 == 2) {
                    if (bigDecimal2 == null) {
                        return null;
                    }
                    return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) > 0);
                }
                if (i10 != 3) {
                    if (i10 == 4 && bigDecimal3 != null) {
                        return Boolean.valueOf(bigDecimal.compareTo(bigDecimal3) >= 0 && bigDecimal.compareTo(bigDecimal4) <= 0);
                    }
                    return null;
                }
                if (bigDecimal2 == null) {
                    return null;
                }
                if (d10 != 0.0d) {
                    return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2.subtract(new BigDecimal(d10).multiply(new BigDecimal(2)))) > 0 && bigDecimal.compareTo(bigDecimal2.add(new BigDecimal(d10).multiply(new BigDecimal(2)))) < 0);
                }
                return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) == 0);
            }
        }
        return null;
    }

    public static Boolean f(String str, com.google.android.gms.internal.measurement.n3 n3Var, v3 v3Var) {
        List list;
        t1.f.h(n3Var);
        if (str == null || !n3Var.L() || n3Var.M() == 1) {
            return null;
        }
        if (n3Var.M() == 7) {
            if (n3Var.D() == 0) {
                return null;
            }
        } else if (!n3Var.K()) {
            return null;
        }
        int iM = n3Var.M();
        boolean zI = n3Var.I();
        String strG = (zI || iM == 2 || iM == 7) ? n3Var.G() : n3Var.G().toUpperCase(Locale.ENGLISH);
        if (n3Var.D() == 0) {
            list = null;
        } else {
            List listH = n3Var.H();
            if (!zI) {
                ArrayList arrayList = new ArrayList(listH.size());
                Iterator it = listH.iterator();
                while (it.hasNext()) {
                    arrayList.add(((String) it.next()).toUpperCase(Locale.ENGLISH));
                }
                listH = Collections.unmodifiableList(arrayList);
            }
            list = listH;
        }
        return d(str, iM, zI, strG, list, iM == 2 ? strG : null, v3Var);
    }

    public static Boolean g(double d10, com.google.android.gms.internal.measurement.g3 g3Var) {
        try {
            return e(new BigDecimal(d10), g3Var, Math.ulp(d10));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Boolean h(long j10, com.google.android.gms.internal.measurement.g3 g3Var) {
        try {
            return e(new BigDecimal(j10), g3Var, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Boolean i(String str, com.google.android.gms.internal.measurement.g3 g3Var) {
        if (!ra.P(str)) {
            return null;
        }
        try {
            return e(new BigDecimal(str), g3Var, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Boolean j(Boolean bool, boolean z10) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z10);
    }

    public abstract int a();

    public abstract boolean b();

    public abstract boolean c();
}
