package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import p0.a;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(a aVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f477a = (IconCompat) aVar.v(remoteActionCompat.f477a, 1);
        remoteActionCompat.f478b = aVar.l(remoteActionCompat.f478b, 2);
        remoteActionCompat.f479c = aVar.l(remoteActionCompat.f479c, 3);
        remoteActionCompat.f480d = (PendingIntent) aVar.r(remoteActionCompat.f480d, 4);
        remoteActionCompat.f481e = aVar.h(remoteActionCompat.f481e, 5);
        remoteActionCompat.f482f = aVar.h(remoteActionCompat.f482f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, a aVar) {
        aVar.x(false, false);
        aVar.M(remoteActionCompat.f477a, 1);
        aVar.D(remoteActionCompat.f478b, 2);
        aVar.D(remoteActionCompat.f479c, 3);
        aVar.H(remoteActionCompat.f480d, 4);
        aVar.z(remoteActionCompat.f481e, 5);
        aVar.z(remoteActionCompat.f482f, 6);
    }
}
