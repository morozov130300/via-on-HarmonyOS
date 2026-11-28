package g;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a extends b {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final HashMap f4608o = new HashMap();

    public boolean contains(Object obj) {
        return this.f4608o.containsKey(obj);
    }

    @Override // g.b
    public b.c f(Object obj) {
        return (b.c) this.f4608o.get(obj);
    }

    @Override // g.b
    public Object n(Object obj, Object obj2) {
        b.c cVarF = f(obj);
        if (cVarF != null) {
            return cVarF.f4614e;
        }
        this.f4608o.put(obj, k(obj, obj2));
        return null;
    }

    @Override // g.b
    public Object o(Object obj) {
        Object objO = super.o(obj);
        this.f4608o.remove(obj);
        return objO;
    }

    public Map.Entry p(Object obj) {
        if (contains(obj)) {
            return ((b.c) this.f4608o.get(obj)).f4616n;
        }
        return null;
    }
}
