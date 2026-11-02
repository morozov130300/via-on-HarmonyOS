package z8;

import android.print.PrintAttributes;
import android.webkit.WebView;
import java.io.File;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class v1 {
    public static void a(WebView webView, String str, String str2) {
        if (webView == null || str2 == null || str == null) {
            return;
        }
        new a.a(new PrintAttributes.Builder().setMediaSize(PrintAttributes.MediaSize.ISO_A4).setResolution(new PrintAttributes.Resolution("pdf", "pdf", 600, 600)).setMinMargins(PrintAttributes.Margins.NO_MARGINS).build()).c(webView.createPrintDocumentAdapter("Via Document"), new File(str), str2);
    }
}
