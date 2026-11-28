package okhttp3;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final f[] f11259e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final f[] f11260f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final i f11261g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final i f11262h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final i f11263i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final i f11264j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f11265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f11266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String[] f11267c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String[] f11268d;

    static {
        f fVar = f.f11221n1;
        f fVar2 = f.f11224o1;
        f fVar3 = f.f11227p1;
        f fVar4 = f.f11230q1;
        f fVar5 = f.f11233r1;
        f fVar6 = f.Z0;
        f fVar7 = f.f11191d1;
        f fVar8 = f.f11182a1;
        f fVar9 = f.f11194e1;
        f fVar10 = f.f11212k1;
        f fVar11 = f.f11209j1;
        f[] fVarArr = {fVar, fVar2, fVar3, fVar4, fVar5, fVar6, fVar7, fVar8, fVar9, fVar10, fVar11};
        f11259e = fVarArr;
        f[] fVarArr2 = {fVar, fVar2, fVar3, fVar4, fVar5, fVar6, fVar7, fVar8, fVar9, fVar10, fVar11, f.K0, f.L0, f.f11205i0, f.f11208j0, f.G, f.K, f.f11210k};
        f11260f = fVarArr2;
        a aVarC = new a(true).c(fVarArr);
        TlsVersion tlsVersion = TlsVersion.TLS_1_3;
        TlsVersion tlsVersion2 = TlsVersion.TLS_1_2;
        f11261g = aVarC.f(tlsVersion, tlsVersion2).d(true).a();
        a aVarC2 = new a(true).c(fVarArr2);
        TlsVersion tlsVersion3 = TlsVersion.TLS_1_0;
        f11262h = aVarC2.f(tlsVersion, tlsVersion2, TlsVersion.TLS_1_1, tlsVersion3).d(true).a();
        f11263i = new a(true).c(fVarArr2).f(tlsVersion3).d(true).a();
        f11264j = new a(false).a();
    }

    public i(a aVar) {
        this.f11265a = aVar.f11269a;
        this.f11267c = aVar.f11270b;
        this.f11268d = aVar.f11271c;
        this.f11266b = aVar.f11272d;
    }

    public void a(SSLSocket sSLSocket, boolean z10) {
        i iVarE = e(sSLSocket, z10);
        String[] strArr = iVarE.f11268d;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = iVarE.f11267c;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    public List b() {
        String[] strArr = this.f11267c;
        if (strArr != null) {
            return f.b(strArr);
        }
        return null;
    }

    public boolean c(SSLSocket sSLSocket) {
        if (!this.f11265a) {
            return false;
        }
        String[] strArr = this.f11268d;
        if (strArr != null && !ub.c.B(ub.c.f12961q, strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.f11267c;
        return strArr2 == null || ub.c.B(f.f11183b, strArr2, sSLSocket.getEnabledCipherSuites());
    }

    public boolean d() {
        return this.f11265a;
    }

    public final i e(SSLSocket sSLSocket, boolean z10) {
        String[] strArrZ = this.f11267c != null ? ub.c.z(f.f11183b, sSLSocket.getEnabledCipherSuites(), this.f11267c) : sSLSocket.getEnabledCipherSuites();
        String[] strArrZ2 = this.f11268d != null ? ub.c.z(ub.c.f12961q, sSLSocket.getEnabledProtocols(), this.f11268d) : sSLSocket.getEnabledProtocols();
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int iW = ub.c.w(f.f11183b, supportedCipherSuites, "TLS_FALLBACK_SCSV");
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
        boolean z10 = this.f11265a;
        if (z10 != iVar.f11265a) {
            return false;
        }
        return !z10 || (Arrays.equals(this.f11267c, iVar.f11267c) && Arrays.equals(this.f11268d, iVar.f11268d) && this.f11266b == iVar.f11266b);
    }

    public boolean f() {
        return this.f11266b;
    }

    public List g() {
        String[] strArr = this.f11268d;
        if (strArr != null) {
            return TlsVersion.forJavaNames(strArr);
        }
        return null;
    }

    public int hashCode() {
        if (this.f11265a) {
            return ((((527 + Arrays.hashCode(this.f11267c)) * 31) + Arrays.hashCode(this.f11268d)) * 31) + (!this.f11266b ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.f11265a) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + (this.f11267c != null ? b().toString() : "[all enabled]") + ", tlsVersions=" + (this.f11268d != null ? g().toString() : "[all enabled]") + ", supportsTlsExtensions=" + this.f11266b + ")";
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f11269a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String[] f11270b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String[] f11271c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f11272d;

        public a(boolean z10) {
            this.f11269a = z10;
        }

        public i a() {
            return new i(this);
        }

        public a b(String... strArr) {
            if (!this.f11269a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            this.f11270b = (String[]) strArr.clone();
            return this;
        }

        public a c(f... fVarArr) {
            if (!this.f11269a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[fVarArr.length];
            for (int i10 = 0; i10 < fVarArr.length; i10++) {
                strArr[i10] = fVarArr[i10].f11250a;
            }
            return b(strArr);
        }

        public a d(boolean z10) {
            if (!this.f11269a) {
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            }
            this.f11272d = z10;
            return this;
        }

        public a e(String... strArr) {
            if (!this.f11269a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            this.f11271c = (String[]) strArr.clone();
            return this;
        }

        public a f(TlsVersion... tlsVersionArr) {
            if (!this.f11269a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            String[] strArr = new String[tlsVersionArr.length];
            for (int i10 = 0; i10 < tlsVersionArr.length; i10++) {
                strArr[i10] = tlsVersionArr[i10].javaName;
            }
            return e(strArr);
        }

        public a(i iVar) {
            this.f11269a = iVar.f11265a;
            this.f11270b = iVar.f11267c;
            this.f11271c = iVar.f11268d;
            this.f11272d = iVar.f11266b;
        }
    }
}
