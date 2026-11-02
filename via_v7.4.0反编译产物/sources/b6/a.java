package b6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public boolean f1821a = false;

    /* renamed from: b, reason: collision with root package name */
    public final HashSet f1822b = new HashSet();

    /* renamed from: c, reason: collision with root package name */
    public InterfaceC0033a f1823c = null;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: b6.a$a, reason: collision with other inner class name */
    public interface InterfaceC0033a {
        void a(int i10);

        void b(boolean z10);
    }

    public int a() {
        return this.f1822b.size();
    }

    public int[] b(boolean z10) {
        int size = this.f1822b.size();
        int[] iArr = new int[size];
        Iterator it = this.f1822b.iterator();
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
        return this.f1821a;
    }

    public boolean d(int i10) {
        return this.f1822b.contains(Integer.valueOf(i10));
    }

    public void e(int i10, int i11) {
        if (i10 == i11 || this.f1822b.isEmpty()) {
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
        this.f1822b.clear();
        for (int i16 : iArrB) {
            this.f1822b.add(Integer.valueOf(i16));
        }
    }

    public void f(int i10, int i11) {
        while (i10 < i11) {
            this.f1822b.add(Integer.valueOf(i10));
            i10++;
        }
        this.f1823c.a(this.f1822b.size());
    }

    public void g(int[] iArr) {
        for (int i10 : iArr) {
            this.f1822b.add(Integer.valueOf(i10));
        }
        this.f1823c.a(this.f1822b.size());
    }

    public boolean h(int i10) {
        return j(i10, !d(i10));
    }

    public void i(InterfaceC0033a interfaceC0033a) {
        this.f1823c = interfaceC0033a;
    }

    public boolean j(int i10, boolean z10) {
        if (d(i10) == z10) {
            return false;
        }
        if (z10) {
            this.f1822b.add(Integer.valueOf(i10));
        } else {
            this.f1822b.remove(Integer.valueOf(i10));
        }
        InterfaceC0033a interfaceC0033a = this.f1823c;
        if (interfaceC0033a == null) {
            return true;
        }
        interfaceC0033a.a(this.f1822b.size());
        return true;
    }

    public void k(boolean z10) {
        if (this.f1821a == z10) {
            return;
        }
        this.f1821a = z10;
        if (!z10) {
            this.f1822b.clear();
        }
        InterfaceC0033a interfaceC0033a = this.f1823c;
        if (interfaceC0033a != null) {
            interfaceC0033a.b(z10);
        }
    }

    public void l(int i10, int i11) {
        while (i10 < i11) {
            this.f1822b.remove(Integer.valueOf(i10));
            i10++;
        }
        this.f1823c.a(this.f1822b.size());
    }

    public void m(int[] iArr) {
        for (int i10 : iArr) {
            this.f1822b.remove(Integer.valueOf(i10));
        }
        this.f1823c.a(this.f1822b.size());
    }

    public void n() {
        if (this.f1822b.isEmpty()) {
            return;
        }
        this.f1822b.clear();
        this.f1823c.a(this.f1822b.size());
    }
}
