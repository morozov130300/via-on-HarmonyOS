package z8;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class u0 {

    /* renamed from: a, reason: collision with root package name */
    public final Context f14762a;

    /* renamed from: b, reason: collision with root package name */
    public final Activity f14763b;

    /* renamed from: c, reason: collision with root package name */
    public w5.k f14764c;

    /* renamed from: d, reason: collision with root package name */
    public b f14765d;

    /* renamed from: f, reason: collision with root package name */
    public HttpURLConnection f14767f;

    /* renamed from: g, reason: collision with root package name */
    public int f14768g;

    /* renamed from: h, reason: collision with root package name */
    public String f14769h;

    /* renamed from: e, reason: collision with root package name */
    public int f14766e = 0;

    /* renamed from: j, reason: collision with root package name */
    public final Handler f14771j = new Handler();

    /* renamed from: k, reason: collision with root package name */
    public final Runnable f14772k = new a();

    /* renamed from: i, reason: collision with root package name */
    public boolean f14770i = true;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (u0.this.f14770i && u0.this.f14764c.r()) {
                u0.h(u0.this);
                if (u0.this.f14766e < u0.this.f14768g) {
                    u0.this.f14771j.postDelayed(this, 1000L);
                    return;
                }
                if (u0.this.f14767f != null) {
                    u0.this.f14767f.disconnect();
                }
                h.c(u0.this.f14763b, new Runnable() { // from class: z8.t0
                    @Override // java.lang.Runnable
                    public final void run() {
                        u0.this.r(113);
                    }
                });
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface b {
        void a(String str);
    }

    public u0(Context context) {
        this.f14762a = context;
        this.f14763b = (Activity) context;
        o();
        this.f14768g = 8;
    }

    public static /* synthetic */ void b(final u0 u0Var, String str) {
        u0Var.getClass();
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                u0Var.f14767f = httpURLConnection;
                httpURLConnection.setRequestMethod("GET");
                u0Var.f14767f.setReadTimeout((u0Var.f14768g - 1) * 1000);
                if (u0Var.f14767f.getResponseCode() == 200) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(u0Var.f14767f.getInputStream(), m8.a.f8676a));
                    StringBuilder sb2 = new StringBuilder();
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        } else {
                            sb2.append(line);
                        }
                    }
                    bufferedReader.close();
                    u0Var.f14769h = new String(sb2.toString().getBytes(m8.a.f8676a), m8.a.f8677b);
                    h.c(u0Var.f14763b, new Runnable() { // from class: z8.r0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f14749e.r(111);
                        }
                    });
                } else {
                    h.c(u0Var.f14763b, new Runnable() { // from class: z8.s0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f14752e.r(112);
                        }
                    });
                }
                HttpURLConnection httpURLConnection2 = u0Var.f14767f;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            } catch (Exception e10) {
                e10.printStackTrace();
                HttpURLConnection httpURLConnection3 = u0Var.f14767f;
                if (httpURLConnection3 != null) {
                    httpURLConnection3.disconnect();
                }
            }
        } catch (Throwable th) {
            HttpURLConnection httpURLConnection4 = u0Var.f14767f;
            if (httpURLConnection4 != null) {
                httpURLConnection4.disconnect();
            }
            throw th;
        }
    }

    public static /* synthetic */ int h(u0 u0Var) {
        int i10 = u0Var.f14766e;
        u0Var.f14766e = i10 + 1;
        return i10;
    }

    public void n(String str) {
        if (b0.B(this.f14762a) == 0) {
            h.c(this.f14763b, new Runnable() { // from class: z8.p0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f14731e.r(113);
                }
            });
            return;
        }
        if (this.f14770i) {
            this.f14764c.f0();
        }
        this.f14771j.postDelayed(this.f14772k, 1000L);
        s(str);
    }

    public final void o() {
        this.f14764c = w5.k.l(this.f14762a).X(x7.u.Nh).t(false).u(false);
    }

    public void p(boolean z10) {
        this.f14770i = z10;
        if (z10) {
            this.f14768g = 8;
        } else {
            this.f14768g = 10;
        }
    }

    public void q(b bVar) {
        this.f14765d = bVar;
    }

    public final void r(int i10) {
        if (this.f14770i) {
            this.f14764c.n();
        }
        switch (i10) {
            case 111:
                if (this.f14765d == null) {
                    if (this.f14770i) {
                        g6.n.m(this.f14763b, this.f14762a.getResources().getString(x7.u.f14193v3), this.f14762a.getResources().getString(x7.u.wg));
                        break;
                    }
                } else {
                    String strTrim = this.f14769h.trim().replaceAll("<meta.*?>", "").trim();
                    this.f14769h = strTrim;
                    this.f14765d.a(strTrim);
                    break;
                }
                break;
            case 112:
                if (this.f14770i) {
                    g6.n.m(this.f14763b, this.f14762a.getResources().getString(x7.u.f14193v3), this.f14762a.getResources().getString(x7.u.f14113p2));
                    break;
                }
                break;
            case 113:
                if (this.f14770i) {
                    g6.n.m(this.f14763b, this.f14762a.getResources().getString(x7.u.f14193v3), this.f14762a.getResources().getString(x7.u.f14192v2));
                    break;
                }
                break;
            case 114:
                g6.n.q(this.f14762a, x7.u.Q8);
                break;
        }
    }

    public final void s(final String str) {
        h.b(new Runnable() { // from class: z8.q0
            @Override // java.lang.Runnable
            public final void run() {
                u0.b(this.f14736e, str);
            }
        });
    }
}
