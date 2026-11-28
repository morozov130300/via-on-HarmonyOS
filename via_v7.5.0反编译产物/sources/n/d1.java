package n;

import android.app.Service;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class d1 {

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class a {
        public static void a(Service service, int i10) {
            service.stopForeground(i10);
        }
    }

    public static void a(Service service, int i10) {
        if (Build.VERSION.SDK_INT >= 24) {
            a.a(service, i10);
        } else {
            service.stopForeground((i10 & 1) != 0);
        }
    }
}
