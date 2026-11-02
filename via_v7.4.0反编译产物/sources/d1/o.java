package d1;

import d1.c;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class o {

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static abstract class a {
        public abstract o a();

        public abstract a b(a1.b bVar);

        public abstract a c(a1.c cVar);

        public abstract a d(a1.d dVar);

        public abstract a e(p pVar);

        public abstract a f(String str);
    }

    public static a a() {
        return new c.b();
    }

    public abstract a1.b b();

    public abstract a1.c c();

    public byte[] d() {
        return (byte[]) e().apply(c().b());
    }

    public abstract a1.d e();

    public abstract p f();

    public abstract String g();
}
