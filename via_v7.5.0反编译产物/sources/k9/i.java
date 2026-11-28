package k9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.List;
import va.f1;
import x8.w0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class i implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t9.g f7235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f7236b;

    public i(t9.g gVar, byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            throw new IllegalArgumentException("key cannot be empty");
        }
        this.f7235a = gVar;
        this.f7236b = bArr;
    }

    @Override // k9.b
    public List a(c cVar) {
        File fileA = cVar.a("pass.csv");
        File fileA2 = cVar.a("pass.enc");
        if (fileA == null || fileA2 == null) {
            return Collections.EMPTY_LIST;
        }
        List listN = this.f7235a.n();
        try {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileA)));
                try {
                    f1.b(bufferedWriter, listN);
                    bufferedWriter.close();
                    if (!w0.h(this.f7236b, fileA, fileA2)) {
                        if (fileA.exists() && !fileA.delete()) {
                            tc.a.i("Watch out", new Object[0]);
                        }
                        return Collections.EMPTY_LIST;
                    }
                    List listSingletonList = Collections.singletonList(new a(fileA2));
                    if (fileA.exists() && !fileA.delete()) {
                        tc.a.i("Watch out", new Object[0]);
                    }
                    return listSingletonList;
                } catch (Throwable th) {
                    try {
                        bufferedWriter.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException e10) {
                tc.a.j(e10);
                if (fileA.exists() && !fileA.delete()) {
                    tc.a.i("Watch out", new Object[0]);
                }
            }
        } catch (Throwable th3) {
            if (fileA.exists() && !fileA.delete()) {
                tc.a.i("Watch out", new Object[0]);
            }
            throw th3;
        }
    }

    @Override // k9.b
    public void b(c cVar, int i10) {
        try {
            c(cVar);
        } catch (IOException e10) {
            throw new IllegalStateException("Failed to restore passwords", e10);
        }
    }

    public boolean c(c cVar) {
        File fileA = cVar.a("pass.csv");
        File fileA2 = cVar.a("pass.enc");
        if (fileA == null || fileA2 == null || !fileA2.exists()) {
            return true;
        }
        try {
            if (!w0.c(this.f7236b, fileA2, fileA)) {
                if (fileA.exists() && !fileA.delete()) {
                    tc.a.i("Watch out", new Object[0]);
                }
                return false;
            }
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileA)));
                try {
                    List listA = f1.a(bufferedReader);
                    if (listA == null) {
                        throw new IOException("Invalid password CSV");
                    }
                    if (!listA.isEmpty() && !this.f7235a.i(listA)) {
                        throw new IOException("Failed to save restored passwords");
                    }
                    bufferedReader.close();
                    if (!fileA.delete()) {
                        tc.a.i("Watch out", new Object[0]);
                    }
                    return true;
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (RuntimeException e10) {
                throw new IOException("Failed to restore passwords", e10);
            }
        } catch (Throwable th3) {
            if (!fileA.delete()) {
                tc.a.i("Watch out", new Object[0]);
            }
            throw th3;
        }
    }
}
