package ka;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class g extends r4.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f7261d;

    public g(String str, Bundle bundle) {
        super(bundle);
        this.f7261d = str;
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
        return this.f7261d;
    }
}
