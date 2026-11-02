package h2;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final String f6345a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6346b;

    /* renamed from: c, reason: collision with root package name */
    public final String f6347c;

    /* renamed from: d, reason: collision with root package name */
    public final String f6348d;

    /* renamed from: e, reason: collision with root package name */
    public final String f6349e;

    /* renamed from: f, reason: collision with root package name */
    public final String f6350f;

    /* renamed from: g, reason: collision with root package name */
    public final String f6351g;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public String f6352a;

        /* renamed from: b, reason: collision with root package name */
        public String f6353b;

        /* renamed from: c, reason: collision with root package name */
        public String f6354c;

        /* renamed from: d, reason: collision with root package name */
        public String f6355d;

        /* renamed from: e, reason: collision with root package name */
        public String f6356e;

        /* renamed from: f, reason: collision with root package name */
        public String f6357f;

        /* renamed from: g, reason: collision with root package name */
        public String f6358g;

        public k a() {
            return new k(this.f6353b, this.f6352a, this.f6354c, this.f6355d, this.f6356e, this.f6357f, this.f6358g);
        }

        public b b(String str) {
            this.f6352a = t1.f.e(str, "ApiKey must be set.");
            return this;
        }

        public b c(String str) {
            this.f6353b = t1.f.e(str, "ApplicationId must be set.");
            return this;
        }

        public b d(String str) {
            this.f6356e = str;
            return this;
        }

        public b e(String str) {
            this.f6358g = str;
            return this;
        }

        public b f(String str) {
            this.f6357f = str;
            return this;
        }
    }

    public k(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        t1.f.l(!w1.l.a(str), "ApplicationId must be set.");
        this.f6346b = str;
        this.f6345a = str2;
        this.f6347c = str3;
        this.f6348d = str4;
        this.f6349e = str5;
        this.f6350f = str6;
        this.f6351g = str7;
    }

    public static k a(Context context) {
        t1.h hVar = new t1.h(context);
        String strA = hVar.a("google_app_id");
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        return new k(strA, hVar.a("google_api_key"), hVar.a("firebase_database_url"), hVar.a("ga_trackingId"), hVar.a("gcm_defaultSenderId"), hVar.a("google_storage_bucket"), hVar.a("project_id"));
    }

    public String b() {
        return this.f6345a;
    }

    public String c() {
        return this.f6346b;
    }

    public String d() {
        return this.f6349e;
    }

    public String e() {
        return this.f6351g;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return t1.e.a(this.f6346b, kVar.f6346b) && t1.e.a(this.f6345a, kVar.f6345a) && t1.e.a(this.f6347c, kVar.f6347c) && t1.e.a(this.f6348d, kVar.f6348d) && t1.e.a(this.f6349e, kVar.f6349e) && t1.e.a(this.f6350f, kVar.f6350f) && t1.e.a(this.f6351g, kVar.f6351g);
    }

    public int hashCode() {
        return t1.e.b(this.f6346b, this.f6345a, this.f6347c, this.f6348d, this.f6349e, this.f6350f, this.f6351g);
    }

    public String toString() {
        return t1.e.c(this).a("applicationId", this.f6346b).a("apiKey", this.f6345a).a("databaseUrl", this.f6347c).a("gcmSenderId", this.f6349e).a("storageBucket", this.f6350f).a("projectId", this.f6351g).toString();
    }
}
