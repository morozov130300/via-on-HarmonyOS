package u1;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f12759a = 4225;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f12760b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static i0 f12761c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static HandlerThread f12762d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f12763e = false;

    public static int a() {
        return f12759a;
    }

    public static b b(Context context) {
        synchronized (f12760b) {
            try {
                if (f12761c == null) {
                    f12761c = new i0(context.getApplicationContext(), f12763e ? c().getLooper() : context.getMainLooper());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f12761c;
    }

    public static HandlerThread c() {
        synchronized (f12760b) {
            try {
                HandlerThread handlerThread = f12762d;
                if (handlerThread != null) {
                    return handlerThread;
                }
                HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", 9);
                f12762d = handlerThread2;
                handlerThread2.start();
                return f12762d;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract void d(d0 d0Var, ServiceConnection serviceConnection, String str);

    public final void e(String str, String str2, int i10, ServiceConnection serviceConnection, String str3, boolean z10) {
        d(new d0(str, str2, i10, z10), serviceConnection, str3);
    }

    public abstract boolean f(d0 d0Var, ServiceConnection serviceConnection, String str, Executor executor);
}
