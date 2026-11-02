package f2;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class c5 extends Thread {

    /* renamed from: e, reason: collision with root package name */
    public final Object f5067e;

    /* renamed from: j, reason: collision with root package name */
    public final BlockingQueue f5068j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f5069k = false;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ e5 f5070l;

    public c5(e5 e5Var, String str, BlockingQueue blockingQueue) {
        this.f5070l = e5Var;
        t1.f.h(str);
        t1.f.h(blockingQueue);
        this.f5067e = new Object();
        this.f5068j = blockingQueue;
        setName(str);
    }

    public final void a() {
        synchronized (this.f5067e) {
            this.f5067e.notifyAll();
        }
    }

    public final void b() {
        synchronized (this.f5070l.f5118i) {
            try {
                if (!this.f5069k) {
                    this.f5070l.f5119j.release();
                    this.f5070l.f5118i.notifyAll();
                    e5 e5Var = this.f5070l;
                    if (this == e5Var.f5112c) {
                        e5Var.f5112c = null;
                    } else if (this == e5Var.f5113d) {
                        e5Var.f5113d = null;
                    } else {
                        e5Var.f5030a.d().r().a("Current scheduler thread is neither worker nor network");
                    }
                    this.f5069k = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c(InterruptedException interruptedException) {
        this.f5070l.f5030a.d().w().b(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws InterruptedException {
        boolean z10 = false;
        while (!z10) {
            try {
                this.f5070l.f5119j.acquire();
                z10 = true;
            } catch (InterruptedException e10) {
                c(e10);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                b5 b5Var = (b5) this.f5068j.poll();
                if (b5Var != null) {
                    Process.setThreadPriority(true != b5Var.f5051j ? 10 : threadPriority);
                    b5Var.run();
                } else {
                    synchronized (this.f5067e) {
                        if (this.f5068j.peek() == null) {
                            e5.B(this.f5070l);
                            try {
                                this.f5067e.wait(30000L);
                            } catch (InterruptedException e11) {
                                c(e11);
                            }
                        }
                    }
                    synchronized (this.f5070l.f5118i) {
                        if (this.f5068j.peek() == null) {
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
