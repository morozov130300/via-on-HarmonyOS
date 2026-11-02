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
import n.h;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class s0 implements f {

    /* renamed from: a, reason: collision with root package name */
    public final Context f10098a;

    /* renamed from: b, reason: collision with root package name */
    public final Notification.Builder f10099b;

    /* renamed from: c, reason: collision with root package name */
    public final h.d f10100c;

    /* renamed from: d, reason: collision with root package name */
    public RemoteViews f10101d;

    /* renamed from: e, reason: collision with root package name */
    public RemoteViews f10102e;

    /* renamed from: f, reason: collision with root package name */
    public final List f10103f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public final Bundle f10104g = new Bundle();

    /* renamed from: h, reason: collision with root package name */
    public int f10105h;

    /* renamed from: i, reason: collision with root package name */
    public RemoteViews f10106i;

    public s0(h.d dVar) {
        int i10;
        Icon icon;
        List listE;
        this.f10100c = dVar;
        this.f10098a = dVar.f10068a;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 26) {
            this.f10099b = new Notification.Builder(dVar.f10068a, dVar.K);
        } else {
            this.f10099b = new Notification.Builder(dVar.f10068a);
        }
        Notification notification = dVar.S;
        this.f10099b.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, dVar.f10076i).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(dVar.f10072e).setContentText(dVar.f10073f).setContentInfo(dVar.f10078k).setContentIntent(dVar.f10074g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(dVar.f10075h, (notification.flags & 128) != 0).setLargeIcon(dVar.f10077j).setNumber(dVar.f10079l).setProgress(dVar.f10087t, dVar.f10088u, dVar.f10089v);
        if (i11 < 21) {
            this.f10099b.setSound(notification.sound, notification.audioStreamType);
        }
        this.f10099b.setSubText(dVar.f10084q).setUsesChronometer(dVar.f10082o).setPriority(dVar.f10080m);
        Iterator it = dVar.f10069b.iterator();
        while (it.hasNext()) {
            b((h.a) it.next());
        }
        Bundle bundle = dVar.D;
        if (bundle != null) {
            this.f10104g.putAll(bundle);
        }
        int i12 = Build.VERSION.SDK_INT;
        if (i12 < 20) {
            if (dVar.f10093z) {
                this.f10104g.putBoolean("android.support.localOnly", true);
            }
            String str = dVar.f10090w;
            if (str != null) {
                this.f10104g.putString("android.support.groupKey", str);
                if (dVar.f10091x) {
                    this.f10104g.putBoolean("android.support.isGroupSummary", true);
                } else {
                    this.f10104g.putBoolean("android.support.useSideChannel", true);
                }
            }
            String str2 = dVar.f10092y;
            if (str2 != null) {
                this.f10104g.putString("android.support.sortKey", str2);
            }
        }
        this.f10101d = dVar.H;
        this.f10102e = dVar.I;
        this.f10099b.setShowWhen(dVar.f10081n);
        if (i12 < 21 && (listE = e(f(dVar.f10070c), dVar.V)) != null && !listE.isEmpty()) {
            this.f10104g.putStringArray("android.people", (String[]) listE.toArray(new String[listE.size()]));
        }
        if (i12 >= 20) {
            this.f10099b.setLocalOnly(dVar.f10093z).setGroup(dVar.f10090w).setGroupSummary(dVar.f10091x).setSortKey(dVar.f10092y);
            this.f10105h = dVar.P;
        }
        if (i12 >= 21) {
            this.f10099b.setCategory(dVar.C).setColor(dVar.E).setVisibility(dVar.F).setPublicVersion(dVar.G).setSound(notification.sound, notification.audioAttributes);
            List listE2 = i12 < 28 ? e(f(dVar.f10070c), dVar.V) : dVar.V;
            if (listE2 != null && !listE2.isEmpty()) {
                Iterator it2 = listE2.iterator();
                while (it2.hasNext()) {
                    this.f10099b.addPerson((String) it2.next());
                }
            }
            this.f10106i = dVar.J;
            if (dVar.f10071d.size() > 0) {
                Bundle bundle2 = dVar.c().getBundle("android.car.EXTENSIONS");
                bundle2 = bundle2 == null ? new Bundle() : bundle2;
                Bundle bundle3 = new Bundle(bundle2);
                Bundle bundle4 = new Bundle();
                for (int i13 = 0; i13 < dVar.f10071d.size(); i13++) {
                    bundle4.putBundle(Integer.toString(i13), t0.b((h.a) dVar.f10071d.get(i13)));
                }
                bundle2.putBundle("invisible_actions", bundle4);
                bundle3.putBundle("invisible_actions", bundle4);
                dVar.c().putBundle("android.car.EXTENSIONS", bundle2);
                this.f10104g.putBundle("android.car.EXTENSIONS", bundle3);
            }
        }
        int i14 = Build.VERSION.SDK_INT;
        if (i14 >= 23 && (icon = dVar.U) != null) {
            this.f10099b.setSmallIcon(icon);
        }
        if (i14 >= 24) {
            this.f10099b.setExtras(dVar.D).setRemoteInputHistory(dVar.f10086s);
            RemoteViews remoteViews = dVar.H;
            if (remoteViews != null) {
                this.f10099b.setCustomContentView(remoteViews);
            }
            RemoteViews remoteViews2 = dVar.I;
            if (remoteViews2 != null) {
                this.f10099b.setCustomBigContentView(remoteViews2);
            }
            RemoteViews remoteViews3 = dVar.J;
            if (remoteViews3 != null) {
                this.f10099b.setCustomHeadsUpContentView(remoteViews3);
            }
        }
        if (i14 >= 26) {
            this.f10099b.setBadgeIconType(dVar.L).setSettingsText(dVar.f10085r).setShortcutId(dVar.M).setTimeoutAfter(dVar.O).setGroupAlertBehavior(dVar.P);
            if (dVar.B) {
                this.f10099b.setColorized(dVar.A);
            }
            if (!TextUtils.isEmpty(dVar.K)) {
                this.f10099b.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i14 >= 28) {
            Iterator it3 = dVar.f10070c.iterator();
            if (it3.hasNext()) {
                g.a(it3.next());
                throw null;
            }
        }
        if (i14 >= 29) {
            this.f10099b.setAllowSystemGeneratedContextualActions(dVar.R);
            this.f10099b.setBubbleMetadata(h.c.a(null));
            o.l lVar = dVar.N;
            if (lVar != null) {
                this.f10099b.setLocusId(lVar.c());
            }
        }
        if (i14 >= 31 && (i10 = dVar.Q) != 0) {
            this.f10099b.setForegroundServiceBehavior(i10);
        }
        if (dVar.T) {
            if (this.f10100c.f10091x) {
                this.f10105h = 2;
            } else {
                this.f10105h = 1;
            }
            this.f10099b.setVibrate(null);
            this.f10099b.setSound(null);
            int i15 = notification.defaults & (-4);
            notification.defaults = i15;
            this.f10099b.setDefaults(i15);
            if (i14 >= 26) {
                if (TextUtils.isEmpty(this.f10100c.f10090w)) {
                    this.f10099b.setGroup("silent");
                }
                this.f10099b.setGroupAlertBehavior(this.f10105h);
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
        return this.f10099b;
    }

    public final void b(h.a aVar) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 20) {
            this.f10103f.add(t0.e(this.f10099b, aVar));
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
        this.f10099b.addAction(builder.build());
    }

    public Notification c() {
        Bundle bundleA;
        RemoteViews remoteViewsF;
        RemoteViews remoteViewsD;
        h.e eVar = this.f10100c.f10083p;
        if (eVar != null) {
            eVar.b(this);
        }
        RemoteViews remoteViewsE = eVar != null ? eVar.e(this) : null;
        Notification notificationD = d();
        if (remoteViewsE != null) {
            notificationD.contentView = remoteViewsE;
        } else {
            RemoteViews remoteViews = this.f10100c.H;
            if (remoteViews != null) {
                notificationD.contentView = remoteViews;
            }
        }
        int i10 = Build.VERSION.SDK_INT;
        if (eVar != null && (remoteViewsD = eVar.d(this)) != null) {
            notificationD.bigContentView = remoteViewsD;
        }
        if (i10 >= 21 && eVar != null && (remoteViewsF = this.f10100c.f10083p.f(this)) != null) {
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
            return this.f10099b.build();
        }
        if (i10 >= 24) {
            Notification notificationBuild = this.f10099b.build();
            if (this.f10105h != 0) {
                if (notificationBuild.getGroup() != null && (notificationBuild.flags & 512) != 0 && this.f10105h == 2) {
                    g(notificationBuild);
                }
                if (notificationBuild.getGroup() != null && (notificationBuild.flags & 512) == 0 && this.f10105h == 1) {
                    g(notificationBuild);
                }
            }
            return notificationBuild;
        }
        if (i10 >= 21) {
            this.f10099b.setExtras(this.f10104g);
            Notification notificationBuild2 = this.f10099b.build();
            RemoteViews remoteViews = this.f10101d;
            if (remoteViews != null) {
                notificationBuild2.contentView = remoteViews;
            }
            RemoteViews remoteViews2 = this.f10102e;
            if (remoteViews2 != null) {
                notificationBuild2.bigContentView = remoteViews2;
            }
            RemoteViews remoteViews3 = this.f10106i;
            if (remoteViews3 != null) {
                notificationBuild2.headsUpContentView = remoteViews3;
            }
            if (this.f10105h != 0) {
                if (notificationBuild2.getGroup() != null && (notificationBuild2.flags & 512) != 0 && this.f10105h == 2) {
                    g(notificationBuild2);
                }
                if (notificationBuild2.getGroup() != null && (notificationBuild2.flags & 512) == 0 && this.f10105h == 1) {
                    g(notificationBuild2);
                }
            }
            return notificationBuild2;
        }
        if (i10 < 20) {
            SparseArray<? extends Parcelable> sparseArrayA = t0.a(this.f10103f);
            if (sparseArrayA != null) {
                this.f10104g.putSparseParcelableArray("android.support.actionExtras", sparseArrayA);
            }
            this.f10099b.setExtras(this.f10104g);
            Notification notificationBuild3 = this.f10099b.build();
            RemoteViews remoteViews4 = this.f10101d;
            if (remoteViews4 != null) {
                notificationBuild3.contentView = remoteViews4;
            }
            RemoteViews remoteViews5 = this.f10102e;
            if (remoteViews5 != null) {
                notificationBuild3.bigContentView = remoteViews5;
            }
            return notificationBuild3;
        }
        this.f10099b.setExtras(this.f10104g);
        Notification notificationBuild4 = this.f10099b.build();
        RemoteViews remoteViews6 = this.f10101d;
        if (remoteViews6 != null) {
            notificationBuild4.contentView = remoteViews6;
        }
        RemoteViews remoteViews7 = this.f10102e;
        if (remoteViews7 != null) {
            notificationBuild4.bigContentView = remoteViews7;
        }
        if (this.f10105h != 0) {
            if (notificationBuild4.getGroup() != null && (notificationBuild4.flags & 512) != 0 && this.f10105h == 2) {
                g(notificationBuild4);
            }
            if (notificationBuild4.getGroup() != null && (notificationBuild4.flags & 512) == 0 && this.f10105h == 1) {
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
