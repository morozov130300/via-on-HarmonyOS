package e4;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Closeable {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final Pattern f4168y = Pattern.compile("[a-z0-9_-]{1,64}");

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final OutputStream f4169z = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final File f4170c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final File f4171e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final File f4172m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final File f4173n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f4174o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f4175p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f4176q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Writer f4178s;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f4180u;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f4177r = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final LinkedHashMap f4179t = new LinkedHashMap(0, 0.75f, true);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f4181v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ThreadPoolExecutor f4182w = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Callable f4183x = new CallableC0061a();

    /* JADX INFO: renamed from: e4.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class CallableC0061a implements Callable {
        public CallableC0061a() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void call() {
            synchronized (a.this) {
                try {
                    if (a.this.f4178s == null) {
                        return null;
                    }
                    a.this.b0();
                    if (a.this.s()) {
                        a.this.x();
                        a.this.f4180u = 0;
                    }
                    return null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f4185a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean[] f4186b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f4187c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f4188d;

        /* JADX INFO: renamed from: e4.a$c$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public class C0062a extends FilterOutputStream {
            public /* synthetic */ C0062a(c cVar, OutputStream outputStream, CallableC0061a callableC0061a) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    c.this.f4187c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    c.this.f4187c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i10) {
                try {
                    ((FilterOutputStream) this).out.write(i10);
                } catch (IOException unused) {
                    c.this.f4187c = true;
                }
            }

            public C0062a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i10, int i11) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i10, i11);
                } catch (IOException unused) {
                    c.this.f4187c = true;
                }
            }
        }

        public /* synthetic */ c(a aVar, d dVar, CallableC0061a callableC0061a) {
            this(dVar);
        }

        public void a() {
            a.this.m(this, false);
        }

        public void e() {
            if (this.f4187c) {
                a.this.m(this, false);
                a.this.J(this.f4185a.f4191a);
            } else {
                a.this.m(this, true);
            }
            this.f4188d = true;
        }

        public OutputStream f(int i10) {
            FileOutputStream fileOutputStream;
            C0062a c0062a;
            synchronized (a.this) {
                try {
                    if (this.f4185a.f4194d != this) {
                        throw new IllegalStateException();
                    }
                    if (!this.f4185a.f4193c) {
                        this.f4186b[i10] = true;
                    }
                    File fileK = this.f4185a.k(i10);
                    try {
                        fileOutputStream = new FileOutputStream(fileK);
                    } catch (FileNotFoundException unused) {
                        a.this.f4170c.mkdirs();
                        try {
                            fileOutputStream = new FileOutputStream(fileK);
                        } catch (FileNotFoundException unused2) {
                            return a.f4169z;
                        }
                    }
                    c0062a = new C0062a(this, fileOutputStream, null);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return c0062a;
        }

        public c(d dVar) {
            this.f4185a = dVar;
            this.f4186b = dVar.f4193c ? null : new boolean[a.this.f4176q];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f4191a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long[] f4192b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f4193c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public c f4194d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f4195e;

        public /* synthetic */ d(a aVar, String str, CallableC0061a callableC0061a) {
            this(str);
        }

        public File j(int i10) {
            return new File(a.this.f4170c, this.f4191a + "." + i10);
        }

        public File k(int i10) {
            return new File(a.this.f4170c, this.f4191a + "." + i10 + ".tmp");
        }

        public String l() {
            StringBuilder sb2 = new StringBuilder();
            for (long j10 : this.f4192b) {
                sb2.append(' ');
                sb2.append(j10);
            }
            return sb2.toString();
        }

        public final IOException m(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public final void n(String[] strArr) throws IOException {
            if (strArr.length != a.this.f4176q) {
                throw m(strArr);
            }
            for (int i10 = 0; i10 < strArr.length; i10++) {
                try {
                    this.f4192b[i10] = Long.parseLong(strArr[i10]);
                } catch (NumberFormatException unused) {
                    throw m(strArr);
                }
            }
        }

        public d(String str) {
            this.f4191a = str;
            this.f4192b = new long[a.this.f4176q];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public final class e implements Closeable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f4197c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f4198e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final InputStream[] f4199m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final long[] f4200n;

        public /* synthetic */ e(a aVar, String str, long j10, InputStream[] inputStreamArr, long[] jArr, CallableC0061a callableC0061a) {
            this(str, j10, inputStreamArr, jArr);
        }

        public InputStream a(int i10) {
            return this.f4199m[i10];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.f4199m) {
                e4.c.a(inputStream);
            }
        }

        public e(String str, long j10, InputStream[] inputStreamArr, long[] jArr) {
            this.f4197c = str;
            this.f4198e = j10;
            this.f4199m = inputStreamArr;
            this.f4200n = jArr;
        }
    }

    public a(File file, int i10, int i11, long j10) {
        this.f4170c = file;
        this.f4174o = i10;
        this.f4171e = new File(file, "journal");
        this.f4172m = new File(file, "journal.tmp");
        this.f4173n = new File(file, "journal.bkp");
        this.f4176q = i11;
        this.f4175p = j10;
    }

    public static void W(File file, File file2, boolean z10) throws IOException {
        if (z10) {
            o(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public static void o(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public static a t(File file, int i10, int i11, long j10) throws IOException {
        if (j10 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i11 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                W(file2, file3, false);
            }
        }
        a aVar = new a(file, i10, i11, j10);
        if (aVar.f4171e.exists()) {
            try {
                aVar.v();
                aVar.u();
                aVar.f4178s = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(aVar.f4171e, true), e4.c.f4208a));
                return aVar;
            } catch (IOException e10) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e10.getMessage() + ", removing");
                aVar.n();
            }
        }
        file.mkdirs();
        a aVar2 = new a(file, i10, i11, j10);
        aVar2.x();
        return aVar2;
    }

    public synchronized boolean J(String str) {
        try {
            l();
            c0(str);
            d dVar = (d) this.f4179t.get(str);
            if (dVar != null && dVar.f4194d == null) {
                for (int i10 = 0; i10 < this.f4176q; i10++) {
                    File fileJ = dVar.j(i10);
                    if (fileJ.exists() && !fileJ.delete()) {
                        throw new IOException("failed to delete " + fileJ);
                    }
                    this.f4177r -= dVar.f4192b[i10];
                    dVar.f4192b[i10] = 0;
                }
                this.f4180u++;
                this.f4178s.append((CharSequence) ("REMOVE " + str + '\n'));
                this.f4179t.remove(str);
                if (s()) {
                    this.f4182w.submit(this.f4183x);
                }
                return true;
            }
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void b0() {
        while (this.f4177r > this.f4175p) {
            J((String) ((Map.Entry) this.f4179t.entrySet().iterator().next()).getKey());
        }
    }

    public final void c0(String str) {
        if (f4168y.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + str + "\"");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            if (this.f4178s == null) {
                return;
            }
            for (d dVar : new ArrayList(this.f4179t.values())) {
                if (dVar.f4194d != null) {
                    dVar.f4194d.a();
                }
            }
            b0();
            this.f4178s.close();
            this.f4178s = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void l() {
        if (this.f4178s == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public final synchronized void m(c cVar, boolean z10) {
        d dVar = cVar.f4185a;
        if (dVar.f4194d != cVar) {
            throw new IllegalStateException();
        }
        if (z10 && !dVar.f4193c) {
            for (int i10 = 0; i10 < this.f4176q; i10++) {
                if (!cVar.f4186b[i10]) {
                    cVar.a();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i10);
                }
                if (!dVar.k(i10).exists()) {
                    cVar.a();
                    return;
                }
            }
        }
        for (int i11 = 0; i11 < this.f4176q; i11++) {
            File fileK = dVar.k(i11);
            if (!z10) {
                o(fileK);
            } else if (fileK.exists()) {
                File fileJ = dVar.j(i11);
                fileK.renameTo(fileJ);
                long j10 = dVar.f4192b[i11];
                long length = fileJ.length();
                dVar.f4192b[i11] = length;
                this.f4177r = (this.f4177r - j10) + length;
            }
        }
        this.f4180u++;
        dVar.f4194d = null;
        if (dVar.f4193c || z10) {
            dVar.f4193c = true;
            this.f4178s.write("CLEAN " + dVar.f4191a + dVar.l() + '\n');
            if (z10) {
                long j11 = this.f4181v;
                this.f4181v = 1 + j11;
                dVar.f4195e = j11;
            }
        } else {
            this.f4179t.remove(dVar.f4191a);
            this.f4178s.write("REMOVE " + dVar.f4191a + '\n');
        }
        this.f4178s.flush();
        if (this.f4177r > this.f4175p || s()) {
            this.f4182w.submit(this.f4183x);
        }
    }

    public void n() throws IOException {
        close();
        e4.c.b(this.f4170c);
    }

    public c p(String str) {
        return q(str, -1L);
    }

    public final synchronized c q(String str, long j10) {
        l();
        c0(str);
        d dVar = (d) this.f4179t.get(str);
        CallableC0061a callableC0061a = null;
        if (j10 != -1 && (dVar == null || dVar.f4195e != j10)) {
            return null;
        }
        if (dVar == null) {
            dVar = new d(this, str, callableC0061a);
            this.f4179t.put(str, dVar);
        } else if (dVar.f4194d != null) {
            return null;
        }
        c cVar = new c(this, dVar, callableC0061a);
        dVar.f4194d = cVar;
        this.f4178s.write("DIRTY " + str + '\n');
        this.f4178s.flush();
        return cVar;
    }

    public synchronized e r(String str) throws Throwable {
        Throwable th;
        InputStream inputStream;
        try {
            l();
            c0(str);
            d dVar = (d) this.f4179t.get(str);
            if (dVar == null) {
                return null;
            }
            if (!dVar.f4193c) {
                return null;
            }
            InputStream[] inputStreamArr = new InputStream[this.f4176q];
            for (int i10 = 0; i10 < this.f4176q; i10++) {
                try {
                    try {
                        try {
                            inputStreamArr[i10] = new FileInputStream(dVar.j(i10));
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (FileNotFoundException unused) {
                        for (int i11 = 0; i11 < this.f4176q && (inputStream = inputStreamArr[i11]) != null; i11++) {
                            e4.c.a(inputStream);
                        }
                        return null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    th = th;
                }
            }
            this.f4180u++;
            this.f4178s.append((CharSequence) ("READ " + str + '\n'));
            if (s()) {
                this.f4182w.submit(this.f4183x);
            }
            return new e(this, str, dVar.f4195e, inputStreamArr, dVar.f4192b, null);
        } catch (Throwable th4) {
            th = th4;
        }
        th = th;
        throw th;
    }

    public final boolean s() {
        int i10 = this.f4180u;
        return i10 >= 2000 && i10 >= this.f4179t.size();
    }

    public final void u() throws IOException {
        o(this.f4172m);
        Iterator it = this.f4179t.values().iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            int i10 = 0;
            if (dVar.f4194d == null) {
                while (i10 < this.f4176q) {
                    this.f4177r += dVar.f4192b[i10];
                    i10++;
                }
            } else {
                dVar.f4194d = null;
                while (i10 < this.f4176q) {
                    o(dVar.j(i10));
                    o(dVar.k(i10));
                    i10++;
                }
                it.remove();
            }
        }
    }

    public final void v() {
        e4.b bVar = new e4.b(new FileInputStream(this.f4171e), e4.c.f4208a);
        try {
            String strC = bVar.c();
            String strC2 = bVar.c();
            String strC3 = bVar.c();
            String strC4 = bVar.c();
            String strC5 = bVar.c();
            if (!"libcore.io.DiskLruCache".equals(strC) || !"1".equals(strC2) || !Integer.toString(this.f4174o).equals(strC3) || !Integer.toString(this.f4176q).equals(strC4) || !"".equals(strC5)) {
                throw new IOException("unexpected journal header: [" + strC + ", " + strC2 + ", " + strC4 + ", " + strC5 + "]");
            }
            int i10 = 0;
            while (true) {
                try {
                    w(bVar.c());
                    i10++;
                } catch (EOFException unused) {
                    this.f4180u = i10 - this.f4179t.size();
                    e4.c.a(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            e4.c.a(bVar);
            throw th;
        }
    }

    public final void w(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i10 = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i10);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i10);
            if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                this.f4179t.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i10, iIndexOf2);
        }
        d dVar = (d) this.f4179t.get(strSubstring);
        CallableC0061a callableC0061a = null;
        if (dVar == null) {
            dVar = new d(this, strSubstring, callableC0061a);
            this.f4179t.put(strSubstring, dVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            dVar.f4193c = true;
            dVar.f4194d = null;
            dVar.n(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
            dVar.f4194d = new c(this, dVar, callableC0061a);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 4 && str.startsWith("READ")) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    public final synchronized void x() {
        try {
            Writer writer = this.f4178s;
            if (writer != null) {
                writer.close();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f4172m), e4.c.f4208a));
            try {
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.f4174o));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.f4176q));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (d dVar : this.f4179t.values()) {
                    if (dVar.f4194d != null) {
                        bufferedWriter.write("DIRTY " + dVar.f4191a + '\n');
                    } else {
                        bufferedWriter.write("CLEAN " + dVar.f4191a + dVar.l() + '\n');
                    }
                }
                bufferedWriter.close();
                if (this.f4171e.exists()) {
                    W(this.f4171e, this.f4173n, true);
                }
                W(this.f4172m, this.f4171e, false);
                this.f4173n.delete();
                this.f4178s = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f4171e, true), e4.c.f4208a));
            } catch (Throwable th) {
                bufferedWriter.close();
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class b extends OutputStream {
        @Override // java.io.OutputStream
        public void write(int i10) {
        }
    }
}
