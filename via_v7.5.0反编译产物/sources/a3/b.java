package a3;

import org.json.JSONObject;
import t2.r;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b implements f {
    public static d b(r rVar) {
        return new d(rVar.a() + ((long) 3600000), new d.b(8, 4), new d.a(true, false, false), 0, 3600, 10.0d, 1.2d, 60);
    }

    @Override // a3.f
    public d a(r rVar, JSONObject jSONObject) {
        return b(rVar);
    }
}
