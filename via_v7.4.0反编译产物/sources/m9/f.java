package m9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.json.JSONException;
import org.json.JSONObject;
import z8.e4;
import z8.w3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class f implements b {

    /* renamed from: a, reason: collision with root package name */
    public final y9.a f8690a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8691b;

    public f(y9.a aVar, String str) {
        this.f8690a = aVar;
        this.f8691b = str;
    }

    @Override // m9.b
    public List a(c cVar) throws IOException {
        File fileA = cVar.a("favorites.txt");
        if (fileA == null) {
            return Collections.EMPTY_LIST;
        }
        List<n9.b> listH = this.f8690a.h();
        if (listH.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileA));
            try {
                for (n9.b bVar : listH) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("title", bVar.e());
                    jSONObject.put("url", bVar.g());
                    jSONObject.put("order", bVar.d());
                    bufferedWriter.write(jSONObject.toString());
                    bufferedWriter.newLine();
                }
                bufferedWriter.flush();
                arrayList.add(new a(fileA));
                bufferedWriter.close();
            } finally {
                try {
                    bufferedWriter.close();
                } catch (Throwable th) {
                    th.addSuppressed(th);
                }
            }
        } catch (IOException | JSONException e10) {
            pc.a.i(e10);
        }
        String str = this.f8691b;
        if (str != null && !str.isEmpty()) {
            HashSet hashSet = new HashSet();
            Iterator it = listH.iterator();
            while (it.hasNext()) {
                hashSet.add(w3.l(this.f8691b, ((n9.b) it.next()).g()));
            }
            File fileA2 = cVar.a("icons.zip");
            if (fileA2 != null) {
                try {
                    ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(fileA2));
                    try {
                        Iterator it2 = hashSet.iterator();
                        int i10 = 0;
                        while (it2.hasNext()) {
                            File file = new File((String) it2.next());
                            if (file.isFile()) {
                                i10++;
                                try {
                                    FileInputStream fileInputStream = new FileInputStream(file);
                                    try {
                                        zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
                                        byte[] bArr = new byte[1024];
                                        while (true) {
                                            int i11 = fileInputStream.read(bArr);
                                            if (i11 <= 0) {
                                                break;
                                            }
                                            zipOutputStream.write(bArr, 0, i11);
                                        }
                                        zipOutputStream.closeEntry();
                                        fileInputStream.close();
                                    } catch (Throwable th2) {
                                        try {
                                            fileInputStream.close();
                                        } catch (Throwable th3) {
                                            th2.addSuppressed(th3);
                                        }
                                        throw th2;
                                    }
                                } catch (Exception e11) {
                                    pc.a.i(e11);
                                }
                            }
                        }
                        if (i10 > 0) {
                            arrayList.add(new a(fileA2));
                        }
                        zipOutputStream.close();
                    } finally {
                    }
                } catch (IOException e12) {
                    pc.a.i(e12);
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0075, code lost:
    
        if (r1.size() <= 0) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0077, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0078, code lost:
    
        if (r8 != 1) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007a, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007c, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007d, code lost:
    
        if (r4 != false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0080, code lost:
    
        if (r8 != 2) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0082, code lost:
    
        r8 = r6.f8690a.h().size();
        r4 = r1.size();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0090, code lost:
    
        if (r4 > r8) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0095, code lost:
    
        if ((r8 - r4) >= (r8 / 2)) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0097, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0098, code lost:
    
        r4 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0099, code lost:
    
        if (r4 == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x009b, code lost:
    
        r6.f8690a.n();
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a0, code lost:
    
        r6.f8690a.j(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00a5, code lost:
    
        w9.n.e().w(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00ac, code lost:
    
        r2.close();
     */
    @Override // m9.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(c cVar, int i10) throws IOException {
        File fileA = cVar.a("favorites.txt");
        if (fileA == null || !fileA.isFile()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileA));
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    if (line.isEmpty()) {
                        bufferedReader.close();
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(line);
                    n9.b bVar = new n9.b();
                    bVar.o(jSONObject.getString("title"));
                    bVar.q(jSONObject.getString("url"));
                    bVar.n(jSONObject.getInt("order"));
                    if (bVar.g() != null && !bVar.g().isEmpty()) {
                        arrayList.add(bVar);
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
        } catch (IOException | JSONException e10) {
            pc.a.i(e10);
        }
        File fileA2 = cVar.a("icons.zip");
        if (fileA2 == null || !fileA2.isFile()) {
            return;
        }
        File file = new File(this.f8691b);
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            e4.b(fileA2.getAbsolutePath(), file.getCanonicalPath());
        } catch (IOException unused) {
            e4.b(fileA2.getAbsolutePath(), file.getAbsolutePath());
        }
    }
}
