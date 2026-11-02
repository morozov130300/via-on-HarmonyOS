package f2;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzcl;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class m6 {

    /* renamed from: a, reason: collision with root package name */
    public final Context f5488a;

    /* renamed from: b, reason: collision with root package name */
    public String f5489b;

    /* renamed from: c, reason: collision with root package name */
    public String f5490c;

    /* renamed from: d, reason: collision with root package name */
    public String f5491d;

    /* renamed from: e, reason: collision with root package name */
    public Boolean f5492e;

    /* renamed from: f, reason: collision with root package name */
    public long f5493f;

    /* renamed from: g, reason: collision with root package name */
    public zzcl f5494g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f5495h;

    /* renamed from: i, reason: collision with root package name */
    public final Long f5496i;

    /* renamed from: j, reason: collision with root package name */
    public String f5497j;

    public m6(Context context, zzcl zzclVar, Long l10) {
        this.f5495h = true;
        t1.f.h(context);
        Context applicationContext = context.getApplicationContext();
        t1.f.h(applicationContext);
        this.f5488a = applicationContext;
        this.f5496i = l10;
        if (zzclVar != null) {
            this.f5494g = zzclVar;
            this.f5489b = zzclVar.f3928n;
            this.f5490c = zzclVar.f3927m;
            this.f5491d = zzclVar.f3926l;
            this.f5495h = zzclVar.f3925k;
            this.f5493f = zzclVar.f3924j;
            this.f5497j = zzclVar.f3930p;
            Bundle bundle = zzclVar.f3929o;
            if (bundle != null) {
                this.f5492e = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
