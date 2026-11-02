package m2;

import i3.a;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class z implements i3.b, i3.a {

    /* renamed from: c, reason: collision with root package name */
    public static final a.InterfaceC0080a f8613c = new a.InterfaceC0080a() { // from class: m2.w
        @Override // i3.a.InterfaceC0080a
        public final void a(i3.b bVar) {
            z.d(bVar);
        }
    };

    /* renamed from: d, reason: collision with root package name */
    public static final i3.b f8614d = new i3.b() { // from class: m2.x
        @Override // i3.b
        public final Object get() {
            return z.b();
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public a.InterfaceC0080a f8615a;

    /* renamed from: b, reason: collision with root package name */
    public volatile i3.b f8616b;

    public z(a.InterfaceC0080a interfaceC0080a, i3.b bVar) {
        this.f8615a = interfaceC0080a;
        this.f8616b = bVar;
    }

    public static /* synthetic */ Object b() {
        return null;
    }

    public static /* synthetic */ void c(a.InterfaceC0080a interfaceC0080a, a.InterfaceC0080a interfaceC0080a2, i3.b bVar) {
        interfaceC0080a.a(bVar);
        interfaceC0080a2.a(bVar);
    }

    public static /* synthetic */ void d(i3.b bVar) {
    }

    public static z e() {
        return new z(f8613c, f8614d);
    }

    public static z f(i3.b bVar) {
        return new z(null, bVar);
    }

    @Override // i3.a
    public void a(final a.InterfaceC0080a interfaceC0080a) {
        i3.b bVar;
        i3.b bVar2;
        i3.b bVar3 = this.f8616b;
        i3.b bVar4 = f8614d;
        if (bVar3 != bVar4) {
            interfaceC0080a.a(bVar3);
            return;
        }
        synchronized (this) {
            bVar = this.f8616b;
            if (bVar != bVar4) {
                bVar2 = bVar;
            } else {
                final a.InterfaceC0080a interfaceC0080a2 = this.f8615a;
                this.f8615a = new a.InterfaceC0080a() { // from class: m2.y
                    @Override // i3.a.InterfaceC0080a
                    public final void a(i3.b bVar5) {
                        z.c(interfaceC0080a2, interfaceC0080a, bVar5);
                    }
                };
                bVar2 = null;
            }
        }
        if (bVar2 != null) {
            interfaceC0080a.a(bVar);
        }
    }

    public void g(i3.b bVar) {
        a.InterfaceC0080a interfaceC0080a;
        if (this.f8616b != f8614d) {
            throw new IllegalStateException("provide() can be called only once.");
        }
        synchronized (this) {
            interfaceC0080a = this.f8615a;
            this.f8615a = null;
            this.f8616b = bVar;
        }
        interfaceC0080a.a(bVar);
    }

    @Override // i3.b
    public Object get() {
        return this.f8616b.get();
    }
}
