package g6;

import android.R;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import f6.h;
import w5.k;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class n {

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Context f6225e;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ String f6226j;

        /* renamed from: k, reason: collision with root package name */
        public final /* synthetic */ String f6227k;

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f6228l;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ h.c f6229m;

        public a(Context context, String str, String str2, View.OnClickListener onClickListener, h.c cVar) {
            this.f6225e = context;
            this.f6226j = str;
            this.f6227k = str2;
            this.f6228l = onClickListener;
            this.f6229m = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            new h.b(f.a(this.f6225e)).h(this.f6226j).d(this.f6227k).e(this.f6228l).f(null).g(this.f6229m).a().s();
        }
    }

    public static void a(Context context, String str, int i10) {
        b(context, str, context.getString(i10));
    }

    public static void b(Context context, String str, String str2) {
        c(context, str, false, str2);
    }

    public static void c(Context context, String str, boolean z10, String str2) {
        if (str == null) {
            return;
        }
        int i10 = Build.VERSION.SDK_INT;
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        ClipData clipDataNewPlainText = ClipData.newPlainText(null, str);
        if (i10 >= 33 && z10) {
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putBoolean("android.content.extra.IS_SENSITIVE", true);
            clipDataNewPlainText.getDescription().setExtras(persistableBundle);
        }
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(clipDataNewPlainText);
        }
        if (str2 == null || str2.isEmpty()) {
            return;
        }
        s(context, str2);
    }

    public static String d(Context context) {
        try {
            ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
            return (clipboardManager == null || !clipboardManager.hasPrimaryClip() || clipboardManager.getPrimaryClip().getItemAt(0).getText() == null) ? "" : clipboardManager.getPrimaryClip().getItemAt(0).getText().toString();
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static void e(Context context, int i10, int i11, k.m mVar) {
        h(context, context.getString(i10), context.getString(i11), mVar, null);
    }

    public static void f(Context context, int i10, String str, k.m mVar) {
        h(context, context.getString(i10), str, mVar, null);
    }

    public static void g(Context context, String str, String str2, k.m mVar) {
        h(context, str, str2, mVar, null);
    }

    public static void h(Context context, String str, String str2, k.m mVar, View.OnClickListener onClickListener) {
        w5.k.l(context).e0(str).J(str2).V(R.string.ok, mVar).N(R.string.cancel, onClickListener).f0();
    }

    public static void i(EditText editText) {
        j(editText, false);
    }

    public static void j(EditText editText, boolean z10) {
        if (editText == null) {
            return;
        }
        Context context = editText.getContext();
        s(f.a(context), context.getString(x7.u.f14020i7, editText.getHint()));
        if (z10) {
            y.X(editText);
        }
    }

    public static void k(Context context, int i10, int i11) {
        m(context, context.getString(i10), context.getString(i11));
    }

    public static void l(Context context, int i10, String str) {
        m(context, context.getString(i10), str);
    }

    public static void m(Context context, String str, String str2) {
        n(context, str, str2, null);
    }

    public static void n(Context context, String str, String str2, k.m mVar) {
        w5.k.l(context).e0(str).J(str2).V(R.string.ok, mVar).f0();
    }

    public static void o(Context context, int i10) {
        p(context, context.getString(i10));
    }

    public static void p(Context context, String str) {
        Toast.makeText(context, str, 0).show();
    }

    public static void q(Context context, int i10) {
        u(context, context.getResources().getString(i10), null, null, null);
    }

    public static void r(Context context, int i10, int i11, View.OnClickListener onClickListener) {
        u(context, context.getString(i10), context.getString(i11), onClickListener, null);
    }

    public static void s(Context context, String str) {
        u(context, str, null, null, null);
    }

    public static void t(Context context, String str, String str2, View.OnClickListener onClickListener) {
        u(context, str, str2, onClickListener, null);
    }

    public static void u(Context context, String str, String str2, View.OnClickListener onClickListener, h.c cVar) {
        f.a(context).runOnUiThread(new a(context, str, str2, onClickListener, cVar));
    }
}
