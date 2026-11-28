package h8;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import c6.y1;
import java.util.Collections;
import java.util.UUID;
import mark.via.Shell;
import mark.via.receiver.ReadAloudReceiver;
import org.simpleframework.xml.strategy.Name;
import w7.u;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class s {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f5750c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f5751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NotificationManager f5752b;

    static {
        f5750c = Build.VERSION.SDK_INT >= 23 ? 201326592 : 134217728;
    }

    public s(Context context) {
        this.f5751a = context;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        this.f5752b = notificationManager;
        if (Build.VERSION.SDK_INT >= 26) {
            notificationManager.deleteNotificationChannel("mark.via.CHANNEL.READ_ALOUD");
            notificationManager.createNotificationChannel(new NotificationChannel("mark.via.CHANNEL.READ_ALOUD2", context.getString(u.Ua), 2));
        }
    }

    public final Notification a(t tVar) {
        if (tVar == null) {
            tVar = new t(UUID.randomUUID().toString(), "about:blank", this.f5751a.getString(u.Ah), Collections.EMPTY_LIST, 0);
        }
        boolean zH = tVar.h();
        n.h.d dVarK = new n.h.d(this.f5751a, "mark.via.CHANNEL.READ_ALOUD2").n(w7.o.f13830s1).i(tVar.e()).h(y1.f2139a.b(tVar.f())).f(zH ? "progress" : "status").k(zH);
        Intent intent = new Intent(this.f5751a, (Class<?>) Shell.class);
        intent.setAction("mark.via.READ_ALOUD");
        intent.setPackage(this.f5751a.getPackageName());
        Context context = this.f5751a;
        int i10 = f5750c;
        dVarK.g(PendingIntent.getActivity(context, 0, intent, i10));
        Intent intent2 = new Intent(this.f5751a, (Class<?>) ReadAloudReceiver.class);
        intent2.setAction(zH ? "mark.via.receiver.ReadAloudReceiver.PAUSE" : "mark.via.receiver.ReadAloudReceiver.PLAY");
        intent2.putExtra(Name.MARK, tVar.b());
        dVarK.a(new n.h.a.C0100a(zH ? w7.o.f13824q1 : w7.o.f13827r1, this.f5751a.getString(zH ? u.f13971a4 : u.f13985b4), PendingIntent.getBroadcast(this.f5751a, 0, intent2, i10)).a());
        return dVarK.b();
    }

    public void b(Service service, t tVar) {
        service.startForeground(2, a(tVar));
    }

    public void c(t tVar) {
        this.f5752b.notify(2, a(tVar));
    }
}
