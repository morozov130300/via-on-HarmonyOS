package p5;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f11581a = new Bundle();

    public static a b() {
        return new a();
    }

    public Bundle a() {
        return this.f11581a;
    }

    public a c(String str, boolean z10) {
        this.f11581a.putBoolean(str, z10);
        return this;
    }

    public a d(String str, int i10) {
        this.f11581a.putInt(str, i10);
        return this;
    }

    public a e(String str, String str2) {
        this.f11581a.putString(str, str2);
        return this;
    }
}
