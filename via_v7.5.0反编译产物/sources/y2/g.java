package y2;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f14824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f14825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final File f14826c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final File f14827d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final File f14828e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final File f14829f;

    public g(Context context) {
        String str;
        File filesDir = context.getFilesDir();
        this.f14824a = filesDir;
        if (v()) {
            str = ".com.google.firebase.crashlytics.files.v2" + File.pathSeparator + u(Application.getProcessName());
        } else {
            str = ".com.google.firebase.crashlytics.files.v1";
        }
        File fileQ = q(new File(filesDir, str));
        this.f14825b = fileQ;
        this.f14826c = q(new File(fileQ, "open-sessions"));
        this.f14827d = q(new File(fileQ, "reports"));
        this.f14828e = q(new File(fileQ, "priority-reports"));
        this.f14829f = q(new File(fileQ, "native-reports"));
    }

    public static synchronized File q(File file) {
        try {
            if (file.exists()) {
                if (file.isDirectory()) {
                    return file;
                }
                q2.f.f().b("Unexpected non-directory file: " + file + "; deleting file and creating new directory.");
                file.delete();
            }
            if (!file.mkdirs()) {
                q2.f.f().d("Could not create Crashlytics-specific directory: " + file);
            }
            return file;
        } catch (Throwable th) {
            throw th;
        }
    }

    public static File r(File file) {
        file.mkdirs();
        return file;
    }

    public static boolean s(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                s(file2);
            }
        }
        return file.delete();
    }

    public static List t(Object[] objArr) {
        return objArr == null ? Collections.EMPTY_LIST : Arrays.asList(objArr);
    }

    public static String u(String str) {
        return str.replaceAll("[^a-zA-Z0-9.]", "_");
    }

    public static boolean v() {
        return Build.VERSION.SDK_INT >= 28;
    }

    public final void a(File file) {
        if (file.exists() && s(file)) {
            q2.f.f().b("Deleted previous Crashlytics file system: " + file.getPath());
        }
    }

    public void b() {
        a(new File(this.f14824a, ".com.google.firebase.crashlytics"));
        a(new File(this.f14824a, ".com.google.firebase.crashlytics-ndk"));
        if (v()) {
            a(new File(this.f14824a, ".com.google.firebase.crashlytics.files.v1"));
        }
    }

    public boolean c(String str) {
        return s(new File(this.f14826c, str));
    }

    public List d() {
        return t(this.f14826c.list());
    }

    public File e(String str) {
        return new File(this.f14825b, str);
    }

    public List f(FilenameFilter filenameFilter) {
        return t(this.f14825b.listFiles(filenameFilter));
    }

    public File g(String str) {
        return new File(this.f14829f, str);
    }

    public List h() {
        return t(this.f14829f.listFiles());
    }

    public File i(String str) {
        return r(new File(n(str), "native"));
    }

    public File j(String str) {
        return new File(this.f14828e, str);
    }

    public List k() {
        return t(this.f14828e.listFiles());
    }

    public File l(String str) {
        return new File(this.f14827d, str);
    }

    public List m() {
        return t(this.f14827d.listFiles());
    }

    public final File n(String str) {
        return r(new File(this.f14826c, str));
    }

    public File o(String str, String str2) {
        return new File(n(str), str2);
    }

    public List p(String str, FilenameFilter filenameFilter) {
        return t(n(str).listFiles(filenameFilter));
    }
}
