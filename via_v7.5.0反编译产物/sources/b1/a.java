package b1;

import com.google.android.datatransport.Priority;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f1712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f1713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Priority f1714c;

    public a(Integer num, Object obj, Priority priority) {
        this.f1712a = num;
        if (obj == null) {
            throw new NullPointerException("Null payload");
        }
        this.f1713b = obj;
        if (priority == null) {
            throw new NullPointerException("Null priority");
        }
        this.f1714c = priority;
    }

    @Override // b1.c
    public Integer a() {
        return this.f1712a;
    }

    @Override // b1.c
    public Object b() {
        return this.f1713b;
    }

    @Override // b1.c
    public Priority c() {
        return this.f1714c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            Integer num = this.f1712a;
            if (num != null ? num.equals(cVar.a()) : cVar.a() == null) {
                if (this.f1713b.equals(cVar.b()) && this.f1714c.equals(cVar.c())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.f1712a;
        return (((((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003) ^ this.f1713b.hashCode()) * 1000003) ^ this.f1714c.hashCode();
    }

    public String toString() {
        return "Event{code=" + this.f1712a + ", payload=" + this.f1713b + ", priority=" + this.f1714c + "}";
    }
}
