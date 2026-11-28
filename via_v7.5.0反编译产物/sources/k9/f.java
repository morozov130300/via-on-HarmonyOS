package k9;

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
import u9.n;
import x8.f4;
import x8.w3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class f implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w9.a f7231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7232b;

    public f(w9.a aVar, String str) {
        this.f7231a = aVar;
        this.f7232b = str;
    }

    @Override // k9.b
    public List a(c cVar) {
        File fileA = cVar.a("favorites.txt");
        if (fileA == null) {
            return Collections.EMPTY_LIST;
        }
        List<l9.b> listH = this.f7231a.h();
        if (listH.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileA));
            try {
                for (l9.b bVar : listH) {
                    bufferedWriter.write(c6.i.f2031a.g(bVar.g(), bVar.e(), bVar.d()));
                    bufferedWriter.newLine();
                }
                bufferedWriter.flush();
                arrayList.add(new a(fileA));
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
        String str = this.f7232b;
        if (str != null && !str.isEmpty()) {
            HashSet hashSet = new HashSet();
            Iterator it = listH.iterator();
            while (it.hasNext()) {
                hashSet.add(w3.l(this.f7232b, ((l9.b) it.next()).g()));
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
                                    } catch (Throwable th3) {
                                        try {
                                            fileInputStream.close();
                                        } catch (Throwable th4) {
                                            th3.addSuppressed(th4);
                                        }
                                        throw th3;
                                    }
                                } catch (Exception e11) {
                                    tc.a.j(e11);
                                }
                            }
                        }
                        if (i10 > 0) {
                            arrayList.add(new a(fileA2));
                        }
                        zipOutputStream.close();
                    } catch (Throwable th5) {
                        try {
                            zipOutputStream.close();
                        } catch (Throwable th6) {
                            th5.addSuppressed(th6);
                        }
                        throw th5;
                    }
                } catch (IOException e12) {
                    tc.a.j(e12);
                }
            }
        }
        return arrayList;
    }

    @Override // k9.b
    public void b(c cVar, int i10) {
        File fileA;
        File fileA2 = cVar.a("favorites.txt");
        if (fileA2 == null || !fileA2.isFile()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileA2));
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    c6.h hVarC = c6.i.f2031a.c(line);
                    if (hVarC != null) {
                        l9.b bVar = new l9.b(hVarC.c(), hVarC.b());
                        bVar.n(hVarC.a());
                        arrayList.add(bVar);
                    }
                    fileA = cVar.a("icons.zip");
                    if (fileA == null && fileA.isFile()) {
                        File file = new File(this.f7232b);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        try {
                            f4.b(fileA.getAbsolutePath(), file.getCanonicalPath());
                            return;
                        } catch (IOException unused) {
                            f4.b(fileA.getAbsolutePath(), file.getAbsolutePath());
                            return;
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
                tc.a.j(e);
            }
            if (arrayList.size() > 0) {
                boolean z10 = i10 == 1;
                if (!z10 && i10 == 2) {
                    int size = this.f7231a.h().size();
                    int size2 = arrayList.size();
                    z10 = size2 > size || size - size2 < size / 2;
                }
                if (z10) {
                    this.f7231a.n();
                }
                this.f7231a.j(arrayList);
            }
            n.e().u(true);
            bufferedReader.close();
        } catch (IOException e10) {
            tc.a.j(e10);
        }
        fileA = cVar.a("icons.zip");
        if (fileA == null) {
        }
    }
}
