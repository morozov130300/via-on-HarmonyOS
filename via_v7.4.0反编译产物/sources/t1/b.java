package t1;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static int f12026a = 4225;

    /* renamed from: b, reason: collision with root package name */
    public static final Object f12027b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static i0 f12028c = null;

    /* renamed from: d, reason: collision with root package name */
    public static HandlerThread f12029d = null;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f12030e = false;

    public static int a() {
        return f12026a;
    }

    public static b b(Context context) {
        synchronized (f12027b) {
            try {
                if (f12028c == null) {
                    f12028c = new i0(context.getApplicationContext(), f12030e ? c().getLooper() : context.getMainLooper());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f12028c;
    }

    public static HandlerThread c() {
        synchronized (f12027b) {
            try {
                HandlerThread handlerThread = f12029d;
                if (handlerThread != null) {
                    return handlerThread;
                }
                HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", 9);
                f12029d = handlerThread2;
                handlerThread2.start();
                return f12029d;
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
