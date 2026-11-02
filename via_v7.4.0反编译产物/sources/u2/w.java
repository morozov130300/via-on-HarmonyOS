package u2;

import u2.b0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class w extends b0.e.f {

    /* renamed from: a, reason: collision with root package name */
    public final String f12777a;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b extends b0.e.f.a {

        /* renamed from: a, reason: collision with root package name */
        public String f12778a;

        @Override // u2.b0.e.f.a
        public b0.e.f a() {
            String str = "";
            if (this.f12778a == null) {
                str = " identifier";
            }
            if (str.isEmpty()) {
                return new w(this.f12778a);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // u2.b0.e.f.a
        public b0.e.f.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null identifier");
            }
            this.f12778a = str;
            return this;
        }
    }

    public w(String str) {
        this.f12777a = str;
    }

    @Override // u2.b0.e.f
    public String b() {
        return this.f12777a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b0.e.f) {
            return this.f12777a.equals(((b0.e.f) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.f12777a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "User{identifier=" + this.f12777a + "}";
    }
}
