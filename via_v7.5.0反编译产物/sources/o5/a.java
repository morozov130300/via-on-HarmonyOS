package o5;

import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.tuyafeng.scanner.camera.CameraSettings;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f10920i = "a";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Collection f10921j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f10922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f10923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f10924c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Camera f10925d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Handler f10926e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f10927f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Handler.Callback f10928g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Camera.AutoFocusCallback f10929h;

    /* JADX INFO: renamed from: o5.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class C0105a implements Handler.Callback {
        public C0105a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != a.this.f10927f) {
                return false;
            }
            a.this.h();
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b implements Camera.AutoFocusCallback {

        /* JADX INFO: renamed from: o5.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public class RunnableC0106a implements Runnable {
            public RunnableC0106a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f10923b = false;
                a.this.f();
            }
        }

        public b() {
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z10, Camera camera) {
            a.this.f10926e.post(new RunnableC0106a());
        }
    }

    static {
        ArrayList arrayList = new ArrayList(2);
        f10921j = arrayList;
        arrayList.add("auto");
        arrayList.add("macro");
    }

    public a(Camera camera, CameraSettings cameraSettings) {
        C0105a c0105a = new C0105a();
        this.f10928g = c0105a;
        this.f10929h = new b();
        this.f10926e = new Handler(c0105a);
        this.f10925d = camera;
        String focusMode = camera.getParameters().getFocusMode();
        boolean z10 = cameraSettings.c() && f10921j.contains(focusMode);
        this.f10924c = z10;
        Log.i(f10920i, "Current focus mode '" + focusMode + "'; use auto focus? " + z10);
        i();
    }

    public final synchronized void f() {
        if (!this.f10922a && !this.f10926e.hasMessages(this.f10927f)) {
            Handler handler = this.f10926e;
            handler.sendMessageDelayed(handler.obtainMessage(this.f10927f), 2000L);
        }
    }

    public final void g() {
        this.f10926e.removeMessages(this.f10927f);
    }

    public final void h() {
        if (!this.f10924c || this.f10922a || this.f10923b) {
            return;
        }
        try {
            this.f10925d.autoFocus(this.f10929h);
            this.f10923b = true;
        } catch (RuntimeException e10) {
            Log.w(f10920i, "Unexpected exception while focusing", e10);
            f();
        }
    }

    public void i() {
        this.f10922a = false;
        h();
    }

    public void j() {
        this.f10922a = true;
        this.f10923b = false;
        g();
        if (this.f10924c) {
            try {
                this.f10925d.cancelAutoFocus();
            } catch (RuntimeException e10) {
                Log.w(f10920i, "Unexpected exception while cancelling focusing", e10);
            }
        }
    }
}
