package com.google.android.datatransport.cct.internal;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class b extends ClientInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ClientInfo.ClientType f2549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d1.a f2550b;

    /* JADX INFO: renamed from: com.google.android.datatransport.cct.internal.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class C0038b extends ClientInfo.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ClientInfo.ClientType f2551a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public d1.a f2552b;

        @Override // com.google.android.datatransport.cct.internal.ClientInfo.a
        public ClientInfo a() {
            return new b(this.f2551a, this.f2552b);
        }

        @Override // com.google.android.datatransport.cct.internal.ClientInfo.a
        public ClientInfo.a b(d1.a aVar) {
            this.f2552b = aVar;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.ClientInfo.a
        public ClientInfo.a c(ClientInfo.ClientType clientType) {
            this.f2551a = clientType;
            return this;
        }
    }

    @Override // com.google.android.datatransport.cct.internal.ClientInfo
    public d1.a b() {
        return this.f2550b;
    }

    @Override // com.google.android.datatransport.cct.internal.ClientInfo
    public ClientInfo.ClientType c() {
        return this.f2549a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ClientInfo) {
            ClientInfo clientInfo = (ClientInfo) obj;
            ClientInfo.ClientType clientType = this.f2549a;
            if (clientType != null ? clientType.equals(clientInfo.c()) : clientInfo.c() == null) {
                d1.a aVar = this.f2550b;
                if (aVar != null ? aVar.equals(clientInfo.b()) : clientInfo.b() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        ClientInfo.ClientType clientType = this.f2549a;
        int iHashCode = ((clientType == null ? 0 : clientType.hashCode()) ^ 1000003) * 1000003;
        d1.a aVar = this.f2550b;
        return iHashCode ^ (aVar != null ? aVar.hashCode() : 0);
    }

    public String toString() {
        return "ClientInfo{clientType=" + this.f2549a + ", androidClientInfo=" + this.f2550b + "}";
    }

    public b(ClientInfo.ClientType clientType, d1.a aVar) {
        this.f2549a = clientType;
        this.f2550b = aVar;
    }
}
