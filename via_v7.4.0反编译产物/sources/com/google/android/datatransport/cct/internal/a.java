package com.google.android.datatransport.cct.internal;

import c1.g;
import c1.h;
import c1.i;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a implements d3.a {

    /* renamed from: a, reason: collision with root package name */
    public static final d3.a f3212a = new a();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: com.google.android.datatransport.cct.internal.a$a, reason: collision with other inner class name */
    public static final class C0043a implements c3.d {

        /* renamed from: a, reason: collision with root package name */
        public static final C0043a f3213a = new C0043a();

        /* renamed from: b, reason: collision with root package name */
        public static final c3.c f3214b = c3.c.d("sdkVersion");

        /* renamed from: c, reason: collision with root package name */
        public static final c3.c f3215c = c3.c.d("model");

        /* renamed from: d, reason: collision with root package name */
        public static final c3.c f3216d = c3.c.d("hardware");

        /* renamed from: e, reason: collision with root package name */
        public static final c3.c f3217e = c3.c.d("device");

        /* renamed from: f, reason: collision with root package name */
        public static final c3.c f3218f = c3.c.d("product");

        /* renamed from: g, reason: collision with root package name */
        public static final c3.c f3219g = c3.c.d("osBuild");

        /* renamed from: h, reason: collision with root package name */
        public static final c3.c f3220h = c3.c.d("manufacturer");

        /* renamed from: i, reason: collision with root package name */
        public static final c3.c f3221i = c3.c.d("fingerprint");

        /* renamed from: j, reason: collision with root package name */
        public static final c3.c f3222j = c3.c.d("locale");

        /* renamed from: k, reason: collision with root package name */
        public static final c3.c f3223k = c3.c.d("country");

        /* renamed from: l, reason: collision with root package name */
        public static final c3.c f3224l = c3.c.d("mccMnc");

        /* renamed from: m, reason: collision with root package name */
        public static final c3.c f3225m = c3.c.d("applicationBuild");

        @Override // c3.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(c1.a aVar, c3.e eVar) {
            eVar.a(f3214b, aVar.m());
            eVar.a(f3215c, aVar.j());
            eVar.a(f3216d, aVar.f());
            eVar.a(f3217e, aVar.d());
            eVar.a(f3218f, aVar.l());
            eVar.a(f3219g, aVar.k());
            eVar.a(f3220h, aVar.h());
            eVar.a(f3221i, aVar.e());
            eVar.a(f3222j, aVar.g());
            eVar.a(f3223k, aVar.c());
            eVar.a(f3224l, aVar.i());
            eVar.a(f3225m, aVar.b());
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b implements c3.d {

        /* renamed from: a, reason: collision with root package name */
        public static final b f3226a = new b();

        /* renamed from: b, reason: collision with root package name */
        public static final c3.c f3227b = c3.c.d("logRequest");

        @Override // c3.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(g gVar, c3.e eVar) {
            eVar.a(f3227b, gVar.c());
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class c implements c3.d {

        /* renamed from: a, reason: collision with root package name */
        public static final c f3228a = new c();

        /* renamed from: b, reason: collision with root package name */
        public static final c3.c f3229b = c3.c.d("clientType");

        /* renamed from: c, reason: collision with root package name */
        public static final c3.c f3230c = c3.c.d("androidClientInfo");

        @Override // c3.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ClientInfo clientInfo, c3.e eVar) {
            eVar.a(f3229b, clientInfo.c());
            eVar.a(f3230c, clientInfo.b());
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class d implements c3.d {

        /* renamed from: a, reason: collision with root package name */
        public static final d f3231a = new d();

        /* renamed from: b, reason: collision with root package name */
        public static final c3.c f3232b = c3.c.d("eventTimeMs");

        /* renamed from: c, reason: collision with root package name */
        public static final c3.c f3233c = c3.c.d("eventCode");

        /* renamed from: d, reason: collision with root package name */
        public static final c3.c f3234d = c3.c.d("eventUptimeMs");

        /* renamed from: e, reason: collision with root package name */
        public static final c3.c f3235e = c3.c.d("sourceExtension");

        /* renamed from: f, reason: collision with root package name */
        public static final c3.c f3236f = c3.c.d("sourceExtensionJsonProto3");

        /* renamed from: g, reason: collision with root package name */
        public static final c3.c f3237g = c3.c.d("timezoneOffsetSeconds");

        /* renamed from: h, reason: collision with root package name */
        public static final c3.c f3238h = c3.c.d("networkConnectionInfo");

        @Override // c3.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(h hVar, c3.e eVar) {
            eVar.b(f3232b, hVar.c());
            eVar.a(f3233c, hVar.b());
            eVar.b(f3234d, hVar.d());
            eVar.a(f3235e, hVar.f());
            eVar.a(f3236f, hVar.g());
            eVar.b(f3237g, hVar.h());
            eVar.a(f3238h, hVar.e());
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class e implements c3.d {

        /* renamed from: a, reason: collision with root package name */
        public static final e f3239a = new e();

        /* renamed from: b, reason: collision with root package name */
        public static final c3.c f3240b = c3.c.d("requestTimeMs");

        /* renamed from: c, reason: collision with root package name */
        public static final c3.c f3241c = c3.c.d("requestUptimeMs");

        /* renamed from: d, reason: collision with root package name */
        public static final c3.c f3242d = c3.c.d("clientInfo");

        /* renamed from: e, reason: collision with root package name */
        public static final c3.c f3243e = c3.c.d("logSource");

        /* renamed from: f, reason: collision with root package name */
        public static final c3.c f3244f = c3.c.d("logSourceName");

        /* renamed from: g, reason: collision with root package name */
        public static final c3.c f3245g = c3.c.d("logEvent");

        /* renamed from: h, reason: collision with root package name */
        public static final c3.c f3246h = c3.c.d("qosTier");

        @Override // c3.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(i iVar, c3.e eVar) {
            eVar.b(f3240b, iVar.g());
            eVar.b(f3241c, iVar.h());
            eVar.a(f3242d, iVar.b());
            eVar.a(f3243e, iVar.d());
            eVar.a(f3244f, iVar.e());
            eVar.a(f3245g, iVar.c());
            eVar.a(f3246h, iVar.f());
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class f implements c3.d {

        /* renamed from: a, reason: collision with root package name */
        public static final f f3247a = new f();

        /* renamed from: b, reason: collision with root package name */
        public static final c3.c f3248b = c3.c.d("networkType");

        /* renamed from: c, reason: collision with root package name */
        public static final c3.c f3249c = c3.c.d("mobileSubtype");

        @Override // c3.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(NetworkConnectionInfo networkConnectionInfo, c3.e eVar) {
            eVar.a(f3248b, networkConnectionInfo.c());
            eVar.a(f3249c, networkConnectionInfo.b());
        }
    }

    @Override // d3.a
    public void a(d3.b bVar) {
        b bVar2 = b.f3226a;
        bVar.a(g.class, bVar2);
        bVar.a(c1.c.class, bVar2);
        e eVar = e.f3239a;
        bVar.a(i.class, eVar);
        bVar.a(c1.e.class, eVar);
        c cVar = c.f3228a;
        bVar.a(ClientInfo.class, cVar);
        bVar.a(com.google.android.datatransport.cct.internal.b.class, cVar);
        C0043a c0043a = C0043a.f3213a;
        bVar.a(c1.a.class, c0043a);
        bVar.a(c1.b.class, c0043a);
        d dVar = d.f3231a;
        bVar.a(h.class, dVar);
        bVar.a(c1.d.class, dVar);
        f fVar = f.f3247a;
        bVar.a(NetworkConnectionInfo.class, fVar);
        bVar.a(com.google.android.datatransport.cct.internal.c.class, fVar);
    }
}
