package g6;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public int f6215a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final float[] f6216b = new float[8];

    /* renamed from: c, reason: collision with root package name */
    public int f6217c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f6218d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f6219e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f6220f = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f6221g = 0;

    /* renamed from: h, reason: collision with root package name */
    public final int[] f6222h = new int[2];

    public Drawable a() {
        int i10 = this.f6218d;
        if (i10 == 0 && this.f6219e == 0) {
            return b(this.f6215a, this.f6217c, this.f6216b, this.f6222h, this.f6220f, this.f6221g);
        }
        if (Build.VERSION.SDK_INT >= 21 && i10 != 0) {
            GradientDrawable gradientDrawableB = b(this.f6215a, -16777216, this.f6216b, this.f6222h, this.f6220f, this.f6221g);
            return new RippleDrawable(ColorStateList.valueOf(this.f6218d), b(this.f6215a, this.f6217c, this.f6216b, this.f6222h, this.f6220f, this.f6221g), gradientDrawableB);
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        int i11 = this.f6218d;
        if (i11 != 0) {
            stateListDrawable.addState(new int[]{R.attr.state_enabled, R.attr.state_pressed}, b(this.f6215a, i11, this.f6216b, this.f6222h, this.f6220f, this.f6221g));
        }
        int i12 = this.f6219e;
        if (i12 != 0) {
            stateListDrawable.addState(new int[]{R.attr.state_enabled, R.attr.state_focused}, b(this.f6215a, i12, this.f6216b, this.f6222h, this.f6220f, this.f6221g));
        }
        stateListDrawable.addState(new int[]{R.attr.state_enabled}, b(this.f6215a, this.f6217c, this.f6216b, this.f6222h, this.f6220f, this.f6221g));
        return stateListDrawable;
    }

    public final GradientDrawable b(int i10, int i11, float[] fArr, int[] iArr, int i12, int i13) {
        int i14;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(i10);
        gradientDrawable.setColor(i11);
        if (fArr != null) {
            gradientDrawable.setCornerRadii(fArr);
        }
        if (iArr != null && ((i14 = iArr[0]) != 0 || iArr[1] != 0)) {
            gradientDrawable.setSize(i14, iArr[1]);
        }
        if (i13 > 0) {
            gradientDrawable.setStroke(i13, i12);
        }
        return gradientDrawable;
    }

    public g c(float f10) {
        return e(f10, f10, f10, f10);
    }

    public g d(float f10, float f11) {
        return e(f10, f10, f11, f11);
    }

    public g e(float f10, float f11, float f12, float f13) {
        float[] fArr = this.f6216b;
        fArr[0] = f10;
        fArr[1] = f10;
        fArr[2] = f11;
        fArr[3] = f11;
        fArr[4] = f12;
        fArr[5] = f12;
        fArr[6] = f13;
        fArr[7] = f13;
        return this;
    }

    public g f(int i10) {
        this.f6215a = i10;
        return this;
    }

    public g g(int i10, int i11) {
        int[] iArr = this.f6222h;
        iArr[0] = i10;
        iArr[1] = i11;
        return this;
    }

    public g h(int i10) {
        this.f6217c = i10;
        return this;
    }

    public g i(int i10) {
        this.f6219e = i10;
        return this;
    }

    public g j(int i10) {
        this.f6218d = i10;
        return this;
    }

    public g k(int i10) {
        this.f6220f = i10;
        return this;
    }

    public g l(int i10) {
        this.f6221g = i10;
        return this;
    }
}
