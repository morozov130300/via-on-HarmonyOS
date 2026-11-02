package h6;

import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f6384d = {1, 2, 4, 8, 16, 32, 64, 128, 256};

    /* renamed from: a, reason: collision with root package name */
    public final View f6385a;

    /* renamed from: b, reason: collision with root package name */
    public final ViewGroup.LayoutParams f6386b;

    /* renamed from: c, reason: collision with root package name */
    public int f6387c;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: h6.a$a, reason: collision with other inner class name */
    public interface InterfaceC0076a {
        void a(Object obj);
    }

    public a(View view, ViewGroup.LayoutParams layoutParams) {
        if (view == null) {
            throw new NullPointerException("Can not initial ViewAnchor<T> with a null view");
        }
        this.f6385a = view;
        layoutParams = layoutParams == null ? new ViewGroup.MarginLayoutParams(-2, -2) : layoutParams;
        this.f6386b = layoutParams;
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            this.f6387c |= 2;
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            this.f6387c |= 1;
        }
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            this.f6387c |= 4;
        }
        view.setLayoutParams(layoutParams);
    }

    public a A(int i10) {
        U(1);
        ((ViewGroup.MarginLayoutParams) this.f6386b).topMargin = i10;
        return this;
    }

    public a B(int i10, int i11) {
        return A(k(i10, i11));
    }

    public a C(int i10) {
        return A(i10).s(i10);
    }

    public a D(int i10, int i11) {
        return C(k(i10, i11));
    }

    public a E(int i10) {
        this.f6385a.setPaddingRelative(i10, i10, i10, i10);
        return this;
    }

    public a F(int i10, int i11) {
        return E(k(i10, i11));
    }

    public a G(int i10, int i11, int i12, int i13) {
        this.f6385a.setPaddingRelative(i10, i11, i12, i13);
        return this;
    }

    public a H(int i10, int i11, int i12, int i13, int i14) {
        return G(k(i10, i11), k(i10, i12), k(i10, i13), k(i10, i14));
    }

    public a I(int i10) {
        View view = this.f6385a;
        view.setPaddingRelative(view.getPaddingStart(), this.f6385a.getPaddingTop(), this.f6385a.getPaddingEnd(), i10);
        return this;
    }

    public a J(int i10, int i11) {
        return I(k(i10, i11));
    }

    public a K(int i10) {
        View view = this.f6385a;
        view.setPaddingRelative(view.getPaddingStart(), this.f6385a.getPaddingTop(), i10, this.f6385a.getPaddingBottom());
        return this;
    }

    public a L(int i10, int i11) {
        return K(k(i10, i11));
    }

    public a M(int i10) {
        View view = this.f6385a;
        view.setPaddingRelative(i10, view.getPaddingTop(), i10, this.f6385a.getPaddingBottom());
        return this;
    }

    public a N(int i10, int i11) {
        return M(k(i10, i11));
    }

    public a O(int i10) {
        View view = this.f6385a;
        view.setPaddingRelative(i10, view.getPaddingTop(), this.f6385a.getPaddingEnd(), this.f6385a.getPaddingBottom());
        return this;
    }

    public a P(int i10, int i11) {
        return O(k(i10, i11));
    }

    public a Q(int i10) {
        View view = this.f6385a;
        view.setPaddingRelative(view.getPaddingStart(), i10, this.f6385a.getPaddingEnd(), this.f6385a.getPaddingBottom());
        return this;
    }

    public a R(int i10, int i11) {
        return Q(k(i10, i11));
    }

    public a S(int i10) {
        View view = this.f6385a;
        view.setPaddingRelative(view.getPaddingStart(), i10, this.f6385a.getPaddingEnd(), i10);
        return this;
    }

    public a T(int i10, int i11) {
        return S(k(i10, i11));
    }

    public final void U(int i10) {
        if ((this.f6387c & i10) == i10) {
            return;
        }
        throw new UnsupportedOperationException("Current flags(" + Integer.toHexString(this.f6387c) + ") don't match required flags(" + Integer.toHexString(i10) + ")");
    }

    public a V(InterfaceC0076a interfaceC0076a) {
        if (interfaceC0076a == null) {
            return this;
        }
        interfaceC0076a.a(this.f6385a);
        return this;
    }

    public a W(float f10) {
        U(4);
        ((LinearLayout.LayoutParams) this.f6386b).weight = f10;
        return this;
    }

    public a X(int i10) {
        this.f6386b.width = i10;
        return this;
    }

    public a Y(int i10, int i11) {
        return X(k(i10, i11));
    }

    public final void a(RelativeLayout.LayoutParams layoutParams, int i10, int i11) {
        if (i10 == 1) {
            layoutParams.addRule(18, i11);
            return;
        }
        if (i10 == 2) {
            layoutParams.addRule(17, i11);
            return;
        }
        if (i10 == 4) {
            layoutParams.addRule(16, i11);
            return;
        }
        if (i10 == 8) {
            layoutParams.addRule(19, i11);
            return;
        }
        if (i10 == 16) {
            layoutParams.addRule(6, i11);
            return;
        }
        if (i10 == 32) {
            layoutParams.addRule(3, i11);
            return;
        }
        if (i10 == 64) {
            layoutParams.addRule(2, i11);
        } else if (i10 == 128) {
            layoutParams.addRule(8, i11);
        } else {
            if (i10 != 256) {
                return;
            }
            layoutParams.addRule(4, i11);
        }
    }

    public final void b(RelativeLayout.LayoutParams layoutParams, int i10) {
        if ((i10 & 153) == 153) {
            layoutParams.addRule(13);
            return;
        }
        if ((i10 & 9) == 9) {
            layoutParams.addRule(14);
        } else if ((i10 & 1) == 1) {
            layoutParams.addRule(20);
        } else if ((i10 & 8) == 8) {
            layoutParams.addRule(21);
        }
        if ((i10 & 144) == 144) {
            layoutParams.addRule(15);
        } else if ((i10 & 16) == 16) {
            layoutParams.addRule(10);
        } else if ((i10 & 128) == 128) {
            layoutParams.addRule(12);
        }
    }

    public a c(boolean z10) {
        U(2);
        ((RelativeLayout.LayoutParams) this.f6386b).alignWithParent = z10;
        return this;
    }

    public a d(int i10) {
        this.f6385a.setBackgroundResource(i10);
        return this;
    }

    public a e(Drawable drawable) {
        this.f6385a.setBackground(drawable);
        return this;
    }

    public a f(int i10) {
        this.f6385a.setBackgroundColor(i10);
        return this;
    }

    public a g(int i10, int i11) {
        U(2);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f6386b;
        for (int i12 : f6384d) {
            if ((i10 & i12) == i12) {
                a(layoutParams, i12, i11);
            }
        }
        return this;
    }

    public a h(int i10) {
        U(2);
        b((RelativeLayout.LayoutParams) this.f6386b, i10);
        return this;
    }

    public a i(int i10) {
        return i10 == 0 ? j(null) : j(this.f6385a.getContext().getString(i10));
    }

    public a j(CharSequence charSequence) {
        this.f6385a.setContentDescription(charSequence);
        return this;
    }

    public final int k(int i10, int i11) {
        return (i11 <= 0 || i10 == 0) ? i11 : (int) TypedValue.applyDimension(i10, i11, this.f6385a.getContext().getResources().getDisplayMetrics());
    }

    public View l() {
        return this.f6385a;
    }

    public a m(int i10) {
        this.f6386b.height = i10;
        return this;
    }

    public a n(int i10, int i11) {
        return m(k(i10, i11));
    }

    public a o(int i10) {
        this.f6385a.setId(i10);
        return this;
    }

    public a p(int i10) {
        ViewGroup.LayoutParams layoutParams = this.f6386b;
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).gravity = i10;
            return this;
        }
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = i10;
        }
        return this;
    }

    public a q(int i10, int i11) {
        return B(i10, i11).t(i10, i11).z(i10, i11).v(i10, i11);
    }

    public a r(int i10, int i11, int i12, int i13, int i14) {
        return B(i10, i12).t(i10, i14).z(i10, i11).v(i10, i13);
    }

    public a s(int i10) {
        U(1);
        ((ViewGroup.MarginLayoutParams) this.f6386b).bottomMargin = i10;
        return this;
    }

    public a t(int i10, int i11) {
        return s(k(i10, i11));
    }

    public a u(int i10) {
        U(1);
        ((ViewGroup.MarginLayoutParams) this.f6386b).setMarginEnd(i10);
        return this;
    }

    public a v(int i10, int i11) {
        return u(k(i10, i11));
    }

    public a w(int i10) {
        return y(i10).u(i10);
    }

    public a x(int i10, int i11) {
        return w(k(i10, i11));
    }

    public a y(int i10) {
        U(1);
        ((ViewGroup.MarginLayoutParams) this.f6386b).setMarginStart(i10);
        return this;
    }

    public a z(int i10, int i11) {
        return y(k(i10, i11));
    }
}
