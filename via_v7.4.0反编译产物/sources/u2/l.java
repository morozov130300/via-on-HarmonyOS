package u2;

import u2.b0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class l extends b0.e.d {

    /* renamed from: a, reason: collision with root package name */
    public final long f12685a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12686b;

    /* renamed from: c, reason: collision with root package name */
    public final b0.e.d.a f12687c;

    /* renamed from: d, reason: collision with root package name */
    public final b0.e.d.c f12688d;

    /* renamed from: e, reason: collision with root package name */
    public final b0.e.d.AbstractC0142d f12689e;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b extends b0.e.d.b {

        /* renamed from: a, reason: collision with root package name */
        public Long f12690a;

        /* renamed from: b, reason: collision with root package name */
        public String f12691b;

        /* renamed from: c, reason: collision with root package name */
        public b0.e.d.a f12692c;

        /* renamed from: d, reason: collision with root package name */
        public b0.e.d.c f12693d;

        /* renamed from: e, reason: collision with root package name */
        public b0.e.d.AbstractC0142d f12694e;

        public b() {
        }

        public b(b0.e.d dVar) {
            this.f12690a = Long.valueOf(dVar.e());
            this.f12691b = dVar.f();
            this.f12692c = dVar.b();
            this.f12693d = dVar.c();
            this.f12694e = dVar.d();
        }

        @Override // u2.b0.e.d.b
        public b0.e.d a() {
            String str = "";
            if (this.f12690a == null) {
                str = " timestamp";
            }
            if (this.f12691b == null) {
                str = str + " type";
            }
            if (this.f12692c == null) {
                str = str + " app";
            }
            if (this.f12693d == null) {
                str = str + " device";
            }
            if (str.isEmpty()) {
                return new l(this.f12690a.longValue(), this.f12691b, this.f12692c, this.f12693d, this.f12694e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // u2.b0.e.d.b
        public b0.e.d.b b(b0.e.d.a aVar) {
            if (aVar == null) {
                throw new NullPointerException("Null app");
            }
            this.f12692c = aVar;
            return this;
        }

        @Override // u2.b0.e.d.b
        public b0.e.d.b c(b0.e.d.c cVar) {
            if (cVar == null) {
                throw new NullPointerException("Null device");
            }
            this.f12693d = cVar;
            return this;
        }

        @Override // u2.b0.e.d.b
        public b0.e.d.b d(b0.e.d.AbstractC0142d abstractC0142d) {
            this.f12694e = abstractC0142d;
            return this;
        }

        @Override // u2.b0.e.d.b
        public b0.e.d.b e(long j10) {
            this.f12690a = Long.valueOf(j10);
            return this;
        }

        @Override // u2.b0.e.d.b
        public b0.e.d.b f(String str) {
            if (str == null) {
                throw new NullPointerException("Null type");
            }
            this.f12691b = str;
            return this;
        }
    }

    public l(long j10, String str, b0.e.d.a aVar, b0.e.d.c cVar, b0.e.d.AbstractC0142d abstractC0142d) {
        this.f12685a = j10;
        this.f12686b = str;
        this.f12687c = aVar;
        this.f12688d = cVar;
        this.f12689e = abstractC0142d;
    }

    @Override // u2.b0.e.d
    public b0.e.d.a b() {
        return this.f12687c;
    }

    @Override // u2.b0.e.d
    public b0.e.d.c c() {
        return this.f12688d;
    }

    @Override // u2.b0.e.d
    public b0.e.d.AbstractC0142d d() {
        return this.f12689e;
    }

    @Override // u2.b0.e.d
    public long e() {
        return this.f12685a;
    }

    public boolean equals(Object obj) {
        b0.e.d.AbstractC0142d abstractC0142d;
        if (obj == this) {
            return true;
        }
        if (obj instanceof b0.e.d) {
            b0.e.d dVar = (b0.e.d) obj;
            if (this.f12685a == dVar.e() && this.f12686b.equals(dVar.f()) && this.f12687c.equals(dVar.b()) && this.f12688d.equals(dVar.c()) && ((abstractC0142d = this.f12689e) != null ? abstractC0142d.equals(dVar.d()) : dVar.d() == null)) {
                return true;
            }
        }
        return false;
    }

    @Override // u2.b0.e.d
    public String f() {
        return this.f12686b;
    }

    @Override // u2.b0.e.d
    public b0.e.d.b g() {
        return new b(this);
    }

    public int hashCode() {
        long j10 = this.f12685a;
        int iHashCode = (((((((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ this.f12686b.hashCode()) * 1000003) ^ this.f12687c.hashCode()) * 1000003) ^ this.f12688d.hashCode()) * 1000003;
        b0.e.d.AbstractC0142d abstractC0142d = this.f12689e;
        return (abstractC0142d == null ? 0 : abstractC0142d.hashCode()) ^ iHashCode;
    }

    public String toString() {
        return "Event{timestamp=" + this.f12685a + ", type=" + this.f12686b + ", app=" + this.f12687c + ", device=" + this.f12688d + ", log=" + this.f12689e + "}";
    }
}
