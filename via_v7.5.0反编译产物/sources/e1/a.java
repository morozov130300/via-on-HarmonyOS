package e1;

import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a implements e3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e3.a f4077a = new a();

    /* JADX INFO: renamed from: e1.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class C0059a implements d3.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0059a f4078a = new C0059a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d3.c f4079b = d3.c.a("window").b(com.google.firebase.encoders.proto.a.b().c(1).a()).a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final d3.c f4080c = d3.c.a("logSourceMetrics").b(com.google.firebase.encoders.proto.a.b().c(2).a()).a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final d3.c f4081d = d3.c.a("globalMetrics").b(com.google.firebase.encoders.proto.a.b().c(3).a()).a();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final d3.c f4082e = d3.c.a("appNamespace").b(com.google.firebase.encoders.proto.a.b().c(4).a()).a();

        @Override // d3.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(h1.a aVar, d3.e eVar) {
            eVar.d(f4079b, aVar.d());
            eVar.d(f4080c, aVar.c());
            eVar.d(f4081d, aVar.b());
            eVar.d(f4082e, aVar.a());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b implements d3.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f4083a = new b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d3.c f4084b = d3.c.a("storageMetrics").b(com.google.firebase.encoders.proto.a.b().c(1).a()).a();

        @Override // d3.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(h1.b bVar, d3.e eVar) {
            eVar.d(f4084b, bVar.a());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class c implements d3.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f4085a = new c();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d3.c f4086b = d3.c.a("eventsDroppedCount").b(com.google.firebase.encoders.proto.a.b().c(1).a()).a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final d3.c f4087c = d3.c.a("reason").b(com.google.firebase.encoders.proto.a.b().c(3).a()).a();

        @Override // d3.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(LogEventDropped logEventDropped, d3.e eVar) {
            eVar.b(f4086b, logEventDropped.a());
            eVar.d(f4087c, logEventDropped.b());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class d implements d3.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f4088a = new d();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d3.c f4089b = d3.c.a("logSource").b(com.google.firebase.encoders.proto.a.b().c(1).a()).a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final d3.c f4090c = d3.c.a("logEventDropped").b(com.google.firebase.encoders.proto.a.b().c(2).a()).a();

        @Override // d3.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(h1.c cVar, d3.e eVar) {
            eVar.d(f4089b, cVar.b());
            eVar.d(f4090c, cVar.a());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class e implements d3.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f4091a = new e();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d3.c f4092b = d3.c.d("clientMetrics");

        @Override // d3.b
        public /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
            n.g.a(obj);
            b(null, (d3.e) obj2);
        }

        public void b(m mVar, d3.e eVar) {
            throw null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class f implements d3.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f4093a = new f();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d3.c f4094b = d3.c.a("currentCacheSizeBytes").b(com.google.firebase.encoders.proto.a.b().c(1).a()).a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final d3.c f4095c = d3.c.a("maxCacheSizeBytes").b(com.google.firebase.encoders.proto.a.b().c(2).a()).a();

        @Override // d3.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(h1.d dVar, d3.e eVar) {
            eVar.b(f4094b, dVar.a());
            eVar.b(f4095c, dVar.b());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class g implements d3.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f4096a = new g();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d3.c f4097b = d3.c.a("startMs").b(com.google.firebase.encoders.proto.a.b().c(1).a()).a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final d3.c f4098c = d3.c.a("endMs").b(com.google.firebase.encoders.proto.a.b().c(2).a()).a();

        @Override // d3.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(h1.e eVar, d3.e eVar2) {
            eVar2.b(f4097b, eVar.b());
            eVar2.b(f4098c, eVar.a());
        }
    }

    @Override // e3.a
    public void a(e3.b bVar) {
        bVar.a(m.class, e.f4091a);
        bVar.a(h1.a.class, C0059a.f4078a);
        bVar.a(h1.e.class, g.f4096a);
        bVar.a(h1.c.class, d.f4088a);
        bVar.a(LogEventDropped.class, c.f4085a);
        bVar.a(h1.b.class, b.f4083a);
        bVar.a(h1.d.class, f.f4093a);
    }
}
