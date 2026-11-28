package v;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f12979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f12980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Method f12981c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Method f12982d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Method f12983e;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class a {
        public static void a(String str) {
            Trace.beginSection(str);
        }

        public static void b() {
            Trace.endSection();
        }
    }

    static {
        if (Build.VERSION.SDK_INT < 29) {
            try {
                f12979a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                Class cls = Long.TYPE;
                f12980b = Trace.class.getMethod("isTagEnabled", cls);
                Class cls2 = Integer.TYPE;
                f12981c = Trace.class.getMethod("asyncTraceBegin", cls, String.class, cls2);
                f12982d = Trace.class.getMethod("asyncTraceEnd", cls, String.class, cls2);
                f12983e = Trace.class.getMethod("traceCounter", cls, String.class, cls2);
            } catch (Exception e10) {
                Log.i("TraceCompat", "Unable to initialize via reflection.", e10);
            }
        }
    }

    public static void a(String str) {
        a.a(str);
    }

    public static void b() {
        a.b();
    }
}
