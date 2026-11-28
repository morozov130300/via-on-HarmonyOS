package n5;

import android.content.Context;
import android.view.OrientationEventListener;
import android.view.WindowManager;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WindowManager f10672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public OrientationEventListener f10673c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public t f10674d;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends OrientationEventListener {
        public a(Context context, int i10) {
            super(context, i10);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i10) {
            int rotation;
            WindowManager windowManager = u.this.f10672b;
            t tVar = u.this.f10674d;
            if (u.this.f10672b == null || tVar == null || (rotation = windowManager.getDefaultDisplay().getRotation()) == u.this.f10671a) {
                return;
            }
            u.this.f10671a = rotation;
            tVar.a(rotation);
        }
    }

    public void e(Context context, t tVar) {
        f();
        Context applicationContext = context.getApplicationContext();
        this.f10674d = tVar;
        this.f10672b = (WindowManager) applicationContext.getSystemService("window");
        a aVar = new a(applicationContext, 3);
        this.f10673c = aVar;
        aVar.enable();
        this.f10671a = this.f10672b.getDefaultDisplay().getRotation();
    }

    public void f() {
        OrientationEventListener orientationEventListener = this.f10673c;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
        this.f10673c = null;
        this.f10672b = null;
        this.f10674d = null;
    }
}
