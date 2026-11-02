package kotlin.jvm.internal;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class i implements c {

    /* renamed from: e, reason: collision with root package name */
    public final Class f8302e;

    /* renamed from: j, reason: collision with root package name */
    public final String f8303j;

    public i(Class jClass, String moduleName) {
        h.f(jClass, "jClass");
        h.f(moduleName, "moduleName");
        this.f8302e = jClass;
        this.f8303j = moduleName;
    }

    @Override // kotlin.jvm.internal.c
    public Class a() {
        return this.f8302e;
    }

    public boolean equals(Object obj) {
        return (obj instanceof i) && h.a(a(), ((i) obj).a());
    }

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        return a().toString() + " (Kotlin reflection is not available)";
    }
}
