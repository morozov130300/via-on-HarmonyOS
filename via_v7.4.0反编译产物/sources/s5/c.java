package s5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class c {
    public static String a(String str) throws NoSuchAlgorithmException {
        if (str == null || str.isEmpty()) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb2 = new StringBuilder();
            for (byte b10 : bArrDigest) {
                String hexString = Integer.toHexString(b10 & 255);
                for (int iMax = Math.max(0, 2 - hexString.length()); iMax > 0; iMax--) {
                    sb2.append(0);
                }
                sb2.append(hexString);
            }
            return sb2.toString();
        } catch (NoSuchAlgorithmException e10) {
            e10.printStackTrace();
            return Integer.toHexString(str.hashCode());
        }
    }
}
