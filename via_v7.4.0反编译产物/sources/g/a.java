package g;

import g.b;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a extends b {

    /* renamed from: m, reason: collision with root package name */
    public final HashMap f6095m = new HashMap();

    public boolean contains(Object obj) {
        return this.f6095m.containsKey(obj);
    }

    @Override // g.b
    public b.c f(Object obj) {
        return (b.c) this.f6095m.get(obj);
    }

    @Override // g.b
    public Object n(Object obj, Object obj2) {
        b.c cVarF = f(obj);
        if (cVarF != null) {
            return cVarF.f6101j;
        }
        this.f6095m.put(obj, k(obj, obj2));
        return null;
    }

    @Override // g.b
    public Object o(Object obj) {
        Object objO = super.o(obj);
        this.f6095m.remove(obj);
        return objO;
    }

    public Map.Entry p(Object obj) {
        if (contains(obj)) {
            return ((b.c) this.f6095m.get(obj)).f6103l;
        }
        return null;
    }
}
