package cb;

import java.util.Comparator;
import x8.z1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b implements Comparator {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2364c;

    public b(int i10) {
        this.f2364c = i10;
    }

    public static b c(int i10) {
        return new b(i10);
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(a aVar, a aVar2) {
        int iA;
        int iCompareTo = -1;
        if (aVar.i() != aVar2.i()) {
            return aVar.i() ? -1 : 1;
        }
        if (aVar.h() != aVar2.h()) {
            return aVar.h() ? -1 : 1;
        }
        if (this.f2364c == 2 && (iA = z1.a(aVar.g(), aVar2.g())) != 0) {
            return iA;
        }
        int iCompare = Integer.compare(aVar.f(), aVar2.f());
        if (iCompare == 0) {
            iCompare = Long.compare(aVar.d(), aVar2.d());
        }
        if (iCompare == 0) {
            String strE = aVar.e();
            String strE2 = aVar2.e();
            if (strE != null) {
                iCompareTo = strE2 == null ? 1 : strE.compareTo(strE2);
            } else if (strE2 == null) {
                iCompareTo = 0;
            }
            iCompare = iCompareTo;
        }
        return this.f2364c == 1 ? -iCompare : iCompare;
    }

    public int b() {
        return this.f2364c;
    }

    public boolean d(int i10) {
        if (this.f2364c == i10) {
            return false;
        }
        this.f2364c = i10;
        return true;
    }
}
