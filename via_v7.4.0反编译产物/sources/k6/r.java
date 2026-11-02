package k6;

import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class r implements q {

    /* renamed from: a, reason: collision with root package name */
    public final Map f8176a = new HashMap(3);

    @Override // k6.q
    public Object a(o oVar) {
        return this.f8176a.get(oVar);
    }

    @Override // k6.q
    public void b(o oVar, Object obj) {
        if (obj == null) {
            this.f8176a.remove(oVar);
        } else {
            this.f8176a.put(oVar, obj);
        }
    }
}
