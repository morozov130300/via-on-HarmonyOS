package g2;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class x4 implements com.google.android.gms.internal.measurement.fb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f5424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ y4 f5425b;

    public x4(y4 y4Var, String str) {
        this.f5425b = y4Var;
        this.f5424a = str;
    }

    @Override // com.google.android.gms.internal.measurement.fb
    public final String b(String str) {
        Map map = (Map) this.f5425b.f5447d.get(this.f5424a);
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return (String) map.get(str);
    }
}
