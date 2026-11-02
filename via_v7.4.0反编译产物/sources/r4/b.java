package r4;

import android.os.Bundle;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b implements g {

    /* renamed from: a, reason: collision with root package name */
    public final String f11521a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11522b;

    /* renamed from: c, reason: collision with root package name */
    public final Bundle f11523c;

    public b(Bundle bundle) {
        this.f11523c = bundle;
        this.f11521a = bundle.getString("URL", null);
        this.f11522b = bundle.getString("TITLE", null);
    }

    public b(String str) {
        Bundle bundle = new Bundle();
        this.f11523c = bundle;
        bundle.putString("URL", str);
        this.f11521a = str;
        this.f11522b = null;
    }

    public Bundle a() {
        return this.f11523c;
    }

    public String b() {
        return this.f11522b;
    }

    @Override // r4.g
    public String getUrl() {
        return this.f11521a;
    }
}
