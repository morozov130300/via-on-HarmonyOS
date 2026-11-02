package n5;

import android.webkit.URLUtil;
import android.webkit.WebView;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import r5.d;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a implements b {

    /* renamed from: a, reason: collision with root package name */
    public final p5.c f10196a;

    /* renamed from: b, reason: collision with root package name */
    public final c f10197b;

    /* renamed from: c, reason: collision with root package name */
    public final String f10198c = UUID.randomUUID().toString();

    public a(p5.c cVar, c cVar2) {
        this.f10196a = cVar;
        this.f10197b = cVar2;
    }

    @Override // n5.b
    public c a() {
        return this.f10197b;
    }

    @Override // n5.b
    public boolean b(WebView webView, String str, int i10) {
        if (str != null && !str.isEmpty() && !str.startsWith("file://") && this.f10196a != null) {
            if (i10 == 1 || i10 == 2) {
                String strE = e(str);
                if (strE.contains("greasyfork.org") || strE.contains("userscript.zone") || strE.contains("openuserjs.org") || strE.contains("sleazyfork.org")) {
                    webView.evaluateJavascript(this.f10197b.a(this.f10198c), null);
                }
            }
            List<d> listF = this.f10196a.F(str, i10);
            if (listF != null && !listF.isEmpty()) {
                boolean z10 = false;
                for (d dVar : listF) {
                    if (dVar.a() != null && !dVar.a().isEmpty()) {
                        boolean z11 = (dVar.b() & 1) == 0;
                        StringBuilder sb2 = new StringBuilder();
                        if (z11) {
                            sb2.append("(function(){\n");
                        }
                        sb2.append(this.f10197b.e(dVar.h(), this.f10198c, dVar.c()));
                        if (dVar.e() != null) {
                            for (String str2 : dVar.e()) {
                                sb2.append(this.f10196a.H(str2));
                                sb2.append("\n\n");
                            }
                        }
                        sb2.append(dVar.a());
                        if (z11) {
                            sb2.append("\n})();");
                        }
                        webView.evaluateJavascript(sb2.toString(), null);
                        z10 = true;
                    }
                }
                return z10;
            }
        }
        return false;
    }

    @Override // n5.b
    public String c() {
        return this.f10198c;
    }

    @Override // n5.b
    public p5.c d() {
        return this.f10196a;
    }

    public final String e(String str) {
        int iIndexOf;
        if (str == null || str.isEmpty() || !URLUtil.isNetworkUrl(str) || (iIndexOf = str.indexOf("://")) < 0) {
            return "";
        }
        int i10 = iIndexOf + 3;
        int iIndexOf2 = str.indexOf(47, i10);
        if (iIndexOf2 < 0) {
            iIndexOf2 = str.length();
        }
        return str.substring(i10, iIndexOf2).toLowerCase(Locale.ROOT);
    }
}
