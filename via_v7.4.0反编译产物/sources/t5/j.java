package t5;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class j {

    /* renamed from: k, reason: collision with root package name */
    public static final String f12187k = "j";

    /* renamed from: a, reason: collision with root package name */
    public u5.b f12188a;

    /* renamed from: b, reason: collision with root package name */
    public HandlerThread f12189b;

    /* renamed from: c, reason: collision with root package name */
    public Handler f12190c;

    /* renamed from: d, reason: collision with root package name */
    public g f12191d;

    /* renamed from: e, reason: collision with root package name */
    public Handler f12192e;

    /* renamed from: f, reason: collision with root package name */
    public Rect f12193f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f12194g = false;

    /* renamed from: h, reason: collision with root package name */
    public final Object f12195h = new Object();

    /* renamed from: i, reason: collision with root package name */
    public final Handler.Callback f12196i = new a();

    /* renamed from: j, reason: collision with root package name */
    public final u5.i f12197j = new b();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == p.f12217d) {
                j.this.g((w) message.obj);
                return true;
            }
            if (i10 != p.f12221h) {
                return true;
            }
            j.this.h();
            return true;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b implements u5.i {
        public b() {
        }

        @Override // u5.i
        public void a(Exception exc) {
            synchronized (j.this.f12195h) {
                try {
                    if (j.this.f12194g) {
                        j.this.f12190c.obtainMessage(p.f12221h).sendToTarget();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // u5.i
        public void b(w wVar) {
            synchronized (j.this.f12195h) {
                try {
                    if (j.this.f12194g) {
                        j.this.f12190c.obtainMessage(p.f12217d, wVar).sendToTarget();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public j(u5.b bVar, g gVar, Handler handler) {
        x.a();
        this.f12188a = bVar;
        this.f12191d = gVar;
        this.f12192e = handler;
    }

    public com.google.zxing.d f(w wVar) {
        if (this.f12193f == null) {
            return null;
        }
        return wVar.a();
    }

    public final void g(w wVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        wVar.b(this.f12193f);
        com.google.zxing.d dVarF = f(wVar);
        com.google.zxing.j jVarC = dVarF != null ? this.f12191d.c(dVarF) : null;
        if (jVarC != null) {
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            Log.d(f12187k, "Found barcode in " + (jCurrentTimeMillis2 - jCurrentTimeMillis) + " ms");
            if (this.f12192e != null) {
                Message messageObtain = Message.obtain(this.f12192e, p.f12219f, new d(jVarC, wVar));
                messageObtain.setData(new Bundle());
                messageObtain.sendToTarget();
            }
        } else {
            Handler handler = this.f12192e;
            if (handler != null) {
                Message.obtain(handler, p.f12218e).sendToTarget();
            }
        }
        if (this.f12192e != null) {
            Message.obtain(this.f12192e, p.f12220g, d.b(this.f12191d.d(), wVar)).sendToTarget();
        }
        h();
    }

    public final void h() {
        this.f12188a.p(this.f12197j);
    }

    public void i(Rect rect) {
        this.f12193f = rect;
    }

    public void j(g gVar) {
        this.f12191d = gVar;
    }

    public void k() {
        x.a();
        HandlerThread handlerThread = new HandlerThread(f12187k);
        this.f12189b = handlerThread;
        handlerThread.start();
        this.f12190c = new Handler(this.f12189b.getLooper(), this.f12196i);
        this.f12194g = true;
        h();
    }

    public void l() {
        x.a();
        synchronized (this.f12195h) {
            this.f12194g = false;
            this.f12190c.removeCallbacksAndMessages(null);
            this.f12189b.quit();
        }
    }
}
