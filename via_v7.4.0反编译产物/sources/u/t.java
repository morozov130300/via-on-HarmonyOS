package u;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class t {

    /* renamed from: a, reason: collision with root package name */
    public static long f12440a;

    /* renamed from: b, reason: collision with root package name */
    public static Method f12441b;

    /* renamed from: c, reason: collision with root package name */
    public static Method f12442c;

    /* renamed from: d, reason: collision with root package name */
    public static Method f12443d;

    /* renamed from: e, reason: collision with root package name */
    public static Method f12444e;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
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
                f12440a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                Class cls = Long.TYPE;
                f12441b = Trace.class.getMethod("isTagEnabled", cls);
                Class cls2 = Integer.TYPE;
                f12442c = Trace.class.getMethod("asyncTraceBegin", cls, String.class, cls2);
                f12443d = Trace.class.getMethod("asyncTraceEnd", cls, String.class, cls2);
                f12444e = Trace.class.getMethod("traceCounter", cls, String.class, cls2);
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
