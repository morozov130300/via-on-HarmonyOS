package ib;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class q implements Comparator {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f6389c;

    public q() {
        this(null);
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(ga.c cVar, ga.c cVar2) {
        int[] iArr = this.f6389c;
        if (iArr != null && iArr.length != 0) {
            int iC = com.tuyafeng.support.utils.a.c(iArr, cVar.d());
            int iC2 = com.tuyafeng.support.utils.a.c(this.f6389c, cVar2.d());
            if (iC2 >= 0 && iC >= 0) {
                if (iC < iC2) {
                    return -1;
                }
                return iC == iC2 ? 0 : 1;
            }
            if (iC >= 0) {
                return -1;
            }
            if (iC2 >= 0) {
                return 1;
            }
        }
        return 0;
    }

    public void b(String str) {
        this.f6389c = com.tuyafeng.support.utils.p.p(str, ',');
    }

    public q(String str) {
        this.f6389c = null;
        b(str);
    }
}
