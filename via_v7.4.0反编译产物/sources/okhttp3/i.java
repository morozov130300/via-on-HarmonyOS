package okhttp3;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: e, reason: collision with root package name */
    public static final f[] f10644e;

    /* renamed from: f, reason: collision with root package name */
    public static final f[] f10645f;

    /* renamed from: g, reason: collision with root package name */
    public static final i f10646g;

    /* renamed from: h, reason: collision with root package name */
    public static final i f10647h;

    /* renamed from: i, reason: collision with root package name */
    public static final i f10648i;

    /* renamed from: j, reason: collision with root package name */
    public static final i f10649j;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f10650a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f10651b;

    /* renamed from: c, reason: collision with root package name */
    public final String[] f10652c;

    /* renamed from: d, reason: collision with root package name */
    public final String[] f10653d;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f10654a;

        /* renamed from: b, reason: collision with root package name */
        public String[] f10655b;

        /* renamed from: c, reason: collision with root package name */
        public String[] f10656c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f10657d;

        public a(i iVar) {
            this.f10654a = iVar.f10650a;
            this.f10655b = iVar.f10652c;
            this.f10656c = iVar.f10653d;
            this.f10657d = iVar.f10651b;
        }

        public a(boolean z10) {
            this.f10654a = z10;
        }

        public i a() {
            return new i(this);
        }

        public a b(String... strArr) {
            if (!this.f10654a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            this.f10655b = (String[]) strArr.clone();
            return this;
        }

        public a c(f... fVarArr) {
            if (!this.f10654a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[fVarArr.length];
            for (int i10 = 0; i10 < fVarArr.length; i10++) {
                strArr[i10] = fVarArr[i10].f10635a;
            }
            return b(strArr);
        }

        public a d(boolean z10) {
            if (!this.f10654a) {
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            }
            this.f10657d = z10;
            return this;
        }

        public a e(String... strArr) {
            if (!this.f10654a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            this.f10656c = (String[]) strArr.clone();
            return this;
        }

        public a f(TlsVersion... tlsVersionArr) {
            if (!this.f10654a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            String[] strArr = new String[tlsVersionArr.length];
            for (int i10 = 0; i10 < tlsVersionArr.length; i10++) {
                strArr[i10] = tlsVersionArr[i10].javaName;
            }
            return e(strArr);
        }
    }

    static {
        f fVar = f.f10606n1;
        f fVar2 = f.f10609o1;
        f fVar3 = f.f10612p1;
        f fVar4 = f.f10615q1;
        f fVar5 = f.f10618r1;
        f fVar6 = f.Z0;
        f fVar7 = f.f10576d1;
        f fVar8 = f.f10567a1;
        f fVar9 = f.f10579e1;
        f fVar10 = f.f10597k1;
        f fVar11 = f.f10594j1;
        f[] fVarArr = {fVar, fVar2, fVar3, fVar4, fVar5, fVar6, fVar7, fVar8, fVar9, fVar10, fVar11};
        f10644e = fVarArr;
        f[] fVarArr2 = {fVar, fVar2, fVar3, fVar4, fVar5, fVar6, fVar7, fVar8, fVar9, fVar10, fVar11, f.K0, f.L0, f.f10590i0, f.f10593j0, f.G, f.K, f.f10595k};
        f10645f = fVarArr2;
        a aVarC = new a(true).c(fVarArr);
        TlsVersion tlsVersion = TlsVersion.TLS_1_3;
        TlsVersion tlsVersion2 = TlsVersion.TLS_1_2;
        f10646g = aVarC.f(tlsVersion, tlsVersion2).d(true).a();
        a aVarC2 = new a(true).c(fVarArr2);
        TlsVersion tlsVersion3 = TlsVersion.TLS_1_0;
        f10647h = aVarC2.f(tlsVersion, tlsVersion2, TlsVersion.TLS_1_1, tlsVersion3).d(true).a();
        f10648i = new a(true).c(fVarArr2).f(tlsVersion3).d(true).a();
        f10649j = new a(false).a();
    }

    public i(a aVar) {
        this.f10650a = aVar.f10654a;
        this.f10652c = aVar.f10655b;
        this.f10653d = aVar.f10656c;
        this.f10651b = aVar.f10657d;
    }

    public void a(SSLSocket sSLSocket, boolean z10) {
        i iVarE = e(sSLSocket, z10);
        String[] strArr = iVarE.f10653d;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = iVarE.f10652c;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    public List b() {
        String[] strArr = this.f10652c;
        if (strArr != null) {
            return f.b(strArr);
        }
        return null;
    }

    public boolean c(SSLSocket sSLSocket) {
        if (!this.f10650a) {
            return false;
        }
        String[] strArr = this.f10653d;
        if (strArr != null && !ub.c.B(ub.c.f12951q, strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.f10652c;
        return strArr2 == null || ub.c.B(f.f10568b, strArr2, sSLSocket.getEnabledCipherSuites());
    }

    public boolean d() {
        return this.f10650a;
    }

    public final i e(SSLSocket sSLSocket, boolean z10) {
        String[] strArrZ = this.f10652c != null ? ub.c.z(f.f10568b, sSLSocket.getEnabledCipherSuites(), this.f10652c) : sSLSocket.getEnabledCipherSuites();
        String[] strArrZ2 = this.f10653d != null ? ub.c.z(ub.c.f12951q, sSLSocket.getEnabledProtocols(), this.f10653d) : sSLSocket.getEnabledProtocols();
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int iW = ub.c.w(f.f10568b, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z10 && iW != -1) {
            strArrZ = ub.c.i(strArrZ, supportedCipherSuites[iW]);
        }
        return new a(this).b(strArrZ).e(strArrZ2).a();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof i)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        i iVar = (i) obj;
        boolean z10 = this.f10650a;
        if (z10 != iVar.f10650a) {
            return false;
        }
        return !z10 || (Arrays.equals(this.f10652c, iVar.f10652c) && Arrays.equals(this.f10653d, iVar.f10653d) && this.f10651b == iVar.f10651b);
    }

    public boolean f() {
        return this.f10651b;
    }

    public List g() {
        String[] strArr = this.f10653d;
        if (strArr != null) {
            return TlsVersion.forJavaNames(strArr);
        }
        return null;
    }

    public int hashCode() {
        if (this.f10650a) {
            return ((((527 + Arrays.hashCode(this.f10652c)) * 31) + Arrays.hashCode(this.f10653d)) * 31) + (!this.f10651b ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.f10650a) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + (this.f10652c != null ? b().toString() : "[all enabled]") + ", tlsVersions=" + (this.f10653d != null ? g().toString() : "[all enabled]") + ", supportsTlsExtensions=" + this.f10651b + ")";
    }
}
