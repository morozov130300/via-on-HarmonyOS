package u5;

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
import androidx.core.widget.d;
import com.tuyafeng.support.utils.f;
import com.tuyafeng.support.utils.l;
import com.tuyafeng.support.utils.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import v8.g;
import w7.n;
import w7.o;
import w7.v;
import x8.h3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f12863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Dialog f12864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f12865c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f12866d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f12867e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f12868f;

    /* JADX INFO: renamed from: u5.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class C0129a implements b6.a.InterfaceC0033a {
        public C0129a() {
        }

        @Override // b6.a.InterfaceC0033a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(LinearLayout linearLayout) {
            linearLayout.setOrientation(0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b implements b6.a.InterfaceC0033a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f12870a;

        /* JADX INFO: renamed from: u5.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public class C0130a extends p5.c {
            public C0130a() {
            }

            @Override // p5.c
            public void a(View view) {
                View.OnClickListener onClickListener = b.this.f12870a.f12874b;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
                a.this.d();
            }
        }

        public b(c cVar) {
            this.f12870a = cVar;
        }

        @Override // b6.a.InterfaceC0033a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(TextView textView) {
            d.b(textView, v.f14330g);
            textView.setText(this.f12870a.f12873a);
            textView.setGravity(17);
            x.P(textView, f.e(textView.getContext(), o.f13786e));
            textView.setOnClickListener(new C0130a());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f12873a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View.OnClickListener f12874b;

        public c(String str, View.OnClickListener onClickListener) {
            this.f12873a = str;
            this.f12874b = onClickListener;
        }
    }

    public a(Context context) {
        this.f12863a = context;
        View viewFindViewById = ((Activity) context).findViewById(R.id.content);
        if (viewFindViewById == null) {
            this.f12866d = x.y(context);
            this.f12867e = x.z(context);
            this.f12868f = x.u(context);
        } else {
            this.f12866d = viewFindViewById.getHeight();
            this.f12867e = viewFindViewById.getWidth();
            int[] iArr = new int[2];
            viewFindViewById.getLocationOnScreen(iArr);
            this.f12868f = iArr[1];
        }
    }

    public static a e(Context context) {
        return new a(context);
    }

    public a a(c cVar) {
        this.f12865c.add(cVar);
        return this;
    }

    public final Dialog b() {
        Dialog dialog = new Dialog(this.f12863a, v.f14326c);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setContentView(c());
        return dialog;
    }

    public final ViewGroup c() {
        LinearLayout linearLayout = (LinearLayout) new b6.a(new LinearLayout(this.f12863a), new FrameLayout.LayoutParams(-2, -2)).M(f.d(this.f12863a, n.f13763p)).V(new C0129a()).l();
        Iterator it = this.f12865c.iterator();
        while (it.hasNext()) {
            linearLayout.addView((TextView) new b6.a(new TextView(this.f12863a), new FrameLayout.LayoutParams(-2, x.h(this.f12863a, 48.0f))).M(x.h(this.f12863a, 16.0f)).V(new b((c) it.next())).l());
        }
        g.f(linearLayout);
        return linearLayout;
    }

    public void d() {
        Dialog dialog = this.f12864b;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.f12864b.dismiss();
    }

    public void f(View view) {
        int height;
        int i10;
        int i11;
        WindowManager windowManager;
        int i12;
        Dialog dialog = this.f12864b;
        if (dialog == null || !dialog.isShowing()) {
            if (this.f12864b == null) {
                this.f12864b = b();
            }
            Window window = this.f12864b.getWindow();
            if (window != null) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                int iMax = Math.max(iArr[0], x.h(this.f12863a, 6.0f));
                if (l.d(this.f12863a)) {
                    iMax = this.f12867e;
                }
                int i13 = iArr[1];
                int i14 = this.f12866d;
                boolean z10 = i13 > (i14 >> 1);
                if (z10) {
                    height = i14 - i13;
                    i10 = 80;
                } else {
                    height = i13 + view.getHeight();
                    i10 = 48;
                }
                int i15 = this.f12868f;
                if (i15 > 0) {
                    height = z10 ? height + i15 : height - i15;
                }
                if (h3.f14580a && (i11 = Build.VERSION.SDK_INT) >= 30 && (windowManager = (WindowManager) this.f12863a.getSystemService(WindowManager.class)) != null) {
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
                x8.l.a(window, 2);
            }
            this.f12864b.show();
        }
    }
}
