package u5;

import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.tuyafeng.scanner.camera.CameraSettings;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: i, reason: collision with root package name */
    public static final String f12821i = "a";

    /* renamed from: j, reason: collision with root package name */
    public static final Collection f12822j;

    /* renamed from: a, reason: collision with root package name */
    public boolean f12823a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f12824b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f12825c;

    /* renamed from: d, reason: collision with root package name */
    public final Camera f12826d;

    /* renamed from: e, reason: collision with root package name */
    public Handler f12827e;

    /* renamed from: f, reason: collision with root package name */
    public int f12828f = 1;

    /* renamed from: g, reason: collision with root package name */
    public final Handler.Callback f12829g;

    /* renamed from: h, reason: collision with root package name */
    public final Camera.AutoFocusCallback f12830h;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: u5.a$a, reason: collision with other inner class name */
    public class C0144a implements Handler.Callback {
        public C0144a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != a.this.f12828f) {
                return false;
            }
            a.this.h();
            return true;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b implements Camera.AutoFocusCallback {

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        /* renamed from: u5.a$b$a, reason: collision with other inner class name */
        public class RunnableC0145a implements Runnable {
            public RunnableC0145a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f12824b = false;
                a.this.f();
            }
        }

        public b() {
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z10, Camera camera) {
            a.this.f12827e.post(new RunnableC0145a());
        }
    }

    static {
        ArrayList arrayList = new ArrayList(2);
        f12822j = arrayList;
        arrayList.add("auto");
        arrayList.add("macro");
    }

    public a(Camera camera, CameraSettings cameraSettings) {
        C0144a c0144a = new C0144a();
        this.f12829g = c0144a;
        this.f12830h = new b();
        this.f12827e = new Handler(c0144a);
        this.f12826d = camera;
        String focusMode = camera.getParameters().getFocusMode();
        boolean z10 = cameraSettings.c() && f12822j.contains(focusMode);
        this.f12825c = z10;
        Log.i(f12821i, "Current focus mode '" + focusMode + "'; use auto focus? " + z10);
        i();
    }

    public final synchronized void f() {
        if (!this.f12823a && !this.f12827e.hasMessages(this.f12828f)) {
            Handler handler = this.f12827e;
            handler.sendMessageDelayed(handler.obtainMessage(this.f12828f), 2000L);
        }
    }

    public final void g() {
        this.f12827e.removeMessages(this.f12828f);
    }

    public final void h() {
        if (!this.f12825c || this.f12823a || this.f12824b) {
            return;
        }
        try {
            this.f12826d.autoFocus(this.f12830h);
            this.f12824b = true;
        } catch (RuntimeException e10) {
            Log.w(f12821i, "Unexpected exception while focusing", e10);
            f();
        }
    }

    public void i() {
        this.f12823a = false;
        h();
    }

    public void j() {
        this.f12823a = true;
        this.f12824b = false;
        g();
        if (this.f12825c) {
            try {
                this.f12826d.cancelAutoFocus();
            } catch (RuntimeException e10) {
                Log.w(f12821i, "Unexpected exception while cancelling focusing", e10);
            }
        }
    }
}
