package mark.via.browser;

import android.os.Handler;
import android.os.Looper;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import androidx.webkit.JavaScriptExecutionException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WebView f9009a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q9 f9012d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final JSONArray[] f9014f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ValueCallback f9015g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f9016h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f9010b = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f9011c = new Runnable() { // from class: mark.via.browser.za
        @Override // java.lang.Runnable
        public final void run() {
            this.f9831c.e();
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f9013e = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements r0.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f9017a;

        public a(int i10) {
            this.f9017a = i10;
        }

        @Override // r0.m
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(JavaScriptExecutionException javaScriptExecutionException) {
            ab.this.g(this.f9017a, null);
        }

        @Override // r0.m
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onResult(String str) {
            ab.this.g(this.f9017a, str);
        }
    }

    public ab(WebView webView, boolean z10) {
        this.f9009a = webView;
        q9 q9VarM = z10 ? q9.m(webView) : null;
        this.f9012d = q9VarM;
        if (q9VarM != null) {
            for (q9.b bVar : q9VarM.z()) {
                if (!bVar.f9567f) {
                    this.f9013e.add(bVar);
                }
            }
        }
        this.f9014f = new JSONArray[this.f9013e.size() + 1];
    }

    public static /* synthetic */ void a(ab abVar, String str) {
        boolean zOptBoolean;
        if (abVar.f9015g == null) {
            return;
        }
        int i10 = 0;
        try {
            if (str == null) {
                str = "null";
            }
            JSONObject jSONObject = new JSONObject(str);
            abVar.f9014f[0] = jSONObject.optJSONArray("text");
            zOptBoolean = jSONObject.optBoolean("reader");
        } catch (JSONException unused) {
            zOptBoolean = false;
        }
        if (zOptBoolean || abVar.f9013e.isEmpty()) {
            abVar.e();
            return;
        }
        abVar.f9016h = abVar.f9013e.size();
        String str2 = "(function(){var text=" + c6.g1.f2009a.n(false) + "return JSON.parse(text);})();";
        while (i10 < abVar.f9013e.size()) {
            int i11 = i10 + 1;
            q9.b bVar = (q9.b) abVar.f9013e.get(i10);
            if (abVar.f9012d.i(bVar)) {
                try {
                    bVar.c(str2, abVar.new a(i11));
                } catch (RuntimeException unused2) {
                    abVar.g(i11, null);
                }
            } else {
                abVar.g(i11, null);
            }
            i10 = i11;
        }
    }

    public void d() {
        this.f9010b.removeCallbacks(this.f9011c);
        this.f9015g = null;
    }

    public final void e() {
        JSONArray jSONArray;
        if (this.f9015g == null) {
            return;
        }
        JSONArray jSONArray2 = new JSONArray();
        for (int i10 = 0; i10 < this.f9014f.length; i10++) {
            if ((i10 <= 0 || this.f9012d.i((q9.b) this.f9013e.get(i10 - 1))) && (jSONArray = this.f9014f[i10]) != null) {
                for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                    Object objOpt = jSONArray.opt(i11);
                    if (objOpt instanceof String) {
                        jSONArray2.put(objOpt);
                    }
                }
            }
        }
        ValueCallback valueCallback = this.f9015g;
        d();
        valueCallback.onReceiveValue(jSONArray2.toString());
    }

    public void f(ValueCallback valueCallback) {
        this.f9015g = valueCallback;
        this.f9010b.postDelayed(this.f9011c, 2000L);
        this.f9009a.evaluateJavascript("(function(){var text=" + c6.g1.f2009a.n(this.f9013e.isEmpty()) + "return {reader:!!document.querySelector('.via-reader-body'),text:JSON.parse(text)};})();", new ValueCallback() { // from class: mark.via.browser.ya
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                ab.a(this.f9798a, (String) obj);
            }
        });
    }

    public final void g(int i10, String str) {
        if (this.f9015g == null) {
            return;
        }
        if (str != null) {
            try {
                this.f9014f[i10] = new JSONArray(str);
            } catch (JSONException unused) {
            }
        }
        int i11 = this.f9016h - 1;
        this.f9016h = i11;
        if (i11 == 0) {
            e();
        }
    }
}
