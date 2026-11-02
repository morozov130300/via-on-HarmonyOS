package j;

import android.app.PendingIntent;
import android.os.IBinder;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final b.a f7483a;

    /* renamed from: b, reason: collision with root package name */
    public final PendingIntent f7484b;

    /* renamed from: c, reason: collision with root package name */
    public final b f7485c;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends b {
        public a() {
        }
    }

    public e(b.a aVar, PendingIntent pendingIntent) {
        if (aVar == null && pendingIntent == null) {
            throw new IllegalStateException("CustomTabsSessionToken must have either a session id or a callback (or both).");
        }
        this.f7483a = aVar;
        this.f7484b = pendingIntent;
        this.f7485c = aVar == null ? null : new a();
    }

    public IBinder a() {
        b.a aVar = this.f7483a;
        if (aVar == null) {
            return null;
        }
        return aVar.asBinder();
    }

    public final IBinder b() {
        b.a aVar = this.f7483a;
        if (aVar != null) {
            return aVar.asBinder();
        }
        throw new IllegalStateException("CustomTabSessionToken must have valid binder or pending session");
    }

    public PendingIntent c() {
        return this.f7484b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        PendingIntent pendingIntentC = eVar.c();
        PendingIntent pendingIntent = this.f7484b;
        if ((pendingIntent == null) != (pendingIntentC == null)) {
            return false;
        }
        return pendingIntent != null ? pendingIntent.equals(pendingIntentC) : b().equals(eVar.b());
    }

    public int hashCode() {
        PendingIntent pendingIntent = this.f7484b;
        return pendingIntent != null ? pendingIntent.hashCode() : b().hashCode();
    }
}
