package n;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class h {

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final Bundle f10045a;

        /* renamed from: b, reason: collision with root package name */
        public IconCompat f10046b;

        /* renamed from: c, reason: collision with root package name */
        public final c1[] f10047c;

        /* renamed from: d, reason: collision with root package name */
        public final c1[] f10048d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f10049e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f10050f;

        /* renamed from: g, reason: collision with root package name */
        public final int f10051g;

        /* renamed from: h, reason: collision with root package name */
        public final boolean f10052h;

        /* renamed from: i, reason: collision with root package name */
        public int f10053i;

        /* renamed from: j, reason: collision with root package name */
        public CharSequence f10054j;

        /* renamed from: k, reason: collision with root package name */
        public PendingIntent f10055k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f10056l;

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        /* renamed from: n.h$a$a, reason: collision with other inner class name */
        public static final class C0099a {

            /* renamed from: a, reason: collision with root package name */
            public final IconCompat f10057a;

            /* renamed from: b, reason: collision with root package name */
            public final CharSequence f10058b;

            /* renamed from: c, reason: collision with root package name */
            public final PendingIntent f10059c;

            /* renamed from: d, reason: collision with root package name */
            public boolean f10060d;

            /* renamed from: e, reason: collision with root package name */
            public final Bundle f10061e;

            /* renamed from: f, reason: collision with root package name */
            public ArrayList f10062f;

            /* renamed from: g, reason: collision with root package name */
            public int f10063g;

            /* renamed from: h, reason: collision with root package name */
            public boolean f10064h;

            /* renamed from: i, reason: collision with root package name */
            public boolean f10065i;

            /* renamed from: j, reason: collision with root package name */
            public boolean f10066j;

            public C0099a(int i10, CharSequence charSequence, PendingIntent pendingIntent) {
                this(i10 != 0 ? IconCompat.g(null, "", i10) : null, charSequence, pendingIntent, new Bundle(), null, true, 0, true, false, false);
            }

            public C0099a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, c1[] c1VarArr, boolean z10, int i10, boolean z11, boolean z12, boolean z13) {
                this.f10060d = true;
                this.f10064h = true;
                this.f10057a = iconCompat;
                this.f10058b = d.d(charSequence);
                this.f10059c = pendingIntent;
                this.f10061e = bundle;
                this.f10062f = c1VarArr == null ? null : new ArrayList(Arrays.asList(c1VarArr));
                this.f10060d = z10;
                this.f10063g = i10;
                this.f10064h = z11;
                this.f10065i = z12;
                this.f10066j = z13;
            }

            public a a() {
                b();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = this.f10062f;
                if (arrayList3 != null) {
                    Iterator it = arrayList3.iterator();
                    if (it.hasNext()) {
                        g.a(it.next());
                        throw null;
                    }
                }
                return new a(this.f10057a, this.f10058b, this.f10059c, this.f10061e, arrayList2.isEmpty() ? null : (c1[]) arrayList2.toArray(new c1[arrayList2.size()]), arrayList.isEmpty() ? null : (c1[]) arrayList.toArray(new c1[arrayList.size()]), this.f10060d, this.f10063g, this.f10064h, this.f10065i, this.f10066j);
            }

            public final void b() {
                if (this.f10065i && this.f10059c == null) {
                    throw new NullPointerException("Contextual Actions must contain a valid PendingIntent");
                }
            }
        }

        public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, c1[] c1VarArr, c1[] c1VarArr2, boolean z10, int i10, boolean z11, boolean z12, boolean z13) {
            this.f10050f = true;
            this.f10046b = iconCompat;
            if (iconCompat != null && iconCompat.k() == 2) {
                this.f10053i = iconCompat.h();
            }
            this.f10054j = d.d(charSequence);
            this.f10055k = pendingIntent;
            this.f10045a = bundle == null ? new Bundle() : bundle;
            this.f10047c = c1VarArr;
            this.f10048d = c1VarArr2;
            this.f10049e = z10;
            this.f10051g = i10;
            this.f10050f = z11;
            this.f10052h = z12;
            this.f10056l = z13;
        }

        public PendingIntent a() {
            return this.f10055k;
        }

        public boolean b() {
            return this.f10049e;
        }

        public c1[] c() {
            return this.f10048d;
        }

        public Bundle d() {
            return this.f10045a;
        }

        public IconCompat e() {
            int i10;
            if (this.f10046b == null && (i10 = this.f10053i) != 0) {
                this.f10046b = IconCompat.g(null, "", i10);
            }
            return this.f10046b;
        }

        public c1[] f() {
            return this.f10047c;
        }

        public int g() {
            return this.f10051g;
        }

        public boolean h() {
            return this.f10050f;
        }

        public CharSequence i() {
            return this.f10054j;
        }

        public boolean j() {
            return this.f10056l;
        }

        public boolean k() {
            return this.f10052h;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class b extends e {

        /* renamed from: e, reason: collision with root package name */
        public CharSequence f10067e;

        @Override // n.h.e
        public void a(Bundle bundle) {
            super.a(bundle);
            if (Build.VERSION.SDK_INT < 21) {
                bundle.putCharSequence("android.bigText", this.f10067e);
            }
        }

        @Override // n.h.e
        public void b(f fVar) {
            Notification.BigTextStyle bigTextStyleBigText = new Notification.BigTextStyle(fVar.a()).setBigContentTitle(this.f10095b).bigText(this.f10067e);
            if (this.f10097d) {
                bigTextStyleBigText.setSummaryText(this.f10096c);
            }
        }

        @Override // n.h.e
        public String c() {
            return "androidx.core.app.NotificationCompat$BigTextStyle";
        }

        public b h(CharSequence charSequence) {
            this.f10067e = d.d(charSequence);
            return this;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class c {
        public static Notification.BubbleMetadata a(c cVar) {
            return null;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class d {
        public boolean A;
        public boolean B;
        public String C;
        public Bundle D;
        public Notification G;
        public RemoteViews H;
        public RemoteViews I;
        public RemoteViews J;
        public String K;
        public String M;
        public o.l N;
        public long O;
        public boolean R;
        public Notification S;
        public boolean T;
        public Icon U;
        public ArrayList V;

        /* renamed from: a, reason: collision with root package name */
        public Context f10068a;

        /* renamed from: e, reason: collision with root package name */
        public CharSequence f10072e;

        /* renamed from: f, reason: collision with root package name */
        public CharSequence f10073f;

        /* renamed from: g, reason: collision with root package name */
        public PendingIntent f10074g;

        /* renamed from: h, reason: collision with root package name */
        public PendingIntent f10075h;

        /* renamed from: i, reason: collision with root package name */
        public RemoteViews f10076i;

        /* renamed from: j, reason: collision with root package name */
        public Bitmap f10077j;

        /* renamed from: k, reason: collision with root package name */
        public CharSequence f10078k;

        /* renamed from: l, reason: collision with root package name */
        public int f10079l;

        /* renamed from: m, reason: collision with root package name */
        public int f10080m;

        /* renamed from: o, reason: collision with root package name */
        public boolean f10082o;

        /* renamed from: p, reason: collision with root package name */
        public e f10083p;

        /* renamed from: q, reason: collision with root package name */
        public CharSequence f10084q;

        /* renamed from: r, reason: collision with root package name */
        public CharSequence f10085r;

        /* renamed from: s, reason: collision with root package name */
        public CharSequence[] f10086s;

        /* renamed from: t, reason: collision with root package name */
        public int f10087t;

        /* renamed from: u, reason: collision with root package name */
        public int f10088u;

        /* renamed from: v, reason: collision with root package name */
        public boolean f10089v;

        /* renamed from: w, reason: collision with root package name */
        public String f10090w;

        /* renamed from: x, reason: collision with root package name */
        public boolean f10091x;

        /* renamed from: y, reason: collision with root package name */
        public String f10092y;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList f10069b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        public ArrayList f10070c = new ArrayList();

        /* renamed from: d, reason: collision with root package name */
        public ArrayList f10071d = new ArrayList();

        /* renamed from: n, reason: collision with root package name */
        public boolean f10081n = true;

        /* renamed from: z, reason: collision with root package name */
        public boolean f10093z = false;
        public int E = 0;
        public int F = 0;
        public int L = 0;
        public int P = 0;
        public int Q = 0;

        public d(Context context, String str) {
            Notification notification = new Notification();
            this.S = notification;
            this.f10068a = context;
            this.K = str;
            notification.when = System.currentTimeMillis();
            this.S.audioStreamType = -1;
            this.f10080m = 0;
            this.V = new ArrayList();
            this.R = true;
        }

        public static CharSequence d(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        public d a(a aVar) {
            if (aVar != null) {
                this.f10069b.add(aVar);
            }
            return this;
        }

        public Notification b() {
            return new s0(this).c();
        }

        public Bundle c() {
            if (this.D == null) {
                this.D = new Bundle();
            }
            return this.D;
        }

        public d e(boolean z10) {
            j(16, z10);
            return this;
        }

        public d f(String str) {
            this.C = str;
            return this;
        }

        public d g(PendingIntent pendingIntent) {
            this.f10074g = pendingIntent;
            return this;
        }

        public d h(CharSequence charSequence) {
            this.f10073f = d(charSequence);
            return this;
        }

        public d i(CharSequence charSequence) {
            this.f10072e = d(charSequence);
            return this;
        }

        public final void j(int i10, boolean z10) {
            if (z10) {
                Notification notification = this.S;
                notification.flags = i10 | notification.flags;
            } else {
                Notification notification2 = this.S;
                notification2.flags = (i10 ^ (-1)) & notification2.flags;
            }
        }

        public d k(boolean z10) {
            j(2, z10);
            return this;
        }

        public d l(int i10, int i11, boolean z10) {
            this.f10087t = i10;
            this.f10088u = i11;
            this.f10089v = z10;
            return this;
        }

        public d m(boolean z10) {
            this.T = z10;
            return this;
        }

        public d n(int i10) {
            this.S.icon = i10;
            return this;
        }

        public d o(e eVar) {
            if (this.f10083p != eVar) {
                this.f10083p = eVar;
                if (eVar != null) {
                    eVar.g(this);
                }
            }
            return this;
        }

        public d p(long j10) {
            this.S.when = j10;
            return this;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static abstract class e {

        /* renamed from: a, reason: collision with root package name */
        public d f10094a;

        /* renamed from: b, reason: collision with root package name */
        public CharSequence f10095b;

        /* renamed from: c, reason: collision with root package name */
        public CharSequence f10096c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f10097d = false;

        public void a(Bundle bundle) {
            if (this.f10097d) {
                bundle.putCharSequence("android.summaryText", this.f10096c);
            }
            CharSequence charSequence = this.f10095b;
            if (charSequence != null) {
                bundle.putCharSequence("android.title.big", charSequence);
            }
            String strC = c();
            if (strC != null) {
                bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", strC);
            }
        }

        public abstract void b(f fVar);

        public abstract String c();

        public RemoteViews d(f fVar) {
            return null;
        }

        public RemoteViews e(f fVar) {
            return null;
        }

        public RemoteViews f(f fVar) {
            return null;
        }

        public void g(d dVar) {
            if (this.f10094a != dVar) {
                this.f10094a = dVar;
                if (dVar != null) {
                    dVar.o(this);
                }
            }
        }
    }

    public static Bundle a(Notification notification) {
        return notification.extras;
    }
}
