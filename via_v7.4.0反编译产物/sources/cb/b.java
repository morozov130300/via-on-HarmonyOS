package cb;

import java.util.Comparator;
import z8.a2;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b implements Comparator {

    /* renamed from: e, reason: collision with root package name */
    public int f3069e;

    public b(int i10) {
        this.f3069e = i10;
    }

    public static b c(int i10) {
        return new b(i10);
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(a aVar, a aVar2) {
        if (aVar.h() != aVar2.h()) {
            return aVar.h() ? -1 : 1;
        }
        if (aVar.g() != aVar2.g()) {
            return aVar.g() ? -1 : 1;
        }
        int i10 = this.f3069e;
        return i10 != 1 ? i10 != 2 ? aVar.e() - aVar2.e() : a2.a(aVar.f(), aVar2.f()) : aVar2.e() - aVar.e();
    }

    public int b() {
        return this.f3069e;
    }

    public boolean d(int i10) {
        if (this.f3069e == i10) {
            return false;
        }
        this.f3069e = i10;
        return true;
    }
}
