package x8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class f4 {
    public static boolean a(InputStream inputStream, String str) {
        try {
            ZipInputStream zipInputStream = new ZipInputStream(inputStream);
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry == null) {
                        zipInputStream.close();
                        return true;
                    }
                    File file = new File(str, nextEntry.getName());
                    if (file.getCanonicalPath().startsWith(str)) {
                        if (nextEntry.isDirectory()) {
                            file.mkdirs();
                        } else {
                            if (!file.exists()) {
                                file.getParentFile().mkdirs();
                                file.createNewFile();
                            }
                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int i10 = zipInputStream.read(bArr);
                                    if (i10 == -1) {
                                        break;
                                    }
                                    fileOutputStream.write(bArr, 0, i10);
                                    fileOutputStream.flush();
                                    try {
                                        zipInputStream.close();
                                    } catch (Throwable th) {
                                        th.addSuppressed(th);
                                    }
                                    throw th;
                                }
                                fileOutputStream.close();
                                long time = nextEntry.getTime();
                                if (time > 0) {
                                    file.setLastModified(time);
                                }
                            } catch (Throwable th2) {
                                try {
                                    fileOutputStream.close();
                                } catch (Throwable th3) {
                                    th2.addSuppressed(th3);
                                }
                                throw th2;
                            }
                        }
                    }
                } catch (Throwable th4) {
                    zipInputStream.close();
                    throw th4;
                }
                tc.a.e(e);
                return false;
            }
        } catch (Exception e10) {
            tc.a.e(e10);
            return false;
        }
    }

    public static boolean b(String str, String str2) {
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            try {
                boolean zA = a(fileInputStream, str2);
                fileInputStream.close();
                return zA;
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0058 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    public static boolean c(String str, List list) throws Throwable {
        ?? r10;
        if (list == 0 || list.isEmpty()) {
            return false;
        }
        HashSet hashSet = new HashSet();
        try {
            try {
                ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(str));
                try {
                    int i10 = 0;
                    for (File file : list) {
                        try {
                            if (d(file.getParent(), file.getName(), zipOutputStream, hashSet)) {
                                i10++;
                            }
                        } catch (Throwable th) {
                            th = th;
                            list = i10;
                            try {
                                zipOutputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    }
                    zipOutputStream.finish();
                    zipOutputStream.close();
                    r10 = i10;
                } catch (Throwable th3) {
                    th = th3;
                    list = 0;
                }
            } catch (Exception e10) {
                e = e10;
                tc.a.e(e);
                r10 = list;
                if (r10 > 0) {
                    return true;
                }
                return false;
            }
        } catch (Exception e11) {
            e = e11;
            list = 0;
            tc.a.e(e);
            r10 = list;
        }
        if (r10 > 0) {
            return true;
        }
        return false;
    }

    public static boolean d(String str, String str2, ZipOutputStream zipOutputStream, Set set) throws IOException {
        if (zipOutputStream == null) {
            return false;
        }
        File file = new File(str, str2);
        if (!file.exists()) {
            return false;
        }
        if (!file.isFile()) {
            String[] list = file.list();
            if (list == null || list.length <= 0) {
                String str3 = str2.replace(File.separatorChar, '/') + "/";
                if (!set.add(str3)) {
                    return true;
                }
                ZipEntry zipEntry = new ZipEntry(str3);
                zipEntry.setTime(file.lastModified());
                zipOutputStream.putNextEntry(zipEntry);
                zipOutputStream.closeEntry();
                return true;
            }
            int i10 = 0;
            for (String str4 : list) {
                if (d(str, str2 + File.separator + str4, zipOutputStream, set)) {
                    i10++;
                }
            }
            return i10 == list.length;
        }
        String strReplace = str2.replace(File.separatorChar, '/');
        if (!set.add(strReplace)) {
            return true;
        }
        ZipEntry zipEntry2 = new ZipEntry(strReplace);
        zipEntry2.setTime(file.lastModified());
        zipOutputStream.putNextEntry(zipEntry2);
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int i11 = fileInputStream.read(bArr);
                if (i11 == -1) {
                    fileInputStream.close();
                    zipOutputStream.closeEntry();
                    return true;
                }
                zipOutputStream.write(bArr, 0, i11);
            }
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
