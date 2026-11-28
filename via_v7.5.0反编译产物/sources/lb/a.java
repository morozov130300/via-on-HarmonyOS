package lb;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a extends Drawable implements Drawable.Callback {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Drawable f7603c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f7604e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f7605m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Bitmap f7607o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ColorFilter f7608p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ColorStateList f7609q;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Paint f7606n = new Paint(3);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public PorterDuff.Mode f7610r = PorterDuff.Mode.SRC_IN;

    public a(Drawable drawable) {
        this.f7604e = drawable == null ? 96 : drawable.getIntrinsicWidth();
        this.f7605m = drawable != null ? drawable.getIntrinsicHeight() : 96;
        Drawable colorDrawable = drawable == null ? new ColorDrawable(0) : drawable.mutate();
        this.f7603c = colorDrawable;
        colorDrawable.setCallback(this);
    }

    public void a(Bitmap bitmap) {
        this.f7607o = bitmap;
        this.f7603c.setCallback(null);
        invalidateSelf();
    }

    public final void b() {
        ColorFilter porterDuffColorFilter = this.f7608p;
        if (porterDuffColorFilter == null && this.f7609q != null && this.f7610r != null) {
            porterDuffColorFilter = new PorterDuffColorFilter(this.f7609q.getColorForState(getState(), this.f7609q.getDefaultColor()), this.f7610r);
        }
        this.f7606n.setColorFilter(porterDuffColorFilter);
        this.f7603c.setColorFilter(porterDuffColorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap = this.f7607o;
        if (bitmap == null) {
            this.f7603c.draw(canvas);
        } else {
            canvas.drawBitmap(bitmap, (Rect) null, getBounds(), this.f7606n);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f7606n.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f7606n.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f7605m;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f7604e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.f7609q;
        if (colorStateList == null || !colorStateList.isStateful()) {
            return this.f7607o == null && this.f7603c.isStateful();
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.f7603c.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i10) {
        return s.a.a(this.f7603c, i10);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i10) {
        return this.f7603c.setLevel(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean state = this.f7603c.setState(iArr);
        b();
        invalidateSelf();
        if (state) {
            return true;
        }
        ColorStateList colorStateList = this.f7609q;
        return colorStateList != null && colorStateList.isStateful();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        scheduleSelf(runnable, j10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f7606n.setAlpha(i10);
        this.f7603c.setAlpha(i10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f7608p = colorFilter;
        b();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i10) {
        setTintList(ColorStateList.valueOf(i10));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f7609q = colorStateList;
        b();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f7610r = mode;
        b();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        return this.f7603c.setVisible(z10, z11) || super.setVisible(z10, z11);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
