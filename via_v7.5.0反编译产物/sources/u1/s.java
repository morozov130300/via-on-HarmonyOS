package u1;

import android.app.PendingIntent;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class s extends c2.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f12804a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(a aVar, Looper looper) {
        super(looper);
        this.f12804a = aVar;
    }

    public static final void a(Message message) {
        t tVar = (t) message.obj;
        tVar.b();
        tVar.e();
    }

    public static final boolean b(Message message) {
        int i10 = message.what;
        return i10 == 2 || i10 == 1 || i10 == 7;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (this.f12804a.C.get() != message.arg1) {
            if (b(message)) {
                a(message);
                return;
            }
            return;
        }
        int i10 = message.what;
        if ((i10 == 1 || i10 == 7 || ((i10 == 4 && !this.f12804a.f()) || message.what == 5)) && !this.f12804a.w()) {
            a(message);
            return;
        }
        int i11 = message.what;
        if (i11 == 4) {
            this.f12804a.f12757z = new ConnectionResult(message.arg2);
            if (a.U(this.f12804a)) {
                a aVar = this.f12804a;
                if (!aVar.A) {
                    aVar.V(3, null);
                    return;
                }
            }
            a aVar2 = this.f12804a;
            ConnectionResult connectionResult = aVar2.f12757z != null ? aVar2.f12757z : new ConnectionResult(8);
            this.f12804a.f12747p.a(connectionResult);
            this.f12804a.y(connectionResult);
            return;
        }
        if (i11 == 5) {
            a aVar3 = this.f12804a;
            ConnectionResult connectionResult2 = aVar3.f12757z != null ? aVar3.f12757z : new ConnectionResult(8);
            this.f12804a.f12747p.a(connectionResult2);
            this.f12804a.y(connectionResult2);
            return;
        }
        if (i11 == 3) {
            Object obj = message.obj;
            ConnectionResult connectionResult3 = new ConnectionResult(message.arg2, obj instanceof PendingIntent ? (PendingIntent) obj : null);
            this.f12804a.f12747p.a(connectionResult3);
            this.f12804a.y(connectionResult3);
            return;
        }
        if (i11 == 6) {
            this.f12804a.V(5, null);
            a aVar4 = this.f12804a;
            if (aVar4.f12752u != null) {
                aVar4.f12752u.a(message.arg2);
            }
            this.f12804a.z(message.arg2);
            a.T(this.f12804a, 5, 1, null);
            return;
        }
        if (i11 == 2 && !this.f12804a.v()) {
            a(message);
            return;
        }
        if (b(message)) {
            ((t) message.obj).c();
            return;
        }
        Log.wtf("GmsClient", "Don't know how to handle message: " + message.what, new Exception());
    }
}
