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
import java.util.List;
import w4.b;
import w4.d;
import x4.e;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a implements e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f14845c = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f14847b;

    public a(String str) {
        this.f14846a = str;
    }

    @Override // x4.e
    public List a() throws Throwable {
        List listT = c.t(this.f14846a);
        this.f14847b = listT;
        return listT;
    }

    @Override // x4.e
    public String b() throws Throwable {
        String line;
        File fileI = i();
        if (fileI == null || !fileI.exists()) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        BufferedReader bufferedReader = null;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(new FileInputStream(fileI)));
                try {
                    String property = System.getProperty("line.separator");
                    while (true) {
                        line = bufferedReader3.readLine();
                        if (line == null) {
                            break;
                        }
                        String strTrim = line.trim();
                        if (!strTrim.isEmpty() && strTrim.charAt(0) != '!') {
                            sb2.append(strTrim);
                            sb2.append(property);
                        }
                    }
                    h(bufferedReader3);
                    bufferedReader = line;
                } catch (Exception e10) {
                    e = e10;
                    bufferedReader2 = bufferedReader3;
                    b5.a.f(f14845c, e);
                    h(bufferedReader2);
                    bufferedReader = bufferedReader2;
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader3;
                    h(bufferedReader);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e11) {
            e = e11;
        }
        return sb2.toString();
    }

    @Override // x4.e
    public b c(String str) throws Throwable {
        File fileI;
        b bVarV;
        BufferedWriter bufferedWriter;
        String str2 = f14845c;
        b5.a.a(str2, "remove filter: " + str);
        Closeable closeable = null;
        if (str == null || str.isEmpty() || str.charAt(0) == '!' || (fileI = i()) == null || (bVarV = c.v(str)) == null) {
            b5.a.a(str2, "The raw is not a valid filter, raw: " + str);
            return null;
        }
        if (this.f14847b == null) {
            this.f14847b = a();
        }
        if (!this.f14847b.remove(bVarV)) {
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
                            b5.a.f(f14845c, e);
                            h(closeable);
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
    public b d(String str) throws Throwable {
        File fileI;
        b bVarV;
        String str2 = f14845c;
        b5.a.a(str2, "add filter: " + str);
        Closeable closeable = null;
        if (str == null || str.isEmpty() || str.charAt(0) == '!' || (fileI = i()) == null || (bVarV = c.v(str)) == null) {
            b5.a.a(str2, "The raw is not a valid filter, raw: " + str);
            return null;
        }
        if (this.f14847b == null) {
            this.f14847b = a();
        }
        if (this.f14847b.contains(bVarV)) {
            b5.a.a(str2, "the filter is already in list, raw: " + str);
            return null;
        }
        this.f14847b.add(bVarV);
        b5.a.a(str2, "write raw to file, raw: " + str);
        try {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileI, true)));
                try {
                    bufferedWriter.newLine();
                    bufferedWriter.write(str);
                    bufferedWriter.flush();
                    h(bufferedWriter);
                    return bVarV;
                } catch (IOException e10) {
                    e = e10;
                    closeable = bufferedWriter;
                    b5.a.f(f14845c, e);
                    h(closeable);
                    return bVarV;
                } catch (Throwable th) {
                    th = th;
                    closeable = bufferedWriter;
                    h(closeable);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e11) {
            e = e11;
        }
    }

    @Override // x4.e
    public String e() {
        return this.f14846a;
    }

    @Override // x4.e
    public boolean g(String str) {
        File fileI = i();
        if (fileI == null) {
            return false;
        }
        if (str == null) {
            return !fileI.exists() || fileI.delete();
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileI, false)));
            try {
                bufferedWriter.write(str);
                bufferedWriter.close();
                return true;
            } catch (Throwable th) {
                try {
                    bufferedWriter.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e10) {
            b5.a.f(f14845c, e10);
            return false;
        }
    }

    public final void h(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e10) {
            b5.a.d(f14845c, e10.getMessage());
        }
    }

    public final File i() {
        String str = this.f14846a;
        if (str == null || str.isEmpty()) {
            return null;
        }
        File file = new File(this.f14846a);
        if (file.getParentFile() == null || file.getParentFile().exists() || file.getParentFile().mkdirs()) {
            return file;
        }
        return null;
    }

    @Override // x4.e
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public d f(String str) {
        d dVarI;
        if (str == null || str.isEmpty() || (dVarI = d.i(str)) == null || !this.f14847b.contains(dVarI)) {
            return null;
        }
        return dVarI;
    }
}
