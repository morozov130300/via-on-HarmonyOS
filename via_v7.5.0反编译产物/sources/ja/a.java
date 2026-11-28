package ja;

import c6.u1;
import ha.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import x8.s1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6748a = 0;

    @Override // ha.h
    public List a(String str, int i10, int i11) {
        return b(str, i10, i11, this.f6748a);
    }

    public List b(String str, int i10, int i11, int i12) {
        if (i12 == 0 || (i11 & 16) == 0) {
            return null;
        }
        List listD = u1.f2108a.d(i12, str, s1.g(), i10);
        if (listD.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(listD.size());
        Iterator it = listD.iterator();
        while (it.hasNext()) {
            arrayList.add(ha.a.g((String) it.next()));
        }
        return arrayList;
    }

    public void c(int i10) {
        this.f6748a = i10;
    }
}
