package e1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class o {

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static abstract class a {
        public abstract o a();

        public abstract a b(b1.b bVar);

        public abstract a c(b1.c cVar);

        public abstract a d(b1.d dVar);

        public abstract a e(p pVar);

        public abstract a f(String str);
    }

    public static a a() {
        return new c.b();
    }

    public abstract b1.b b();

    public abstract b1.c c();

    public byte[] d() {
        return (byte[]) e().apply(c().b());
    }

    public abstract b1.d e();

    public abstract p f();

    public abstract String g();
}
