package tb;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f12655a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12656b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f12657c;

        public a(String str) {
            this.f12655a = str;
        }

        public double b() {
            double dL = l();
            while (true) {
                if (k('+')) {
                    this.f12657c = true;
                    dL += l();
                } else {
                    if (!k('-')) {
                        return dL;
                    }
                    this.f12657c = true;
                    dL -= l();
                }
            }
        }

        public String c() {
            h();
            int i10 = this.f12656b;
            while (this.f12656b < this.f12655a.length() && Character.isLetter(this.f12655a.charAt(this.f12656b))) {
                this.f12656b++;
            }
            return this.f12655a.substring(i10, this.f12656b);
        }

        public double d() {
            h();
            int i10 = this.f12656b;
            boolean z10 = false;
            while (this.f12656b < this.f12655a.length()) {
                char cCharAt = this.f12655a.charAt(this.f12656b);
                if (Character.isDigit(cCharAt)) {
                    this.f12656b++;
                } else {
                    if (cCharAt != '.' || z10) {
                        break;
                    }
                    this.f12656b++;
                    z10 = true;
                }
            }
            return Double.parseDouble(this.f12655a.substring(i10, this.f12656b));
        }

        public double e() {
            double dB = b();
            h();
            if (this.f12656b == this.f12655a.length()) {
                return dB;
            }
            throw new IllegalArgumentException();
        }

        public double f() {
            double dG = g();
            if (k('^')) {
                this.f12657c = true;
                dG = Math.pow(dG, m());
            }
            while (k('%')) {
                this.f12657c = true;
                dG /= 100.0d;
            }
            return dG;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:33:0x0088  */
        public double g() {
            h();
            if (k('(')) {
                double dB = b();
                if (k(')')) {
                    return dB;
                }
                throw new IllegalArgumentException();
            }
            if (this.f12656b < this.f12655a.length() && (Character.isDigit(this.f12655a.charAt(this.f12656b)) || this.f12655a.charAt(this.f12656b) == '.')) {
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
            byte b10 = 1;
            this.f12657c = true;
            switch (strC.hashCode()) {
                case 3458:
                    if (!strC.equals("ln")) {
                        b10 = -1;
                    } else {
                        b10 = 0;
                    }
                    break;
                case 96370:
                    if (!strC.equals("abs")) {
                        b10 = -1;
                    }
                    break;
                case 98695:
                    if (!strC.equals("cos")) {
                        b10 = -1;
                    } else {
                        b10 = 2;
                    }
                    break;
                case 107332:
                    if (!strC.equals("log")) {
                        b10 = -1;
                    } else {
                        b10 = 3;
                    }
                    break;
                case 113880:
                    if (!strC.equals("sin")) {
                        b10 = -1;
                    } else {
                        b10 = 4;
                    }
                    break;
                case 114593:
                    if (!strC.equals("tan")) {
                        b10 = -1;
                    } else {
                        b10 = 5;
                    }
                    break;
                case 3538208:
                    if (!strC.equals("sqrt")) {
                        b10 = -1;
                    } else {
                        b10 = 6;
                    }
                    break;
                default:
                    b10 = -1;
                    break;
            }
            switch (b10) {
                case 0:
                    if (dB2 > 0.0d) {
                        return Math.log(dB2);
                    }
                    throw new ArithmeticException();
                case 1:
                    return Math.abs(dB2);
                case 2:
                    return Math.cos(dB2);
                case 3:
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
            while (this.f12656b < this.f12655a.length() && Character.isWhitespace(this.f12655a.charAt(this.f12656b))) {
                this.f12656b++;
            }
        }

        public boolean i() {
            h();
            if (this.f12656b >= this.f12655a.length()) {
                return false;
            }
            char cCharAt = this.f12655a.charAt(this.f12656b);
            return cCharAt == '.' || Character.isDigit(cCharAt);
        }

        public boolean j() {
            h();
            if (this.f12656b >= this.f12655a.length()) {
                return false;
            }
            char cCharAt = this.f12655a.charAt(this.f12656b);
            return cCharAt == '(' || cCharAt == '.' || Character.isDigit(cCharAt) || Character.isLetter(cCharAt);
        }

        public boolean k(char c10) {
            h();
            if (this.f12656b >= this.f12655a.length() || this.f12655a.charAt(this.f12656b) != c10) {
                return false;
            }
            this.f12656b++;
            return true;
        }

        public double l() {
            double dM;
            double dM2 = m();
            while (true) {
                if (k('*') || k((char) 215)) {
                    this.f12657c = true;
                    dM = m();
                    dM2 *= dM;
                } else if (k('/') || k((char) 247)) {
                    this.f12657c = true;
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
                    this.f12657c = true;
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
            this.f12657c = true;
            return -m();
        }
    }

    public static String a(String str) {
        if (str != null && !str.trim().isEmpty() && str.length() <= 256) {
            try {
                a aVar = new a(str.toLowerCase(Locale.ROOT));
                double dE = aVar.e();
                if (aVar.f12657c && tb.a.a(dE)) {
                    BigDecimal bigDecimalA = com.google.android.gms.internal.measurement.i.a(new BigDecimal(dE, new MathContext(14, RoundingMode.HALF_UP)));
                    return bigDecimalA.compareTo(BigDecimal.ZERO) == 0 ? "0" : bigDecimalA.toPlainString();
                }
            } catch (RuntimeException unused) {
            }
        }
        return null;
    }
}
