package mark.via.data.backup2;

import android.content.Context;
import com.tuyafeng.support.utils.j;
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
import k9.b;
import k9.e;
import k9.f;
import k9.i;
import k9.m;
import ka.h;
import qa.c;
import t9.g;
import u9.l;
import w9.a;
import x8.c1;
import x8.d4;
import x8.e4;
import x8.w0;
import x8.w3;
import z9.d;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class ZipBackupManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f10103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10104b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f10105c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f10106d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final u4.a f10107e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f10108f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d f10109g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final m9.c f10110h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final h f10111i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final g f10112j;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public enum RestoreResult {
        SUCCESS,
        ENCRYPTED_DATA_SKIPPED,
        FAILED
    }

    public ZipBackupManager(Context context, l lVar, a aVar, u4.a aVar2, c cVar, d dVar, m9.c cVar2, h hVar, g gVar) {
        this.f10103a = context;
        this.f10104b = c1.j(context, "backup");
        this.f10105c = lVar;
        this.f10106d = aVar;
        this.f10107e = aVar2;
        this.f10108f = cVar;
        this.f10109g = dVar;
        this.f10110h = cVar2;
        this.f10111i = hVar;
        this.f10112j = gVar;
    }

    public boolean a(File file, int i10, String str) throws Throwable {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    boolean zB = b(fileOutputStream2, i10, str);
                    j.a(fileOutputStream2);
                    return zB;
                } catch (Exception e10) {
                    e = e10;
                    fileOutputStream = fileOutputStream2;
                    tc.a.j(e);
                    j.a(fileOutputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    j.a(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e11) {
            e = e11;
        }
    }

    public boolean b(OutputStream outputStream, int i10, String str) throws Throwable {
        File fileA;
        int i11;
        if (i10 == 0) {
            return false;
        }
        e4 e4Var = null;
        strReplace = null;
        String strReplace = null;
        e4Var = null;
        try {
            try {
                File fileC = c(UUID.randomUUID().toString());
                ArrayList arrayList = new ArrayList();
                e4 e4Var2 = new e4(outputStream);
                try {
                    try {
                        e4Var2.c();
                        if ((i10 & 2) == 2) {
                            arrayList.add(new k9.d(this.f10110h));
                        }
                        if ((i10 & 4) == 4) {
                            arrayList.add(new f(this.f10106d, w3.m(this.f10103a)));
                        }
                        if ((i10 & 8) == 8) {
                            arrayList.add(new k9.g(this.f10106d));
                        }
                        if ((i10 & 16) == 16) {
                            arrayList.add(new m(this.f10111i));
                        }
                        if ((i10 & 1) == 1) {
                            arrayList.add(new k9.l(this.f10103a, this.f10105c, this.f10106d, this.f10107e, this.f10108f, this.f10109g));
                        }
                        if (str != null && (i11 = i10 & 32) != 0) {
                            strReplace = UUID.randomUUID().toString().replace("-", "");
                            byte[] bArrK = w0.k(str, strReplace);
                            if (i11 == 32 && bArrK != null) {
                                arrayList.add(new i(this.f10112j, bArrK));
                            }
                        }
                        if ((i10 & 31) == 31) {
                            arrayList.add(new e(this.f10105c, this.f10106d, this.f10109g, this.f10107e, this.f10108f, this.f10110h, false));
                        }
                        if (arrayList.isEmpty()) {
                            j.a(e4Var2);
                            return true;
                        }
                        ArrayList<k9.a> arrayList2 = new ArrayList();
                        k9.h hVar = new k9.h(fileC);
                        if (strReplace != null && (fileA = hVar.a("info.enc")) != null && f(strReplace, fileA)) {
                            arrayList2.add(new k9.a(fileA));
                        }
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            arrayList2.addAll(((b) it.next()).a(hVar));
                        }
                        if (arrayList2.isEmpty()) {
                            j.a(e4Var2);
                            return true;
                        }
                        for (k9.a aVar : arrayList2) {
                            try {
                                e4Var2.a(aVar.a(), aVar.b());
                            } catch (Exception e10) {
                                tc.a.j(e10);
                            }
                        }
                        j.a(e4Var2);
                        return true;
                    } catch (Throwable th) {
                        th = th;
                        e4Var = e4Var2;
                        j.a(e4Var);
                        throw th;
                    }
                } catch (Exception e11) {
                    e = e11;
                    e4Var = e4Var2;
                    tc.a.j(e);
                    j.a(e4Var);
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
        String str2 = this.f10104b;
        if (str2 == null || str2.isEmpty()) {
            throw new NullPointerException("tempDirectory == null || tempDirectory.isEmpty()");
        }
        File file = new File(this.f10104b, str);
        if (file.isFile() && !file.delete()) {
            throw new IOException("Cannot delete file " + file.getAbsolutePath());
        }
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        throw new IOException("Cannot make directories for " + file.getAbsolutePath());
    }

    public final String d(File file) {
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
                        try {
                            fileInputStream.close();
                        } catch (Throwable th) {
                            th.addSuppressed(th);
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                    throw th2;
                }
            } catch (Throwable th4) {
                fileInputStream.close();
                throw th4;
            }
        } catch (IOException e10) {
            tc.a.j(e10);
            return null;
        }
    }

    public RestoreResult e(InputStream inputStream, String str) throws Throwable {
        Throwable th;
        IOException iOException;
        d4 d4Var = null;
        try {
            try {
                File fileC = c(UUID.randomUUID().toString());
                d4 d4Var2 = new d4(inputStream);
                try {
                    d4Var2.a(fileC);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new k9.d(this.f10110h));
                    arrayList.add(new f(this.f10106d, w3.m(this.f10103a)));
                    arrayList.add(new k9.g(this.f10106d));
                    arrayList.add(new m(this.f10111i));
                    arrayList.add(new k9.l(this.f10103a, this.f10105c, this.f10106d, this.f10107e, this.f10108f, this.f10109g));
                    k9.h hVar = new k9.h(fileC);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((b) it.next()).b(hVar, 0);
                    }
                    File fileA = hVar.a("pass.enc");
                    if (str != null && fileA != null && fileA.exists()) {
                        byte[] bArrK = w0.k(str, d(hVar.a("info.enc")));
                        if (bArrK == null) {
                            RestoreResult restoreResult = RestoreResult.FAILED;
                            j.a(d4Var2);
                            return restoreResult;
                        }
                        if (!new i(this.f10112j, bArrK).c(hVar)) {
                            RestoreResult restoreResult2 = RestoreResult.ENCRYPTED_DATA_SKIPPED;
                            j.a(d4Var2);
                            return restoreResult2;
                        }
                    }
                    RestoreResult restoreResult3 = RestoreResult.SUCCESS;
                    j.a(d4Var2);
                    return restoreResult3;
                } catch (IOException e10) {
                    iOException = e10;
                    d4Var = d4Var2;
                    tc.a.j(iOException);
                    j.a(d4Var);
                    return RestoreResult.FAILED;
                } catch (Throwable th2) {
                    th = th2;
                    d4Var = d4Var2;
                    j.a(d4Var);
                    throw th;
                }
            } catch (IOException e11) {
                iOException = e11;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public final boolean f(String str, File file) {
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
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e10) {
            tc.a.j(e10);
            return false;
        }
    }
}
