package com.google.firebase.installations.remote;

import com.google.firebase.installations.remote.TokenResult;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class b extends TokenResult {

    /* renamed from: a, reason: collision with root package name */
    public final String f4092a;

    /* renamed from: b, reason: collision with root package name */
    public final long f4093b;

    /* renamed from: c, reason: collision with root package name */
    public final TokenResult.ResponseCode f4094c;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: com.google.firebase.installations.remote.b$b, reason: collision with other inner class name */
    public static final class C0052b extends TokenResult.a {

        /* renamed from: a, reason: collision with root package name */
        public String f4095a;

        /* renamed from: b, reason: collision with root package name */
        public Long f4096b;

        /* renamed from: c, reason: collision with root package name */
        public TokenResult.ResponseCode f4097c;

        @Override // com.google.firebase.installations.remote.TokenResult.a
        public TokenResult a() {
            String str = "";
            if (this.f4096b == null) {
                str = " tokenExpirationTimestamp";
            }
            if (str.isEmpty()) {
                return new b(this.f4095a, this.f4096b.longValue(), this.f4097c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.installations.remote.TokenResult.a
        public TokenResult.a b(TokenResult.ResponseCode responseCode) {
            this.f4097c = responseCode;
            return this;
        }

        @Override // com.google.firebase.installations.remote.TokenResult.a
        public TokenResult.a c(String str) {
            this.f4095a = str;
            return this;
        }

        @Override // com.google.firebase.installations.remote.TokenResult.a
        public TokenResult.a d(long j10) {
            this.f4096b = Long.valueOf(j10);
            return this;
        }
    }

    public b(String str, long j10, TokenResult.ResponseCode responseCode) {
        this.f4092a = str;
        this.f4093b = j10;
        this.f4094c = responseCode;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    public TokenResult.ResponseCode b() {
        return this.f4094c;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    public String c() {
        return this.f4092a;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    public long d() {
        return this.f4093b;
    }

    public boolean equals(Object obj) {
        TokenResult.ResponseCode responseCode;
        if (obj == this) {
            return true;
        }
        if (obj instanceof TokenResult) {
            TokenResult tokenResult = (TokenResult) obj;
            String str = this.f4092a;
            if (str != null ? str.equals(tokenResult.c()) : tokenResult.c() == null) {
                if (this.f4093b == tokenResult.d() && ((responseCode = this.f4094c) != null ? responseCode.equals(tokenResult.b()) : tokenResult.b() == null)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f4092a;
        int iHashCode = str == null ? 0 : str.hashCode();
        long j10 = this.f4093b;
        int i10 = (((iHashCode ^ 1000003) * 1000003) ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        TokenResult.ResponseCode responseCode = this.f4094c;
        return i10 ^ (responseCode != null ? responseCode.hashCode() : 0);
    }

    public String toString() {
        return "TokenResult{token=" + this.f4092a + ", tokenExpirationTimestamp=" + this.f4093b + ", responseCode=" + this.f4094c + "}";
    }
}
