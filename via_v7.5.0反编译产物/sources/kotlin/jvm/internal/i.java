package kotlin.jvm.internal;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class i implements c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Class f7316c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f7317e;

    public i(Class jClass, String moduleName) {
        h.f(jClass, "jClass");
        h.f(moduleName, "moduleName");
        this.f7316c = jClass;
        this.f7317e = moduleName;
    }

    @Override // kotlin.jvm.internal.c
    public Class a() {
        return this.f7316c;
    }

    public boolean equals(Object obj) {
        return (obj instanceof i) && h.a(a(), ((i) obj).a());
    }

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        return a() + " (Kotlin reflection is not available)";
    }
}
