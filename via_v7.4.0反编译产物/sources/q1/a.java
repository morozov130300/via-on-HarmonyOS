package q1;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public boolean f11234a = false;

    /* renamed from: b, reason: collision with root package name */
    public final BlockingQueue f11235b = new LinkedBlockingQueue();

    public IBinder a(long j10, TimeUnit timeUnit) throws TimeoutException {
        t1.f.g("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (this.f11234a) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.f11234a = true;
        IBinder iBinder = (IBinder) this.f11235b.poll(j10, timeUnit);
        if (iBinder != null) {
            return iBinder;
        }
        throw new TimeoutException("Timed out waiting for the service connection");
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f11235b.add(iBinder);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
