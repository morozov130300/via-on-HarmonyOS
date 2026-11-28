package tc;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b[] f12724a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile b[] f12726c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List f12725b = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f12727d = new C0127a();

    /* JADX INFO: renamed from: tc.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class C0127a extends b {
        @Override // tc.a.b
        public void a(String str, Object... objArr) {
            for (b bVar : a.f12726c) {
                bVar.a(str, objArr);
            }
        }

        @Override // tc.a.b
        public void b(Throwable th) {
            for (b bVar : a.f12726c) {
                bVar.b(th);
            }
        }

        @Override // tc.a.b
        public void c(Throwable th, String str, Object... objArr) {
            for (b bVar : a.f12726c) {
                bVar.c(th, str, objArr);
            }
        }

        @Override // tc.a.b
        public void d(String str, Object... objArr) {
            for (b bVar : a.f12726c) {
                bVar.d(str, objArr);
            }
        }

        @Override // tc.a.b
        public void e(Throwable th) {
            for (b bVar : a.f12726c) {
                bVar.e(th);
            }
        }

        @Override // tc.a.b
        public void f(Throwable th, String str, Object... objArr) {
            for (b bVar : a.f12726c) {
                bVar.f(th, str, objArr);
            }
        }

        @Override // tc.a.b
        public void l(int i10, String str, String str2, Throwable th) {
            throw new AssertionError("Missing override for log method.");
        }

        @Override // tc.a.b
        public void n(String str, Object... objArr) {
            for (b bVar : a.f12726c) {
                bVar.n(str, objArr);
            }
        }

        @Override // tc.a.b
        public void o(Throwable th) {
            for (b bVar : a.f12726c) {
                bVar.o(th);
            }
        }

        @Override // tc.a.b
        public void p(Throwable th, String str, Object... objArr) {
            for (b bVar : a.f12726c) {
                bVar.p(th, str, objArr);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ThreadLocal f12728a = new ThreadLocal();

        public void a(String str, Object... objArr) {
            m(3, null, str, objArr);
        }

        public void b(Throwable th) {
            m(3, th, null, new Object[0]);
        }

        public void c(Throwable th, String str, Object... objArr) {
            m(3, th, str, objArr);
        }

        public void d(String str, Object... objArr) {
            m(6, null, str, objArr);
        }

        public void e(Throwable th) {
            m(6, th, null, new Object[0]);
        }

        public void f(Throwable th, String str, Object... objArr) {
            m(6, th, str, objArr);
        }

        public String g(String str, Object[] objArr) {
            return String.format(str, objArr);
        }

        public final String h(Throwable th) {
            StringWriter stringWriter = new StringWriter(256);
            PrintWriter printWriter = new PrintWriter((Writer) stringWriter, false);
            th.printStackTrace(printWriter);
            printWriter.flush();
            return stringWriter.toString();
        }

        public String i() {
            String str = (String) this.f12728a.get();
            if (str != null) {
                this.f12728a.remove();
            }
            return str;
        }

        public boolean j(int i10) {
            return true;
        }

        public boolean k(String str, int i10) {
            return j(i10);
        }

        public abstract void l(int i10, String str, String str2, Throwable th);

        public final void m(int i10, Throwable th, String str, Object... objArr) {
            String strI = i();
            if (k(strI, i10)) {
                if (str != null && str.length() == 0) {
                    str = null;
                }
                if (str != null) {
                    if (objArr != null && objArr.length > 0) {
                        str = g(str, objArr);
                    }
                    if (th != null) {
                        str = str + "\n" + h(th);
                    }
                } else if (th == null) {
                    return;
                } else {
                    str = h(th);
                }
                l(i10, strI, str, th);
            }
        }

        public void n(String str, Object... objArr) {
            m(5, null, str, objArr);
        }

        public void o(Throwable th) {
            m(5, th, null, new Object[0]);
        }

        public void p(Throwable th, String str, Object... objArr) {
            m(5, th, str, objArr);
        }
    }

    static {
        b[] bVarArr = new b[0];
        f12724a = bVarArr;
        f12726c = bVarArr;
    }

    public static void a(String str, Object... objArr) {
        f12727d.a(str, objArr);
    }

    public static void b(Throwable th) {
        f12727d.b(th);
    }

    public static void c(Throwable th, String str, Object... objArr) {
        f12727d.c(th, str, objArr);
    }

    public static void d(String str, Object... objArr) {
        f12727d.d(str, objArr);
    }

    public static void e(Throwable th) {
        f12727d.e(th);
    }

    public static void f(Throwable th, String str, Object... objArr) {
        f12727d.f(th, str, objArr);
    }

    public static List g() {
        List listUnmodifiableList;
        List list = f12725b;
        synchronized (list) {
            listUnmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        }
        return listUnmodifiableList;
    }

    public static void h(b bVar) {
        if (bVar == null) {
            throw new NullPointerException("tree == null");
        }
        if (bVar == f12727d) {
            throw new IllegalArgumentException("Cannot plant Timber into itself.");
        }
        List list = f12725b;
        synchronized (list) {
            list.add(bVar);
            f12726c = (b[]) list.toArray(new b[list.size()]);
        }
    }

    public static void i(String str, Object... objArr) {
        f12727d.n(str, objArr);
    }

    public static void j(Throwable th) {
        f12727d.o(th);
    }

    public static void k(Throwable th, String str, Object... objArr) {
        f12727d.p(th, str, objArr);
    }
}
