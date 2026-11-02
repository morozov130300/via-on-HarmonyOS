package ab;

import ab.a;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Build;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class b {

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: ab.b$b, reason: collision with other inner class name */
    public static class C0006b extends BroadcastReceiver implements ab.a {

        /* renamed from: a, reason: collision with root package name */
        public a.InterfaceC0005a f383a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f384b;

        public C0006b() {
        }

        @Override // ab.a
        public void a(Context context) {
            if (this.f384b) {
                return;
            }
            this.f384b = true;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            context.registerReceiver(this, intentFilter);
        }

        @Override // ab.a
        public void b(Context context) {
            if (this.f384b) {
                this.f384b = false;
                context.unregisterReceiver(this);
            }
        }

        @Override // ab.a
        public void c(a.InterfaceC0005a interfaceC0005a) {
            this.f383a = interfaceC0005a;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            a.InterfaceC0005a interfaceC0005a = this.f383a;
            if (interfaceC0005a == null) {
                return;
            }
            interfaceC0005a.a();
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class c extends ConnectivityManager.NetworkCallback implements ab.a {

        /* renamed from: a, reason: collision with root package name */
        public a.InterfaceC0005a f385a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f386b;

        @Override // ab.a
        public void a(Context context) {
            if (this.f386b) {
                return;
            }
            this.f386b = true;
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            if (Build.VERSION.SDK_INT >= 24) {
                connectivityManager.registerDefaultNetworkCallback(this);
            } else {
                connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().build(), this);
            }
        }

        @Override // ab.a
        public void b(Context context) {
            if (this.f386b) {
                this.f386b = false;
                ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).unregisterNetworkCallback(this);
            }
        }

        @Override // ab.a
        public void c(a.InterfaceC0005a interfaceC0005a) {
            this.f385a = interfaceC0005a;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            super.onAvailable(network);
            a.InterfaceC0005a interfaceC0005a = this.f385a;
            if (interfaceC0005a != null) {
                interfaceC0005a.a();
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            super.onLost(network);
            a.InterfaceC0005a interfaceC0005a = this.f385a;
            if (interfaceC0005a != null) {
                interfaceC0005a.a();
            }
        }
    }

    public static ab.a a() {
        return Build.VERSION.SDK_INT >= 21 ? new c() : new C0006b();
    }
}
