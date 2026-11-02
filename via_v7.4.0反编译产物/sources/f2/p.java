package f2;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.zzas;
import java.util.Iterator;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final String f5570a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5571b;

    /* renamed from: c, reason: collision with root package name */
    public final String f5572c;

    /* renamed from: d, reason: collision with root package name */
    public final long f5573d;

    /* renamed from: e, reason: collision with root package name */
    public final long f5574e;

    /* renamed from: f, reason: collision with root package name */
    public final zzas f5575f;

    public p(h5 h5Var, String str, String str2, String str3, long j10, long j11, Bundle bundle) {
        zzas zzasVar;
        t1.f.d(str2);
        t1.f.d(str3);
        this.f5570a = str2;
        this.f5571b = str3;
        this.f5572c = true == TextUtils.isEmpty(str) ? null : str;
        this.f5573d = j10;
        this.f5574e = j11;
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
        this.f5575f = zzasVar;
    }

    public p(h5 h5Var, String str, String str2, String str3, long j10, long j11, zzas zzasVar) {
        t1.f.d(str2);
        t1.f.d(str3);
        t1.f.h(zzasVar);
        this.f5570a = str2;
        this.f5571b = str3;
        this.f5572c = true == TextUtils.isEmpty(str) ? null : str;
        this.f5573d = j10;
        this.f5574e = j11;
        if (j11 != 0 && j11 > j10) {
            h5Var.d().w().c("Event created with reverse previous/current timestamps. appId, name", v3.z(str2), v3.z(str3));
        }
        this.f5575f = zzasVar;
    }

    public final p a(h5 h5Var, long j10) {
        return new p(h5Var, this.f5572c, this.f5570a, this.f5571b, this.f5573d, j10, this.f5575f);
    }

    public final String toString() {
        return "Event{appId='" + this.f5570a + "', name='" + this.f5571b + "', params=" + this.f5575f.toString() + "}";
    }
}
