package s0;

import android.content.pm.PackageInfo;
import android.webkit.WebView;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    public static PackageInfo a() {
        return WebView.getCurrentWebViewPackage();
    }
}
