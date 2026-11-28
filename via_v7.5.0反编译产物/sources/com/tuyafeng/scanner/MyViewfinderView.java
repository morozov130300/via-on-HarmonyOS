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
import n5.v;
import n5.y;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class MyViewfinderView extends y {
    public int A;
    public int B;
    public float C;
    public float D;
    public LinearGradient E;
    public float[] F;
    public int[] G;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f3535y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f3536z;

    public MyViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3535y = 0.06f;
        this.f3536z = TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics());
        this.A = -1;
        this.B = 0;
        this.C = TypedValue.applyDimension(1, 3.0f, getResources().getDisplayMetrics());
        this.D = TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics());
        this.F = new float[]{0.0f, 0.5f, 1.0f};
        this.G = new int[]{16777215, -1, 16777215};
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        v vVar;
        b();
        Rect rect = this.f10696v;
        if (rect == null || (vVar = this.f10697w) == null) {
            return;
        }
        int width = getWidth();
        int height = getHeight();
        this.f10685c.setColor(this.A);
        this.f10685c.setStyle(Paint.Style.STROKE);
        canvas.drawRect(rect.left, rect.top, rect.right, rect.bottom, this.f10685c);
        this.f10685c.setStyle(Paint.Style.FILL);
        int i10 = rect.left;
        canvas.drawRect(i10, rect.top, (rect.width() * this.f3535y) + i10, this.f3536z + rect.top, this.f10685c);
        int i11 = rect.left;
        int i12 = rect.top;
        canvas.drawRect(i11, i12, i11 + this.f3536z, (rect.height() * this.f3535y) + i12, this.f10685c);
        float fWidth = rect.right - (rect.width() * this.f3535y);
        int i13 = rect.top;
        canvas.drawRect(fWidth, i13, rect.right, this.f3536z + i13, this.f10685c);
        int i14 = rect.right;
        float f10 = i14 - this.f3536z;
        int i15 = rect.top;
        canvas.drawRect(f10, i15, i14, (rect.height() * this.f3535y) + i15, this.f10685c);
        int i16 = rect.left;
        canvas.drawRect(i16, rect.bottom - this.f3536z, (rect.width() * this.f3535y) + i16, rect.bottom, this.f10685c);
        canvas.drawRect(rect.left, rect.bottom - (rect.height() * this.f3535y), this.f3536z + rect.left, rect.bottom, this.f10685c);
        float fWidth2 = rect.right - (rect.width() * this.f3535y);
        int i17 = rect.bottom;
        canvas.drawRect(fWidth2, i17 - this.f3536z, rect.right, i17, this.f10685c);
        canvas.drawRect(rect.right - this.f3536z, rect.bottom - (rect.height() * this.f3535y), rect.right, rect.bottom, this.f10685c);
        this.f10685c.setColor(this.f10686e != null ? this.f10688n : this.f10687m);
        float f11 = width;
        canvas.drawRect(0.0f, 0.0f, f11, rect.top, this.f10685c);
        canvas.drawRect(0.0f, rect.top, rect.left, rect.bottom + 1, this.f10685c);
        canvas.drawRect(rect.right + 1, rect.top, f11, rect.bottom + 1, this.f10685c);
        canvas.drawRect(0.0f, rect.bottom + 1, f11, height, this.f10685c);
        if (this.f10686e != null) {
            this.f10685c.setAlpha(160);
            canvas.drawBitmap(this.f10686e, (Rect) null, rect, this.f10685c);
        } else {
            int i18 = (int) (this.B + this.D);
            this.B = i18;
            if (i18 > rect.height()) {
                this.B = 0;
            }
            float f12 = rect.left;
            int i19 = rect.top;
            int i20 = this.B;
            LinearGradient linearGradient = new LinearGradient(f12, i19 + i20, rect.right, i19 + i20, this.G, this.F, Shader.TileMode.CLAMP);
            this.E = linearGradient;
            this.f10685c.setShader(linearGradient);
            float f13 = rect.left;
            int i21 = rect.top;
            int i22 = this.B;
            canvas.drawRect(f13, i21 + i22, rect.right, i21 + i22 + this.C, this.f10685c);
            this.f10685c.setShader(null);
            float fWidth3 = rect.width() / vVar.f10676c;
            float fHeight = rect.height() / vVar.f10677e;
            List<k> list = this.f10693s;
            List<k> list2 = this.f10694t;
            int i23 = rect.left;
            int i24 = rect.top;
            if (list.isEmpty()) {
                this.f10694t = null;
            } else {
                this.f10693s = new ArrayList(5);
                this.f10694t = list;
                this.f10685c.setAlpha(160);
                this.f10685c.setColor(this.f10690p);
                for (k kVar : list) {
                    canvas.drawCircle(((int) (kVar.c() * fWidth3)) + i23, ((int) (kVar.d() * fHeight)) + i24, 6.0f, this.f10685c);
                }
            }
            if (list2 != null) {
                this.f10685c.setAlpha(80);
                this.f10685c.setColor(this.f10690p);
                for (k kVar2 : list2) {
                    canvas.drawCircle(((int) (kVar2.c() * fWidth3)) + i23, ((int) (kVar2.d() * fHeight)) + i24, 3.0f, this.f10685c);
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
