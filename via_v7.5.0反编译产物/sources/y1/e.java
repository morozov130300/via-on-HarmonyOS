package y1;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static e f14814b = new e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f14815a = null;

    public static d a(Context context) {
        return f14814b.b(context);
    }

    public final synchronized d b(Context context) {
        try {
            if (this.f14815a == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                this.f14815a = new d(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f14815a;
    }
}
