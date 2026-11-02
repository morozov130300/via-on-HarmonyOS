package s8;

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
import w.d;
import z8.c1;
import z8.u1;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f11860a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f11861b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f11862c;

    /* renamed from: d, reason: collision with root package name */
    public String f11863d;

    /* renamed from: e, reason: collision with root package name */
    public Set f11864e;

    /* renamed from: f, reason: collision with root package name */
    public int f11865f;

    public c(String str) {
        this.f11860a = str;
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
        if (this.f11864e == null) {
            this.f11864e = new HashSet();
        }
        this.f11864e.add(str);
    }

    public void b() throws IOException {
        String str;
        File parentFile;
        if (this.f11865f == hashCode() || (str = this.f11860a) == null || str.isEmpty()) {
            return;
        }
        File file = new File(this.f11860a);
        if (!file.isDirectory() || c1.f(file)) {
            if (!file.exists() && (parentFile = file.getParentFile()) != null) {
                if (parentFile.isFile() && !parentFile.delete()) {
                    return;
                }
                if (!parentFile.exists() && !parentFile.mkdirs()) {
                    return;
                }
            }
            this.f11865f = hashCode();
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                try {
                    o(bufferedWriter, "enabled", this.f11861b ? "1" : "0");
                    o(bufferedWriter, "proxyUrl", this.f11863d);
                    o(bufferedWriter, "reverseBypassRules", this.f11862c ? "1" : "0");
                    Set set = this.f11864e;
                    if (set != null) {
                        Iterator it = set.iterator();
                        while (it.hasNext()) {
                            o(bufferedWriter, "bypassRule", (String) it.next());
                        }
                    }
                    bufferedWriter.close();
                } finally {
                }
            } catch (IOException e10) {
                pc.a.i(e10);
            }
        }
    }

    public Set c() {
        return this.f11864e;
    }

    public String d() {
        return this.f11863d;
    }

    public boolean e() {
        String str = this.f11863d;
        return (str == null || str.isEmpty()) ? false : true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            c cVar = (c) obj;
            if (this.f11861b == cVar.f11861b && this.f11862c == cVar.f11862c && u1.a(this.f11863d, cVar.f11863d) && u1.a(this.f11864e, cVar.f11864e)) {
                return true;
            }
        }
        return false;
    }

    public boolean f() {
        return this.f11861b;
    }

    public boolean g() {
        return this.f11865f != hashCode();
    }

    public boolean h() {
        return this.f11862c;
    }

    public int hashCode() {
        return u1.b(Boolean.valueOf(this.f11861b), Boolean.valueOf(this.f11862c), this.f11863d, this.f11864e);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public void i() {
        BufferedReader bufferedReader;
        String str = this.f11860a;
        if (str == null || str.isEmpty()) {
            return;
        }
        File file = new File(this.f11860a);
        try {
            if (!file.isFile()) {
                return;
            }
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
            } catch (IOException e10) {
                pc.a.i(e10);
            }
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        bufferedReader.close();
                        return;
                    }
                    String strTrim = line.trim();
                    if (!strTrim.isEmpty()) {
                        d dVarJ = j(strTrim);
                        String str2 = (String) dVarJ.f13207a;
                        switch (str2.hashCode()) {
                            case -1609594047:
                                if (!str2.equals("enabled")) {
                                    break;
                                } else {
                                    this.f11861b = "1".equals(dVarJ.f13208b);
                                    break;
                                }
                            case -985185247:
                                if (!str2.equals("proxyUrl")) {
                                    break;
                                } else {
                                    this.f11863d = (String) dVarJ.f13208b;
                                    break;
                                }
                            case -521223164:
                                if (!str2.equals("bypassRule")) {
                                    break;
                                } else {
                                    a((String) dVarJ.f13208b);
                                    break;
                                }
                            case 735170733:
                                if (!str2.equals("reverseBypassRules")) {
                                    break;
                                } else {
                                    this.f11862c = "1".equals(dVarJ.f13208b);
                                    break;
                                }
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
        } finally {
            this.f11865f = hashCode();
        }
    }

    public void k(String str) {
        if (this.f11864e == null || str.isEmpty()) {
            return;
        }
        this.f11864e.remove(str);
    }

    public void l(boolean z10) {
        this.f11861b = z10;
    }

    public void m(String str) {
        this.f11863d = str;
    }

    public void n(boolean z10) {
        this.f11862c = z10;
    }
}
