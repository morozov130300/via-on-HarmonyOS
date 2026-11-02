package la;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ka.h;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b implements h {

    /* renamed from: a, reason: collision with root package name */
    public final List f8465a = new ArrayList();

    @Override // ka.h
    public List a(String str, int i10, int i11) {
        if ((i11 & 32) != 32 || (!(str == null || str.isEmpty()) || i10 <= 0)) {
            return Collections.EMPTY_LIST;
        }
        int iMin = Math.min(i10, this.f8465a.size());
        ArrayList arrayList = new ArrayList();
        for (int i12 = 0; i12 < iMin; i12++) {
            arrayList.add(ka.a.f(null, (String) this.f8465a.get(i12), 32));
        }
        return arrayList;
    }

    public void b(String str) {
        if (str != null) {
            String strTrim = str.trim();
            if (strTrim.isEmpty()) {
                return;
            }
            this.f8465a.remove(strTrim);
            this.f8465a.add(0, strTrim);
        }
    }

    public void c(String str) {
        if (str == null || str.isEmpty()) {
            this.f8465a.clear();
        } else {
            this.f8465a.remove(str);
        }
    }
}
