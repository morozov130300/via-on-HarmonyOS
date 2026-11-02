package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.ClientInfo;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class b extends ClientInfo {

    /* renamed from: a, reason: collision with root package name */
    public final ClientInfo.ClientType f3250a;

    /* renamed from: b, reason: collision with root package name */
    public final c1.a f3251b;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: com.google.android.datatransport.cct.internal.b$b, reason: collision with other inner class name */
    public static final class C0044b extends ClientInfo.a {

        /* renamed from: a, reason: collision with root package name */
        public ClientInfo.ClientType f3252a;

        /* renamed from: b, reason: collision with root package name */
        public c1.a f3253b;

        @Override // com.google.android.datatransport.cct.internal.ClientInfo.a
        public ClientInfo a() {
            return new b(this.f3252a, this.f3253b);
        }

        @Override // com.google.android.datatransport.cct.internal.ClientInfo.a
        public ClientInfo.a b(c1.a aVar) {
            this.f3253b = aVar;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.ClientInfo.a
        public ClientInfo.a c(ClientInfo.ClientType clientType) {
            this.f3252a = clientType;
            return this;
        }
    }

    public b(ClientInfo.ClientType clientType, c1.a aVar) {
        this.f3250a = clientType;
        this.f3251b = aVar;
    }

    @Override // com.google.android.datatransport.cct.internal.ClientInfo
    public c1.a b() {
        return this.f3251b;
    }

    @Override // com.google.android.datatransport.cct.internal.ClientInfo
    public ClientInfo.ClientType c() {
        return this.f3250a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ClientInfo) {
            ClientInfo clientInfo = (ClientInfo) obj;
            ClientInfo.ClientType clientType = this.f3250a;
            if (clientType != null ? clientType.equals(clientInfo.c()) : clientInfo.c() == null) {
                c1.a aVar = this.f3251b;
                if (aVar != null ? aVar.equals(clientInfo.b()) : clientInfo.b() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        ClientInfo.ClientType clientType = this.f3250a;
        int iHashCode = ((clientType == null ? 0 : clientType.hashCode()) ^ 1000003) * 1000003;
        c1.a aVar = this.f3251b;
        return iHashCode ^ (aVar != null ? aVar.hashCode() : 0);
    }

    public String toString() {
        return "ClientInfo{clientType=" + this.f3250a + ", androidClientInfo=" + this.f3251b + "}";
    }
}
