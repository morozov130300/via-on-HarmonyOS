package f2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class e4 extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final pa f5108a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f5109b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f5110c;

    public e4(pa paVar) {
        t1.f.h(paVar);
        this.f5108a = paVar;
    }

    public final void b() {
        this.f5108a.g();
        this.f5108a.f().h();
        if (this.f5109b) {
            return;
        }
        this.f5108a.c().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.f5110c = this.f5108a.X().m();
        this.f5108a.d().v().b("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.f5110c));
        this.f5109b = true;
    }

    public final void c() {
        this.f5108a.g();
        this.f5108a.f().h();
        this.f5108a.f().h();
        if (this.f5109b) {
            this.f5108a.d().v().a("Unregistering connectivity change receiver");
            this.f5109b = false;
            this.f5110c = false;
            try {
                this.f5108a.c().unregisterReceiver(this);
            } catch (IllegalArgumentException e10) {
                this.f5108a.d().r().b("Failed to unregister the network broadcast receiver", e10);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.f5108a.g();
        String action = intent.getAction();
        this.f5108a.d().v().b("NetworkBroadcastReceiver received action", action);
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            this.f5108a.d().w().b("NetworkBroadcastReceiver received unknown action", action);
            return;
        }
        boolean zM = this.f5108a.X().m();
        if (this.f5110c != zM) {
            this.f5110c = zM;
            this.f5108a.f().z(new d4(this, zM));
        }
    }
}
