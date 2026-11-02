package u2;

import u2.b0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class f extends b0.d {

    /* renamed from: a, reason: collision with root package name */
    public final c0 f12625a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12626b;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b extends b0.d.a {

        /* renamed from: a, reason: collision with root package name */
        public c0 f12627a;

        /* renamed from: b, reason: collision with root package name */
        public String f12628b;

        @Override // u2.b0.d.a
        public b0.d a() {
            String str = "";
            if (this.f12627a == null) {
                str = " files";
            }
            if (str.isEmpty()) {
                return new f(this.f12627a, this.f12628b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // u2.b0.d.a
        public b0.d.a b(c0 c0Var) {
            if (c0Var == null) {
                throw new NullPointerException("Null files");
            }
            this.f12627a = c0Var;
            return this;
        }

        @Override // u2.b0.d.a
        public b0.d.a c(String str) {
            this.f12628b = str;
            return this;
        }
    }

    public f(c0 c0Var, String str) {
        this.f12625a = c0Var;
        this.f12626b = str;
    }

    @Override // u2.b0.d
    public c0 b() {
        return this.f12625a;
    }

    @Override // u2.b0.d
    public String c() {
        return this.f12626b;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof b0.d) {
            b0.d dVar = (b0.d) obj;
            if (this.f12625a.equals(dVar.b()) && ((str = this.f12626b) != null ? str.equals(dVar.c()) : dVar.c() == null)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (this.f12625a.hashCode() ^ 1000003) * 1000003;
        String str = this.f12626b;
        return iHashCode ^ (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "FilesPayload{files=" + this.f12625a + ", orgId=" + this.f12626b + "}";
    }
}
