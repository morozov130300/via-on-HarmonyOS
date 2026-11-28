package com.google.firebase.installations.remote;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class b extends TokenResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f3390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TokenResult.ResponseCode f3391c;

    /* JADX INFO: renamed from: com.google.firebase.installations.remote.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class C0046b extends TokenResult.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f3392a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f3393b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public TokenResult.ResponseCode f3394c;

        @Override // com.google.firebase.installations.remote.TokenResult.a
        public TokenResult a() {
            String str = "";
            if (this.f3393b == null) {
                str = " tokenExpirationTimestamp";
            }
            if (str.isEmpty()) {
                return new b(this.f3392a, this.f3393b.longValue(), this.f3394c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.installations.remote.TokenResult.a
        public TokenResult.a b(TokenResult.ResponseCode responseCode) {
            this.f3394c = responseCode;
            return this;
        }

        @Override // com.google.firebase.installations.remote.TokenResult.a
        public TokenResult.a c(String str) {
            this.f3392a = str;
            return this;
        }

        @Override // com.google.firebase.installations.remote.TokenResult.a
        public TokenResult.a d(long j10) {
            this.f3393b = Long.valueOf(j10);
            return this;
        }
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    public TokenResult.ResponseCode b() {
        return this.f3391c;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    public String c() {
        return this.f3389a;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    public long d() {
        return this.f3390b;
    }

    public boolean equals(Object obj) {
        TokenResult.ResponseCode responseCode;
        if (obj == this) {
            return true;
        }
        if (obj instanceof TokenResult) {
            TokenResult tokenResult = (TokenResult) obj;
            String str = this.f3389a;
            if (str != null ? str.equals(tokenResult.c()) : tokenResult.c() == null) {
                if (this.f3390b == tokenResult.d() && ((responseCode = this.f3391c) != null ? responseCode.equals(tokenResult.b()) : tokenResult.b() == null)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f3389a;
        int iHashCode = str == null ? 0 : str.hashCode();
        long j10 = this.f3390b;
        int i10 = (((iHashCode ^ 1000003) * 1000003) ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        TokenResult.ResponseCode responseCode = this.f3391c;
        return i10 ^ (responseCode != null ? responseCode.hashCode() : 0);
    }

    public String toString() {
        return "TokenResult{token=" + this.f3389a + ", tokenExpirationTimestamp=" + this.f3390b + ", responseCode=" + this.f3391c + "}";
    }

    public b(String str, long j10, TokenResult.ResponseCode responseCode) {
        this.f3389a = str;
        this.f3390b = j10;
        this.f3391c = responseCode;
    }
}
