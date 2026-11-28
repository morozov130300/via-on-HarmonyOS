package la;

import androidx.lifecycle.a0;
import androidx.lifecycle.b0;
import androidx.lifecycle.z;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class t implements a0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f7601a;

    public t(Map map) {
        this.f7601a = map;
    }

    @Override // androidx.lifecycle.a0.b
    public z a(Class cls) {
        c7.a aVar = (c7.a) this.f7601a.get(cls);
        if (aVar == null) {
            for (Map.Entry entry : this.f7601a.entrySet()) {
                if (cls.isAssignableFrom((Class) entry.getKey())) {
                    aVar = (c7.a) entry.getValue();
                    break;
                }
            }
        }
        if (aVar != null) {
            try {
                return (z) aVar.get();
            } catch (Exception e10) {
                throw new RuntimeException(e10);
            }
        }
        throw new IllegalArgumentException("unknown model class " + cls);
    }

    @Override // androidx.lifecycle.a0.b
    public /* synthetic */ z b(Class cls, i0.a aVar) {
        return b0.b(this, cls, aVar);
    }
}
