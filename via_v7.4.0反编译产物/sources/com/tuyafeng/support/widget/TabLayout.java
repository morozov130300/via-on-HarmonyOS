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
import h6.a;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class TabLayout extends HorizontalScrollView {
    public static final int[] O = {R.attr.textColorPrimary, R.attr.padding, R.attr.paddingLeft, R.attr.paddingRight};
    public int A;
    public ColorStateList B;
    public int C;
    public int D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public Typeface I;
    public int J;
    public int K;
    public int L;
    public int M;
    public String[] N;

    /* renamed from: e, reason: collision with root package name */
    public LinearLayout f4275e;

    /* renamed from: j, reason: collision with root package name */
    public LinearLayout.LayoutParams f4276j;

    /* renamed from: k, reason: collision with root package name */
    public final d f4277k;

    /* renamed from: l, reason: collision with root package name */
    public ViewPager2.i f4278l;

    /* renamed from: m, reason: collision with root package name */
    public ViewPager2 f4279m;

    /* renamed from: n, reason: collision with root package name */
    public int f4280n;

    /* renamed from: o, reason: collision with root package name */
    public int f4281o;

    /* renamed from: p, reason: collision with root package name */
    public float f4282p;

    /* renamed from: q, reason: collision with root package name */
    public Paint f4283q;

    /* renamed from: r, reason: collision with root package name */
    public Paint f4284r;

    /* renamed from: s, reason: collision with root package name */
    public int f4285s;

    /* renamed from: t, reason: collision with root package name */
    public int f4286t;

    /* renamed from: u, reason: collision with root package name */
    public int f4287u;

    /* renamed from: v, reason: collision with root package name */
    public int f4288v;

    /* renamed from: w, reason: collision with root package name */
    public int f4289w;

    /* renamed from: x, reason: collision with root package name */
    public int f4290x;

    /* renamed from: y, reason: collision with root package name */
    public int f4291y;

    /* renamed from: z, reason: collision with root package name */
    public int f4292z;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: e, reason: collision with root package name */
        public int f4293e;

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f4293e = parcel.readInt();
        }

        public /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f4293e);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements a.InterfaceC0076a {
        public a() {
        }

        @Override // h6.a.InterfaceC0076a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(TextView textView) {
            textView.setMaxLines(1);
            textView.setGravity(17);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f4295a;

        public b(int i10) {
            this.f4295a = i10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TabLayout.this.f4279m.getCurrentItem() == this.f4295a) {
                TabLayout.e(TabLayout.this);
                return;
            }
            TabLayout.this.u(TabLayout.this.f4275e.getChildAt(TabLayout.this.f4279m.getCurrentItem()));
            TabLayout.this.f4279m.setCurrentItem(this.f4295a);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface c {
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class d extends ViewPager2.i {
        public d() {
        }

        public /* synthetic */ d(TabLayout tabLayout, a aVar) {
            this();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void a(int i10) {
            if (i10 == 0) {
                TabLayout tabLayout = TabLayout.this;
                tabLayout.p(tabLayout.f4279m.getCurrentItem(), 0);
            }
            ViewPager2.i iVar = TabLayout.this.f4278l;
            if (iVar != null) {
                iVar.a(i10);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void b(int i10, float f10, int i11) {
            TabLayout.this.f4281o = i10;
            TabLayout.this.f4282p = f10;
            TabLayout.this.p(i10, TabLayout.this.f4280n > 0 ? (int) (TabLayout.this.f4275e.getChildAt(i10).getWidth() * f10) : 0);
            TabLayout.this.invalidate();
            ViewPager2.i iVar = TabLayout.this.f4278l;
            if (iVar != null) {
                iVar.b(i10, f10, i11);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void c(int i10) {
            TabLayout.this.v(i10);
            TabLayout.this.q(TabLayout.this.f4275e.getChildAt(i10));
            if (i10 > 0) {
                TabLayout.this.u(TabLayout.this.f4275e.getChildAt(i10 - 1));
            }
            if (i10 < TabLayout.this.f4279m.getAdapter().g() - 1) {
                TabLayout.this.u(TabLayout.this.f4275e.getChildAt(i10 + 1));
            }
            ViewPager2.i iVar = TabLayout.this.f4278l;
            if (iVar != null) {
                iVar.c(i10);
            }
        }
    }

    public TabLayout(Context context) {
        this(context, null);
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TabLayout(Context context, AttributeSet attributeSet, int i10) {
        String str;
        super(context, attributeSet, i10);
        this.f4277k = new d(this, 0 == true ? 1 : 0);
        this.f4281o = 0;
        this.f4282p = 0.0f;
        this.f4286t = 2;
        this.f4287u = 0;
        this.f4289w = 0;
        this.f4290x = 0;
        this.f4292z = 12;
        this.A = 14;
        this.B = null;
        this.C = 0;
        this.D = 0;
        this.E = false;
        this.G = false;
        this.H = true;
        this.I = null;
        this.J = 1;
        this.L = 0;
        this.M = x7.o.f13723f;
        setFillViewport(true);
        setWillNotDraw(false);
        LinearLayout linearLayout = new LinearLayout(context);
        this.f4275e = linearLayout;
        linearLayout.setOrientation(0);
        addView(this.f4275e);
        Paint paint = new Paint();
        this.f4283q = paint;
        paint.setAntiAlias(true);
        this.f4283q.setStyle(Paint.Style.FILL);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.K = (int) TypedValue.applyDimension(1, this.K, displayMetrics);
        this.f4286t = (int) TypedValue.applyDimension(1, this.f4286t, displayMetrics);
        this.f4287u = (int) TypedValue.applyDimension(1, this.f4287u, displayMetrics);
        this.f4290x = (int) TypedValue.applyDimension(1, this.f4290x, displayMetrics);
        this.f4292z = (int) TypedValue.applyDimension(1, this.f4292z, displayMetrics);
        this.f4289w = (int) TypedValue.applyDimension(1, this.f4289w, displayMetrics);
        this.A = (int) TypedValue.applyDimension(2, this.A, displayMetrics);
        Paint paint2 = new Paint();
        this.f4284r = paint2;
        paint2.setAntiAlias(true);
        this.f4284r.setStrokeWidth(this.f4289w);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, O);
        int color = typedArrayObtainStyledAttributes.getColor(0, g6.f.b(context, R.color.black));
        this.f4288v = color;
        this.f4291y = color;
        this.f4285s = color;
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.C = dimensionPixelSize > 0 ? dimensionPixelSize : typedArrayObtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.D = dimensionPixelSize <= 0 ? typedArrayObtainStyledAttributes.getDimensionPixelSize(3, 0) : dimensionPixelSize;
        typedArrayObtainStyledAttributes.recycle();
        if (Build.VERSION.SDK_INT >= 21) {
            this.J = 0;
            str = "sans-serif-medium";
        } else {
            str = "sans-serif";
        }
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, x7.w.f14277p);
        this.f4285s = typedArrayObtainStyledAttributes2.getColor(x7.w.f14281t, this.f4285s);
        this.f4286t = typedArrayObtainStyledAttributes2.getDimensionPixelSize(x7.w.f14282u, this.f4286t);
        this.f4288v = typedArrayObtainStyledAttributes2.getColor(x7.w.G, this.f4288v);
        this.f4287u = typedArrayObtainStyledAttributes2.getDimensionPixelSize(x7.w.H, this.f4287u);
        this.f4291y = typedArrayObtainStyledAttributes2.getColor(x7.w.f14278q, this.f4291y);
        this.f4289w = typedArrayObtainStyledAttributes2.getDimensionPixelSize(x7.w.f14280s, this.f4289w);
        this.f4290x = typedArrayObtainStyledAttributes2.getDimensionPixelSize(x7.w.f14279r, this.f4290x);
        this.E = typedArrayObtainStyledAttributes2.getBoolean(x7.w.f14285x, this.E);
        this.K = typedArrayObtainStyledAttributes2.getDimensionPixelSize(x7.w.f14284w, this.K);
        this.G = typedArrayObtainStyledAttributes2.getBoolean(x7.w.f14283v, this.G);
        this.f4292z = typedArrayObtainStyledAttributes2.getDimensionPixelSize(x7.w.f14287z, this.f4292z);
        this.M = typedArrayObtainStyledAttributes2.getResourceId(x7.w.f14286y, this.M);
        this.A = typedArrayObtainStyledAttributes2.getDimensionPixelSize(x7.w.E, this.A);
        this.B = typedArrayObtainStyledAttributes2.hasValue(x7.w.C) ? typedArrayObtainStyledAttributes2.getColorStateList(x7.w.C) : null;
        this.J = typedArrayObtainStyledAttributes2.getInt(x7.w.F, this.J);
        this.H = typedArrayObtainStyledAttributes2.getBoolean(x7.w.A, this.H);
        int i11 = typedArrayObtainStyledAttributes2.getInt(x7.w.B, 150);
        String string = typedArrayObtainStyledAttributes2.getString(x7.w.D);
        typedArrayObtainStyledAttributes2.recycle();
        if (this.B == null) {
            this.B = m(color, color, Color.argb(i11, Color.red(color), Color.green(color), Color.blue(color)));
        }
        this.I = Typeface.create(string != null ? string : str, this.J);
        r();
        this.f4276j = this.E ? new LinearLayout.LayoutParams(0, -1, 1.0f) : new LinearLayout.LayoutParams(-2, -1);
    }

    public static /* synthetic */ c e(TabLayout tabLayout) {
        tabLayout.getClass();
        return null;
    }

    public int getCurrentPosition() {
        return this.f4281o;
    }

    public float getCurrentPositionOffset() {
        return this.f4282p;
    }

    public int getDividerColor() {
        return this.f4291y;
    }

    public int getDividerPadding() {
        return this.f4290x;
    }

    public int getDividerWidth() {
        return this.f4289w;
    }

    public int getIndicatorColor() {
        return this.f4285s;
    }

    public w.d getIndicatorCoordinates() {
        int i10;
        View childAt = this.f4275e.getChildAt(this.f4281o);
        float left = childAt.getLeft();
        float right = childAt.getRight();
        if (this.f4282p > 0.0f && (i10 = this.f4281o) < this.f4280n - 1) {
            View childAt2 = this.f4275e.getChildAt(i10 + 1);
            float left2 = childAt2.getLeft();
            float right2 = childAt2.getRight();
            float f10 = this.f4282p;
            left = (left2 * f10) + ((1.0f - f10) * left);
            right = (right2 * f10) + ((1.0f - f10) * right);
        }
        return new w.d(Float.valueOf(left), Float.valueOf(right));
    }

    public int getIndicatorHeight() {
        return this.f4286t;
    }

    public int getScrollOffset() {
        return this.K;
    }

    public boolean getShouldExpand() {
        return this.E;
    }

    public int getTabBackground() {
        return this.M;
    }

    public int getTabCount() {
        return this.f4280n;
    }

    public int getTabPaddingLeftRight() {
        return this.f4292z;
    }

    public LinearLayout getTabsContainer() {
        return this.f4275e;
    }

    public ColorStateList getTextColor() {
        return this.B;
    }

    public int getTextSize() {
        return this.A;
    }

    public int getUnderlineColor() {
        return this.f4288v;
    }

    public int getUnderlineHeight() {
        return this.f4287u;
    }

    public final void k(int i10, CharSequence charSequence, View view) {
        TextView textView = (TextView) view.findViewById(x7.p.f13841s0);
        if (textView != null && charSequence != null) {
            textView.setText(charSequence);
        }
        view.setFocusable(true);
        view.setOnClickListener(new b(i10));
        this.f4275e.addView(view, i10, this.f4276j);
    }

    public final ColorStateList l(int i10) {
        return new ColorStateList(new int[][]{new int[0]}, new int[]{i10});
    }

    public final ColorStateList m(int i10, int i11, int i12) {
        return new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}, new int[]{R.attr.state_selected}, new int[0]}, new int[]{i10, i11, i12});
    }

    public final TextView n() {
        return (TextView) new h6.a(new TextView(getContext()), new FrameLayout.LayoutParams(-1, -1)).o(x7.p.f13841s0).V(new a()).l();
    }

    public void o() {
        this.f4275e.removeAllViews();
        this.f4280n = this.f4279m.getAdapter().g();
        int i10 = 0;
        while (i10 < this.f4280n) {
            if (this.F) {
                n.g.a(this.f4279m.getAdapter());
                throw null;
            }
            TextView textViewN = n();
            String[] strArr = this.N;
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
        ViewPager2 viewPager2 = this.f4279m;
        if (viewPager2 != null) {
            viewPager2.n(this.f4277k);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isInEditMode() || this.f4280n == 0) {
            return;
        }
        int height = getHeight();
        int i10 = this.f4289w;
        if (i10 > 0) {
            this.f4284r.setStrokeWidth(i10);
            this.f4284r.setColor(this.f4291y);
            for (int i11 = 0; i11 < this.f4280n - 1; i11++) {
                View childAt = this.f4275e.getChildAt(i11);
                canvas.drawLine(childAt.getRight(), this.f4290x, childAt.getRight(), height - this.f4290x, this.f4284r);
            }
        }
        if (this.f4287u > 0) {
            this.f4283q.setColor(this.f4288v);
            canvas.drawRect(this.C, height - this.f4287u, this.f4275e.getWidth() + this.D, height, this.f4283q);
        }
        if (this.f4286t > 0) {
            this.f4283q.setColor(this.f4285s);
            w.d indicatorCoordinates = getIndicatorCoordinates();
            canvas.drawRect(((Float) indicatorCoordinates.f13207a).floatValue() + this.C, height - this.f4286t, ((Float) indicatorCoordinates.f13208b).floatValue() + this.C, height, this.f4283q);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        if (this.G && this.f4275e.getChildCount() > 0) {
            int width = (getWidth() / 2) - (this.f4275e.getChildAt(0).getMeasuredWidth() / 2);
            this.D = width;
            this.C = width;
        }
        boolean z11 = this.G;
        if (z11 || this.C > 0 || this.D > 0) {
            this.f4275e.setMinimumWidth(z11 ? getWidth() : (getWidth() - this.C) - this.D);
            setClipToPadding(false);
        }
        setPadding(this.C, getPaddingTop(), this.D, getPaddingBottom());
        if (this.K == 0) {
            this.K = (getWidth() / 2) - this.C;
        }
        ViewPager2 viewPager2 = this.f4279m;
        if (viewPager2 != null) {
            this.f4281o = viewPager2.getCurrentItem();
        }
        this.f4282p = 0.0f;
        p(this.f4281o, 0);
        v(this.f4281o);
        super.onLayout(z10, i10, i11, i12, i13);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        int i10 = savedState.f4293e;
        this.f4281o = i10;
        if (i10 != 0 && this.f4275e.getChildCount() > 0) {
            u(this.f4275e.getChildAt(0));
            q(this.f4275e.getChildAt(this.f4281o));
        }
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f4293e = this.f4281o;
        return savedState;
    }

    public final void p(int i10, int i11) {
        if (this.f4280n == 0) {
            return;
        }
        int left = this.f4275e.getChildAt(i10).getLeft() + i11;
        if (i10 > 0 || i11 > 0) {
            int i12 = left - this.K;
            w.d indicatorCoordinates = getIndicatorCoordinates();
            left = (int) (i12 + ((((Float) indicatorCoordinates.f13208b).floatValue() - ((Float) indicatorCoordinates.f13207a).floatValue()) / 2.0f));
        }
        if (left != this.L) {
            this.L = left;
            scrollTo(left, 0);
        }
    }

    public final void q(View view) {
        if (view != null) {
            TextView textView = (TextView) view.findViewById(x7.p.f13841s0);
            if (textView != null) {
                textView.setSelected(true);
            }
            if (this.F) {
                n.g.a(this.f4279m.getAdapter());
                throw null;
            }
        }
    }

    public final void r() {
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), Math.max(this.f4286t, this.f4287u));
    }

    public void s(Typeface typeface, int i10) {
        this.I = typeface;
        this.J = i10;
        w();
    }

    public void setAllCaps(boolean z10) {
        this.H = z10;
    }

    public void setDividerColor(int i10) {
        this.f4291y = i10;
        invalidate();
    }

    public void setDividerColorResource(int i10) {
        this.f4291y = g6.f.b(getContext(), i10);
        invalidate();
    }

    public void setDividerPadding(int i10) {
        this.f4290x = i10;
        invalidate();
    }

    public void setDividerWidth(int i10) {
        this.f4289w = i10;
        invalidate();
    }

    public void setIndicatorColor(int i10) {
        this.f4285s = i10;
        invalidate();
    }

    public void setIndicatorColorResource(int i10) {
        this.f4285s = g6.f.b(getContext(), i10);
        invalidate();
    }

    public void setIndicatorHeight(int i10) {
        this.f4286t = i10;
        invalidate();
    }

    public void setOnPageChangeListener(ViewPager2.i iVar) {
        this.f4278l = iVar;
    }

    public void setOnTabReselectedListener(c cVar) {
    }

    public void setScrollOffset(int i10) {
        this.K = i10;
        invalidate();
    }

    public void setShouldExpand(boolean z10) {
        this.E = z10;
        if (this.f4279m != null) {
            requestLayout();
        }
    }

    public void setTabBackground(int i10) {
        this.M = i10;
    }

    public void setTabPaddingLeftRight(int i10) {
        this.f4292z = i10;
        w();
    }

    public void setTextColor(int i10) {
        setTextColor(l(i10));
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.B = colorStateList;
        w();
    }

    public void setTextColorResource(int i10) {
        setTextColor(g6.f.b(getContext(), i10));
    }

    public void setTextColorStateListResource(int i10) {
        setTextColor(g6.f.c(getContext(), i10));
    }

    public void setTextSize(int i10) {
        this.A = i10;
        w();
    }

    public void setUnderlineColor(int i10) {
        this.f4288v = i10;
        invalidate();
    }

    public void setUnderlineColorResource(int i10) {
        this.f4288v = g6.f.b(getContext(), i10);
        invalidate();
    }

    public void setUnderlineHeight(int i10) {
        this.f4287u = i10;
        invalidate();
    }

    public void t(ViewPager2 viewPager2, String[] strArr) {
        this.N = strArr;
        this.f4279m = viewPager2;
        if (viewPager2.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        viewPager2.getAdapter();
        this.F = false;
        viewPager2.g(this.f4277k);
        o();
    }

    public final void u(View view) {
        if (view != null) {
            TextView textView = (TextView) view.findViewById(x7.p.f13841s0);
            if (textView != null) {
                textView.setSelected(false);
            }
            if (this.F) {
                n.g.a(this.f4279m.getAdapter());
                throw null;
            }
        }
    }

    public final void v(int i10) {
        for (int i11 = 0; i11 < this.f4280n; i11++) {
            View childAt = this.f4275e.getChildAt(i11);
            if (i11 == i10) {
                q(childAt);
            } else {
                u(childAt);
            }
        }
    }

    public final void w() {
        for (int i10 = 0; i10 < this.f4280n; i10++) {
            View childAt = this.f4275e.getChildAt(i10);
            childAt.setBackgroundResource(this.M);
            childAt.setPadding(this.f4292z, childAt.getPaddingTop(), this.f4292z, childAt.getPaddingBottom());
            TextView textView = (TextView) childAt.findViewById(x7.p.f13841s0);
            if (textView != null) {
                textView.setTextColor(this.B);
                textView.setTypeface(this.I, this.J);
                textView.setTextSize(0, this.A);
                if (this.H) {
                    textView.setAllCaps(true);
                }
            }
        }
    }
}
