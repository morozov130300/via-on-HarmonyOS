package mark.via.download;

import android.R;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.HashMap;
import mark.via.Shell;
import mark.via.receiver.DownloadReceiver;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f10249d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile n f10250e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f10251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n.x0 f10252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f10253c;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f10254a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f10255b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f10256c = System.currentTimeMillis();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f10257d = SystemClock.elapsedRealtime();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f10258e;

        public a(long j10) {
            this.f10255b = j10;
            this.f10254a = e(j10);
        }

        public long a() {
            return this.f10256c;
        }

        public long b() {
            return this.f10257d;
        }

        public int c() {
            return this.f10254a;
        }

        public int d() {
            return this.f10258e;
        }

        public final int e(long j10) {
            return (int) (j10 ^ (j10 >>> 32));
        }

        public void f(long j10) {
            this.f10257d = j10;
        }

        public void g(int i10) {
            this.f10258e = i10;
        }
    }

    static {
        f10249d = Build.VERSION.SDK_INT >= 23 ? 201326592 : 134217728;
    }

    public n(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f10251a = applicationContext;
        this.f10252b = n.x0.f(applicationContext);
        this.f10253c = new HashMap();
    }

    public static n e(Context context) {
        if (f10250e == null) {
            synchronized (n.class) {
                try {
                    if (f10250e == null) {
                        f10250e = new n(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f10250e;
    }

    public final String a(Context context, g5.c cVar) {
        if (cVar.r() <= 0 || cVar.p() <= 0) {
            return context.getString(w7.u.f14013d4);
        }
        int iR = (int) ((cVar.r() - cVar.c()) / cVar.p());
        if (iR <= 60) {
            return context.getResources().getQuantityString(w7.t.f13964f, iR, Integer.valueOf(iR));
        }
        int i10 = iR / 60;
        if (i10 <= 120) {
            return context.getResources().getQuantityString(w7.t.f13962d, i10, Integer.valueOf(i10));
        }
        int i11 = i10 / 60;
        return i11 <= 12 ? context.getResources().getQuantityString(w7.t.f13960b, i11, Integer.valueOf(i11)) : context.getString(w7.u.f14013d4);
    }

    public void b(long j10) {
        a aVar = (a) this.f10253c.remove(Long.valueOf(j10));
        if (aVar == null) {
            return;
        }
        tc.a.a("cancel notification: %d", Long.valueOf(j10));
        this.f10252b.a(aVar.c());
    }

    public final String c(Context context, long j10) {
        return x8.z.v(context, j10);
    }

    public final String d(Context context, String str) {
        return (str == null || str.isEmpty()) ? context.getString(w7.u.f14027e4) : context.getString(w7.u.f14041f4, str);
    }

    public final int f(int i10) {
        if (g5.b.e(i10)) {
            return 1;
        }
        if (g5.b.b(i10)) {
            return 2;
        }
        if (g5.b.f(i10)) {
            return 3;
        }
        if (g5.b.d(i10)) {
            return 4;
        }
        return g5.b.c(i10) ? 5 : 0;
    }

    public void g() {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        this.f10252b.c(new NotificationChannelGroup("mark.via.GENERAL_GROUP", this.f10251a.getString(w7.u.Fc)));
        this.f10252b.e("mark.via.DOWNLOAD_FORGROUND");
        ArrayList arrayList = new ArrayList();
        NotificationChannel notificationChannel = new NotificationChannel("mark.via.FORGROUND", this.f10251a.getString(w7.u.f14102j9), 2);
        notificationChannel.setShowBadge(false);
        arrayList.add(notificationChannel);
        NotificationChannel notificationChannel2 = new NotificationChannel("mark.via.DOWNLOAD", this.f10251a.getString(w7.u.f14088i9), 2);
        notificationChannel2.setGroup("mark.via.GENERAL_GROUP");
        arrayList.add(notificationChannel2);
        this.f10252b.d(arrayList);
    }

    /* JADX WARN: Code duplicated, block: B:49:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:50:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:54:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:61:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:62:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:65:0x0202  */
    /* JADX WARN: Code duplicated, block: B:66:0x0205  */
    /* JADX WARN: Code duplicated, block: B:69:0x020b  */
    /* JADX WARN: Code duplicated, block: B:70:0x020e  */
    public void h(g5.c cVar) {
        g5.c cVar2;
        char c10;
        char c11;
        String string;
        String string2;
        String string3;
        int i10;
        String str;
        int i11;
        int i12;
        a aVar = (a) this.f10253c.get(Long.valueOf(cVar.j()));
        int iF = f(cVar.q());
        if (aVar == null || iF != aVar.d() || SystemClock.elapsedRealtime() - aVar.b() >= 1000) {
            if (aVar == null) {
                if (c5.b.r(this.f10251a).h(cVar.j()) == null) {
                    return;
                }
                aVar = new a(cVar.j());
                this.f10253c.put(Long.valueOf(cVar.j()), aVar);
            }
            aVar.g(iF);
            aVar.f(SystemClock.elapsedRealtime());
            n.h.d dVar = new n.h.d(this.f10251a, "mark.via.DOWNLOAD");
            dVar.p(aVar.a());
            int iQ = cVar.q();
            boolean zD = g5.b.d(iQ);
            boolean zF = g5.b.f(iQ);
            boolean zC = g5.b.c(iQ);
            boolean zE = g5.b.e(iQ);
            boolean zB = g5.b.b(iQ);
            dVar.i(cVar.l());
            dVar.k(zD && !zF);
            dVar.e(!zD || zF);
            String str2 = "status";
            if (zE || zB) {
                cVar2 = cVar;
                dVar.h(zE ? this.f10251a.getString(w7.u.f13999c4) : d(this.f10251a, cVar2.d()));
                dVar.n(zE ? R.drawable.stat_sys_download_done : w7.o.f13821p1);
                dVar.f(zE ? "status" : "err");
            } else {
                if (cVar.r() <= 0) {
                    Context context = this.f10251a;
                    string = context.getString(w7.u.f14195q4, c(context, cVar.c()));
                    c10 = 1;
                    c11 = 0;
                } else {
                    Context context2 = this.f10251a;
                    c10 = 1;
                    c11 = 0;
                    string = context2.getString(w7.u.f14181p4, c(context2, cVar.c()), c(this.f10251a, cVar.r()));
                }
                if (zC) {
                    Context context3 = this.f10251a;
                    int i13 = w7.u.f14237t4;
                    String string4 = context3.getString(w7.u.f14264v4);
                    Object[] objArr = new Object[2];
                    objArr[c11] = string;
                    objArr[c10] = string4;
                    string3 = context3.getString(i13, objArr);
                } else {
                    if (zF) {
                        Context context4 = this.f10251a;
                        int i14 = w7.u.f14237t4;
                        String string5 = context4.getString(w7.u.f14277w4);
                        Object[] objArr2 = new Object[2];
                        objArr2[c11] = string;
                        objArr2[c10] = string5;
                        string3 = context4.getString(i14, objArr2);
                    } else {
                        if (cVar.p() <= r14) {
                            string2 = this.f10251a.getString(w7.u.f14251u4);
                        } else {
                            string2 = c(this.f10251a, cVar.p()) + "/s";
                        }
                        if (cVar.r() > r14) {
                            cVar2 = cVar;
                            String strA = a(this.f10251a, cVar2);
                            Context context5 = this.f10251a;
                            int i15 = w7.u.f14223s4;
                            Object[] objArr3 = new Object[3];
                            objArr3[c11] = string;
                            objArr3[c10] = string2;
                            objArr3[2] = strA;
                            string3 = context5.getString(i15, objArr3);
                        } else {
                            cVar2 = cVar;
                            Context context6 = this.f10251a;
                            int i16 = w7.u.f14209r4;
                            Object[] objArr4 = new Object[2];
                            objArr4[c11] = string;
                            objArr4[c10] = string2;
                            string3 = context6.getString(i16, objArr4);
                        }
                    }
                    dVar.h(string3);
                    dVar.o(new n.h.b().h(string3));
                    if (cVar2.r() > 0) {
                        dVar.l(100, (int) ((cVar2.c() / cVar2.r()) * 100.0f), false);
                    } else {
                        dVar.l(100, 50, true);
                    }
                    if (zD || zF) {
                        i10 = w7.o.f13824q1;
                    } else {
                        i10 = R.drawable.stat_sys_download;
                    }
                    dVar.n(i10);
                    if (zD && !zF) {
                        str2 = "progress";
                    }
                    dVar.f(str2);
                    Intent intent = new Intent(this.f10251a, (Class<?>) DownloadReceiver.class);
                    if (zD) {
                        str = "mark.via.receiver.DownloadReceiver.PAUSE";
                    } else {
                        str = "mark.via.receiver.DownloadReceiver.RESUME";
                    }
                    intent.setAction(str);
                    intent.putExtra(Name.MARK, cVar2.j());
                    PendingIntent broadcast = PendingIntent.getBroadcast(this.f10251a, 0, intent, f10249d);
                    if (zD) {
                        i11 = w7.o.f13824q1;
                    } else {
                        i11 = w7.o.f13827r1;
                    }
                    Context context7 = this.f10251a;
                    if (zD) {
                        i12 = w7.u.f13971a4;
                    } else {
                        i12 = w7.u.f13985b4;
                    }
                    dVar.a(new n.h.a.C0100a(i11, context7.getString(i12), broadcast).a());
                }
                cVar2 = cVar;
                dVar.h(string3);
                dVar.o(new n.h.b().h(string3));
                if (cVar2.r() > 0) {
                    dVar.l(100, (int) ((cVar2.c() / cVar2.r()) * 100.0f), false);
                } else {
                    dVar.l(100, 50, true);
                }
                if (zD) {
                    i10 = w7.o.f13824q1;
                } else {
                    i10 = w7.o.f13824q1;
                }
                dVar.n(i10);
                if (zD) {
                    str2 = "progress";
                }
                dVar.f(str2);
                Intent intent2 = new Intent(this.f10251a, (Class<?>) DownloadReceiver.class);
                if (zD) {
                    str = "mark.via.receiver.DownloadReceiver.PAUSE";
                } else {
                    str = "mark.via.receiver.DownloadReceiver.RESUME";
                }
                intent2.setAction(str);
                intent2.putExtra(Name.MARK, cVar2.j());
                PendingIntent broadcast2 = PendingIntent.getBroadcast(this.f10251a, 0, intent2, f10249d);
                if (zD) {
                    i11 = w7.o.f13824q1;
                } else {
                    i11 = w7.o.f13827r1;
                }
                Context context8 = this.f10251a;
                if (zD) {
                    i12 = w7.u.f13971a4;
                } else {
                    i12 = w7.u.f13985b4;
                }
                dVar.a(new n.h.a.C0100a(i11, context8.getString(i12), broadcast2).a());
            }
            if (zE) {
                dVar.g(PendingIntent.getActivity(this.f10251a, 0, x8.e1.b(cVar2), f10249d));
            } else {
                Intent intent3 = new Intent(this.f10251a, (Class<?>) Shell.class);
                intent3.setAction("mark.via.DOWNLOADER");
                intent3.setPackage(this.f10251a.getPackageName());
                dVar.g(PendingIntent.getActivity(this.f10251a, 0, intent3, f10249d));
            }
            if (zE || zB) {
                this.f10252b.a(aVar.c());
            }
            this.f10252b.h(aVar.c(), dVar.b());
        }
    }
}
