package mark.via.browser;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class ld {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f9327a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f9328b = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final File f9329a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f9330b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f9331c = System.currentTimeMillis();

        public b(File file) {
            this.f9329a = file;
            this.f9330b = file.length();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f9332a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f9333b;

        public c() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface d {
        void a(File file);
    }

    public static File h(File file, String str, d dVar) throws IOException {
        String str2;
        if (!file.isDirectory() && !file.mkdirs() && !file.isDirectory()) {
            throw new IOException("Cannot create image cache directory");
        }
        if (str == null || str.isEmpty()) {
            str2 = "";
        } else {
            str2 = "." + str;
        }
        File fileCreateTempFile = File.createTempFile("image-", str2 + ".part", file);
        File file2 = new File(file, fileCreateTempFile.getName().substring(0, fileCreateTempFile.getName().length() + (-5)));
        try {
            dVar.a(fileCreateTempFile);
            if (!fileCreateTempFile.isFile() || !fileCreateTempFile.canRead() || fileCreateTempFile.length() == 0) {
                throw new IOException("Empty or unreadable image");
            }
            if (!fileCreateTempFile.renameTo(file2)) {
                throw new IOException("Cannot publish image cache file");
            }
            if (fileCreateTempFile.exists()) {
                fileCreateTempFile.delete();
            }
            return file2;
        } catch (Throwable th) {
            if (fileCreateTempFile.exists()) {
                fileCreateTempFile.delete();
            }
            throw th;
        }
    }

    public void a(String str, File file) {
        this.f9328b.put(str, new b(file));
    }

    public void b() {
        this.f9327a.clear();
    }

    public int c(String str) {
        c cVar = (c) this.f9327a.remove(str);
        if (cVar == null) {
            return 0;
        }
        return cVar.f9332a;
    }

    public File d(String str) {
        b bVar = (b) this.f9328b.get(str);
        if (bVar == null) {
            return null;
        }
        if (bVar.f9329a.isFile() && bVar.f9329a.canRead() && bVar.f9330b > 0 && bVar.f9329a.length() == bVar.f9330b && System.currentTimeMillis() - bVar.f9331c < 86400000) {
            return bVar.f9329a;
        }
        this.f9328b.remove(str);
        return null;
    }

    public int e(String str) {
        c cVar = (c) this.f9327a.get(str);
        if (cVar == null) {
            return 0;
        }
        return cVar.f9332a;
    }

    public boolean f(String str, int i10) {
        c cVar = (c) this.f9327a.get(str);
        if (cVar != null) {
            cVar.f9332a |= i10;
            return false;
        }
        c cVar2 = new c();
        cVar2.f9332a = i10;
        this.f9327a.put(str, cVar2);
        return true;
    }

    public boolean g(String str) {
        c cVar = (c) this.f9327a.get(str);
        if (cVar == null || cVar.f9333b) {
            return false;
        }
        cVar.f9333b = true;
        return true;
    }
}
