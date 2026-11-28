package n5;

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

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class y extends View {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int[] f10684x = {0, 64, 128, 192, 255, 192, 128, 64};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f10685c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Bitmap f10686e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f10687m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f10688n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f10689o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f10690p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f10691q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f10692r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public List f10693s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public List f10694t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public f f10695u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Rect f10696v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public v f10697w;

    public y(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10685c = new Paint(1);
        Resources resources = getResources();
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, r.f10660f);
        this.f10687m = typedArrayObtainStyledAttributes.getColor(r.f10665k, resources.getColor(o.f10642d));
        this.f10688n = typedArrayObtainStyledAttributes.getColor(r.f10662h, resources.getColor(o.f10640b));
        this.f10689o = typedArrayObtainStyledAttributes.getColor(r.f10663i, resources.getColor(o.f10641c));
        this.f10690p = typedArrayObtainStyledAttributes.getColor(r.f10661g, resources.getColor(o.f10639a));
        this.f10691q = typedArrayObtainStyledAttributes.getBoolean(r.f10664j, true);
        typedArrayObtainStyledAttributes.recycle();
        this.f10692r = 0;
        this.f10693s = new ArrayList(20);
        this.f10694t = new ArrayList(20);
    }

    public void a(com.google.zxing.k kVar) {
        if (this.f10693s.size() < 20) {
            this.f10693s.add(kVar);
        }
    }

    public void b() {
        f fVar = this.f10695u;
        if (fVar == null) {
            return;
        }
        Rect framingRect = fVar.getFramingRect();
        v previewSize = this.f10695u.getPreviewSize();
        if (framingRect == null || previewSize == null) {
            return;
        }
        this.f10696v = framingRect;
        this.f10697w = previewSize;
    }

    public void setCameraPreview(f fVar) {
        this.f10695u = fVar;
        fVar.i(new a());
    }

    public void setLaserVisibility(boolean z10) {
        this.f10691q = z10;
    }

    public void setMaskColor(int i10) {
        this.f10687m = i10;
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements f.InterfaceC0102f {
        public a() {
        }

        @Override // n5.f.InterfaceC0102f
        public void a() {
            y.this.b();
            y.this.invalidate();
        }

        @Override // n5.f.InterfaceC0102f
        public void b(Exception exc) {
        }

        @Override // n5.f.InterfaceC0102f
        public void c() {
        }

        @Override // n5.f.InterfaceC0102f
        public void d() {
        }

        @Override // n5.f.InterfaceC0102f
        public void e() {
        }
    }
}
