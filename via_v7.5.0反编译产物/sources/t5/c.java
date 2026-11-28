package t5;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class c implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f12555a = new ArrayList();

    @Override // t5.k
    public boolean a(Class cls) {
        int i10 = 0;
        for (int size = this.f12555a.size() - 1; size >= 0; size--) {
            if (((j) this.f12555a.get(size)).a() == cls) {
                i10++;
                this.f12555a.remove(size);
            }
        }
        return i10 > 0;
    }

    @Override // t5.k
    public int b(Class cls) {
        int size = this.f12555a.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (((j) this.f12555a.get(i10)).a() == cls) {
                return i10;
            }
        }
        int size2 = this.f12555a.size();
        for (int i11 = 0; i11 < size2; i11++) {
            if (((j) this.f12555a.get(i11)).a().isAssignableFrom(cls)) {
                return i11;
            }
        }
        return -1;
    }

    @Override // t5.k
    public void c(j jVar) {
        this.f12555a.add(jVar);
    }

    @Override // t5.k
    public j getType(int i10) {
        return (j) this.f12555a.get(i10);
    }
}
