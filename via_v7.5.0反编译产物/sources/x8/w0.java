package x8;

import android.util.Base64;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class w0 {
    public static String a(String str, String str2, String str3) {
        if (str != null && str2 != null && str3 != null) {
            try {
                IvParameterSpec ivParameterSpec = new IvParameterSpec(str2.getBytes("UTF-8"));
                SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes("UTF-8"), "AES");
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
                cipher.init(2, secretKeySpec, ivParameterSpec);
                return new String(cipher.doFinal(Base64.decode(str3, 0)));
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return null;
    }

    public static String b(byte[] bArr, String str) {
        if (bArr != null && bArr.length >= 32 && str != null) {
            try {
                byte[] bArrDecode = Base64.decode(str, 2);
                if (bArrDecode.length < 16) {
                    return null;
                }
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, 0, 32, "AES");
                byte[] bArrCopyOfRange = Arrays.copyOfRange(bArrDecode, 0, 16);
                byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArrDecode, 16, bArrDecode.length);
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
                cipher.init(2, secretKeySpec, new IvParameterSpec(bArrCopyOfRange));
                return new String(cipher.doFinal(bArrCopyOfRange2), "UTF-8");
            } catch (Exception e10) {
                tc.a.j(e10);
            }
        }
        return null;
    }

    public static boolean c(byte[] bArr, File file, File file2) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr2 = new byte[16];
                if (fileInputStream.read(bArr2) != 16) {
                    fileInputStream.close();
                    return false;
                }
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(2, new SecretKeySpec(bArr, "AES"), new IvParameterSpec(bArr2));
                CipherInputStream cipherInputStream = new CipherInputStream(fileInputStream, cipher);
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] bArr3 = new byte[4096];
                    while (true) {
                        int i10 = cipherInputStream.read(bArr3);
                        if (i10 == -1) {
                            fileOutputStream.close();
                            cipherInputStream.close();
                            fileInputStream.close();
                            return true;
                        }
                        fileOutputStream.write(bArr3, 0, i10);
                        try {
                            fileInputStream.close();
                        } catch (Throwable th) {
                            th.addSuppressed(th);
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                    throw th2;
                }
            } catch (Throwable th4) {
                fileInputStream.close();
                throw th4;
            }
        } catch (Exception e10) {
            tc.a.j(e10);
            return false;
        }
        tc.a.j(e10);
        return false;
    }

    public static byte[] d(ya.e eVar, byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            PrivateKey privateKeyD = eVar.d("mark.via.ViaPass");
            if (privateKeyD == null) {
                tc.a.i("No private key found", new Object[0]);
                return null;
            }
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(2, privateKeyD);
            return cipher.doFinal(bArr);
        } catch (Exception e10) {
            tc.a.j(e10);
            return null;
        }
    }

    public static byte[] e(ya.e eVar, byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            PublicKey publicKeyB = eVar.b("mark.via.ViaPass");
            if (publicKeyB == null) {
                tc.a.i("No public key found", new Object[0]);
                return null;
            }
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, publicKeyB);
            return cipher.doFinal(bArr);
        } catch (Exception e10) {
            tc.a.j(e10);
            return null;
        }
    }

    public static String f(String str, String str2, String str3) {
        if (str != null && str2 != null && str3 != null) {
            try {
                IvParameterSpec ivParameterSpec = new IvParameterSpec(str2.getBytes("UTF-8"));
                SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes("UTF-8"), "AES");
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
                cipher.init(1, secretKeySpec, ivParameterSpec);
                return Base64.encodeToString(cipher.doFinal(str3.getBytes()), 0);
            } catch (Exception e10) {
                tc.a.j(e10);
            }
        }
        return null;
    }

    public static String g(byte[] bArr, String str) {
        if (bArr != null && bArr.length >= 32 && str != null) {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, 0, 32, "AES");
                byte[] bArr2 = new byte[16];
                new SecureRandom().nextBytes(bArr2);
                IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
                cipher.init(1, secretKeySpec, ivParameterSpec);
                byte[] bArrDoFinal = cipher.doFinal(str.getBytes("UTF-8"));
                byte[] bArr3 = new byte[bArrDoFinal.length + 16];
                System.arraycopy(bArr2, 0, bArr3, 0, 16);
                System.arraycopy(bArrDoFinal, 0, bArr3, 16, bArrDoFinal.length);
                return Base64.encodeToString(bArr3, 2);
            } catch (Exception e10) {
                tc.a.j(e10);
            }
        }
        return null;
    }

    public static boolean h(byte[] bArr, File file, File file2) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            byte[] bArr2 = new byte[16];
            new SecureRandom().nextBytes(bArr2);
            cipher.init(1, secretKeySpec, new IvParameterSpec(bArr2));
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    fileOutputStream.write(bArr2);
                    CipherOutputStream cipherOutputStream = new CipherOutputStream(fileOutputStream, cipher);
                    byte[] bArr3 = new byte[4096];
                    while (true) {
                        int i10 = fileInputStream.read(bArr3);
                        if (i10 == -1) {
                            cipherOutputStream.close();
                            fileOutputStream.close();
                            fileInputStream.close();
                            return true;
                        }
                        cipherOutputStream.write(bArr3, 0, i10);
                        try {
                            fileInputStream.close();
                        } catch (Throwable th) {
                            th.addSuppressed(th);
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                    throw th2;
                }
            } catch (Throwable th4) {
                fileInputStream.close();
                throw th4;
            }
        } catch (Exception e10) {
            tc.a.j(e10);
            return false;
        }
    }

    public static void i(ya.e eVar) {
        if (eVar.a("mark.via.ViaPass")) {
            return;
        }
        eVar.c("mark.via.ViaPass");
    }

    public static String j(byte[] bArr) {
        try {
            return Base64.encodeToString(bArr, 2);
        } catch (Exception e10) {
            tc.a.j(e10);
            return null;
        }
    }

    public static byte[] k(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(str.toCharArray(), str2.getBytes("UTF-8"), 10000, 256)).getEncoded();
        } catch (Exception e10) {
            tc.a.j(e10);
            return null;
        }
    }

    public static byte[] l(String str) {
        try {
            return Base64.decode(str, 2);
        } catch (Exception e10) {
            tc.a.j(e10);
            return null;
        }
    }
}
