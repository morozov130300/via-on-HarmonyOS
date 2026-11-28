package com.tuyafeng.support.utils;

import android.R;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class n {

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f3581c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f3582e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ String f3583m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f3584n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ a6.h.c f3585o;

        public a(Context context, String str, String str2, View.OnClickListener onClickListener, a6.h.c cVar) {
            this.f3581c = context;
            this.f3582e = str;
            this.f3583m = str2;
            this.f3584n = onClickListener;
            this.f3585o = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            new a6.h.b(f.a(this.f3581c)).h(this.f3582e).d(this.f3583m).e(this.f3584n).f(null).g(this.f3585o).a().s();
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
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        ClipData clipDataNewPlainText = ClipData.newPlainText(null, str);
        if (Build.VERSION.SDK_INT >= 33 && z10) {
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

    public static void e(Context context, int i10, int i11, q5.k.m mVar) {
        h(context, context.getString(i10), context.getString(i11), mVar, null);
    }

    public static void f(Context context, int i10, String str, q5.k.m mVar) {
        h(context, context.getString(i10), str, mVar, null);
    }

    public static void g(Context context, String str, String str2, q5.k.m mVar) {
        h(context, str, str2, mVar, null);
    }

    public static void h(Context context, String str, String str2, q5.k.m mVar, View.OnClickListener onClickListener) {
        q5.k.l(context).g0(str).K(str2).X(R.string.ok, mVar).P(R.string.cancel, onClickListener).h0();
    }

    public static void i(EditText editText) {
        j(editText, false);
    }

    public static void j(EditText editText, boolean z10) {
        if (editText == null) {
            return;
        }
        Context context = editText.getContext();
        s(f.a(context), context.getString(w7.u.f14254u7, editText.getHint()));
        if (z10) {
            x.Y(editText);
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

    public static void n(Context context, String str, String str2, q5.k.m mVar) {
        q5.k.l(context).g0(str).K(str2).X(R.string.ok, mVar).h0();
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

    public static void u(Context context, String str, String str2, View.OnClickListener onClickListener, a6.h.c cVar) {
        f.a(context).runOnUiThread(new a(context, str, str2, onClickListener, cVar));
    }
}
