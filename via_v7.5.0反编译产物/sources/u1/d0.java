package u1;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class d0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Uri f12764f = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ComponentName f12767c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f12768d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f12769e;

    public d0(String str, String str2, int i10, boolean z10) {
        f.d(str);
        this.f12765a = str;
        f.d(str2);
        this.f12766b = str2;
        this.f12767c = null;
        this.f12768d = i10;
        this.f12769e = z10;
    }

    public final int a() {
        return this.f12768d;
    }

    public final ComponentName b() {
        return this.f12767c;
    }

    public final Intent c(Context context) {
        Bundle bundleCall;
        if (this.f12765a == null) {
            return new Intent().setComponent(this.f12767c);
        }
        Intent intent = null;
        if (this.f12769e) {
            Bundle bundle = new Bundle();
            bundle.putString("serviceActionBundleKey", this.f12765a);
            try {
                bundleCall = context.getContentResolver().call(f12764f, "serviceIntentCall", (String) null, bundle);
            } catch (IllegalArgumentException e10) {
                Log.w("ConnectionStatusConfig", "Dynamic intent resolution failed: ".concat(e10.toString()));
                bundleCall = null;
            }
            intent = bundleCall != null ? (Intent) bundleCall.getParcelable("serviceResponseIntentKey") : null;
            if (intent == null) {
                Log.w("ConnectionStatusConfig", "Dynamic lookup for intent failed for action: ".concat(String.valueOf(this.f12765a)));
            }
        }
        return intent != null ? intent : new Intent(this.f12765a).setPackage(this.f12766b);
    }

    public final String d() {
        return this.f12766b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        return e.a(this.f12765a, d0Var.f12765a) && e.a(this.f12766b, d0Var.f12766b) && e.a(this.f12767c, d0Var.f12767c) && this.f12768d == d0Var.f12768d && this.f12769e == d0Var.f12769e;
    }

    public final int hashCode() {
        return e.b(this.f12765a, this.f12766b, this.f12767c, Integer.valueOf(this.f12768d), Boolean.valueOf(this.f12769e));
    }

    public final String toString() {
        String str = this.f12765a;
        if (str != null) {
            return str;
        }
        f.h(this.f12767c);
        return this.f12767c.flattenToString();
    }
}
