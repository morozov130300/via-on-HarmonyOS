package n5;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.tuyafeng.scanner.camera.CameraSettings;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class f extends ViewGroup {
    public static final String K = "f";
    public Rect A;
    public Rect B;
    public v C;
    public double D;
    public o5.j E;
    public boolean F;
    public final SurfaceHolder.Callback G;
    public final Handler.Callback H;
    public t I;
    public final InterfaceC0102f J;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public o5.b f10591c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public WindowManager f10592e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Handler f10593m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f10594n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public SurfaceView f10595o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TextureView f10596p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f10597q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public u f10598r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f10599s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public List f10600t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public o5.f f10601u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public CameraSettings f10602v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public v f10603w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public v f10604x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Rect f10605y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public v f10606z;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class c implements Handler.Callback {
        public c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == p.f10651i) {
                f.this.u((v) message.obj);
                return true;
            }
            if (i10 != p.f10645c) {
                if (i10 != p.f10644b) {
                    return false;
                }
                f.this.J.d();
                return false;
            }
            Exception exc = (Exception) message.obj;
            if (!f.this.r()) {
                return false;
            }
            f.this.t();
            f.this.J.b(exc);
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class d implements t {

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                f.this.x();
            }
        }

        public d() {
        }

        @Override // n5.t
        public void a(int i10) {
            f.this.f10593m.postDelayed(new a(), 250L);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class e implements InterfaceC0102f {
        public e() {
        }

        @Override // n5.f.InterfaceC0102f
        public void a() {
            Iterator it = f.this.f10600t.iterator();
            while (it.hasNext()) {
                ((InterfaceC0102f) it.next()).a();
            }
        }

        @Override // n5.f.InterfaceC0102f
        public void b(Exception exc) {
            Iterator it = f.this.f10600t.iterator();
            while (it.hasNext()) {
                ((InterfaceC0102f) it.next()).b(exc);
            }
        }

        @Override // n5.f.InterfaceC0102f
        public void c() {
            Iterator it = f.this.f10600t.iterator();
            while (it.hasNext()) {
                ((InterfaceC0102f) it.next()).c();
            }
        }

        @Override // n5.f.InterfaceC0102f
        public void d() {
            Iterator it = f.this.f10600t.iterator();
            while (it.hasNext()) {
                ((InterfaceC0102f) it.next()).d();
            }
        }

        @Override // n5.f.InterfaceC0102f
        public void e() {
            Iterator it = f.this.f10600t.iterator();
            while (it.hasNext()) {
                ((InterfaceC0102f) it.next()).e();
            }
        }
    }

    /* JADX INFO: renamed from: n5.f$f, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface InterfaceC0102f {
        void a();

        void b(Exception exc);

        void c();

        void d();

        void e();
    }

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10594n = false;
        this.f10597q = false;
        this.f10599s = -1;
        this.f10600t = new ArrayList();
        this.f10602v = new CameraSettings();
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = 0.1d;
        this.E = null;
        this.F = false;
        this.G = new b();
        this.H = new c();
        this.I = new d();
        this.J = new e();
        p(context, attributeSet, 0, 0);
    }

    private int getDisplayRotation() {
        return this.f10592e.getDefaultDisplay().getRotation();
    }

    public final void A() {
        Rect rect;
        v vVar = this.f10606z;
        if (vVar == null || this.f10604x == null || (rect = this.f10605y) == null) {
            return;
        }
        if (this.f10595o != null && vVar.equals(new v(rect.width(), this.f10605y.height()))) {
            z(new o5.c(this.f10595o.getHolder()));
            return;
        }
        TextureView textureView = this.f10596p;
        if (textureView == null || textureView.getSurfaceTexture() == null) {
            return;
        }
        if (this.f10604x != null) {
            this.f10596p.setTransform(l(new v(this.f10596p.getWidth(), this.f10596p.getHeight()), this.f10604x));
        }
        z(new o5.c(this.f10596p.getSurfaceTexture()));
    }

    public final TextureView.SurfaceTextureListener B() {
        return new a();
    }

    public o5.b getCameraInstance() {
        return this.f10591c;
    }

    public CameraSettings getCameraSettings() {
        return this.f10602v;
    }

    public Rect getFramingRect() {
        return this.A;
    }

    public v getFramingRectSize() {
        return this.C;
    }

    public double getMarginFraction() {
        return this.D;
    }

    public Rect getPreviewFramingRect() {
        return this.B;
    }

    public o5.j getPreviewScalingStrategy() {
        o5.j jVar = this.E;
        if (jVar != null) {
            return jVar;
        }
        return this.f10596p != null ? new o5.e() : new o5.g();
    }

    public v getPreviewSize() {
        return this.f10604x;
    }

    public void i(InterfaceC0102f interfaceC0102f) {
        this.f10600t.add(interfaceC0102f);
    }

    public final void j() {
        v vVar;
        o5.f fVar;
        v vVar2 = this.f10603w;
        if (vVar2 == null || (vVar = this.f10604x) == null || (fVar = this.f10601u) == null) {
            this.B = null;
            this.A = null;
            this.f10605y = null;
            throw new IllegalStateException("containerSize or previewSize is not set yet");
        }
        int i10 = vVar.f10676c;
        int i11 = vVar.f10677e;
        int i12 = vVar2.f10676c;
        int i13 = vVar2.f10677e;
        Rect rectD = fVar.d(vVar);
        if (rectD.width() <= 0 || rectD.height() <= 0) {
            return;
        }
        this.f10605y = rectD;
        this.A = k(new Rect(0, 0, i12, i13), this.f10605y);
        Rect rect = new Rect(this.A);
        Rect rect2 = this.f10605y;
        rect.offset(-rect2.left, -rect2.top);
        Rect rect3 = new Rect((rect.left * i10) / this.f10605y.width(), (rect.top * i11) / this.f10605y.height(), (rect.right * i10) / this.f10605y.width(), (rect.bottom * i11) / this.f10605y.height());
        this.B = rect3;
        if (rect3.width() > 0 && this.B.height() > 0) {
            this.J.a();
            return;
        }
        this.B = null;
        this.A = null;
        Log.w(K, "Preview frame is too small");
    }

    public Rect k(Rect rect, Rect rect2) {
        Rect rect3 = new Rect(rect);
        rect3.intersect(rect2);
        if (this.C != null) {
            rect3.inset(Math.max(0, (rect3.width() - this.C.f10676c) / 2), Math.max(0, (rect3.height() - this.C.f10677e) / 2));
            return rect3;
        }
        double dWidth = rect3.width();
        double d10 = this.D;
        Double.isNaN(dWidth);
        double d11 = dWidth * d10;
        double dHeight = rect3.height();
        double d12 = this.D;
        Double.isNaN(dHeight);
        int iMin = (int) Math.min(d11, dHeight * d12);
        rect3.inset(iMin, iMin);
        if (rect3.height() > rect3.width()) {
            rect3.inset(0, (rect3.height() - rect3.width()) / 2);
        }
        return rect3;
    }

    public Matrix l(v vVar, v vVar2) {
        float f10;
        float f11 = vVar.f10676c / vVar.f10677e;
        float f12 = vVar2.f10676c / vVar2.f10677e;
        float f13 = 1.0f;
        if (f11 < f12) {
            f13 = f12 / f11;
            f10 = 1.0f;
        } else {
            f10 = f11 / f12;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(f13, f10);
        int i10 = vVar.f10676c;
        int i11 = vVar.f10677e;
        matrix.postTranslate((i10 - (i10 * f13)) / 2.0f, (i11 - (i11 * f10)) / 2.0f);
        return matrix;
    }

    public final void m(v vVar) {
        this.f10603w = vVar;
        o5.b bVar = this.f10591c;
        if (bVar == null || bVar.l() != null) {
            return;
        }
        o5.f fVar = new o5.f(getDisplayRotation(), vVar);
        this.f10601u = fVar;
        fVar.e(getPreviewScalingStrategy());
        this.f10591c.r(this.f10601u);
        this.f10591c.k();
        boolean z10 = this.F;
        if (z10) {
            this.f10591c.u(z10);
        }
    }

    public o5.b n() {
        o5.b bVar = new o5.b(getContext());
        bVar.q(this.f10602v);
        return bVar;
    }

    public final void o() {
        if (this.f10591c != null) {
            Log.w(K, "initCamera called twice");
            return;
        }
        o5.b bVarN = n();
        this.f10591c = bVarN;
        bVarN.s(this.f10593m);
        this.f10591c.o();
        this.f10599s = getDisplayRotation();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        y();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        m(new v(i12 - i10, i13 - i11));
        SurfaceView surfaceView = this.f10595o;
        if (surfaceView == null) {
            TextureView textureView = this.f10596p;
            if (textureView != null) {
                textureView.layout(0, 0, getWidth(), getHeight());
                return;
            }
            return;
        }
        Rect rect = this.f10605y;
        if (rect == null) {
            surfaceView.layout(0, 0, getWidth(), getHeight());
        } else {
            surfaceView.layout(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable("super"));
        setTorch(bundle.getBoolean("torch"));
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable("super", parcelableOnSaveInstanceState);
        bundle.putBoolean("torch", this.F);
        return bundle;
    }

    public final void p(Context context, AttributeSet attributeSet, int i10, int i11) {
        if (getBackground() == null) {
            setBackgroundColor(-16777216);
        }
        q(attributeSet);
        this.f10592e = (WindowManager) context.getSystemService("window");
        this.f10593m = new Handler(this.H);
        this.f10598r = new u();
    }

    public void q(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, r.f10655a);
        int dimension = (int) typedArrayObtainStyledAttributes.getDimension(r.f10657c, -1.0f);
        int dimension2 = (int) typedArrayObtainStyledAttributes.getDimension(r.f10656b, -1.0f);
        if (dimension > 0 && dimension2 > 0) {
            this.C = new v(dimension, dimension2);
        }
        this.f10594n = typedArrayObtainStyledAttributes.getBoolean(r.f10659e, true);
        int integer = typedArrayObtainStyledAttributes.getInteger(r.f10658d, -1);
        if (integer == 1) {
            this.E = new o5.e();
        } else if (integer == 2) {
            this.E = new o5.g();
        } else if (integer == 3) {
            this.E = new o5.h();
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public boolean r() {
        return this.f10591c != null;
    }

    public boolean s() {
        return this.f10597q;
    }

    public void setCameraSettings(CameraSettings cameraSettings) {
        this.f10602v = cameraSettings;
    }

    public void setFramingRectSize(v vVar) {
        this.C = vVar;
    }

    public void setMarginFraction(double d10) {
        if (d10 >= 0.5d) {
            throw new IllegalArgumentException("The margin fraction must be less than 0.5");
        }
        this.D = d10;
    }

    public void setPreviewScalingStrategy(o5.j jVar) {
        this.E = jVar;
    }

    public void setTorch(boolean z10) {
        this.F = z10;
        o5.b bVar = this.f10591c;
        if (bVar != null) {
            bVar.u(z10);
        }
    }

    public void setUseTextureView(boolean z10) {
        this.f10594n = z10;
    }

    public void t() {
        TextureView textureView;
        SurfaceView surfaceView;
        x.a();
        Log.d(K, "pause()");
        this.f10599s = -1;
        o5.b bVar = this.f10591c;
        if (bVar != null) {
            bVar.j();
            this.f10591c = null;
            this.f10597q = false;
        } else {
            this.f10593m.sendEmptyMessage(p.f10644b);
        }
        if (this.f10606z == null && (surfaceView = this.f10595o) != null) {
            surfaceView.getHolder().removeCallback(this.G);
        }
        if (this.f10606z == null && (textureView = this.f10596p) != null) {
            textureView.setSurfaceTextureListener(null);
        }
        this.f10603w = null;
        this.f10604x = null;
        this.B = null;
        this.f10598r.f();
        this.J.c();
    }

    public final void u(v vVar) {
        this.f10604x = vVar;
        if (this.f10603w != null) {
            j();
            requestLayout();
            A();
        }
    }

    public void w() {
        x.a();
        Log.d(K, "resume()");
        o();
        if (this.f10606z != null) {
            A();
        } else {
            SurfaceView surfaceView = this.f10595o;
            if (surfaceView != null) {
                surfaceView.getHolder().addCallback(this.G);
            } else {
                TextureView textureView = this.f10596p;
                if (textureView != null) {
                    if (textureView.isAvailable()) {
                        B().onSurfaceTextureAvailable(this.f10596p.getSurfaceTexture(), this.f10596p.getWidth(), this.f10596p.getHeight());
                    } else {
                        this.f10596p.setSurfaceTextureListener(B());
                    }
                }
            }
        }
        requestLayout();
        this.f10598r.e(getContext(), this.I);
    }

    public final void x() {
        if (!r() || getDisplayRotation() == this.f10599s) {
            return;
        }
        t();
        w();
    }

    public final void y() {
        if (this.f10594n) {
            TextureView textureView = new TextureView(getContext());
            this.f10596p = textureView;
            textureView.setSurfaceTextureListener(B());
            addView(this.f10596p);
            return;
        }
        SurfaceView surfaceView = new SurfaceView(getContext());
        this.f10595o = surfaceView;
        surfaceView.getHolder().addCallback(this.G);
        addView(this.f10595o);
    }

    public final void z(o5.c cVar) {
        if (this.f10597q || this.f10591c == null) {
            return;
        }
        Log.i(K, "Starting preview");
        this.f10591c.t(cVar);
        this.f10591c.v();
        this.f10597q = true;
        v();
        this.J.e();
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements TextureView.SurfaceTextureListener {
        public a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) {
            onSurfaceTextureSizeChanged(surfaceTexture, i10, i11);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i10, int i11) {
            f.this.f10606z = new v(i10, i11);
            f.this.A();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b implements SurfaceHolder.Callback {
        public b() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i10, int i11, int i12) {
            if (surfaceHolder == null) {
                Log.e(f.K, "*** WARNING *** surfaceChanged() gave us a null surface!");
                return;
            }
            f.this.f10606z = new v(i11, i12);
            f.this.A();
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            f.this.f10606z = null;
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
        }
    }

    public void v() {
    }
}
