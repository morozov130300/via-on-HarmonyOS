package e8;

import android.os.Build;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class k extends p4.a {

    /* renamed from: a, reason: collision with root package name */
    public final a f4836a;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface a {
        boolean Z(ValueCallback valueCallback, WebChromeClient.FileChooserParams fileChooserParams);

        void s(ValueCallback valueCallback);
    }

    public k(a aVar) {
        this.f4836a = aVar;
    }

    @Override // p4.a
    public boolean A(t4.b bVar, ValueCallback valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        if (Build.VERSION.SDK_INT < 21) {
            return false;
        }
        this.f4836a.Z(valueCallback, fileChooserParams);
        return true;
    }

    @Override // p4.a
    public boolean z(ValueCallback valueCallback, String str, String str2) {
        this.f4836a.s(valueCallback);
        return true;
    }
}
