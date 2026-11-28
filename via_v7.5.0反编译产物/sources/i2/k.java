package i2;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f6216c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f6217d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f6218e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f6219f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f6220g;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f6221a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f6222b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f6223c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f6224d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f6225e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f6226f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f6227g;

        public k a() {
            return new k(this.f6222b, this.f6221a, this.f6223c, this.f6224d, this.f6225e, this.f6226f, this.f6227g);
        }

        public b b(String str) {
            this.f6221a = u1.f.e(str, "ApiKey must be set.");
            return this;
        }

        public b c(String str) {
            this.f6222b = u1.f.e(str, "ApplicationId must be set.");
            return this;
        }

        public b d(String str) {
            this.f6225e = str;
            return this;
        }

        public b e(String str) {
            this.f6227g = str;
            return this;
        }

        public b f(String str) {
            this.f6226f = str;
            return this;
        }
    }

    public static k a(Context context) {
        u1.h hVar = new u1.h(context);
        String strA = hVar.a("google_app_id");
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        return new k(strA, hVar.a("google_api_key"), hVar.a("firebase_database_url"), hVar.a("ga_trackingId"), hVar.a("gcm_defaultSenderId"), hVar.a("google_storage_bucket"), hVar.a("project_id"));
    }

    public String b() {
        return this.f6214a;
    }

    public String c() {
        return this.f6215b;
    }

    public String d() {
        return this.f6218e;
    }

    public String e() {
        return this.f6220g;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return u1.e.a(this.f6215b, kVar.f6215b) && u1.e.a(this.f6214a, kVar.f6214a) && u1.e.a(this.f6216c, kVar.f6216c) && u1.e.a(this.f6217d, kVar.f6217d) && u1.e.a(this.f6218e, kVar.f6218e) && u1.e.a(this.f6219f, kVar.f6219f) && u1.e.a(this.f6220g, kVar.f6220g);
    }

    public int hashCode() {
        return u1.e.b(this.f6215b, this.f6214a, this.f6216c, this.f6217d, this.f6218e, this.f6219f, this.f6220g);
    }

    public String toString() {
        return u1.e.c(this).a("applicationId", this.f6215b).a("apiKey", this.f6214a).a("databaseUrl", this.f6216c).a("gcmSenderId", this.f6218e).a("storageBucket", this.f6219f).a("projectId", this.f6220g).toString();
    }

    public k(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        u1.f.l(!x1.l.a(str), "ApplicationId must be set.");
        this.f6215b = str;
        this.f6214a = str2;
        this.f6216c = str3;
        this.f6217d = str4;
        this.f6218e = str5;
        this.f6219f = str6;
        this.f6220g = str7;
    }
}
