package ab;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: ab.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class C0005b extends BroadcastReceiver implements ab.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ab.a.InterfaceC0004a f288a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f289b;

        public C0005b() {
        }

        @Override // ab.a
        public void a(Context context) {
            if (this.f289b) {
                return;
            }
            this.f289b = true;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            context.registerReceiver(this, intentFilter);
        }

        @Override // ab.a
        public void b(Context context) {
            if (this.f289b) {
                this.f289b = false;
                context.unregisterReceiver(this);
            }
        }

        @Override // ab.a
        public void c(ab.a.InterfaceC0004a interfaceC0004a) {
            this.f288a = interfaceC0004a;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ab.a.InterfaceC0004a interfaceC0004a = this.f288a;
            if (interfaceC0004a == null) {
                return;
            }
            interfaceC0004a.a();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class c extends ConnectivityManager.NetworkCallback implements ab.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ab.a.InterfaceC0004a f290a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f291b;

        @Override // ab.a
        public void a(Context context) {
            if (this.f291b) {
                return;
            }
            this.f291b = true;
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            if (Build.VERSION.SDK_INT >= 24) {
                connectivityManager.registerDefaultNetworkCallback(this);
            } else {
                connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().build(), this);
            }
        }

        @Override // ab.a
        public void b(Context context) {
            if (this.f291b) {
                this.f291b = false;
                ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).unregisterNetworkCallback(this);
            }
        }

        @Override // ab.a
        public void c(ab.a.InterfaceC0004a interfaceC0004a) {
            this.f290a = interfaceC0004a;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            super.onAvailable(network);
            ab.a.InterfaceC0004a interfaceC0004a = this.f290a;
            if (interfaceC0004a != null) {
                interfaceC0004a.a();
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            super.onLost(network);
            ab.a.InterfaceC0004a interfaceC0004a = this.f290a;
            if (interfaceC0004a != null) {
                interfaceC0004a.a();
            }
        }
    }

    public static ab.a a() {
        return Build.VERSION.SDK_INT >= 21 ? new c() : new C0005b();
    }
}
