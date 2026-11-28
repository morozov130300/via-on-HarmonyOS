package c8;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import c6.a2;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class x0 extends q4.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set f2297b = new HashSet(Arrays.asList("html", "htm", "css", "png", "js", "mht", "pdf", "jpg", "jpeg", "ttf", "otf", "woff", "woff2"));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2298a = null;

    @Override // q4.a
    public WebResourceResponse H(t4.b bVar, WebResourceRequest webResourceRequest, String str, String str2) {
        a2 a2Var = a2.f1958a;
        if (!a2Var.m(str)) {
            return super.H(bVar, webResourceRequest, str, str2);
        }
        String strD = a2Var.d(str);
        if (strD != null && !strD.isEmpty() && f2297b.contains(strD)) {
            return null;
        }
        L(bVar.getContext());
        if (K(new File(((Build.VERSION.SDK_INT < 21 || webResourceRequest == null) ? Uri.parse(str) : webResourceRequest.getUrl()).getPath()))) {
            return null;
        }
        return new WebResourceResponse("text/plain", "UTF-8", new ByteArrayInputStream(new byte[0]));
    }

    public final String J(File file) {
        try {
            return file.getCanonicalPath();
        } catch (Exception unused) {
            return file.getAbsolutePath();
        }
    }

    public final boolean K(File file) {
        if (file == null) {
            return true;
        }
        return !J(file).startsWith(this.f2298a);
    }

    public final void L(Context context) {
        File filesDir;
        if (this.f2298a != null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            filesDir = context.getDataDir();
        } else {
            File parentFile = context.getFilesDir().getParentFile();
            filesDir = parentFile == null ? context.getFilesDir() : parentFile;
        }
        this.f2298a = J(filesDir);
    }
}
