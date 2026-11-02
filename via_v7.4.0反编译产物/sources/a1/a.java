package a1;

import com.google.android.datatransport.Priority;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a extends c {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f45a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f46b;

    /* renamed from: c, reason: collision with root package name */
    public final Priority f47c;

    public a(Integer num, Object obj, Priority priority) {
        this.f45a = num;
        if (obj == null) {
            throw new NullPointerException("Null payload");
        }
        this.f46b = obj;
        if (priority == null) {
            throw new NullPointerException("Null priority");
        }
        this.f47c = priority;
    }

    @Override // a1.c
    public Integer a() {
        return this.f45a;
    }

    @Override // a1.c
    public Object b() {
        return this.f46b;
    }

    @Override // a1.c
    public Priority c() {
        return this.f47c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            Integer num = this.f45a;
            if (num != null ? num.equals(cVar.a()) : cVar.a() == null) {
                if (this.f46b.equals(cVar.b()) && this.f47c.equals(cVar.c())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.f45a;
        return (((((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003) ^ this.f46b.hashCode()) * 1000003) ^ this.f47c.hashCode();
    }

    public String toString() {
        return "Event{code=" + this.f45a + ", payload=" + this.f46b + ", priority=" + this.f47c + "}";
    }
}
