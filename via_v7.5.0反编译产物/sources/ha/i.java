package ha;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class i {
    public static List a(List... listArr) {
        List list = null;
        for (List list2 : listArr) {
            if (list2 != null && list2.size() != 0) {
                if (list == null) {
                    list = list2;
                } else {
                    list.addAll(list2);
                }
            }
        }
        return list;
    }
}
