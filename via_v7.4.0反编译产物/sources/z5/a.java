package z5;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Insets;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import g6.f;
import g6.l;
import g6.y;
import h6.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import x7.n;
import x7.o;
import x7.v;
import x8.g;
import z8.l3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final Context f14590a;

    /* renamed from: b, reason: collision with root package name */
    public Dialog f14591b;

    /* renamed from: c, reason: collision with root package name */
    public final List f14592c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final int f14593d;

    /* renamed from: e, reason: collision with root package name */
    public final int f14594e;

    /* renamed from: f, reason: collision with root package name */
    public final int f14595f;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: z5.a$a, reason: collision with other inner class name */
    public class C0159a implements a.InterfaceC0076a {
        public C0159a() {
        }

        @Override // h6.a.InterfaceC0076a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(LinearLayout linearLayout) {
            linearLayout.setOrientation(0);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b implements a.InterfaceC0076a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f14597a;

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        /* renamed from: z5.a$b$a, reason: collision with other inner class name */
        public class C0160a extends v5.c {
            public C0160a() {
            }

            @Override // v5.c
            public void a(View view) {
                View.OnClickListener onClickListener = b.this.f14597a.f14601b;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
                a.this.d();
            }
        }

        public b(c cVar) {
            this.f14597a = cVar;
        }

        @Override // h6.a.InterfaceC0076a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(TextView textView) {
            androidx.core.widget.c.b(textView, v.f14261h);
            textView.setText(this.f14597a.f14600a);
            textView.setGravity(17);
            y.O(textView, f.e(textView.getContext(), o.f13723f));
            textView.setOnClickListener(new C0160a());
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final String f14600a;

        /* renamed from: b, reason: collision with root package name */
        public final View.OnClickListener f14601b;

        public c(String str, View.OnClickListener onClickListener) {
            this.f14600a = str;
            this.f14601b = onClickListener;
        }
    }

    public a(Context context) {
        this.f14590a = context;
        View viewFindViewById = ((Activity) context).findViewById(R.id.content);
        if (viewFindViewById == null) {
            this.f14593d = y.y(context);
            this.f14594e = y.z(context);
            this.f14595f = y.u(context);
        } else {
            this.f14593d = viewFindViewById.getHeight();
            this.f14594e = viewFindViewById.getWidth();
            int[] iArr = new int[2];
            viewFindViewById.getLocationOnScreen(iArr);
            this.f14595f = iArr[1];
        }
    }

    public static a e(Context context) {
        return new a(context);
    }

    public a a(c cVar) {
        this.f14592c.add(cVar);
        return this;
    }

    public final Dialog b() {
        Dialog dialog = new Dialog(this.f14590a, v.f14256c);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setContentView(c());
        return dialog;
    }

    public final ViewGroup c() {
        LinearLayout linearLayout = (LinearLayout) new h6.a(new LinearLayout(this.f14590a), new FrameLayout.LayoutParams(-2, -2)).M(f.d(this.f14590a, n.f13697p)).V(new C0159a()).l();
        Iterator it = this.f14592c.iterator();
        while (it.hasNext()) {
            linearLayout.addView((TextView) new h6.a(new TextView(this.f14590a), new FrameLayout.LayoutParams(-2, y.h(this.f14590a, 48.0f))).M(y.h(this.f14590a, 16.0f)).V(new b((c) it.next())).l());
        }
        g.f(linearLayout);
        return linearLayout;
    }

    public void d() {
        Dialog dialog = this.f14591b;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.f14591b.dismiss();
    }

    public void f(View view) {
        int height;
        int i10;
        int i11;
        WindowManager windowManager;
        int i12;
        Dialog dialog = this.f14591b;
        if (dialog == null || !dialog.isShowing()) {
            if (this.f14591b == null) {
                this.f14591b = b();
            }
            Window window = this.f14591b.getWindow();
            if (window != null) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                int iMax = Math.max(iArr[0], y.h(this.f14590a, 6.0f));
                if (l.d(this.f14590a)) {
                    iMax = this.f14594e;
                }
                int i13 = iArr[1];
                int i14 = this.f14593d;
                boolean z10 = i13 > (i14 >> 1);
                if (z10) {
                    height = i14 - i13;
                    i10 = 80;
                } else {
                    height = i13 + view.getHeight();
                    i10 = 48;
                }
                int i15 = this.f14595f;
                if (i15 > 0) {
                    height = z10 ? height + i15 : height - i15;
                }
                if (l3.f14720a && (i11 = Build.VERSION.SDK_INT) >= 30 && (windowManager = (WindowManager) this.f14590a.getSystemService(WindowManager.class)) != null) {
                    WindowInsets windowInsets = windowManager.getCurrentWindowMetrics().getWindowInsets();
                    boolean zIsVisible = windowInsets.isVisible(WindowInsets.Type.statusBars());
                    Insets insetsIgnoringVisibility = windowInsets.getInsetsIgnoringVisibility(WindowInsets.Type.systemBars());
                    if (zIsVisible) {
                        i12 = z10 ? insetsIgnoringVisibility.bottom : insetsIgnoringVisibility.top;
                    } else if (i11 >= 35) {
                        if (!z10) {
                            i12 = insetsIgnoringVisibility.top;
                        }
                    } else if (i11 >= 30 && z10) {
                        i12 = insetsIgnoringVisibility.bottom;
                    }
                    height -= i12;
                }
                attributes.gravity = i10 | 3;
                attributes.x = iMax;
                attributes.y = height;
                attributes.height = -2;
                attributes.width = -2;
                attributes.flags &= -3;
                window.setAttributes(attributes);
                z8.l.a(window, 2);
            }
            this.f14591b.show();
        }
    }
}
