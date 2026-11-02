package h3;

import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a extends r {

    /* renamed from: a, reason: collision with root package name */
    public final String f6359a;

    /* renamed from: b, reason: collision with root package name */
    public final List f6360b;

    public a(String str, List list) {
        if (str == null) {
            throw new NullPointerException("Null userAgent");
        }
        this.f6359a = str;
        if (list == null) {
            throw new NullPointerException("Null usedDates");
        }
        this.f6360b = list;
    }

    @Override // h3.r
    public List b() {
        return this.f6360b;
    }

    @Override // h3.r
    public String c() {
        return this.f6359a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof r) {
            r rVar = (r) obj;
            if (this.f6359a.equals(rVar.c()) && this.f6360b.equals(rVar.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f6359a.hashCode() ^ 1000003) * 1000003) ^ this.f6360b.hashCode();
    }

    public String toString() {
        return "HeartBeatResult{userAgent=" + this.f6359a + ", usedDates=" + this.f6360b + "}";
    }
}
