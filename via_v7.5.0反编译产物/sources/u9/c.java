package u9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import x8.v0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12909a;

    public c(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("path == null || path.isEmpty()");
        }
        this.f12909a = str;
    }

    public final File a(String str) {
        return new File(this.f12909a, v0.g(str));
    }

    public String b(String str, String str2) {
        String strC;
        return (str == null || str.isEmpty() || (strC = c(a(str))) == null) ? str2 : strC;
    }

    public final String c(File file) throws Throwable {
        BufferedReader bufferedReader = null;
        if (file == null || !file.isFile()) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            break;
                        }
                        sb2.append(line);
                        sb2.append("\n");
                    } catch (Exception e10) {
                        e = e10;
                        bufferedReader = bufferedReader2;
                        tc.a.b(e);
                        com.tuyafeng.support.utils.j.a(bufferedReader);
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        com.tuyafeng.support.utils.j.a(bufferedReader);
                        throw th;
                    }
                }
                com.tuyafeng.support.utils.j.a(bufferedReader2);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e11) {
            e = e11;
        }
        return sb2.toString();
    }

    public void d(String str, String str2) throws Throwable {
        if (str == null || str.isEmpty()) {
            return;
        }
        e(a(str), str2);
    }

    public final void e(File file, String str) throws Throwable {
        File parentFile;
        if (file == null || (parentFile = file.getParentFile()) == null) {
            return;
        }
        if (parentFile.isFile() && !parentFile.delete()) {
            return;
        }
        if (!parentFile.exists() && !parentFile.mkdirs()) {
            return;
        }
        OutputStreamWriter outputStreamWriter = null;
        try {
            try {
                OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(new FileOutputStream(file), k8.a.f7218a);
                try {
                    outputStreamWriter2.write(str);
                    com.tuyafeng.support.utils.j.a(outputStreamWriter2);
                } catch (Exception e10) {
                    e = e10;
                    outputStreamWriter = outputStreamWriter2;
                    tc.a.b(e);
                    com.tuyafeng.support.utils.j.a(outputStreamWriter);
                } catch (Throwable th) {
                    th = th;
                    outputStreamWriter = outputStreamWriter2;
                    com.tuyafeng.support.utils.j.a(outputStreamWriter);
                    throw th;
                }
            } catch (Exception e11) {
                e = e11;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
