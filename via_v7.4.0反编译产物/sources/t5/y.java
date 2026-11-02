package t5;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import t5.f;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class y extends View {

    /* renamed from: v, reason: collision with root package name */
    public static final int[] f12255v = {0, 64, 128, 192, 255, 192, 128, 64};

    /* renamed from: e, reason: collision with root package name */
    public final Paint f12256e;

    /* renamed from: j, reason: collision with root package name */
    public Bitmap f12257j;

    /* renamed from: k, reason: collision with root package name */
    public int f12258k;

    /* renamed from: l, reason: collision with root package name */
    public final int f12259l;

    /* renamed from: m, reason: collision with root package name */
    public final int f12260m;

    /* renamed from: n, reason: collision with root package name */
    public final int f12261n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f12262o;

    /* renamed from: p, reason: collision with root package name */
    public int f12263p;

    /* renamed from: q, reason: collision with root package name */
    public List f12264q;

    /* renamed from: r, reason: collision with root package name */
    public List f12265r;

    /* renamed from: s, reason: collision with root package name */
    public f f12266s;

    /* renamed from: t, reason: collision with root package name */
    public Rect f12267t;

    /* renamed from: u, reason: collision with root package name */
    public v f12268u;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements f.InterfaceC0124f {
        public a() {
        }

        @Override // t5.f.InterfaceC0124f
        public void a() {
            y.this.b();
            y.this.invalidate();
        }

        @Override // t5.f.InterfaceC0124f
        public void b(Exception exc) {
        }

        @Override // t5.f.InterfaceC0124f
        public void c() {
        }

        @Override // t5.f.InterfaceC0124f
        public void d() {
        }

        @Override // t5.f.InterfaceC0124f
        public void e() {
        }
    }

    public y(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12256e = new Paint(1);
        Resources resources = getResources();
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, r.f12231f);
        this.f12258k = typedArrayObtainStyledAttributes.getColor(r.f12236k, resources.getColor(o.f12213d));
        this.f12259l = typedArrayObtainStyledAttributes.getColor(r.f12233h, resources.getColor(o.f12211b));
        this.f12260m = typedArrayObtainStyledAttributes.getColor(r.f12234i, resources.getColor(o.f12212c));
        this.f12261n = typedArrayObtainStyledAttributes.getColor(r.f12232g, resources.getColor(o.f12210a));
        this.f12262o = typedArrayObtainStyledAttributes.getBoolean(r.f12235j, true);
        typedArrayObtainStyledAttributes.recycle();
        this.f12263p = 0;
        this.f12264q = new ArrayList(20);
        this.f12265r = new ArrayList(20);
    }

    public void a(com.google.zxing.k kVar) {
        if (this.f12264q.size() < 20) {
            this.f12264q.add(kVar);
        }
    }

    public void b() {
        f fVar = this.f12266s;
        if (fVar == null) {
            return;
        }
        Rect framingRect = fVar.getFramingRect();
        v previewSize = this.f12266s.getPreviewSize();
        if (framingRect == null || previewSize == null) {
            return;
        }
        this.f12267t = framingRect;
        this.f12268u = previewSize;
    }

    public void setCameraPreview(f fVar) {
        this.f12266s = fVar;
        fVar.i(new a());
    }

    public void setLaserVisibility(boolean z10) {
        this.f12262o = z10;
    }

    public void setMaskColor(int i10) {
        this.f12258k = i10;
    }
}
