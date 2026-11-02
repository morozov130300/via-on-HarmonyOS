package com.google.android.datatransport.runtime.firebase.transport;

import f3.b;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class LogEventDropped {

    /* renamed from: c, reason: collision with root package name */
    public static final LogEventDropped f3261c = new a().a();

    /* renamed from: a, reason: collision with root package name */
    public final long f3262a;

    /* renamed from: b, reason: collision with root package name */
    public final Reason f3263b;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
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

        @Override // f3.b
        public int getNumber() {
            return this.number_;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public long f3265a = 0;

        /* renamed from: b, reason: collision with root package name */
        public Reason f3266b = Reason.REASON_UNKNOWN;

        public LogEventDropped a() {
            return new LogEventDropped(this.f3265a, this.f3266b);
        }

        public a b(long j10) {
            this.f3265a = j10;
            return this;
        }

        public a c(Reason reason) {
            this.f3266b = reason;
            return this;
        }
    }

    public LogEventDropped(long j10, Reason reason) {
        this.f3262a = j10;
        this.f3263b = reason;
    }

    public static a c() {
        return new a();
    }

    public long a() {
        return this.f3262a;
    }

    public Reason b() {
        return this.f3263b;
    }
}
