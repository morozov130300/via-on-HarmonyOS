package pa;

import androidx.lifecycle.x;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class s implements y.b {

    /* renamed from: a, reason: collision with root package name */
    public final Map f11150a;

    public s(Map map) {
        this.f11150a = map;
    }

    @Override // androidx.lifecycle.y.b
    public x a(Class cls) {
        i7.a aVar = (i7.a) this.f11150a.get(cls);
        if (aVar == null) {
            Iterator it = this.f11150a.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                if (cls.isAssignableFrom((Class) entry.getKey())) {
                    aVar = (i7.a) entry.getValue();
                    break;
                }
            }
        }
        if (aVar != null) {
            try {
                return (x) aVar.get();
            } catch (Exception e10) {
                throw new RuntimeException(e10);
            }
        }
        throw new IllegalArgumentException("unknown model class " + cls);
    }

    @Override // androidx.lifecycle.y.b
    public /* synthetic */ x b(Class cls, h0.a aVar) {
        return z.b(this, cls, aVar);
    }
}
