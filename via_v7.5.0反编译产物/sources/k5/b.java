package k5;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7206a;

    public b(Context context) {
        this.f7206a = context.getApplicationContext();
    }

    @Override // k5.p
    public boolean a() {
        return t.a(this.f7206a) != 0;
    }
}
