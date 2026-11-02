package c1;

import c1.h;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;
import java.util.Arrays;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class d extends h {

    /* renamed from: a, reason: collision with root package name */
    public final long f2243a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f2244b;

    /* renamed from: c, reason: collision with root package name */
    public final long f2245c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f2246d;

    /* renamed from: e, reason: collision with root package name */
    public final String f2247e;

    /* renamed from: f, reason: collision with root package name */
    public final long f2248f;

    /* renamed from: g, reason: collision with root package name */
    public final NetworkConnectionInfo f2249g;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b extends h.a {

        /* renamed from: a, reason: collision with root package name */
        public Long f2250a;

        /* renamed from: b, reason: collision with root package name */
        public Integer f2251b;

        /* renamed from: c, reason: collision with root package name */
        public Long f2252c;

        /* renamed from: d, reason: collision with root package name */
        public byte[] f2253d;

        /* renamed from: e, reason: collision with root package name */
        public String f2254e;

        /* renamed from: f, reason: collision with root package name */
        public Long f2255f;

        /* renamed from: g, reason: collision with root package name */
        public NetworkConnectionInfo f2256g;

        @Override // c1.h.a
        public h a() {
            String str = "";
            if (this.f2250a == null) {
                str = " eventTimeMs";
            }
            if (this.f2252c == null) {
                str = str + " eventUptimeMs";
            }
            if (this.f2255f == null) {
                str = str + " timezoneOffsetSeconds";
            }
            if (str.isEmpty()) {
                return new d(this.f2250a.longValue(), this.f2251b, this.f2252c.longValue(), this.f2253d, this.f2254e, this.f2255f.longValue(), this.f2256g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // c1.h.a
        public h.a b(Integer num) {
            this.f2251b = num;
            return this;
        }

        @Override // c1.h.a
        public h.a c(long j10) {
            this.f2250a = Long.valueOf(j10);
            return this;
        }

        @Override // c1.h.a
        public h.a d(long j10) {
            this.f2252c = Long.valueOf(j10);
            return this;
        }

        @Override // c1.h.a
        public h.a e(NetworkConnectionInfo networkConnectionInfo) {
            this.f2256g = networkConnectionInfo;
            return this;
        }

        @Override // c1.h.a
        public h.a f(byte[] bArr) {
            this.f2253d = bArr;
            return this;
        }

        @Override // c1.h.a
        public h.a g(String str) {
            this.f2254e = str;
            return this;
        }

        @Override // c1.h.a
        public h.a h(long j10) {
            this.f2255f = Long.valueOf(j10);
            return this;
        }
    }

    public d(long j10, Integer num, long j11, byte[] bArr, String str, long j12, NetworkConnectionInfo networkConnectionInfo) {
        this.f2243a = j10;
        this.f2244b = num;
        this.f2245c = j11;
        this.f2246d = bArr;
        this.f2247e = str;
        this.f2248f = j12;
        this.f2249g = networkConnectionInfo;
    }

    @Override // c1.h
    public Integer b() {
        return this.f2244b;
    }

    @Override // c1.h
    public long c() {
        return this.f2243a;
    }

    @Override // c1.h
    public long d() {
        return this.f2245c;
    }

    @Override // c1.h
    public NetworkConnectionInfo e() {
        return this.f2249g;
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
            if (this.f2243a == hVar.c() && ((num = this.f2244b) != null ? num.equals(hVar.b()) : hVar.b() == null) && this.f2245c == hVar.d()) {
                if (Arrays.equals(this.f2246d, hVar instanceof d ? ((d) hVar).f2246d : hVar.f()) && ((str = this.f2247e) != null ? str.equals(hVar.g()) : hVar.g() == null) && this.f2248f == hVar.h() && ((networkConnectionInfo = this.f2249g) != null ? networkConnectionInfo.equals(hVar.e()) : hVar.e() == null)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // c1.h
    public byte[] f() {
        return this.f2246d;
    }

    @Override // c1.h
    public String g() {
        return this.f2247e;
    }

    @Override // c1.h
    public long h() {
        return this.f2248f;
    }

    public int hashCode() {
        long j10 = this.f2243a;
        int i10 = (((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.f2244b;
        int iHashCode = num == null ? 0 : num.hashCode();
        long j11 = this.f2245c;
        int iHashCode2 = (((((i10 ^ iHashCode) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f2246d)) * 1000003;
        String str = this.f2247e;
        int iHashCode3 = str == null ? 0 : str.hashCode();
        long j12 = this.f2248f;
        int i11 = (((iHashCode2 ^ iHashCode3) * 1000003) ^ ((int) ((j12 >>> 32) ^ j12))) * 1000003;
        NetworkConnectionInfo networkConnectionInfo = this.f2249g;
        return i11 ^ (networkConnectionInfo != null ? networkConnectionInfo.hashCode() : 0);
    }

    public String toString() {
        return "LogEvent{eventTimeMs=" + this.f2243a + ", eventCode=" + this.f2244b + ", eventUptimeMs=" + this.f2245c + ", sourceExtension=" + Arrays.toString(this.f2246d) + ", sourceExtensionJsonProto3=" + this.f2247e + ", timezoneOffsetSeconds=" + this.f2248f + ", networkConnectionInfo=" + this.f2249g + "}";
    }
}
