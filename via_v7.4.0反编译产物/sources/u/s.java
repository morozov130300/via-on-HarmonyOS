package u;

import android.os.LocaleList;
import java.util.Locale;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class s implements m {

    /* renamed from: a, reason: collision with root package name */
    public final LocaleList f12439a;

    public s(Object obj) {
        this.f12439a = r.a(obj);
    }

    @Override // u.m
    public Object a() {
        return this.f12439a;
    }

    public boolean equals(Object obj) {
        return this.f12439a.equals(((m) obj).a());
    }

    @Override // u.m
    public Locale get(int i10) {
        return this.f12439a.get(i10);
    }

    public int hashCode() {
        return this.f12439a.hashCode();
    }

    public String toString() {
        return this.f12439a.toString();
    }
}
