package z4;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import w4.c;
import x4.d;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15180a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f15182c = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f15181b = new ArrayList();

    public a(String str) {
        this.f15180a = str;
    }

    @Override // x4.d
    public boolean a(List list) throws Throwable {
        if (!this.f15180a.isEmpty() && !new File(this.f15180a).isDirectory()) {
            List listC = c();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (!listC.contains(cVar)) {
                    c cVar2 = new c(cVar);
                    cVar2.k(b5.d.a(this.f15180a));
                    cVar2.n(0);
                    listC.add(cVar2);
                }
            }
            if (listC.size() > this.f15181b.size() && b(listC)) {
                return true;
            }
        }
        return false;
    }

    @Override // x4.d
    public boolean b(List list) {
        if (!this.f15180a.isEmpty()) {
            File file = new File(this.f15180a);
            if (!file.isDirectory()) {
                List listD = d(list);
                try {
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
                    try {
                        Iterator it = listD.iterator();
                        while (it.hasNext()) {
                            bufferedWriter.write(((c) it.next()).q());
                            bufferedWriter.newLine();
                        }
                        bufferedWriter.close();
                        this.f15181b = listD;
                        this.f15182c = true;
                        return true;
                    } catch (Throwable th) {
                        try {
                            bufferedWriter.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (IOException unused) {
                }
            }
        }
        return false;
    }

    @Override // x4.d
    public List c() throws Throwable {
        if (!this.f15182c) {
            f();
            this.f15182c = true;
        }
        return d(this.f15181b);
    }

    public final List d(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new c((c) it.next()));
        }
        return arrayList;
    }

    @Override // x4.d
    public boolean e() {
        if (this.f15180a.isEmpty()) {
            return true;
        }
        File file = new File(this.f15180a);
        return file.isDirectory() || !file.exists();
    }

    public final void f() throws Throwable {
        c cVarI;
        if (this.f15180a.isEmpty()) {
            return;
        }
        File file = new File(this.f15180a);
        if (file.isDirectory() || !file.exists()) {
            return;
        }
        BufferedReader bufferedReader = null;
        try {
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                    try {
                        ArrayList arrayList = new ArrayList();
                        while (true) {
                            String line = bufferedReader2.readLine();
                            if (line == null) {
                                this.f15181b.clear();
                                this.f15181b.addAll(arrayList);
                                bufferedReader2.close();
                                return;
                            } else if (!line.isEmpty() && (cVarI = c.i(line)) != null) {
                                if (TextUtils.isEmpty(cVarI.a())) {
                                    cVarI.k(b5.d.a(this.f15180a));
                                }
                                arrayList.add(cVarI);
                            }
                        }
                    } catch (IOException e10) {
                        e = e10;
                        bufferedReader = bufferedReader2;
                        e.printStackTrace();
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception unused) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e11) {
                e = e11;
            }
        } catch (Exception unused2) {
        }
    }
}
