package j;

import android.app.PendingIntent;
import android.os.IBinder;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b.a f6718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PendingIntent f6719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f6720c;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends b {
        public a() {
        }
    }

    public e(b.a aVar, PendingIntent pendingIntent) {
        if (aVar == null && pendingIntent == null) {
            throw new IllegalStateException("CustomTabsSessionToken must have either a session id or a callback (or both).");
        }
        this.f6718a = aVar;
        this.f6719b = pendingIntent;
        this.f6720c = aVar == null ? null : new a();
    }

    public IBinder a() {
        b.a aVar = this.f6718a;
        if (aVar == null) {
            return null;
        }
        return aVar.asBinder();
    }

    public final IBinder b() {
        b.a aVar = this.f6718a;
        if (aVar != null) {
            return aVar.asBinder();
        }
        throw new IllegalStateException("CustomTabSessionToken must have valid binder or pending session");
    }

    public PendingIntent c() {
        return this.f6719b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        PendingIntent pendingIntentC = eVar.c();
        PendingIntent pendingIntent = this.f6719b;
        if ((pendingIntent == null) != (pendingIntentC == null)) {
            return false;
        }
        return pendingIntent != null ? pendingIntent.equals(pendingIntentC) : b().equals(eVar.b());
    }

    public int hashCode() {
        PendingIntent pendingIntent = this.f6719b;
        return pendingIntent != null ? pendingIntent.hashCode() : b().hashCode();
    }
}
