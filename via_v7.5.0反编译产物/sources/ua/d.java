package ua;

import android.util.Base64;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12940b;

    public d(String str, String str2) {
        this.f12939a = str;
        this.f12940b = str2;
    }

    public static d e(String str) {
        int length;
        int iLastIndexOf = str == null ? -1 : str.lastIndexOf(35);
        if (iLastIndexOf >= 0 && str.contains("://")) {
            String[] strArr = {"md5", "sha256"};
            for (int i10 = 0; i10 < 2; i10++) {
                String str2 = strArr[i10];
                int iIndexOf = str.indexOf(str2, iLastIndexOf + 1);
                if (iIndexOf >= 0 && (length = iIndexOf + str2.length()) < str.length() && (str.charAt(length) == '=' || str.charAt(length) == '-')) {
                    int i11 = length + 1;
                    int i12 = i11;
                    while (i12 < str.length() && str.charAt(i12) != ',' && str.charAt(i12) != ';') {
                        i12++;
                    }
                    return new d(str2.equals("md5") ? "MD5" : "SHA-256", str.substring(i11, i12));
                }
            }
        }
        return null;
    }

    public boolean a(File file) {
        MessageDigest messageDigestD = d();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int i10 = fileInputStream.read(bArr);
                    if (i10 == -1) {
                        fileInputStream.close();
                        return c(messageDigestD.digest());
                    }
                    messageDigestD.update(bArr, 0, i10);
                    return false;
                }
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException unused) {
            return false;
        }
    }

    public boolean b(byte[] bArr) {
        return c(d().digest(bArr));
    }

    public final boolean c(byte[] bArr) {
        if (this.f12940b.length() != bArr.length * 2) {
            try {
                return MessageDigest.isEqual(bArr, Base64.decode(this.f12940b, 0));
            } catch (IllegalArgumentException unused) {
                return false;
            }
        }
        for (int i10 = 0; i10 < bArr.length; i10++) {
            int i11 = bArr[i10] & 255;
            int i12 = i10 * 2;
            if (Character.digit(this.f12940b.charAt(i12), 16) != i11 / 16 || Character.digit(this.f12940b.charAt(i12 + 1), 16) != i11 % 16) {
                return false;
            }
        }
        return true;
    }

    public final MessageDigest d() {
        try {
            return MessageDigest.getInstance(this.f12939a);
        } catch (NoSuchAlgorithmException e10) {
            throw new IllegalStateException(e10);
        }
    }
}
