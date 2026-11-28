package mark.via.browser;

import android.webkit.ValueCallback;
import android.webkit.WebView;
import androidx.webkit.JavaScriptExecutionException;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class rd implements com.tuyafeng.support.widget.a0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WebView f9608a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f9611d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f9612e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f9613f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Runnable f9614g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f9615h;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f9610c = new IdentityHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f9609b = q9.s();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements r0.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f9616a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ValueCallback f9617b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f9618c;

        public a(long j10, ValueCallback valueCallback, b bVar) {
            this.f9616a = j10;
            this.f9617b = valueCallback;
            this.f9618c = bVar;
        }

        @Override // r0.m
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(JavaScriptExecutionException javaScriptExecutionException) {
            if (this.f9616a != rd.this.f9613f) {
                return;
            }
            Object obj = rd.this.f9610c.get(this.f9618c.f9620a);
            b bVar = this.f9618c;
            if (obj == bVar) {
                rd.this.y(bVar.f9620a);
            }
            ValueCallback valueCallback = this.f9617b;
            if (valueCallback != null) {
                valueCallback.onReceiveValue(0);
            }
            if (javaScriptExecutionException.getErrorType() != 1) {
                tc.a.i("Video command failed (%d)", Integer.valueOf(javaScriptExecutionException.getErrorType()));
            }
        }

        @Override // r0.m
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onResult(String str) {
            ValueCallback valueCallback;
            if (this.f9616a == rd.this.f9613f && (valueCallback = this.f9617b) != null) {
                valueCallback.onReceiveValue(Integer.valueOf(rd.w(str)));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final q9.b f9620a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f9621b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f9622c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f9623d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f9624e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f9625f = 1.0f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f9626g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f9627h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f9628i;

        public b(q9.b bVar, long j10) {
            this.f9620a = bVar;
            this.f9621b = j10;
        }
    }

    public rd(WebView webView) {
        this.f9608a = webView;
    }

    public static /* synthetic */ void h(rd rdVar, ValueCallback valueCallback, long j10, String str) {
        if (valueCallback == null) {
            rdVar.getClass();
        } else if (j10 == rdVar.f9613f) {
            valueCallback.onReceiveValue(Integer.valueOf(w(str)));
        }
    }

    public static /* synthetic */ void i(rd rdVar, long j10, String str) {
        if (j10 != rdVar.f9613f) {
            return;
        }
        String[] strArrSplit = str.replace("\"", "").split(",");
        if (strArrSplit.length >= 4) {
            try {
                b bVar = new b(null, 0L);
                float f10 = Float.parseFloat(strArrSplit[0]);
                bVar.f9624e = f10;
                if (Float.isInfinite(f10) || Float.isNaN(bVar.f9624e)) {
                    bVar.f9624e = -1.0f;
                }
                bVar.f9625f = Float.parseFloat(strArrSplit[1]);
                bVar.f9626g = Integer.parseInt(strArrSplit[2]);
                bVar.f9627h = Integer.parseInt(strArrSplit[3]);
                rdVar.f9611d = bVar;
            } catch (NumberFormatException e10) {
                tc.a.j(e10);
            }
        }
        rdVar.f9614g.run();
    }

    public static b m(Collection collection, b bVar, boolean z10) {
        int i10;
        int i11;
        Iterator it = collection.iterator();
        boolean z11 = false;
        b bVar2 = null;
        while (it.hasNext()) {
            b bVar3 = (b) it.next();
            if (bVar3 == bVar) {
                z11 = z10;
            }
            if (bVar2 == null || (i10 = bVar3.f9622c) > (i11 = bVar2.f9622c) || (i10 == i11 && bVar3.f9623d > bVar2.f9623d)) {
                bVar2 = bVar3;
            }
        }
        return (!z11 || bVar2.f9622c >= 3) ? bVar2 : bVar;
    }

    public static rd q(WebView webView) {
        rd rdVar = (rd) webView.getTag(w7.p.J0);
        if (rdVar != null) {
            return rdVar;
        }
        rd rdVar2 = new rd(webView);
        webView.setTag(w7.p.J0, rdVar2);
        return rdVar2;
    }

    public static int w(String str) {
        if ("1".equals(str) || "\"1\"".equals(str)) {
            return 1;
        }
        return ("2".equals(str) || "\"2\"".equals(str)) ? 2 : 0;
    }

    public final void A(boolean z10) {
        Runnable runnable;
        b bVarM = m(this.f9610c.values(), this.f9611d, this.f9614g != null);
        if (this.f9611d != bVarM) {
            if (this.f9614g != null) {
                v(false);
            }
            this.f9611d = bVarM;
            this.f9613f++;
            if (this.f9614g != null) {
                v(true);
            }
            z10 = true;
        }
        if (!z10 || (runnable = this.f9614g) == null) {
            return;
        }
        runnable.run();
    }

    public void B(ValueCallback valueCallback) {
        o("toggle", 0.0f, valueCallback);
    }

    public void C(Runnable runnable) {
        this.f9614g = runnable;
        final long j10 = this.f9613f + 1;
        this.f9613f = j10;
        if (this.f9609b) {
            v(true);
            runnable.run();
            return;
        }
        this.f9611d = null;
        runnable.run();
        String strA = sd.a(this.f9608a.getContext());
        if (strA == null) {
            return;
        }
        this.f9608a.evaluateJavascript(strA, new ValueCallback() { // from class: mark.via.browser.qd
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                rd.i(this.f9581a, j10, (String) obj);
            }
        });
    }

    public void D() {
        if (this.f9614g == null) {
            return;
        }
        v(false);
        this.f9614g = null;
        this.f9613f++;
        if (this.f9609b) {
            this.f9611d = m(this.f9610c.values(), null, false);
        }
    }

    public void E(q9.b bVar, JSONObject jSONObject) {
        long jOptLong = jSONObject.optLong("target");
        if (jOptLong <= 0) {
            y(bVar);
            return;
        }
        b bVar2 = (b) this.f9610c.get(bVar);
        if (bVar2 == null || bVar2.f9621b != jOptLong) {
            bVar2 = new b(bVar, jOptLong);
            this.f9610c.put(bVar, bVar2);
        }
        float fOptDouble = (float) jSONObject.optDouble("duration", -1.0d);
        float fOptDouble2 = (float) jSONObject.optDouble("rate", 1.0d);
        int iOptInt = jSONObject.optInt("width");
        int iOptInt2 = jSONObject.optInt("height");
        boolean z10 = false;
        boolean z11 = (bVar2.f9624e == fOptDouble && bVar2.f9625f == fOptDouble2 && bVar2.f9626g == iOptInt && bVar2.f9627h == iOptInt2) ? false : true;
        bVar2.f9622c = Math.max(1, Math.min(3, jSONObject.optInt("priority")));
        if (bVar2.f9623d == 0 || jSONObject.optBoolean("active")) {
            long j10 = this.f9612e + 1;
            this.f9612e = j10;
            bVar2.f9623d = j10;
        }
        bVar2.f9624e = fOptDouble;
        bVar2.f9625f = fOptDouble2;
        bVar2.f9626g = iOptInt;
        bVar2.f9627h = iOptInt2;
        bVar2.f9628i = jSONObject.optInt("paused");
        if (z11 && bVar2 == this.f9611d) {
            z10 = true;
        }
        A(z10);
    }

    @Override // com.tuyafeng.support.widget.a0.b
    public void a(ValueCallback valueCallback) {
        o("state", 0.0f, valueCallback);
    }

    @Override // com.tuyafeng.support.widget.a0.b
    public void b(int i10) {
        o("seek", i10, null);
    }

    @Override // com.tuyafeng.support.widget.a0.b
    public void c(float f10) {
        o("rate", f10, null);
    }

    @Override // com.tuyafeng.support.widget.a0.b
    public float d() {
        b bVar = this.f9611d;
        if (bVar == null) {
            return 1.0f;
        }
        return bVar.f9625f;
    }

    @Override // com.tuyafeng.support.widget.a0.b
    public Object e() {
        return this.f9611d;
    }

    @Override // com.tuyafeng.support.widget.a0.b
    public Runnable f(float f10, float f11) {
        final b bVar = this.f9611d;
        p(bVar, "hold", f10, null);
        return new Runnable() { // from class: mark.via.browser.pd
            @Override // java.lang.Runnable
            public final void run() {
                this.f9452c.p(bVar, "release", 0.0f, null);
            }
        };
    }

    @Override // com.tuyafeng.support.widget.a0.b
    public float getDuration() {
        b bVar = this.f9611d;
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.f9624e;
    }

    public void n() {
        this.f9610c.clear();
        this.f9611d = null;
        this.f9613f++;
        Runnable runnable = this.f9614g;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void o(String str, float f10, ValueCallback valueCallback) {
        p(this.f9611d, str, f10, valueCallback);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:18:0x0068  */
    public final void p(b bVar, String str, float f10, final ValueCallback valueCallback) {
        String strG;
        if (this.f9609b) {
            if (bVar == null) {
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(0);
                    return;
                }
                return;
            }
            long j10 = this.f9613f;
            bVar.f9620a.c("window.__VIA_VIDEO?window.__VIA_VIDEO.command(" + bVar.f9621b + ",'" + str + "'," + f10 + "):0;", new a(j10, valueCallback, bVar));
            return;
        }
        if (bVar == this.f9611d || "release".equals(str)) {
            str.getClass();
            switch (str) {
                case "toggle":
                    strG = sd.g(this.f9608a.getContext());
                    break;
                case "hold":
                case "release":
                    strG = sd.i(this.f9608a.getContext(), f10);
                    break;
                case "rate":
                    strG = sd.h(this.f9608a.getContext(), f10);
                    break;
                case "seek":
                    strG = sd.f(this.f9608a.getContext(), (int) f10);
                    break;
                default:
                    strG = sd.c(this.f9608a.getContext());
                    break;
            }
            if (strG != null) {
                final long j11 = this.f9613f;
                this.f9608a.evaluateJavascript(strG, new ValueCallback() { // from class: mark.via.browser.od
                    @Override // android.webkit.ValueCallback
                    public final void onReceiveValue(Object obj) {
                        rd.h(this.f9402a, valueCallback, j11, (String) obj);
                    }
                });
            } else if (valueCallback != null) {
                valueCallback.onReceiveValue(0);
            }
        }
    }

    public int r() {
        b bVar = this.f9611d;
        if (bVar == null) {
            return 0;
        }
        return bVar.f9627h;
    }

    public int s() {
        b bVar = this.f9611d;
        if (bVar == null) {
            return 0;
        }
        return bVar.f9628i;
    }

    public int t() {
        b bVar = this.f9611d;
        if (bVar == null) {
            return 0;
        }
        return bVar.f9626g;
    }

    public boolean u() {
        return this.f9611d != null;
    }

    public final void v(boolean z10) {
        b bVar = this.f9611d;
        if (bVar == null || !this.f9609b) {
            return;
        }
        bVar.f9620a.b("window.__VIA_VIDEO&&window.__VIA_VIDEO.lock(" + this.f9611d.f9621b + "," + z10 + ");");
    }

    public void x() {
        WebView webView = this.f9608a;
        s4.b.g(webView, sd.d(webView.getContext()));
        this.f9615h = true;
    }

    public void y(q9.b bVar) {
        if (this.f9610c.remove(bVar) != null) {
            A(false);
        }
    }

    public void z() {
        if (this.f9615h) {
            WebView webView = this.f9608a;
            s4.b.g(webView, sd.e(webView.getContext()));
            this.f9615h = false;
        }
    }
}
