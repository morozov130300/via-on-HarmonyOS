package y5;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class c implements k {

    /* renamed from: a, reason: collision with root package name */
    public final List f14463a = new ArrayList();

    @Override // y5.k
    public boolean a(Class cls) {
        int i10 = 0;
        for (int size = this.f14463a.size() - 1; size >= 0; size--) {
            if (((j) this.f14463a.get(size)).a() == cls) {
                i10++;
                this.f14463a.remove(size);
            }
        }
        return i10 > 0;
    }

    @Override // y5.k
    public int b(Class cls) {
        int size = this.f14463a.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (((j) this.f14463a.get(i10)).a() == cls) {
                return i10;
            }
        }
        int size2 = this.f14463a.size();
        for (int i11 = 0; i11 < size2; i11++) {
            if (((j) this.f14463a.get(i11)).a().isAssignableFrom(cls)) {
                return i11;
            }
        }
        return -1;
    }

    @Override // y5.k
    public void c(j jVar) {
        this.f14463a.add(jVar);
    }

    @Override // y5.k
    public j getType(int i10) {
        return (j) this.f14463a.get(i10);
    }
}
