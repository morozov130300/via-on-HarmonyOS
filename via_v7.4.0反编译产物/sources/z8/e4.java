package z8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class e4 {
    public static boolean a(InputStream inputStream, String str) throws IOException {
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
                                }
                                fileOutputStream.close();
                                long time = nextEntry.getTime();
                                if (time > 0) {
                                    file.setLastModified(time);
                                }
                            } finally {
                            }
                        }
                    }
                } finally {
                }
            }
        } catch (Exception e10) {
            pc.a.d(e10);
            return false;
        }
    }

    public static boolean b(String str, String str2) throws IOException {
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            try {
                boolean zA = a(fileInputStream, str2);
                fileInputStream.close();
                return zA;
            } finally {
            }
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0058 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v10, types: [int] */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8, types: [int] */
    /* JADX WARN: Type inference failed for: r6v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean c(String str, List list) throws Throwable {
        ?? r62;
        if (list == null || list.isEmpty()) {
            return false;
        }
        HashSet hashSet = new HashSet();
        try {
            try {
                ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(str));
                try {
                    Iterator it = list.iterator();
                    ?? r63 = 0;
                    while (it.hasNext()) {
                        try {
                            File file = (File) it.next();
                            if (d(file.getParent(), file.getName(), zipOutputStream, hashSet)) {
                                r63++;
                            }
                        } catch (Throwable th) {
                            th = th;
                            list = r63;
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
                    r62 = r63;
                } catch (Throwable th3) {
                    th = th3;
                    list = null;
                }
            } catch (Exception e10) {
                e = e10;
                pc.a.d(e);
                r62 = list;
                if (r62 > 0) {
                }
            }
        } catch (Exception e11) {
            e = e11;
            list = null;
            pc.a.d(e);
            r62 = list;
            if (r62 > 0) {
            }
        }
        return r62 > 0;
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
