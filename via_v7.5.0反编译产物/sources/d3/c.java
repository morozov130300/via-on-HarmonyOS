package d3;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f3900b;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f3901a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map f3902b = null;

        public b(String str) {
            this.f3901a = str;
        }

        public c a() {
            return new c(this.f3901a, this.f3902b == null ? Collections.EMPTY_MAP : Collections.unmodifiableMap(new HashMap(this.f3902b)));
        }

        public b b(Annotation annotation) {
            if (this.f3902b == null) {
                this.f3902b = new HashMap();
            }
            this.f3902b.put(annotation.annotationType(), annotation);
            return this;
        }
    }

    public static b a(String str) {
        return new b(str);
    }

    public static c d(String str) {
        return new c(str, Collections.EMPTY_MAP);
    }

    public String b() {
        return this.f3899a;
    }

    public Annotation c(Class cls) {
        return (Annotation) this.f3900b.get(cls);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f3899a.equals(cVar.f3899a) && this.f3900b.equals(cVar.f3900b);
    }

    public int hashCode() {
        return (this.f3899a.hashCode() * 31) + this.f3900b.hashCode();
    }

    public String toString() {
        return "FieldDescriptor{name=" + this.f3899a + ", properties=" + this.f3900b.values() + "}";
    }

    public c(String str, Map map) {
        this.f3899a = str;
        this.f3900b = map;
    }
}
