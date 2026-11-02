package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import java.lang.reflect.InvocationTargetException;
import o0.a;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(a aVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f574a = (IconCompat) aVar.v(remoteActionCompat.f574a, 1);
        remoteActionCompat.f575b = aVar.l(remoteActionCompat.f575b, 2);
        remoteActionCompat.f576c = aVar.l(remoteActionCompat.f576c, 3);
        remoteActionCompat.f577d = (PendingIntent) aVar.r(remoteActionCompat.f577d, 4);
        remoteActionCompat.f578e = aVar.h(remoteActionCompat.f578e, 5);
        remoteActionCompat.f579f = aVar.h(remoteActionCompat.f579f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, a aVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        aVar.x(false, false);
        aVar.M(remoteActionCompat.f574a, 1);
        aVar.D(remoteActionCompat.f575b, 2);
        aVar.D(remoteActionCompat.f576c, 3);
        aVar.H(remoteActionCompat.f577d, 4);
        aVar.z(remoteActionCompat.f578e, 5);
        aVar.z(remoteActionCompat.f579f, 6);
    }
}
