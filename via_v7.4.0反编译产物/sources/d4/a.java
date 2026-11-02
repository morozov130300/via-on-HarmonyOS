package d4;

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

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a implements Closeable {

    /* renamed from: w, reason: collision with root package name */
    public static final Pattern f4536w = Pattern.compile("[a-z0-9_-]{1,64}");

    /* renamed from: x, reason: collision with root package name */
    public static final OutputStream f4537x = new b();

    /* renamed from: e, reason: collision with root package name */
    public final File f4538e;

    /* renamed from: j, reason: collision with root package name */
    public final File f4539j;

    /* renamed from: k, reason: collision with root package name */
    public final File f4540k;

    /* renamed from: l, reason: collision with root package name */
    public final File f4541l;

    /* renamed from: m, reason: collision with root package name */
    public final int f4542m;

    /* renamed from: n, reason: collision with root package name */
    public long f4543n;

    /* renamed from: o, reason: collision with root package name */
    public final int f4544o;

    /* renamed from: q, reason: collision with root package name */
    public Writer f4546q;

    /* renamed from: s, reason: collision with root package name */
    public int f4548s;

    /* renamed from: p, reason: collision with root package name */
    public long f4545p = 0;

    /* renamed from: r, reason: collision with root package name */
    public final LinkedHashMap f4547r = new LinkedHashMap(0, 0.75f, true);

    /* renamed from: t, reason: collision with root package name */
    public long f4549t = 0;

    /* renamed from: u, reason: collision with root package name */
    public final ThreadPoolExecutor f4550u = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: v, reason: collision with root package name */
    public final Callable f4551v = new CallableC0060a();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: d4.a$a, reason: collision with other inner class name */
    public class CallableC0060a implements Callable {
        public CallableC0060a() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void call() {
            synchronized (a.this) {
                try {
                    if (a.this.f4546q == null) {
                        return null;
                    }
                    a.this.b0();
                    if (a.this.s()) {
                        a.this.x();
                        a.this.f4548s = 0;
                    }
                    return null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class b extends OutputStream {
        @Override // java.io.OutputStream
        public void write(int i10) {
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public final class c {

        /* renamed from: a, reason: collision with root package name */
        public final d f4553a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean[] f4554b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f4555c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f4556d;

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        /* renamed from: d4.a$c$a, reason: collision with other inner class name */
        public class C0061a extends FilterOutputStream {
            public C0061a(OutputStream outputStream) {
                super(outputStream);
            }

            public /* synthetic */ C0061a(c cVar, OutputStream outputStream, CallableC0060a callableC0060a) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    c.this.f4555c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() throws IOException {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    c.this.f4555c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i10) throws IOException {
                try {
                    ((FilterOutputStream) this).out.write(i10);
                } catch (IOException unused) {
                    c.this.f4555c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i10, int i11) throws IOException {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i10, i11);
                } catch (IOException unused) {
                    c.this.f4555c = true;
                }
            }
        }

        public c(d dVar) {
            this.f4553a = dVar;
            this.f4554b = dVar.f4561c ? null : new boolean[a.this.f4544o];
        }

        public /* synthetic */ c(a aVar, d dVar, CallableC0060a callableC0060a) {
            this(dVar);
        }

        public void a() {
            a.this.m(this, false);
        }

        public void e() {
            if (this.f4555c) {
                a.this.m(this, false);
                a.this.J(this.f4553a.f4559a);
            } else {
                a.this.m(this, true);
            }
            this.f4556d = true;
        }

        public OutputStream f(int i10) {
            FileOutputStream fileOutputStream;
            C0061a c0061a;
            synchronized (a.this) {
                try {
                    if (this.f4553a.f4562d != this) {
                        throw new IllegalStateException();
                    }
                    if (!this.f4553a.f4561c) {
                        this.f4554b[i10] = true;
                    }
                    File fileK = this.f4553a.k(i10);
                    try {
                        fileOutputStream = new FileOutputStream(fileK);
                    } catch (FileNotFoundException unused) {
                        a.this.f4538e.mkdirs();
                        try {
                            fileOutputStream = new FileOutputStream(fileK);
                        } catch (FileNotFoundException unused2) {
                            return a.f4537x;
                        }
                    }
                    c0061a = new C0061a(this, fileOutputStream, null);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return c0061a;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public final class d {

        /* renamed from: a, reason: collision with root package name */
        public final String f4559a;

        /* renamed from: b, reason: collision with root package name */
        public final long[] f4560b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f4561c;

        /* renamed from: d, reason: collision with root package name */
        public c f4562d;

        /* renamed from: e, reason: collision with root package name */
        public long f4563e;

        public d(String str) {
            this.f4559a = str;
            this.f4560b = new long[a.this.f4544o];
        }

        public /* synthetic */ d(a aVar, String str, CallableC0060a callableC0060a) {
            this(str);
        }

        public File j(int i10) {
            return new File(a.this.f4538e, this.f4559a + "." + i10);
        }

        public File k(int i10) {
            return new File(a.this.f4538e, this.f4559a + "." + i10 + ".tmp");
        }

        public String l() {
            StringBuilder sb2 = new StringBuilder();
            for (long j10 : this.f4560b) {
                sb2.append(' ');
                sb2.append(j10);
            }
            return sb2.toString();
        }

        public final IOException m(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public final void n(String[] strArr) throws IOException {
            if (strArr.length != a.this.f4544o) {
                throw m(strArr);
            }
            for (int i10 = 0; i10 < strArr.length; i10++) {
                try {
                    this.f4560b[i10] = Long.parseLong(strArr[i10]);
                } catch (NumberFormatException unused) {
                    throw m(strArr);
                }
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public final class e implements Closeable {

        /* renamed from: e, reason: collision with root package name */
        public final String f4565e;

        /* renamed from: j, reason: collision with root package name */
        public final long f4566j;

        /* renamed from: k, reason: collision with root package name */
        public final InputStream[] f4567k;

        /* renamed from: l, reason: collision with root package name */
        public final long[] f4568l;

        public e(String str, long j10, InputStream[] inputStreamArr, long[] jArr) {
            this.f4565e = str;
            this.f4566j = j10;
            this.f4567k = inputStreamArr;
            this.f4568l = jArr;
        }

        public /* synthetic */ e(a aVar, String str, long j10, InputStream[] inputStreamArr, long[] jArr, CallableC0060a callableC0060a) {
            this(str, j10, inputStreamArr, jArr);
        }

        public InputStream a(int i10) {
            return this.f4567k[i10];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            for (InputStream inputStream : this.f4567k) {
                d4.c.a(inputStream);
            }
        }
    }

    public a(File file, int i10, int i11, long j10) {
        this.f4538e = file;
        this.f4542m = i10;
        this.f4539j = new File(file, "journal");
        this.f4540k = new File(file, "journal.tmp");
        this.f4541l = new File(file, "journal.bkp");
        this.f4544o = i11;
        this.f4543n = j10;
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
        if (aVar.f4539j.exists()) {
            try {
                aVar.v();
                aVar.u();
                aVar.f4546q = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(aVar.f4539j, true), d4.c.f4576a));
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
            d dVar = (d) this.f4547r.get(str);
            if (dVar != null && dVar.f4562d == null) {
                for (int i10 = 0; i10 < this.f4544o; i10++) {
                    File fileJ = dVar.j(i10);
                    if (fileJ.exists() && !fileJ.delete()) {
                        throw new IOException("failed to delete " + fileJ);
                    }
                    this.f4545p -= dVar.f4560b[i10];
                    dVar.f4560b[i10] = 0;
                }
                this.f4548s++;
                this.f4546q.append((CharSequence) ("REMOVE " + str + '\n'));
                this.f4547r.remove(str);
                if (s()) {
                    this.f4550u.submit(this.f4551v);
                }
                return true;
            }
            return false;
        } finally {
        }
    }

    public final void b0() {
        while (this.f4545p > this.f4543n) {
            J((String) ((Map.Entry) this.f4547r.entrySet().iterator().next()).getKey());
        }
    }

    public final void c0(String str) {
        if (f4536w.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + str + "\"");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            if (this.f4546q == null) {
                return;
            }
            Iterator it = new ArrayList(this.f4547r.values()).iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.f4562d != null) {
                    dVar.f4562d.a();
                }
            }
            b0();
            this.f4546q.close();
            this.f4546q = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void l() {
        if (this.f4546q == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public final synchronized void m(c cVar, boolean z10) {
        d dVar = cVar.f4553a;
        if (dVar.f4562d != cVar) {
            throw new IllegalStateException();
        }
        if (z10 && !dVar.f4561c) {
            for (int i10 = 0; i10 < this.f4544o; i10++) {
                if (!cVar.f4554b[i10]) {
                    cVar.a();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i10);
                }
                if (!dVar.k(i10).exists()) {
                    cVar.a();
                    return;
                }
            }
        }
        for (int i11 = 0; i11 < this.f4544o; i11++) {
            File fileK = dVar.k(i11);
            if (!z10) {
                o(fileK);
            } else if (fileK.exists()) {
                File fileJ = dVar.j(i11);
                fileK.renameTo(fileJ);
                long j10 = dVar.f4560b[i11];
                long length = fileJ.length();
                dVar.f4560b[i11] = length;
                this.f4545p = (this.f4545p - j10) + length;
            }
        }
        this.f4548s++;
        dVar.f4562d = null;
        if (dVar.f4561c || z10) {
            dVar.f4561c = true;
            this.f4546q.write("CLEAN " + dVar.f4559a + dVar.l() + '\n');
            if (z10) {
                long j11 = this.f4549t;
                this.f4549t = 1 + j11;
                dVar.f4563e = j11;
            }
        } else {
            this.f4547r.remove(dVar.f4559a);
            this.f4546q.write("REMOVE " + dVar.f4559a + '\n');
        }
        this.f4546q.flush();
        if (this.f4545p > this.f4543n || s()) {
            this.f4550u.submit(this.f4551v);
        }
    }

    public void n() throws IOException {
        close();
        d4.c.b(this.f4538e);
    }

    public c p(String str) {
        return q(str, -1L);
    }

    public final synchronized c q(String str, long j10) {
        l();
        c0(str);
        d dVar = (d) this.f4547r.get(str);
        CallableC0060a callableC0060a = null;
        if (j10 != -1 && (dVar == null || dVar.f4563e != j10)) {
            return null;
        }
        if (dVar == null) {
            dVar = new d(this, str, callableC0060a);
            this.f4547r.put(str, dVar);
        } else if (dVar.f4562d != null) {
            return null;
        }
        c cVar = new c(this, dVar, callableC0060a);
        dVar.f4562d = cVar;
        this.f4546q.write("DIRTY " + str + '\n');
        this.f4546q.flush();
        return cVar;
    }

    public synchronized e r(String str) throws Throwable {
        Throwable th;
        InputStream inputStream;
        try {
            l();
            c0(str);
            d dVar = (d) this.f4547r.get(str);
            if (dVar == null) {
                return null;
            }
            if (!dVar.f4561c) {
                return null;
            }
            InputStream[] inputStreamArr = new InputStream[this.f4544o];
            for (int i10 = 0; i10 < this.f4544o; i10++) {
                try {
                    try {
                        try {
                            inputStreamArr[i10] = new FileInputStream(dVar.j(i10));
                        } catch (Throwable th2) {
                            th = th2;
                            throw th;
                        }
                    } catch (FileNotFoundException unused) {
                        for (int i11 = 0; i11 < this.f4544o && (inputStream = inputStreamArr[i11]) != null; i11++) {
                            d4.c.a(inputStream);
                        }
                        return null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    th = th;
                    throw th;
                }
            }
            this.f4548s++;
            this.f4546q.append((CharSequence) ("READ " + str + '\n'));
            if (s()) {
                this.f4550u.submit(this.f4551v);
            }
            return new e(this, str, dVar.f4563e, inputStreamArr, dVar.f4560b, null);
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public final boolean s() {
        int i10 = this.f4548s;
        return i10 >= 2000 && i10 >= this.f4547r.size();
    }

    public final void u() throws IOException {
        o(this.f4540k);
        Iterator it = this.f4547r.values().iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            int i10 = 0;
            if (dVar.f4562d == null) {
                while (i10 < this.f4544o) {
                    this.f4545p += dVar.f4560b[i10];
                    i10++;
                }
            } else {
                dVar.f4562d = null;
                while (i10 < this.f4544o) {
                    o(dVar.j(i10));
                    o(dVar.k(i10));
                    i10++;
                }
                it.remove();
            }
        }
    }

    public final void v() throws IOException {
        d4.b bVar = new d4.b(new FileInputStream(this.f4539j), d4.c.f4576a);
        try {
            String strD = bVar.d();
            String strD2 = bVar.d();
            String strD3 = bVar.d();
            String strD4 = bVar.d();
            String strD5 = bVar.d();
            if (!"libcore.io.DiskLruCache".equals(strD) || !"1".equals(strD2) || !Integer.toString(this.f4542m).equals(strD3) || !Integer.toString(this.f4544o).equals(strD4) || !"".equals(strD5)) {
                throw new IOException("unexpected journal header: [" + strD + ", " + strD2 + ", " + strD4 + ", " + strD5 + "]");
            }
            int i10 = 0;
            while (true) {
                try {
                    w(bVar.d());
                    i10++;
                } catch (EOFException unused) {
                    this.f4548s = i10 - this.f4547r.size();
                    d4.c.a(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            d4.c.a(bVar);
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
                this.f4547r.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i10, iIndexOf2);
        }
        d dVar = (d) this.f4547r.get(strSubstring);
        CallableC0060a callableC0060a = null;
        if (dVar == null) {
            dVar = new d(this, strSubstring, callableC0060a);
            this.f4547r.put(strSubstring, dVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            dVar.f4561c = true;
            dVar.f4562d = null;
            dVar.n(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
            dVar.f4562d = new c(this, dVar, callableC0060a);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 4 && str.startsWith("READ")) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    public final synchronized void x() {
        try {
            Writer writer = this.f4546q;
            if (writer != null) {
                writer.close();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f4540k), d4.c.f4576a));
            try {
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.f4542m));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.f4544o));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (d dVar : this.f4547r.values()) {
                    if (dVar.f4562d != null) {
                        bufferedWriter.write("DIRTY " + dVar.f4559a + '\n');
                    } else {
                        bufferedWriter.write("CLEAN " + dVar.f4559a + dVar.l() + '\n');
                    }
                }
                bufferedWriter.close();
                if (this.f4539j.exists()) {
                    W(this.f4539j, this.f4541l, true);
                }
                W(this.f4540k, this.f4539j, false);
                this.f4541l.delete();
                this.f4546q = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f4539j, true), d4.c.f4576a));
            } catch (Throwable th) {
                bufferedWriter.close();
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
