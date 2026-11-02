package j;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import b.b;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class d extends Service {

    /* renamed from: e, reason: collision with root package name */
    public final k.g f7480e = new k.g();

    /* renamed from: j, reason: collision with root package name */
    public b.a f7481j = new a();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends b.a {
        public a() {
        }

        @Override // b.b
        public boolean B(b.a aVar) {
            return b0(aVar, null);
        }

        @Override // b.b
        public boolean C(b.a aVar, IBinder iBinder, Bundle bundle) {
            return d.this.j(new e(aVar, Z(bundle)), g.a(iBinder), bundle);
        }

        @Override // b.b
        public boolean G(b.a aVar, Uri uri) {
            return d.this.i(new e(aVar, null), uri, null, new Bundle());
        }

        @Override // b.b
        public boolean L(b.a aVar, Bundle bundle) {
            return d.this.c(new e(aVar, Z(bundle)), bundle);
        }

        @Override // b.b
        public boolean N(b.a aVar, int i10, Uri uri, Bundle bundle) {
            return d.this.l(new e(aVar, Z(bundle)), i10, uri, bundle);
        }

        @Override // b.b
        public boolean O(b.a aVar, Bundle bundle) {
            return d.this.k(new e(aVar, Z(bundle)), bundle);
        }

        @Override // b.b
        public boolean R(b.a aVar, Bundle bundle) {
            return b0(aVar, Z(bundle));
        }

        public final PendingIntent Z(Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("android.support.customtabs.extra.SESSION_ID");
            bundle.remove("android.support.customtabs.extra.SESSION_ID");
            return pendingIntent;
        }

        public final Uri a0(Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            return Build.VERSION.SDK_INT >= 33 ? (Uri) j.a.a(bundle, "target_origin", Uri.class) : (Uri) bundle.getParcelable("target_origin");
        }

        public final boolean b0(b.a aVar, PendingIntent pendingIntent) {
            final e eVar = new e(aVar, pendingIntent);
            try {
                IBinder.DeathRecipient deathRecipient = new IBinder.DeathRecipient() { // from class: j.c
                    @Override // android.os.IBinder.DeathRecipient
                    public final void binderDied() {
                        d.this.a(eVar);
                    }
                };
                synchronized (d.this.f7480e) {
                    aVar.asBinder().linkToDeath(deathRecipient, 0);
                    d.this.f7480e.put(aVar.asBinder(), deathRecipient);
                }
                return d.this.e(eVar);
            } catch (RemoteException unused) {
                return false;
            }
        }

        @Override // b.b
        public boolean h(b.a aVar, Uri uri, Bundle bundle) {
            return d.this.i(new e(aVar, Z(bundle)), uri, a0(bundle), bundle);
        }

        @Override // b.b
        public int k(b.a aVar, String str, Bundle bundle) {
            return d.this.f(new e(aVar, Z(bundle)), str, bundle);
        }

        @Override // b.b
        public Bundle u(String str, Bundle bundle) {
            return d.this.b(str, bundle);
        }

        @Override // b.b
        public boolean v(b.a aVar, Uri uri, Bundle bundle, List list) {
            return d.this.d(new e(aVar, Z(bundle)), uri, bundle, list);
        }

        @Override // b.b
        public boolean x(b.a aVar, Uri uri, int i10, Bundle bundle) {
            return d.this.g(new e(aVar, Z(bundle)), uri, i10, bundle);
        }

        @Override // b.b
        public boolean z(long j10) {
            return d.this.m(j10);
        }
    }

    public boolean a(e eVar) {
        try {
            synchronized (this.f7480e) {
                try {
                    IBinder iBinderA = eVar.a();
                    if (iBinderA == null) {
                        return false;
                    }
                    iBinderA.unlinkToDeath((IBinder.DeathRecipient) this.f7480e.get(iBinderA), 0);
                    this.f7480e.remove(iBinderA);
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (NoSuchElementException unused) {
            return false;
        }
    }

    public abstract Bundle b(String str, Bundle bundle);

    public boolean c(e eVar, Bundle bundle) {
        return false;
    }

    public abstract boolean d(e eVar, Uri uri, Bundle bundle, List list);

    public abstract boolean e(e eVar);

    public abstract int f(e eVar, String str, Bundle bundle);

    public abstract boolean g(e eVar, Uri uri, int i10, Bundle bundle);

    public abstract boolean h(e eVar, Uri uri);

    public boolean i(e eVar, Uri uri, Uri uri2, Bundle bundle) {
        return h(eVar, uri);
    }

    public boolean j(e eVar, f fVar, Bundle bundle) {
        return false;
    }

    public abstract boolean k(e eVar, Bundle bundle);

    public abstract boolean l(e eVar, int i10, Uri uri, Bundle bundle);

    public abstract boolean m(long j10);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f7481j;
    }
}
