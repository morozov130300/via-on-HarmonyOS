package u1;

import com.google.android.gms.common.internal.RootTelemetryConfiguration;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static g f12779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final RootTelemetryConfiguration f12780c = new RootTelemetryConfiguration(0, false, false, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RootTelemetryConfiguration f12781a;

    public static synchronized g a() {
        try {
            if (f12779b == null) {
                f12779b = new g();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f12779b;
    }

    public final synchronized void b(RootTelemetryConfiguration rootTelemetryConfiguration) {
        try {
            if (rootTelemetryConfiguration == null) {
                this.f12781a = f12780c;
                return;
            }
            RootTelemetryConfiguration rootTelemetryConfiguration2 = this.f12781a;
            if (rootTelemetryConfiguration2 == null || rootTelemetryConfiguration2.k() < rootTelemetryConfiguration.k()) {
                this.f12781a = rootTelemetryConfiguration;
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
