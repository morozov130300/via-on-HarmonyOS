package mark.via.settings.search;

import android.os.Bundle;
import java.util.LinkedHashSet;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a[] f10378c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String[] f10379d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Class f10380e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Bundle f10381f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f10382g;

    public b(String str, String str2, String[] strArr, Class cls, Bundle bundle, int i10, String... strArr2) {
        this.f10376a = str;
        this.f10377b = str2;
        this.f10379d = (String[]) strArr.clone();
        this.f10380e = cls;
        this.f10381f = bundle == null ? null : new Bundle(bundle);
        this.f10382g = i10;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        a.a(linkedHashSet, str2, true);
        if (strArr2 != null) {
            for (String str3 : strArr2) {
                a.a(linkedHashSet, str3, false);
            }
        }
        this.f10378c = (a[]) linkedHashSet.toArray(new a[0]);
    }

    public static String h(String str) {
        return str == null ? "" : str.trim().toLowerCase(Locale.ROOT);
    }

    public Bundle a() {
        return this.f10381f == null ? new Bundle() : new Bundle(this.f10381f);
    }

    public String b() {
        return this.f10376a;
    }

    public String[] c() {
        return (String[]) this.f10379d.clone();
    }

    public Class d() {
        return this.f10380e;
    }

    public int e() {
        return this.f10382g;
    }

    public String f() {
        return this.f10377b;
    }

    public boolean g(String str) {
        for (a aVar : this.f10378c) {
            if (aVar.c(str)) {
                return true;
            }
        }
        return false;
    }
}
