package m5;

import downloader.DownloaderException;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Throwable f7921b;

    public h(int i10, Throwable th) {
        this.f7920a = i10;
        this.f7921b = th;
    }

    public static String b(int i10) {
        if (i10 == 1) {
            return "User Cancel";
        }
        if (i10 == 2) {
            return "Unsupported Protocol";
        }
        if (i10 == 11) {
            return "Can Not Create File";
        }
        if (i10 == 12) {
            return "Can Not Write File";
        }
        if (i10 == 40) {
            return "Decode Error";
        }
        switch (i10) {
            case 20:
                return "Http Data Error";
            case 21:
                return "Http Bad Request";
            case 22:
                return "Certificate Error";
            case 23:
                return "Network Timeout";
            case 24:
                return "Non Resumable";
            case 25:
                return "Too Many Redirects";
            default:
                switch (i10) {
                    case 30:
                        return "Task Submit Failed";
                    case 31:
                        return "Chunk Verify Failed";
                    case 32:
                        return "No Network Connection";
                    default:
                        return null;
                }
        }
    }

    public static h f(int i10) {
        return g(i10, null, null);
    }

    public static h g(int i10, String str, Throwable th) {
        if (str == null) {
            str = b(i10);
        }
        return new h(i10, new DownloaderException(str, th));
    }

    public static h h(int i10, Throwable th) {
        return g(i10, null, th);
    }

    public static h i(int i10, String str) {
        return g(i10, "HTTP Error: " + i10 + " " + str, null);
    }

    public int a() {
        return this.f7920a;
    }

    public String c() {
        Throwable th = this.f7921b;
        if (th == null || th.getMessage() == null) {
            return null;
        }
        return this.f7921b.getMessage();
    }

    public Throwable d() {
        return this.f7921b;
    }

    public boolean e() {
        int i10 = this.f7920a;
        return i10 == 503 || i10 == 500 || i10 == 20 || i10 == 23 || i10 == 31;
    }

    public String toString() {
        return "DownloadError{code=" + this.f7920a + ", throwable=" + this.f7921b + '}';
    }
}
