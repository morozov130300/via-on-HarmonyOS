package j4;

import g4.c;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
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
