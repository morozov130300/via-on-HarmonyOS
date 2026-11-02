package f2;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzas;
import com.google.android.gms.measurement.internal.zzau;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class w3 {

    /* renamed from: a, reason: collision with root package name */
    public final String f5782a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5783b;

    /* renamed from: c, reason: collision with root package name */
    public final long f5784c;

    /* renamed from: d, reason: collision with root package name */
    public final Bundle f5785d;

    public w3(String str, String str2, Bundle bundle, long j10) {
        this.f5782a = str;
        this.f5783b = str2;
        this.f5785d = bundle;
        this.f5784c = j10;
    }

    public static w3 b(zzau zzauVar) {
        return new w3(zzauVar.f3964e, zzauVar.f3966k, zzauVar.f3965j.g(), zzauVar.f3967l);
    }

    public final zzau a() {
        return new zzau(this.f5782a, new zzas(new Bundle(this.f5785d)), this.f5783b, this.f5784c);
    }

    public final String toString() {
        return "origin=" + this.f5783b + ",name=" + this.f5782a + ",params=" + this.f5785d.toString();
    }
}
