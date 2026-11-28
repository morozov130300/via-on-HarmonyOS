package r4;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f11974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Bundle f11975c;

    public b(Bundle bundle) {
        this.f11975c = bundle;
        this.f11973a = bundle.getString("URL", null);
        this.f11974b = bundle.getString("TITLE", null);
    }

    public Bundle a() {
        return this.f11975c;
    }

    public String b() {
        return this.f11974b;
    }

    @Override // r4.g
    public String getUrl() {
        return this.f11973a;
    }

    public b(String str) {
        Bundle bundle = new Bundle();
        this.f11975c = bundle;
        bundle.putString("URL", str);
        this.f11973a = str;
        this.f11974b = null;
    }
}
