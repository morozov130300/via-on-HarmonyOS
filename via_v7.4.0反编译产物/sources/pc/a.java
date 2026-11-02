package pc;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final b[] f11161a;

    /* renamed from: c, reason: collision with root package name */
    public static volatile b[] f11163c;

    /* renamed from: b, reason: collision with root package name */
    public static final List f11162b = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public static final b f11164d = new C0113a();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: pc.a$a, reason: collision with other inner class name */
    public static class C0113a extends b {
        @Override // pc.a.b
        public void a(String str, Object... objArr) {
            for (b bVar : a.f11163c) {
                bVar.a(str, objArr);
            }
        }

        @Override // pc.a.b
        public void b(Throwable th) {
            for (b bVar : a.f11163c) {
                bVar.b(th);
            }
        }

        @Override // pc.a.b
        public void c(String str, Object... objArr) {
            for (b bVar : a.f11163c) {
                bVar.c(str, objArr);
            }
        }

        @Override // pc.a.b
        public void d(Throwable th) {
            for (b bVar : a.f11163c) {
                bVar.d(th);
            }
        }

        @Override // pc.a.b
        public void e(Throwable th, String str, Object... objArr) {
            for (b bVar : a.f11163c) {
                bVar.e(th, str, objArr);
            }
        }

        @Override // pc.a.b
        public void k(int i10, String str, String str2, Throwable th) {
            throw new AssertionError("Missing override for log method.");
        }

        @Override // pc.a.b
        public void m(String str, Object... objArr) {
            for (b bVar : a.f11163c) {
                bVar.m(str, objArr);
            }
        }

        @Override // pc.a.b
        public void n(Throwable th) {
            for (b bVar : a.f11163c) {
                bVar.n(th);
            }
        }

        @Override // pc.a.b
        public void o(Throwable th, String str, Object... objArr) {
            for (b bVar : a.f11163c) {
                bVar.o(th, str, objArr);
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static abstract class b {

        /* renamed from: a, reason: collision with root package name */
        public final ThreadLocal f11165a = new ThreadLocal();

        public void a(String str, Object... objArr) {
            l(3, null, str, objArr);
        }

        public void b(Throwable th) {
            l(3, th, null, new Object[0]);
        }

        public void c(String str, Object... objArr) {
            l(6, null, str, objArr);
        }

        public void d(Throwable th) {
            l(6, th, null, new Object[0]);
        }

        public void e(Throwable th, String str, Object... objArr) {
            l(6, th, str, objArr);
        }

        public String f(String str, Object[] objArr) {
            return String.format(str, objArr);
        }

        public final String g(Throwable th) {
            StringWriter stringWriter = new StringWriter(256);
            PrintWriter printWriter = new PrintWriter((Writer) stringWriter, false);
            th.printStackTrace(printWriter);
            printWriter.flush();
            return stringWriter.toString();
        }

        public String h() {
            String str = (String) this.f11165a.get();
            if (str != null) {
                this.f11165a.remove();
            }
            return str;
        }

        public boolean i(int i10) {
            return true;
        }

        public boolean j(String str, int i10) {
            return i(i10);
        }

        public abstract void k(int i10, String str, String str2, Throwable th);

        public final void l(int i10, Throwable th, String str, Object... objArr) {
            String strH = h();
            if (j(strH, i10)) {
                if (str != null && str.length() == 0) {
                    str = null;
                }
                if (str != null) {
                    if (objArr != null && objArr.length > 0) {
                        str = f(str, objArr);
                    }
                    if (th != null) {
                        str = str + "\n" + g(th);
                    }
                } else if (th == null) {
                    return;
                } else {
                    str = g(th);
                }
                k(i10, strH, str, th);
            }
        }

        public void m(String str, Object... objArr) {
            l(5, null, str, objArr);
        }

        public void n(Throwable th) {
            l(5, th, null, new Object[0]);
        }

        public void o(Throwable th, String str, Object... objArr) {
            l(5, th, str, objArr);
        }
    }

    static {
        b[] bVarArr = new b[0];
        f11161a = bVarArr;
        f11163c = bVarArr;
    }

    public static void a(String str, Object... objArr) {
        f11164d.a(str, objArr);
    }

    public static void b(Throwable th) {
        f11164d.b(th);
    }

    public static void c(String str, Object... objArr) {
        f11164d.c(str, objArr);
    }

    public static void d(Throwable th) {
        f11164d.d(th);
    }

    public static void e(Throwable th, String str, Object... objArr) {
        f11164d.e(th, str, objArr);
    }

    public static List f() {
        List listUnmodifiableList;
        List list = f11162b;
        synchronized (list) {
            listUnmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        }
        return listUnmodifiableList;
    }

    public static void g(b bVar) {
        if (bVar == null) {
            throw new NullPointerException("tree == null");
        }
        if (bVar == f11164d) {
            throw new IllegalArgumentException("Cannot plant Timber into itself.");
        }
        List list = f11162b;
        synchronized (list) {
            list.add(bVar);
            f11163c = (b[]) list.toArray(new b[list.size()]);
        }
    }

    public static void h(String str, Object... objArr) {
        f11164d.m(str, objArr);
    }

    public static void i(Throwable th) {
        f11164d.n(th);
    }

    public static void j(Throwable th, String str, Object... objArr) {
        f11164d.o(th, str, objArr);
    }
}
