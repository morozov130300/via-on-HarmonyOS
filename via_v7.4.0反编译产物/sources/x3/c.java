package x3;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final List f13589a;

    /* renamed from: b, reason: collision with root package name */
    public final int f13590b;

    public c(List list, int i10) {
        this.f13589a = new ArrayList(list);
        this.f13590b = i10;
    }

    public List a() {
        return this.f13589a;
    }

    public int b() {
        return this.f13590b;
    }

    public boolean c(List list) {
        return this.f13589a.equals(list);
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            return this.f13589a.equals(((c) obj).f13589a);
        }
        return false;
    }

    public int hashCode() {
        return this.f13589a.hashCode();
    }

    public String toString() {
        return "{ " + this.f13589a + " }";
    }
}
