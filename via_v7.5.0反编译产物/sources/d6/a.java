package d6;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f3917a;

    /* JADX INFO: renamed from: d6.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static abstract class AbstractC0057a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LinkedHashMap f3918a;

        public AbstractC0057a(int i10) {
            this.f3918a = b.b(i10);
        }

        public AbstractC0057a a(Object obj, c7.a aVar) {
            this.f3918a.put(g.b(obj, "key"), g.b(aVar, "provider"));
            return this;
        }
    }

    public a(Map map) {
        this.f3917a = Collections.unmodifiableMap(map);
    }

    public final Map a() {
        return this.f3917a;
    }
}
