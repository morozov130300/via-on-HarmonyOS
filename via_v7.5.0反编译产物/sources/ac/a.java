package ac;

import android.os.Build;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a extends f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Class f292c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f293d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f294e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e f295f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final e f296g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f297h = c.b();

    /* JADX INFO: renamed from: ac.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class C0006a extends cc.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f298a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f299b;

        public C0006a(Object obj, Method method) {
            this.f298a = obj;
            this.f299b = method;
        }

        @Override // cc.c
        public List a(List list, String str) throws SSLPeerUnverifiedException {
            try {
                return (List) this.f299b.invoke(this.f298a, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str);
            } catch (IllegalAccessException e10) {
                throw new AssertionError(e10);
            } catch (InvocationTargetException e11) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e11.getMessage());
                sSLPeerUnverifiedException.initCause(e11);
                throw sSLPeerUnverifiedException;
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof C0006a;
        }

        public int hashCode() {
            return 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b implements cc.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final X509TrustManager f300a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f301b;

        public b(X509TrustManager x509TrustManager, Method method) {
            this.f301b = method;
            this.f300a = x509TrustManager;
        }

        @Override // cc.e
        public X509Certificate a(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f301b.invoke(this.f300a, x509Certificate);
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
            } catch (IllegalAccessException e10) {
                throw ub.c.b("unable to get issues and signature", e10);
            } catch (InvocationTargetException unused) {
            }
            return null;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f300a.equals(bVar.f300a) && this.f301b.equals(bVar.f301b);
        }

        public int hashCode() {
            return this.f300a.hashCode() + (this.f301b.hashCode() * 31);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f302a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f303b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Method f304c;

        public c(Method method, Method method2, Method method3) {
            this.f302a = method;
            this.f303b = method2;
            this.f304c = method3;
        }

        public static c b() throws NoSuchMethodException {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                Method method4 = cls.getMethod("get", null);
                method2 = cls.getMethod("open", String.class);
                method = cls.getMethod("warnIfOpen", null);
                method3 = method4;
            } catch (Exception unused) {
                method = null;
                method2 = null;
            }
            return new c(method3, method2, method);
        }

        public Object a(String str) {
            Method method = this.f302a;
            if (method != null) {
                try {
                    Object objInvoke = method.invoke(null, null);
                    this.f303b.invoke(objInvoke, str);
                    return objInvoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        public boolean c(Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                this.f304c.invoke(obj, null);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    public a(Class cls, e eVar, e eVar2, e eVar3, e eVar4) {
        this.f292c = cls;
        this.f293d = eVar;
        this.f294e = eVar2;
        this.f295f = eVar3;
        this.f296g = eVar4;
    }

    public static f t() {
        Class<?> cls;
        e eVar;
        e eVar2;
        try {
            try {
                cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            } catch (ClassNotFoundException unused) {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            }
            Class<?> cls2 = cls;
            e eVar3 = new e(null, "setUseSessionTickets", Boolean.TYPE);
            e eVar4 = new e(null, "setHostname", String.class);
            if (u()) {
                e eVar5 = new e(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                eVar2 = new e(null, "setAlpnProtocols", byte[].class);
                eVar = eVar5;
            } else {
                eVar = null;
                eVar2 = null;
            }
            return new a(cls2, eVar3, eVar4, eVar, eVar2);
        } catch (ClassNotFoundException unused2) {
            return null;
        }
    }

    public static boolean u() {
        if (Security.getProvider("GMSCore_OpenSSL") != null) {
            return true;
        }
        try {
            Class.forName("android.net.Network");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @Override // ac.f
    public cc.c c(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new C0006a(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
        } catch (Exception unused) {
            return super.c(x509TrustManager);
        }
    }

    @Override // ac.f
    public cc.e d(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new b(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.d(x509TrustManager);
        }
    }

    @Override // ac.f
    public void g(SSLSocket sSLSocket, String str, List list) {
        if (str != null) {
            this.f293d.e(sSLSocket, Boolean.TRUE);
            this.f294e.e(sSLSocket, str);
        }
        e eVar = this.f296g;
        if (eVar == null || !eVar.g(sSLSocket)) {
            return;
        }
        this.f296g.f(sSLSocket, f.e(list));
    }

    @Override // ac.f
    public void h(Socket socket, InetSocketAddress inetSocketAddress, int i10) throws IOException {
        try {
            socket.connect(inetSocketAddress, i10);
        } catch (AssertionError e10) {
            if (!ub.c.A(e10)) {
                throw e10;
            }
            throw new IOException(e10);
        } catch (ClassCastException e11) {
            if (Build.VERSION.SDK_INT != 26) {
                throw e11;
            }
            IOException iOException = new IOException("Exception in connect");
            iOException.initCause(e11);
            throw iOException;
        } catch (SecurityException e12) {
            IOException iOException2 = new IOException("Exception in connect");
            iOException2.initCause(e12);
            throw iOException2;
        }
    }

    @Override // ac.f
    public SSLContext k() {
        try {
            if (Build.VERSION.SDK_INT < 22) {
                try {
                    return SSLContext.getInstance("TLSv1.2");
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            try {
                return SSLContext.getInstance("TLS");
            } catch (NoSuchAlgorithmException e10) {
                throw new IllegalStateException("No TLS provider", e10);
            }
        } catch (NoClassDefFoundError unused2) {
        }
    }

    @Override // ac.f
    public String l(SSLSocket sSLSocket) {
        byte[] bArr;
        e eVar = this.f295f;
        if (eVar == null || !eVar.g(sSLSocket) || (bArr = (byte[]) this.f295f.f(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, ub.c.f12954j);
    }

    @Override // ac.f
    public Object m(String str) {
        return this.f297h.a(str);
    }

    @Override // ac.f
    public boolean n(String str) {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return s(str, cls, cls.getMethod("getInstance", null).invoke(null, null));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.n(str);
        } catch (IllegalAccessException e10) {
            e = e10;
            throw ub.c.b("unable to determine cleartext support", e);
        } catch (IllegalArgumentException e11) {
            e = e11;
            throw ub.c.b("unable to determine cleartext support", e);
        } catch (InvocationTargetException e12) {
            e = e12;
            throw ub.c.b("unable to determine cleartext support", e);
        }
    }

    @Override // ac.f
    public void p(int i10, String str, Throwable th) {
        int iMin;
        int i11 = i10 != 5 ? 3 : 5;
        if (th != null) {
            str = str + '\n' + Log.getStackTraceString(th);
        }
        int length = str.length();
        int i12 = 0;
        while (i12 < length) {
            int iIndexOf = str.indexOf(10, i12);
            if (iIndexOf == -1) {
                iIndexOf = length;
            }
            while (true) {
                iMin = Math.min(iIndexOf, i12 + 4000);
                Log.println(i11, "OkHttp", str.substring(i12, iMin));
                if (iMin >= iIndexOf) {
                    break;
                } else {
                    i12 = iMin;
                }
            }
            i12 = iMin + 1;
        }
    }

    @Override // ac.f
    public void q(String str, Object obj) {
        if (this.f297h.c(obj)) {
            return;
        }
        p(5, str, null);
    }

    public final boolean r(String str, Class cls, Object obj) {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", null).invoke(obj, null)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.n(str);
        }
    }

    public final boolean s(String str, Class cls, Object obj) {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return r(str, cls, obj);
        }
    }
}
