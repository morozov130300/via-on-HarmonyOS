package g2;

import android.content.SharedPreferences;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class h4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f4858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f4859c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f4860d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ l4 f4861e;

    public h4(l4 l4Var, String str, long j10) {
        this.f4861e = l4Var;
        u1.f.d(str);
        this.f4857a = str;
        this.f4858b = j10;
    }

    public final long a() {
        if (!this.f4859c) {
            this.f4859c = true;
            this.f4860d = this.f4861e.o().getLong(this.f4857a, this.f4858b);
        }
        return this.f4860d;
    }

    public final void b(long j10) {
        SharedPreferences.Editor editorEdit = this.f4861e.o().edit();
        editorEdit.putLong(this.f4857a, j10);
        editorEdit.apply();
        this.f4860d = j10;
    }
}
