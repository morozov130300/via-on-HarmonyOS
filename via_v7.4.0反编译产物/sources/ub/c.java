package ub;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.q;
import okhttp3.r;
import okhttp3.x;
import okhttp3.z;
import okio.ByteString;
import okio.e;
import okio.q;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f12935a;

    /* renamed from: c, reason: collision with root package name */
    public static final z f12937c;

    /* renamed from: d, reason: collision with root package name */
    public static final x f12938d;

    /* renamed from: r, reason: collision with root package name */
    public static final Method f12952r;

    /* renamed from: s, reason: collision with root package name */
    public static final Pattern f12953s;

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f12936b = new String[0];

    /* renamed from: e, reason: collision with root package name */
    public static final ByteString f12939e = ByteString.decodeHex("efbbbf");

    /* renamed from: f, reason: collision with root package name */
    public static final ByteString f12940f = ByteString.decodeHex("feff");

    /* renamed from: g, reason: collision with root package name */
    public static final ByteString f12941g = ByteString.decodeHex("fffe");

    /* renamed from: h, reason: collision with root package name */
    public static final ByteString f12942h = ByteString.decodeHex("0000ffff");

    /* renamed from: i, reason: collision with root package name */
    public static final ByteString f12943i = ByteString.decodeHex("ffff0000");

    /* renamed from: j, reason: collision with root package name */
    public static final Charset f12944j = Charset.forName("UTF-8");

    /* renamed from: k, reason: collision with root package name */
    public static final Charset f12945k = Charset.forName("ISO-8859-1");

    /* renamed from: l, reason: collision with root package name */
    public static final Charset f12946l = Charset.forName("UTF-16BE");

    /* renamed from: m, reason: collision with root package name */
    public static final Charset f12947m = Charset.forName("UTF-16LE");

    /* renamed from: n, reason: collision with root package name */
    public static final Charset f12948n = Charset.forName("UTF-32BE");

    /* renamed from: o, reason: collision with root package name */
    public static final Charset f12949o = Charset.forName("UTF-32LE");

    /* renamed from: p, reason: collision with root package name */
    public static final TimeZone f12950p = TimeZone.getTimeZone("GMT");

    /* renamed from: q, reason: collision with root package name */
    public static final Comparator f12951q = new a();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements Comparator {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b implements ThreadFactory {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f12954e;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ boolean f12955j;

        public b(String str, boolean z10) {
            this.f12954e = str;
            this.f12955j = z10;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f12954e);
            thread.setDaemon(this.f12955j);
            return thread;
        }
    }

    static {
        byte[] bArr = new byte[0];
        f12935a = bArr;
        Method declaredMethod = null;
        f12937c = z.h(null, bArr);
        f12938d = x.e(null, bArr);
        try {
            declaredMethod = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception unused) {
        }
        f12952r = declaredMethod;
        f12953s = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    }

    public static boolean A(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static boolean B(Comparator comparator, String[] strArr, String[] strArr2) {
        if (strArr != null && strArr2 != null && strArr.length != 0 && strArr2.length != 0) {
            for (String str : strArr) {
                for (String str2 : strArr2) {
                    if (comparator.compare(str, str2) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static X509TrustManager C() throws NoSuchAlgorithmException, KeyStoreException {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1) {
                TrustManager trustManager = trustManagers[0];
                if (trustManager instanceof X509TrustManager) {
                    return (X509TrustManager) trustManager;
                }
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException e10) {
            throw b("No System TLS", e10);
        }
    }

    public static boolean D(q qVar, int i10, TimeUnit timeUnit) {
        long jNanoTime = System.nanoTime();
        long jC = qVar.e().e() ? qVar.e().c() - jNanoTime : Long.MAX_VALUE;
        qVar.e().d(Math.min(jC, timeUnit.toNanos(i10)) + jNanoTime);
        try {
            okio.c cVar = new okio.c();
            while (qVar.U(cVar, 8192L) != -1) {
                cVar.a();
            }
            if (jC == Long.MAX_VALUE) {
                qVar.e().a();
                return true;
            }
            qVar.e().d(jNanoTime + jC);
            return true;
        } catch (InterruptedIOException unused) {
            if (jC == Long.MAX_VALUE) {
                qVar.e().a();
                return false;
            }
            qVar.e().d(jNanoTime + jC);
            return false;
        } catch (Throwable th) {
            if (jC == Long.MAX_VALUE) {
                qVar.e().a();
            } else {
                qVar.e().d(jNanoTime + jC);
            }
            throw th;
        }
    }

    public static int E(String str, int i10, int i11) {
        while (i10 < i11) {
            char cCharAt = str.charAt(i10);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i10;
            }
            i10++;
        }
        return i11;
    }

    public static int F(String str, int i10, int i11) {
        for (int i12 = i11 - 1; i12 >= i10; i12--) {
            char cCharAt = str.charAt(i12);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i12 + 1;
            }
        }
        return i10;
    }

    public static ThreadFactory G(String str, boolean z10) {
        return new b(str, z10);
    }

    public static okhttp3.q H(List list) {
        q.a aVar = new q.a();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zb.a aVar2 = (zb.a) it.next();
            ub.a.f12933a.b(aVar, aVar2.f14816a.utf8(), aVar2.f14817b.utf8());
        }
        return aVar.d();
    }

    public static String I(String str, int i10, int i11) {
        int iE = E(str, i10, i11);
        return str.substring(iE, F(str, iE, i11));
    }

    public static boolean J(String str) {
        return f12953s.matcher(str).matches();
    }

    public static void a(Throwable th, Throwable th2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = f12952r;
        if (method != null) {
            try {
                method.invoke(th, th2);
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }

    public static AssertionError b(String str, Exception exc) {
        AssertionError assertionError = new AssertionError(str);
        try {
            assertionError.initCause(exc);
        } catch (IllegalStateException unused) {
        }
        return assertionError;
    }

    public static Charset c(e eVar, Charset charset) {
        if (eVar.G(0L, f12939e)) {
            eVar.skip(r0.size());
            return f12944j;
        }
        if (eVar.G(0L, f12940f)) {
            eVar.skip(r0.size());
            return f12946l;
        }
        if (eVar.G(0L, f12941g)) {
            eVar.skip(r0.size());
            return f12947m;
        }
        if (eVar.G(0L, f12942h)) {
            eVar.skip(r0.size());
            return f12948n;
        }
        if (!eVar.G(0L, f12943i)) {
            return charset;
        }
        eVar.skip(r0.size());
        return f12949o;
    }

    public static String d(String str) {
        if (!str.contains(":")) {
            try {
                String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
                if (lowerCase.isEmpty()) {
                    return null;
                }
                if (j(lowerCase)) {
                    return null;
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        InetAddress inetAddressM = (str.startsWith("[") && str.endsWith("]")) ? m(str, 1, str.length() - 1) : m(str, 0, str.length());
        if (inetAddressM == null) {
            return null;
        }
        byte[] address = inetAddressM.getAddress();
        if (address.length == 16) {
            return y(address);
        }
        throw new AssertionError("Invalid IPv6 address: '" + str + "'");
    }

    public static int e(String str, long j10, TimeUnit timeUnit) {
        if (j10 < 0) {
            throw new IllegalArgumentException(str + " < 0");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit == null");
        }
        long millis = timeUnit.toMillis(j10);
        if (millis > 2147483647L) {
            throw new IllegalArgumentException(str + " too large.");
        }
        if (millis != 0 || j10 <= 0) {
            return (int) millis;
        }
        throw new IllegalArgumentException(str + " too small.");
    }

    public static void f(long j10, long j11, long j12) {
        if ((j11 | j12) < 0 || j11 > j10 || j10 - j11 < j12) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static void g(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e10) {
                throw e10;
            } catch (Exception unused) {
            }
        }
    }

    public static void h(Socket socket) throws IOException {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e10) {
                if (!A(e10)) {
                    throw e10;
                }
            } catch (RuntimeException e11) {
                throw e11;
            } catch (Exception unused) {
            }
        }
    }

    public static String[] i(String[] strArr, String str) {
        int length = strArr.length;
        String[] strArr2 = new String[length + 1];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[length] = str;
        return strArr2;
    }

    public static boolean j(String str) {
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt <= 31 || cCharAt >= '\u007f' || " #%/:?@[\\]".indexOf(cCharAt) != -1) {
                return true;
            }
        }
        return false;
    }

    public static int k(char c10) {
        if (c10 >= '0' && c10 <= '9') {
            return c10 - '0';
        }
        if (c10 >= 'a' && c10 <= 'f') {
            return c10 - 'W';
        }
        if (c10 < 'A' || c10 > 'F') {
            return -1;
        }
        return c10 - '7';
    }

    public static boolean l(String str, int i10, int i11, byte[] bArr, int i12) {
        int i13 = i12;
        while (i10 < i11) {
            if (i13 == bArr.length) {
                return false;
            }
            if (i13 != i12) {
                if (str.charAt(i10) != '.') {
                    return false;
                }
                i10++;
            }
            int i14 = i10;
            int i15 = 0;
            while (i14 < i11) {
                char cCharAt = str.charAt(i14);
                if (cCharAt < '0' || cCharAt > '9') {
                    break;
                }
                if ((i15 == 0 && i10 != i14) || (i15 = ((i15 * 10) + cCharAt) - 48) > 255) {
                    return false;
                }
                i14++;
            }
            if (i14 - i10 == 0) {
                return false;
            }
            bArr[i13] = (byte) i15;
            i13++;
            i10 = i14;
        }
        return i13 == i12 + 4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0079, code lost:
    
        if (r4 == 16) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x007b, code lost:
    
        if (r5 != (-1)) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x007d, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x007e, code lost:
    
        r12 = r4 - r5;
        java.lang.System.arraycopy(r1, r5, r1, 16 - r12, r12);
        java.util.Arrays.fill(r1, r5, (16 - r4) + r5, (byte) 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x008e, code lost:
    
        return java.net.InetAddress.getByAddress(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0095, code lost:
    
        throw new java.lang.AssertionError();
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static InetAddress m(String str, int i10, int i11) {
        int i12;
        byte[] bArr = new byte[16];
        int i13 = 0;
        int i14 = -1;
        int i15 = -1;
        while (true) {
            if (i10 < i11) {
                if (i13 != 16) {
                    int i16 = i10 + 2;
                    if (i16 <= i11 && str.regionMatches(i10, "::", 0, 2)) {
                        if (i14 == -1) {
                            i13 += 2;
                            i14 = i13;
                            if (i16 != i11) {
                                i15 = i16;
                                i10 = i15;
                                int i17 = 0;
                                while (i10 < i11) {
                                }
                                i12 = i10 - i15;
                                if (i12 == 0) {
                                    break;
                                }
                                break;
                                break;
                            }
                            break;
                        }
                        return null;
                    }
                    if (i13 != 0) {
                        if (str.regionMatches(i10, ":", 0, 1)) {
                            i10++;
                        } else {
                            if (!str.regionMatches(i10, ".", 0, 1) || !l(str, i15, i11, bArr, i13 - 2)) {
                                return null;
                            }
                            i13 += 2;
                        }
                    }
                    i15 = i10;
                    i10 = i15;
                    int i172 = 0;
                    while (i10 < i11) {
                        int iK = k(str.charAt(i10));
                        if (iK == -1) {
                            break;
                        }
                        i172 = (i172 << 4) + iK;
                        i10++;
                    }
                    i12 = i10 - i15;
                    if (i12 == 0 || i12 > 4) {
                        break;
                    }
                    int i18 = i13 + 1;
                    bArr[i13] = (byte) ((i172 >>> 8) & 255);
                    i13 += 2;
                    bArr[i18] = (byte) (i172 & 255);
                } else {
                    return null;
                }
            } else {
                break;
            }
        }
        return null;
    }

    public static int n(String str, int i10, int i11, char c10) {
        while (i10 < i11) {
            if (str.charAt(i10) == c10) {
                return i10;
            }
            i10++;
        }
        return i11;
    }

    public static int o(String str, int i10, int i11, String str2) {
        while (i10 < i11) {
            if (str2.indexOf(str.charAt(i10)) != -1) {
                return i10;
            }
            i10++;
        }
        return i11;
    }

    public static boolean p(okio.q qVar, int i10, TimeUnit timeUnit) {
        try {
            return D(qVar, i10, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean q(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static String r(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static String s(r rVar, boolean z10) {
        String strL;
        if (rVar.l().contains(":")) {
            strL = "[" + rVar.l() + "]";
        } else {
            strL = rVar.l();
        }
        if (!z10 && rVar.w() == r.d(rVar.A())) {
            return strL;
        }
        return strL + ":" + rVar.w();
    }

    public static List t(List list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static List u(Object... objArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) objArr.clone()));
    }

    public static Map v(Map map) {
        return map.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    public static int w(Comparator comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (comparator.compare(strArr[i10], str) == 0) {
                return i10;
            }
        }
        return -1;
    }

    public static int x(String str) {
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt <= 31 || cCharAt >= '\u007f') {
                return i10;
            }
        }
        return -1;
    }

    public static String y(byte[] bArr) {
        int i10 = -1;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i12 < bArr.length) {
            int i14 = i12;
            while (i14 < 16 && bArr[i14] == 0 && bArr[i14 + 1] == 0) {
                i14 += 2;
            }
            int i15 = i14 - i12;
            if (i15 > i13 && i15 >= 4) {
                i10 = i12;
                i13 = i15;
            }
            i12 = i14 + 2;
        }
        okio.c cVar = new okio.c();
        while (i11 < bArr.length) {
            if (i11 == i10) {
                cVar.writeByte(58);
                i11 += i13;
                if (i11 == 16) {
                    cVar.writeByte(58);
                }
            } else {
                if (i11 > 0) {
                    cVar.writeByte(58);
                }
                cVar.L(((bArr[i11] & 255) << 8) | (bArr[i11 + 1] & 255));
                i11 += 2;
            }
        }
        return cVar.q();
    }

    public static String[] z(Comparator comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    break;
                }
                if (comparator.compare(str, strArr2[i10]) == 0) {
                    arrayList.add(str);
                    break;
                }
                i10++;
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
