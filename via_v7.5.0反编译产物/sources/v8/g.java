package v8;

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
import com.tuyafeng.support.widget.e0;
import com.tuyafeng.support.widget.f0;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import la.s;
import w7.k;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Executor f13439a;

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
        textView.post(new Runnable() { // from class: v8.e
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
        textView.postDelayed(new Runnable() { // from class: v8.f
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
        if ((view instanceof RecyclerView) || (view instanceof ListView) || (view instanceof e0) || (view instanceof f0) || (view instanceof com.tuyafeng.support.widget.b)) {
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
        j().execute(new Runnable() { // from class: v8.d
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
        Typeface typefaceN1 = s.j().N1();
        return typefaceN1 == null ? Typeface.DEFAULT : typefaceN1;
    }

    public static Executor j() {
        if (f13439a == null) {
            synchronized (g.class) {
                try {
                    if (f13439a == null) {
                        f13439a = Executors.newFixedThreadPool(1);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f13439a;
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
        textView.setTextColor(com.tuyafeng.support.utils.e.a(textView.getContext(), k.f13732l));
    }

    public static void m(TextView textView, int i10) {
        textView.setTextSize(0, i10);
    }
}
