package com.google.android.datatransport.runtime.firebase.transport;

import g3.b;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class LogEventDropped {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LogEventDropped f2560c = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f2561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Reason f2562b;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public enum Reason implements b {
        REASON_UNKNOWN(0),
        MESSAGE_TOO_OLD(1),
        CACHE_FULL(2),
        PAYLOAD_TOO_BIG(3),
        MAX_RETRIES_REACHED(4),
        INVALID_PAYLOD(5),
        SERVER_ERROR(6);

        private final int number_;

        Reason(int i10) {
            this.number_ = i10;
        }

        @Override // g3.b
        public int getNumber() {
            return this.number_;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f2564a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Reason f2565b = Reason.REASON_UNKNOWN;

        public LogEventDropped a() {
            return new LogEventDropped(this.f2564a, this.f2565b);
        }

        public a b(long j10) {
            this.f2564a = j10;
            return this;
        }

        public a c(Reason reason) {
            this.f2565b = reason;
            return this;
        }
    }

    public LogEventDropped(long j10, Reason reason) {
        this.f2561a = j10;
        this.f2562b = reason;
    }

    public static a c() {
        return new a();
    }

    public long a() {
        return this.f2561a;
    }

    public Reason b() {
        return this.f2562b;
    }
}
