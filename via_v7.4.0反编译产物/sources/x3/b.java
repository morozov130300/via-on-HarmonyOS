package x3;

import java.util.Objects;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final w3.b f13586a;

    /* renamed from: b, reason: collision with root package name */
    public final w3.b f13587b;

    /* renamed from: c, reason: collision with root package name */
    public final w3.c f13588c;

    public b(w3.b bVar, w3.b bVar2, w3.c cVar) {
        this.f13586a = bVar;
        this.f13587b = bVar2;
        this.f13588c = cVar;
    }

    public w3.c a() {
        return this.f13588c;
    }

    public w3.b b() {
        return this.f13586a;
    }

    public w3.b c() {
        return this.f13587b;
    }

    public boolean d() {
        return this.f13587b == null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Objects.equals(this.f13586a, bVar.f13586a) && Objects.equals(this.f13587b, bVar.f13587b) && Objects.equals(this.f13588c, bVar.f13588c);
    }

    public int hashCode() {
        return (Objects.hashCode(this.f13586a) ^ Objects.hashCode(this.f13587b)) ^ Objects.hashCode(this.f13588c);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[ ");
        sb2.append(this.f13586a);
        sb2.append(" , ");
        sb2.append(this.f13587b);
        sb2.append(" : ");
        w3.c cVar = this.f13588c;
        sb2.append(cVar == null ? "null" : Integer.valueOf(cVar.c()));
        sb2.append(" ]");
        return sb2.toString();
    }
}
