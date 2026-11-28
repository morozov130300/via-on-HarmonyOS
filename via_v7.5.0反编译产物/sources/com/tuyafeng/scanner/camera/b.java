package com.tuyafeng.scanner.camera;

import android.content.Context;
import android.hardware.Camera;
import android.os.Build;
import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import n5.v;
import n5.w;
import o5.c;
import o5.f;
import o5.i;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f3548n = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Camera f3549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Camera.CameraInfo f3550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public o5.a f3551c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public r3.a f3552d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f3553e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f3554f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public f f3556h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public v f3557i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public v f3558j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Context f3560l;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CameraSettings f3555g = new CameraSettings();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f3559k = -1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final a f3561m = new a();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public final class a implements Camera.PreviewCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public i f3562a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public v f3563b;

        public a() {
        }

        public void a(i iVar) {
            this.f3562a = iVar;
        }

        public void b(v vVar) {
            this.f3563b = vVar;
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            v vVar = this.f3563b;
            i iVar = this.f3562a;
            if (vVar == null || iVar == null) {
                Log.d(b.f3548n, "Got preview callback, but no handler or resolution available");
                if (iVar != null) {
                    iVar.a(new Exception("No resolution available"));
                    return;
                }
                return;
            }
            try {
                if (bArr == null) {
                    throw new NullPointerException("No preview data received");
                }
                w wVar = new w(bArr, vVar.f10676c, vVar.f10677e, camera.getParameters().getPreviewFormat(), b.this.f());
                if (b.this.f3550b.facing == 1) {
                    wVar.c(true);
                }
                iVar.b(wVar);
            } catch (RuntimeException e10) {
                Log.e(b.f3548n, "Camera preview failed", e10);
                iVar.a(e10);
            }
        }
    }

    public b(Context context) {
        this.f3560l = context;
    }

    public static List i(Camera.Parameters parameters) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        ArrayList arrayList = new ArrayList();
        if (supportedPreviewSizes == null) {
            Camera.Size previewSize = parameters.getPreviewSize();
            if (previewSize != null) {
                new v(previewSize.width, previewSize.height);
                arrayList.add(new v(previewSize.width, previewSize.height));
                return arrayList;
            }
        } else {
            for (Camera.Size size : supportedPreviewSizes) {
                arrayList.add(new v(size.width, size.height));
            }
        }
        return arrayList;
    }

    public final int c() {
        int iC = this.f3556h.c();
        int i10 = 0;
        if (iC != 0) {
            if (iC == 1) {
                i10 = 90;
            } else if (iC == 2) {
                i10 = 180;
            } else if (iC == 3) {
                i10 = 270;
            }
        }
        Camera.CameraInfo cameraInfo = this.f3550b;
        int i11 = cameraInfo.facing == 1 ? (360 - ((cameraInfo.orientation + i10) % 360)) % 360 : ((cameraInfo.orientation - i10) + 360) % 360;
        Log.i(f3548n, "Camera Display Orientation: " + i11);
        return i11;
    }

    public void d() {
        Camera camera = this.f3549a;
        if (camera != null) {
            camera.release();
            this.f3549a = null;
        }
    }

    public void e() {
        if (this.f3549a == null) {
            throw new RuntimeException("Camera not open");
        }
        r();
    }

    public int f() {
        return this.f3559k;
    }

    public final Camera.Parameters g() {
        Camera.Parameters parameters = this.f3549a.getParameters();
        String str = this.f3554f;
        if (str == null) {
            this.f3554f = parameters.flatten();
            return parameters;
        }
        parameters.unflatten(str);
        return parameters;
    }

    public v h() {
        if (this.f3558j == null) {
            return null;
        }
        return j() ? this.f3558j.d() : this.f3558j;
    }

    public boolean j() {
        int i10 = this.f3559k;
        if (i10 != -1) {
            return i10 % 180 != 0;
        }
        throw new IllegalStateException("Rotation not calculated yet. Call configure() first.");
    }

    public boolean k() {
        String flashMode;
        Camera.Parameters parameters = this.f3549a.getParameters();
        return (parameters == null || (flashMode = parameters.getFlashMode()) == null || (!"on".equals(flashMode) && !"torch".equals(flashMode))) ? false : true;
    }

    public void l() {
        Camera cameraB = s3.a.b(this.f3555g.b());
        this.f3549a = cameraB;
        if (cameraB == null) {
            throw new RuntimeException("Failed to open camera");
        }
        int iA = s3.a.a(this.f3555g.b());
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        this.f3550b = cameraInfo;
        Camera.getCameraInfo(iA, cameraInfo);
    }

    public void m(i iVar) {
        Camera camera = this.f3549a;
        if (camera == null || !this.f3553e) {
            return;
        }
        this.f3561m.a(iVar);
        camera.setOneShotPreviewCallback(this.f3561m);
    }

    public final void n(int i10) {
        this.f3549a.setDisplayOrientation(i10);
    }

    public void o(CameraSettings cameraSettings) {
        this.f3555g = cameraSettings;
    }

    public final void p(boolean z10) {
        Camera.Parameters parametersG = g();
        if (parametersG == null) {
            Log.w(f3548n, "Device error: no camera parameters are available. Proceeding without configuration.");
            return;
        }
        String str = f3548n;
        Log.i(str, "Initial camera parameters: " + parametersG.flatten());
        if (z10) {
            Log.w(str, "In camera config safe mode -- most settings will not be honored");
        }
        com.tuyafeng.scanner.camera.a.g(parametersG, this.f3555g.a(), z10);
        if (!z10) {
            com.tuyafeng.scanner.camera.a.k(parametersG, false);
            if (this.f3555g.h()) {
                com.tuyafeng.scanner.camera.a.i(parametersG);
            }
            if (this.f3555g.e()) {
                com.tuyafeng.scanner.camera.a.c(parametersG);
            }
            if (this.f3555g.g()) {
                com.tuyafeng.scanner.camera.a.l(parametersG);
                com.tuyafeng.scanner.camera.a.h(parametersG);
                com.tuyafeng.scanner.camera.a.j(parametersG);
            }
        }
        List listI = i(parametersG);
        if (listI.size() == 0) {
            this.f3557i = null;
        } else {
            v vVarA = this.f3556h.a(listI, j());
            this.f3557i = vVarA;
            parametersG.setPreviewSize(vVarA.f10676c, vVarA.f10677e);
        }
        if (Build.DEVICE.equals("glass-1")) {
            com.tuyafeng.scanner.camera.a.e(parametersG);
        }
        Log.i(str, "Final camera parameters: " + parametersG.flatten());
        this.f3549a.setParameters(parametersG);
    }

    public void q(f fVar) {
        this.f3556h = fVar;
    }

    public final void r() {
        try {
            int iC = c();
            this.f3559k = iC;
            n(iC);
        } catch (Exception unused) {
            Log.w(f3548n, "Failed to set rotation.");
        }
        try {
            p(false);
        } catch (Exception unused2) {
            try {
                p(true);
            } catch (Exception unused3) {
                Log.w(f3548n, "Camera rejected even safe-mode parameters! No configuration");
            }
        }
        Camera.Size previewSize = this.f3549a.getParameters().getPreviewSize();
        if (previewSize == null) {
            this.f3558j = this.f3557i;
        } else {
            this.f3558j = new v(previewSize.width, previewSize.height);
        }
        this.f3561m.b(this.f3558j);
    }

    public void s(c cVar) throws IOException {
        cVar.a(this.f3549a);
    }

    public void t(boolean z10) {
        if (this.f3549a != null) {
            try {
                if (z10 != k()) {
                    o5.a aVar = this.f3551c;
                    if (aVar != null) {
                        aVar.j();
                    }
                    Camera.Parameters parameters = this.f3549a.getParameters();
                    com.tuyafeng.scanner.camera.a.k(parameters, z10);
                    if (this.f3555g.f()) {
                        com.tuyafeng.scanner.camera.a.d(parameters, z10);
                    }
                    this.f3549a.setParameters(parameters);
                    o5.a aVar2 = this.f3551c;
                    if (aVar2 != null) {
                        aVar2.i();
                    }
                }
            } catch (RuntimeException e10) {
                Log.e(f3548n, "Failed to set torch", e10);
            }
        }
    }

    public void u() {
        Camera camera = this.f3549a;
        if (camera == null || this.f3553e) {
            return;
        }
        camera.startPreview();
        this.f3553e = true;
        this.f3551c = new o5.a(this.f3549a, this.f3555g);
        r3.a aVar = new r3.a(this.f3560l, this, this.f3555g);
        this.f3552d = aVar;
        aVar.c();
    }

    public void v() {
        o5.a aVar = this.f3551c;
        if (aVar != null) {
            aVar.j();
            this.f3551c = null;
        }
        r3.a aVar2 = this.f3552d;
        if (aVar2 != null) {
            aVar2.d();
            this.f3552d = null;
        }
        Camera camera = this.f3549a;
        if (camera == null || !this.f3553e) {
            return;
        }
        camera.stopPreview();
        this.f3561m.a(null);
        this.f3553e = false;
    }
}
