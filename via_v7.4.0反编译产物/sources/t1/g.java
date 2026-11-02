package t1;

import com.google.android.gms.common.internal.RootTelemetryConfiguration;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: b, reason: collision with root package name */
    public static g f12046b;

    /* renamed from: c, reason: collision with root package name */
    public static final RootTelemetryConfiguration f12047c = new RootTelemetryConfiguration(0, false, false, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    public RootTelemetryConfiguration f12048a;

    public static synchronized g a() {
        try {
            if (f12046b == null) {
                f12046b = new g();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f12046b;
    }

    public final synchronized void b(RootTelemetryConfiguration rootTelemetryConfiguration) {
        if (rootTelemetryConfiguration == null) {
            this.f12048a = f12047c;
            return;
        }
        RootTelemetryConfiguration rootTelemetryConfiguration2 = this.f12048a;
        if (rootTelemetryConfiguration2 == null || rootTelemetryConfiguration2.k() < rootTelemetryConfiguration.k()) {
            this.f12048a = rootTelemetryConfiguration;
        }
    }
}
