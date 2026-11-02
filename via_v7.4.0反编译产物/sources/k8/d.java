package k8;

import android.os.Handler;
import android.os.Looper;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import pc.a;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class d extends a.b {

    /* renamed from: c, reason: collision with root package name */
    public final String f8196c;

    /* renamed from: d, reason: collision with root package name */
    public final int f8197d;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f8195b = new Handler(Looper.getMainLooper());

    /* renamed from: e, reason: collision with root package name */
    public final Executor f8198e = Executors.newSingleThreadExecutor();

    /* renamed from: f, reason: collision with root package name */
    public final List f8199f = new ArrayList();

    public d(String str, int i10) {
        this.f8196c = str;
        this.f8197d = i10;
    }

    public static /* synthetic */ void q(d dVar, List list) throws IOException {
        dVar.getClass();
        try {
            FileWriter fileWriter = new FileWriter(dVar.f8196c, true);
            try {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    fileWriter.append((CharSequence) it.next());
                    fileWriter.append('\n');
                }
                fileWriter.flush();
                fileWriter.close();
            } finally {
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // pc.a.b
    public void k(int i10, String str, String str2, Throwable th) {
        if (i10 < this.f8197d) {
            return;
        }
        r(t(i10, str, str2));
    }

    public final void r(String str) {
        if (str == null) {
            return;
        }
        this.f8199f.add(str);
        this.f8195b.removeCallbacksAndMessages(null);
        this.f8195b.postDelayed(new Runnable() { // from class: k8.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f8192e.s();
            }
        }, 300L);
    }

    public final void s() {
        final ArrayList arrayList = new ArrayList(this.f8199f);
        this.f8199f.clear();
        this.f8198e.execute(new Runnable() { // from class: k8.c
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                d.q(this.f8193e, arrayList);
            }
        });
    }

    public final String t(int i10, String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        sb2.append('[');
        sb2.append(timestamp);
        sb2.append(']');
        sb2.append(' ');
        sb2.append(u(i10));
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

    public final String u(int i10) {
        return i10 != 2 ? i10 != 4 ? i10 != 5 ? i10 != 6 ? i10 != 7 ? "D" : "WTF" : "E" : "W" : "I" : "V";
    }

    public String v() {
        return this.f8196c;
    }
}
