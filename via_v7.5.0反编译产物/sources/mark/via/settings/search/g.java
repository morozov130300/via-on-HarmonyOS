package mark.via.settings.search;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class g {
    public static boolean a(b bVar, String[] strArr) {
        for (String str : strArr) {
            if (!bVar.g(str)) {
                return false;
            }
        }
        return true;
    }

    public static List b(List list, String str) {
        ArrayList arrayList = new ArrayList();
        String strH = b.h(str);
        if (!strH.isEmpty()) {
            String[] strArrSplit = strH.split("\\s+");
            Iterator it = list.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (a(bVar, strArrSplit)) {
                    arrayList.add(bVar);
                }
            }
        }
        return arrayList;
    }
}
