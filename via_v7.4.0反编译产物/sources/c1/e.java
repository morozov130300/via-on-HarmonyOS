package c1;

import c1.i;
import com.google.android.datatransport.cct.internal.ClientInfo;
import com.google.android.datatransport.cct.internal.QosTier;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class e extends i {

    /* renamed from: a, reason: collision with root package name */
    public final long f2257a;

    /* renamed from: b, reason: collision with root package name */
    public final long f2258b;

    /* renamed from: c, reason: collision with root package name */
    public final ClientInfo f2259c;

    /* renamed from: d, reason: collision with root package name */
    public final Integer f2260d;

    /* renamed from: e, reason: collision with root package name */
    public final String f2261e;

    /* renamed from: f, reason: collision with root package name */
    public final List f2262f;

    /* renamed from: g, reason: collision with root package name */
    public final QosTier f2263g;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b extends i.a {

        /* renamed from: a, reason: collision with root package name */
        public Long f2264a;

        /* renamed from: b, reason: collision with root package name */
        public Long f2265b;

        /* renamed from: c, reason: collision with root package name */
        public ClientInfo f2266c;

        /* renamed from: d, reason: collision with root package name */
        public Integer f2267d;

        /* renamed from: e, reason: collision with root package name */
        public String f2268e;

        /* renamed from: f, reason: collision with root package name */
        public List f2269f;

        /* renamed from: g, reason: collision with root package name */
        public QosTier f2270g;

        @Override // c1.i.a
        public i a() {
            String str = "";
            if (this.f2264a == null) {
                str = " requestTimeMs";
            }
            if (this.f2265b == null) {
                str = str + " requestUptimeMs";
            }
            if (str.isEmpty()) {
                return new e(this.f2264a.longValue(), this.f2265b.longValue(), this.f2266c, this.f2267d, this.f2268e, this.f2269f, this.f2270g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // c1.i.a
        public i.a b(ClientInfo clientInfo) {
            this.f2266c = clientInfo;
            return this;
        }

        @Override // c1.i.a
        public i.a c(List list) {
            this.f2269f = list;
            return this;
        }

        @Override // c1.i.a
        public i.a d(Integer num) {
            this.f2267d = num;
            return this;
        }

        @Override // c1.i.a
        public i.a e(String str) {
            this.f2268e = str;
            return this;
        }

        @Override // c1.i.a
        public i.a f(QosTier qosTier) {
            this.f2270g = qosTier;
            return this;
        }

        @Override // c1.i.a
        public i.a g(long j10) {
            this.f2264a = Long.valueOf(j10);
            return this;
        }

        @Override // c1.i.a
        public i.a h(long j10) {
            this.f2265b = Long.valueOf(j10);
            return this;
        }
    }

    public e(long j10, long j11, ClientInfo clientInfo, Integer num, String str, List list, QosTier qosTier) {
        this.f2257a = j10;
        this.f2258b = j11;
        this.f2259c = clientInfo;
        this.f2260d = num;
        this.f2261e = str;
        this.f2262f = list;
        this.f2263g = qosTier;
    }

    @Override // c1.i
    public ClientInfo b() {
        return this.f2259c;
    }

    @Override // c1.i
    public List c() {
        return this.f2262f;
    }

    @Override // c1.i
    public Integer d() {
        return this.f2260d;
    }

    @Override // c1.i
    public String e() {
        return this.f2261e;
    }

    public boolean equals(Object obj) {
        ClientInfo clientInfo;
        Integer num;
        String str;
        List list;
        QosTier qosTier;
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (this.f2257a == iVar.g() && this.f2258b == iVar.h() && ((clientInfo = this.f2259c) != null ? clientInfo.equals(iVar.b()) : iVar.b() == null) && ((num = this.f2260d) != null ? num.equals(iVar.d()) : iVar.d() == null) && ((str = this.f2261e) != null ? str.equals(iVar.e()) : iVar.e() == null) && ((list = this.f2262f) != null ? list.equals(iVar.c()) : iVar.c() == null) && ((qosTier = this.f2263g) != null ? qosTier.equals(iVar.f()) : iVar.f() == null)) {
                return true;
            }
        }
        return false;
    }

    @Override // c1.i
    public QosTier f() {
        return this.f2263g;
    }

    @Override // c1.i
    public long g() {
        return this.f2257a;
    }

    @Override // c1.i
    public long h() {
        return this.f2258b;
    }

    public int hashCode() {
        long j10 = this.f2257a;
        long j11 = this.f2258b;
        int i10 = (((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003;
        ClientInfo clientInfo = this.f2259c;
        int iHashCode = (i10 ^ (clientInfo == null ? 0 : clientInfo.hashCode())) * 1000003;
        Integer num = this.f2260d;
        int iHashCode2 = (iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.f2261e;
        int iHashCode3 = (iHashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List list = this.f2262f;
        int iHashCode4 = (iHashCode3 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        QosTier qosTier = this.f2263g;
        return iHashCode4 ^ (qosTier != null ? qosTier.hashCode() : 0);
    }

    public String toString() {
        return "LogRequest{requestTimeMs=" + this.f2257a + ", requestUptimeMs=" + this.f2258b + ", clientInfo=" + this.f2259c + ", logSource=" + this.f2260d + ", logSourceName=" + this.f2261e + ", logEvents=" + this.f2262f + ", qosTier=" + this.f2263g + "}";
    }
}
