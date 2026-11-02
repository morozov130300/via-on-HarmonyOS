package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a extends SchedulerConfig {

    /* renamed from: a, reason: collision with root package name */
    public final n1.a f3270a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f3271b;

    public a(n1.a aVar, Map map) {
        if (aVar == null) {
            throw new NullPointerException("Null clock");
        }
        this.f3270a = aVar;
        if (map == null) {
            throw new NullPointerException("Null values");
        }
        this.f3271b = map;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig
    public n1.a e() {
        return this.f3270a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SchedulerConfig) {
            SchedulerConfig schedulerConfig = (SchedulerConfig) obj;
            if (this.f3270a.equals(schedulerConfig.e()) && this.f3271b.equals(schedulerConfig.h())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig
    public Map h() {
        return this.f3271b;
    }

    public int hashCode() {
        return ((this.f3270a.hashCode() ^ 1000003) * 1000003) ^ this.f3271b.hashCode();
    }

    public String toString() {
        return "SchedulerConfig{clock=" + this.f3270a + ", values=" + this.f3271b + "}";
    }
}
