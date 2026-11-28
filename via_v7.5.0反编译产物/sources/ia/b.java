package ia;

import ha.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f6333a = new ArrayList();

    @Override // ha.h
    public List a(String str, int i10, int i11) {
        if ((i11 & 32) != 32 || (!(str == null || str.isEmpty()) || i10 <= 0)) {
            return Collections.EMPTY_LIST;
        }
        int iMin = Math.min(i10, this.f6333a.size());
        ArrayList arrayList = new ArrayList();
        for (int i12 = 0; i12 < iMin; i12++) {
            arrayList.add(ha.a.f(null, (String) this.f6333a.get(i12), 32));
        }
        return arrayList;
    }

    public void b(String str) {
        if (str != null) {
            String strTrim = str.trim();
            if (strTrim.isEmpty()) {
                return;
            }
            this.f6333a.remove(strTrim);
            this.f6333a.add(0, strTrim);
        }
    }

    public void c(String str) {
        if (str == null || str.isEmpty()) {
            this.f6333a.clear();
        } else {
            this.f6333a.remove(str);
        }
    }
}
