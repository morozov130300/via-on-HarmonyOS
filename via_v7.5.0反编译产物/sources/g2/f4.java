package g2;

import android.content.SharedPreferences;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class f4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f4789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f4790c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f4791d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ l4 f4792e;

    public f4(l4 l4Var, String str, boolean z10) {
        this.f4792e = l4Var;
        u1.f.d(str);
        this.f4788a = str;
        this.f4789b = z10;
    }

    public final void a(boolean z10) {
        SharedPreferences.Editor editorEdit = this.f4792e.o().edit();
        editorEdit.putBoolean(this.f4788a, z10);
        editorEdit.apply();
        this.f4791d = z10;
    }

    public final boolean b() {
        if (!this.f4790c) {
            this.f4790c = true;
            this.f4791d = this.f4792e.o().getBoolean(this.f4788a, this.f4789b);
        }
        return this.f4791d;
    }
}
