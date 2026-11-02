package com.tuyafeng.scanner;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.google.zxing.k;
import java.util.ArrayList;
import java.util.List;
import t5.v;
import t5.y;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class MyViewfinderView extends y {
    public float A;
    public float B;
    public LinearGradient C;
    public float[] D;
    public int[] E;

    /* renamed from: w, reason: collision with root package name */
    public float f4240w;

    /* renamed from: x, reason: collision with root package name */
    public float f4241x;

    /* renamed from: y, reason: collision with root package name */
    public int f4242y;

    /* renamed from: z, reason: collision with root package name */
    public int f4243z;

    public MyViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4240w = 0.06f;
        this.f4241x = TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics());
        this.f4242y = -1;
        this.f4243z = 0;
        this.A = TypedValue.applyDimension(1, 3.0f, getResources().getDisplayMetrics());
        this.B = TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics());
        this.D = new float[]{0.0f, 0.5f, 1.0f};
        this.E = new int[]{16777215, -1, 16777215};
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        v vVar;
        b();
        Rect rect = this.f12267t;
        if (rect == null || (vVar = this.f12268u) == null) {
            return;
        }
        int width = getWidth();
        int height = getHeight();
        this.f12256e.setColor(this.f4242y);
        this.f12256e.setStyle(Paint.Style.STROKE);
        canvas.drawRect(rect.left, rect.top, rect.right, rect.bottom, this.f12256e);
        this.f12256e.setStyle(Paint.Style.FILL);
        int i10 = rect.left;
        canvas.drawRect(i10, rect.top, (rect.width() * this.f4240w) + i10, this.f4241x + rect.top, this.f12256e);
        int i11 = rect.left;
        int i12 = rect.top;
        canvas.drawRect(i11, i12, i11 + this.f4241x, (rect.height() * this.f4240w) + i12, this.f12256e);
        float fWidth = rect.right - (rect.width() * this.f4240w);
        int i13 = rect.top;
        canvas.drawRect(fWidth, i13, rect.right, this.f4241x + i13, this.f12256e);
        int i14 = rect.right;
        float f10 = i14 - this.f4241x;
        int i15 = rect.top;
        canvas.drawRect(f10, i15, i14, (rect.height() * this.f4240w) + i15, this.f12256e);
        int i16 = rect.left;
        canvas.drawRect(i16, rect.bottom - this.f4241x, (rect.width() * this.f4240w) + i16, rect.bottom, this.f12256e);
        canvas.drawRect(rect.left, rect.bottom - (rect.height() * this.f4240w), this.f4241x + rect.left, rect.bottom, this.f12256e);
        float fWidth2 = rect.right - (rect.width() * this.f4240w);
        int i17 = rect.bottom;
        canvas.drawRect(fWidth2, i17 - this.f4241x, rect.right, i17, this.f12256e);
        canvas.drawRect(rect.right - this.f4241x, rect.bottom - (rect.height() * this.f4240w), rect.right, rect.bottom, this.f12256e);
        this.f12256e.setColor(this.f12257j != null ? this.f12259l : this.f12258k);
        float f11 = width;
        canvas.drawRect(0.0f, 0.0f, f11, rect.top, this.f12256e);
        canvas.drawRect(0.0f, rect.top, rect.left, rect.bottom + 1, this.f12256e);
        canvas.drawRect(rect.right + 1, rect.top, f11, rect.bottom + 1, this.f12256e);
        canvas.drawRect(0.0f, rect.bottom + 1, f11, height, this.f12256e);
        if (this.f12257j != null) {
            this.f12256e.setAlpha(160);
            canvas.drawBitmap(this.f12257j, (Rect) null, rect, this.f12256e);
        } else {
            int i18 = (int) (this.f4243z + this.B);
            this.f4243z = i18;
            if (i18 > rect.height()) {
                this.f4243z = 0;
            }
            float f12 = rect.left;
            int i19 = rect.top;
            int i20 = this.f4243z;
            LinearGradient linearGradient = new LinearGradient(f12, i19 + i20, rect.right, i19 + i20, this.E, this.D, Shader.TileMode.CLAMP);
            this.C = linearGradient;
            this.f12256e.setShader(linearGradient);
            float f13 = rect.left;
            int i21 = rect.top;
            int i22 = this.f4243z;
            canvas.drawRect(f13, i21 + i22, rect.right, i21 + i22 + this.A, this.f12256e);
            this.f12256e.setShader(null);
            float fWidth3 = rect.width() / vVar.f12247e;
            float fHeight = rect.height() / vVar.f12248j;
            List<k> list = this.f12264q;
            List<k> list2 = this.f12265r;
            int i23 = rect.left;
            int i24 = rect.top;
            if (list.isEmpty()) {
                this.f12265r = null;
            } else {
                this.f12264q = new ArrayList(5);
                this.f12265r = list;
                this.f12256e.setAlpha(160);
                this.f12256e.setColor(this.f12261n);
                for (k kVar : list) {
                    canvas.drawCircle(((int) (kVar.c() * fWidth3)) + i23, ((int) (kVar.d() * fHeight)) + i24, 6.0f, this.f12256e);
                }
            }
            if (list2 != null) {
                this.f12256e.setAlpha(80);
                this.f12256e.setColor(this.f12261n);
                for (k kVar2 : list2) {
                    canvas.drawCircle(((int) (kVar2.c() * fWidth3)) + i23, ((int) (kVar2.d() * fHeight)) + i24, 3.0f, this.f12256e);
                }
            }
        }
        postInvalidateDelayed(16L, rect.left, rect.top, rect.right, rect.bottom);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
    }
}
