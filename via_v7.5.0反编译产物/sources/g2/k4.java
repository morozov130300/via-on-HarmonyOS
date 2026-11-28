package g2;

import android.content.SharedPreferences;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class k4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f5028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f5029c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ l4 f5030d;

    public k4(l4 l4Var, String str, String str2) {
        this.f5030d = l4Var;
        u1.f.d(str);
        this.f5027a = str;
    }

    public final String a() {
        if (!this.f5028b) {
            this.f5028b = true;
            this.f5029c = this.f5030d.o().getString(this.f5027a, null);
        }
        return this.f5029c;
    }

    public final void b(String str) {
        SharedPreferences.Editor editorEdit = this.f5030d.o().edit();
        editorEdit.putString(this.f5027a, str);
        editorEdit.apply();
        this.f5029c = str;
    }
}
