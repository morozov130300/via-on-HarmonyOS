package r0;

import android.webkit.WebView;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WebView f11880b;

    public b(String str, WebView webView) {
        this.f11879a = str;
        this.f11880b = webView;
    }

    public void a(WebView webView) {
        if (this.f11880b != webView) {
            throw new IllegalArgumentException("The world is not associated with the webview");
        }
    }

    public String b() {
        return this.f11879a;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (Objects.equals(this.f11879a, bVar.f11879a) && Objects.equals(this.f11880b, bVar.f11880b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.f11879a, this.f11880b);
    }
}
