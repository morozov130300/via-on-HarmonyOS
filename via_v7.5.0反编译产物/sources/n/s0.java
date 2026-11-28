package n;

import android.app.Notification;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class s0 implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f10463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Notification.Builder f10464b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h.d f10465c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RemoteViews f10466d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RemoteViews f10467e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f10468f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Bundle f10469g = new Bundle();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f10470h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RemoteViews f10471i;

    public s0(h.d dVar) {
        int i10;
        Icon icon;
        List listE;
        this.f10465c = dVar;
        this.f10463a = dVar.f10433a;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 26) {
            this.f10464b = new Notification.Builder(dVar.f10433a, dVar.K);
        } else {
            this.f10464b = new Notification.Builder(dVar.f10433a);
        }
        Notification notification = dVar.S;
        this.f10464b.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, dVar.f10441i).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(dVar.f10437e).setContentText(dVar.f10438f).setContentInfo(dVar.f10443k).setContentIntent(dVar.f10439g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(dVar.f10440h, (notification.flags & 128) != 0).setLargeIcon(dVar.f10442j).setNumber(dVar.f10444l).setProgress(dVar.f10452t, dVar.f10453u, dVar.f10454v);
        if (i11 < 21) {
            this.f10464b.setSound(notification.sound, notification.audioStreamType);
        }
        this.f10464b.setSubText(dVar.f10449q).setUsesChronometer(dVar.f10447o).setPriority(dVar.f10445m);
        Iterator it = dVar.f10434b.iterator();
        while (it.hasNext()) {
            b((h.a) it.next());
        }
        Bundle bundle = dVar.D;
        if (bundle != null) {
            this.f10469g.putAll(bundle);
        }
        int i12 = Build.VERSION.SDK_INT;
        if (i12 < 20) {
            if (dVar.f10458z) {
                this.f10469g.putBoolean("android.support.localOnly", true);
            }
            String str = dVar.f10455w;
            if (str != null) {
                this.f10469g.putString("android.support.groupKey", str);
                if (dVar.f10456x) {
                    this.f10469g.putBoolean("android.support.isGroupSummary", true);
                } else {
                    this.f10469g.putBoolean("android.support.useSideChannel", true);
                }
            }
            String str2 = dVar.f10457y;
            if (str2 != null) {
                this.f10469g.putString("android.support.sortKey", str2);
            }
        }
        this.f10466d = dVar.H;
        this.f10467e = dVar.I;
        this.f10464b.setShowWhen(dVar.f10446n);
        if (i12 < 21 && (listE = e(f(dVar.f10435c), dVar.V)) != null && !listE.isEmpty()) {
            this.f10469g.putStringArray("android.people", (String[]) listE.toArray(new String[listE.size()]));
        }
        if (i12 >= 20) {
            this.f10464b.setLocalOnly(dVar.f10458z).setGroup(dVar.f10455w).setGroupSummary(dVar.f10456x).setSortKey(dVar.f10457y);
            this.f10470h = dVar.P;
        }
        if (i12 >= 21) {
            this.f10464b.setCategory(dVar.C).setColor(dVar.E).setVisibility(dVar.F).setPublicVersion(dVar.G).setSound(notification.sound, notification.audioAttributes);
            List listE2 = i12 < 28 ? e(f(dVar.f10435c), dVar.V) : dVar.V;
            if (listE2 != null && !listE2.isEmpty()) {
                Iterator it2 = listE2.iterator();
                while (it2.hasNext()) {
                    this.f10464b.addPerson((String) it2.next());
                }
            }
            this.f10471i = dVar.J;
            if (dVar.f10436d.size() > 0) {
                Bundle bundle2 = dVar.c().getBundle("android.car.EXTENSIONS");
                bundle2 = bundle2 == null ? new Bundle() : bundle2;
                Bundle bundle3 = new Bundle(bundle2);
                Bundle bundle4 = new Bundle();
                for (int i13 = 0; i13 < dVar.f10436d.size(); i13++) {
                    bundle4.putBundle(Integer.toString(i13), t0.b((h.a) dVar.f10436d.get(i13)));
                }
                bundle2.putBundle("invisible_actions", bundle4);
                bundle3.putBundle("invisible_actions", bundle4);
                dVar.c().putBundle("android.car.EXTENSIONS", bundle2);
                this.f10469g.putBundle("android.car.EXTENSIONS", bundle3);
            }
        }
        int i14 = Build.VERSION.SDK_INT;
        if (i14 >= 23 && (icon = dVar.U) != null) {
            this.f10464b.setSmallIcon(icon);
        }
        if (i14 >= 24) {
            this.f10464b.setExtras(dVar.D).setRemoteInputHistory(dVar.f10451s);
            RemoteViews remoteViews = dVar.H;
            if (remoteViews != null) {
                this.f10464b.setCustomContentView(remoteViews);
            }
            RemoteViews remoteViews2 = dVar.I;
            if (remoteViews2 != null) {
                this.f10464b.setCustomBigContentView(remoteViews2);
            }
            RemoteViews remoteViews3 = dVar.J;
            if (remoteViews3 != null) {
                this.f10464b.setCustomHeadsUpContentView(remoteViews3);
            }
        }
        if (i14 >= 26) {
            this.f10464b.setBadgeIconType(dVar.L).setSettingsText(dVar.f10450r).setShortcutId(dVar.M).setTimeoutAfter(dVar.O).setGroupAlertBehavior(dVar.P);
            if (dVar.B) {
                this.f10464b.setColorized(dVar.A);
            }
            if (!TextUtils.isEmpty(dVar.K)) {
                this.f10464b.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i14 >= 28) {
            Iterator it3 = dVar.f10435c.iterator();
            if (it3.hasNext()) {
                g.a(it3.next());
                throw null;
            }
        }
        if (i14 >= 29) {
            this.f10464b.setAllowSystemGeneratedContextualActions(dVar.R);
            this.f10464b.setBubbleMetadata(h.c.a(null));
            o.l lVar = dVar.N;
            if (lVar != null) {
                this.f10464b.setLocusId(lVar.c());
            }
        }
        if (i14 >= 31 && (i10 = dVar.Q) != 0) {
            this.f10464b.setForegroundServiceBehavior(i10);
        }
        if (dVar.T) {
            if (this.f10465c.f10456x) {
                this.f10470h = 2;
            } else {
                this.f10470h = 1;
            }
            this.f10464b.setVibrate(null);
            this.f10464b.setSound(null);
            int i15 = notification.defaults & (-4);
            notification.defaults = i15;
            this.f10464b.setDefaults(i15);
            if (i14 >= 26) {
                if (TextUtils.isEmpty(this.f10465c.f10455w)) {
                    this.f10464b.setGroup("silent");
                }
                this.f10464b.setGroupAlertBehavior(this.f10470h);
            }
        }
    }

    public static List e(List list, List list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        k.b bVar = new k.b(list.size() + list2.size());
        bVar.addAll(list);
        bVar.addAll(list2);
        return new ArrayList(bVar);
    }

    public static List f(List list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        if (!it.hasNext()) {
            return arrayList;
        }
        g.a(it.next());
        throw null;
    }

    @Override // n.f
    public Notification.Builder a() {
        return this.f10464b;
    }

    public final void b(h.a aVar) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 20) {
            this.f10468f.add(t0.e(this.f10464b, aVar));
            return;
        }
        IconCompat iconCompatE = aVar.e();
        Notification.Action.Builder builder = i10 >= 23 ? new Notification.Action.Builder(iconCompatE != null ? iconCompatE.p() : null, aVar.i(), aVar.a()) : new Notification.Action.Builder(iconCompatE != null ? iconCompatE.h() : 0, aVar.i(), aVar.a());
        if (aVar.f() != null) {
            for (RemoteInput remoteInput : c1.b(aVar.f())) {
                builder.addRemoteInput(remoteInput);
            }
        }
        Bundle bundle = aVar.d() != null ? new Bundle(aVar.d()) : new Bundle();
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 24) {
            builder.setAllowGeneratedReplies(aVar.b());
        }
        bundle.putInt("android.support.action.semanticAction", aVar.g());
        if (i11 >= 28) {
            builder.setSemanticAction(aVar.g());
        }
        if (i11 >= 29) {
            builder.setContextual(aVar.k());
        }
        if (i11 >= 31) {
            builder.setAuthenticationRequired(aVar.j());
        }
        bundle.putBoolean("android.support.action.showsUserInterface", aVar.h());
        builder.addExtras(bundle);
        this.f10464b.addAction(builder.build());
    }

    public Notification c() {
        Bundle bundleA;
        RemoteViews remoteViewsF;
        RemoteViews remoteViewsD;
        h.e eVar = this.f10465c.f10448p;
        if (eVar != null) {
            eVar.b(this);
        }
        RemoteViews remoteViewsE = eVar != null ? eVar.e(this) : null;
        Notification notificationD = d();
        if (remoteViewsE != null) {
            notificationD.contentView = remoteViewsE;
        } else {
            RemoteViews remoteViews = this.f10465c.H;
            if (remoteViews != null) {
                notificationD.contentView = remoteViews;
            }
        }
        int i10 = Build.VERSION.SDK_INT;
        if (eVar != null && (remoteViewsD = eVar.d(this)) != null) {
            notificationD.bigContentView = remoteViewsD;
        }
        if (i10 >= 21 && eVar != null && (remoteViewsF = this.f10465c.f10448p.f(this)) != null) {
            notificationD.headsUpContentView = remoteViewsF;
        }
        if (eVar != null && (bundleA = h.a(notificationD)) != null) {
            eVar.a(bundleA);
        }
        return notificationD;
    }

    public Notification d() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 26) {
            return this.f10464b.build();
        }
        if (i10 >= 24) {
            Notification notificationBuild = this.f10464b.build();
            if (this.f10470h != 0) {
                if (notificationBuild.getGroup() != null && (notificationBuild.flags & 512) != 0 && this.f10470h == 2) {
                    g(notificationBuild);
                }
                if (notificationBuild.getGroup() != null && (notificationBuild.flags & 512) == 0 && this.f10470h == 1) {
                    g(notificationBuild);
                }
            }
            return notificationBuild;
        }
        if (i10 >= 21) {
            this.f10464b.setExtras(this.f10469g);
            Notification notificationBuild2 = this.f10464b.build();
            RemoteViews remoteViews = this.f10466d;
            if (remoteViews != null) {
                notificationBuild2.contentView = remoteViews;
            }
            RemoteViews remoteViews2 = this.f10467e;
            if (remoteViews2 != null) {
                notificationBuild2.bigContentView = remoteViews2;
            }
            RemoteViews remoteViews3 = this.f10471i;
            if (remoteViews3 != null) {
                notificationBuild2.headsUpContentView = remoteViews3;
            }
            if (this.f10470h != 0) {
                if (notificationBuild2.getGroup() != null && (notificationBuild2.flags & 512) != 0 && this.f10470h == 2) {
                    g(notificationBuild2);
                }
                if (notificationBuild2.getGroup() != null && (notificationBuild2.flags & 512) == 0 && this.f10470h == 1) {
                    g(notificationBuild2);
                }
            }
            return notificationBuild2;
        }
        if (i10 < 20) {
            SparseArray<? extends Parcelable> sparseArrayA = t0.a(this.f10468f);
            if (sparseArrayA != null) {
                this.f10469g.putSparseParcelableArray("android.support.actionExtras", sparseArrayA);
            }
            this.f10464b.setExtras(this.f10469g);
            Notification notificationBuild3 = this.f10464b.build();
            RemoteViews remoteViews4 = this.f10466d;
            if (remoteViews4 != null) {
                notificationBuild3.contentView = remoteViews4;
            }
            RemoteViews remoteViews5 = this.f10467e;
            if (remoteViews5 != null) {
                notificationBuild3.bigContentView = remoteViews5;
            }
            return notificationBuild3;
        }
        this.f10464b.setExtras(this.f10469g);
        Notification notificationBuild4 = this.f10464b.build();
        RemoteViews remoteViews6 = this.f10466d;
        if (remoteViews6 != null) {
            notificationBuild4.contentView = remoteViews6;
        }
        RemoteViews remoteViews7 = this.f10467e;
        if (remoteViews7 != null) {
            notificationBuild4.bigContentView = remoteViews7;
        }
        if (this.f10470h != 0) {
            if (notificationBuild4.getGroup() != null && (notificationBuild4.flags & 512) != 0 && this.f10470h == 2) {
                g(notificationBuild4);
            }
            if (notificationBuild4.getGroup() != null && (notificationBuild4.flags & 512) == 0 && this.f10470h == 1) {
                g(notificationBuild4);
            }
        }
        return notificationBuild4;
    }

    public final void g(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -4;
    }
}
