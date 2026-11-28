package e6;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class k implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f4245a;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class a implements j.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map f4246a = new HashMap(3);

        @Override // e6.j.a
        public j.a a(Class cls, s sVar) {
            if (sVar == null) {
                this.f4246a.remove(cls);
                return this;
            }
            this.f4246a.put(cls, sVar);
            return this;
        }

        @Override // e6.j.a
        public j build() {
            return new k(Collections.unmodifiableMap(this.f4246a));
        }
    }

    public k(Map map) {
        this.f4245a = map;
    }

    @Override // e6.j
    public s a(Class cls) {
        return (s) this.f4245a.get(cls);
    }
}
