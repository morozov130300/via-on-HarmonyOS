package na;

import android.os.Bundle;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class g extends r4.b {

    /* renamed from: d, reason: collision with root package name */
    public final String f10290d;

    public g(String str, Bundle bundle) {
        super(bundle);
        this.f10290d = str;
    }

    public static g d(String str, Bundle bundle) {
        if (bundle != null) {
            return new g(str, bundle);
        }
        throw new NullPointerException("bundle == null");
    }

    public static g e(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("URL", str2);
        bundle.putString("TITLE", str3);
        return new g(str, bundle);
    }

    public String c() {
        return this.f10290d;
    }
}
