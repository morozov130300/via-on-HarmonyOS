package x8;

import android.print.PrintAttributes;
import android.webkit.WebView;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class u1 {
    public static void a(WebView webView, String str, String str2) {
        if (webView == null || str2 == null || str == null) {
            return;
        }
        new a.a(new PrintAttributes.Builder().setMediaSize(PrintAttributes.MediaSize.ISO_A4).setResolution(new PrintAttributes.Resolution("pdf", "pdf", 600, 600)).setMinMargins(PrintAttributes.Margins.NO_MARGINS).build()).c(webView.createPrintDocumentAdapter("Via Document"), new File(str), str2);
    }
}
