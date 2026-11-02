package d1;

import d1.i;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class b extends i {

    /* renamed from: a, reason: collision with root package name */
    public final String f4467a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f4468b;

    /* renamed from: c, reason: collision with root package name */
    public final h f4469c;

    /* renamed from: d, reason: collision with root package name */
    public final long f4470d;

    /* renamed from: e, reason: collision with root package name */
    public final long f4471e;

    /* renamed from: f, reason: collision with root package name */
    public final Map f4472f;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: d1.b$b, reason: collision with other inner class name */
    public static final class C0059b extends i.a {

        /* renamed from: a, reason: collision with root package name */
        public String f4473a;

        /* renamed from: b, reason: collision with root package name */
        public Integer f4474b;

        /* renamed from: c, reason: collision with root package name */
        public h f4475c;

        /* renamed from: d, reason: collision with root package name */
        public Long f4476d;

        /* renamed from: e, reason: collision with root package name */
        public Long f4477e;

        /* renamed from: f, reason: collision with root package name */
        public Map f4478f;

        @Override // d1.i.a
        public i d() {
            String str = "";
            if (this.f4473a == null) {
                str = " transportName";
            }
            if (this.f4475c == null) {
                str = str + " encodedPayload";
            }
            if (this.f4476d == null) {
                str = str + " eventMillis";
            }
            if (this.f4477e == null) {
                str = str + " uptimeMillis";
            }
            if (this.f4478f == null) {
                str = str + " autoMetadata";
            }
            if (str.isEmpty()) {
                return new b(this.f4473a, this.f4474b, this.f4475c, this.f4476d.longValue(), this.f4477e.longValue(), this.f4478f);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // d1.i.a
        public Map e() {
            Map map = this.f4478f;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }

        @Override // d1.i.a
        public i.a f(Map map) {
            if (map == null) {
                throw new NullPointerException("Null autoMetadata");
            }
            this.f4478f = map;
            return this;
        }

        @Override // d1.i.a
        public i.a g(Integer num) {
            this.f4474b = num;
            return this;
        }

        @Override // d1.i.a
        public i.a h(h hVar) {
            if (hVar == null) {
                throw new NullPointerException("Null encodedPayload");
            }
            this.f4475c = hVar;
            return this;
        }

        @Override // d1.i.a
        public i.a i(long j10) {
            this.f4476d = Long.valueOf(j10);
            return this;
        }

        @Override // d1.i.a
        public i.a j(String str) {
            if (str == null) {
                throw new NullPointerException("Null transportName");
            }
            this.f4473a = str;
            return this;
        }

        @Override // d1.i.a
        public i.a k(long j10) {
            this.f4477e = Long.valueOf(j10);
            return this;
        }
    }

    public b(String str, Integer num, h hVar, long j10, long j11, Map map) {
        this.f4467a = str;
        this.f4468b = num;
        this.f4469c = hVar;
        this.f4470d = j10;
        this.f4471e = j11;
        this.f4472f = map;
    }

    @Override // d1.i
    public Map c() {
        return this.f4472f;
    }

    @Override // d1.i
    public Integer d() {
        return this.f4468b;
    }

    @Override // d1.i
    public h e() {
        return this.f4469c;
    }

    public boolean equals(Object obj) {
        Integer num;
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (this.f4467a.equals(iVar.j()) && ((num = this.f4468b) != null ? num.equals(iVar.d()) : iVar.d() == null) && this.f4469c.equals(iVar.e()) && this.f4470d == iVar.f() && this.f4471e == iVar.k() && this.f4472f.equals(iVar.c())) {
                return true;
            }
        }
        return false;
    }

    @Override // d1.i
    public long f() {
        return this.f4470d;
    }

    public int hashCode() {
        int iHashCode = (this.f4467a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f4468b;
        int iHashCode2 = (((iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003) ^ this.f4469c.hashCode()) * 1000003;
        long j10 = this.f4470d;
        int i10 = (iHashCode2 ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        long j11 = this.f4471e;
        return ((i10 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ this.f4472f.hashCode();
    }

    @Override // d1.i
    public String j() {
        return this.f4467a;
    }

    @Override // d1.i
    public long k() {
        return this.f4471e;
    }

    public String toString() {
        return "EventInternal{transportName=" + this.f4467a + ", code=" + this.f4468b + ", encodedPayload=" + this.f4469c + ", eventMillis=" + this.f4470d + ", uptimeMillis=" + this.f4471e + ", autoMetadata=" + this.f4472f + "}";
    }
}
