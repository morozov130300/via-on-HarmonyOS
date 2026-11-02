package i4;

import f4.c;
import java.io.File;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class a {
    public static String a(File file) {
        try {
            return c.b(file);
        } catch (Exception unused) {
            System.out.println("APK : " + file.getAbsolutePath() + " not have channel info from Zip Comment");
            return null;
        }
    }

    public static String b(File file) {
        System.out.println("try to read channel info from apk : " + file.getAbsolutePath());
        return b.d(file, -2012129793);
    }
}
