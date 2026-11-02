package qb;

import com.burgstaller.okhttp.digest.DigestAuthenticator;
import com.thegrizzlylabs.sardineandroid.impl.SardineException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.u;
import org.json.JSONException;
import org.json.JSONObject;
import z8.c1;
import z8.v0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class h implements d {

    /* renamed from: a, reason: collision with root package name */
    public final String f11457a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11458b;

    /* renamed from: c, reason: collision with root package name */
    public final j4.b f11459c;

    /* renamed from: d, reason: collision with root package name */
    public final String f11460d;

    /* renamed from: e, reason: collision with root package name */
    public final Map f11461e;

    /* renamed from: f, reason: collision with root package name */
    public final String f11462f;

    public h(String str, f fVar, String str2) throws IOException {
        if (str == null) {
            throw new NullPointerException("id == null");
        }
        if (fVar == null) {
            throw new NullPointerException("webDavConfig == null");
        }
        if (str2 == null) {
            throw new NullPointerException("tempDirectory == null");
        }
        this.f11457a = str;
        this.f11458b = str2;
        this.f11461e = new HashMap();
        q();
        u.b bVar = new u.b();
        x0.b bVar2 = new x0.b(fVar.f(), fVar.d());
        if (fVar.g()) {
            bVar.a(new v0.b(new DigestAuthenticator(bVar2), new ConcurrentHashMap()));
        } else {
            bVar.a(new w0.a(bVar2));
        }
        this.f11459c = new k4.a(bVar.b());
        this.f11460d = fVar.c();
        String strE = fVar.e();
        strE = (strE == null || strE.isEmpty()) ? "/Via" : strE;
        strE = strE.charAt(0) == '/' ? strE.substring(1) : strE;
        if (strE.length() > 0 && strE.charAt(strE.length() - 1) != '/') {
            strE = strE + '/';
        }
        this.f11462f = strE;
    }

    @Override // qb.d
    public void a(String str, boolean z10) throws IOException {
        File fileD = d(str, z10);
        if (fileD.isFile()) {
            fileD.delete();
        }
    }

    @Override // qb.d
    public long b(String str) {
        i(str);
        return k(str).c();
    }

    @Override // qb.d
    public void c(String str, File file, String str2, boolean z10) throws IOException {
        i(str);
        if (file == null) {
            throw new NullPointerException("file == null");
        }
        if (!file.exists()) {
            throw new FileNotFoundException("File not found at " + file.getAbsolutePath());
        }
        File fileD = d(str, true);
        if (!z10 && fileD.isFile() && c1.i(fileD, file) == -1) {
            pc.a.a("no diff for %s", str);
            return;
        }
        p(str);
        String strN = n(this.f11460d, str);
        if (str2 == null) {
            str2 = "application/octet-stream";
        }
        this.f11459c.b(strN, file, str2);
        c1.a(file, d(str, true));
        c cVarK = k(str);
        cVarK.f(e(str));
        cVarK.e(cVarK.d());
    }

    @Override // qb.d
    public File d(String str, boolean z10) throws IOException {
        i(str);
        String strG = v0.g(str);
        String str2 = this.f11458b;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(strG);
        sb2.append(z10 ? "-1" : "-0");
        File file = new File(str2, sb2.toString());
        if (c1.N(file.getParentFile())) {
            return file;
        }
        throw new IOException("Cannot create temp directory");
    }

    @Override // qb.d
    public long e(String str) {
        i(str);
        for (b bVar : o(str)) {
            if (str.equals(bVar.a())) {
                k(bVar.a()).f(bVar.b());
                return bVar.b();
            }
        }
        return 0L;
    }

    @Override // qb.d
    public boolean f() {
        return c1.f(new File(this.f11458b));
    }

    @Override // qb.d
    public void g() throws IOException {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(l()));
            try {
                Iterator it = this.f11461e.values().iterator();
                while (it.hasNext()) {
                    JSONObject jSONObjectG = ((c) it.next()).g();
                    if (jSONObjectG != null) {
                        bufferedWriter.write(jSONObjectG.toString());
                        bufferedWriter.newLine();
                    }
                }
                bufferedWriter.close();
            } finally {
            }
        } catch (IOException e10) {
            pc.a.i(e10);
        }
    }

    @Override // qb.d
    public String getPath() {
        return this.f11462f;
    }

    @Override // qb.d
    public InputStream h(String str) throws IOException {
        i(str);
        if (!this.f11459c.c(n(this.f11460d, str))) {
            throw new FileNotFoundException("File not found at " + str);
        }
        File fileD = d(str, true);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(this.f11459c.get(n(this.f11460d, str)));
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileD));
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int i10 = bufferedInputStream.read(bArr);
                    if (i10 == -1) {
                        bufferedOutputStream.flush();
                        bufferedOutputStream.close();
                        bufferedInputStream.close();
                        return new FileInputStream(fileD);
                    }
                    bufferedOutputStream.write(bArr, 0, i10);
                }
            } finally {
            }
        } catch (Throwable th) {
            try {
                bufferedInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final void i(String str) {
        if (str == null || str.isEmpty()) {
            throw new NullPointerException("text == null || text.isEmpty()");
        }
    }

    public void j(String str) {
        i(str);
        if (str.charAt(str.length() - 1) != '/') {
            str = str + '/';
        }
        this.f11459c.a(n(this.f11460d, str));
    }

    public final c k(String str) {
        c cVar = (c) this.f11461e.get(str);
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c(str);
        this.f11461e.put(str, cVar2);
        return cVar2;
    }

    public final File l() {
        File file = new File(this.f11458b);
        c1.N(file);
        return new File(file.getParentFile(), "timestamp.txt");
    }

    public boolean m(String str) throws SardineException {
        i(str);
        try {
            return this.f11459c.c(n(this.f11460d, str));
        } catch (SardineException e10) {
            if (e10.getStatusCode() == 405) {
                return true;
            }
            throw e10;
        }
    }

    public final String n(String str, String str2) {
        if (str2 == null || str2.isEmpty()) {
            return str;
        }
        if (str2.charAt(0) == '/') {
            str2 = str2.substring(1);
        }
        return str + str2;
    }

    public List o(String str) {
        ArrayList arrayList = new ArrayList();
        List<j4.a> listD = this.f11459c.d(n(this.f11460d, str));
        String str2 = this.f11460d;
        int iIndexOf = str2.indexOf(47, str2.indexOf("://") + 3);
        String strSubstring = iIndexOf > 0 ? this.f11460d.substring(iIndexOf) : null;
        for (j4.a aVar : listD) {
            String strW = aVar.w();
            if (strSubstring != null && strW.startsWith(strSubstring)) {
                strW = strW.substring(strSubstring.length());
            }
            String str3 = strW;
            Date dateO = aVar.o();
            Date dateU = aVar.u();
            if (dateO == null) {
                dateO = dateU;
            } else if (dateU == null) {
                dateU = dateO;
            } else {
                dateO = dateU;
                dateU = dateO;
            }
            arrayList.add(new b(str3, dateO == null ? 0L : dateO.getTime(), dateU != null ? dateU.getTime() : 0L));
        }
        return arrayList;
    }

    public final void p(String str) {
        int iIndexOf;
        if (str == null || str.isEmpty() || (iIndexOf = str.indexOf(47)) < 0) {
            return;
        }
        while (iIndexOf > 0 && iIndexOf <= str.length()) {
            int i10 = iIndexOf + 1;
            String strSubstring = str.substring(0, i10);
            if (!m(strSubstring)) {
                j(strSubstring);
            }
            iIndexOf = str.indexOf(47, i10);
        }
    }

    public final void q() throws IOException {
        File fileL = l();
        if (!fileL.exists()) {
            return;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileL));
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        bufferedReader.close();
                        return;
                    } else if (!line.isEmpty()) {
                        try {
                            c cVarA = c.a(new JSONObject(line));
                            this.f11461e.put(cVarA.b(), cVarA);
                        } catch (JSONException e10) {
                            pc.a.i(e10);
                        }
                    }
                } finally {
                }
            }
        } catch (IOException e11) {
            pc.a.i(e11);
        }
    }
}
