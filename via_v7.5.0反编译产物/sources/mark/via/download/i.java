package mark.via.download;

import android.content.Context;
import android.util.Base64;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static i f10197f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f10198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f10199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c5.a f10200c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentMap f10201d = new ConcurrentHashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set f10202e = Collections.newSetFromMap(new ConcurrentHashMap());

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface a {
        void a(File file, String str, long j10, int i10);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public final class b implements c6.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f10203a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f10204b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final a f10205c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object f10206d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final x.a f10207e;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public File f10209g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public FileOutputStream f10210h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f10211i;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f10213k;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final AtomicBoolean f10208f = new AtomicBoolean();

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final c6.p f10212j = new c6.p(this, i.z(), new p7.l() { // from class: mark.via.download.j
            @Override // p7.l
            public final Object invoke(Object obj) {
                return this.f10221c.f(((Integer) obj).intValue());
            }
        });

        public b(String str, Object obj, Object obj2, Object obj3, x.a aVar, a aVar2) {
            this.f10211i = str;
            this.f10203a = obj;
            this.f10204b = obj2;
            this.f10205c = aVar2;
            this.f10206d = obj3;
            this.f10207e = aVar;
        }

        @Override // c6.n
        public boolean b() {
            try {
                this.f10210h.getFD().sync();
                return true;
            } catch (IOException e10) {
                tc.a.j(e10);
                return false;
            }
        }

        @Override // c6.n
        public boolean c() {
            File[] fileArr = {i.this.f10198a, i.this.f10199b};
            for (int i10 = 0; i10 < 2; i10++) {
                File file = fileArr[i10];
                if (file != null) {
                    try {
                        if (file.isDirectory() || file.mkdirs()) {
                            this.f10209g = new File(file, this.f10211i + ".part");
                            this.f10210h = new FileOutputStream(this.f10209g);
                            return true;
                        }
                    } catch (IOException e10) {
                        tc.a.j(e10);
                        File file2 = this.f10209g;
                        if (file2 != null) {
                            i.t(file2);
                        }
                    }
                }
            }
            return false;
        }

        @Override // c6.n
        public boolean close() {
            try {
                FileOutputStream fileOutputStream = this.f10210h;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                this.f10210h = null;
                return true;
            } catch (IOException e10) {
                tc.a.j(e10);
                return false;
            }
        }

        @Override // c6.n
        public boolean d() {
            String strF = this.f10212j.f();
            this.f10213k = strF;
            try {
                if (strF.isEmpty() || this.f10213k.contains("/*") || "application/octet-stream".equals(this.f10213k)) {
                    FileInputStream fileInputStream = new FileInputStream(this.f10209g);
                    try {
                        byte[] bArr = new byte[(int) Math.min(144L, this.f10212j.g())];
                        this.f10213k = fileInputStream.read(bArr) > 0 ? l5.c.d(bArr) : null;
                        fileInputStream.close();
                    } catch (Throwable th) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                File file = new File(this.f10209g.getParentFile(), this.f10211i);
                if (!this.f10209g.renameTo(file)) {
                    return false;
                }
                this.f10209g = file;
                if (i.this.f10201d.remove(this.f10211i, this)) {
                    i.this.f10202e.add(this.f10209g.getAbsolutePath());
                    return true;
                }
                this.f10212j.a(5);
                return false;
            } catch (IOException e10) {
                tc.a.j(e10);
                return false;
            }
        }

        @Override // c6.n
        public void e() {
            close();
            File file = this.f10209g;
            if (file != null) {
                i.t(file);
            }
        }

        public final d7.h f(int i10) {
            i.this.f10201d.remove(this.f10211i, this);
            if (i10 == 0) {
                this.f10205c.a(this.f10209g, this.f10213k, this.f10212j.g(), 0);
            } else {
                x.a aVar = this.f10207e;
                if (aVar != null) {
                    aVar.accept(this.f10211i + ":abort");
                }
                this.f10205c.a(null, null, 0L, i10);
            }
            return d7.h.f3935a;
        }

        @Override // c6.n
        public long length() {
            return this.f10209g.length();
        }
    }

    public i(File file, File file2, c5.a aVar) {
        this.f10198a = file;
        this.f10199b = file2;
        this.f10200c = aVar;
    }

    public static /* synthetic */ void a(i iVar, byte[] bArr, String str, b bVar) {
        iVar.getClass();
        try {
            boolean zO = iVar.o(str, ByteBuffer.wrap(bArr, 40, 8).getLong(), bArr, 48, bArr.length - 48);
            bVar.f10208f.set(false);
            if (zO) {
                bVar.f10207e.accept(str + ":chunk");
            }
        } catch (Throwable th) {
            bVar.f10208f.set(false);
            throw th;
        }
    }

    public static /* synthetic */ void b(i iVar, g5.c cVar, int i10, int i11) {
        if (g5.b.e(i11)) {
            iVar.D(cVar.t());
        }
    }

    public static /* synthetic */ void c(i iVar, Map.Entry entry, b bVar) {
        iVar.getClass();
        iVar.u((String) entry.getKey(), bVar, 5);
    }

    public static /* synthetic */ Boolean d(b bVar, byte[] bArr, int i10, int i11) {
        try {
            bVar.f10210h.write(bArr, i10, i11);
            return Boolean.TRUE;
        } catch (IOException e10) {
            tc.a.j(e10);
            return Boolean.FALSE;
        }
    }

    public static /* synthetic */ void f(i iVar, String str, File file) {
        for (g5.c cVar : iVar.f10200c.a()) {
            if (str.equals(cVar.t()) && !g5.b.e(cVar.q())) {
                return;
            }
        }
        t(file);
    }

    public static void t(File file) {
        if (!file.exists() || file.delete()) {
            return;
        }
        tc.a.i("Cannot delete blob temporary file", new Object[0]);
    }

    public static synchronized i y(Context context) {
        try {
            if (f10197f == null) {
                File externalCacheDir = context.getExternalCacheDir();
                c5.b bVarR = c5.b.r(context);
                final i iVar = new i(externalCacheDir == null ? null : new File(externalCacheDir, "blob"), new File(context.getCacheDir(), "blob"), bVarR);
                f10197f = iVar;
                bVarR.e(new j5.c() { // from class: mark.via.download.a
                    @Override // j5.c
                    public final void I(g5.c cVar, int i10, int i11) {
                        i.b(this.f10152c, cVar, i10, i11);
                    }
                });
                r6.p pVarC = a7.a.c();
                Objects.requireNonNull(iVar);
                pVarC.d(new Runnable() { // from class: mark.via.download.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f10157c.r();
                    }
                });
                a7.a.c().f(new Runnable() { // from class: mark.via.download.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f10165c.v();
                    }
                }, 15L, 15L, TimeUnit.SECONDS);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f10197f;
    }

    public static long z() {
        return TimeUnit.NANOSECONDS.toMillis(System.nanoTime());
    }

    public void A(Object obj, final byte[] bArr) {
        if (bArr.length < 48) {
            return;
        }
        final String str = new String(bArr, 4, 36, StandardCharsets.US_ASCII);
        final b bVar = (b) this.f10201d.get(str);
        if (bVar == null || bVar.f10206d != obj || bVar.f10207e == null) {
            return;
        }
        if (bVar.f10208f.compareAndSet(false, true)) {
            a7.a.c().d(new Runnable() { // from class: mark.via.download.g
                @Override // java.lang.Runnable
                public final void run() {
                    i.a(this.f10186c, bArr, str, bVar);
                }
            });
        } else if (this.f10201d.remove(str, bVar)) {
            a7.a.c().d(new Runnable() { // from class: mark.via.download.f
                @Override // java.lang.Runnable
                public final void run() {
                    this.f10180c.u(str, bVar, 7);
                }
            });
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public boolean B(JSONObject jSONObject) throws JSONException {
        String string = jSONObject.getString(Name.MARK);
        try {
            String string2 = jSONObject.getString("event");
            switch (string2.hashCode()) {
                case -1274442605:
                    if (string2.equals("finish")) {
                        return x(string);
                    }
                    return false;
                case 92611376:
                    if (string2.equals("abort")) {
                        int i10 = -1;
                        int iOptInt = jSONObject.optInt("errorCode", -1);
                        if (iOptInt >= 1 && iOptInt <= 7) {
                            i10 = iOptInt;
                        }
                        w(string, i10);
                        return true;
                    }
                    return false;
                case 93616297:
                    if (string2.equals("begin")) {
                        return p(string, jSONObject.getLong("size"), jSONObject.optString("mimeType"));
                    }
                    return false;
                case 94642797:
                    if (string2.equals("chunk")) {
                        return n(string, jSONObject.getLong("offset"), jSONObject.getString("data"));
                    }
                    return false;
                default:
                    return false;
            }
        } catch (JSONException unused) {
            w(string, 7);
            return false;
        }
    }

    public boolean C(String str) {
        File file;
        if (str != null && str.startsWith("file:")) {
            try {
                File absoluteFile = new File(URI.create(str).normalize()).getAbsoluteFile();
                File parentFile = absoluteFile.getParentFile();
                if ((this.f10199b.getAbsoluteFile().equals(parentFile) || ((file = this.f10198a) != null && file.getAbsoluteFile().equals(parentFile))) && UUID.fromString(absoluteFile.getName()).toString().equals(absoluteFile.getName())) {
                    return true;
                }
            } catch (IllegalArgumentException unused) {
            }
        }
        return false;
    }

    public void D(final String str) {
        if (C(str)) {
            final File file = new File(URI.create(str));
            this.f10202e.remove(file.getAbsolutePath());
            a7.a.c().d(new Runnable() { // from class: mark.via.download.e
                @Override // java.lang.Runnable
                public final void run() {
                    i.f(this.f10175c, str, file);
                }
            });
        }
    }

    public void m(String str) {
        if (C(str)) {
            this.f10202e.remove(new File(URI.create(str)).getAbsolutePath());
        }
    }

    public boolean n(String str, long j10, String str2) {
        if (str2 != null) {
            try {
                if (str2.length() <= 87384) {
                    byte[] bArrDecode = Base64.decode(str2, 2);
                    return o(str, j10, bArrDecode, 0, bArrDecode.length);
                }
            } catch (IllegalArgumentException e10) {
                e = e10;
                tc.a.k(e, "Cannot decode blob chunk", new Object[0]);
                w(str, 7);
                return false;
            }
        }
        try {
            throw new IllegalArgumentException("Invalid blob chunk");
        } catch (IllegalArgumentException e11) {
            e = e11;
            tc.a.k(e, "Cannot decode blob chunk", new Object[0]);
            w(str, 7);
            return false;
        }
    }

    public final boolean o(String str, long j10, final byte[] bArr, final int i10, final int i11) {
        final b bVar;
        boolean z10 = false;
        if (str == null || (bVar = (b) this.f10201d.get(str)) == null) {
            return false;
        }
        synchronized (bVar) {
            try {
                if (this.f10201d.get(str) == bVar && bVar.f10212j.c(j10, i11, z(), new p7.a() { // from class: mark.via.download.h
                    @Override // p7.a
                    public final Object invoke() {
                        return i.d(bVar, bArr, i10, i11);
                    }
                })) {
                    z10 = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z10;
    }

    public boolean p(String str, long j10, String str2) {
        b bVar;
        boolean z10 = false;
        if (str == null || (bVar = (b) this.f10201d.get(str)) == null) {
            return false;
        }
        synchronized (bVar) {
            try {
                if (this.f10201d.get(str) == bVar && bVar.f10212j.b(j10, str2, z())) {
                    z10 = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z10;
    }

    public void q(Object obj) {
        for (final Map.Entry entry : this.f10201d.entrySet()) {
            final b bVar = (b) entry.getValue();
            if (bVar.f10203a == obj || bVar.f10204b == obj) {
                if (this.f10201d.remove(entry.getKey(), bVar)) {
                    a7.a.c().d(new Runnable() { // from class: mark.via.download.d
                        @Override // java.lang.Runnable
                        public final void run() {
                            i.c(this.f10168c, entry, bVar);
                        }
                    });
                }
            }
        }
    }

    public void r() {
        HashSet hashSet = new HashSet(this.f10202e);
        for (g5.c cVar : this.f10200c.a()) {
            if (C(cVar.t()) && !g5.b.e(cVar.q())) {
                hashSet.add(new File(URI.create(cVar.t())).getAbsolutePath());
            }
        }
        File[] fileArr = {this.f10198a, this.f10199b};
        for (int i10 = 0; i10 < 2; i10++) {
            File file = fileArr[i10];
            File[] fileArrListFiles = file == null ? null : file.listFiles();
            if (fileArrListFiles != null) {
                for (File file2 : fileArrListFiles) {
                    String name = file2.getName();
                    if (!this.f10201d.containsKey(name.endsWith(".part") ? name.substring(0, name.length() - 5) : name) && !hashSet.contains(file2.getAbsolutePath()) && (name.endsWith(".part") || System.currentTimeMillis() - file2.lastModified() > TimeUnit.DAYS.toMillis(1L))) {
                        t(file2);
                    }
                }
            }
        }
    }

    public String s(Object obj, Object obj2, Object obj3, x.a aVar, a aVar2) {
        String string = UUID.randomUUID().toString();
        this.f10201d.put(string, new b(string, obj, obj2, obj3, aVar, aVar2));
        return string;
    }

    public final void u(String str, b bVar, int i10) {
        synchronized (bVar) {
            bVar.f10212j.a(i10);
        }
    }

    public void v() {
        long jZ = z();
        Iterator it = this.f10201d.entrySet().iterator();
        while (it.hasNext()) {
            b bVar = (b) ((Map.Entry) it.next()).getValue();
            synchronized (bVar) {
                bVar.f10212j.d(jZ);
            }
        }
    }

    public void w(String str, int i10) {
        b bVar;
        if (str == null || (bVar = (b) this.f10201d.remove(str)) == null) {
            return;
        }
        u(str, bVar, i10);
    }

    public boolean x(String str) {
        b bVar;
        boolean z10 = false;
        if (str == null || (bVar = (b) this.f10201d.get(str)) == null) {
            return false;
        }
        synchronized (bVar) {
            try {
                if (this.f10201d.get(str) == bVar && bVar.f10212j.e()) {
                    z10 = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z10;
    }
}
