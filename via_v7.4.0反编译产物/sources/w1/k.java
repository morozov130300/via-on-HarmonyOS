package w1;

import android.os.Process;
import android.os.StrictMode;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static String f13220a;

    /* renamed from: b, reason: collision with root package name */
    public static int f13221b;

    public static String a() throws Throwable {
        BufferedReader bufferedReader;
        if (f13220a == null) {
            int iMyPid = f13221b;
            if (iMyPid == 0) {
                iMyPid = Process.myPid();
                f13221b = iMyPid;
            }
            String strTrim = null;
            strTrim = null;
            strTrim = null;
            BufferedReader bufferedReader2 = null;
            if (iMyPid > 0) {
                try {
                    String str = "/proc/" + iMyPid + "/cmdline";
                    StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        bufferedReader = new BufferedReader(new FileReader(str));
                    } finally {
                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                    }
                } catch (IOException unused) {
                    bufferedReader = null;
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    String line = bufferedReader.readLine();
                    t1.f.h(line);
                    strTrim = line.trim();
                } catch (IOException unused2) {
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader2 = bufferedReader;
                    i.a(bufferedReader2);
                    throw th;
                }
                i.a(bufferedReader);
            }
            f13220a = strTrim;
        }
        return f13220a;
    }
}
