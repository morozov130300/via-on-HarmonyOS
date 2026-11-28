package n;

import android.app.Notification;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class x0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f10475d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static d f10478g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f10479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NotificationManager f10480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f10474c = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Set f10476e = new HashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object f10477f = new Object();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class a implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f10481a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f10482b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f10483c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f10484d = false;

        public a(String str, int i10, String str2) {
            this.f10481a = str;
            this.f10482b = i10;
            this.f10483c = str2;
        }

        @Override // n.x0.e
        public void a(c.a aVar) {
            if (this.f10484d) {
                aVar.r(this.f10481a);
            } else {
                aVar.J(this.f10481a, this.f10482b, this.f10483c);
            }
        }

        public String toString() {
            return "CancelTask[packageName:" + this.f10481a + ", id:" + this.f10482b + ", tag:" + this.f10483c + ", all:" + this.f10484d + "]";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class b implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f10485a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f10486b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f10487c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Notification f10488d;

        public b(String str, int i10, String str2, Notification notification) {
            this.f10485a = str;
            this.f10486b = i10;
            this.f10487c = str2;
            this.f10488d = notification;
        }

        @Override // n.x0.e
        public void a(c.a aVar) {
            aVar.U(this.f10485a, this.f10486b, this.f10487c, this.f10488d);
        }

        public String toString() {
            return "NotifyTask[packageName:" + this.f10485a + ", id:" + this.f10486b + ", tag:" + this.f10487c + "]";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ComponentName f10489a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final IBinder f10490b;

        public c(ComponentName componentName, IBinder iBinder) {
            this.f10489a = componentName;
            this.f10490b = iBinder;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class d implements Handler.Callback, ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f10491a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HandlerThread f10492b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Handler f10493c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map f10494d = new HashMap();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Set f10495e = new HashSet();

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final ComponentName f10496a;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public c.a f10498c;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public boolean f10497b = false;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public ArrayDeque f10499d = new ArrayDeque();

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f10500e = 0;

            public a(ComponentName componentName) {
                this.f10496a = componentName;
            }
        }

        public d(Context context) {
            this.f10491a = context;
            HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
            this.f10492b = handlerThread;
            handlerThread.start();
            this.f10493c = new Handler(handlerThread.getLooper(), this);
        }

        public final boolean a(a aVar) {
            if (aVar.f10497b) {
                return true;
            }
            boolean zBindService = this.f10491a.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(aVar.f10496a), this, 33);
            aVar.f10497b = zBindService;
            if (zBindService) {
                aVar.f10500e = 0;
            } else {
                Log.w("NotifManCompat", "Unable to bind to listener " + aVar.f10496a);
                this.f10491a.unbindService(this);
            }
            return aVar.f10497b;
        }

        public final void b(a aVar) {
            if (aVar.f10497b) {
                this.f10491a.unbindService(this);
                aVar.f10497b = false;
            }
            aVar.f10498c = null;
        }

        public final void c(e eVar) {
            j();
            for (a aVar : this.f10494d.values()) {
                aVar.f10499d.add(eVar);
                g(aVar);
            }
        }

        public final void d(ComponentName componentName) {
            a aVar = (a) this.f10494d.get(componentName);
            if (aVar != null) {
                g(aVar);
            }
        }

        public final void e(ComponentName componentName, IBinder iBinder) {
            a aVar = (a) this.f10494d.get(componentName);
            if (aVar != null) {
                aVar.f10498c = c.a.AbstractBinderC0035a.Y(iBinder);
                aVar.f10500e = 0;
                g(aVar);
            }
        }

        public final void f(ComponentName componentName) {
            a aVar = (a) this.f10494d.get(componentName);
            if (aVar != null) {
                b(aVar);
            }
        }

        public final void g(a aVar) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Processing component " + aVar.f10496a + ", " + aVar.f10499d.size() + " queued tasks");
            }
            if (aVar.f10499d.isEmpty()) {
                return;
            }
            if (!a(aVar) || aVar.f10498c == null) {
                i(aVar);
                return;
            }
            while (true) {
                e eVar = (e) aVar.f10499d.peek();
                if (eVar == null) {
                    break;
                }
                try {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Sending task " + eVar);
                    }
                    eVar.a(aVar.f10498c);
                    aVar.f10499d.remove();
                } catch (DeadObjectException unused) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Remote service has died: " + aVar.f10496a);
                    }
                } catch (RemoteException e10) {
                    Log.w("NotifManCompat", "RemoteException communicating with " + aVar.f10496a, e10);
                }
            }
            if (aVar.f10499d.isEmpty()) {
                return;
            }
            i(aVar);
        }

        public void h(e eVar) {
            this.f10493c.obtainMessage(0, eVar).sendToTarget();
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 0) {
                c((e) message.obj);
                return true;
            }
            if (i10 == 1) {
                c cVar = (c) message.obj;
                e(cVar.f10489a, cVar.f10490b);
                return true;
            }
            if (i10 == 2) {
                f((ComponentName) message.obj);
                return true;
            }
            if (i10 != 3) {
                return false;
            }
            d((ComponentName) message.obj);
            return true;
        }

        public final void i(a aVar) {
            if (this.f10493c.hasMessages(3, aVar.f10496a)) {
                return;
            }
            int i10 = aVar.f10500e;
            int i11 = i10 + 1;
            aVar.f10500e = i11;
            if (i11 <= 6) {
                int i12 = (1 << i10) * 1000;
                if (Log.isLoggable("NotifManCompat", 3)) {
                    Log.d("NotifManCompat", "Scheduling retry for " + i12 + " ms");
                }
                this.f10493c.sendMessageDelayed(this.f10493c.obtainMessage(3, aVar.f10496a), i12);
                return;
            }
            Log.w("NotifManCompat", "Giving up on delivering " + aVar.f10499d.size() + " tasks to " + aVar.f10496a + " after " + aVar.f10500e + " retries");
            aVar.f10499d.clear();
        }

        public final void j() {
            Set setG = x0.g(this.f10491a);
            if (setG.equals(this.f10495e)) {
                return;
            }
            this.f10495e = setG;
            List<ResolveInfo> listQueryIntentServices = this.f10491a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
            HashSet<ComponentName> hashSet = new HashSet();
            for (ResolveInfo resolveInfo : listQueryIntentServices) {
                if (setG.contains(resolveInfo.serviceInfo.packageName)) {
                    ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                    ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                    if (resolveInfo.serviceInfo.permission != null) {
                        Log.w("NotifManCompat", "Permission present on component " + componentName + ", not adding listener record.");
                    } else {
                        hashSet.add(componentName);
                    }
                }
            }
            for (ComponentName componentName2 : hashSet) {
                if (!this.f10494d.containsKey(componentName2)) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Adding listener record for " + componentName2);
                    }
                    this.f10494d.put(componentName2, new a(componentName2));
                }
            }
            Iterator it = this.f10494d.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (!hashSet.contains(entry.getKey())) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Removing listener record for " + entry.getKey());
                    }
                    b((a) entry.getValue());
                    it.remove();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Connected to service " + componentName);
            }
            this.f10493c.obtainMessage(1, new c(componentName, iBinder)).sendToTarget();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Disconnected from service " + componentName);
            }
            this.f10493c.obtainMessage(2, componentName).sendToTarget();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface e {
        void a(c.a aVar);
    }

    public x0(Context context) {
        this.f10479a = context;
        this.f10480b = (NotificationManager) context.getSystemService("notification");
    }

    public static x0 f(Context context) {
        return new x0(context);
    }

    public static Set g(Context context) {
        Set set;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (f10474c) {
            if (string != null) {
                try {
                    if (!string.equals(f10475d)) {
                        String[] strArrSplit = string.split(":", -1);
                        HashSet hashSet = new HashSet(strArrSplit.length);
                        for (String str : strArrSplit) {
                            ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(str);
                            if (componentNameUnflattenFromString != null) {
                                hashSet.add(componentNameUnflattenFromString.getPackageName());
                            }
                        }
                        f10476e = hashSet;
                        f10475d = string;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            set = f10476e;
        }
        return set;
    }

    public static boolean k(Notification notification) {
        Bundle bundleA = h.a(notification);
        return bundleA != null && bundleA.getBoolean("android.support.useSideChannel");
    }

    public void a(int i10) {
        b(null, i10);
    }

    public void b(String str, int i10) {
        this.f10480b.cancel(str, i10);
        if (Build.VERSION.SDK_INT <= 19) {
            j(new a(this.f10479a.getPackageName(), i10, str));
        }
    }

    public void c(NotificationChannelGroup notificationChannelGroup) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f10480b.createNotificationChannelGroup(notificationChannelGroup);
        }
    }

    public void d(List list) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f10480b.createNotificationChannels(list);
        }
    }

    public void e(String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f10480b.deleteNotificationChannel(str);
        }
    }

    public void h(int i10, Notification notification) {
        i(null, i10, notification);
    }

    public void i(String str, int i10, Notification notification) {
        if (!k(notification)) {
            this.f10480b.notify(str, i10, notification);
        } else {
            j(new b(this.f10479a.getPackageName(), i10, str, notification));
            this.f10480b.cancel(str, i10);
        }
    }

    public final void j(e eVar) {
        synchronized (f10477f) {
            try {
                if (f10478g == null) {
                    f10478g = new d(this.f10479a.getApplicationContext());
                }
                f10478g.h(eVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
