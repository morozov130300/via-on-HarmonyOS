package u2;

import u2.b0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class u extends b0.e.d.AbstractC0142d {

    /* renamed from: a, reason: collision with root package name */
    public final String f12767a;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b extends b0.e.d.AbstractC0142d.a {

        /* renamed from: a, reason: collision with root package name */
        public String f12768a;

        @Override // u2.b0.e.d.AbstractC0142d.a
        public b0.e.d.AbstractC0142d a() {
            String str = "";
            if (this.f12768a == null) {
                str = " content";
            }
            if (str.isEmpty()) {
                return new u(this.f12768a);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // u2.b0.e.d.AbstractC0142d.a
        public b0.e.d.AbstractC0142d.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null content");
            }
            this.f12768a = str;
            return this;
        }
    }

    public u(String str) {
        this.f12767a = str;
    }

    @Override // u2.b0.e.d.AbstractC0142d
    public String b() {
        return this.f12767a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b0.e.d.AbstractC0142d) {
            return this.f12767a.equals(((b0.e.d.AbstractC0142d) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.f12767a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Log{content=" + this.f12767a + "}";
    }
}
