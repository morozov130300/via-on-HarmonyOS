package g2;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzas;
import com.google.android.gms.measurement.internal.zzau;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class w3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f5400c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Bundle f5401d;

    public w3(String str, String str2, Bundle bundle, long j10) {
        this.f5398a = str;
        this.f5399b = str2;
        this.f5401d = bundle;
        this.f5400c = j10;
    }

    public static w3 b(zzau zzauVar) {
        return new w3(zzauVar.f3263c, zzauVar.f3265m, zzauVar.f3264e.g(), zzauVar.f3266n);
    }

    public final zzau a() {
        return new zzau(this.f5398a, new zzas(new Bundle(this.f5401d)), this.f5399b, this.f5400c);
    }

    public final String toString() {
        return "origin=" + this.f5399b + ",name=" + this.f5398a + ",params=" + this.f5401d.toString();
    }
}
