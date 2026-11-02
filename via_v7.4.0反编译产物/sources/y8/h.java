package y8;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import g6.n;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import mark.via.Shell;
import mark.via.download.i1;
import org.json.JSONException;
import org.json.JSONObject;
import pa.r;
import w5.k;
import x7.u;
import z8.b1;
import z8.c0;
import z8.c1;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f14498a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static volatile a f14499b;

    /* renamed from: c, reason: collision with root package name */
    public static volatile boolean f14500c;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public long f14501a = -1;

        /* renamed from: b, reason: collision with root package name */
        public int f14502b = 0;

        /* renamed from: c, reason: collision with root package name */
        public String f14503c;

        /* renamed from: d, reason: collision with root package name */
        public String f14504d;

        /* renamed from: e, reason: collision with root package name */
        public String f14505e;

        public String d() {
            return this.f14503c;
        }

        public String e() {
            return this.f14504d;
        }

        public String f() {
            return this.f14505e;
        }

        public long g() {
            return this.f14501a;
        }

        public int h() {
            return this.f14502b;
        }

        public boolean i() {
            String str;
            String str2;
            String str3;
            return (this.f14502b <= 20260920 || (str = this.f14504d) == null || str.isEmpty() || (str2 = this.f14503c) == null || str2.isEmpty() || (str3 = this.f14505e) == null || str3.isEmpty()) ? false : true;
        }

        public final boolean j(a aVar) {
            return aVar != null && this.f14502b == aVar.h() && this.f14504d.equals(aVar.e()) && this.f14505e.equalsIgnoreCase(aVar.f());
        }

        public final boolean k(g5.c cVar) {
            return cVar != null && this.f14501a == cVar.j() && this.f14504d.equals(cVar.t());
        }

        public void l(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f14501a = jSONObject.optLong("task_id", -1L);
                this.f14502b = jSONObject.optInt("version", 0);
                this.f14503c = jSONObject.optString("changelog");
                this.f14504d = jSONObject.optString("url");
                this.f14505e = jSONObject.optString("md5");
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }

        public void m(long j10) {
            this.f14501a = j10;
        }

        public final JSONObject n() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("task_id", this.f14501a);
            jSONObject.put("version", this.f14502b);
            jSONObject.put("url", this.f14504d);
            jSONObject.put("md5", this.f14505e);
            jSONObject.put("changelog", this.f14503c);
            return jSONObject;
        }

        public String toString() {
            return "UpdateConfig{taskId=" + this.f14501a + ", versionCode=" + this.f14502b + ", changelog='" + this.f14503c + "', downloadUrl='" + this.f14504d + "', md5='" + this.f14505e + "'}";
        }
    }

    public static /* synthetic */ void a(Uri uri, Activity activity, View view, k.p pVar) {
        Intent intent = new Intent("android.intent.action.INSTALL_PACKAGE");
        intent.addFlags(268435456);
        intent.addFlags(1);
        intent.setDataAndType(uri, "application/vnd.android.package-archive");
        try {
            activity.startActivity(intent);
        } catch (Exception unused) {
        }
    }

    public static /* synthetic */ void f(Activity activity, View view) {
        Intent intent = new Intent(activity, (Class<?>) Shell.class);
        intent.setAction("mark.via.DOWNLOADER");
        activity.startActivity(intent);
    }

    public static void h(final Activity activity, final a aVar) {
        if (aVar == null || activity == null || !aVar.i()) {
            n.q(activity, u.f14236y7);
        } else {
            k.l(activity).d0(u.I8).J(aVar.d()).u(false).V(u.A, new k.m() { // from class: y8.b
                @Override // w5.k.m
                public final void a(View view, k.p pVar) {
                    z8.h.b(new Runnable() { // from class: y8.c
                        @Override // java.lang.Runnable
                        public final void run() throws IOException {
                            h.j(activity, aVar);
                        }
                    });
                }
            }).N(R.string.cancel, null).f0();
        }
    }

    public static String i(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b10 : bArr) {
            String hexString = Integer.toHexString(b10 & 255);
            if (hexString.length() < 2) {
                sb2.append(0);
            }
            sb2.append(hexString);
        }
        return sb2.toString();
    }

    public static void j(final Activity activity, a aVar) throws IOException {
        if (aVar == null || !aVar.i()) {
            return;
        }
        c5.b bVarR = c5.b.r(activity);
        g5.c cVarL = l(activity, bVarR, aVar);
        if (cVarL != null) {
            if (g5.b.c(cVarL.q())) {
                mark.via.download.a.c(activity, cVarL.j());
            }
            v(activity);
            return;
        }
        String strX = r.j().x();
        g5.c cVar = new g5.c();
        cVar.J("via_" + aVar.h() + ".apk");
        cVar.K(strX);
        cVar.S(aVar.e());
        cVar.N(true);
        cVar.I("application/vnd.android.package-archive");
        cVar.P(90);
        cVar.x(2);
        final int iH = i1.h(activity, cVar, strX);
        long j10 = (iH == 2 || iH == 3) ? 0L : bVarR.j(cVar);
        if (j10 <= 0) {
            activity.runOnUiThread(new Runnable() { // from class: y8.d
                @Override // java.lang.Runnable
                public final void run() {
                    n.q(activity, iH == 3 ? u.dg : u.R3);
                }
            });
            return;
        }
        if (u(activity, j10, aVar)) {
            mark.via.download.a.c(activity, j10);
            v(activity);
        } else {
            cVar.P(200);
            cVar.A("Unable to save update metadata");
            bVarR.b(cVar);
            activity.runOnUiThread(new Runnable() { // from class: y8.e
                @Override // java.lang.Runnable
                public final void run() {
                    n.q(activity, u.R3);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0097 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static a k() throws Throwable {
        BufferedReader bufferedReader;
        a aVar = new a();
        HttpURLConnection httpURLConnection = null;
        BufferedReader bufferedReader2 = null;
        httpURLConnection = null;
        try {
            try {
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(c0.i() ? "https://res.viayoo.com/v1/latest_play.json" : "https://res.viayoo.com/v1/latest_cn.json").openConnection();
                try {
                    httpURLConnection2.setRequestMethod("GET");
                    httpURLConnection2.setRequestProperty("Accept", "*/*");
                    httpURLConnection2.setRequestProperty("Charset", "UTF-8");
                    httpURLConnection2.setRequestProperty("Connection", "Keep-Alive");
                    if (httpURLConnection2.getResponseCode() == 200) {
                        StringBuilder sb2 = new StringBuilder();
                        bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection2.getInputStream(), "UTF-8"));
                        while (true) {
                            try {
                                String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                }
                                sb2.append(line);
                            } catch (Exception e10) {
                                e = e10;
                                httpURLConnection = httpURLConnection2;
                                try {
                                    pc.a.d(e);
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                    if (bufferedReader != null) {
                                        bufferedReader.close();
                                    }
                                    return aVar;
                                } catch (Throwable th) {
                                    th = th;
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (Exception unused) {
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                httpURLConnection = httpURLConnection2;
                                if (httpURLConnection != null) {
                                }
                                if (bufferedReader != null) {
                                }
                                throw th;
                            }
                        }
                        aVar.l(sb2.toString());
                        bufferedReader2 = bufferedReader;
                    }
                    httpURLConnection2.disconnect();
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                        return aVar;
                    }
                } catch (Exception e11) {
                    e = e11;
                    bufferedReader = null;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                }
            } catch (Exception unused2) {
            }
        } catch (Exception e12) {
            e = e12;
            bufferedReader = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
        }
        return aVar;
    }

    public static g5.c l(Context context, c5.a aVar, a aVar2) {
        a aVarT = t(context);
        if (aVarT != null && aVarT.j(aVar2)) {
            g5.c cVarH = aVar.h(aVarT.g());
            if (aVarT.k(cVarH) && q(cVarH)) {
                if (g5.b.d(cVarH.q()) || g5.b.c(cVarH.q())) {
                    return cVarH;
                }
                return null;
            }
        }
        return null;
    }

    public static String m(Context context, Uri uri) throws IOException {
        if (context != null && uri != null) {
            byte[] bArr = new byte[8192];
            try {
                InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                if (inputStreamOpenInputStream == null) {
                    if (inputStreamOpenInputStream == null) {
                        return null;
                    }
                    inputStreamOpenInputStream.close();
                    return null;
                }
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    while (true) {
                        int i10 = inputStreamOpenInputStream.read(bArr);
                        if (i10 == -1) {
                            String strI = i(messageDigest.digest());
                            inputStreamOpenInputStream.close();
                            return strI;
                        }
                        messageDigest.update(bArr, 0, i10);
                    }
                } finally {
                }
            } catch (Exception e10) {
                pc.a.i(e10);
            }
        }
        return null;
    }

    public static g5.c n(Context context, a aVar) {
        a aVarT;
        if (context != null && aVar != null && (aVarT = t(context)) != null && aVarT.j(aVar)) {
            g5.c cVarH = c5.b.r(context).h(aVarT.g());
            if (aVarT.k(cVarH) && g5.b.e(cVarH.q())) {
                if (x(context, cVarH.f(), aVarT.f())) {
                    return cVarH;
                }
                r(context, cVarH);
            }
        }
        return null;
    }

    public static File o(Context context) {
        String strK = c1.k(context.getApplicationContext(), "update", "update.json");
        if (strK == null) {
            return null;
        }
        return new File(strK);
    }

    public static a p(Context context, g5.c cVar) {
        a aVarT;
        if (context == null || cVar == null || (aVarT = t(context)) == null || !aVarT.k(cVar)) {
            return null;
        }
        return aVarT;
    }

    public static boolean q(g5.c cVar) {
        return cVar != null && (System.currentTimeMillis() / 1000) - cVar.b() <= 86400;
    }

    public static void r(Context context, g5.c cVar) {
        cVar.P(200);
        cVar.A("Update package checksum mismatch");
        c5.b.r(context).b(cVar);
    }

    public static void s(Context context, g5.c cVar) {
        if (context == null || cVar == null) {
            return;
        }
        r(context, cVar);
    }

    public static a t(Context context) {
        if (f14500c) {
            return f14499b;
        }
        if (context == null) {
            return null;
        }
        synchronized (f14498a) {
            try {
                if (f14500c) {
                    return f14499b;
                }
                File fileO = o(context);
                if (fileO == null || !fileO.isFile()) {
                    f14500c = true;
                    return null;
                }
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileO), "UTF-8"));
                    try {
                        StringBuilder sb2 = new StringBuilder();
                        while (true) {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            sb2.append(line);
                        }
                        a aVar = new a();
                        aVar.l(sb2.toString());
                        if (aVar.g() > 0 && aVar.i()) {
                            f14499b = aVar;
                        }
                        bufferedReader.close();
                    } finally {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th) {
                            th.addSuppressed(th);
                        }
                    }
                } catch (Exception e10) {
                    pc.a.i(e10);
                }
                f14500c = true;
                return f14499b;
            } finally {
            }
        }
    }

    public static boolean u(Context context, long j10, a aVar) {
        try {
            File fileO = o(context);
            if (fileO == null) {
                return false;
            }
            aVar.m(j10);
            synchronized (f14498a) {
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(fileO), "UTF-8");
                try {
                    outputStreamWriter.write(aVar.n().toString());
                    outputStreamWriter.close();
                    f14499b = aVar;
                    f14500c = true;
                } finally {
                }
            }
            return true;
        } catch (Exception e10) {
            pc.a.i(e10);
            return false;
        }
    }

    public static void v(final Activity activity) {
        activity.runOnUiThread(new Runnable() { // from class: y8.f
            @Override // java.lang.Runnable
            public final void run() {
                Activity activity2 = activity;
                n.r(activity2, u.f13919b4, u.Jh, new View.OnClickListener() { // from class: y8.g
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        h.f(activity2, view);
                    }
                });
            }
        });
    }

    public static void w(final Activity activity, a aVar, final Uri uri) {
        if (activity == null || uri == null || !b1.p(activity, uri) || aVar == null || !aVar.i()) {
            return;
        }
        k.l(activity).d0(u.I8).J(aVar.d()).u(false).V(u.f13936c7, new k.m() { // from class: y8.a
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                h.a(uri, activity, view, pVar);
            }
        }).N(R.string.cancel, null).f0();
    }

    public static boolean x(Context context, Uri uri, String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return str.equalsIgnoreCase(m(context, uri));
    }

    public static boolean y(Context context, g5.c cVar, a aVar) {
        return (cVar == null || aVar == null || !x(context, cVar.f(), aVar.f())) ? false : true;
    }
}
