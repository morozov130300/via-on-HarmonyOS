package y3;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.oned.rss.expanded.decoders.CurrentParsingState;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final s3.a f14449a;

    /* renamed from: b, reason: collision with root package name */
    public final CurrentParsingState f14450b = new CurrentParsingState();

    /* renamed from: c, reason: collision with root package name */
    public final StringBuilder f14451c = new StringBuilder();

    public r(s3.a aVar) {
        this.f14449a = aVar;
    }

    public static int g(s3.a aVar, int i10, int i11) {
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            if (aVar.j(i10 + i13)) {
                i12 |= 1 << ((i11 - i13) - 1);
            }
        }
        return i12;
    }

    public String a(StringBuilder sb2, int i10) throws NotFoundException, FormatException {
        String str = null;
        while (true) {
            n nVarC = c(i10, str);
            String strA = q.a(nVarC.b());
            if (strA != null) {
                sb2.append(strA);
            }
            String strValueOf = nVarC.d() ? String.valueOf(nVarC.c()) : null;
            if (i10 == nVarC.a()) {
                return sb2.toString();
            }
            i10 = nVarC.a();
            str = strValueOf;
        }
    }

    public final m b(int i10) {
        char c10;
        int iF = f(i10, 5);
        if (iF == 15) {
            return new m(i10 + 5, '$');
        }
        if (iF >= 5 && iF < 15) {
            return new m(i10 + 5, (char) (iF + 43));
        }
        int iF2 = f(i10, 6);
        if (iF2 >= 32 && iF2 < 58) {
            return new m(i10 + 6, (char) (iF2 + 33));
        }
        switch (iF2) {
            case 58:
                c10 = '*';
                break;
            case 59:
                c10 = ',';
                break;
            case 60:
                c10 = '-';
                break;
            case 61:
                c10 = '.';
                break;
            case 62:
                c10 = '/';
                break;
            default:
                throw new IllegalStateException("Decoding invalid alphanumeric value: " + iF2);
        }
        return new m(i10 + 6, c10);
    }

    public n c(int i10, String str) throws FormatException {
        this.f14451c.setLength(0);
        if (str != null) {
            this.f14451c.append(str);
        }
        this.f14450b.h(i10);
        n nVarO = o();
        return (nVarO == null || !nVarO.d()) ? new n(this.f14450b.a(), this.f14451c.toString()) : new n(this.f14450b.a(), this.f14451c.toString(), nVarO.c());
    }

    public final m d(int i10) throws FormatException {
        int iF = f(i10, 5);
        if (iF == 15) {
            return new m(i10 + 5, '$');
        }
        char c10 = '+';
        if (iF >= 5 && iF < 15) {
            return new m(i10 + 5, (char) (iF + 43));
        }
        int iF2 = f(i10, 7);
        if (iF2 >= 64 && iF2 < 90) {
            return new m(i10 + 7, (char) (iF2 + 1));
        }
        if (iF2 >= 90 && iF2 < 116) {
            return new m(i10 + 7, (char) (iF2 + 7));
        }
        switch (f(i10, 8)) {
            case 232:
                c10 = '!';
                break;
            case 233:
                c10 = '\"';
                break;
            case 234:
                c10 = '%';
                break;
            case 235:
                c10 = '&';
                break;
            case 236:
                c10 = '\'';
                break;
            case 237:
                c10 = '(';
                break;
            case 238:
                c10 = ')';
                break;
            case 239:
                c10 = '*';
                break;
            case 240:
                break;
            case 241:
                c10 = ',';
                break;
            case 242:
                c10 = '-';
                break;
            case 243:
                c10 = '.';
                break;
            case 244:
                c10 = '/';
                break;
            case 245:
                c10 = ':';
                break;
            case 246:
                c10 = ';';
                break;
            case 247:
                c10 = '<';
                break;
            case 248:
                c10 = '=';
                break;
            case 249:
                c10 = '>';
                break;
            case 250:
                c10 = '?';
                break;
            case 251:
                c10 = '_';
                break;
            case 252:
                c10 = ' ';
                break;
            default:
                throw FormatException.getFormatInstance();
        }
        return new m(i10 + 8, c10);
    }

    public final o e(int i10) {
        int i11 = i10 + 7;
        if (i11 > this.f14449a.n()) {
            int iF = f(i10, 4);
            return iF == 0 ? new o(this.f14449a.n(), 10, 10) : new o(this.f14449a.n(), iF - 1, 10);
        }
        int iF2 = f(i10, 7) - 8;
        return new o(i11, iF2 / 11, iF2 % 11);
    }

    public int f(int i10, int i11) {
        return g(this.f14449a, i10, i11);
    }

    public final boolean h(int i10) {
        int i11 = i10 + 3;
        if (i11 > this.f14449a.n()) {
            return false;
        }
        while (i10 < i11) {
            if (this.f14449a.j(i10)) {
                return false;
            }
            i10++;
        }
        return true;
    }

    public final boolean i(int i10) {
        int i11;
        if (i10 + 1 > this.f14449a.n()) {
            return false;
        }
        for (int i12 = 0; i12 < 5 && (i11 = i12 + i10) < this.f14449a.n(); i12++) {
            if (i12 == 2) {
                if (!this.f14449a.j(i10 + 2)) {
                    return false;
                }
            } else if (this.f14449a.j(i11)) {
                return false;
            }
        }
        return true;
    }

    public final boolean j(int i10) {
        int i11;
        if (i10 + 1 > this.f14449a.n()) {
            return false;
        }
        for (int i12 = 0; i12 < 4 && (i11 = i12 + i10) < this.f14449a.n(); i12++) {
            if (this.f14449a.j(i11)) {
                return false;
            }
        }
        return true;
    }

    public final boolean k(int i10) {
        int iF;
        if (i10 + 5 > this.f14449a.n()) {
            return false;
        }
        int iF2 = f(i10, 5);
        if (iF2 < 5 || iF2 >= 16) {
            return i10 + 6 <= this.f14449a.n() && (iF = f(i10, 6)) >= 16 && iF < 63;
        }
        return true;
    }

    public final boolean l(int i10) {
        int iF;
        if (i10 + 5 > this.f14449a.n()) {
            return false;
        }
        int iF2 = f(i10, 5);
        if (iF2 >= 5 && iF2 < 16) {
            return true;
        }
        if (i10 + 7 > this.f14449a.n()) {
            return false;
        }
        int iF3 = f(i10, 7);
        if (iF3 < 64 || iF3 >= 116) {
            return i10 + 8 <= this.f14449a.n() && (iF = f(i10, 8)) >= 232 && iF < 253;
        }
        return true;
    }

    public final boolean m(int i10) {
        if (i10 + 7 > this.f14449a.n()) {
            return i10 + 4 <= this.f14449a.n();
        }
        int i11 = i10;
        while (true) {
            int i12 = i10 + 3;
            if (i11 >= i12) {
                return this.f14449a.j(i12);
            }
            if (this.f14449a.j(i11)) {
                return true;
            }
            i11++;
        }
    }

    public final l n() {
        while (k(this.f14450b.a())) {
            m mVarB = b(this.f14450b.a());
            this.f14450b.h(mVarB.a());
            if (mVarB.c()) {
                return new l(new n(this.f14450b.a(), this.f14451c.toString()), true);
            }
            this.f14451c.append(mVarB.b());
        }
        if (h(this.f14450b.a())) {
            this.f14450b.b(3);
            this.f14450b.g();
        } else if (i(this.f14450b.a())) {
            if (this.f14450b.a() + 5 < this.f14449a.n()) {
                this.f14450b.b(5);
            } else {
                this.f14450b.h(this.f14449a.n());
            }
            this.f14450b.f();
        }
        return new l();
    }

    public final n o() throws FormatException {
        l lVarQ;
        boolean zB;
        do {
            int iA = this.f14450b.a();
            if (this.f14450b.c()) {
                lVarQ = n();
                zB = lVarQ.b();
            } else if (this.f14450b.d()) {
                lVarQ = p();
                zB = lVarQ.b();
            } else {
                lVarQ = q();
                zB = lVarQ.b();
            }
            if (iA == this.f14450b.a() && !zB) {
                break;
            }
        } while (!zB);
        return lVarQ.a();
    }

    public final l p() throws FormatException {
        while (l(this.f14450b.a())) {
            m mVarD = d(this.f14450b.a());
            this.f14450b.h(mVarD.a());
            if (mVarD.c()) {
                return new l(new n(this.f14450b.a(), this.f14451c.toString()), true);
            }
            this.f14451c.append(mVarD.b());
        }
        if (h(this.f14450b.a())) {
            this.f14450b.b(3);
            this.f14450b.g();
        } else if (i(this.f14450b.a())) {
            if (this.f14450b.a() + 5 < this.f14449a.n()) {
                this.f14450b.b(5);
            } else {
                this.f14450b.h(this.f14449a.n());
            }
            this.f14450b.e();
        }
        return new l();
    }

    public final l q() {
        while (m(this.f14450b.a())) {
            o oVarE = e(this.f14450b.a());
            this.f14450b.h(oVarE.a());
            if (oVarE.d()) {
                return new l(oVarE.e() ? new n(this.f14450b.a(), this.f14451c.toString()) : new n(this.f14450b.a(), this.f14451c.toString(), oVarE.c()), true);
            }
            this.f14451c.append(oVarE.b());
            if (oVarE.e()) {
                return new l(new n(this.f14450b.a(), this.f14451c.toString()), true);
            }
            this.f14451c.append(oVarE.c());
        }
        if (j(this.f14450b.a())) {
            this.f14450b.e();
            this.f14450b.b(4);
        }
        return new l();
    }
}
