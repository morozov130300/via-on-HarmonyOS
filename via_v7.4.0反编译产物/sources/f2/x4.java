package f2;

import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class x4 implements com.google.android.gms.internal.measurement.fb {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f5808a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ y4 f5809b;

    public x4(y4 y4Var, String str) {
        this.f5809b = y4Var;
        this.f5808a = str;
    }

    @Override // com.google.android.gms.internal.measurement.fb
    public final String b(String str) {
        Map map = (Map) this.f5809b.f5831d.get(this.f5808a);
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return (String) map.get(str);
    }
}
