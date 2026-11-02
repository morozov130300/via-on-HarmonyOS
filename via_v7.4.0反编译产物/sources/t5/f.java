package t5;

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

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class f extends ViewGroup {
    public static final String I = "f";
    public v A;
    public double B;
    public u5.j C;
    public boolean D;
    public final SurfaceHolder.Callback E;
    public final Handler.Callback F;
    public t G;
    public final InterfaceC0124f H;

    /* renamed from: e, reason: collision with root package name */
    public u5.b f12160e;

    /* renamed from: j, reason: collision with root package name */
    public WindowManager f12161j;

    /* renamed from: k, reason: collision with root package name */
    public Handler f12162k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f12163l;

    /* renamed from: m, reason: collision with root package name */
    public SurfaceView f12164m;

    /* renamed from: n, reason: collision with root package name */
    public TextureView f12165n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f12166o;

    /* renamed from: p, reason: collision with root package name */
    public u f12167p;

    /* renamed from: q, reason: collision with root package name */
    public int f12168q;

    /* renamed from: r, reason: collision with root package name */
    public List f12169r;

    /* renamed from: s, reason: collision with root package name */
    public u5.f f12170s;

    /* renamed from: t, reason: collision with root package name */
    public CameraSettings f12171t;

    /* renamed from: u, reason: collision with root package name */
    public v f12172u;

    /* renamed from: v, reason: collision with root package name */
    public v f12173v;

    /* renamed from: w, reason: collision with root package name */
    public Rect f12174w;

    /* renamed from: x, reason: collision with root package name */
    public v f12175x;

    /* renamed from: y, reason: collision with root package name */
    public Rect f12176y;

    /* renamed from: z, reason: collision with root package name */
    public Rect f12177z;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
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
            f.this.f12175x = new v(i10, i11);
            f.this.A();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b implements SurfaceHolder.Callback {
        public b() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i10, int i11, int i12) {
            if (surfaceHolder == null) {
                Log.e(f.I, "*** WARNING *** surfaceChanged() gave us a null surface!");
                return;
            }
            f.this.f12175x = new v(i11, i12);
            f.this.A();
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            f.this.f12175x = null;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class c implements Handler.Callback {
        public c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == p.f12222i) {
                f.this.u((v) message.obj);
                return true;
            }
            if (i10 != p.f12216c) {
                if (i10 != p.f12215b) {
                    return false;
                }
                f.this.H.d();
                return false;
            }
            Exception exc = (Exception) message.obj;
            if (!f.this.r()) {
                return false;
            }
            f.this.t();
            f.this.H.b(exc);
            return false;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class d implements t {

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
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

        @Override // t5.t
        public void a(int i10) {
            f.this.f12162k.postDelayed(new a(), 250L);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class e implements InterfaceC0124f {
        public e() {
        }

        @Override // t5.f.InterfaceC0124f
        public void a() {
            Iterator it = f.this.f12169r.iterator();
            while (it.hasNext()) {
                ((InterfaceC0124f) it.next()).a();
            }
        }

        @Override // t5.f.InterfaceC0124f
        public void b(Exception exc) {
            Iterator it = f.this.f12169r.iterator();
            while (it.hasNext()) {
                ((InterfaceC0124f) it.next()).b(exc);
            }
        }

        @Override // t5.f.InterfaceC0124f
        public void c() {
            Iterator it = f.this.f12169r.iterator();
            while (it.hasNext()) {
                ((InterfaceC0124f) it.next()).c();
            }
        }

        @Override // t5.f.InterfaceC0124f
        public void d() {
            Iterator it = f.this.f12169r.iterator();
            while (it.hasNext()) {
                ((InterfaceC0124f) it.next()).d();
            }
        }

        @Override // t5.f.InterfaceC0124f
        public void e() {
            Iterator it = f.this.f12169r.iterator();
            while (it.hasNext()) {
                ((InterfaceC0124f) it.next()).e();
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: t5.f$f, reason: collision with other inner class name */
    public interface InterfaceC0124f {
        void a();

        void b(Exception exc);

        void c();

        void d();

        void e();
    }

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12163l = false;
        this.f12166o = false;
        this.f12168q = -1;
        this.f12169r = new ArrayList();
        this.f12171t = new CameraSettings();
        this.f12176y = null;
        this.f12177z = null;
        this.A = null;
        this.B = 0.1d;
        this.C = null;
        this.D = false;
        this.E = new b();
        this.F = new c();
        this.G = new d();
        this.H = new e();
        p(context, attributeSet, 0, 0);
    }

    private int getDisplayRotation() {
        return this.f12161j.getDefaultDisplay().getRotation();
    }

    public final void A() {
        Rect rect;
        v vVar = this.f12175x;
        if (vVar == null || this.f12173v == null || (rect = this.f12174w) == null) {
            return;
        }
        if (this.f12164m != null && vVar.equals(new v(rect.width(), this.f12174w.height()))) {
            z(new u5.c(this.f12164m.getHolder()));
            return;
        }
        TextureView textureView = this.f12165n;
        if (textureView == null || textureView.getSurfaceTexture() == null) {
            return;
        }
        if (this.f12173v != null) {
            this.f12165n.setTransform(l(new v(this.f12165n.getWidth(), this.f12165n.getHeight()), this.f12173v));
        }
        z(new u5.c(this.f12165n.getSurfaceTexture()));
    }

    public final TextureView.SurfaceTextureListener B() {
        return new a();
    }

    public u5.b getCameraInstance() {
        return this.f12160e;
    }

    public CameraSettings getCameraSettings() {
        return this.f12171t;
    }

    public Rect getFramingRect() {
        return this.f12176y;
    }

    public v getFramingRectSize() {
        return this.A;
    }

    public double getMarginFraction() {
        return this.B;
    }

    public Rect getPreviewFramingRect() {
        return this.f12177z;
    }

    public u5.j getPreviewScalingStrategy() {
        u5.j jVar = this.C;
        return jVar != null ? jVar : this.f12165n != null ? new u5.e() : new u5.g();
    }

    public v getPreviewSize() {
        return this.f12173v;
    }

    public void i(InterfaceC0124f interfaceC0124f) {
        this.f12169r.add(interfaceC0124f);
    }

    public final void j() {
        v vVar;
        u5.f fVar;
        v vVar2 = this.f12172u;
        if (vVar2 == null || (vVar = this.f12173v) == null || (fVar = this.f12170s) == null) {
            this.f12177z = null;
            this.f12176y = null;
            this.f12174w = null;
            throw new IllegalStateException("containerSize or previewSize is not set yet");
        }
        int i10 = vVar.f12247e;
        int i11 = vVar.f12248j;
        int i12 = vVar2.f12247e;
        int i13 = vVar2.f12248j;
        Rect rectD = fVar.d(vVar);
        if (rectD.width() <= 0 || rectD.height() <= 0) {
            return;
        }
        this.f12174w = rectD;
        this.f12176y = k(new Rect(0, 0, i12, i13), this.f12174w);
        Rect rect = new Rect(this.f12176y);
        Rect rect2 = this.f12174w;
        rect.offset(-rect2.left, -rect2.top);
        Rect rect3 = new Rect((rect.left * i10) / this.f12174w.width(), (rect.top * i11) / this.f12174w.height(), (rect.right * i10) / this.f12174w.width(), (rect.bottom * i11) / this.f12174w.height());
        this.f12177z = rect3;
        if (rect3.width() > 0 && this.f12177z.height() > 0) {
            this.H.a();
            return;
        }
        this.f12177z = null;
        this.f12176y = null;
        Log.w(I, "Preview frame is too small");
    }

    public Rect k(Rect rect, Rect rect2) {
        Rect rect3 = new Rect(rect);
        rect3.intersect(rect2);
        if (this.A != null) {
            rect3.inset(Math.max(0, (rect3.width() - this.A.f12247e) / 2), Math.max(0, (rect3.height() - this.A.f12248j) / 2));
            return rect3;
        }
        double dWidth = rect3.width();
        double d10 = this.B;
        Double.isNaN(dWidth);
        double d11 = dWidth * d10;
        double dHeight = rect3.height();
        double d12 = this.B;
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
        float f11 = vVar.f12247e / vVar.f12248j;
        float f12 = vVar2.f12247e / vVar2.f12248j;
        float f13 = 1.0f;
        if (f11 < f12) {
            f13 = f12 / f11;
            f10 = 1.0f;
        } else {
            f10 = f11 / f12;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(f13, f10);
        int i10 = vVar.f12247e;
        int i11 = vVar.f12248j;
        matrix.postTranslate((i10 - (i10 * f13)) / 2.0f, (i11 - (i11 * f10)) / 2.0f);
        return matrix;
    }

    public final void m(v vVar) {
        this.f12172u = vVar;
        u5.b bVar = this.f12160e;
        if (bVar == null || bVar.l() != null) {
            return;
        }
        u5.f fVar = new u5.f(getDisplayRotation(), vVar);
        this.f12170s = fVar;
        fVar.e(getPreviewScalingStrategy());
        this.f12160e.r(this.f12170s);
        this.f12160e.k();
        boolean z10 = this.D;
        if (z10) {
            this.f12160e.u(z10);
        }
    }

    public u5.b n() {
        u5.b bVar = new u5.b(getContext());
        bVar.q(this.f12171t);
        return bVar;
    }

    public final void o() {
        if (this.f12160e != null) {
            Log.w(I, "initCamera called twice");
            return;
        }
        u5.b bVarN = n();
        this.f12160e = bVarN;
        bVarN.s(this.f12162k);
        this.f12160e.o();
        this.f12168q = getDisplayRotation();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        y();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        m(new v(i12 - i10, i13 - i11));
        SurfaceView surfaceView = this.f12164m;
        if (surfaceView == null) {
            TextureView textureView = this.f12165n;
            if (textureView != null) {
                textureView.layout(0, 0, getWidth(), getHeight());
                return;
            }
            return;
        }
        Rect rect = this.f12174w;
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
        bundle.putBoolean("torch", this.D);
        return bundle;
    }

    public final void p(Context context, AttributeSet attributeSet, int i10, int i11) {
        if (getBackground() == null) {
            setBackgroundColor(-16777216);
        }
        q(attributeSet);
        this.f12161j = (WindowManager) context.getSystemService("window");
        this.f12162k = new Handler(this.F);
        this.f12167p = new u();
    }

    public void q(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, r.f12226a);
        int dimension = (int) typedArrayObtainStyledAttributes.getDimension(r.f12228c, -1.0f);
        int dimension2 = (int) typedArrayObtainStyledAttributes.getDimension(r.f12227b, -1.0f);
        if (dimension > 0 && dimension2 > 0) {
            this.A = new v(dimension, dimension2);
        }
        this.f12163l = typedArrayObtainStyledAttributes.getBoolean(r.f12230e, true);
        int integer = typedArrayObtainStyledAttributes.getInteger(r.f12229d, -1);
        if (integer == 1) {
            this.C = new u5.e();
        } else if (integer == 2) {
            this.C = new u5.g();
        } else if (integer == 3) {
            this.C = new u5.h();
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public boolean r() {
        return this.f12160e != null;
    }

    public boolean s() {
        return this.f12166o;
    }

    public void setCameraSettings(CameraSettings cameraSettings) {
        this.f12171t = cameraSettings;
    }

    public void setFramingRectSize(v vVar) {
        this.A = vVar;
    }

    public void setMarginFraction(double d10) {
        if (d10 >= 0.5d) {
            throw new IllegalArgumentException("The margin fraction must be less than 0.5");
        }
        this.B = d10;
    }

    public void setPreviewScalingStrategy(u5.j jVar) {
        this.C = jVar;
    }

    public void setTorch(boolean z10) {
        this.D = z10;
        u5.b bVar = this.f12160e;
        if (bVar != null) {
            bVar.u(z10);
        }
    }

    public void setUseTextureView(boolean z10) {
        this.f12163l = z10;
    }

    public void t() {
        TextureView textureView;
        SurfaceView surfaceView;
        x.a();
        Log.d(I, "pause()");
        this.f12168q = -1;
        u5.b bVar = this.f12160e;
        if (bVar != null) {
            bVar.j();
            this.f12160e = null;
            this.f12166o = false;
        } else {
            this.f12162k.sendEmptyMessage(p.f12215b);
        }
        if (this.f12175x == null && (surfaceView = this.f12164m) != null) {
            surfaceView.getHolder().removeCallback(this.E);
        }
        if (this.f12175x == null && (textureView = this.f12165n) != null) {
            textureView.setSurfaceTextureListener(null);
        }
        this.f12172u = null;
        this.f12173v = null;
        this.f12177z = null;
        this.f12167p.f();
        this.H.c();
    }

    public final void u(v vVar) {
        this.f12173v = vVar;
        if (this.f12172u != null) {
            j();
            requestLayout();
            A();
        }
    }

    public void v() {
    }

    public void w() {
        x.a();
        Log.d(I, "resume()");
        o();
        if (this.f12175x != null) {
            A();
        } else {
            SurfaceView surfaceView = this.f12164m;
            if (surfaceView != null) {
                surfaceView.getHolder().addCallback(this.E);
            } else {
                TextureView textureView = this.f12165n;
                if (textureView != null) {
                    if (textureView.isAvailable()) {
                        B().onSurfaceTextureAvailable(this.f12165n.getSurfaceTexture(), this.f12165n.getWidth(), this.f12165n.getHeight());
                    } else {
                        this.f12165n.setSurfaceTextureListener(B());
                    }
                }
            }
        }
        requestLayout();
        this.f12167p.e(getContext(), this.G);
    }

    public final void x() {
        if (!r() || getDisplayRotation() == this.f12168q) {
            return;
        }
        t();
        w();
    }

    public final void y() {
        if (this.f12163l) {
            TextureView textureView = new TextureView(getContext());
            this.f12165n = textureView;
            textureView.setSurfaceTextureListener(B());
            addView(this.f12165n);
            return;
        }
        SurfaceView surfaceView = new SurfaceView(getContext());
        this.f12164m = surfaceView;
        surfaceView.getHolder().addCallback(this.E);
        addView(this.f12164m);
    }

    public final void z(u5.c cVar) {
        if (this.f12166o || this.f12160e == null) {
            return;
        }
        Log.i(I, "Starting preview");
        this.f12160e.t(cVar);
        this.f12160e.v();
        this.f12166o = true;
        v();
        this.H.e();
    }
}
