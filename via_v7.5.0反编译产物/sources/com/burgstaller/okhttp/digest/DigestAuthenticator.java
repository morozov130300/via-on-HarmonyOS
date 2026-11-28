package com.burgstaller.okhttp.digest;

import ac.f;
import com.burgstaller.okhttp.digest.fromhttpclient.BasicNameValuePair;
import com.burgstaller.okhttp.digest.fromhttpclient.UnsupportedDigestAlgorithmException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import okhttp3.a0;
import okhttp3.q;
import okhttp3.w;
import okhttp3.y;
import xb.i;
import y0.a;
import y0.b;
import z0.c;
import z0.d;
import z0.e;
import z0.g;
import z0.h;
import z0.j;
import z0.k;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class DigestAuthenticator implements a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final char[] f2493k = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AtomicReference f2494b = new AtomicReference();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Charset f2495c = Charset.forName("ASCII");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f2496d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f2497e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f2498f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f2499g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f2500h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f2501i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f2502j;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class AuthenticationException extends IllegalStateException {
        public AuthenticationException(String str) {
            super(str);
        }

        public AuthenticationException(String str, Exception exc) {
            super(str, exc);
        }
    }

    public DigestAuthenticator(b bVar) {
        this.f2496d = bVar;
    }

    public static String d() {
        byte[] bArr = new byte[8];
        new SecureRandom().nextBytes(bArr);
        return g(bArr);
    }

    public static MessageDigest f(String str) {
        try {
            return MessageDigest.getInstance(str);
        } catch (Exception e10) {
            throw new IllegalArgumentException("Unsupported algorithm in HTTP Digest authentication: " + str, e10);
        }
    }

    public static String g(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length * 2];
        for (int i10 = 0; i10 < length; i10++) {
            byte b10 = bArr[i10];
            int i11 = i10 * 2;
            char[] cArr2 = f2493k;
            cArr[i11] = cArr2[(b10 & 240) >> 4];
            cArr[i11 + 1] = cArr2[b10 & 15];
        }
        return new String(cArr);
    }

    public static byte[] i(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Parameter may not be null");
        }
        try {
            return str.getBytes("US-ASCII");
        } catch (UnsupportedEncodingException e10) {
            throw new Error("HttpClient requires ASCII support", e10);
        }
    }

    @Override // okhttp3.b
    public synchronized w a(a0 a0Var, y yVar) {
        ConcurrentHashMap concurrentHashMap;
        String strH = h(yVar.h(), m(yVar.c()));
        concurrentHashMap = new ConcurrentHashMap();
        p(strH, 7, strH.length() - 7, concurrentHashMap);
        c(yVar.h(), concurrentHashMap);
        this.f2494b.set(Collections.unmodifiableMap(concurrentHashMap));
        if (concurrentHashMap.get("nonce") == null) {
            throw new IllegalArgumentException("missing nonce in challenge header: " + strH);
        }
        return b(a0Var, yVar.o(), concurrentHashMap);
    }

    public final w b(a0 a0Var, w wVar, Map map) {
        if (((String) map.get("realm")) == null) {
            return null;
        }
        String str = (String) map.get("nonce");
        if (str == null) {
            throw new IllegalArgumentException("missing nonce in challenge");
        }
        if (n(wVar, str, "true".equalsIgnoreCase((String) map.get("stale")))) {
            f.j().p(5, "previous digest authentication with same nonce failed, returning null", null);
            return null;
        }
        if (a0Var == null || !a0Var.c()) {
            String strF = wVar.f();
            String strC = i.c(wVar.h());
            map.put("methodname", strF);
            map.put("uri", strC);
        } else {
            String str2 = wVar.h().l() + ':' + wVar.h().x();
            map.put("methodname", "CONNECT");
            map.put("uri", str2);
        }
        if (((String) map.get("charset")) == null) {
            map.put("charset", k(wVar));
        }
        j jVarE = e(this.f2496d, wVar, map);
        return wVar.g().d(jVarE.getName(), jVarE.getValue()).b();
    }

    public final void c(q qVar, Map map) {
        for (int i10 = 0; i10 < qVar.j(); i10++) {
            map.put(qVar.e(i10), qVar.k(i10));
        }
    }

    public final synchronized j e(b bVar, w wVar, Map map) {
        byte b10;
        String string;
        StringBuilder sb2;
        String str;
        try {
            String str2 = (String) map.get("uri");
            String str3 = (String) map.get("realm");
            String str4 = (String) map.get("nonce");
            String str5 = (String) map.get("opaque");
            String str6 = (String) map.get("methodname");
            String str7 = (String) map.get("algorithm");
            if (str7 == null) {
                str7 = "MD5";
            }
            HashSet hashSet = new HashSet(8);
            String str8 = (String) map.get("qop");
            if (str8 != null) {
                StringTokenizer stringTokenizer = new StringTokenizer(str8, ",");
                while (stringTokenizer.hasMoreTokens()) {
                    hashSet.add(stringTokenizer.nextToken().trim().toLowerCase(Locale.US));
                }
                b10 = (wVar.a() == null || !hashSet.contains("auth-int")) ? hashSet.contains("auth") ? (byte) 2 : (byte) -1 : (byte) 1;
            } else {
                b10 = 0;
            }
            if (b10 == -1) {
                throw new AuthenticationException("None of the qop methods is supported: " + str8);
            }
            String str9 = (String) map.get("charset");
            if (str9 == null) {
                str9 = "ISO-8859-1";
            }
            String str10 = "MD5-sess".equalsIgnoreCase(str7) ? "MD5" : str7;
            try {
                MessageDigest messageDigestF = f(str10);
                String strB = bVar.b();
                String strA = bVar.a();
                if (str4.equals(this.f2497e)) {
                    this.f2498f++;
                } else {
                    this.f2498f = 1L;
                    this.f2499g = null;
                    this.f2497e = str4;
                }
                StringBuilder sb3 = new StringBuilder(256);
                Formatter formatter = new Formatter(sb3, Locale.US);
                formatter.format("%08x", Long.valueOf(this.f2498f));
                formatter.close();
                String string2 = sb3.toString();
                if (this.f2499g == null) {
                    this.f2499g = d();
                }
                this.f2500h = null;
                this.f2501i = null;
                if ("MD5-sess".equalsIgnoreCase(str7)) {
                    sb3.setLength(0);
                    sb3.append(strB);
                    sb3.append(':');
                    sb3.append(str3);
                    sb3.append(':');
                    sb3.append(strA);
                    String strG = g(messageDigestF.digest(j(sb3.toString(), str9)));
                    sb3.setLength(0);
                    sb3.append(strG);
                    sb3.append(':');
                    sb3.append(str4);
                    sb3.append(':');
                    sb3.append(this.f2499g);
                    this.f2500h = sb3.toString();
                } else {
                    sb3.setLength(0);
                    sb3.append(strB);
                    sb3.append(':');
                    sb3.append(str3);
                    sb3.append(':');
                    sb3.append(strA);
                    this.f2500h = sb3.toString();
                }
                String strG2 = g(messageDigestF.digest(j(this.f2500h, str9)));
                if (b10 == 2) {
                    this.f2501i = str6 + ':' + str2;
                } else if (b10 != 1) {
                    this.f2501i = str6 + ':' + str2;
                } else if (wVar.a() == null) {
                    h hVar = new h(messageDigestF);
                    try {
                        hVar.close();
                        this.f2501i = str6 + ':' + str2 + ':' + g(hVar.a());
                    } catch (IOException e10) {
                        throw new AuthenticationException("I/O error reading entity content", e10);
                    }
                } else {
                    if (!hashSet.contains("auth")) {
                        throw new AuthenticationException("Qop auth-int cannot be used with a non-repeatable entity");
                    }
                    this.f2501i = str6 + ':' + str2;
                    b10 = 2;
                }
                String strG3 = g(messageDigestF.digest(j(this.f2501i, str9)));
                if (b10 == 0) {
                    sb3.setLength(0);
                    sb3.append(strG2);
                    sb3.append(':');
                    sb3.append(str4);
                    sb3.append(':');
                    sb3.append(strG3);
                    string = sb3.toString();
                } else {
                    sb3.setLength(0);
                    sb3.append(strG2);
                    sb3.append(':');
                    sb3.append(str4);
                    sb3.append(':');
                    sb3.append(string2);
                    sb3.append(':');
                    sb3.append(this.f2499g);
                    sb3.append(':');
                    sb3.append(b10 == 1 ? "auth-int" : "auth");
                    sb3.append(':');
                    sb3.append(strG3);
                    string = sb3.toString();
                }
                String strG4 = g(messageDigestF.digest(i(string)));
                sb2 = new StringBuilder(128);
                str = o() ? "Proxy-Authorization" : "Authorization";
                sb2.append("Digest ");
                ArrayList arrayList = new ArrayList(20);
                arrayList.add(new BasicNameValuePair("username", strB));
                arrayList.add(new BasicNameValuePair("realm", str3));
                arrayList.add(new BasicNameValuePair("nonce", str4));
                arrayList.add(new BasicNameValuePair("uri", str2));
                arrayList.add(new BasicNameValuePair("response", strG4));
                if (b10 != 0) {
                    arrayList.add(new BasicNameValuePair("qop", b10 == 1 ? "auth-int" : "auth"));
                    arrayList.add(new BasicNameValuePair("nc", string2));
                    arrayList.add(new BasicNameValuePair("cnonce", this.f2499g));
                }
                arrayList.add(new BasicNameValuePair("algorithm", str7));
                if (str5 != null) {
                    arrayList.add(new BasicNameValuePair("opaque", str5));
                }
                for (int i10 = 0; i10 < arrayList.size(); i10++) {
                    j jVar = (j) arrayList.get(i10);
                    if (i10 > 0) {
                        sb2.append(", ");
                    }
                    String name = jVar.getName();
                    c.f15118a.b(sb2, jVar, !("nc".equals(name) || "qop".equals(name) || "algorithm".equals(name)));
                }
            } catch (UnsupportedDigestAlgorithmException e11) {
                throw new AuthenticationException("Unsuppported digest algorithm: " + str10, e11);
            }
        } catch (Throwable th) {
            throw th;
        }
        return new BasicNameValuePair(str, sb2.toString());
    }

    public final String h(q qVar, String str) {
        List<String> listL = qVar.l(str);
        for (String str2 : listL) {
            if (str2.startsWith("Digest")) {
                return str2;
            }
        }
        throw new IllegalArgumentException("unsupported auth scheme: " + listL);
    }

    public final byte[] j(String str, String str2) {
        try {
            return str.getBytes(str2);
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes();
        }
    }

    public String k(w wVar) {
        String strC = wVar.c("http.auth.credential-charset");
        return strC == null ? l().name() : strC;
    }

    public Charset l() {
        return this.f2495c;
    }

    public final String m(int i10) {
        if (i10 == 401) {
            q(false);
            return "WWW-Authenticate";
        }
        if (i10 != 407) {
            return "";
        }
        q(true);
        return "Proxy-Authenticate";
    }

    public final boolean n(w wVar, String str, boolean z10) {
        String strC = wVar.c(o() ? "Proxy-Authorization" : "Authorization");
        if (strC == null || !strC.startsWith("Digest")) {
            return false;
        }
        return !z10;
    }

    public boolean o() {
        return this.f2502j;
    }

    public void p(String str, int i10, int i11, Map map) {
        d dVar = d.f15120b;
        k kVar = new k(i10, str.length());
        e eVar = new e(i11);
        eVar.a(str);
        g[] gVarArrD = dVar.d(eVar, kVar);
        if (gVarArrD.length == 0) {
            throw new IllegalArgumentException("Authentication challenge is empty");
        }
        for (g gVar : gVarArrD) {
            map.put(gVar.getName(), gVar.getValue());
        }
    }

    public void q(boolean z10) {
        this.f2502j = z10;
    }
}
