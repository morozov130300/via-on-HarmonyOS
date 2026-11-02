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
import n.h;
import org.simpleframework.xml.strategy.Name;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class d {

    /* renamed from: d, reason: collision with root package name */
    public static final int f9870d;

    /* renamed from: e, reason: collision with root package name */
    public static volatile d f9871e;

    /* renamed from: a, reason: collision with root package name */
    public final Context f9872a;

    /* renamed from: b, reason: collision with root package name */
    public final n.x0 f9873b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f9874c;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f9875a;

        /* renamed from: b, reason: collision with root package name */
        public final long f9876b;

        /* renamed from: c, reason: collision with root package name */
        public long f9877c = System.currentTimeMillis();

        /* renamed from: d, reason: collision with root package name */
        public long f9878d = SystemClock.elapsedRealtime();

        /* renamed from: e, reason: collision with root package name */
        public int f9879e;

        public a(long j10) {
            this.f9876b = j10;
            this.f9875a = e(j10);
        }

        public long a() {
            return this.f9877c;
        }

        public long b() {
            return this.f9878d;
        }

        public int c() {
            return this.f9875a;
        }

        public int d() {
            return this.f9879e;
        }

        public final int e(long j10) {
            return (int) (j10 ^ (j10 >>> 32));
        }

        public void f(long j10) {
            this.f9878d = j10;
        }

        public void g(int i10) {
            this.f9879e = i10;
        }
    }

    static {
        f9870d = Build.VERSION.SDK_INT >= 23 ? 201326592 : 134217728;
    }

    public d(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f9872a = applicationContext;
        this.f9873b = n.x0.f(applicationContext);
        this.f9874c = new HashMap();
    }

    public static d e(Context context) {
        if (f9871e == null) {
            synchronized (d.class) {
                try {
                    if (f9871e == null) {
                        f9871e = new d(context);
                    }
                } finally {
                }
            }
        }
        return f9871e;
    }

    public final String a(Context context, g5.c cVar) {
        if (cVar.r() <= 0 || cVar.p() <= 0) {
            return context.getString(x7.u.Q3);
        }
        int iR = (int) ((cVar.r() - cVar.c()) / cVar.p());
        if (iR <= 60) {
            return context.getResources().getQuantityString(x7.t.f13898f, iR, Integer.valueOf(iR));
        }
        int i10 = iR / 60;
        if (i10 <= 120) {
            return context.getResources().getQuantityString(x7.t.f13896d, i10, Integer.valueOf(i10));
        }
        int i11 = i10 / 60;
        return i11 <= 12 ? context.getResources().getQuantityString(x7.t.f13894b, i11, Integer.valueOf(i11)) : context.getString(x7.u.Q3);
    }

    public void b(long j10) {
        a aVar = (a) this.f9874c.remove(Long.valueOf(j10));
        if (aVar == null) {
            return;
        }
        pc.a.a("cancel notification: %d", Long.valueOf(j10));
        this.f9873b.a(aVar.c());
    }

    public final String c(Context context, long j10) {
        return z8.b0.w(context, j10);
    }

    public final String d(Context context, String str) {
        return (str == null || str.isEmpty()) ? context.getString(x7.u.R3) : context.getString(x7.u.S3, str);
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
        this.f9873b.c(new NotificationChannelGroup("mark.via.GENERAL_GROUP", this.f9872a.getString(x7.u.rc)));
        this.f9873b.e("mark.via.DOWNLOAD_FORGROUND");
        ArrayList arrayList = new ArrayList();
        NotificationChannel notificationChannel = new NotificationChannel("mark.via.FORGROUND", this.f9872a.getString(x7.u.X8), 2);
        notificationChannel.setShowBadge(false);
        arrayList.add(notificationChannel);
        NotificationChannel notificationChannel2 = new NotificationChannel("mark.via.DOWNLOAD", this.f9872a.getString(x7.u.W8), 2);
        notificationChannel2.setGroup("mark.via.GENERAL_GROUP");
        arrayList.add(notificationChannel2);
        this.f9873b.d(arrayList);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void h(g5.c cVar) {
        String str;
        g5.c cVar2;
        long j10;
        char c10;
        char c11;
        String string;
        String string2;
        String string3;
        a aVar = (a) this.f9874c.get(Long.valueOf(cVar.j()));
        int iF = f(cVar.q());
        if (aVar == null || iF != aVar.d() || SystemClock.elapsedRealtime() - aVar.b() >= 1000) {
            if (aVar == null) {
                aVar = new a(cVar.j());
                this.f9874c.put(Long.valueOf(cVar.j()), aVar);
            }
            aVar.g(iF);
            aVar.f(SystemClock.elapsedRealtime());
            h.d dVar = new h.d(this.f9872a, "mark.via.DOWNLOAD");
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
            str = "status";
            if (zE || zB) {
                cVar2 = cVar;
                dVar.h(zE ? this.f9872a.getString(x7.u.P3) : d(this.f9872a, cVar2.d()));
                dVar.n(zE ? R.drawable.stat_sys_download_done : x7.o.f13761r1);
                dVar.f(zE ? "status" : "err");
            } else {
                if (cVar.r() <= 0) {
                    Context context = this.f9872a;
                    j10 = 0;
                    string = context.getString(x7.u.f13947d4, c(context, cVar.c()));
                    c10 = 1;
                    c11 = 0;
                } else {
                    j10 = 0;
                    Context context2 = this.f9872a;
                    c10 = 1;
                    c11 = 0;
                    string = context2.getString(x7.u.f13933c4, c(context2, cVar.c()), c(this.f9872a, cVar.r()));
                }
                if (zC) {
                    Context context3 = this.f9872a;
                    int i10 = x7.u.f13989g4;
                    String string4 = context3.getString(x7.u.f14017i4);
                    Object[] objArr = new Object[2];
                    objArr[c11] = string;
                    objArr[c10] = string4;
                    string3 = context3.getString(i10, objArr);
                } else if (zF) {
                    Context context4 = this.f9872a;
                    int i11 = x7.u.f13989g4;
                    String string5 = context4.getString(x7.u.f14031j4);
                    Object[] objArr2 = new Object[2];
                    objArr2[c11] = string;
                    objArr2[c10] = string5;
                    string3 = context4.getString(i11, objArr2);
                } else {
                    if (cVar.p() <= j10) {
                        string2 = this.f9872a.getString(x7.u.f14003h4);
                    } else {
                        string2 = c(this.f9872a, cVar.p()) + "/s";
                    }
                    if (cVar.r() > j10) {
                        cVar2 = cVar;
                        String strA = a(this.f9872a, cVar2);
                        Context context5 = this.f9872a;
                        int i12 = x7.u.f13975f4;
                        Object[] objArr3 = new Object[3];
                        objArr3[c11] = string;
                        objArr3[c10] = string2;
                        objArr3[2] = strA;
                        string3 = context5.getString(i12, objArr3);
                    } else {
                        cVar2 = cVar;
                        Context context6 = this.f9872a;
                        int i13 = x7.u.f13961e4;
                        Object[] objArr4 = new Object[2];
                        objArr4[c11] = string;
                        objArr4[c10] = string2;
                        string3 = context6.getString(i13, objArr4);
                    }
                    dVar.h(string3);
                    dVar.o(new h.b().h(string3));
                    if (cVar2.r() <= j10) {
                        dVar.l(100, (int) ((cVar2.c() / cVar2.r()) * 100.0f), false);
                    } else {
                        dVar.l(100, 50, true);
                    }
                    dVar.n((zD || zF) ? x7.o.f13764s1 : R.drawable.stat_sys_download);
                    if (zD && !zF) {
                        str = "progress";
                    }
                    dVar.f(str);
                    Intent intent = new Intent(this.f9872a, (Class<?>) DownloadReceiver.class);
                    intent.setAction(!zD ? "mark.via.receiver.DownloadReceiver.PAUSE" : "mark.via.receiver.DownloadReceiver.RESUME");
                    intent.putExtra(Name.MARK, cVar2.j());
                    dVar.a(new h.a.C0099a(!zD ? x7.o.f13764s1 : x7.o.f13767t1, this.f9872a.getString(!zD ? x7.u.N3 : x7.u.O3), PendingIntent.getBroadcast(this.f9872a, 0, intent, f9870d)).a());
                }
                cVar2 = cVar;
                dVar.h(string3);
                dVar.o(new h.b().h(string3));
                if (cVar2.r() <= j10) {
                }
                if (zD) {
                    dVar.n((zD || zF) ? x7.o.f13764s1 : R.drawable.stat_sys_download);
                    if (zD) {
                        str = "progress";
                    }
                    dVar.f(str);
                    Intent intent2 = new Intent(this.f9872a, (Class<?>) DownloadReceiver.class);
                    intent2.setAction(!zD ? "mark.via.receiver.DownloadReceiver.PAUSE" : "mark.via.receiver.DownloadReceiver.RESUME");
                    intent2.putExtra(Name.MARK, cVar2.j());
                    dVar.a(new h.a.C0099a(!zD ? x7.o.f13764s1 : x7.o.f13767t1, this.f9872a.getString(!zD ? x7.u.N3 : x7.u.O3), PendingIntent.getBroadcast(this.f9872a, 0, intent2, f9870d)).a());
                }
            }
            if (zE) {
                dVar.g(PendingIntent.getActivity(this.f9872a, 0, z8.f1.b(cVar2), f9870d));
            } else {
                Intent intent3 = new Intent(this.f9872a, (Class<?>) Shell.class);
                intent3.setAction("mark.via.DOWNLOADER");
                intent3.setPackage(this.f9872a.getPackageName());
                dVar.g(PendingIntent.getActivity(this.f9872a, 0, intent3, f9870d));
            }
            if (zE || zB) {
                this.f9873b.a(aVar.c());
            }
            this.f9873b.h(aVar.c(), dVar.b());
        }
    }
}
