package com.google.firebase.installations.local;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a extends com.google.firebase.installations.local.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PersistedInstallation.RegistrationStatus f3363c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f3364d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f3365e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f3366f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f3367g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f3368h;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b extends com.google.firebase.installations.local.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f3369a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public PersistedInstallation.RegistrationStatus f3370b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f3371c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f3372d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Long f3373e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Long f3374f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f3375g;

        @Override // com.google.firebase.installations.local.b.a
        public com.google.firebase.installations.local.b a() {
            String str = "";
            if (this.f3370b == null) {
                str = " registrationStatus";
            }
            if (this.f3373e == null) {
                str = str + " expiresInSecs";
            }
            if (this.f3374f == null) {
                str = str + " tokenCreationEpochInSecs";
            }
            if (str.isEmpty()) {
                return new a(this.f3369a, this.f3370b, this.f3371c, this.f3372d, this.f3373e.longValue(), this.f3374f.longValue(), this.f3375g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.installations.local.b.a
        public com.google.firebase.installations.local.b.a b(String str) {
            this.f3371c = str;
            return this;
        }

        @Override // com.google.firebase.installations.local.b.a
        public com.google.firebase.installations.local.b.a c(long j10) {
            this.f3373e = Long.valueOf(j10);
            return this;
        }

        @Override // com.google.firebase.installations.local.b.a
        public com.google.firebase.installations.local.b.a d(String str) {
            this.f3369a = str;
            return this;
        }

        @Override // com.google.firebase.installations.local.b.a
        public com.google.firebase.installations.local.b.a e(String str) {
            this.f3375g = str;
            return this;
        }

        @Override // com.google.firebase.installations.local.b.a
        public com.google.firebase.installations.local.b.a f(String str) {
            this.f3372d = str;
            return this;
        }

        @Override // com.google.firebase.installations.local.b.a
        public com.google.firebase.installations.local.b.a g(PersistedInstallation.RegistrationStatus registrationStatus) {
            if (registrationStatus == null) {
                throw new NullPointerException("Null registrationStatus");
            }
            this.f3370b = registrationStatus;
            return this;
        }

        @Override // com.google.firebase.installations.local.b.a
        public com.google.firebase.installations.local.b.a h(long j10) {
            this.f3374f = Long.valueOf(j10);
            return this;
        }

        public b() {
        }

        public b(com.google.firebase.installations.local.b bVar) {
            this.f3369a = bVar.d();
            this.f3370b = bVar.g();
            this.f3371c = bVar.b();
            this.f3372d = bVar.f();
            this.f3373e = Long.valueOf(bVar.c());
            this.f3374f = Long.valueOf(bVar.h());
            this.f3375g = bVar.e();
        }
    }

    @Override // com.google.firebase.installations.local.b
    public String b() {
        return this.f3364d;
    }

    @Override // com.google.firebase.installations.local.b
    public long c() {
        return this.f3366f;
    }

    @Override // com.google.firebase.installations.local.b
    public String d() {
        return this.f3362b;
    }

    @Override // com.google.firebase.installations.local.b
    public String e() {
        return this.f3368h;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        if (obj == this) {
            return true;
        }
        if (obj instanceof com.google.firebase.installations.local.b) {
            com.google.firebase.installations.local.b bVar = (com.google.firebase.installations.local.b) obj;
            String str4 = this.f3362b;
            if (str4 != null ? str4.equals(bVar.d()) : bVar.d() == null) {
                if (this.f3363c.equals(bVar.g()) && ((str = this.f3364d) != null ? str.equals(bVar.b()) : bVar.b() == null) && ((str2 = this.f3365e) != null ? str2.equals(bVar.f()) : bVar.f() == null) && this.f3366f == bVar.c() && this.f3367g == bVar.h() && ((str3 = this.f3368h) != null ? str3.equals(bVar.e()) : bVar.e() == null)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.firebase.installations.local.b
    public String f() {
        return this.f3365e;
    }

    @Override // com.google.firebase.installations.local.b
    public PersistedInstallation.RegistrationStatus g() {
        return this.f3363c;
    }

    @Override // com.google.firebase.installations.local.b
    public long h() {
        return this.f3367g;
    }

    public int hashCode() {
        String str = this.f3362b;
        int iHashCode = ((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.f3363c.hashCode()) * 1000003;
        String str2 = this.f3364d;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f3365e;
        int iHashCode3 = (iHashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        long j10 = this.f3366f;
        int i10 = (iHashCode3 ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        long j11 = this.f3367g;
        int i11 = (i10 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003;
        String str4 = this.f3368h;
        return i11 ^ (str4 != null ? str4.hashCode() : 0);
    }

    @Override // com.google.firebase.installations.local.b
    public com.google.firebase.installations.local.b.a n() {
        return new b(this);
    }

    public String toString() {
        return "PersistedInstallationEntry{firebaseInstallationId=" + this.f3362b + ", registrationStatus=" + this.f3363c + ", authToken=" + this.f3364d + ", refreshToken=" + this.f3365e + ", expiresInSecs=" + this.f3366f + ", tokenCreationEpochInSecs=" + this.f3367g + ", fisError=" + this.f3368h + "}";
    }

    public a(String str, PersistedInstallation.RegistrationStatus registrationStatus, String str2, String str3, long j10, long j11, String str4) {
        this.f3362b = str;
        this.f3363c = registrationStatus;
        this.f3364d = str2;
        this.f3365e = str3;
        this.f3366f = j10;
        this.f3367g = j11;
        this.f3368h = str4;
    }
}
