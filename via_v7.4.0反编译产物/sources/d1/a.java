package d1;

import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a implements d3.a {

    /* renamed from: a, reason: collision with root package name */
    public static final d3.a f4445a = new a();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: d1.a$a, reason: collision with other inner class name */
    public static final class C0058a implements c3.d {

        /* renamed from: a, reason: collision with root package name */
        public static final C0058a f4446a = new C0058a();

        /* renamed from: b, reason: collision with root package name */
        public static final c3.c f4447b = c3.c.a("window").b(com.google.firebase.encoders.proto.a.b().c(1).a()).a();

        /* renamed from: c, reason: collision with root package name */
        public static final c3.c f4448c = c3.c.a("logSourceMetrics").b(com.google.firebase.encoders.proto.a.b().c(2).a()).a();

        /* renamed from: d, reason: collision with root package name */
        public static final c3.c f4449d = c3.c.a("globalMetrics").b(com.google.firebase.encoders.proto.a.b().c(3).a()).a();

        /* renamed from: e, reason: collision with root package name */
        public static final c3.c f4450e = c3.c.a("appNamespace").b(com.google.firebase.encoders.proto.a.b().c(4).a()).a();

        @Override // c3.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(g1.a aVar, c3.e eVar) {
            eVar.a(f4447b, aVar.d());
            eVar.a(f4448c, aVar.c());
            eVar.a(f4449d, aVar.b());
            eVar.a(f4450e, aVar.a());
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b implements c3.d {

        /* renamed from: a, reason: collision with root package name */
        public static final b f4451a = new b();

        /* renamed from: b, reason: collision with root package name */
        public static final c3.c f4452b = c3.c.a("storageMetrics").b(com.google.firebase.encoders.proto.a.b().c(1).a()).a();

        @Override // c3.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(g1.b bVar, c3.e eVar) {
            eVar.a(f4452b, bVar.a());
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class c implements c3.d {

        /* renamed from: a, reason: collision with root package name */
        public static final c f4453a = new c();

        /* renamed from: b, reason: collision with root package name */
        public static final c3.c f4454b = c3.c.a("eventsDroppedCount").b(com.google.firebase.encoders.proto.a.b().c(1).a()).a();

        /* renamed from: c, reason: collision with root package name */
        public static final c3.c f4455c = c3.c.a("reason").b(com.google.firebase.encoders.proto.a.b().c(3).a()).a();

        @Override // c3.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(LogEventDropped logEventDropped, c3.e eVar) {
            eVar.b(f4454b, logEventDropped.a());
            eVar.a(f4455c, logEventDropped.b());
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class d implements c3.d {

        /* renamed from: a, reason: collision with root package name */
        public static final d f4456a = new d();

        /* renamed from: b, reason: collision with root package name */
        public static final c3.c f4457b = c3.c.a("logSource").b(com.google.firebase.encoders.proto.a.b().c(1).a()).a();

        /* renamed from: c, reason: collision with root package name */
        public static final c3.c f4458c = c3.c.a("logEventDropped").b(com.google.firebase.encoders.proto.a.b().c(2).a()).a();

        @Override // c3.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(g1.c cVar, c3.e eVar) {
            eVar.a(f4457b, cVar.b());
            eVar.a(f4458c, cVar.a());
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class e implements c3.d {

        /* renamed from: a, reason: collision with root package name */
        public static final e f4459a = new e();

        /* renamed from: b, reason: collision with root package name */
        public static final c3.c f4460b = c3.c.d("clientMetrics");

        @Override // c3.b
        public /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
            n.g.a(obj);
            b(null, (c3.e) obj2);
        }

        public void b(m mVar, c3.e eVar) {
            throw null;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class f implements c3.d {

        /* renamed from: a, reason: collision with root package name */
        public static final f f4461a = new f();

        /* renamed from: b, reason: collision with root package name */
        public static final c3.c f4462b = c3.c.a("currentCacheSizeBytes").b(com.google.firebase.encoders.proto.a.b().c(1).a()).a();

        /* renamed from: c, reason: collision with root package name */
        public static final c3.c f4463c = c3.c.a("maxCacheSizeBytes").b(com.google.firebase.encoders.proto.a.b().c(2).a()).a();

        @Override // c3.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(g1.d dVar, c3.e eVar) {
            eVar.b(f4462b, dVar.a());
            eVar.b(f4463c, dVar.b());
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class g implements c3.d {

        /* renamed from: a, reason: collision with root package name */
        public static final g f4464a = new g();

        /* renamed from: b, reason: collision with root package name */
        public static final c3.c f4465b = c3.c.a("startMs").b(com.google.firebase.encoders.proto.a.b().c(1).a()).a();

        /* renamed from: c, reason: collision with root package name */
        public static final c3.c f4466c = c3.c.a("endMs").b(com.google.firebase.encoders.proto.a.b().c(2).a()).a();

        @Override // c3.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(g1.e eVar, c3.e eVar2) {
            eVar2.b(f4465b, eVar.b());
            eVar2.b(f4466c, eVar.a());
        }
    }

    @Override // d3.a
    public void a(d3.b bVar) {
        bVar.a(m.class, e.f4459a);
        bVar.a(g1.a.class, C0058a.f4446a);
        bVar.a(g1.e.class, g.f4464a);
        bVar.a(g1.c.class, d.f4456a);
        bVar.a(LogEventDropped.class, c.f4453a);
        bVar.a(g1.b.class, b.f4451a);
        bVar.a(g1.d.class, f.f4461a);
    }
}
