package g2;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class c5 extends Thread {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f4683c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BlockingQueue f4684e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f4685m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ e5 f4686n;

    public c5(e5 e5Var, String str, BlockingQueue blockingQueue) {
        this.f4686n = e5Var;
        u1.f.h(str);
        u1.f.h(blockingQueue);
        this.f4683c = new Object();
        this.f4684e = blockingQueue;
        setName(str);
    }

    public final void a() {
        synchronized (this.f4683c) {
            this.f4683c.notifyAll();
        }
    }

    public final void b() {
        synchronized (this.f4686n.f4734i) {
            try {
                if (!this.f4685m) {
                    this.f4686n.f4735j.release();
                    this.f4686n.f4734i.notifyAll();
                    e5 e5Var = this.f4686n;
                    if (this == e5Var.f4728c) {
                        e5Var.f4728c = null;
                    } else if (this == e5Var.f4729d) {
                        e5Var.f4729d = null;
                    } else {
                        e5Var.f4646a.d().r().a("Current scheduler thread is neither worker nor network");
                    }
                    this.f4685m = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c(InterruptedException interruptedException) {
        this.f4686n.f4646a.d().w().b(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        boolean z10 = false;
        while (!z10) {
            try {
                this.f4686n.f4735j.acquire();
                z10 = true;
            } catch (InterruptedException e10) {
                c(e10);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                b5 b5Var = (b5) this.f4684e.poll();
                if (b5Var != null) {
                    Process.setThreadPriority(true != b5Var.f4667e ? 10 : threadPriority);
                    b5Var.run();
                } else {
                    synchronized (this.f4683c) {
                        if (this.f4684e.peek() == null) {
                            e5.B(this.f4686n);
                            try {
                                this.f4683c.wait(30000L);
                            } catch (InterruptedException e11) {
                                c(e11);
                            }
                        }
                    }
                    synchronized (this.f4686n.f4734i) {
                        if (this.f4684e.peek() == null) {
                            b();
                            b();
                            return;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            b();
            throw th;
        }
    }
}
