package t8;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f12565a = new e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f12566b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12567c = 0;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface a {
        String a(long j10, int i10, boolean z10);
    }

    public void a(long j10) {
        int size = this.f12566b.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (j10 >= ((d) this.f12566b.get(i10)).b()) {
                size = i10;
                break;
            }
        }
        if (size >= this.f12566b.size() || j10 > ((d) this.f12566b.get(size)).b() + 86400000) {
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
            String strA = this.f12565a.a(timeInMillis, i12, i12 > i11);
            if (size >= this.f12566b.size()) {
                this.f12566b.add(new d(strA, this.f12567c, timeInMillis));
            } else {
                List list = this.f12566b;
                list.add(size, new d(strA, ((d) list.get(size)).a(), timeInMillis));
            }
        }
        int size2 = this.f12566b.size();
        for (int i13 = size + 1; i13 < size2; i13++) {
            ((d) this.f12566b.get(i13)).d(((d) this.f12566b.get(i13)).a() + 1);
        }
        this.f12567c++;
    }

    public final int b(int i10) {
        if (i10 < 0 || i10 >= this.f12567c || this.f12566b.size() == 0) {
            return -1;
        }
        int size = this.f12566b.size();
        for (int i11 = 1; i11 < size; i11++) {
            if (((d) this.f12566b.get(i11)).a() > i10) {
                return i11 - 1;
            }
        }
        return this.f12566b.size() - 1;
    }

    public w5.b c(int i10) {
        int iB = b(i10);
        if (iB == -1) {
            return new w5.b(-1, "", this.f12567c, i10);
        }
        String strE = e(iB);
        int[] iArrD = d(iB);
        int i11 = iArrD[1];
        int i12 = iArrD[0];
        return new w5.b(iB, strE, i11 - i12, i10 - i12);
    }

    public final int[] d(int i10) {
        if (i10 < 0 || i10 >= this.f12566b.size()) {
            return new int[]{0, 0};
        }
        return new int[]{((d) this.f12566b.get(i10)).a(), i10 >= this.f12566b.size() + (-1) ? this.f12567c : ((d) this.f12566b.get(i10 + 1)).a()};
    }

    public final String e(int i10) {
        if (i10 < 0 || i10 >= this.f12566b.size()) {
            return null;
        }
        return ((d) this.f12566b.get(i10)).c();
    }

    public void f(int i10) {
        if (i10 < 0 || i10 >= this.f12567c || this.f12566b.isEmpty()) {
            return;
        }
        int size = this.f12566b.size();
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            if (i10 >= ((d) this.f12566b.get(i12)).a()) {
                i11 = i12;
            } else {
                ((d) this.f12566b.get(i12)).d(((d) this.f12566b.get(i12)).a() - 1);
            }
        }
        this.f12567c--;
        if (i11 >= this.f12566b.size() - 1) {
            if (((d) this.f12566b.get(i11)).a() < this.f12567c) {
                return;
            }
        } else if (((d) this.f12566b.get(i11)).a() != ((d) this.f12566b.get(i11 + 1)).a()) {
            return;
        }
        this.f12566b.remove(i11);
    }

    public void g(List list, c cVar) {
        this.f12567c = list.size();
        this.f12566b.clear();
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
                a aVar = this.f12565a;
                long j10 = timeInMillis * 1000;
                if (i12 > i10) {
                    z10 = true;
                }
                this.f12566b.add(new d(aVar.a(j10, i12, z10), i11, j10));
            }
            i11++;
            z10 = false;
        }
    }

    public void h(a aVar) {
        if (aVar == null) {
            this.f12565a = new e();
        } else {
            this.f12565a = aVar;
        }
    }
}
