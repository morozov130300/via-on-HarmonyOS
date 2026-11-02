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

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a implements d {

    /* renamed from: a, reason: collision with root package name */
    public final String f14587a;

    /* renamed from: c, reason: collision with root package name */
    public boolean f14589c = false;

    /* renamed from: b, reason: collision with root package name */
    public List f14588b = new ArrayList();

    public a(String str) {
        this.f14587a = str;
    }

    @Override // x4.d
    public List a() throws Throwable {
        if (!this.f14589c) {
            g();
            this.f14589c = true;
        }
        return e(this.f14588b);
    }

    @Override // x4.d
    public boolean b(List list) {
        if (!this.f14587a.isEmpty() && !new File(this.f14587a).isDirectory()) {
            Iterator it = list.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (!this.f14588b.contains(cVar)) {
                    cVar.i(b5.d.a(this.f14587a));
                    cVar.l(0);
                    this.f14588b.add(cVar);
                    i10++;
                }
            }
            if (i10 > 0 && c(this.f14588b)) {
                return true;
            }
        }
        return false;
    }

    @Override // x4.d
    public boolean c(List list) throws Throwable {
        if (!this.f14587a.isEmpty()) {
            File file = new File(this.f14587a);
            if (!file.isDirectory()) {
                this.f14588b = list;
                BufferedWriter bufferedWriter = null;
                try {
                    BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
                    try {
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            bufferedWriter2.write(((c) it.next()).o());
                            bufferedWriter2.newLine();
                        }
                        try {
                            bufferedWriter2.close();
                        } catch (Exception unused) {
                        }
                        return true;
                    } catch (IOException unused2) {
                        bufferedWriter = bufferedWriter2;
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (Exception unused3) {
                            }
                        }
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        bufferedWriter = bufferedWriter2;
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (Exception unused4) {
                            }
                        }
                        throw th;
                    }
                } catch (IOException unused5) {
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
        return false;
    }

    @Override // x4.d
    public List d() {
        return this.f14588b;
    }

    public final List e(List list) {
        if (list.isEmpty()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar != null && cVar.f()) {
                arrayList.addAll(b5.c.t(cVar.a()));
            }
        }
        return arrayList;
    }

    @Override // x4.d
    public boolean f() {
        if (this.f14587a.isEmpty()) {
            return true;
        }
        File file = new File(this.f14587a);
        return file.isDirectory() || !file.exists();
    }

    public final void g() throws Throwable {
        BufferedReader bufferedReader;
        c cVarG;
        if (this.f14587a.isEmpty()) {
            return;
        }
        File file = new File(this.f14587a);
        if (file.isDirectory() || !file.exists()) {
            return;
        }
        BufferedReader bufferedReader2 = null;
        try {
            try {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e10) {
                e = e10;
            }
            try {
                ArrayList arrayList = new ArrayList();
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        this.f14588b.clear();
                        this.f14588b.addAll(arrayList);
                        bufferedReader.close();
                        return;
                    } else if (!line.isEmpty() && (cVarG = c.g(line)) != null) {
                        if (TextUtils.isEmpty(cVarG.a())) {
                            cVarG.i(b5.d.a(this.f14587a));
                        }
                        arrayList.add(cVarG);
                    }
                }
            } catch (IOException e11) {
                e = e11;
                bufferedReader2 = bufferedReader;
                e.printStackTrace();
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (Exception unused) {
                    }
                }
                throw th;
            }
        } catch (Exception unused2) {
        }
    }
}
