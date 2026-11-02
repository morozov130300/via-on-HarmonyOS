package q3;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.tuyafeng.scanner.camera.CameraSettings;
import com.tuyafeng.scanner.camera.b;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a implements SensorEventListener {

    /* renamed from: a, reason: collision with root package name */
    public b f11276a;

    /* renamed from: b, reason: collision with root package name */
    public CameraSettings f11277b;

    /* renamed from: c, reason: collision with root package name */
    public Sensor f11278c;

    /* renamed from: d, reason: collision with root package name */
    public Context f11279d;

    /* renamed from: e, reason: collision with root package name */
    public Handler f11280e = new Handler();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: q3.a$a, reason: collision with other inner class name */
    public class RunnableC0115a implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f11281e;

        public RunnableC0115a(boolean z10) {
            this.f11281e = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f11276a.t(this.f11281e);
        }
    }

    public a(Context context, b bVar, CameraSettings cameraSettings) {
        this.f11279d = context;
        this.f11276a = bVar;
        this.f11277b = cameraSettings;
    }

    public final void b(boolean z10) {
        this.f11280e.post(new RunnableC0115a(z10));
    }

    public void c() {
        if (this.f11277b.d()) {
            SensorManager sensorManager = (SensorManager) this.f11279d.getSystemService("sensor");
            Sensor defaultSensor = sensorManager.getDefaultSensor(5);
            this.f11278c = defaultSensor;
            if (defaultSensor != null) {
                sensorManager.registerListener(this, defaultSensor, 3);
            }
        }
    }

    public void d() {
        if (this.f11278c != null) {
            ((SensorManager) this.f11279d.getSystemService("sensor")).unregisterListener(this);
            this.f11278c = null;
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i10) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        float f10 = sensorEvent.values[0];
        if (this.f11276a != null) {
            if (f10 <= 45.0f) {
                b(true);
            } else if (f10 >= 450.0f) {
                b(false);
            }
        }
    }
}
