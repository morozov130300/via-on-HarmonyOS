package n2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class z implements j3.b, j3.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final j3.a.InterfaceC0083a f10577c = new j3.a.InterfaceC0083a() { // from class: n2.w
        @Override // j3.a.InterfaceC0083a
        public final void a(j3.b bVar) {
            z.d(bVar);
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final j3.b f10578d = new j3.b() { // from class: n2.x
        @Override // j3.b
        public final Object get() {
            return z.b();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j3.a.InterfaceC0083a f10579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile j3.b f10580b;

    public z(j3.a.InterfaceC0083a interfaceC0083a, j3.b bVar) {
        this.f10579a = interfaceC0083a;
        this.f10580b = bVar;
    }

    public static /* synthetic */ Object b() {
        return null;
    }

    public static /* synthetic */ void c(j3.a.InterfaceC0083a interfaceC0083a, j3.a.InterfaceC0083a interfaceC0083a2, j3.b bVar) {
        interfaceC0083a.a(bVar);
        interfaceC0083a2.a(bVar);
    }

    public static z e() {
        return new z(f10577c, f10578d);
    }

    public static z f(j3.b bVar) {
        return new z(null, bVar);
    }

    @Override // j3.a
    public void a(final j3.a.InterfaceC0083a interfaceC0083a) {
        j3.b bVar;
        j3.b bVar2;
        j3.b bVar3 = this.f10580b;
        j3.b bVar4 = f10578d;
        if (bVar3 != bVar4) {
            interfaceC0083a.a(bVar3);
            return;
        }
        synchronized (this) {
            bVar = this.f10580b;
            if (bVar != bVar4) {
                bVar2 = bVar;
            } else {
                final j3.a.InterfaceC0083a interfaceC0083a2 = this.f10579a;
                this.f10579a = new j3.a.InterfaceC0083a() { // from class: n2.y
                    @Override // j3.a.InterfaceC0083a
                    public final void a(j3.b bVar5) {
                        z.c(interfaceC0083a2, interfaceC0083a, bVar5);
                    }
                };
                bVar2 = null;
            }
        }
        if (bVar2 != null) {
            interfaceC0083a.a(bVar);
        }
    }

    public void g(j3.b bVar) {
        j3.a.InterfaceC0083a interfaceC0083a;
        if (this.f10580b != f10578d) {
            throw new IllegalStateException("provide() can be called only once.");
        }
        synchronized (this) {
            interfaceC0083a = this.f10579a;
            this.f10579a = null;
            this.f10580b = bVar;
        }
        interfaceC0083a.a(bVar);
    }

    @Override // j3.b
    public Object get() {
        return this.f10580b.get();
    }

    public static /* synthetic */ void d(j3.b bVar) {
    }
}
