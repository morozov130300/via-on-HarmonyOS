package j8;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import i6.g0;
import java.util.Collections;
import java.util.UUID;
import mark.via.Shell;
import mark.via.receiver.ReadAloudReceiver;
import n.h;
import org.simpleframework.xml.strategy.Name;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class s {

    /* renamed from: c, reason: collision with root package name */
    public static final int f7619c;

    /* renamed from: a, reason: collision with root package name */
    public final Context f7620a;

    /* renamed from: b, reason: collision with root package name */
    public final NotificationManager f7621b;

    static {
        f7619c = Build.VERSION.SDK_INT >= 23 ? 201326592 : 134217728;
    }

    public s(Context context) {
        this.f7620a = context;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        this.f7621b = notificationManager;
        if (Build.VERSION.SDK_INT >= 26) {
            notificationManager.deleteNotificationChannel("mark.via.CHANNEL.READ_ALOUD");
            notificationManager.createNotificationChannel(new NotificationChannel("mark.via.CHANNEL.READ_ALOUD2", context.getString(x7.u.Ia), 2));
        }
    }

    public final Notification a(t tVar) {
        if (tVar == null) {
            tVar = new t(UUID.randomUUID().toString(), "about:blank", this.f7620a.getString(x7.u.bh), Collections.EMPTY_LIST, 0);
        }
        boolean zH = tVar.h();
        h.d dVarK = new h.d(this.f7620a, "mark.via.CHANNEL.READ_ALOUD2").n(x7.o.f13770u1).i(tVar.e()).h(g0.f6993a.b(tVar.f())).f(zH ? "progress" : "status").k(zH);
        Intent intent = new Intent(this.f7620a, (Class<?>) Shell.class);
        intent.setAction("mark.via.READ_ALOUD");
        intent.setPackage(this.f7620a.getPackageName());
        Context context = this.f7620a;
        int i10 = f7619c;
        dVarK.g(PendingIntent.getActivity(context, 0, intent, i10));
        Intent intent2 = new Intent(this.f7620a, (Class<?>) ReadAloudReceiver.class);
        intent2.setAction(zH ? "mark.via.receiver.ReadAloudReceiver.PAUSE" : "mark.via.receiver.ReadAloudReceiver.PLAY");
        intent2.putExtra(Name.MARK, tVar.b());
        dVarK.a(new h.a.C0099a(zH ? x7.o.f13764s1 : x7.o.f13767t1, this.f7620a.getString(zH ? x7.u.N3 : x7.u.O3), PendingIntent.getBroadcast(this.f7620a, 0, intent2, i10)).a());
        return dVarK.b();
    }

    public void b(Service service, t tVar) {
        service.startForeground(2, a(tVar));
    }

    public void c(t tVar) {
        this.f7621b.notify(2, a(tVar));
    }
}
