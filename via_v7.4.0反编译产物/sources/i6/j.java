package i6;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: c, reason: collision with root package name */
    public static final a f7007c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    public static final j f7008d = new j(0, 0 == true ? 1 : 0, 2, 0 == true ? 1 : 0);

    /* renamed from: a, reason: collision with root package name */
    public final int f7009a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7010b;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final j a() {
            return j.f7008d;
        }
    }

    public j(int i10, String str) {
        this.f7009a = i10;
        this.f7010b = str;
    }

    public /* synthetic */ j(int i10, String str, int i11, kotlin.jvm.internal.f fVar) {
        this(i10, (i11 & 2) != 0 ? null : str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.f7009a == jVar.f7009a && kotlin.jvm.internal.h.a(this.f7010b, jVar.f7010b);
    }

    public int hashCode() {
        int i10 = this.f7009a * 31;
        String str = this.f7010b;
        return i10 + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "Error(code=" + this.f7009a + ", message=" + this.f7010b + ')';
    }
}
