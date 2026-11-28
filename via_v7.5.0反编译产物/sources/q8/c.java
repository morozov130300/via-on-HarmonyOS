package q8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import x.d;
import x8.c1;
import x8.t1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f11836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f11837c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f11838d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Set f11839e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f11840f;

    public c(String str) {
        this.f11835a = str;
    }

    public static d j(String str) {
        int iIndexOf = str.indexOf(61);
        return iIndexOf < 0 ? new d(str, null) : new d(str.substring(0, iIndexOf), str.substring(iIndexOf + 1));
    }

    public static void o(Writer writer, String str, String str2) throws IOException {
        if (str == null) {
            return;
        }
        writer.write(str);
        if (str2 != null) {
            writer.write(61);
            writer.write(str2);
        }
        writer.write("\n");
    }

    public void a(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        if (this.f11839e == null) {
            this.f11839e = new HashSet();
        }
        this.f11839e.add(str);
    }

    public void b() {
        String str;
        File parentFile;
        if (this.f11840f == hashCode() || (str = this.f11835a) == null || str.isEmpty()) {
            return;
        }
        File file = new File(this.f11835a);
        if (!file.isDirectory() || c1.f(file)) {
            if (!file.exists() && (parentFile = file.getParentFile()) != null) {
                if (parentFile.isFile() && !parentFile.delete()) {
                    return;
                }
                if (!parentFile.exists() && !parentFile.mkdirs()) {
                    return;
                }
            }
            this.f11840f = hashCode();
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                try {
                    o(bufferedWriter, "enabled", this.f11836b ? "1" : "0");
                    o(bufferedWriter, "proxyUrl", this.f11838d);
                    o(bufferedWriter, "reverseBypassRules", this.f11837c ? "1" : "0");
                    Set set = this.f11839e;
                    if (set != null) {
                        Iterator it = set.iterator();
                        while (it.hasNext()) {
                            o(bufferedWriter, "bypassRule", (String) it.next());
                        }
                    }
                    bufferedWriter.close();
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
            }
        }
    }

    public Set c() {
        return this.f11839e;
    }

    public String d() {
        return this.f11838d;
    }

    public boolean e() {
        String str = this.f11838d;
        return (str == null || str.isEmpty()) ? false : true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            c cVar = (c) obj;
            if (this.f11836b == cVar.f11836b && this.f11837c == cVar.f11837c && t1.a(this.f11838d, cVar.f11838d) && t1.a(this.f11839e, cVar.f11839e)) {
                return true;
            }
        }
        return false;
    }

    public boolean f() {
        return this.f11836b;
    }

    public boolean g() {
        return this.f11840f != hashCode();
    }

    public boolean h() {
        return this.f11837c;
    }

    public int hashCode() {
        return t1.b(Boolean.valueOf(this.f11836b), Boolean.valueOf(this.f11837c), this.f11838d, this.f11839e);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void i() {
        String str = this.f11835a;
        if (str == null || str.isEmpty()) {
            return;
        }
        File file = new File(this.f11835a);
        try {
            if (!file.isFile()) {
                return;
            }
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            bufferedReader.close();
                            this.f11840f = hashCode();
                            return;
                        }
                        String strTrim = line.trim();
                        if (!strTrim.isEmpty()) {
                            d dVarJ = j(strTrim);
                            String str2 = (String) dVarJ.f14455a;
                            switch (str2.hashCode()) {
                                case -1609594047:
                                    if (str2.equals("enabled")) {
                                        this.f11836b = "1".equals(dVarJ.f14456b);
                                    }
                                    break;
                                case -985185247:
                                    if (str2.equals("proxyUrl")) {
                                        this.f11838d = (String) dVarJ.f14456b;
                                    }
                                    break;
                                case -521223164:
                                    if (str2.equals("bypassRule")) {
                                        a((String) dVarJ.f14456b);
                                    }
                                    break;
                                case 735170733:
                                    if (str2.equals("reverseBypassRules")) {
                                        this.f11837c = "1".equals(dVarJ.f14456b);
                                    }
                                    break;
                            }
                        }
                    } catch (Throwable th) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
            } catch (IOException e10) {
                tc.a.j(e10);
            }
        } catch (Throwable th3) {
            this.f11840f = hashCode();
            throw th3;
        }
    }

    public void k(String str) {
        if (this.f11839e == null || str.isEmpty()) {
            return;
        }
        this.f11839e.remove(str);
    }

    public void l(boolean z10) {
        this.f11836b = z10;
    }

    public void m(String str) {
        this.f11838d = str;
    }

    public void n(boolean z10) {
        this.f11837c = z10;
    }
}
