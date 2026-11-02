package n0;

import android.os.Trace;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static long f10136a;

    /* renamed from: b, reason: collision with root package name */
    public static Method f10137b;

    public static void a(String str) {
        c.a(str);
    }

    public static void b() {
        c.b();
    }

    public static void c(String str, Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (!(cause instanceof RuntimeException)) {
                throw new RuntimeException(cause);
            }
            throw ((RuntimeException) cause);
        }
        Log.v("Trace", "Unable to call " + str + " via reflection", exc);
    }

    public static boolean d() {
        try {
            if (f10137b == null) {
                return Trace.isEnabled();
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        return e();
    }

    public static boolean e() {
        try {
            if (f10137b == null) {
                f10136a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                f10137b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) f10137b.invoke(null, Long.valueOf(f10136a))).booleanValue();
        } catch (Exception e10) {
            c("isTagEnabled", e10);
            return false;
        }
    }
}
