package com.google.firebase.installations.remote;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class InstallationResponse {

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public enum ResponseCode {
        OK,
        BAD_CONFIG
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static abstract class a {
        public abstract InstallationResponse a();

        public abstract a b(TokenResult tokenResult);

        public abstract a c(String str);

        public abstract a d(String str);

        public abstract a e(ResponseCode responseCode);

        public abstract a f(String str);
    }

    public static a a() {
        return new com.google.firebase.installations.remote.a.b();
    }

    public abstract TokenResult b();

    public abstract String c();

    public abstract String d();

    public abstract ResponseCode e();

    public abstract String f();
}
