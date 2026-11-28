package g2;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.zzas;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f5188c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f5189d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f5190e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final zzas f5191f;

    public p(h5 h5Var, String str, String str2, String str3, long j10, long j11, Bundle bundle) {
        zzas zzasVar;
        u1.f.d(str2);
        u1.f.d(str3);
        this.f5186a = str2;
        this.f5187b = str3;
        this.f5188c = true == TextUtils.isEmpty(str) ? null : str;
        this.f5189d = j10;
        this.f5190e = j11;
        if (j11 != 0 && j11 > j10) {
            h5Var.d().w().b("Event created with reverse previous/current timestamps. appId", v3.z(str2));
        }
        if (bundle == null || bundle.isEmpty()) {
            zzasVar = new zzas(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    h5Var.d().r().a("Param name can't be null");
                    it.remove();
                } else {
                    Object objO = h5Var.N().o(next, bundle2.get(next));
                    if (objO == null) {
                        h5Var.d().w().b("Param value can't be null", h5Var.D().e(next));
                        it.remove();
                    } else {
                        h5Var.N().D(bundle2, next, objO);
                    }
                }
            }
            zzasVar = new zzas(bundle2);
        }
        this.f5191f = zzasVar;
    }

    public final p a(h5 h5Var, long j10) {
        return new p(h5Var, this.f5188c, this.f5186a, this.f5187b, this.f5189d, j10, this.f5191f);
    }

    public final String toString() {
        return "Event{appId='" + this.f5186a + "', name='" + this.f5187b + "', params=" + this.f5191f.toString() + "}";
    }

    public p(h5 h5Var, String str, String str2, String str3, long j10, long j11, zzas zzasVar) {
        u1.f.d(str2);
        u1.f.d(str3);
        u1.f.h(zzasVar);
        this.f5186a = str2;
        this.f5187b = str3;
        this.f5188c = true == TextUtils.isEmpty(str) ? null : str;
        this.f5189d = j10;
        this.f5190e = j11;
        if (j11 != 0 && j11 > j10) {
            h5Var.d().w().c("Event created with reverse previous/current timestamps. appId, name", v3.z(str2), v3.z(str3));
        }
        this.f5191f = zzasVar;
    }
}
