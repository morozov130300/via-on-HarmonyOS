package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class b extends SchedulerConfig.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f2571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f2572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f2573c;

    /* JADX INFO: renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class C0039b extends SchedulerConfig.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f2574a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f2575b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Set f2576c;

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b.a
        public SchedulerConfig.b a() {
            String str = "";
            if (this.f2574a == null) {
                str = " delta";
            }
            if (this.f2575b == null) {
                str = str + " maxAllowedDelay";
            }
            if (this.f2576c == null) {
                str = str + " flags";
            }
            if (str.isEmpty()) {
                return new b(this.f2574a.longValue(), this.f2575b.longValue(), this.f2576c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b.a
        public SchedulerConfig.b.a b(long j10) {
            this.f2574a = Long.valueOf(j10);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b.a
        public SchedulerConfig.b.a c(Set set) {
            if (set == null) {
                throw new NullPointerException("Null flags");
            }
            this.f2576c = set;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b.a
        public SchedulerConfig.b.a d(long j10) {
            this.f2575b = Long.valueOf(j10);
            return this;
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b
    public long b() {
        return this.f2571a;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b
    public Set c() {
        return this.f2573c;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b
    public long d() {
        return this.f2572b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SchedulerConfig.b) {
            SchedulerConfig.b bVar = (SchedulerConfig.b) obj;
            if (this.f2571a == bVar.b() && this.f2572b == bVar.d() && this.f2573c.equals(bVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j10 = this.f2571a;
        int i10 = (((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003;
        long j11 = this.f2572b;
        return this.f2573c.hashCode() ^ ((i10 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003);
    }

    public String toString() {
        return "ConfigValue{delta=" + this.f2571a + ", maxAllowedDelay=" + this.f2572b + ", flags=" + this.f2573c + "}";
    }

    public b(long j10, long j11, Set set) {
        this.f2571a = j10;
        this.f2572b = j11;
        this.f2573c = set;
    }
}
