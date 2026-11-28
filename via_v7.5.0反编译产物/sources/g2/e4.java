package g2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class e4 extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final pa f4724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f4725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f4726c;

    public e4(pa paVar) {
        u1.f.h(paVar);
        this.f4724a = paVar;
    }

    public final void b() {
        this.f4724a.g();
        this.f4724a.f().h();
        if (this.f4725b) {
            return;
        }
        this.f4724a.c().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.f4726c = this.f4724a.X().m();
        this.f4724a.d().v().b("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.f4726c));
        this.f4725b = true;
    }

    public final void c() {
        this.f4724a.g();
        this.f4724a.f().h();
        this.f4724a.f().h();
        if (this.f4725b) {
            this.f4724a.d().v().a("Unregistering connectivity change receiver");
            this.f4725b = false;
            this.f4726c = false;
            try {
                this.f4724a.c().unregisterReceiver(this);
            } catch (IllegalArgumentException e10) {
                this.f4724a.d().r().b("Failed to unregister the network broadcast receiver", e10);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.f4724a.g();
        String action = intent.getAction();
        this.f4724a.d().v().b("NetworkBroadcastReceiver received action", action);
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            this.f4724a.d().w().b("NetworkBroadcastReceiver received unknown action", action);
            return;
        }
        boolean zM = this.f4724a.X().m();
        if (this.f4726c != zM) {
            this.f4726c = zM;
            this.f4724a.f().z(new d4(this, zM));
        }
    }
}
