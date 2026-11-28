package w5;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f13652a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet f13653b = new HashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public InterfaceC0153a f13654c = null;

    /* JADX INFO: renamed from: w5.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface InterfaceC0153a {
        void a(int i10);

        void b(boolean z10);
    }

    public int a() {
        return this.f13653b.size();
    }

    public int[] b(boolean z10) {
        int size = this.f13653b.size();
        int[] iArr = new int[size];
        Iterator it = this.f13653b.iterator();
        int i10 = 0;
        int i11 = 0;
        while (it.hasNext()) {
            iArr[i11] = ((Integer) it.next()).intValue();
            i11++;
        }
        if (z10) {
            Arrays.sort(iArr);
            for (int i12 = size - 1; i10 < i12; i12--) {
                int i13 = iArr[i10];
                iArr[i10] = iArr[i12];
                iArr[i12] = i13;
                i10++;
            }
        }
        return iArr;
    }

    public boolean c() {
        return this.f13652a;
    }

    public boolean d(int i10) {
        return this.f13653b.contains(Integer.valueOf(i10));
    }

    public void e(int i10, int i11) {
        if (i10 == i11 || this.f13653b.isEmpty()) {
            return;
        }
        int[] iArrB = b(false);
        if (i10 > i11) {
            for (int i12 = 0; i12 < iArrB.length; i12++) {
                int i13 = iArrB[i12];
                if (i13 >= i11 && i13 <= i10) {
                    iArrB[i12] = i13 == i10 ? i11 : i13 + 1;
                }
            }
        } else if (i11 > i10) {
            for (int i14 = 0; i14 < iArrB.length; i14++) {
                int i15 = iArrB[i14];
                if (i15 >= i10 && i15 <= i11) {
                    iArrB[i14] = i15 == i10 ? i11 : i15 - 1;
                }
            }
        }
        this.f13653b.clear();
        for (int i16 : iArrB) {
            this.f13653b.add(Integer.valueOf(i16));
        }
    }

    public void f(int i10, int i11) {
        while (i10 < i11) {
            this.f13653b.add(Integer.valueOf(i10));
            i10++;
        }
        this.f13654c.a(this.f13653b.size());
    }

    public void g(int[] iArr) {
        for (int i10 : iArr) {
            this.f13653b.add(Integer.valueOf(i10));
        }
        this.f13654c.a(this.f13653b.size());
    }

    public boolean h(int i10) {
        return j(i10, !d(i10));
    }

    public void i(InterfaceC0153a interfaceC0153a) {
        this.f13654c = interfaceC0153a;
    }

    public boolean j(int i10, boolean z10) {
        if (d(i10) == z10) {
            return false;
        }
        if (z10) {
            this.f13653b.add(Integer.valueOf(i10));
        } else {
            this.f13653b.remove(Integer.valueOf(i10));
        }
        InterfaceC0153a interfaceC0153a = this.f13654c;
        if (interfaceC0153a == null) {
            return true;
        }
        interfaceC0153a.a(this.f13653b.size());
        return true;
    }

    public void k(boolean z10) {
        if (this.f13652a == z10) {
            return;
        }
        this.f13652a = z10;
        if (!z10) {
            this.f13653b.clear();
        }
        InterfaceC0153a interfaceC0153a = this.f13654c;
        if (interfaceC0153a != null) {
            interfaceC0153a.b(z10);
        }
    }

    public void l(int i10, int i11) {
        while (i10 < i11) {
            this.f13653b.remove(Integer.valueOf(i10));
            i10++;
        }
        this.f13654c.a(this.f13653b.size());
    }

    public void m(int[] iArr) {
        for (int i10 : iArr) {
            this.f13653b.remove(Integer.valueOf(i10));
        }
        this.f13654c.a(this.f13653b.size());
    }

    public void n() {
        if (this.f13653b.isEmpty()) {
            return;
        }
        this.f13653b.clear();
        this.f13654c.a(this.f13653b.size());
    }
}
