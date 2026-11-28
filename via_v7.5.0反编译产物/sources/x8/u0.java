package x8;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f14629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Activity f14630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public q5.k f14631c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f14632d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public HttpURLConnection f14634f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f14635g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f14636h;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f14633e = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Handler f14638j = new Handler();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Runnable f14639k = new a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f14637i = true;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (u0.this.f14637i && u0.this.f14631c.s()) {
                u0.h(u0.this);
                if (u0.this.f14633e < u0.this.f14635g) {
                    u0.this.f14638j.postDelayed(this, 1000L);
                    return;
                }
                if (u0.this.f14634f != null) {
                    u0.this.f14634f.disconnect();
                }
                h.c(u0.this.f14630b, new Runnable() { // from class: x8.t0
                    @Override // java.lang.Runnable
                    public final void run() {
                        u0.this.r(113);
                    }
                });
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface b {
        void a(String str);
    }

    public u0(Context context) {
        this.f14629a = context;
        this.f14630b = (Activity) context;
        o();
        this.f14635g = 8;
    }

    public static /* synthetic */ void b(final u0 u0Var, String str) {
        u0Var.getClass();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            u0Var.f14634f = httpURLConnection;
            httpURLConnection.setRequestMethod("GET");
            u0Var.f14634f.setReadTimeout((u0Var.f14635g - 1) * 1000);
            if (u0Var.f14634f.getResponseCode() == 200) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(u0Var.f14634f.getInputStream(), k8.a.f7218a));
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
                u0Var.f14636h = new String(sb2.toString().getBytes(k8.a.f7218a), k8.a.f7219b);
                h.c(u0Var.f14630b, new Runnable() { // from class: x8.r0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f14620c.r(111);
                    }
                });
            } else {
                h.c(u0Var.f14630b, new Runnable() { // from class: x8.s0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f14623c.r(112);
                    }
                });
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        } finally {
            HttpURLConnection httpURLConnection2 = u0Var.f14634f;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
        }
    }

    public static /* synthetic */ int h(u0 u0Var) {
        int i10 = u0Var.f14633e;
        u0Var.f14633e = i10 + 1;
        return i10;
    }

    public void n(String str) {
        if (z.A(this.f14629a) == 0) {
            h.c(this.f14630b, new Runnable() { // from class: x8.p0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f14617c.r(113);
                }
            });
            return;
        }
        if (this.f14637i) {
            this.f14631c.h0();
        }
        this.f14638j.postDelayed(this.f14639k, 1000L);
        s(str);
    }

    public final void o() {
        this.f14631c = q5.k.l(this.f14629a).Z(w7.u.si).u(false).v(false);
    }

    public void p(boolean z10) {
        this.f14637i = z10;
        if (z10) {
            this.f14635g = 8;
        } else {
            this.f14635g = 10;
        }
    }

    public void q(b bVar) {
        this.f14632d = bVar;
    }

    public final void r(int i10) {
        if (this.f14637i) {
            this.f14631c.o();
        }
        switch (i10) {
            case 111:
                if (this.f14632d != null) {
                    String strTrim = this.f14636h.trim().replaceAll("<meta.*?>", "").trim();
                    this.f14636h = strTrim;
                    this.f14632d.a(strTrim);
                } else if (this.f14637i) {
                    com.tuyafeng.support.utils.n.m(this.f14630b, this.f14629a.getResources().getString(w7.u.I3), this.f14629a.getResources().getString(w7.u.Mg));
                }
                break;
            case 112:
                if (this.f14637i) {
                    com.tuyafeng.support.utils.n.m(this.f14630b, this.f14629a.getResources().getString(w7.u.I3), this.f14629a.getResources().getString(w7.u.C2));
                }
                break;
            case 113:
                if (this.f14637i) {
                    com.tuyafeng.support.utils.n.m(this.f14630b, this.f14629a.getResources().getString(w7.u.I3), this.f14629a.getResources().getString(w7.u.I2));
                }
                break;
            case 114:
                com.tuyafeng.support.utils.n.q(this.f14629a, w7.u.f14004c9);
                break;
        }
    }

    public final void s(final String str) {
        h.b(new Runnable() { // from class: x8.q0
            @Override // java.lang.Runnable
            public final void run() {
                u0.b(this.f14618c, str);
            }
        });
    }
}
