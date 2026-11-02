package k8;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class l extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public Paint f8209a;

    /* renamed from: b, reason: collision with root package name */
    public Bitmap f8210b;

    /* renamed from: c, reason: collision with root package name */
    public int f8211c;

    /* renamed from: d, reason: collision with root package name */
    public int f8212d;

    /* renamed from: e, reason: collision with root package name */
    public int f8213e;

    public l(Bitmap bitmap, int i10) {
        this.f8210b = bitmap;
        Bitmap bitmap2 = this.f8210b;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap2, tileMode, tileMode);
        Paint paint = new Paint();
        this.f8209a = paint;
        paint.setAntiAlias(true);
        this.f8209a.setShader(bitmapShader);
        this.f8211c = this.f8210b.getWidth();
        this.f8212d = this.f8210b.getHeight();
        this.f8213e = i10;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        RectF rectF = new RectF(0.0f, 0.0f, this.f8211c, this.f8212d);
        int i10 = this.f8213e;
        canvas.drawRoundRect(rectF, i10, i10, this.f8209a);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f8212d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f8211c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f8209a.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f8209a.setColorFilter(colorFilter);
    }
}
