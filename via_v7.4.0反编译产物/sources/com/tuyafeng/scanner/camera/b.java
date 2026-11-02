package com.tuyafeng.scanner.camera;

import android.content.Context;
import android.hardware.Camera;
import android.os.Build;
import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import t5.v;
import t5.w;
import u5.c;
import u5.f;
import u5.i;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: n, reason: collision with root package name */
    public static final String f4255n = "b";

    /* renamed from: a, reason: collision with root package name */
    public Camera f4256a;

    /* renamed from: b, reason: collision with root package name */
    public Camera.CameraInfo f4257b;

    /* renamed from: c, reason: collision with root package name */
    public u5.a f4258c;

    /* renamed from: d, reason: collision with root package name */
    public q3.a f4259d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f4260e;

    /* renamed from: f, reason: collision with root package name */
    public String f4261f;

    /* renamed from: h, reason: collision with root package name */
    public f f4263h;

    /* renamed from: i, reason: collision with root package name */
    public v f4264i;

    /* renamed from: j, reason: collision with root package name */
    public v f4265j;

    /* renamed from: l, reason: collision with root package name */
    public Context f4267l;

    /* renamed from: g, reason: collision with root package name */
    public CameraSettings f4262g = new CameraSettings();

    /* renamed from: k, reason: collision with root package name */
    public int f4266k = -1;

    /* renamed from: m, reason: collision with root package name */
    public final a f4268m = new a();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public final class a implements Camera.PreviewCallback {

        /* renamed from: a, reason: collision with root package name */
        public i f4269a;

        /* renamed from: b, reason: collision with root package name */
        public v f4270b;

        public a() {
        }

        public void a(i iVar) {
            this.f4269a = iVar;
        }

        public void b(v vVar) {
            this.f4270b = vVar;
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            v vVar = this.f4270b;
            i iVar = this.f4269a;
            if (vVar == null || iVar == null) {
                Log.d(b.f4255n, "Got preview callback, but no handler or resolution available");
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
                w wVar = new w(bArr, vVar.f12247e, vVar.f12248j, camera.getParameters().getPreviewFormat(), b.this.f());
                if (b.this.f4257b.facing == 1) {
                    wVar.c(true);
                }
                iVar.b(wVar);
            } catch (RuntimeException e10) {
                Log.e(b.f4255n, "Camera preview failed", e10);
                iVar.a(e10);
            }
        }
    }

    public b(Context context) {
        this.f4267l = context;
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
        int iC = this.f4263h.c();
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
        Camera.CameraInfo cameraInfo = this.f4257b;
        int i11 = cameraInfo.facing == 1 ? (360 - ((cameraInfo.orientation + i10) % 360)) % 360 : ((cameraInfo.orientation - i10) + 360) % 360;
        Log.i(f4255n, "Camera Display Orientation: " + i11);
        return i11;
    }

    public void d() {
        Camera camera = this.f4256a;
        if (camera != null) {
            camera.release();
            this.f4256a = null;
        }
    }

    public void e() {
        if (this.f4256a == null) {
            throw new RuntimeException("Camera not open");
        }
        r();
    }

    public int f() {
        return this.f4266k;
    }

    public final Camera.Parameters g() {
        Camera.Parameters parameters = this.f4256a.getParameters();
        String str = this.f4261f;
        if (str == null) {
            this.f4261f = parameters.flatten();
            return parameters;
        }
        parameters.unflatten(str);
        return parameters;
    }

    public v h() {
        if (this.f4265j == null) {
            return null;
        }
        return j() ? this.f4265j.b() : this.f4265j;
    }

    public boolean j() {
        int i10 = this.f4266k;
        if (i10 != -1) {
            return i10 % 180 != 0;
        }
        throw new IllegalStateException("Rotation not calculated yet. Call configure() first.");
    }

    public boolean k() {
        String flashMode;
        Camera.Parameters parameters = this.f4256a.getParameters();
        return (parameters == null || (flashMode = parameters.getFlashMode()) == null || (!"on".equals(flashMode) && !"torch".equals(flashMode))) ? false : true;
    }

    public void l() {
        Camera cameraB = r3.a.b(this.f4262g.b());
        this.f4256a = cameraB;
        if (cameraB == null) {
            throw new RuntimeException("Failed to open camera");
        }
        int iA = r3.a.a(this.f4262g.b());
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        this.f4257b = cameraInfo;
        Camera.getCameraInfo(iA, cameraInfo);
    }

    public void m(i iVar) {
        Camera camera = this.f4256a;
        if (camera == null || !this.f4260e) {
            return;
        }
        this.f4268m.a(iVar);
        camera.setOneShotPreviewCallback(this.f4268m);
    }

    public final void n(int i10) {
        this.f4256a.setDisplayOrientation(i10);
    }

    public void o(CameraSettings cameraSettings) {
        this.f4262g = cameraSettings;
    }

    public final void p(boolean z10) {
        Camera.Parameters parametersG = g();
        if (parametersG == null) {
            Log.w(f4255n, "Device error: no camera parameters are available. Proceeding without configuration.");
            return;
        }
        String str = f4255n;
        Log.i(str, "Initial camera parameters: " + parametersG.flatten());
        if (z10) {
            Log.w(str, "In camera config safe mode -- most settings will not be honored");
        }
        com.tuyafeng.scanner.camera.a.g(parametersG, this.f4262g.a(), z10);
        if (!z10) {
            com.tuyafeng.scanner.camera.a.k(parametersG, false);
            if (this.f4262g.h()) {
                com.tuyafeng.scanner.camera.a.i(parametersG);
            }
            if (this.f4262g.e()) {
                com.tuyafeng.scanner.camera.a.c(parametersG);
            }
            if (this.f4262g.g()) {
                com.tuyafeng.scanner.camera.a.l(parametersG);
                com.tuyafeng.scanner.camera.a.h(parametersG);
                com.tuyafeng.scanner.camera.a.j(parametersG);
            }
        }
        List listI = i(parametersG);
        if (listI.size() == 0) {
            this.f4264i = null;
        } else {
            v vVarA = this.f4263h.a(listI, j());
            this.f4264i = vVarA;
            parametersG.setPreviewSize(vVarA.f12247e, vVarA.f12248j);
        }
        if (Build.DEVICE.equals("glass-1")) {
            com.tuyafeng.scanner.camera.a.e(parametersG);
        }
        Log.i(str, "Final camera parameters: " + parametersG.flatten());
        this.f4256a.setParameters(parametersG);
    }

    public void q(f fVar) {
        this.f4263h = fVar;
    }

    public final void r() {
        try {
            int iC = c();
            this.f4266k = iC;
            n(iC);
        } catch (Exception unused) {
            Log.w(f4255n, "Failed to set rotation.");
        }
        try {
            p(false);
        } catch (Exception unused2) {
            try {
                p(true);
            } catch (Exception unused3) {
                Log.w(f4255n, "Camera rejected even safe-mode parameters! No configuration");
            }
        }
        Camera.Size previewSize = this.f4256a.getParameters().getPreviewSize();
        if (previewSize == null) {
            this.f4265j = this.f4264i;
        } else {
            this.f4265j = new v(previewSize.width, previewSize.height);
        }
        this.f4268m.b(this.f4265j);
    }

    public void s(c cVar) throws IOException {
        cVar.a(this.f4256a);
    }

    public void t(boolean z10) {
        if (this.f4256a != null) {
            try {
                if (z10 != k()) {
                    u5.a aVar = this.f4258c;
                    if (aVar != null) {
                        aVar.j();
                    }
                    Camera.Parameters parameters = this.f4256a.getParameters();
                    com.tuyafeng.scanner.camera.a.k(parameters, z10);
                    if (this.f4262g.f()) {
                        com.tuyafeng.scanner.camera.a.d(parameters, z10);
                    }
                    this.f4256a.setParameters(parameters);
                    u5.a aVar2 = this.f4258c;
                    if (aVar2 != null) {
                        aVar2.i();
                    }
                }
            } catch (RuntimeException e10) {
                Log.e(f4255n, "Failed to set torch", e10);
            }
        }
    }

    public void u() {
        Camera camera = this.f4256a;
        if (camera == null || this.f4260e) {
            return;
        }
        camera.startPreview();
        this.f4260e = true;
        this.f4258c = new u5.a(this.f4256a, this.f4262g);
        q3.a aVar = new q3.a(this.f4267l, this, this.f4262g);
        this.f4259d = aVar;
        aVar.c();
    }

    public void v() {
        u5.a aVar = this.f4258c;
        if (aVar != null) {
            aVar.j();
            this.f4258c = null;
        }
        q3.a aVar2 = this.f4259d;
        if (aVar2 != null) {
            aVar2.d();
            this.f4259d = null;
        }
        Camera camera = this.f4256a;
        if (camera == null || !this.f4260e) {
            return;
        }
        camera.stopPreview();
        this.f4268m.a(null);
        this.f4260e = false;
    }
}
