package v5;

import android.os.Bundle;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f13034a = new Bundle();

    public static a b() {
        return new a();
    }

    public Bundle a() {
        return this.f13034a;
    }

    public a c(String str, boolean z10) {
        this.f13034a.putBoolean(str, z10);
        return this;
    }

    public a d(String str, int i10) {
        this.f13034a.putInt(str, i10);
        return this;
    }

    public a e(String str, String str2) {
        this.f13034a.putString(str, str2);
        return this;
    }
}
