package l2;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class e implements f2.a.InterfaceC0066a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f7468a;

    public e(f fVar) {
        this.f7468a = fVar;
    }

    @Override // g2.k6
    public final void a(String str, String str2, Bundle bundle, long j10) {
        if (str == null || !b.c(str2)) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str2);
        bundle2.putLong("timestampInMillis", j10);
        bundle2.putBundle("params", bundle);
        this.f7468a.f7469a.a(3, bundle2);
    }
}
