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
import c.a;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class x0 {

    /* renamed from: d, reason: collision with root package name */
    public static String f10110d;

    /* renamed from: g, reason: collision with root package name */
    public static d f10113g;

    /* renamed from: a, reason: collision with root package name */
    public final Context f10114a;

    /* renamed from: b, reason: collision with root package name */
    public final NotificationManager f10115b;

    /* renamed from: c, reason: collision with root package name */
    public static final Object f10109c = new Object();

    /* renamed from: e, reason: collision with root package name */
    public static Set f10111e = new HashSet();

    /* renamed from: f, reason: collision with root package name */
    public static final Object f10112f = new Object();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class a implements e {

        /* renamed from: a, reason: collision with root package name */
        public final String f10116a;

        /* renamed from: b, reason: collision with root package name */
        public final int f10117b;

        /* renamed from: c, reason: collision with root package name */
        public final String f10118c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f10119d = false;

        public a(String str, int i10, String str2) {
            this.f10116a = str;
            this.f10117b = i10;
            this.f10118c = str2;
        }

        @Override // n.x0.e
        public void a(c.a aVar) {
            if (this.f10119d) {
                aVar.r(this.f10116a);
            } else {
                aVar.K(this.f10116a, this.f10117b, this.f10118c);
            }
        }

        public String toString() {
            return "CancelTask[packageName:" + this.f10116a + ", id:" + this.f10117b + ", tag:" + this.f10118c + ", all:" + this.f10119d + "]";
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class b implements e {

        /* renamed from: a, reason: collision with root package name */
        public final String f10120a;

        /* renamed from: b, reason: collision with root package name */
        public final int f10121b;

        /* renamed from: c, reason: collision with root package name */
        public final String f10122c;

        /* renamed from: d, reason: collision with root package name */
        public final Notification f10123d;

        public b(String str, int i10, String str2, Notification notification) {
            this.f10120a = str;
            this.f10121b = i10;
            this.f10122c = str2;
            this.f10123d = notification;
        }

        @Override // n.x0.e
        public void a(c.a aVar) {
            aVar.U(this.f10120a, this.f10121b, this.f10122c, this.f10123d);
        }

        public String toString() {
            return "NotifyTask[packageName:" + this.f10120a + ", id:" + this.f10121b + ", tag:" + this.f10122c + "]";
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final ComponentName f10124a;

        /* renamed from: b, reason: collision with root package name */
        public final IBinder f10125b;

        public c(ComponentName componentName, IBinder iBinder) {
            this.f10124a = componentName;
            this.f10125b = iBinder;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class d implements Handler.Callback, ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        public final Context f10126a;

        /* renamed from: b, reason: collision with root package name */
        public final HandlerThread f10127b;

        /* renamed from: c, reason: collision with root package name */
        public final Handler f10128c;

        /* renamed from: d, reason: collision with root package name */
        public final Map f10129d = new HashMap();

        /* renamed from: e, reason: collision with root package name */
        public Set f10130e = new HashSet();

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            public final ComponentName f10131a;

            /* renamed from: c, reason: collision with root package name */
            public c.a f10133c;

            /* renamed from: b, reason: collision with root package name */
            public boolean f10132b = false;

            /* renamed from: d, reason: collision with root package name */
            public ArrayDeque f10134d = new ArrayDeque();

            /* renamed from: e, reason: collision with root package name */
            public int f10135e = 0;

            public a(ComponentName componentName) {
                this.f10131a = componentName;
            }
        }

        public d(Context context) {
            this.f10126a = context;
            HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
            this.f10127b = handlerThread;
            handlerThread.start();
            this.f10128c = new Handler(handlerThread.getLooper(), this);
        }

        public final boolean a(a aVar) {
            if (aVar.f10132b) {
                return true;
            }
            boolean zBindService = this.f10126a.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(aVar.f10131a), this, 33);
            aVar.f10132b = zBindService;
            if (zBindService) {
                aVar.f10135e = 0;
            } else {
                Log.w("NotifManCompat", "Unable to bind to listener " + aVar.f10131a);
                this.f10126a.unbindService(this);
            }
            return aVar.f10132b;
        }

        public final void b(a aVar) {
            if (aVar.f10132b) {
                this.f10126a.unbindService(this);
                aVar.f10132b = false;
            }
            aVar.f10133c = null;
        }

        public final void c(e eVar) {
            j();
            for (a aVar : this.f10129d.values()) {
                aVar.f10134d.add(eVar);
                g(aVar);
            }
        }

        public final void d(ComponentName componentName) {
            a aVar = (a) this.f10129d.get(componentName);
            if (aVar != null) {
                g(aVar);
            }
        }

        public final void e(ComponentName componentName, IBinder iBinder) {
            a aVar = (a) this.f10129d.get(componentName);
            if (aVar != null) {
                aVar.f10133c = a.AbstractBinderC0035a.Y(iBinder);
                aVar.f10135e = 0;
                g(aVar);
            }
        }

        public final void f(ComponentName componentName) {
            a aVar = (a) this.f10129d.get(componentName);
            if (aVar != null) {
                b(aVar);
            }
        }

        public final void g(a aVar) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Processing component " + aVar.f10131a + ", " + aVar.f10134d.size() + " queued tasks");
            }
            if (aVar.f10134d.isEmpty()) {
                return;
            }
            if (!a(aVar) || aVar.f10133c == null) {
                i(aVar);
                return;
            }
            while (true) {
                e eVar = (e) aVar.f10134d.peek();
                if (eVar == null) {
                    break;
                }
                try {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Sending task " + eVar);
                    }
                    eVar.a(aVar.f10133c);
                    aVar.f10134d.remove();
                } catch (DeadObjectException unused) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Remote service has died: " + aVar.f10131a);
                    }
                } catch (RemoteException e10) {
                    Log.w("NotifManCompat", "RemoteException communicating with " + aVar.f10131a, e10);
                }
            }
            if (aVar.f10134d.isEmpty()) {
                return;
            }
            i(aVar);
        }

        public void h(e eVar) {
            this.f10128c.obtainMessage(0, eVar).sendToTarget();
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
                e(cVar.f10124a, cVar.f10125b);
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
            if (this.f10128c.hasMessages(3, aVar.f10131a)) {
                return;
            }
            int i10 = aVar.f10135e;
            int i11 = i10 + 1;
            aVar.f10135e = i11;
            if (i11 <= 6) {
                int i12 = (1 << i10) * 1000;
                if (Log.isLoggable("NotifManCompat", 3)) {
                    Log.d("NotifManCompat", "Scheduling retry for " + i12 + " ms");
                }
                this.f10128c.sendMessageDelayed(this.f10128c.obtainMessage(3, aVar.f10131a), i12);
                return;
            }
            Log.w("NotifManCompat", "Giving up on delivering " + aVar.f10134d.size() + " tasks to " + aVar.f10131a + " after " + aVar.f10135e + " retries");
            aVar.f10134d.clear();
        }

        public final void j() {
            Set setG = x0.g(this.f10126a);
            if (setG.equals(this.f10130e)) {
                return;
            }
            this.f10130e = setG;
            List<ResolveInfo> listQueryIntentServices = this.f10126a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
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
                if (!this.f10129d.containsKey(componentName2)) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Adding listener record for " + componentName2);
                    }
                    this.f10129d.put(componentName2, new a(componentName2));
                }
            }
            Iterator it = this.f10129d.entrySet().iterator();
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
            this.f10128c.obtainMessage(1, new c(componentName, iBinder)).sendToTarget();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Disconnected from service " + componentName);
            }
            this.f10128c.obtainMessage(2, componentName).sendToTarget();
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface e {
        void a(c.a aVar);
    }

    public x0(Context context) {
        this.f10114a = context;
        this.f10115b = (NotificationManager) context.getSystemService("notification");
    }

    public static x0 f(Context context) {
        return new x0(context);
    }

    public static Set g(Context context) {
        Set set;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (f10109c) {
            if (string != null) {
                try {
                    if (!string.equals(f10110d)) {
                        String[] strArrSplit = string.split(":", -1);
                        HashSet hashSet = new HashSet(strArrSplit.length);
                        for (String str : strArrSplit) {
                            ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(str);
                            if (componentNameUnflattenFromString != null) {
                                hashSet.add(componentNameUnflattenFromString.getPackageName());
                            }
                        }
                        f10111e = hashSet;
                        f10110d = string;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            set = f10111e;
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
        this.f10115b.cancel(str, i10);
        if (Build.VERSION.SDK_INT <= 19) {
            j(new a(this.f10114a.getPackageName(), i10, str));
        }
    }

    public void c(NotificationChannelGroup notificationChannelGroup) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f10115b.createNotificationChannelGroup(notificationChannelGroup);
        }
    }

    public void d(List list) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f10115b.createNotificationChannels(list);
        }
    }

    public void e(String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f10115b.deleteNotificationChannel(str);
        }
    }

    public void h(int i10, Notification notification) {
        i(null, i10, notification);
    }

    public void i(String str, int i10, Notification notification) {
        if (!k(notification)) {
            this.f10115b.notify(str, i10, notification);
        } else {
            j(new b(this.f10114a.getPackageName(), i10, str, notification));
            this.f10115b.cancel(str, i10);
        }
    }

    public final void j(e eVar) {
        synchronized (f10112f) {
            try {
                if (f10113g == null) {
                    f10113g = new d(this.f10114a.getApplicationContext());
                }
                f10113g.h(eVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
