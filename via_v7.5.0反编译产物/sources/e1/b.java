package e1;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class b extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f4100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f4101c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f4102d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f4103e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map f4104f;

    /* JADX INFO: renamed from: e1.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class C0060b extends i.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f4105a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f4106b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public h f4107c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f4108d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Long f4109e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Map f4110f;

        @Override // e1.i.a
        public i d() {
            String str = "";
            if (this.f4105a == null) {
                str = " transportName";
            }
            if (this.f4107c == null) {
                str = str + " encodedPayload";
            }
            if (this.f4108d == null) {
                str = str + " eventMillis";
            }
            if (this.f4109e == null) {
                str = str + " uptimeMillis";
            }
            if (this.f4110f == null) {
                str = str + " autoMetadata";
            }
            if (str.isEmpty()) {
                return new b(this.f4105a, this.f4106b, this.f4107c, this.f4108d.longValue(), this.f4109e.longValue(), this.f4110f);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // e1.i.a
        public Map e() {
            Map map = this.f4110f;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }

        @Override // e1.i.a
        public i.a f(Map map) {
            if (map == null) {
                throw new NullPointerException("Null autoMetadata");
            }
            this.f4110f = map;
            return this;
        }

        @Override // e1.i.a
        public i.a g(Integer num) {
            this.f4106b = num;
            return this;
        }

        @Override // e1.i.a
        public i.a h(h hVar) {
            if (hVar == null) {
                throw new NullPointerException("Null encodedPayload");
            }
            this.f4107c = hVar;
            return this;
        }

        @Override // e1.i.a
        public i.a i(long j10) {
            this.f4108d = Long.valueOf(j10);
            return this;
        }

        @Override // e1.i.a
        public i.a j(String str) {
            if (str == null) {
                throw new NullPointerException("Null transportName");
            }
            this.f4105a = str;
            return this;
        }

        @Override // e1.i.a
        public i.a k(long j10) {
            this.f4109e = Long.valueOf(j10);
            return this;
        }
    }

    @Override // e1.i
    public Map c() {
        return this.f4104f;
    }

    @Override // e1.i
    public Integer d() {
        return this.f4100b;
    }

    @Override // e1.i
    public h e() {
        return this.f4101c;
    }

    public boolean equals(Object obj) {
        Integer num;
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (this.f4099a.equals(iVar.j()) && ((num = this.f4100b) != null ? num.equals(iVar.d()) : iVar.d() == null) && this.f4101c.equals(iVar.e()) && this.f4102d == iVar.f() && this.f4103e == iVar.k() && this.f4104f.equals(iVar.c())) {
                return true;
            }
        }
        return false;
    }

    @Override // e1.i
    public long f() {
        return this.f4102d;
    }

    public int hashCode() {
        int iHashCode = (this.f4099a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f4100b;
        int iHashCode2 = (((iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003) ^ this.f4101c.hashCode()) * 1000003;
        long j10 = this.f4102d;
        int i10 = (iHashCode2 ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        long j11 = this.f4103e;
        return ((i10 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ this.f4104f.hashCode();
    }

    @Override // e1.i
    public String j() {
        return this.f4099a;
    }

    @Override // e1.i
    public long k() {
        return this.f4103e;
    }

    public String toString() {
        return "EventInternal{transportName=" + this.f4099a + ", code=" + this.f4100b + ", encodedPayload=" + this.f4101c + ", eventMillis=" + this.f4102d + ", uptimeMillis=" + this.f4103e + ", autoMetadata=" + this.f4104f + "}";
    }

    public b(String str, Integer num, h hVar, long j10, long j11, Map map) {
        this.f4099a = str;
        this.f4100b = num;
        this.f4101c = hVar;
        this.f4102d = j10;
        this.f4103e = j11;
        this.f4104f = map;
    }
}
