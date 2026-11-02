package tb;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Locale;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class b {

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f12356a;

        /* renamed from: b, reason: collision with root package name */
        public int f12357b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f12358c;

        public a(String str) {
            this.f12356a = str;
        }

        public double b() {
            double dL = l();
            while (true) {
                if (k('+')) {
                    this.f12358c = true;
                    dL += l();
                } else {
                    if (!k('-')) {
                        return dL;
                    }
                    this.f12358c = true;
                    dL -= l();
                }
            }
        }

        public String c() {
            h();
            int i10 = this.f12357b;
            while (this.f12357b < this.f12356a.length() && Character.isLetter(this.f12356a.charAt(this.f12357b))) {
                this.f12357b++;
            }
            return this.f12356a.substring(i10, this.f12357b);
        }

        public double d() {
            h();
            int i10 = this.f12357b;
            boolean z10 = false;
            while (this.f12357b < this.f12356a.length()) {
                char cCharAt = this.f12356a.charAt(this.f12357b);
                if (Character.isDigit(cCharAt)) {
                    this.f12357b++;
                } else {
                    if (cCharAt != '.' || z10) {
                        break;
                    }
                    this.f12357b++;
                    z10 = true;
                }
            }
            return Double.parseDouble(this.f12356a.substring(i10, this.f12357b));
        }

        public double e() {
            double dB = b();
            h();
            if (this.f12357b == this.f12356a.length()) {
                return dB;
            }
            throw new IllegalArgumentException();
        }

        public double f() {
            double dG = g();
            if (k('^')) {
                this.f12358c = true;
                dG = Math.pow(dG, m());
            }
            while (k('%')) {
                this.f12358c = true;
                dG /= 100.0d;
            }
            return dG;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0088  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public double g() {
            h();
            if (k('(')) {
                double dB = b();
                if (k(')')) {
                    return dB;
                }
                throw new IllegalArgumentException();
            }
            if (this.f12357b < this.f12356a.length() && (Character.isDigit(this.f12356a.charAt(this.f12357b)) || this.f12356a.charAt(this.f12357b) == '.')) {
                return d();
            }
            String strC = c();
            if ("pi".equals(strC)) {
                return 3.141592653589793d;
            }
            if ("e".equals(strC)) {
                return 2.718281828459045d;
            }
            if (strC.isEmpty() || !k('(')) {
                throw new IllegalArgumentException();
            }
            double dB2 = b();
            if (!k(')')) {
                throw new IllegalArgumentException();
            }
            char c10 = 1;
            this.f12358c = true;
            switch (strC.hashCode()) {
                case 3458:
                    if (!strC.equals("ln")) {
                        c10 = '\uffff';
                        break;
                    } else {
                        c10 = 0;
                        break;
                    }
                case 96370:
                    if (!strC.equals("abs")) {
                    }
                    break;
                case 98695:
                    if (strC.equals("cos")) {
                        c10 = 2;
                        break;
                    }
                    break;
                case 107332:
                    if (strC.equals("log")) {
                        c10 = 3;
                        break;
                    }
                    break;
                case 113880:
                    if (strC.equals("sin")) {
                        c10 = 4;
                        break;
                    }
                    break;
                case 114593:
                    if (strC.equals("tan")) {
                        c10 = 5;
                        break;
                    }
                    break;
                case 3538208:
                    if (strC.equals("sqrt")) {
                        c10 = 6;
                        break;
                    }
                    break;
            }
            switch (c10) {
                case 0:
                    if (dB2 > 0.0d) {
                        return Math.log(dB2);
                    }
                    throw new ArithmeticException();
                case 1:
                    return Math.abs(dB2);
                case 2:
                    return Math.cos(dB2);
                case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                    if (dB2 > 0.0d) {
                        return Math.log10(dB2);
                    }
                    throw new ArithmeticException();
                case 4:
                    return Math.sin(dB2);
                case 5:
                    return Math.tan(dB2);
                case 6:
                    if (dB2 >= 0.0d) {
                        return Math.sqrt(dB2);
                    }
                    throw new ArithmeticException();
                default:
                    throw new IllegalArgumentException();
            }
        }

        public void h() {
            while (this.f12357b < this.f12356a.length() && Character.isWhitespace(this.f12356a.charAt(this.f12357b))) {
                this.f12357b++;
            }
        }

        public boolean i() {
            h();
            if (this.f12357b >= this.f12356a.length()) {
                return false;
            }
            char cCharAt = this.f12356a.charAt(this.f12357b);
            return cCharAt == '.' || Character.isDigit(cCharAt);
        }

        public boolean j() {
            h();
            if (this.f12357b >= this.f12356a.length()) {
                return false;
            }
            char cCharAt = this.f12356a.charAt(this.f12357b);
            return cCharAt == '(' || cCharAt == '.' || Character.isDigit(cCharAt) || Character.isLetter(cCharAt);
        }

        public boolean k(char c10) {
            h();
            if (this.f12357b >= this.f12356a.length() || this.f12356a.charAt(this.f12357b) != c10) {
                return false;
            }
            this.f12357b++;
            return true;
        }

        public double l() {
            double dM;
            double dM2 = m();
            while (true) {
                if (k('*') || k('\u00d7')) {
                    this.f12358c = true;
                    dM = m();
                    dM2 *= dM;
                } else if (k('/') || k('\u00f7')) {
                    this.f12358c = true;
                    double dM3 = m();
                    if (dM3 == 0.0d) {
                        throw new ArithmeticException();
                    }
                    dM2 /= dM3;
                } else {
                    if (!j()) {
                        return dM2;
                    }
                    if (i()) {
                        throw new IllegalArgumentException();
                    }
                    this.f12358c = true;
                    dM = m();
                    dM2 *= dM;
                }
            }
        }

        public double m() {
            if (k('+')) {
                return m();
            }
            if (!k('-')) {
                return f();
            }
            this.f12358c = true;
            return -m();
        }
    }

    public static String a(String str) {
        if (str != null && !str.trim().isEmpty() && str.length() <= 256) {
            try {
                a aVar = new a(str.toLowerCase(Locale.ROOT));
                double dE = aVar.e();
                if (aVar.f12358c && tb.a.a(dE)) {
                    BigDecimal bigDecimalA = com.google.android.gms.internal.measurement.i.a(new BigDecimal(dE, new MathContext(14, RoundingMode.HALF_UP)));
                    return bigDecimalA.compareTo(BigDecimal.ZERO) == 0 ? "0" : bigDecimalA.toPlainString();
                }
            } catch (RuntimeException unused) {
            }
        }
        return null;
    }
}
