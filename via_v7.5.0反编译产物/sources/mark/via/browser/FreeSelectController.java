package mark.via.browser;

import android.R;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.webkit.ValueCallback;
import androidx.fragment.app.Fragment;
import androidx.webkit.JavaScriptExecutionException;
import com.tuyafeng.support.utils.FragmentUtils;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class FreeSelectController implements View.OnAttachStateChangeListener, androidx.lifecycle.d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f8935c = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public t4.b f8936e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f8937m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public q9.b f8938n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f8939o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f8940p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f8941q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f8942r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f8943s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f8944t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public q5.k f8945u;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements r0.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ValueCallback f8946a;

        public a(ValueCallback valueCallback) {
            this.f8946a = valueCallback;
        }

        @Override // r0.m
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(JavaScriptExecutionException javaScriptExecutionException) {
            ValueCallback valueCallback = this.f8946a;
            if (valueCallback != null) {
                valueCallback.onReceiveValue(null);
            }
        }

        @Override // r0.m
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onResult(String str) {
            ValueCallback valueCallback = this.f8946a;
            if (valueCallback != null) {
                valueCallback.onReceiveValue(str);
            }
        }
    }

    public FreeSelectController(Fragment fragment) {
        FragmentUtils.f(fragment, this);
    }

    public static /* synthetic */ void d(FreeSelectController freeSelectController, t4.b bVar, String str) {
        if (freeSelectController.w(bVar, str)) {
            freeSelectController.u();
        }
    }

    public static /* synthetic */ void h(FreeSelectController freeSelectController, int[] iArr, t4.b bVar, String str, q9.b bVar2, String str2, ValueCallback valueCallback, String str3) {
        freeSelectController.getClass();
        if (str3 != null && !"null".equals(str3)) {
            if (!freeSelectController.w(bVar, str) || iArr[0] == 0) {
                t(bVar, bVar2, str2, null);
                return;
            }
            iArr[0] = 0;
            freeSelectController.f8938n = bVar2;
            valueCallback.onReceiveValue(str3);
            return;
        }
        int i10 = iArr[0];
        if (i10 > 0) {
            int i11 = i10 - 1;
            iArr[0] = i11;
            if (i11 == 0 && freeSelectController.w(bVar, str)) {
                freeSelectController.u();
            }
        }
    }

    public static /* synthetic */ void k(FreeSelectController freeSelectController, t4.b bVar, String str) {
        if (freeSelectController.w(bVar, str)) {
            freeSelectController.u();
        }
    }

    public static /* synthetic */ void l(final FreeSelectController freeSelectController, final t4.b bVar, final String str, Runnable runnable, String str2) {
        if (freeSelectController.w(bVar, str)) {
            freeSelectController.f8935c.removeCallbacks(runnable);
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (jSONObject.optBoolean("selected")) {
                    freeSelectController.f8944t = true;
                    return;
                }
                final String strOptString = jSONObject.optString("text");
                if (strOptString.trim().isEmpty()) {
                    freeSelectController.u();
                    return;
                }
                t(bVar, freeSelectController.f8938n, freeSelectController.D("cancel"), null);
                bVar.k();
                q5.k kVarW = q5.k.l(bVar.getContext()).f0(w7.u.f14023e0).K(strOptString).X(w7.u.f14272w, new q5.k.m() { // from class: mark.via.browser.u9
                    @Override // q5.k.m
                    public final void a(View view, q5.k.p pVar) {
                        FreeSelectController.o(this.f9688a, bVar, str, strOptString, view, pVar);
                    }
                }).P(R.string.cancel, null).W(new DialogInterface.OnDismissListener() { // from class: mark.via.browser.v9
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        this.f9709c.q();
                    }
                });
                freeSelectController.f8945u = kVarW;
                kVarW.h0();
            } catch (Exception e10) {
                tc.a.j(e10);
                freeSelectController.u();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1 */
    public static /* synthetic */ void n(final FreeSelectController freeSelectController, final t4.b bVar, final String str, JSONObject jSONObject, String str2, String str3, String str4, Runnable runnable, String str5) {
        FreeSelectController freeSelectController2 = "frame";
        if (!freeSelectController.w(bVar, str)) {
            if (jSONObject == null) {
                bVar.evaluateJavascript(str2, null);
                return;
            }
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(str5);
            try {
                if (jSONObject2.has("frame")) {
                    freeSelectController.A(bVar, str, str3, str4 + "[" + jSONObject2.getInt("frame") + "]", jSONObject2.getJSONObject("bounds"), runnable);
                    return;
                }
                double d10 = jSONObject2.getDouble("x");
                double d11 = jSONObject2.getDouble("y");
                if (d10 >= 0.0d && d10 < bVar.getWidth() && d11 >= 0.0d && d11 < bVar.getHeight()) {
                    freeSelectController.f8940p = (float) d10;
                    freeSelectController.f8941q = (float) d11;
                    freeSelectController.f8935c.removeCallbacks(runnable);
                    freeSelectController.f8943s = true;
                    freeSelectController.f8939o = SystemClock.uptimeMillis();
                    freeSelectController.s(0);
                    freeSelectController.f8935c.postDelayed(new Runnable() { // from class: mark.via.browser.z9
                        @Override // java.lang.Runnable
                        public final void run() {
                            FreeSelectController.p(this.f9828c, bVar, str);
                        }
                    }, Math.max(500, ViewConfiguration.getLongPressTimeout() + 100));
                    return;
                }
                freeSelectController.u();
                return;
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            freeSelectController2 = freeSelectController;
        }
        freeSelectController2.u();
    }

    public static /* synthetic */ void o(FreeSelectController freeSelectController, t4.b bVar, String str, String str2, View view, q5.k.p pVar) {
        if (freeSelectController.w(bVar, str)) {
            com.tuyafeng.support.utils.n.a(bVar.getContext(), str2, w7.u.Eg);
        }
    }

    public static /* synthetic */ void p(final FreeSelectController freeSelectController, final t4.b bVar, final String str) {
        if (freeSelectController.w(bVar, str)) {
            freeSelectController.s(1);
            freeSelectController.f8943s = false;
            freeSelectController.f8935c.postDelayed(new Runnable() { // from class: mark.via.browser.aa
                @Override // java.lang.Runnable
                public final void run() {
                    this.f9006c.r(bVar, str);
                }
            }, 300L);
        }
    }

    public static void t(t4.b bVar, q9.b bVar2, String str, ValueCallback valueCallback) {
        if (bVar2 == null) {
            bVar.evaluateJavascript(str, valueCallback);
        } else {
            bVar2.c(str, new a(valueCallback));
        }
    }

    public final void A(final t4.b bVar, final String str, final String str2, final String str3, final JSONObject jSONObject, final Runnable runnable) {
        final String strD = D("cancel");
        String strReplace = str2.replace("__BOUNDS__", jSONObject == null ? "null" : jSONObject.toString());
        ValueCallback<String> valueCallback = new ValueCallback() { // from class: mark.via.browser.x9
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                FreeSelectController.n(this.f9757a, bVar, str, jSONObject, strD, str2, str3, runnable, (String) obj);
            }
        };
        if (jSONObject == null) {
            bVar.evaluateJavascript(strReplace, valueCallback);
            return;
        }
        List<q9.b> listZ = q9.m(bVar).z();
        if (listZ.isEmpty()) {
            u();
            return;
        }
        String str4 = "(function(){try{if(window!==" + str3 + ")return null;}catch(e){return null;}return " + strReplace + "})()";
        final int[] iArr = {listZ.size()};
        for (final q9.b bVar2 : listZ) {
            final ValueCallback<String> valueCallback2 = valueCallback;
            final String str5 = strD;
            strD = str5;
            valueCallback = valueCallback2;
            t(bVar, bVar2, str4, new ValueCallback() { // from class: mark.via.browser.y9
                @Override // android.webkit.ValueCallback
                public final void onReceiveValue(Object obj) {
                    FreeSelectController.h(this.f9791a, iArr, bVar, str, bVar2, str5, valueCallback2, (String) obj);
                }
            });
        }
    }

    public void B(q9.b bVar) {
        if (this.f8938n == bVar) {
            q();
        }
    }

    public void C(final t4.b bVar, int i10, int i11, String str) {
        q();
        if (bVar == null || !bVar.isAttachedToWindow() || !bVar.getSettings().getJavaScriptEnabled() || bVar.getWidth() <= 0 || bVar.getHeight() <= 0) {
            return;
        }
        String strC = u8.c(bVar.getContext());
        if (strC == null) {
            com.tuyafeng.support.utils.n.q(bVar.getContext(), w7.u.Ng);
            return;
        }
        int[] iArr = new int[2];
        bVar.getLocationOnScreen(iArr);
        float f10 = i10 - iArr[0];
        this.f8940p = f10;
        float f11 = i11 - iArr[1];
        this.f8941q = f11;
        if (f10 < 0.0f || f11 < 0.0f || f10 >= bVar.getWidth() || this.f8941q >= bVar.getHeight()) {
            return;
        }
        this.f8936e = bVar;
        final String string = UUID.randomUUID().toString();
        this.f8937m = string;
        bVar.addOnAttachStateChangeListener(this);
        String strReplace = strC.replace("__X__", String.valueOf(this.f8940p)).replace("__Y__", String.valueOf(this.f8941q)).replace("__WW__", String.valueOf(bVar.getWidth())).replace("__WH__", String.valueOf(bVar.getHeight())).replace("__RADIUS__", String.valueOf(bVar.getResources().getDisplayMetrics().density * 16.0f)).replace("__FROM__", String.valueOf(bVar.getId())).replace("__ACTION__", String.valueOf(111)).replace("__TOKEN__", JSONObject.quote(string)).replace("__SECRET__", JSONObject.quote(str));
        Runnable runnable = new Runnable() { // from class: mark.via.browser.w9
            @Override // java.lang.Runnable
            public final void run() {
                FreeSelectController.k(this.f9735c, bVar, string);
            }
        };
        this.f8935c.postDelayed(runnable, 3000L);
        A(bVar, string, strReplace, "top", null, runnable);
    }

    public final String D(String str) {
        return "(function(){var s=window.__viaFreeSelect;if(s&&s.token===" + JSONObject.quote(this.f8937m) + ")return s." + str + "();})()";
    }

    @Override // androidx.lifecycle.d
    public /* synthetic */ void b(androidx.lifecycle.j jVar) {
        androidx.lifecycle.c.c(this, jVar);
    }

    @Override // androidx.lifecycle.d
    public /* synthetic */ void c(androidx.lifecycle.j jVar) {
        androidx.lifecycle.c.a(this, jVar);
    }

    @Override // androidx.lifecycle.d
    public void f(androidx.lifecycle.j jVar) {
        q();
    }

    @Override // androidx.lifecycle.d
    public /* synthetic */ void g(androidx.lifecycle.j jVar) {
        androidx.lifecycle.c.e(this, jVar);
    }

    @Override // androidx.lifecycle.d
    public void i(androidx.lifecycle.j jVar) {
        q();
    }

    @Override // androidx.lifecycle.d
    public /* synthetic */ void j(androidx.lifecycle.j jVar) {
        androidx.lifecycle.c.d(this, jVar);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        q();
    }

    public void q() {
        t4.b bVar = this.f8936e;
        if (bVar == null) {
            return;
        }
        String strD = D("cancel");
        this.f8937m = null;
        this.f8935c.removeCallbacksAndMessages(null);
        if (this.f8943s) {
            s(3);
        }
        bVar.removeOnAttachStateChangeListener(this);
        this.f8936e = null;
        this.f8944t = false;
        this.f8943s = false;
        q5.k kVar = this.f8945u;
        if (kVar != null) {
            this.f8945u = null;
            kVar.o();
        }
        t(bVar, this.f8938n, strD, null);
        this.f8938n = null;
        bVar.k();
    }

    public final void r(final t4.b bVar, final String str) {
        if (w(bVar, str)) {
            final Runnable runnable = new Runnable() { // from class: mark.via.browser.s9
                @Override // java.lang.Runnable
                public final void run() {
                    FreeSelectController.d(this.f9644c, bVar, str);
                }
            };
            this.f8935c.postDelayed(runnable, 3000L);
            t(bVar, this.f8938n, D("check"), new ValueCallback() { // from class: mark.via.browser.t9
                @Override // android.webkit.ValueCallback
                public final void onReceiveValue(Object obj) {
                    FreeSelectController.l(this.f9667a, bVar, str, runnable, (String) obj);
                }
            });
        }
    }

    public final void s(int i10) {
        MotionEvent motionEventObtain = MotionEvent.obtain(this.f8939o, SystemClock.uptimeMillis(), i10, this.f8940p, this.f8941q, 0);
        this.f8942r = true;
        try {
            this.f8936e.dispatchTouchEvent(motionEventObtain);
        } finally {
            this.f8942r = false;
            motionEventObtain.recycle();
        }
    }

    public final void u() {
        t4.b bVar = this.f8936e;
        if (bVar != null) {
            com.tuyafeng.support.utils.n.q(bVar.getContext(), w7.u.Ng);
        }
        q();
    }

    public boolean v() {
        return this.f8943s;
    }

    public final boolean w(t4.b bVar, String str) {
        String str2;
        return this.f8936e == bVar && (str2 = this.f8937m) != null && str2.equals(str);
    }

    public void x(t4.b bVar) {
        if (this.f8936e == bVar) {
            q();
        }
    }

    public void y(int i10, String str, boolean z10) {
        if (w(this.f8936e, str) && this.f8936e.getId() == i10 && this.f8945u == null) {
            if (z10) {
                this.f8944t = true;
            } else if (this.f8944t) {
                q();
            }
        }
    }

    public boolean z(View view, MotionEvent motionEvent) {
        if (view != this.f8936e) {
            return false;
        }
        if (this.f8942r) {
            return true;
        }
        if ((this.f8943s || (!this.f8944t && this.f8945u == null)) && motionEvent.getActionMasked() == 0) {
            q();
        }
        return false;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }
}
