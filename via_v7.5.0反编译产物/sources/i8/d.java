package i8;

import android.os.Handler;
import android.os.Looper;
import java.io.FileWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class d extends tc.a.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f6307c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f6308d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f6306b = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Executor f6309e = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f6310f = new ArrayList();

    public d(String str, int i10) {
        this.f6307c = str;
        this.f6308d = i10;
    }

    public static /* synthetic */ void r(d dVar, List list) {
        dVar.getClass();
        try {
            FileWriter fileWriter = new FileWriter(dVar.f6307c, true);
            try {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    fileWriter.append((CharSequence) it.next());
                    fileWriter.append('\n');
                }
                fileWriter.flush();
                fileWriter.close();
            } catch (Throwable th) {
                try {
                    fileWriter.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // tc.a.b
    public void l(int i10, String str, String str2, Throwable th) {
        if (i10 < this.f6308d) {
            return;
        }
        s(u(i10, str, str2));
    }

    public final void s(String str) {
        if (str == null) {
            return;
        }
        this.f6310f.add(str);
        this.f6306b.removeCallbacksAndMessages(null);
        this.f6306b.postDelayed(new Runnable() { // from class: i8.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f6303c.t();
            }
        }, 300L);
    }

    public final void t() {
        final ArrayList arrayList = new ArrayList(this.f6310f);
        this.f6310f.clear();
        this.f6309e.execute(new Runnable() { // from class: i8.c
            @Override // java.lang.Runnable
            public final void run() {
                d.r(this.f6304c, arrayList);
            }
        });
    }

    public final String u(int i10, String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        sb2.append('[');
        sb2.append(timestamp);
        sb2.append(']');
        sb2.append(' ');
        sb2.append(v(i10));
        sb2.append('/');
        if (str == null) {
            str = "";
        }
        sb2.append(str);
        sb2.append('(');
        sb2.append(Thread.currentThread());
        sb2.append(')');
        sb2.append(": ");
        sb2.append(str2);
        return sb2.toString();
    }

    public final String v(int i10) {
        if (i10 == 2) {
            return "V";
        }
        if (i10 == 4) {
            return "I";
        }
        if (i10 == 5) {
            return "W";
        }
        if (i10 != 6) {
            return i10 != 7 ? "D" : "WTF";
        }
        return "E";
    }

    public String w() {
        return this.f6307c;
    }
}
