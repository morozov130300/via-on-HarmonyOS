package t1;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class d0 {

    /* renamed from: f, reason: collision with root package name */
    public static final Uri f12031f = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();

    /* renamed from: a, reason: collision with root package name */
    public final String f12032a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12033b;

    /* renamed from: c, reason: collision with root package name */
    public final ComponentName f12034c;

    /* renamed from: d, reason: collision with root package name */
    public final int f12035d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f12036e;

    public d0(String str, String str2, int i10, boolean z10) {
        f.d(str);
        this.f12032a = str;
        f.d(str2);
        this.f12033b = str2;
        this.f12034c = null;
        this.f12035d = i10;
        this.f12036e = z10;
    }

    public final int a() {
        return this.f12035d;
    }

    public final ComponentName b() {
        return this.f12034c;
    }

    public final Intent c(Context context) {
        Bundle bundleCall;
        if (this.f12032a == null) {
            return new Intent().setComponent(this.f12034c);
        }
        if (this.f12036e) {
            Bundle bundle = new Bundle();
            bundle.putString("serviceActionBundleKey", this.f12032a);
            try {
                bundleCall = context.getContentResolver().call(f12031f, "serviceIntentCall", (String) null, bundle);
            } catch (IllegalArgumentException e10) {
                Log.w("ConnectionStatusConfig", "Dynamic intent resolution failed: ".concat(e10.toString()));
                bundleCall = null;
            }
            intent = bundleCall != null ? (Intent) bundleCall.getParcelable("serviceResponseIntentKey") : null;
            if (intent == null) {
                Log.w("ConnectionStatusConfig", "Dynamic lookup for intent failed for action: ".concat(String.valueOf(this.f12032a)));
            }
        }
        return intent != null ? intent : new Intent(this.f12032a).setPackage(this.f12033b);
    }

    public final String d() {
        return this.f12033b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        return e.a(this.f12032a, d0Var.f12032a) && e.a(this.f12033b, d0Var.f12033b) && e.a(this.f12034c, d0Var.f12034c) && this.f12035d == d0Var.f12035d && this.f12036e == d0Var.f12036e;
    }

    public final int hashCode() {
        return e.b(this.f12032a, this.f12033b, this.f12034c, Integer.valueOf(this.f12035d), Boolean.valueOf(this.f12036e));
    }

    public final String toString() {
        String str = this.f12032a;
        if (str != null) {
            return str;
        }
        f.h(this.f12034c);
        return this.f12034c.flattenToString();
    }
}
