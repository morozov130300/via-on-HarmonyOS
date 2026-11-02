package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import java.util.Set;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class b extends SchedulerConfig.b {

    /* renamed from: a, reason: collision with root package name */
    public final long f3272a;

    /* renamed from: b, reason: collision with root package name */
    public final long f3273b;

    /* renamed from: c, reason: collision with root package name */
    public final Set f3274c;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.b$b, reason: collision with other inner class name */
    public static final class C0045b extends SchedulerConfig.b.a {

        /* renamed from: a, reason: collision with root package name */
        public Long f3275a;

        /* renamed from: b, reason: collision with root package name */
        public Long f3276b;

        /* renamed from: c, reason: collision with root package name */
        public Set f3277c;

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b.a
        public SchedulerConfig.b a() {
            String str = "";
            if (this.f3275a == null) {
                str = " delta";
            }
            if (this.f3276b == null) {
                str = str + " maxAllowedDelay";
            }
            if (this.f3277c == null) {
                str = str + " flags";
            }
            if (str.isEmpty()) {
                return new b(this.f3275a.longValue(), this.f3276b.longValue(), this.f3277c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b.a
        public SchedulerConfig.b.a b(long j10) {
            this.f3275a = Long.valueOf(j10);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b.a
        public SchedulerConfig.b.a c(Set set) {
            if (set == null) {
                throw new NullPointerException("Null flags");
            }
            this.f3277c = set;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b.a
        public SchedulerConfig.b.a d(long j10) {
            this.f3276b = Long.valueOf(j10);
            return this;
        }
    }

    public b(long j10, long j11, Set set) {
        this.f3272a = j10;
        this.f3273b = j11;
        this.f3274c = set;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b
    public long b() {
        return this.f3272a;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b
    public Set c() {
        return this.f3274c;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b
    public long d() {
        return this.f3273b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SchedulerConfig.b) {
            SchedulerConfig.b bVar = (SchedulerConfig.b) obj;
            if (this.f3272a == bVar.b() && this.f3273b == bVar.d() && this.f3274c.equals(bVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j10 = this.f3272a;
        int i10 = (((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003;
        long j11 = this.f3273b;
        return this.f3274c.hashCode() ^ ((i10 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003);
    }

    public String toString() {
        return "ConfigValue{delta=" + this.f3272a + ", maxAllowedDelay=" + this.f3273b + ", flags=" + this.f3274c + "}";
    }
}
