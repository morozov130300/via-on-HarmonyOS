package d1;

import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class d extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f3870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f3871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f3872c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f3873d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f3874e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f3875f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final NetworkConnectionInfo f3876g;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b extends h.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f3877a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f3878b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Long f3879c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public byte[] f3880d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f3881e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Long f3882f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public NetworkConnectionInfo f3883g;

        @Override // d1.h.a
        public h a() {
            String str = "";
            if (this.f3877a == null) {
                str = " eventTimeMs";
            }
            if (this.f3879c == null) {
                str = str + " eventUptimeMs";
            }
            if (this.f3882f == null) {
                str = str + " timezoneOffsetSeconds";
            }
            if (str.isEmpty()) {
                return new d(this.f3877a.longValue(), this.f3878b, this.f3879c.longValue(), this.f3880d, this.f3881e, this.f3882f.longValue(), this.f3883g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // d1.h.a
        public h.a b(Integer num) {
            this.f3878b = num;
            return this;
        }

        @Override // d1.h.a
        public h.a c(long j10) {
            this.f3877a = Long.valueOf(j10);
            return this;
        }

        @Override // d1.h.a
        public h.a d(long j10) {
            this.f3879c = Long.valueOf(j10);
            return this;
        }

        @Override // d1.h.a
        public h.a e(NetworkConnectionInfo networkConnectionInfo) {
            this.f3883g = networkConnectionInfo;
            return this;
        }

        @Override // d1.h.a
        public h.a f(byte[] bArr) {
            this.f3880d = bArr;
            return this;
        }

        @Override // d1.h.a
        public h.a g(String str) {
            this.f3881e = str;
            return this;
        }

        @Override // d1.h.a
        public h.a h(long j10) {
            this.f3882f = Long.valueOf(j10);
            return this;
        }
    }

    @Override // d1.h
    public Integer b() {
        return this.f3871b;
    }

    @Override // d1.h
    public long c() {
        return this.f3870a;
    }

    @Override // d1.h
    public long d() {
        return this.f3872c;
    }

    @Override // d1.h
    public NetworkConnectionInfo e() {
        return this.f3876g;
    }

    public boolean equals(Object obj) {
        Integer num;
        String str;
        NetworkConnectionInfo networkConnectionInfo;
        if (obj == this) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (this.f3870a == hVar.c() && ((num = this.f3871b) != null ? num.equals(hVar.b()) : hVar.b() == null) && this.f3872c == hVar.d()) {
                if (Arrays.equals(this.f3873d, hVar instanceof d ? ((d) hVar).f3873d : hVar.f()) && ((str = this.f3874e) != null ? str.equals(hVar.g()) : hVar.g() == null) && this.f3875f == hVar.h() && ((networkConnectionInfo = this.f3876g) != null ? networkConnectionInfo.equals(hVar.e()) : hVar.e() == null)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // d1.h
    public byte[] f() {
        return this.f3873d;
    }

    @Override // d1.h
    public String g() {
        return this.f3874e;
    }

    @Override // d1.h
    public long h() {
        return this.f3875f;
    }

    public int hashCode() {
        long j10 = this.f3870a;
        int i10 = (((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.f3871b;
        int iHashCode = num == null ? 0 : num.hashCode();
        long j11 = this.f3872c;
        int iHashCode2 = (((((i10 ^ iHashCode) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f3873d)) * 1000003;
        String str = this.f3874e;
        int iHashCode3 = str == null ? 0 : str.hashCode();
        long j12 = this.f3875f;
        int i11 = (((iHashCode2 ^ iHashCode3) * 1000003) ^ ((int) ((j12 >>> 32) ^ j12))) * 1000003;
        NetworkConnectionInfo networkConnectionInfo = this.f3876g;
        return i11 ^ (networkConnectionInfo != null ? networkConnectionInfo.hashCode() : 0);
    }

    public String toString() {
        return "LogEvent{eventTimeMs=" + this.f3870a + ", eventCode=" + this.f3871b + ", eventUptimeMs=" + this.f3872c + ", sourceExtension=" + Arrays.toString(this.f3873d) + ", sourceExtensionJsonProto3=" + this.f3874e + ", timezoneOffsetSeconds=" + this.f3875f + ", networkConnectionInfo=" + this.f3876g + "}";
    }

    public d(long j10, Integer num, long j11, byte[] bArr, String str, long j12, NetworkConnectionInfo networkConnectionInfo) {
        this.f3870a = j10;
        this.f3871b = num;
        this.f3872c = j11;
        this.f3873d = bArr;
        this.f3874e = str;
        this.f3875f = j12;
        this.f3876g = networkConnectionInfo;
    }
}
