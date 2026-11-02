package z8;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a4 {

    /* renamed from: a, reason: collision with root package name */
    public final Context f14673a;

    /* renamed from: b, reason: collision with root package name */
    public final Activity f14674b;

    /* renamed from: c, reason: collision with root package name */
    public w5.k f14675c;

    /* renamed from: d, reason: collision with root package name */
    public b f14676d;

    /* renamed from: f, reason: collision with root package name */
    public HttpURLConnection f14678f;

    /* renamed from: e, reason: collision with root package name */
    public int f14677e = 0;

    /* renamed from: g, reason: collision with root package name */
    public final Handler f14679g = new Handler();

    /* renamed from: h, reason: collision with root package name */
    public final Runnable f14680h = new a();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a4.this.f14675c.r()) {
                a4.e(a4.this);
                if (a4.this.f14677e < 5) {
                    a4.this.f14679g.postDelayed(this, 1000L);
                    return;
                }
                if (a4.this.f14678f != null) {
                    a4.this.f14678f.disconnect();
                }
                h.c(a4.this.f14674b, new Runnable() { // from class: z8.z3
                    @Override // java.lang.Runnable
                    public final void run() {
                        a4.this.m(2);
                    }
                });
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface b {
        void a();
    }

    public a4(Context context) {
        this.f14673a = context;
        this.f14674b = (Activity) context;
        j();
    }

    public static /* synthetic */ void a(final a4 a4Var, Map map, String str) {
        a4Var.getClass();
        byte[] bytes = k(map).toString().getBytes(m8.a.f8676a);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            a4Var.f14678f = httpURLConnection;
            httpURLConnection.setConnectTimeout(3000);
            a4Var.f14678f.setDoInput(true);
            a4Var.f14678f.setDoOutput(true);
            a4Var.f14678f.setRequestMethod("POST");
            a4Var.f14678f.setUseCaches(false);
            a4Var.f14678f.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            a4Var.f14678f.setRequestProperty("Content-Length", String.valueOf(bytes.length));
            a4Var.f14678f.getOutputStream().write(bytes);
            int responseCode = a4Var.f14678f.getResponseCode();
            pc.a.a("Response: %d", Integer.valueOf(responseCode));
            final int i10 = responseCode == 200 ? 0 : 1;
            h.c(a4Var.f14674b, new Runnable() { // from class: z8.y3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f14792e.m(i10);
                }
            });
            HttpURLConnection httpURLConnection2 = a4Var.f14678f;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
        } catch (IOException unused) {
            HttpURLConnection httpURLConnection3 = a4Var.f14678f;
            if (httpURLConnection3 != null) {
                httpURLConnection3.disconnect();
            }
        } catch (Throwable th) {
            HttpURLConnection httpURLConnection4 = a4Var.f14678f;
            if (httpURLConnection4 != null) {
                httpURLConnection4.disconnect();
            }
            throw th;
        }
    }

    public static /* synthetic */ int e(a4 a4Var) {
        int i10 = a4Var.f14677e;
        a4Var.f14677e = i10 + 1;
        return i10;
    }

    public static StringBuffer k(Map map) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            for (Map.Entry entry : map.entrySet()) {
                stringBuffer.append((String) entry.getKey());
                stringBuffer.append("=");
                stringBuffer.append((String) entry.getValue());
                stringBuffer.append("&");
            }
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            return stringBuffer;
        } catch (Exception e10) {
            e10.printStackTrace();
            return stringBuffer;
        }
    }

    public final void j() {
        this.f14675c = w5.k.l(this.f14673a).X(x7.u.Nh).t(false).u(false);
    }

    public void l(b bVar) {
        this.f14676d = bVar;
    }

    public final void m(int i10) {
        this.f14675c.n();
        if (i10 != 0) {
            if (i10 != 2) {
                g6.n.m(this.f14674b, this.f14673a.getResources().getString(x7.u.f14193v3), this.f14673a.getResources().getString(x7.u.f14113p2));
                return;
            } else {
                g6.n.m(this.f14674b, this.f14673a.getResources().getString(x7.u.f14193v3), this.f14673a.getResources().getString(x7.u.f14192v2));
                return;
            }
        }
        b bVar = this.f14676d;
        if (bVar != null) {
            bVar.a();
        } else {
            g6.n.m(this.f14674b, this.f14673a.getResources().getString(x7.u.f14193v3), this.f14673a.getResources().getString(x7.u.lh));
        }
    }

    public final void n(final String str, final Map map) {
        h.b(new Runnable() { // from class: z8.x3
            @Override // java.lang.Runnable
            public final void run() {
                a4.a(this.f14787e, map, str);
            }
        });
    }

    public void o(String str, Map map) {
        if (b0.B(this.f14673a) != 0) {
            this.f14675c.f0();
            this.f14679g.postDelayed(this.f14680h, 1000L);
            n(str, map);
        }
    }
}
