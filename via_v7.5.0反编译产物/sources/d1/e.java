package d1;

import com.google.android.datatransport.cct.internal.ClientInfo;
import com.google.android.datatransport.cct.internal.QosTier;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class e extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f3884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f3885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ClientInfo f3886c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f3887d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f3888e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f3889f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final QosTier f3890g;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b extends i.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f3891a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f3892b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ClientInfo f3893c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Integer f3894d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f3895e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List f3896f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public QosTier f3897g;

        @Override // d1.i.a
        public i a() {
            String str = "";
            if (this.f3891a == null) {
                str = " requestTimeMs";
            }
            if (this.f3892b == null) {
                str = str + " requestUptimeMs";
            }
            if (str.isEmpty()) {
                return new e(this.f3891a.longValue(), this.f3892b.longValue(), this.f3893c, this.f3894d, this.f3895e, this.f3896f, this.f3897g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // d1.i.a
        public i.a b(ClientInfo clientInfo) {
            this.f3893c = clientInfo;
            return this;
        }

        @Override // d1.i.a
        public i.a c(List list) {
            this.f3896f = list;
            return this;
        }

        @Override // d1.i.a
        public i.a d(Integer num) {
            this.f3894d = num;
            return this;
        }

        @Override // d1.i.a
        public i.a e(String str) {
            this.f3895e = str;
            return this;
        }

        @Override // d1.i.a
        public i.a f(QosTier qosTier) {
            this.f3897g = qosTier;
            return this;
        }

        @Override // d1.i.a
        public i.a g(long j10) {
            this.f3891a = Long.valueOf(j10);
            return this;
        }

        @Override // d1.i.a
        public i.a h(long j10) {
            this.f3892b = Long.valueOf(j10);
            return this;
        }
    }

    @Override // d1.i
    public ClientInfo b() {
        return this.f3886c;
    }

    @Override // d1.i
    public List c() {
        return this.f3889f;
    }

    @Override // d1.i
    public Integer d() {
        return this.f3887d;
    }

    @Override // d1.i
    public String e() {
        return this.f3888e;
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
            if (this.f3884a == iVar.g() && this.f3885b == iVar.h() && ((clientInfo = this.f3886c) != null ? clientInfo.equals(iVar.b()) : iVar.b() == null) && ((num = this.f3887d) != null ? num.equals(iVar.d()) : iVar.d() == null) && ((str = this.f3888e) != null ? str.equals(iVar.e()) : iVar.e() == null) && ((list = this.f3889f) != null ? list.equals(iVar.c()) : iVar.c() == null) && ((qosTier = this.f3890g) != null ? qosTier.equals(iVar.f()) : iVar.f() == null)) {
                return true;
            }
        }
        return false;
    }

    @Override // d1.i
    public QosTier f() {
        return this.f3890g;
    }

    @Override // d1.i
    public long g() {
        return this.f3884a;
    }

    @Override // d1.i
    public long h() {
        return this.f3885b;
    }

    public int hashCode() {
        long j10 = this.f3884a;
        long j11 = this.f3885b;
        int i10 = (((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003;
        ClientInfo clientInfo = this.f3886c;
        int iHashCode = (i10 ^ (clientInfo == null ? 0 : clientInfo.hashCode())) * 1000003;
        Integer num = this.f3887d;
        int iHashCode2 = (iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.f3888e;
        int iHashCode3 = (iHashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List list = this.f3889f;
        int iHashCode4 = (iHashCode3 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        QosTier qosTier = this.f3890g;
        return iHashCode4 ^ (qosTier != null ? qosTier.hashCode() : 0);
    }

    public String toString() {
        return "LogRequest{requestTimeMs=" + this.f3884a + ", requestUptimeMs=" + this.f3885b + ", clientInfo=" + this.f3886c + ", logSource=" + this.f3887d + ", logSourceName=" + this.f3888e + ", logEvents=" + this.f3889f + ", qosTier=" + this.f3890g + "}";
    }

    public e(long j10, long j11, ClientInfo clientInfo, Integer num, String str, List list, QosTier qosTier) {
        this.f3884a = j10;
        this.f3885b = j11;
        this.f3886c = clientInfo;
        this.f3887d = num;
        this.f3888e = str;
        this.f3889f = list;
        this.f3890g = qosTier;
    }
}
