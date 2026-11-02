package x3;

import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class a {
    public static s3.a a(List list) {
        int size = list.size() * 2;
        int i10 = size - 1;
        if (((b) list.get(list.size() - 1)).c() == null) {
            i10 = size - 2;
        }
        s3.a aVar = new s3.a(i10 * 12);
        int i11 = 0;
        int iB = ((b) list.get(0)).c().b();
        for (int i12 = 11; i12 >= 0; i12--) {
            if (((1 << i12) & iB) != 0) {
                aVar.s(i11);
            }
            i11++;
        }
        for (int i13 = 1; i13 < list.size(); i13++) {
            b bVar = (b) list.get(i13);
            int iB2 = bVar.b().b();
            for (int i14 = 11; i14 >= 0; i14--) {
                if (((1 << i14) & iB2) != 0) {
                    aVar.s(i11);
                }
                i11++;
            }
            if (bVar.c() != null) {
                int iB3 = bVar.c().b();
                for (int i15 = 11; i15 >= 0; i15--) {
                    if (((1 << i15) & iB3) != 0) {
                        aVar.s(i11);
                    }
                    i11++;
                }
            }
        }
        return aVar;
    }
}
