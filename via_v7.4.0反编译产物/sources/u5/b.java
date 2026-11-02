package u5;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.tuyafeng.scanner.camera.CameraSettings;
import t5.p;
import t5.v;
import t5.x;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b {

    /* renamed from: n, reason: collision with root package name */
    public static final String f12834n = "b";

    /* renamed from: a, reason: collision with root package name */
    public u5.d f12835a;

    /* renamed from: b, reason: collision with root package name */
    public u5.c f12836b;

    /* renamed from: c, reason: collision with root package name */
    public com.tuyafeng.scanner.camera.b f12837c;

    /* renamed from: d, reason: collision with root package name */
    public Handler f12838d;

    /* renamed from: e, reason: collision with root package name */
    public u5.f f12839e;

    /* renamed from: h, reason: collision with root package name */
    public Handler f12842h;

    /* renamed from: f, reason: collision with root package name */
    public boolean f12840f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f12841g = true;

    /* renamed from: i, reason: collision with root package name */
    public CameraSettings f12843i = new CameraSettings();

    /* renamed from: j, reason: collision with root package name */
    public Runnable f12844j = new c();

    /* renamed from: k, reason: collision with root package name */
    public Runnable f12845k = new d();

    /* renamed from: l, reason: collision with root package name */
    public Runnable f12846l = new e();

    /* renamed from: m, reason: collision with root package name */
    public Runnable f12847m = new f();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f12848e;

        public a(boolean z10) {
            this.f12848e = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f12837c.t(this.f12848e);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: u5.b$b, reason: collision with other inner class name */
    public class RunnableC0146b implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ i f12850e;

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        /* renamed from: u5.b$b$a */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f12837c.m(RunnableC0146b.this.f12850e);
            }
        }

        public RunnableC0146b(i iVar) {
            this.f12850e = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f12840f) {
                b.this.f12835a.c(new a());
            } else {
                Log.d(b.f12834n, "Camera is closed, not requesting preview");
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.d(b.f12834n, "Opening camera");
                b.this.f12837c.l();
            } catch (Exception e10) {
                b.this.n(e10);
                Log.e(b.f12834n, "Failed to open camera", e10);
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.d(b.f12834n, "Configuring camera");
                b.this.f12837c.e();
                if (b.this.f12838d != null) {
                    b.this.f12838d.obtainMessage(p.f12222i, b.this.m()).sendToTarget();
                }
            } catch (Exception e10) {
                b.this.n(e10);
                Log.e(b.f12834n, "Failed to configure camera", e10);
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.d(b.f12834n, "Starting preview");
                b.this.f12837c.s(b.this.f12836b);
                b.this.f12837c.u();
            } catch (Exception e10) {
                b.this.n(e10);
                Log.e(b.f12834n, "Failed to start preview", e10);
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.d(b.f12834n, "Closing camera");
                b.this.f12837c.v();
                b.this.f12837c.d();
            } catch (Exception e10) {
                Log.e(b.f12834n, "Failed to close camera", e10);
            }
            b.this.f12841g = true;
            b.this.f12838d.sendEmptyMessage(p.f12215b);
            b.this.f12835a.b();
        }
    }

    public b(Context context) {
        x.a();
        this.f12835a = u5.d.d();
        com.tuyafeng.scanner.camera.b bVar = new com.tuyafeng.scanner.camera.b(context);
        this.f12837c = bVar;
        bVar.o(this.f12843i);
        this.f12842h = new Handler();
    }

    public void j() {
        x.a();
        if (this.f12840f) {
            this.f12835a.c(this.f12847m);
        } else {
            this.f12841g = true;
        }
        this.f12840f = false;
    }

    public void k() {
        x.a();
        w();
        this.f12835a.c(this.f12845k);
    }

    public u5.f l() {
        return this.f12839e;
    }

    public final v m() {
        return this.f12837c.h();
    }

    public final void n(Exception exc) {
        Handler handler = this.f12838d;
        if (handler != null) {
            handler.obtainMessage(p.f12216c, exc).sendToTarget();
        }
    }

    public void o() {
        x.a();
        this.f12840f = true;
        this.f12841g = false;
        this.f12835a.e(this.f12844j);
    }

    public void p(i iVar) {
        this.f12842h.post(new RunnableC0146b(iVar));
    }

    public void q(CameraSettings cameraSettings) {
        if (this.f12840f) {
            return;
        }
        this.f12843i = cameraSettings;
        this.f12837c.o(cameraSettings);
    }

    public void r(u5.f fVar) {
        this.f12839e = fVar;
        this.f12837c.q(fVar);
    }

    public void s(Handler handler) {
        this.f12838d = handler;
    }

    public void t(u5.c cVar) {
        this.f12836b = cVar;
    }

    public void u(boolean z10) {
        x.a();
        if (this.f12840f) {
            this.f12835a.c(new a(z10));
        }
    }

    public void v() {
        x.a();
        w();
        this.f12835a.c(this.f12846l);
    }

    public final void w() {
        if (!this.f12840f) {
            throw new IllegalStateException("CameraInstance is not open");
        }
    }
}
