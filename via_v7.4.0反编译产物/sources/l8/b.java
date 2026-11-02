package l8;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class b {
    public static List a(Bundle bundle) {
        if (bundle == null || !bundle.containsKey("urls")) {
            return null;
        }
        String[] stringArray = bundle.getStringArray("urls");
        int[] intArray = bundle.getIntArray("wheres");
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        while (i10 < stringArray.length) {
            if (!stringArray[i10].isEmpty()) {
                arrayList.add(new a(stringArray[i10], i10 >= intArray.length ? 2 : intArray[i10]));
            }
            i10++;
        }
        return arrayList;
    }

    public static Bundle b(List list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Bundle bundle = new Bundle();
        int size = list.size();
        String[] strArr = new String[size];
        int[] iArr = new int[size];
        for (int i10 = 0; i10 < size; i10++) {
            a aVar = (a) list.get(i10);
            strArr[i10] = aVar.a();
            iArr[i10] = aVar.b();
        }
        bundle.putStringArray("urls", strArr);
        bundle.putIntArray("wheres", iArr);
        return bundle;
    }
}
