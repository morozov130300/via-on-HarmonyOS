package ac;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class d extends f {

    /* renamed from: c, reason: collision with root package name */
    public final Method f402c;

    /* renamed from: d, reason: collision with root package name */
    public final Method f403d;

    /* renamed from: e, reason: collision with root package name */
    public final Method f404e;

    /* renamed from: f, reason: collision with root package name */
    public final Class f405f;

    /* renamed from: g, reason: collision with root package name */
    public final Class f406g;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class a implements InvocationHandler {

        /* renamed from: a, reason: collision with root package name */
        public final List f407a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f408b;

        /* renamed from: c, reason: collision with root package name */
        public String f409c;

        public a(List list) {
            this.f407a = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = ub.c.f12936b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f408b = true;
                return null;
            }
            if (name.equals("protocols") && objArr.length == 0) {
                return this.f407a;
            }
            if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1) {
                Object obj2 = objArr[0];
                if (obj2 instanceof List) {
                    List list = (List) obj2;
                    int size = list.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        if (this.f407a.contains(list.get(i10))) {
                            String str = (String) list.get(i10);
                            this.f409c = str;
                            return str;
                        }
                    }
                    String str2 = (String) this.f407a.get(0);
                    this.f409c = str2;
                    return str2;
                }
            }
            if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                return method.invoke(this, objArr);
            }
            this.f409c = (String) objArr[0];
            return null;
        }
    }

    public d(Method method, Method method2, Method method3, Class cls, Class cls2) {
        this.f402c = method;
        this.f403d = method2;
        this.f404e = method3;
        this.f405f = cls;
        this.f406g = cls2;
    }

    public static f r() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
            return new d(cls.getMethod("put", SSLSocket.class, cls2), cls.getMethod("get", SSLSocket.class), cls.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // ac.f
    public void a(SSLSocket sSLSocket) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            this.f404e.invoke(null, sSLSocket);
        } catch (IllegalAccessException | InvocationTargetException e10) {
            throw ub.c.b("unable to remove alpn", e10);
        }
    }

    @Override // ac.f
    public void g(SSLSocket sSLSocket, String str, List list) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            this.f402c.invoke(null, sSLSocket, Proxy.newProxyInstance(f.class.getClassLoader(), new Class[]{this.f405f, this.f406g}, new a(f.b(list))));
        } catch (IllegalAccessException | InvocationTargetException e10) {
            throw ub.c.b("unable to set alpn", e10);
        }
    }

    @Override // ac.f
    public String l(SSLSocket sSLSocket) {
        try {
            a aVar = (a) Proxy.getInvocationHandler(this.f403d.invoke(null, sSLSocket));
            boolean z10 = aVar.f408b;
            if (!z10 && aVar.f409c == null) {
                f.j().p(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", null);
                return null;
            }
            if (z10) {
                return null;
            }
            return aVar.f409c;
        } catch (IllegalAccessException e10) {
            e = e10;
            throw ub.c.b("unable to get selected protocol", e);
        } catch (InvocationTargetException e11) {
            e = e11;
            throw ub.c.b("unable to get selected protocol", e);
        }
    }
}
