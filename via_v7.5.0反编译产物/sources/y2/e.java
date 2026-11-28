package y2;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;
import t2.p;
import v2.b0;
import v2.c0;
import w2.h;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Charset f14816d = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f14817e = 15;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final h f14818f = new h();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Comparator f14819g = new Comparator() { // from class: y2.a
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return ((File) obj2).getName().compareTo(((File) obj).getName());
        }
    };

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final FilenameFilter f14820h = new FilenameFilter() { // from class: y2.b
        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            return str.startsWith("event");
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f14821a = new AtomicInteger(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f14822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a3.g f14823c;

    public e(g gVar, a3.g gVar2) {
        this.f14822b = gVar;
        this.f14823c = gVar2;
    }

    public static void D(File file, String str) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), f14816d);
        try {
            outputStreamWriter.write(str);
            outputStreamWriter.close();
        } catch (Throwable th) {
            try {
                outputStreamWriter.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static void E(File file, String str, long j10) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), f14816d);
        try {
            outputStreamWriter.write(str);
            file.setLastModified(h(j10));
            outputStreamWriter.close();
        } catch (Throwable th) {
            try {
                outputStreamWriter.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static int f(List list, int i10) {
        int size = list.size();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            if (size <= i10) {
                break;
            }
            g.s(file);
            size--;
        }
        return size;
    }

    public static long h(long j10) {
        return j10 * 1000;
    }

    public static String m(int i10, boolean z10) {
        return "event" + String.format(Locale.US, "%010d", Integer.valueOf(i10)) + (z10 ? "_" : "");
    }

    public static String o(String str) {
        return str.substring(0, f14817e);
    }

    public static boolean s(String str) {
        return str.startsWith("event") && str.endsWith("_");
    }

    public static boolean t(File file, String str) {
        return str.startsWith("event") && !str.endsWith("_");
    }

    public static int v(File file, File file2) {
        return o(file.getName()).compareTo(o(file2.getName()));
    }

    public static String y(File file) throws IOException {
        byte[] bArr = new byte[8192];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            try {
                int i10 = fileInputStream.read(bArr);
                if (i10 <= 0) {
                    String str = new String(byteArrayOutputStream.toByteArray(), f14816d);
                    fileInputStream.close();
                    return str;
                }
                byteArrayOutputStream.write(bArr, 0, i10);
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    public final void A(String str, long j10) {
        boolean z10;
        List listP = this.f14822b.p(str, f14820h);
        if (listP.isEmpty()) {
            q2.f.f().i("Session " + str + " has no events.");
            return;
        }
        Collections.sort(listP);
        ArrayList arrayList = new ArrayList();
        Iterator it = listP.iterator();
        loop0: while (true) {
            z10 = false;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                File file = (File) it.next();
                try {
                    arrayList.add(f14818f.h(y(file)));
                    if (z10 || s(file.getName())) {
                        z10 = true;
                    }
                } catch (IOException e10) {
                    q2.f.f().l("Could not add event to report for " + file, e10);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            B(this.f14822b.o(str, "report"), arrayList, j10, z10, u2.h.g(str, this.f14822b));
            return;
        }
        q2.f.f().k("Could not parse event files for session " + str);
    }

    public final void B(File file, List list, long j10, boolean z10, String str) {
        try {
            h hVar = f14818f;
            b0 b0VarN = hVar.F(y(file)).p(j10, z10, str).n(c0.c(list));
            b0.e eVarK = b0VarN.k();
            if (eVarK == null) {
                return;
            }
            D(z10 ? this.f14822b.j(eVarK.h()) : this.f14822b.l(eVarK.h()), hVar.G(b0VarN));
        } catch (IOException e10) {
            q2.f.f().l("Could not synthesize final report file for " + file, e10);
        }
    }

    public final int C(String str, int i10) {
        List listP = this.f14822b.p(str, new FilenameFilter() { // from class: y2.c
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str2) {
                return e.t(file, str2);
            }
        });
        Collections.sort(listP, new Comparator() { // from class: y2.d
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return e.v((File) obj, (File) obj2);
            }
        });
        return f(listP, i10);
    }

    public final SortedSet e(String str) {
        this.f14822b.b();
        SortedSet sortedSetP = p();
        if (str != null) {
            sortedSetP.remove(str);
        }
        if (sortedSetP.size() > 8) {
            while (sortedSetP.size() > 8) {
                String str2 = (String) sortedSetP.last();
                q2.f.f().b("Removing session over cap: " + str2);
                this.f14822b.c(str2);
                sortedSetP.remove(str2);
            }
        }
        return sortedSetP;
    }

    public final void g() {
        int i10 = this.f14823c.b().f30a.f42b;
        List listN = n();
        int size = listN.size();
        if (size <= i10) {
            return;
        }
        Iterator it = listN.subList(i10, size).iterator();
        while (it.hasNext()) {
            ((File) it.next()).delete();
        }
    }

    public void i() {
        j(this.f14822b.m());
        j(this.f14822b.k());
        j(this.f14822b.h());
    }

    public final void j(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((File) it.next()).delete();
        }
    }

    public void k(String str, long j10) {
        for (String str2 : e(str)) {
            q2.f.f().i("Finalizing report for session " + str2);
            A(str2, j10);
            this.f14822b.c(str2);
        }
        g();
    }

    public void l(String str, b0.d dVar, b0.a aVar) {
        File fileO = this.f14822b.o(str, "report");
        q2.f.f().b("Writing native session report for " + str + " to file: " + fileO);
        z(fileO, dVar, str, aVar);
    }

    public final List n() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f14822b.k());
        arrayList.addAll(this.f14822b.h());
        Comparator comparator = f14819g;
        Collections.sort(arrayList, comparator);
        List listM = this.f14822b.m();
        Collections.sort(listM, comparator);
        arrayList.addAll(listM);
        return arrayList;
    }

    public SortedSet p() {
        return new TreeSet(this.f14822b.d()).descendingSet();
    }

    public long q(String str) {
        return this.f14822b.o(str, "start-time").lastModified();
    }

    public boolean r() {
        return (this.f14822b.m().isEmpty() && this.f14822b.k().isEmpty() && this.f14822b.h().isEmpty()) ? false : true;
    }

    public List u() {
        List<File> listN = n();
        ArrayList arrayList = new ArrayList();
        for (File file : listN) {
            try {
                arrayList.add(p.a(f14818f.F(y(file)), file.getName(), file));
            } catch (IOException e10) {
                q2.f.f().l("Could not load report file " + file + "; deleting", e10);
                file.delete();
            }
        }
        return arrayList;
    }

    public void w(b0.e.d dVar, String str, boolean z10) {
        int i10 = this.f14823c.b().f30a.f41a;
        try {
            D(this.f14822b.o(str, m(this.f14821a.getAndIncrement(), z10)), f14818f.i(dVar));
        } catch (IOException e10) {
            q2.f.f().l("Could not persist event for session " + str, e10);
        }
        C(str, i10);
    }

    public void x(b0 b0Var) {
        b0.e eVarK = b0Var.k();
        if (eVarK == null) {
            q2.f.f().b("Could not get session for report");
            return;
        }
        String strH = eVarK.h();
        try {
            D(this.f14822b.o(strH, "report"), f14818f.G(b0Var));
            E(this.f14822b.o(strH, "start-time"), "", eVarK.k());
        } catch (IOException e10) {
            q2.f.f().c("Could not persist report for session " + strH, e10);
        }
    }

    public final void z(File file, b0.d dVar, String str, b0.a aVar) {
        try {
            h hVar = f14818f;
            D(this.f14822b.g(str), hVar.G(hVar.F(y(file)).o(dVar).m(aVar)));
        } catch (IOException e10) {
            q2.f.f().l("Could not synthesize final native report file for " + file, e10);
        }
    }
}
