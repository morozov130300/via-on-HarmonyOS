package g2;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzcl;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class m6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f5104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f5105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f5106c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f5107d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Boolean f5108e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f5109f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public zzcl f5110g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f5111h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Long f5112i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f5113j;

    public m6(Context context, zzcl zzclVar, Long l10) {
        this.f5111h = true;
        u1.f.h(context);
        Context applicationContext = context.getApplicationContext();
        u1.f.h(applicationContext);
        this.f5104a = applicationContext;
        this.f5112i = l10;
        if (zzclVar != null) {
            this.f5110g = zzclVar;
            this.f5105b = zzclVar.f3227p;
            this.f5106c = zzclVar.f3226o;
            this.f5107d = zzclVar.f3225n;
            this.f5111h = zzclVar.f3224m;
            this.f5109f = zzclVar.f3223e;
            this.f5113j = zzclVar.f3229r;
            Bundle bundle = zzclVar.f3228q;
            if (bundle != null) {
                this.f5108e = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
