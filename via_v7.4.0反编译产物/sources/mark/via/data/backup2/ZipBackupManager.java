package mark.via.data.backup2;

import android.content.Context;
import ca.d;
import g6.j;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import m9.b;
import m9.e;
import m9.f;
import m9.i;
import m9.m;
import na.h;
import p5.c;
import v9.g;
import w9.l;
import y9.a;
import z8.c1;
import z8.c4;
import z8.d4;
import z8.w0;
import z8.w3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class ZipBackupManager {

    /* renamed from: a, reason: collision with root package name */
    public final Context f9800a;

    /* renamed from: b, reason: collision with root package name */
    public final String f9801b;

    /* renamed from: c, reason: collision with root package name */
    public final l f9802c;

    /* renamed from: d, reason: collision with root package name */
    public final a f9803d;

    /* renamed from: e, reason: collision with root package name */
    public final u4.a f9804e;

    /* renamed from: f, reason: collision with root package name */
    public final c f9805f;

    /* renamed from: g, reason: collision with root package name */
    public final d f9806g;

    /* renamed from: h, reason: collision with root package name */
    public final o9.c f9807h;

    /* renamed from: i, reason: collision with root package name */
    public final h f9808i;

    /* renamed from: j, reason: collision with root package name */
    public final g f9809j;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public enum RestoreResult {
        SUCCESS,
        ENCRYPTED_DATA_SKIPPED,
        FAILED
    }

    public ZipBackupManager(Context context, l lVar, a aVar, u4.a aVar2, c cVar, d dVar, o9.c cVar2, h hVar, g gVar) {
        this.f9800a = context;
        this.f9801b = c1.j(context, "backup");
        this.f9802c = lVar;
        this.f9803d = aVar;
        this.f9804e = aVar2;
        this.f9805f = cVar;
        this.f9806g = dVar;
        this.f9807h = cVar2;
        this.f9808i = hVar;
        this.f9809j = gVar;
    }

    public boolean a(File file, int i10, String str) throws Throwable {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e10) {
            e = e10;
        }
        try {
            boolean zB = b(fileOutputStream, i10, str);
            j.a(fileOutputStream);
            return zB;
        } catch (Exception e11) {
            e = e11;
            fileOutputStream2 = fileOutputStream;
            pc.a.i(e);
            j.a(fileOutputStream2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            j.a(fileOutputStream2);
            throw th;
        }
    }

    public boolean b(OutputStream outputStream, int i10, String str) throws Throwable {
        File fileA;
        int i11;
        if (i10 == 0) {
            return false;
        }
        d4 d4Var = null;
        strReplace = null;
        String strReplace = null;
        d4Var = null;
        try {
            try {
                File fileC = c(UUID.randomUUID().toString());
                ArrayList arrayList = new ArrayList();
                d4 d4Var2 = new d4(outputStream);
                try {
                    try {
                        d4Var2.d();
                        if ((i10 & 2) == 2) {
                            arrayList.add(new m9.d(this.f9807h));
                        }
                        if ((i10 & 4) == 4) {
                            arrayList.add(new f(this.f9803d, w3.m(this.f9800a)));
                        }
                        if ((i10 & 8) == 8) {
                            arrayList.add(new m9.g(this.f9803d));
                        }
                        if ((i10 & 16) == 16) {
                            arrayList.add(new m(this.f9808i));
                        }
                        if ((i10 & 1) == 1) {
                            arrayList.add(new m9.l(this.f9800a, this.f9802c, this.f9803d, this.f9804e, this.f9805f, this.f9806g));
                        }
                        if (str != null && (i11 = i10 & 32) != 0) {
                            strReplace = UUID.randomUUID().toString().replace("-", "");
                            byte[] bArrJ = w0.j(str, strReplace);
                            if (i11 == 32 && bArrJ != null) {
                                arrayList.add(new i(this.f9809j, bArrJ));
                            }
                        }
                        if ((i10 & 31) == 31) {
                            arrayList.add(new e(this.f9802c, this.f9803d, this.f9806g, this.f9804e, this.f9805f, this.f9807h, false));
                        }
                        if (arrayList.isEmpty()) {
                            j.a(d4Var2);
                            return true;
                        }
                        ArrayList<m9.a> arrayList2 = new ArrayList();
                        m9.h hVar = new m9.h(fileC);
                        if (strReplace != null && (fileA = hVar.a("info.enc")) != null && f(strReplace, fileA)) {
                            arrayList2.add(new m9.a(fileA));
                        }
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            arrayList2.addAll(((b) it.next()).a(hVar));
                        }
                        if (arrayList2.isEmpty()) {
                            j.a(d4Var2);
                            return true;
                        }
                        for (m9.a aVar : arrayList2) {
                            try {
                                d4Var2.a(aVar.a(), aVar.b());
                            } catch (Exception e10) {
                                pc.a.i(e10);
                            }
                        }
                        j.a(d4Var2);
                        return true;
                    } catch (Throwable th) {
                        th = th;
                        d4Var = d4Var2;
                        j.a(d4Var);
                        throw th;
                    }
                } catch (Exception e11) {
                    e = e11;
                    d4Var = d4Var2;
                    pc.a.i(e);
                    j.a(d4Var);
                    return false;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e12) {
            e = e12;
        }
    }

    public final File c(String str) throws IOException {
        String str2 = this.f9801b;
        if (str2 == null || str2.isEmpty()) {
            throw new NullPointerException("tempDirectory == null || tempDirectory.isEmpty()");
        }
        File file = new File(this.f9801b, str);
        if (file.isFile() && !file.delete()) {
            throw new IOException("Cannot delete file " + file.getAbsolutePath());
        }
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        throw new IOException("Cannot make directories for " + file.getAbsolutePath());
    }

    public final String d(File file) throws IOException {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byte[] bArr = {90, 60, 127, -89};
                    byte[] bArr2 = new byte[128];
                    int i10 = 0;
                    while (true) {
                        int i11 = fileInputStream.read(bArr2);
                        if (i11 == -1) {
                            String string = byteArrayOutputStream.toString("UTF-8");
                            byteArrayOutputStream.close();
                            fileInputStream.close();
                            return string;
                        }
                        for (int i12 = 0; i12 < i11; i12++) {
                            bArr2[i12] = (byte) (bArr2[i12] ^ bArr[i10 % 4]);
                            i10++;
                        }
                        byteArrayOutputStream.write(bArr2, 0, i11);
                    }
                } finally {
                }
            } finally {
            }
        } catch (IOException e10) {
            pc.a.i(e10);
            return null;
        }
    }

    public RestoreResult e(InputStream inputStream, String str) throws Throwable {
        Throwable th;
        IOException iOException;
        File fileC;
        c4 c4Var;
        c4 c4Var2 = null;
        try {
            try {
                fileC = c(UUID.randomUUID().toString());
                c4Var = new c4(inputStream);
            } catch (IOException e10) {
                iOException = e10;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            c4Var.a(fileC);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new m9.d(this.f9807h));
            arrayList.add(new f(this.f9803d, w3.m(this.f9800a)));
            arrayList.add(new m9.g(this.f9803d));
            arrayList.add(new m(this.f9808i));
            arrayList.add(new m9.l(this.f9800a, this.f9802c, this.f9803d, this.f9804e, this.f9805f, this.f9806g));
            m9.h hVar = new m9.h(fileC);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((b) it.next()).b(hVar, 0);
            }
            File fileA = hVar.a("pass.enc");
            if (str != null && fileA != null && fileA.exists()) {
                byte[] bArrJ = w0.j(str, d(hVar.a("info.enc")));
                if (bArrJ == null) {
                    RestoreResult restoreResult = RestoreResult.FAILED;
                    j.a(c4Var);
                    return restoreResult;
                }
                if (!new i(this.f9809j, bArrJ).c(hVar)) {
                    RestoreResult restoreResult2 = RestoreResult.ENCRYPTED_DATA_SKIPPED;
                    j.a(c4Var);
                    return restoreResult2;
                }
            }
            RestoreResult restoreResult3 = RestoreResult.SUCCESS;
            j.a(c4Var);
            return restoreResult3;
        } catch (IOException e11) {
            iOException = e11;
            c4Var2 = c4Var;
            pc.a.i(iOException);
            j.a(c4Var2);
            return RestoreResult.FAILED;
        } catch (Throwable th3) {
            th = th3;
            c4Var2 = c4Var;
            j.a(c4Var2);
            throw th;
        }
    }

    public final boolean f(String str, File file) throws IOException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = {90, 60, 127, -89};
                byte[] bytes = str.getBytes("UTF-8");
                for (int i10 = 0; i10 < bytes.length; i10++) {
                    bytes[i10] = (byte) (bytes[i10] ^ bArr[i10 % 4]);
                }
                fileOutputStream.write(bytes);
                fileOutputStream.close();
                return true;
            } finally {
            }
        } catch (IOException e10) {
            pc.a.i(e10);
            return false;
        }
    }
}
