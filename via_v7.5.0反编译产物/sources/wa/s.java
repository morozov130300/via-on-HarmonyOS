package wa;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class s implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f14409a;

    public s(Context context) {
        this.f14409a = context;
    }

    @Override // wa.b
    public void a(String str) {
        com.tuyafeng.support.utils.n.s(this.f14409a, str);
    }

    @Override // wa.b
    public void onCancel() {
    }
}
