package mark.via.service;

import android.app.Service;
import android.content.Intent;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import android.os.IBinder;
import h8.c;
import h8.d;
import h8.e;
import h8.q;
import h8.s;
import h8.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mark.via.service.ReadAloudService;
import n.d1;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class ReadAloudService extends Service implements d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public q f10335c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public s f10336e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f10337m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List f10338n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public AudioManager f10339o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public AudioDeviceCallback f10340p = null;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends AudioDeviceCallback {
        public a() {
        }

        @Override // android.media.AudioDeviceCallback
        public void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
            e.a(ReadAloudService.this.getApplicationContext(), null);
        }
    }

    public static /* synthetic */ void b(ReadAloudService readAloudService, boolean z10) {
        readAloudService.getClass();
        tc.a.a("stop service: %s", Boolean.valueOf(z10));
        try {
            d1.a(readAloudService, z10 ? 1 : 2);
            readAloudService.stopSelf();
        } catch (Exception e10) {
            tc.a.j(e10);
        }
    }

    @Override // h8.d
    public void a(t tVar) {
        g(tVar);
    }

    public final void c(Runnable runnable) {
        if (this.f10337m) {
            runnable.run();
            return;
        }
        if (this.f10338n == null) {
            this.f10338n = new ArrayList();
        }
        this.f10338n.add(runnable);
    }

    public final void d() {
        this.f10337m = true;
        List list = this.f10338n;
        if (list == null) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.f10338n.clear();
        this.f10338n = null;
    }

    public final void e(t tVar) {
        this.f10336e.b(this, tVar);
    }

    public final void f(final boolean z10) {
        c(new Runnable() { // from class: gb.d
            @Override // java.lang.Runnable
            public final void run() {
                ReadAloudService.b(this.f5604c, z10);
            }
        });
    }

    public final void g(t tVar) {
        this.f10336e.c(tVar);
        if (tVar.g()) {
            f(true);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f10336e = new s(this);
        c cVarN = c.n(this);
        this.f10335c = cVarN;
        cVarN.g(this);
        AudioManager audioManager = (AudioManager) o.a.i(this, AudioManager.class);
        this.f10339o = audioManager;
        if (Build.VERSION.SDK_INT >= 23 && audioManager != null) {
            a aVar = new a();
            this.f10340p = aVar;
            this.f10339o.registerAudioDeviceCallback(aVar, null);
        }
        e(this.f10335c.d());
        d();
    }

    @Override // android.app.Service
    public void onDestroy() {
        AudioManager audioManager;
        AudioDeviceCallback audioDeviceCallback;
        if (Build.VERSION.SDK_INT >= 23 && (audioManager = this.f10339o) != null && (audioDeviceCallback = this.f10340p) != null) {
            audioManager.unregisterAudioDeviceCallback(audioDeviceCallback);
        }
        this.f10335c.e(this);
        super.onDestroy();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        super.onStartCommand(intent, i10, i11);
        String action = intent == null ? null : intent.getAction();
        if (action != null && this.f10335c != null) {
            tc.a.a("action: %s", action);
            switch (action) {
                case "mark.via.receiver.ReadAloudReceiver.PAUSE":
                    if (this.f10335c.i(intent.getStringExtra(Name.MARK))) {
                        f(false);
                        break;
                    }
                    break;
                case "mark.via.receiver.ReadAloudReceiver.PLAY":
                    t tVarF = this.f10335c.f(intent.getStringExtra(Name.MARK));
                    if (tVarF != null) {
                        int intExtra = intent.getIntExtra("index", -9999);
                        if (intExtra != -9999) {
                            tVarF.i(intExtra);
                        } else if (tVarF.g()) {
                            tVarF.i(0);
                        }
                        if (!tVarF.g() && this.f10335c.j(tVarF.b())) {
                            g(tVarF);
                        }
                        break;
                    }
                    break;
                case "mark.via.receiver.ReadAloudReceiver.STOP":
                    this.f10335c.b();
                    f(true);
                    break;
            }
        }
        return 1;
    }
}
