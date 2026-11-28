package com.tuyafeng.support.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager2.widget.ViewPager2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class TabLayout extends HorizontalScrollView {
    public static final int[] Q = {R.attr.textColorPrimary, R.attr.padding, R.attr.paddingLeft, R.attr.paddingRight};
    public int A;
    public int B;
    public int C;
    public ColorStateList D;
    public int E;
    public int F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public Typeface K;
    public int L;
    public int M;
    public int N;
    public int O;
    public String[] P;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinearLayout f3610c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LinearLayout.LayoutParams f3611e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final d f3612m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ViewPager2.i f3613n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ViewPager2 f3614o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f3615p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f3616q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f3617r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Paint f3618s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Paint f3619t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f3620u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f3621v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f3622w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f3623x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f3624y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f3625z;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f3626c;

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f3626c);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f3626c = parcel.readInt();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements b6.a.InterfaceC0033a {
        public a() {
        }

        @Override // b6.a.InterfaceC0033a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(TextView textView) {
            textView.setMaxLines(1);
            textView.setGravity(17);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f3628a;

        public b(int i10) {
            this.f3628a = i10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TabLayout.this.f3614o.getCurrentItem() == this.f3628a) {
                TabLayout.e(TabLayout.this);
                return;
            }
            TabLayout.this.u(TabLayout.this.f3610c.getChildAt(TabLayout.this.f3614o.getCurrentItem()));
            TabLayout.this.f3614o.setCurrentItem(this.f3628a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface c {
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class d extends ViewPager2.i {
        public d() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void a(int i10) {
            if (i10 == 0) {
                TabLayout tabLayout = TabLayout.this;
                tabLayout.p(tabLayout.f3614o.getCurrentItem(), 0);
            }
            ViewPager2.i iVar = TabLayout.this.f3613n;
            if (iVar != null) {
                iVar.a(i10);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void b(int i10, float f10, int i11) {
            TabLayout.this.f3616q = i10;
            TabLayout.this.f3617r = f10;
            TabLayout.this.p(i10, TabLayout.this.f3615p > 0 ? (int) (TabLayout.this.f3610c.getChildAt(i10).getWidth() * f10) : 0);
            TabLayout.this.invalidate();
            ViewPager2.i iVar = TabLayout.this.f3613n;
            if (iVar != null) {
                iVar.b(i10, f10, i11);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void c(int i10) {
            TabLayout.this.v(i10);
            TabLayout.this.q(TabLayout.this.f3610c.getChildAt(i10));
            if (i10 > 0) {
                TabLayout.this.u(TabLayout.this.f3610c.getChildAt(i10 - 1));
            }
            if (i10 < TabLayout.this.f3614o.getAdapter().g() - 1) {
                TabLayout.this.u(TabLayout.this.f3610c.getChildAt(i10 + 1));
            }
            ViewPager2.i iVar = TabLayout.this.f3613n;
            if (iVar != null) {
                iVar.c(i10);
            }
        }

        public /* synthetic */ d(TabLayout tabLayout, a aVar) {
            this();
        }
    }

    public TabLayout(Context context) {
        this(context, null);
    }

    public static /* synthetic */ c e(TabLayout tabLayout) {
        tabLayout.getClass();
        return null;
    }

    public int getCurrentPosition() {
        return this.f3616q;
    }

    public float getCurrentPositionOffset() {
        return this.f3617r;
    }

    public int getDividerColor() {
        return this.A;
    }

    public int getDividerPadding() {
        return this.f3625z;
    }

    public int getDividerWidth() {
        return this.f3624y;
    }

    public int getIndicatorColor() {
        return this.f3620u;
    }

    public x.d getIndicatorCoordinates() {
        int i10;
        View childAt = this.f3610c.getChildAt(this.f3616q);
        float left = childAt.getLeft();
        float right = childAt.getRight();
        if (this.f3617r > 0.0f && (i10 = this.f3616q) < this.f3615p - 1) {
            View childAt2 = this.f3610c.getChildAt(i10 + 1);
            float left2 = childAt2.getLeft();
            float right2 = childAt2.getRight();
            float f10 = this.f3617r;
            left = (left2 * f10) + ((1.0f - f10) * left);
            right = (right2 * f10) + ((1.0f - f10) * right);
        }
        return new x.d(Float.valueOf(left), Float.valueOf(right));
    }

    public int getIndicatorHeight() {
        return this.f3621v;
    }

    public int getScrollOffset() {
        return this.M;
    }

    public boolean getShouldExpand() {
        return this.G;
    }

    public int getTabBackground() {
        return this.O;
    }

    public int getTabCount() {
        return this.f3615p;
    }

    public int getTabPaddingLeftRight() {
        return this.B;
    }

    public LinearLayout getTabsContainer() {
        return this.f3610c;
    }

    public ColorStateList getTextColor() {
        return this.D;
    }

    public int getTextSize() {
        return this.C;
    }

    public int getUnderlineColor() {
        return this.f3623x;
    }

    public int getUnderlineHeight() {
        return this.f3622w;
    }

    public final void k(int i10, CharSequence charSequence, View view) {
        TextView textView = (TextView) view.findViewById(w7.p.f13895o0);
        if (textView != null && charSequence != null) {
            textView.setText(charSequence);
        }
        view.setFocusable(true);
        view.setOnClickListener(new b(i10));
        this.f3610c.addView(view, i10, this.f3611e);
    }

    public final ColorStateList l(int i10) {
        return new ColorStateList(new int[][]{new int[0]}, new int[]{i10});
    }

    public final ColorStateList m(int i10, int i11, int i12) {
        return new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}, new int[]{R.attr.state_selected}, new int[0]}, new int[]{i10, i11, i12});
    }

    public final TextView n() {
        return (TextView) new b6.a(new TextView(getContext()), new FrameLayout.LayoutParams(-1, -1)).o(w7.p.f13895o0).V(new a()).l();
    }

    public void o() {
        this.f3610c.removeAllViews();
        this.f3615p = this.f3614o.getAdapter().g();
        int i10 = 0;
        while (i10 < this.f3615p) {
            if (this.H) {
                n.g.a(this.f3614o.getAdapter());
                throw null;
            }
            TextView textViewN = n();
            String[] strArr = this.P;
            k(i10, i10 >= strArr.length ? "EMPTY" : strArr[i10], textViewN);
            i10++;
        }
        w();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewPager2 viewPager2 = this.f3614o;
        if (viewPager2 != null) {
            viewPager2.n(this.f3612m);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isInEditMode() || this.f3615p == 0) {
            return;
        }
        int height = getHeight();
        int i10 = this.f3624y;
        if (i10 > 0) {
            this.f3619t.setStrokeWidth(i10);
            this.f3619t.setColor(this.A);
            for (int i11 = 0; i11 < this.f3615p - 1; i11++) {
                View childAt = this.f3610c.getChildAt(i11);
                canvas.drawLine(childAt.getRight(), this.f3625z, childAt.getRight(), height - this.f3625z, this.f3619t);
            }
        }
        if (this.f3622w > 0) {
            this.f3618s.setColor(this.f3623x);
            canvas.drawRect(this.E, height - this.f3622w, this.f3610c.getWidth() + this.F, height, this.f3618s);
        }
        if (this.f3621v > 0) {
            this.f3618s.setColor(this.f3620u);
            x.d indicatorCoordinates = getIndicatorCoordinates();
            canvas.drawRect(((Float) indicatorCoordinates.f14455a).floatValue() + this.E, height - this.f3621v, ((Float) indicatorCoordinates.f14456b).floatValue() + this.E, height, this.f3618s);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        if (this.I && this.f3610c.getChildCount() > 0) {
            int width = (getWidth() / 2) - (this.f3610c.getChildAt(0).getMeasuredWidth() / 2);
            this.F = width;
            this.E = width;
        }
        boolean z11 = this.I;
        if (z11 || this.E > 0 || this.F > 0) {
            this.f3610c.setMinimumWidth(z11 ? getWidth() : (getWidth() - this.E) - this.F);
            setClipToPadding(false);
        }
        setPadding(this.E, getPaddingTop(), this.F, getPaddingBottom());
        if (this.M == 0) {
            this.M = (getWidth() / 2) - this.E;
        }
        ViewPager2 viewPager2 = this.f3614o;
        if (viewPager2 != null) {
            this.f3616q = viewPager2.getCurrentItem();
        }
        this.f3617r = 0.0f;
        p(this.f3616q, 0);
        v(this.f3616q);
        super.onLayout(z10, i10, i11, i12, i13);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        int i10 = savedState.f3626c;
        this.f3616q = i10;
        if (i10 != 0 && this.f3610c.getChildCount() > 0) {
            u(this.f3610c.getChildAt(0));
            q(this.f3610c.getChildAt(this.f3616q));
        }
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f3626c = this.f3616q;
        return savedState;
    }

    public final void p(int i10, int i11) {
        if (this.f3615p == 0) {
            return;
        }
        int left = this.f3610c.getChildAt(i10).getLeft() + i11;
        if (i10 > 0 || i11 > 0) {
            int i12 = left - this.M;
            x.d indicatorCoordinates = getIndicatorCoordinates();
            left = (int) (i12 + ((((Float) indicatorCoordinates.f14456b).floatValue() - ((Float) indicatorCoordinates.f14455a).floatValue()) / 2.0f));
        }
        if (left != this.N) {
            this.N = left;
            scrollTo(left, 0);
        }
    }

    public final void q(View view) {
        if (view != null) {
            TextView textView = (TextView) view.findViewById(w7.p.f13895o0);
            if (textView != null) {
                textView.setSelected(true);
            }
            if (this.H) {
                n.g.a(this.f3614o.getAdapter());
                throw null;
            }
        }
    }

    public final void r() {
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), Math.max(this.f3621v, this.f3622w));
    }

    public void s(Typeface typeface, int i10) {
        this.K = typeface;
        this.L = i10;
        w();
    }

    public void setAllCaps(boolean z10) {
        this.J = z10;
    }

    public void setDividerColor(int i10) {
        this.A = i10;
        invalidate();
    }

    public void setDividerColorResource(int i10) {
        this.A = com.tuyafeng.support.utils.f.b(getContext(), i10);
        invalidate();
    }

    public void setDividerPadding(int i10) {
        this.f3625z = i10;
        invalidate();
    }

    public void setDividerWidth(int i10) {
        this.f3624y = i10;
        invalidate();
    }

    public void setIndicatorColor(int i10) {
        this.f3620u = i10;
        invalidate();
    }

    public void setIndicatorColorResource(int i10) {
        this.f3620u = com.tuyafeng.support.utils.f.b(getContext(), i10);
        invalidate();
    }

    public void setIndicatorHeight(int i10) {
        this.f3621v = i10;
        invalidate();
    }

    public void setOnPageChangeListener(ViewPager2.i iVar) {
        this.f3613n = iVar;
    }

    public void setScrollOffset(int i10) {
        this.M = i10;
        invalidate();
    }

    public void setShouldExpand(boolean z10) {
        this.G = z10;
        if (this.f3614o != null) {
            requestLayout();
        }
    }

    public void setTabBackground(int i10) {
        this.O = i10;
    }

    public void setTabPaddingLeftRight(int i10) {
        this.B = i10;
        w();
    }

    public void setTextColor(int i10) {
        setTextColor(l(i10));
    }

    public void setTextColorResource(int i10) {
        setTextColor(com.tuyafeng.support.utils.f.b(getContext(), i10));
    }

    public void setTextColorStateListResource(int i10) {
        setTextColor(com.tuyafeng.support.utils.f.c(getContext(), i10));
    }

    public void setTextSize(int i10) {
        this.C = i10;
        w();
    }

    public void setUnderlineColor(int i10) {
        this.f3623x = i10;
        invalidate();
    }

    public void setUnderlineColorResource(int i10) {
        this.f3623x = com.tuyafeng.support.utils.f.b(getContext(), i10);
        invalidate();
    }

    public void setUnderlineHeight(int i10) {
        this.f3622w = i10;
        invalidate();
    }

    public void t(ViewPager2 viewPager2, String[] strArr) {
        this.P = strArr;
        this.f3614o = viewPager2;
        if (viewPager2.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        viewPager2.getAdapter();
        this.H = false;
        viewPager2.g(this.f3612m);
        o();
    }

    public final void u(View view) {
        if (view != null) {
            TextView textView = (TextView) view.findViewById(w7.p.f13895o0);
            if (textView != null) {
                textView.setSelected(false);
            }
            if (this.H) {
                n.g.a(this.f3614o.getAdapter());
                throw null;
            }
        }
    }

    public final void v(int i10) {
        for (int i11 = 0; i11 < this.f3615p; i11++) {
            View childAt = this.f3610c.getChildAt(i11);
            if (i11 == i10) {
                q(childAt);
            } else {
                u(childAt);
            }
        }
    }

    public final void w() {
        for (int i10 = 0; i10 < this.f3615p; i10++) {
            View childAt = this.f3610c.getChildAt(i10);
            childAt.setBackgroundResource(this.O);
            childAt.setPadding(this.B, childAt.getPaddingTop(), this.B, childAt.getPaddingBottom());
            TextView textView = (TextView) childAt.findViewById(w7.p.f13895o0);
            if (textView != null) {
                textView.setTextColor(this.D);
                textView.setTypeface(this.K, this.L);
                textView.setTextSize(0, this.C);
                if (this.J) {
                    textView.setAllCaps(true);
                }
            }
        }
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.D = colorStateList;
        w();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TabLayout(Context context, AttributeSet attributeSet, int i10) {
        String str;
        LinearLayout.LayoutParams layoutParams;
        super(context, attributeSet, i10);
        this.f3612m = new d(this, 0 == true ? 1 : 0);
        this.f3616q = 0;
        this.f3617r = 0.0f;
        this.f3621v = 2;
        this.f3622w = 0;
        this.f3624y = 0;
        this.f3625z = 0;
        this.B = 12;
        this.C = 14;
        this.D = null;
        this.E = 0;
        this.F = 0;
        this.G = false;
        this.I = false;
        this.J = true;
        this.K = null;
        this.L = 1;
        this.N = 0;
        this.O = w7.o.f13786e;
        setFillViewport(true);
        setWillNotDraw(false);
        LinearLayout linearLayout = new LinearLayout(context);
        this.f3610c = linearLayout;
        linearLayout.setOrientation(0);
        addView(this.f3610c);
        Paint paint = new Paint();
        this.f3618s = paint;
        paint.setAntiAlias(true);
        this.f3618s.setStyle(Paint.Style.FILL);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.M = (int) TypedValue.applyDimension(1, this.M, displayMetrics);
        this.f3621v = (int) TypedValue.applyDimension(1, this.f3621v, displayMetrics);
        this.f3622w = (int) TypedValue.applyDimension(1, this.f3622w, displayMetrics);
        this.f3625z = (int) TypedValue.applyDimension(1, this.f3625z, displayMetrics);
        this.B = (int) TypedValue.applyDimension(1, this.B, displayMetrics);
        this.f3624y = (int) TypedValue.applyDimension(1, this.f3624y, displayMetrics);
        this.C = (int) TypedValue.applyDimension(2, this.C, displayMetrics);
        Paint paint2 = new Paint();
        this.f3619t = paint2;
        paint2.setAntiAlias(true);
        this.f3619t.setStrokeWidth(this.f3624y);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Q);
        int color = typedArrayObtainStyledAttributes.getColor(0, com.tuyafeng.support.utils.f.b(context, R.color.black));
        this.f3623x = color;
        this.A = color;
        this.f3620u = color;
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.E = dimensionPixelSize > 0 ? dimensionPixelSize : typedArrayObtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.F = dimensionPixelSize <= 0 ? typedArrayObtainStyledAttributes.getDimensionPixelSize(3, 0) : dimensionPixelSize;
        typedArrayObtainStyledAttributes.recycle();
        if (Build.VERSION.SDK_INT >= 21) {
            this.L = 0;
            str = "sans-serif-medium";
        } else {
            str = "sans-serif";
        }
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, w7.w.f14346p);
        this.f3620u = typedArrayObtainStyledAttributes2.getColor(w7.w.f14350t, this.f3620u);
        this.f3621v = typedArrayObtainStyledAttributes2.getDimensionPixelSize(w7.w.f14351u, this.f3621v);
        this.f3623x = typedArrayObtainStyledAttributes2.getColor(w7.w.G, this.f3623x);
        this.f3622w = typedArrayObtainStyledAttributes2.getDimensionPixelSize(w7.w.H, this.f3622w);
        this.A = typedArrayObtainStyledAttributes2.getColor(w7.w.f14347q, this.A);
        this.f3624y = typedArrayObtainStyledAttributes2.getDimensionPixelSize(w7.w.f14349s, this.f3624y);
        this.f3625z = typedArrayObtainStyledAttributes2.getDimensionPixelSize(w7.w.f14348r, this.f3625z);
        this.G = typedArrayObtainStyledAttributes2.getBoolean(w7.w.f14354x, this.G);
        this.M = typedArrayObtainStyledAttributes2.getDimensionPixelSize(w7.w.f14353w, this.M);
        this.I = typedArrayObtainStyledAttributes2.getBoolean(w7.w.f14352v, this.I);
        this.B = typedArrayObtainStyledAttributes2.getDimensionPixelSize(w7.w.f14356z, this.B);
        this.O = typedArrayObtainStyledAttributes2.getResourceId(w7.w.f14355y, this.O);
        this.C = typedArrayObtainStyledAttributes2.getDimensionPixelSize(w7.w.E, this.C);
        this.D = typedArrayObtainStyledAttributes2.hasValue(w7.w.C) ? typedArrayObtainStyledAttributes2.getColorStateList(w7.w.C) : null;
        this.L = typedArrayObtainStyledAttributes2.getInt(w7.w.F, this.L);
        this.J = typedArrayObtainStyledAttributes2.getBoolean(w7.w.A, this.J);
        int i11 = typedArrayObtainStyledAttributes2.getInt(w7.w.B, 150);
        String string = typedArrayObtainStyledAttributes2.getString(w7.w.D);
        typedArrayObtainStyledAttributes2.recycle();
        if (this.D == null) {
            this.D = m(color, color, Color.argb(i11, Color.red(color), Color.green(color), Color.blue(color)));
        }
        this.K = Typeface.create(string != null ? string : str, this.L);
        r();
        if (this.G) {
            layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -1);
        }
        this.f3611e = layoutParams;
    }

    public void setOnTabReselectedListener(c cVar) {
    }
}
