package y4;

import b5.c;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import w4.b;
import w4.d;
import x4.e;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a implements e {

    /* renamed from: c, reason: collision with root package name */
    public static final String f14452c = "a";

    /* renamed from: a, reason: collision with root package name */
    public final String f14453a;

    /* renamed from: b, reason: collision with root package name */
    public List f14454b;

    public a(String str) {
        this.f14453a = str;
    }

    @Override // x4.e
    public List a() {
        ArrayList arrayList = new ArrayList(c.t(this.f14453a));
        this.f14454b = arrayList;
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // x4.e
    public String b() throws Throwable {
        BufferedReader bufferedReader;
        String line;
        File fileI = i();
        if (fileI == null || !fileI.exists()) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        BufferedReader bufferedReader2 = null;
        BufferedReader bufferedReader3 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileI)));
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e10) {
            e = e10;
        }
        try {
            String property = System.getProperty("line.separator");
            while (true) {
                line = bufferedReader.readLine();
                if (line == 0) {
                    break;
                }
                String strTrim = line.trim();
                if (!strTrim.isEmpty() && strTrim.charAt(0) != '!') {
                    sb2.append(strTrim);
                    sb2.append(property);
                }
            }
            h(bufferedReader);
            bufferedReader2 = line;
        } catch (Exception e11) {
            e = e11;
            bufferedReader3 = bufferedReader;
            b5.a.f(f14452c, e);
            h(bufferedReader3);
            bufferedReader2 = bufferedReader3;
            return sb2.toString();
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            h(bufferedReader2);
            throw th;
        }
        return sb2.toString();
    }

    @Override // x4.e
    public String c() {
        return this.f14453a;
    }

    @Override // x4.e
    public b d(String str) throws Throwable {
        File fileI;
        b bVarV;
        BufferedWriter bufferedWriter;
        String str2 = f14452c;
        b5.a.a(str2, "remove filter: " + str);
        Closeable closeable = null;
        if (str == null || str.isEmpty() || str.charAt(0) == '!' || (fileI = i()) == null || (bVarV = c.v(str)) == null) {
            b5.a.a(str2, "The raw is not a valid filter, raw: " + str);
            return null;
        }
        if (this.f14454b == null) {
            this.f14454b = a();
        }
        if (!this.f14454b.remove(bVarV)) {
            b5.a.a(str2, "the filter is not in list, raw: " + str);
            return null;
        }
        File file = new File(fileI.getParent(), "." + fileI.getName());
        b5.a.a(str2, "remove raw from file, raw: " + str);
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileI)));
            try {
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        String strTrim = line.trim();
                        if (!strTrim.equals(str) && !strTrim.isEmpty()) {
                            bufferedWriter.write(strTrim);
                            bufferedWriter.newLine();
                        }
                    } catch (IOException e10) {
                        e = e10;
                        closeable = bufferedReader;
                        try {
                            b5.a.f(f14452c, e);
                            h(closeable);
                            h(bufferedWriter);
                            return bVarV;
                        } catch (Throwable th) {
                            th = th;
                            h(closeable);
                            h(bufferedWriter);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        closeable = bufferedReader;
                        h(closeable);
                        h(bufferedWriter);
                        throw th;
                    }
                }
                file.renameTo(fileI);
                h(bufferedReader);
            } catch (IOException e11) {
                e = e11;
                bufferedWriter = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedWriter = null;
            }
        } catch (IOException e12) {
            e = e12;
            bufferedWriter = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedWriter = null;
        }
        h(bufferedWriter);
        return bVarV;
    }

    @Override // x4.e
    public b e(String str) throws Throwable {
        File fileI;
        b bVarV;
        BufferedWriter bufferedWriter;
        String str2 = f14452c;
        b5.a.a(str2, "add filter: " + str);
        Closeable closeable = null;
        if (str == null || str.isEmpty() || str.charAt(0) == '!' || (fileI = i()) == null || (bVarV = c.v(str)) == null) {
            b5.a.a(str2, "The raw is not a valid filter, raw: " + str);
            return null;
        }
        if (this.f14454b == null) {
            this.f14454b = a();
        }
        if (this.f14454b.contains(bVarV)) {
            b5.a.a(str2, "the filter is already in list, raw: " + str);
            return null;
        }
        this.f14454b.add(bVarV);
        b5.a.a(str2, "write raw to file, raw: " + str);
        try {
            try {
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileI, true)));
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e10) {
            e = e10;
        }
        try {
            bufferedWriter.newLine();
            bufferedWriter.write(str);
            bufferedWriter.flush();
            h(bufferedWriter);
            return bVarV;
        } catch (IOException e11) {
            e = e11;
            closeable = bufferedWriter;
            b5.a.f(f14452c, e);
            h(closeable);
            return bVarV;
        } catch (Throwable th2) {
            th = th2;
            closeable = bufferedWriter;
            h(closeable);
            throw th;
        }
    }

    @Override // x4.e
    public boolean f(String str) throws Throwable {
        BufferedWriter bufferedWriter;
        File fileI = i();
        if (fileI == null) {
            return false;
        }
        if (str != null) {
            String strTrim = str.trim();
            if (!strTrim.isEmpty()) {
                Closeable closeable = null;
                try {
                    try {
                        bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileI, false)));
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (IOException e10) {
                    e = e10;
                }
                try {
                    bufferedWriter.write(strTrim);
                    h(bufferedWriter);
                    return true;
                } catch (IOException e11) {
                    e = e11;
                    closeable = bufferedWriter;
                    b5.a.f(f14452c, e);
                    h(closeable);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    closeable = bufferedWriter;
                    h(closeable);
                    throw th;
                }
            }
        }
        return fileI.delete();
    }

    public final void h(Closeable closeable) throws IOException {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e10) {
            b5.a.d(f14452c, e10.getMessage());
        }
    }

    public final File i() {
        String str = this.f14453a;
        if (str == null || str.isEmpty()) {
            return null;
        }
        File file = new File(this.f14453a);
        if (file.getParentFile() == null || file.getParentFile().exists() || file.getParentFile().mkdirs()) {
            return file;
        }
        return null;
    }

    @Override // x4.e
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public d g(String str) {
        d dVarI;
        if (str == null || str.isEmpty() || (dVarI = d.i(str)) == null || !this.f14454b.contains(dVarI)) {
            return null;
        }
        return dVarI;
    }
}
