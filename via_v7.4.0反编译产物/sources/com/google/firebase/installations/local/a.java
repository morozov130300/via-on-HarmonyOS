package com.google.firebase.installations.local;

import com.google.firebase.installations.local.PersistedInstallation;
import com.google.firebase.installations.local.b;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a extends com.google.firebase.installations.local.b {

    /* renamed from: b, reason: collision with root package name */
    public final String f4065b;

    /* renamed from: c, reason: collision with root package name */
    public final PersistedInstallation.RegistrationStatus f4066c;

    /* renamed from: d, reason: collision with root package name */
    public final String f4067d;

    /* renamed from: e, reason: collision with root package name */
    public final String f4068e;

    /* renamed from: f, reason: collision with root package name */
    public final long f4069f;

    /* renamed from: g, reason: collision with root package name */
    public final long f4070g;

    /* renamed from: h, reason: collision with root package name */
    public final String f4071h;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b extends b.a {

        /* renamed from: a, reason: collision with root package name */
        public String f4072a;

        /* renamed from: b, reason: collision with root package name */
        public PersistedInstallation.RegistrationStatus f4073b;

        /* renamed from: c, reason: collision with root package name */
        public String f4074c;

        /* renamed from: d, reason: collision with root package name */
        public String f4075d;

        /* renamed from: e, reason: collision with root package name */
        public Long f4076e;

        /* renamed from: f, reason: collision with root package name */
        public Long f4077f;

        /* renamed from: g, reason: collision with root package name */
        public String f4078g;

        public b() {
        }

        public b(com.google.firebase.installations.local.b bVar) {
            this.f4072a = bVar.d();
            this.f4073b = bVar.g();
            this.f4074c = bVar.b();
            this.f4075d = bVar.f();
            this.f4076e = Long.valueOf(bVar.c());
            this.f4077f = Long.valueOf(bVar.h());
            this.f4078g = bVar.e();
        }

        @Override // com.google.firebase.installations.local.b.a
        public com.google.firebase.installations.local.b a() {
            String str = "";
            if (this.f4073b == null) {
                str = " registrationStatus";
            }
            if (this.f4076e == null) {
                str = str + " expiresInSecs";
            }
            if (this.f4077f == null) {
                str = str + " tokenCreationEpochInSecs";
            }
            if (str.isEmpty()) {
                return new a(this.f4072a, this.f4073b, this.f4074c, this.f4075d, this.f4076e.longValue(), this.f4077f.longValue(), this.f4078g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.installations.local.b.a
        public b.a b(String str) {
            this.f4074c = str;
            return this;
        }

        @Override // com.google.firebase.installations.local.b.a
        public b.a c(long j10) {
            this.f4076e = Long.valueOf(j10);
            return this;
        }

        @Override // com.google.firebase.installations.local.b.a
        public b.a d(String str) {
            this.f4072a = str;
            return this;
        }

        @Override // com.google.firebase.installations.local.b.a
        public b.a e(String str) {
            this.f4078g = str;
            return this;
        }

        @Override // com.google.firebase.installations.local.b.a
        public b.a f(String str) {
            this.f4075d = str;
            return this;
        }

        @Override // com.google.firebase.installations.local.b.a
        public b.a g(PersistedInstallation.RegistrationStatus registrationStatus) {
            if (registrationStatus == null) {
                throw new NullPointerException("Null registrationStatus");
            }
            this.f4073b = registrationStatus;
            return this;
        }

        @Override // com.google.firebase.installations.local.b.a
        public b.a h(long j10) {
            this.f4077f = Long.valueOf(j10);
            return this;
        }
    }

    public a(String str, PersistedInstallation.RegistrationStatus registrationStatus, String str2, String str3, long j10, long j11, String str4) {
        this.f4065b = str;
        this.f4066c = registrationStatus;
        this.f4067d = str2;
        this.f4068e = str3;
        this.f4069f = j10;
        this.f4070g = j11;
        this.f4071h = str4;
    }

    @Override // com.google.firebase.installations.local.b
    public String b() {
        return this.f4067d;
    }

    @Override // com.google.firebase.installations.local.b
    public long c() {
        return this.f4069f;
    }

    @Override // com.google.firebase.installations.local.b
    public String d() {
        return this.f4065b;
    }

    @Override // com.google.firebase.installations.local.b
    public String e() {
        return this.f4071h;
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
            String str4 = this.f4065b;
            if (str4 != null ? str4.equals(bVar.d()) : bVar.d() == null) {
                if (this.f4066c.equals(bVar.g()) && ((str = this.f4067d) != null ? str.equals(bVar.b()) : bVar.b() == null) && ((str2 = this.f4068e) != null ? str2.equals(bVar.f()) : bVar.f() == null) && this.f4069f == bVar.c() && this.f4070g == bVar.h() && ((str3 = this.f4071h) != null ? str3.equals(bVar.e()) : bVar.e() == null)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.firebase.installations.local.b
    public String f() {
        return this.f4068e;
    }

    @Override // com.google.firebase.installations.local.b
    public PersistedInstallation.RegistrationStatus g() {
        return this.f4066c;
    }

    @Override // com.google.firebase.installations.local.b
    public long h() {
        return this.f4070g;
    }

    public int hashCode() {
        String str = this.f4065b;
        int iHashCode = ((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.f4066c.hashCode()) * 1000003;
        String str2 = this.f4067d;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f4068e;
        int iHashCode3 = (iHashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        long j10 = this.f4069f;
        int i10 = (iHashCode3 ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        long j11 = this.f4070g;
        int i11 = (i10 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003;
        String str4 = this.f4071h;
        return i11 ^ (str4 != null ? str4.hashCode() : 0);
    }

    @Override // com.google.firebase.installations.local.b
    public b.a n() {
        return new b(this);
    }

    public String toString() {
        return "PersistedInstallationEntry{firebaseInstallationId=" + this.f4065b + ", registrationStatus=" + this.f4066c + ", authToken=" + this.f4067d + ", refreshToken=" + this.f4068e + ", expiresInSecs=" + this.f4069f + ", tokenCreationEpochInSecs=" + this.f4070g + ", fisError=" + this.f4071h + "}";
    }
}
