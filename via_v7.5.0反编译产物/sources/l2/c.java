package l2;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzjb;
import g2.g6;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class c implements f2.a.InterfaceC0066a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f7463a;

    public c(d dVar) {
        this.f7463a = dVar;
    }

    @Override // g2.k6
    public final void a(String str, String str2, Bundle bundle, long j10) {
        if (this.f7463a.f7464a.contains(str2)) {
            Bundle bundle2 = new Bundle();
            zzjb zzjbVar = b.f7457a;
            String strA = g6.a(str2);
            if (strA != null) {
                str2 = strA;
            }
            bundle2.putString("events", str2);
            this.f7463a.f7465b.a(2, bundle2);
        }
    }
}
