package m9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import va.d1;
import z8.w0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class i implements b {

    /* renamed from: a, reason: collision with root package name */
    public final v9.g f8694a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f8695b;

    public i(v9.g gVar, byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            throw new IllegalArgumentException("key cannot be empty");
        }
        this.f8694a = gVar;
        this.f8695b = bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007b  */
    @Override // m9.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List a(c cVar) throws Throwable {
        BufferedWriter bufferedWriter;
        File fileA = cVar.a("pass.csv");
        File fileA2 = cVar.a("pass.enc");
        if (fileA == null || fileA2 == null) {
            return Collections.EMPTY_LIST;
        }
        List listN = this.f8694a.n();
        BufferedWriter bufferedWriter2 = null;
        try {
            try {
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileA)));
            } catch (Exception e10) {
                e = e10;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            bufferedWriter.append((CharSequence) "name,url,username,password,note\n");
            Iterator it = listN.iterator();
            while (it.hasNext()) {
                String strB = d1.b((v9.f) it.next());
                if (strB != null) {
                    bufferedWriter.append((CharSequence) strB);
                }
                bufferedWriter.append('\n');
            }
            g6.j.a(bufferedWriter);
        } catch (Exception e11) {
            e = e11;
            bufferedWriter2 = bufferedWriter;
            pc.a.i(e);
            g6.j.a(bufferedWriter2);
            ArrayList arrayList = new ArrayList();
            if (w0.h(this.f8695b, fileA, fileA2)) {
            }
            if (!fileA.delete()) {
            }
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            bufferedWriter2 = bufferedWriter;
            g6.j.a(bufferedWriter2);
            throw th;
        }
        ArrayList arrayList2 = new ArrayList();
        if (w0.h(this.f8695b, fileA, fileA2)) {
            arrayList2.add(new a(fileA2));
        }
        if (!fileA.delete()) {
            pc.a.h("Watch out", new Object[0]);
        }
        return arrayList2;
    }

    @Override // m9.b
    public void b(c cVar, int i10) throws Throwable {
        c(cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x00ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean c(c cVar) throws Throwable {
        BufferedReader bufferedReader;
        Throwable th;
        Exception e10;
        ArrayList arrayList;
        int iC;
        File fileA = cVar.a("pass.csv");
        File fileA2 = cVar.a("pass.enc");
        if (fileA == null || fileA2 == null || !fileA2.exists()) {
            return true;
        }
        if (!w0.c(this.f8695b, fileA2, fileA)) {
            if (fileA.exists() && !fileA.delete()) {
                pc.a.h("Watch out", new Object[0]);
            }
            return false;
        }
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileA)));
            try {
                try {
                    arrayList = new ArrayList();
                    iC = d1.c(bufferedReader.readLine());
                } catch (Exception e11) {
                    e10 = e11;
                    pc.a.i(e10);
                    g6.j.a(bufferedReader);
                    if (!fileA.delete()) {
                        pc.a.h("Watch out", new Object[0]);
                    }
                    return true;
                }
            } catch (Throwable th2) {
                th = th2;
                g6.j.a(bufferedReader);
                if (!fileA.delete()) {
                    pc.a.h("Watch out", new Object[0]);
                }
                throw th;
            }
        } catch (Exception e12) {
            bufferedReader = null;
            e10 = e12;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
            g6.j.a(bufferedReader);
            if (!fileA.delete()) {
            }
            throw th;
        }
        if (iC == 0) {
            g6.j.a(bufferedReader);
            if (!fileA.delete()) {
                pc.a.h("Watch out", new Object[0]);
            }
            return true;
        }
        StringBuilder sb2 = new StringBuilder();
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            if (z10) {
                sb2.append("\n");
                sb2.append(line);
            } else {
                sb2.setLength(0);
                sb2.append(line);
                i10 = 0;
            }
            int length = line.length();
            for (int i11 = 0; i11 < length; i11++) {
                if (line.charAt(i11) == '\"') {
                    i10++;
                }
            }
            if (i10 % 2 == 0) {
                v9.f fVarI = d1.i(sb2.toString(), iC);
                if (fVarI != null) {
                    arrayList.add(fVarI);
                }
                z10 = false;
            } else {
                z10 = true;
            }
        }
        if (!arrayList.isEmpty()) {
            this.f8694a.i(arrayList);
        }
        g6.j.a(bufferedReader);
        if (!fileA.delete()) {
            pc.a.h("Watch out", new Object[0]);
        }
        return true;
    }
}
