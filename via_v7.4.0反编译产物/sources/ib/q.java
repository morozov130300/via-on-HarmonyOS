package ib;

import java.util.Comparator;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class q implements Comparator {

    /* renamed from: e, reason: collision with root package name */
    public int[] f7157e;

    public q() {
        this(null);
    }

    public q(String str) {
        this.f7157e = null;
        b(str);
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(ja.c cVar, ja.c cVar2) {
        int[] iArr = this.f7157e;
        if (iArr != null && iArr.length != 0) {
            int iC = g6.a.c(iArr, cVar.d());
            int iC2 = g6.a.c(this.f7157e, cVar2.d());
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
        this.f7157e = g6.p.p(str, ',');
    }
}
