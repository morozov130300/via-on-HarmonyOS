package x8;

import android.graphics.Typeface;
import android.os.Build;
import android.text.PrecomputedText;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tuyafeng.support.widget.a0;
import com.tuyafeng.support.widget.z;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import pa.r;
import x7.k;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static volatile Executor f14299a;

    public static /* synthetic */ void a(Reference reference, Runnable runnable) {
        if (((TextView) reference.get()) == null || runnable == null) {
            return;
        }
        runnable.run();
    }

    public static /* synthetic */ void b(final Reference reference, String str, PrecomputedText.Params params, final Runnable runnable, final long j10) {
        TextView textView = (TextView) reference.get();
        if (textView == null) {
            return;
        }
        final PrecomputedText precomputedTextCreate = PrecomputedText.create(str, params);
        textView.post(new Runnable() { // from class: x8.e
            @Override // java.lang.Runnable
            public final void run() {
                g.c(reference, precomputedTextCreate, runnable, j10);
            }
        });
    }

    public static /* synthetic */ void c(final Reference reference, PrecomputedText precomputedText, final Runnable runnable, long j10) {
        TextView textView = (TextView) reference.get();
        if (textView == null) {
            return;
        }
        textView.setText(precomputedText);
        textView.postDelayed(new Runnable() { // from class: x8.f
            @Override // java.lang.Runnable
            public final void run() {
                g.a(reference, runnable);
            }
        }, j10);
    }

    public static void d(TextView textView) {
        if (textView == null) {
            return;
        }
        Typeface typeface = textView.getTypeface();
        e(textView, typeface == null ? 0 : typeface.getStyle());
    }

    public static void e(TextView textView, int i10) {
        if (textView == null) {
            return;
        }
        textView.setTypeface(i(), i10);
    }

    public static void f(View view) {
        if ((view instanceof RecyclerView) || (view instanceof ListView) || (view instanceof z) || (view instanceof a0) || (view instanceof com.tuyafeng.support.widget.b)) {
            return;
        }
        if (!(view instanceof ViewGroup)) {
            if (view instanceof TextView) {
                d((TextView) view);
                return;
            }
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if (childAt instanceof TextView) {
                d((TextView) childAt);
            }
            if (childAt instanceof ViewGroup) {
                f(childAt);
            }
        }
    }

    public static void g(TextView textView, final String str, final Runnable runnable) {
        if (textView == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || str == null || str.length() < 16384) {
            textView.setText(str);
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        textView.setText(str.substring(0, 16384));
        final PrecomputedText.Params textMetricsParams = textView.getTextMetricsParams();
        final WeakReference weakReference = new WeakReference(textView);
        final long jMin = Math.min(50, str.length() / 16384) * 10;
        j().execute(new Runnable() { // from class: x8.d
            @Override // java.lang.Runnable
            public final void run() {
                g.b(weakReference, str, textMetricsParams, runnable, jMin);
            }
        });
    }

    public static void h(EditText editText) {
        if (editText == null || Build.VERSION.SDK_INT < 35) {
            return;
        }
        editText.setLocalePreferredLineHeightForMinimumUsed(false);
    }

    public static Typeface i() {
        Typeface typefaceN1 = r.j().N1();
        return typefaceN1 == null ? Typeface.DEFAULT : typefaceN1;
    }

    public static Executor j() {
        if (f14299a == null) {
            synchronized (g.class) {
                try {
                    if (f14299a == null) {
                        f14299a = Executors.newFixedThreadPool(1);
                    }
                } finally {
                }
            }
        }
        return f14299a;
    }

    public static void k(TextView textView) {
        if (textView == null) {
            return;
        }
        textView.setSingleLine();
        textView.setMaxLines(1);
        textView.setLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
    }

    public static void l(TextView textView) {
        if (textView == null) {
            return;
        }
        textView.setTextColor(g6.e.a(textView.getContext(), k.f13665k));
    }

    public static void m(TextView textView, int i10) {
        textView.setTextSize(0, i10);
    }
}
