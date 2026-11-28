package e6;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class r implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f4260a = new HashMap(3);

    @Override // e6.q
    public void a(o oVar, Object obj) {
        if (obj == null) {
            this.f4260a.remove(oVar);
        } else {
            this.f4260a.put(oVar, obj);
        }
    }

    @Override // e6.q
    public Object b(o oVar) {
        return this.f4260a.get(oVar);
    }
}
