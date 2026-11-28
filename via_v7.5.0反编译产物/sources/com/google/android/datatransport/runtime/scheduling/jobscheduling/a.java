package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a extends SchedulerConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o1.a f2569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f2570b;

    public a(o1.a aVar, Map map) {
        if (aVar == null) {
            throw new NullPointerException("Null clock");
        }
        this.f2569a = aVar;
        if (map == null) {
            throw new NullPointerException("Null values");
        }
        this.f2570b = map;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig
    public o1.a e() {
        return this.f2569a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SchedulerConfig) {
            SchedulerConfig schedulerConfig = (SchedulerConfig) obj;
            if (this.f2569a.equals(schedulerConfig.e()) && this.f2570b.equals(schedulerConfig.h())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig
    public Map h() {
        return this.f2570b;
    }

    public int hashCode() {
        return ((this.f2569a.hashCode() ^ 1000003) * 1000003) ^ this.f2570b.hashCode();
    }

    public String toString() {
        return "SchedulerConfig{clock=" + this.f2569a + ", values=" + this.f2570b + "}";
    }
}
