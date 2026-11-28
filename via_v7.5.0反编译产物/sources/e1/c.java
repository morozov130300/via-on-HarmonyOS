package e1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class c extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f4111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b1.c f4113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b1.d f4114d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b1.b f4115e;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b extends o.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public p f4116a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f4117b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public b1.c f4118c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public b1.d f4119d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public b1.b f4120e;

        @Override // e1.o.a
        public o a() {
            String str = "";
            if (this.f4116a == null) {
                str = " transportContext";
            }
            if (this.f4117b == null) {
                str = str + " transportName";
            }
            if (this.f4118c == null) {
                str = str + " event";
            }
            if (this.f4119d == null) {
                str = str + " transformer";
            }
            if (this.f4120e == null) {
                str = str + " encoding";
            }
            if (str.isEmpty()) {
                return new c(this.f4116a, this.f4117b, this.f4118c, this.f4119d, this.f4120e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // e1.o.a
        public o.a b(b1.b bVar) {
            if (bVar == null) {
                throw new NullPointerException("Null encoding");
            }
            this.f4120e = bVar;
            return this;
        }

        @Override // e1.o.a
        public o.a c(b1.c cVar) {
            if (cVar == null) {
                throw new NullPointerException("Null event");
            }
            this.f4118c = cVar;
            return this;
        }

        @Override // e1.o.a
        public o.a d(b1.d dVar) {
            if (dVar == null) {
                throw new NullPointerException("Null transformer");
            }
            this.f4119d = dVar;
            return this;
        }

        @Override // e1.o.a
        public o.a e(p pVar) {
            if (pVar == null) {
                throw new NullPointerException("Null transportContext");
            }
            this.f4116a = pVar;
            return this;
        }

        @Override // e1.o.a
        public o.a f(String str) {
            if (str == null) {
                throw new NullPointerException("Null transportName");
            }
            this.f4117b = str;
            return this;
        }
    }

    @Override // e1.o
    public b1.b b() {
        return this.f4115e;
    }

    @Override // e1.o
    public b1.c c() {
        return this.f4113c;
    }

    @Override // e1.o
    public b1.d e() {
        return this.f4114d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof o) {
            o oVar = (o) obj;
            if (this.f4111a.equals(oVar.f()) && this.f4112b.equals(oVar.g()) && this.f4113c.equals(oVar.c()) && this.f4114d.equals(oVar.e()) && this.f4115e.equals(oVar.b())) {
                return true;
            }
        }
        return false;
    }

    @Override // e1.o
    public p f() {
        return this.f4111a;
    }

    @Override // e1.o
    public String g() {
        return this.f4112b;
    }

    public int hashCode() {
        return ((((((((this.f4111a.hashCode() ^ 1000003) * 1000003) ^ this.f4112b.hashCode()) * 1000003) ^ this.f4113c.hashCode()) * 1000003) ^ this.f4114d.hashCode()) * 1000003) ^ this.f4115e.hashCode();
    }

    public String toString() {
        return "SendRequest{transportContext=" + this.f4111a + ", transportName=" + this.f4112b + ", event=" + this.f4113c + ", transformer=" + this.f4114d + ", encoding=" + this.f4115e + "}";
    }

    public c(p pVar, String str, b1.c cVar, b1.d dVar, b1.b bVar) {
        this.f4111a = pVar;
        this.f4112b = str;
        this.f4113c = cVar;
        this.f4114d = dVar;
        this.f4115e = bVar;
    }
}
