package x8;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class r3 {
    public static void a(RecyclerView recyclerView) {
        if (recyclerView == null) {
            return;
        }
        recyclerView.k(new x5.c(com.tuyafeng.support.utils.f.b(recyclerView.getContext(), w7.m.f13739c)));
    }

    public static TextView b(Context context) {
        TextView textView = new TextView(context);
        textView.setTextColor(com.tuyafeng.support.utils.e.a(context, w7.k.f13733m));
        textView.setTextSize(0, v8.h.s(context));
        textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        textView.setGravity(17);
        com.tuyafeng.support.utils.x.U(textView, 0, com.tuyafeng.support.utils.x.h(context, 20.0f));
        textView.setId(-1);
        f(textView);
        return textView;
    }

    public static StateListDrawable c(Context context, boolean z10, int i10, int i11) {
        float[] fArr;
        LayerDrawable layerDrawable;
        int iJ = v8.h.j(context);
        int iH = com.tuyafeng.support.utils.x.h(context, i10 - 6);
        int iH2 = com.tuyafeng.support.utils.x.h(context, i10 - 5);
        int iH3 = com.tuyafeng.support.utils.x.h(context, 999.0f);
        if (z10) {
            float f10 = iH3;
            fArr = new float[]{0.0f, 0.0f, f10, f10, f10, f10, 0.0f, 0.0f};
        } else {
            float f11 = iH3;
            fArr = new float[]{f11, f11, 0.0f, 0.0f, 0.0f, 0.0f, f11, f11};
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadii(fArr);
        gradientDrawable.setColor(iJ);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setCornerRadii(fArr);
        gradientDrawable2.setColor(i11);
        LayerDrawable layerDrawable2 = new LayerDrawable(new GradientDrawable[]{gradientDrawable});
        LayerDrawable layerDrawable3 = new LayerDrawable(new GradientDrawable[]{gradientDrawable2});
        if (z10) {
            layerDrawable2.setLayerInset(0, 0, 0, iH, 0);
            layerDrawable = layerDrawable3;
            layerDrawable.setLayerInset(0, 0, 0, iH2, 0);
        } else {
            layerDrawable2.setLayerInset(0, iH, 0, 0, 0);
            layerDrawable = layerDrawable3;
            layerDrawable.setLayerInset(0, iH2, 0, 0, 0);
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, layerDrawable2);
        stateListDrawable.addState(new int[0], layerDrawable);
        return stateListDrawable;
    }

    public static void d(RecyclerView recyclerView) {
        RecyclerView.o layoutManager = recyclerView.getLayoutManager();
        if (recyclerView.getAdapter() == null || layoutManager == null) {
            return;
        }
        Parcelable parcelableE1 = layoutManager.e1();
        recyclerView.E1(recyclerView.getAdapter(), true);
        recyclerView.getRecycledViewPool().b();
        layoutManager.d1(parcelableE1);
    }

    public static void e(RecyclerView recyclerView) {
        if (recyclerView == null) {
            return;
        }
        recyclerView.setOverScrollMode(1);
        recyclerView.setEdgeEffectFactory(new y5.a());
    }

    public static void f(TextView textView) {
        if (textView == null) {
            return;
        }
        textView.setText("¯\\_(ツ)_/¯");
        textView.setContentDescription(textView.getContext().getString(w7.u.C4));
    }

    public static void g(View view) {
        if (view == null) {
            return;
        }
        if (view instanceof RecyclerView) {
            view.setOverScrollMode(Build.VERSION.SDK_INT >= 21 ? 1 : 2);
        } else {
            view.setOverScrollMode(Build.VERSION.SDK_INT >= 32 ? 1 : 2);
        }
    }

    public static void h(SeekBar seekBar) {
        if (seekBar == null) {
            return;
        }
        seekBar.setProgressDrawable(v8.h.m(seekBar.getContext()));
        seekBar.setThumb(v8.h.v(seekBar.getContext()));
    }

    public static void i(View view) {
        j(view, -2139062144);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void j(View view, int i10) {
        if (view != 0 && (view instanceof r5.a.c)) {
            r5.a fastScrollDelegate = ((r5.a.c) view).getFastScrollDelegate();
            fastScrollDelegate.u(true);
            fastScrollDelegate.v(24, 64);
            boolean zD = com.tuyafeng.support.utils.l.d(view.getContext());
            fastScrollDelegate.s(zD);
            fastScrollDelegate.w(com.tuyafeng.support.utils.x.h(view.getContext(), 4.0f));
            fastScrollDelegate.t(c(view.getContext(), zD, 24, i10));
        }
    }

    public static void k(EditText editText) {
        if (editText == null || editText.getContext() == null) {
            return;
        }
        v8.g.l(editText);
        Context context = editText.getContext();
        editText.setHintTextColor(v8.h.p(context));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{R.attr.textColorHighlight, R.attr.textSelectHandleLeft, R.attr.textSelectHandleRight, R.attr.textSelectHandle, R.attr.textCursorDrawable}, R.attr.editTextStyle, 0);
        try {
            editText.setHighlightColor(typedArrayObtainStyledAttributes.getColor(0, editText.getHighlightColor()));
            if (Build.VERSION.SDK_INT >= 29) {
                if (typedArrayObtainStyledAttributes.hasValue(1)) {
                    editText.setTextSelectHandleLeft(typedArrayObtainStyledAttributes.getDrawable(1));
                }
                if (typedArrayObtainStyledAttributes.hasValue(2)) {
                    editText.setTextSelectHandleRight(typedArrayObtainStyledAttributes.getDrawable(2));
                }
                if (typedArrayObtainStyledAttributes.hasValue(3)) {
                    editText.setTextSelectHandle(typedArrayObtainStyledAttributes.getDrawable(3));
                }
                if (typedArrayObtainStyledAttributes.hasValue(4)) {
                    editText.setTextCursorDrawable(typedArrayObtainStyledAttributes.getDrawable(4));
                }
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static void l(View view, boolean z10) {
        if (view == null) {
            return;
        }
        view.setEnabled(z10);
        view.setAlpha(z10 ? 1.0f : 0.5f);
    }

    public static void m(ImageView imageView, int i10) {
        if (imageView == null) {
            return;
        }
        imageView.setColorFilter(i10, PorterDuff.Mode.SRC_IN);
    }

    public static void n(ImageView imageView) {
        if (imageView == null) {
            return;
        }
        m(imageView, com.tuyafeng.support.utils.e.a(imageView.getContext(), w7.k.f13729i));
    }

    public static void o(TextView textView) {
        p(textView, true);
    }

    public static void p(TextView textView, boolean z10) {
        if (textView == null || textView.getContext() == null) {
            return;
        }
        if (z10) {
            textView.setTextDirection(5);
        } else {
            textView.setTextDirection(3);
        }
    }

    public static void q(TextView textView) {
        if (textView == null) {
            return;
        }
        textView.setEllipsize(null);
        textView.setSingleLine(true);
        textView.setFadingEdgeLength(com.tuyafeng.support.utils.x.h(textView.getContext(), 24.0f));
        textView.setHorizontalFadingEdgeEnabled(true);
    }

    public static void r(TextView textView) {
        if (textView == null) {
            return;
        }
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setSingleLine(true);
        textView.setHorizontalFadingEdgeEnabled(false);
    }
}
