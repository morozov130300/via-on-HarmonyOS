package com.google.firebase.concurrent;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Logger;
import t1.f;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class SequentialExecutor implements Executor {

    /* renamed from: n, reason: collision with root package name */
    public static final Logger f4000n = Logger.getLogger(SequentialExecutor.class.getName());

    /* renamed from: e, reason: collision with root package name */
    public final Executor f4001e;

    /* renamed from: j, reason: collision with root package name */
    public final Deque f4002j = new ArrayDeque();

    /* renamed from: k, reason: collision with root package name */
    public WorkerRunningState f4003k = WorkerRunningState.IDLE;

    /* renamed from: l, reason: collision with root package name */
    public long f4004l = 0;

    /* renamed from: m, reason: collision with root package name */
    public final b f4005m = new b(this, null);

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public enum WorkerRunningState {
        IDLE,
        QUEUING,
        QUEUED,
        RUNNING
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Runnable f4007e;

        public a(Runnable runnable) {
            this.f4007e = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4007e.run();
        }

        public String toString() {
            return this.f4007e.toString();
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public final class b implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        public Runnable f4009e;

        public b() {
        }

        public /* synthetic */ b(SequentialExecutor sequentialExecutor, a aVar) {
            this();
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0045, code lost:
        
            if (r1 == false) goto L52;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x004e, code lost:
        
            r1 = r1 | java.lang.Thread.interrupted();
            r2 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0050, code lost:
        
            r8.f4009e.run();
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x005a, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x005c, code lost:
        
            r3 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x005d, code lost:
        
            com.google.firebase.concurrent.SequentialExecutor.f4000n.log(java.util.logging.Level.SEVERE, "Exception while executing runnable " + r8.f4009e, (java.lang.Throwable) r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x007a, code lost:
        
            r8.f4009e = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x007c, code lost:
        
            throw r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:?, code lost:
        
            return;
         */
        /* JADX WARN: Removed duplicated region for block: B:48:0x003d A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void a() {
            Runnable runnable;
            boolean z10 = false;
            boolean zInterrupted = false;
            while (true) {
                try {
                    synchronized (SequentialExecutor.this.f4002j) {
                        if (z10) {
                            runnable = (Runnable) SequentialExecutor.this.f4002j.poll();
                            this.f4009e = runnable;
                            if (runnable != null) {
                            }
                        } else {
                            WorkerRunningState workerRunningState = SequentialExecutor.this.f4003k;
                            WorkerRunningState workerRunningState2 = WorkerRunningState.RUNNING;
                            if (workerRunningState != workerRunningState2) {
                                SequentialExecutor.f(SequentialExecutor.this);
                                SequentialExecutor.this.f4003k = workerRunningState2;
                                z10 = true;
                                runnable = (Runnable) SequentialExecutor.this.f4002j.poll();
                                this.f4009e = runnable;
                                if (runnable != null) {
                                    SequentialExecutor.this.f4003k = WorkerRunningState.IDLE;
                                }
                            }
                        }
                    }
                    if (!zInterrupted) {
                        return;
                    }
                } finally {
                    if (zInterrupted) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a();
            } catch (Error e10) {
                synchronized (SequentialExecutor.this.f4002j) {
                    SequentialExecutor.this.f4003k = WorkerRunningState.IDLE;
                    throw e10;
                }
            }
        }

        public String toString() {
            Runnable runnable = this.f4009e;
            if (runnable != null) {
                return "SequentialExecutorWorker{running=" + runnable + "}";
            }
            return "SequentialExecutorWorker{state=" + SequentialExecutor.this.f4003k + "}";
        }
    }

    public SequentialExecutor(Executor executor) {
        this.f4001e = (Executor) f.h(executor);
    }

    public static /* synthetic */ long f(SequentialExecutor sequentialExecutor) {
        long j10 = sequentialExecutor.f4004l;
        sequentialExecutor.f4004l = 1 + j10;
        return j10;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0061  */
    @Override // java.util.concurrent.Executor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void execute(Runnable runnable) {
        WorkerRunningState workerRunningState;
        boolean z10;
        f.h(runnable);
        synchronized (this.f4002j) {
            WorkerRunningState workerRunningState2 = this.f4003k;
            if (workerRunningState2 != WorkerRunningState.RUNNING && workerRunningState2 != (workerRunningState = WorkerRunningState.QUEUED)) {
                long j10 = this.f4004l;
                a aVar = new a(runnable);
                this.f4002j.add(aVar);
                WorkerRunningState workerRunningState3 = WorkerRunningState.QUEUING;
                this.f4003k = workerRunningState3;
                try {
                    this.f4001e.execute(this.f4005m);
                    if (this.f4003k != workerRunningState3) {
                        return;
                    }
                    synchronized (this.f4002j) {
                        try {
                            if (this.f4004l == j10 && this.f4003k == workerRunningState3) {
                                this.f4003k = workerRunningState;
                            }
                        } finally {
                        }
                    }
                    return;
                } catch (Error | RuntimeException e10) {
                    synchronized (this.f4002j) {
                        try {
                            WorkerRunningState workerRunningState4 = this.f4003k;
                            if (workerRunningState4 == WorkerRunningState.IDLE || workerRunningState4 == WorkerRunningState.QUEUING) {
                                z10 = this.f4002j.removeLastOccurrence(aVar);
                            }
                            if (!(e10 instanceof RejectedExecutionException) || z10) {
                                throw e10;
                            }
                        } finally {
                        }
                    }
                    return;
                }
            }
            this.f4002j.add(runnable);
        }
    }

    public String toString() {
        return "SequentialExecutor@" + System.identityHashCode(this) + "{" + this.f4001e + "}";
    }
}
