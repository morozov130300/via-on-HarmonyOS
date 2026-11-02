package v8;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public a f13054a = new e();

    /* renamed from: b, reason: collision with root package name */
    public final List f13055b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public int f13056c = 0;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface a {
        String a(long j10, int i10, boolean z10);
    }

    public void a(long j10) {
        int size = this.f13055b.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                break;
            }
            if (j10 >= ((d) this.f13055b.get(i10)).b()) {
                size = i10;
                break;
            }
            i10++;
        }
        if (size >= this.f13055b.size() || j10 > ((d) this.f13055b.get(size)).b() + 86400000) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            int i11 = -calendar.get(6);
            calendar.add(5, 1);
            long timeInMillis = calendar.getTimeInMillis();
            int i12 = 1;
            while (timeInMillis > j10) {
                timeInMillis -= 86400000;
                i12--;
            }
            String strA = this.f13054a.a(timeInMillis, i12, i12 > i11);
            if (size >= this.f13055b.size()) {
                this.f13055b.add(new d(strA, this.f13056c, timeInMillis));
            } else {
                List list = this.f13055b;
                list.add(size, new d(strA, ((d) list.get(size)).a(), timeInMillis));
            }
        }
        int size2 = this.f13055b.size();
        for (int i13 = size + 1; i13 < size2; i13++) {
            ((d) this.f13055b.get(i13)).d(((d) this.f13055b.get(i13)).a() + 1);
        }
        this.f13056c++;
    }

    public final int b(int i10) {
        if (i10 < 0 || i10 >= this.f13056c || this.f13055b.size() == 0) {
            return -1;
        }
        int size = this.f13055b.size();
        for (int i11 = 1; i11 < size; i11++) {
            if (((d) this.f13055b.get(i11)).a() > i10) {
                return i11 - 1;
            }
        }
        return this.f13055b.size() - 1;
    }

    public b6.b c(int i10) {
        int iB = b(i10);
        if (iB == -1) {
            return new b6.b(-1, "", this.f13056c, i10);
        }
        String strE = e(iB);
        int[] iArrD = d(iB);
        int i11 = iArrD[1];
        int i12 = iArrD[0];
        return new b6.b(iB, strE, i11 - i12, i10 - i12);
    }

    public final int[] d(int i10) {
        if (i10 < 0 || i10 >= this.f13055b.size()) {
            return new int[]{0, 0};
        }
        return new int[]{((d) this.f13055b.get(i10)).a(), i10 >= this.f13055b.size() + (-1) ? this.f13056c : ((d) this.f13055b.get(i10 + 1)).a()};
    }

    public final String e(int i10) {
        if (i10 < 0 || i10 >= this.f13055b.size()) {
            return null;
        }
        return ((d) this.f13055b.get(i10)).c();
    }

    public void f(int i10) {
        if (i10 < 0 || i10 >= this.f13056c || this.f13055b.isEmpty()) {
            return;
        }
        int size = this.f13055b.size();
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            if (i10 >= ((d) this.f13055b.get(i12)).a()) {
                i11 = i12;
            } else {
                ((d) this.f13055b.get(i12)).d(((d) this.f13055b.get(i12)).a() - 1);
            }
        }
        this.f13056c--;
        if (i11 >= this.f13055b.size() - 1) {
            if (((d) this.f13055b.get(i11)).a() < this.f13056c) {
                return;
            }
        } else if (((d) this.f13055b.get(i11)).a() != ((d) this.f13055b.get(i11 + 1)).a()) {
            return;
        }
        this.f13055b.remove(i11);
    }

    public void g(List list, c cVar) {
        this.f13056c = list.size();
        this.f13055b.clear();
        Calendar calendar = Calendar.getInstance();
        boolean z10 = false;
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        int i10 = -calendar.get(6);
        calendar.add(5, 1);
        long timeInMillis = calendar.getTimeInMillis() / 1000;
        int size = list.size();
        int i11 = 0;
        int i12 = 1;
        while (i11 < size) {
            long jA = cVar.a(list.get(i11)) / 1000;
            if (jA < timeInMillis) {
                while (timeInMillis > jA) {
                    timeInMillis -= 86400;
                    i12--;
                }
                a aVar = this.f13054a;
                long j10 = timeInMillis * 1000;
                if (i12 > i10) {
                    z10 = true;
                }
                this.f13055b.add(new d(aVar.a(j10, i12, z10), i11, j10));
            }
            i11++;
            z10 = false;
        }
    }

    public void h(a aVar) {
        if (aVar == null) {
            this.f13054a = new e();
        } else {
            this.f13054a = aVar;
        }
    }
}
