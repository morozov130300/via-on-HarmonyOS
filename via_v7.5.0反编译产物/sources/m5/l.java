package m5;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.util.Collections;
import java.util.List;
import k5.o;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class l implements m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g5.c f7937c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f5.c f7938e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final o f7939m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final h5.c f7940n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile boolean f7941o;

    public l(g5.c cVar, f5.c cVar2, o oVar, h5.c cVar3) {
        this.f7937c = cVar;
        this.f7938e = cVar2;
        this.f7939m = oVar;
        this.f7940n = cVar3;
    }

    @Override // m5.m
    public void a() {
        this.f7941o = true;
    }

    /* JADX WARN: Code duplicated, block: B:131:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:141:0x0203  */
    /* JADX WARN: Code duplicated, block: B:143:0x0209  */
    /* JADX WARN: Code duplicated, block: B:145:0x0225  */
    /* JADX WARN: Code duplicated, block: B:147:0x0229  */
    /* JADX WARN: Code duplicated, block: B:149:0x0235  */
    /* JADX WARN: Code duplicated, block: B:174:0x0135 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:176:0x0170 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:177:0x0161 A[EDGE_INSN: B:177:0x0161->B:67:0x0161 BREAK  A[LOOP:0: B:51:0x0128->B:58:0x013c], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:24:0x005f A[Catch: IOException | IllegalArgumentException -> 0x01e2, IOException -> 0x01e7, TRY_ENTER, TryCatch #20 {IOException | IllegalArgumentException -> 0x01e2, blocks: (B:11:0x0029, B:13:0x003e, B:26:0x0069, B:33:0x009b, B:48:0x010d, B:24:0x005f), top: B:170:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x00ca A[Catch: IOException | IllegalArgumentException -> 0x0057, IOException -> 0x005d, TRY_ENTER, TryCatch #21 {IOException | IllegalArgumentException -> 0x0057, blocks: (B:16:0x004c, B:28:0x007f, B:31:0x0093, B:32:0x009a, B:35:0x00ca, B:37:0x00df, B:39:0x00ed, B:41:0x00f3, B:43:0x00fb, B:44:0x0102, B:45:0x0103, B:46:0x010a), top: B:169:0x004c }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00df A[Catch: IOException | IllegalArgumentException -> 0x0057, IOException -> 0x005d, TryCatch #21 {IOException | IllegalArgumentException -> 0x0057, blocks: (B:16:0x004c, B:28:0x007f, B:31:0x0093, B:32:0x009a, B:35:0x00ca, B:37:0x00df, B:39:0x00ed, B:41:0x00f3, B:43:0x00fb, B:44:0x0102, B:45:0x0103, B:46:0x010a), top: B:169:0x004c }] */
    /* JADX WARN: Code duplicated, block: B:45:0x0103 A[Catch: IOException | IllegalArgumentException -> 0x0057, IOException -> 0x005d, TryCatch #21 {IOException | IllegalArgumentException -> 0x0057, blocks: (B:16:0x004c, B:28:0x007f, B:31:0x0093, B:32:0x009a, B:35:0x00ca, B:37:0x00df, B:39:0x00ed, B:41:0x00f3, B:43:0x00fb, B:44:0x0102, B:45:0x0103, B:46:0x010a), top: B:169:0x004c }] */
    /* JADX WARN: Code duplicated, block: B:53:0x012c A[Catch: all -> 0x0164, IOException -> 0x016a, TRY_LEAVE, TryCatch #23 {IOException -> 0x016a, all -> 0x0164, blocks: (B:50:0x0121, B:51:0x0128, B:53:0x012c), top: B:166:0x0121 }] */
    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public j call() {
        int i10;
        h hVarH;
        URI uriCreate;
        int i11;
        g5.a aVar;
        f5.c cVar;
        g5.a aVar2;
        FileInputStream fileInputStream;
        Throwable th;
        h hVarH2;
        k5.c cVarA;
        k5.c cVar2;
        h hVarH3;
        byte[] bArr;
        int i12;
        List listH;
        if (g5.b.e(this.f7937c.q())) {
            return j.d();
        }
        if (this.f7941o) {
            c(80);
            return j.c(h.f(1));
        }
        try {
            File file = new File(URI.create(this.f7937c.t()));
            try {
                if (!file.isFile()) {
                    throw new IOException("Local source is missing");
                }
                long length = file.length();
                long j10 = 0;
                if (this.f7937c.u()) {
                    if (this.f7937c.r() != length) {
                        throw new IOException("Local source length changed");
                    }
                    uriCreate = URI.create(this.f7937c.g());
                    if ("file".equals(uriCreate.getScheme())) {
                        throw new IOException("Source and destination are the same file");
                    }
                    this.f7937c.R(length);
                    this.f7937c.F(true);
                    this.f7937c.z(0L);
                    this.f7937c.x(1);
                    i11 = 0;
                    this.f7937c.O(false);
                    aVar = new g5.a();
                    aVar.n(this.f7937c.j());
                    aVar.k(length);
                    cVar = this.f7938e;
                    if (cVar != null) {
                        cVar.m(this.f7937c.j());
                        if (this.f7938e.k(Collections.singletonList(aVar))) {
                            throw new IOException("Cannot create copy progress");
                        }
                        listH = this.f7938e.h(this.f7937c.j());
                        if (listH != null) {
                        }
                        throw new IOException("Cannot load copy progress");
                    }
                    aVar2 = aVar;
                    c(92);
                    fileInputStream = new FileInputStream(file);
                    cVarA = this.f7939m.a(this.f7937c.g());
                    cVarA.a(0L);
                    bArr = new byte[65536];
                    while (true) {
                        if (this.f7941o) {
                            i12 = fileInputStream.read(bArr);
                            i10 = 1;
                            if (i12 != -1) {
                                break;
                                break;
                            }
                            cVarA.write(bArr, i11, i12);
                            cVar2 = cVarA;
                            long j11 = j10 + ((long) i12);
                            aVar2.i(j11);
                            this.f7940n.a(this.f7937c, aVar2, j11, length);
                            j10 = j11;
                            bArr = bArr;
                            cVarA = cVar2;
                            i11 = 0;
                        } else {
                            i10 = 1;
                            break;
                        }
                    }
                    k5.c cVar3 = cVarA;
                    this.f7937c.z(j10);
                    if (!this.f7941o) {
                        throw new IOException("Local copy length mismatch");
                    }
                    cVar3.b();
                    cVar3.close();
                    hVarH = null;
                    fileInputStream.close();
                } else {
                    try {
                        if (this.f7937c.r() > 0) {
                            if (this.f7937c.r() != length) {
                                throw new IOException("Local source length changed");
                            }
                        }
                        uriCreate = URI.create(this.f7937c.g());
                        if ("file".equals(uriCreate.getScheme()) && file.getCanonicalFile().equals(new File(uriCreate).getCanonicalFile())) {
                            throw new IOException("Source and destination are the same file");
                        }
                        this.f7937c.R(length);
                        this.f7937c.F(true);
                        this.f7937c.z(0L);
                        this.f7937c.x(1);
                        i11 = 0;
                        this.f7937c.O(false);
                        aVar = new g5.a();
                        aVar.n(this.f7937c.j());
                        aVar.k(length);
                        cVar = this.f7938e;
                        if (cVar != null) {
                            cVar.m(this.f7937c.j());
                            if (this.f7938e.k(Collections.singletonList(aVar))) {
                                throw new IOException("Cannot create copy progress");
                            }
                            listH = this.f7938e.h(this.f7937c.j());
                            if (listH != null || listH.size() != 1) {
                                throw new IOException("Cannot load copy progress");
                            }
                            aVar = (g5.a) listH.get(0);
                        }
                        aVar2 = aVar;
                        c(92);
                        fileInputStream = new FileInputStream(file);
                        try {
                            try {
                                cVarA = this.f7939m.a(this.f7937c.g());
                                try {
                                    cVarA.a(0L);
                                    bArr = new byte[65536];
                                    while (true) {
                                        if (this.f7941o) {
                                            i10 = 1;
                                            break;
                                        }
                                        i12 = fileInputStream.read(bArr);
                                        i10 = 1;
                                        if (i12 != -1) {
                                            break;
                                        }
                                        try {
                                            cVarA.write(bArr, i11, i12);
                                            cVar2 = cVarA;
                                            long j12 = j10 + ((long) i12);
                                            try {
                                                try {
                                                    aVar2.i(j12);
                                                    this.f7940n.a(this.f7937c, aVar2, j12, length);
                                                    j10 = j12;
                                                    bArr = bArr;
                                                    cVarA = cVar2;
                                                    i11 = 0;
                                                } catch (IOException e10) {
                                                    e = e10;
                                                    hVarH = h.h(12, e);
                                                    try {
                                                        try {
                                                            cVar2.close();
                                                        } catch (IOException e11) {
                                                            hVarH3 = hVarH == null ? h.h(12, e11) : hVarH;
                                                            hVarH = hVarH3;
                                                            fileInputStream.close();
                                                            if (hVarH != null) {
                                                                this.f7937c.A(hVarH.c());
                                                                this.f7937c.B(hVarH.d());
                                                                c(200);
                                                                return j.c(hVarH);
                                                            }
                                                            if (this.f7941o) {
                                                                c(80);
                                                                return j.c(h.f(i10));
                                                            }
                                                            this.f7937c.A(null);
                                                            this.f7937c.B(null);
                                                            c(100);
                                                            return j.d();
                                                        }
                                                        fileInputStream.close();
                                                        if (hVarH != null) {
                                                            this.f7937c.A(hVarH.c());
                                                            this.f7937c.B(hVarH.d());
                                                            c(200);
                                                            return j.c(hVarH);
                                                        }
                                                        if (this.f7941o) {
                                                            c(80);
                                                            return j.c(h.f(i10));
                                                        }
                                                        this.f7937c.A(null);
                                                        this.f7937c.B(null);
                                                        c(100);
                                                        return j.d();
                                                    } catch (Throwable th2) {
                                                        th = th2;
                                                        hVarH2 = hVarH;
                                                        th = th;
                                                        try {
                                                            try {
                                                                fileInputStream.close();
                                                                throw th;
                                                            } catch (Throwable th3) {
                                                                th.addSuppressed(th3);
                                                                throw th;
                                                            }
                                                        } catch (IOException | IllegalArgumentException e12) {
                                                            e = e12;
                                                            hVarH = hVarH2;
                                                        }
                                                    }
                                                }
                                            } catch (Throwable th4) {
                                                th = th4;
                                                Throwable th5 = th;
                                                try {
                                                    cVar2.close();
                                                    hVarH2 = null;
                                                } catch (IOException e13) {
                                                    hVarH2 = h.h(12, e13);
                                                }
                                                try {
                                                    throw th5;
                                                } catch (Throwable th6) {
                                                    th = th6;
                                                    th = th;
                                                    fileInputStream.close();
                                                    throw th;
                                                }
                                            }
                                        } catch (IOException e14) {
                                            e = e14;
                                            cVar2 = cVarA;
                                        } catch (Throwable th7) {
                                            th = th7;
                                            cVar2 = cVarA;
                                        }
                                    }
                                    k5.c cVar4 = cVarA;
                                    this.f7937c.z(j10);
                                    if (!this.f7941o && (j10 != length || file.length() != length)) {
                                        throw new IOException("Local copy length mismatch");
                                    }
                                    cVar4.b();
                                    try {
                                        cVar4.close();
                                        hVarH = null;
                                    } catch (IOException e15) {
                                        hVarH3 = h.h(12, e15);
                                        hVarH = hVarH3;
                                    }
                                } catch (IOException e16) {
                                    e = e16;
                                    cVar2 = cVarA;
                                    i10 = 1;
                                } catch (Throwable th8) {
                                    th = th8;
                                    cVar2 = cVarA;
                                    i10 = 1;
                                }
                                try {
                                    fileInputStream.close();
                                } catch (IOException e17) {
                                    e = e17;
                                    if (hVarH == null) {
                                        hVarH = h.h(12, e);
                                    }
                                } catch (IllegalArgumentException e18) {
                                    e = e18;
                                    if (hVarH == null) {
                                        hVarH = h.h(12, e);
                                    }
                                }
                            } catch (Throwable th9) {
                                th = th9;
                                i10 = 1;
                                th = th;
                                hVarH2 = null;
                                fileInputStream.close();
                                throw th;
                            }
                        } catch (Throwable th10) {
                            th = th10;
                            th = th;
                            hVarH2 = null;
                            fileInputStream.close();
                            throw th;
                        }
                    } catch (IOException | IllegalArgumentException e19) {
                        e = e19;
                        hVarH = null;
                        i10 = 1;
                    }
                }
                if (hVarH != null) {
                    this.f7937c.A(hVarH.c());
                    this.f7937c.B(hVarH.d());
                    c(200);
                    return j.c(hVarH);
                }
                if (this.f7941o) {
                    c(80);
                    return j.c(h.f(i10));
                }
                this.f7937c.A(null);
                this.f7937c.B(null);
                c(100);
                return j.d();
            } catch (IOException e20) {
                e = e20;
                hVarH = null;
            } catch (IllegalArgumentException e21) {
                e = e21;
                hVarH = null;
            }
        } catch (IOException | IllegalArgumentException e22) {
            e = e22;
            i10 = 1;
        }
        hVarH = null;
        if (hVarH == null) {
            hVarH = h.h(12, e);
        }
        if (hVarH != null) {
            this.f7937c.A(hVarH.c());
            this.f7937c.B(hVarH.d());
            c(200);
            return j.c(hVarH);
        }
        if (this.f7941o) {
            c(80);
            return j.c(h.f(i10));
        }
        this.f7937c.A(null);
        this.f7937c.B(null);
        c(100);
        return j.d();
    }

    public final void c(int i10) {
        int iQ = this.f7937c.q();
        this.f7937c.Q(i10);
        this.f7940n.b(this.f7937c, iQ, i10);
    }
}
