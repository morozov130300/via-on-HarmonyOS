package r3;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.tuyafeng.scanner.camera.CameraSettings;
import com.tuyafeng.scanner.camera.b;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f11966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CameraSettings f11967b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Sensor f11968c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Context f11969d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Handler f11970e = new Handler();

    /* JADX INFO: renamed from: r3.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class RunnableC0116a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f11971c;

        public RunnableC0116a(boolean z10) {
            this.f11971c = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f11966a.t(this.f11971c);
        }
    }

    public a(Context context, b bVar, CameraSettings cameraSettings) {
        this.f11969d = context;
        this.f11966a = bVar;
        this.f11967b = cameraSettings;
    }

    public final void b(boolean z10) {
        this.f11970e.post(new RunnableC0116a(z10));
    }

    public void c() {
        if (this.f11967b.d()) {
            SensorManager sensorManager = (SensorManager) this.f11969d.getSystemService("sensor");
            Sensor defaultSensor = sensorManager.getDefaultSensor(5);
            this.f11968c = defaultSensor;
            if (defaultSensor != null) {
                sensorManager.registerListener(this, defaultSensor, 3);
            }
        }
    }

    public void d() {
        if (this.f11968c != null) {
            ((SensorManager) this.f11969d.getSystemService("sensor")).unregisterListener(this);
            this.f11968c = null;
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        float f10 = sensorEvent.values[0];
        if (this.f11966a != null) {
            if (f10 <= 45.0f) {
                b(true);
            } else if (f10 >= 450.0f) {
                b(false);
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i10) {
    }
}
