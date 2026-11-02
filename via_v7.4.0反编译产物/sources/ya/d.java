package ya;

import android.content.Context;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.util.Calendar;
import javax.security.auth.x500.X500Principal;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class d implements e {

    /* renamed from: a, reason: collision with root package name */
    public final Context f14519a;

    public d(Context context) {
        this.f14519a = context.getApplicationContext();
    }

    @Override // ya.e
    public boolean a(String str) throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        return keyStore.containsAlias(str);
    }

    @Override // ya.e
    public PublicKey b(String str) throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        if (keyStore.containsAlias(str)) {
            return keyStore.getCertificate(str).getPublicKey();
        }
        return null;
    }

    @Override // ya.e
    public void c(String str) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        if (a(str)) {
            return;
        }
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
        if (Build.VERSION.SDK_INT >= 23) {
            keyPairGenerator.initialize(new KeyGenParameterSpec.Builder(str, 3).setKeySize(2048).setEncryptionPaddings("PKCS1Padding").build());
        } else {
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.add(1, 20);
            KeyPairGeneratorSpec.Builder endDate = new KeyPairGeneratorSpec.Builder(this.f14519a).setAlias(str).setSubject(new X500Principal("CN=" + str)).setSerialNumber(new BigInteger(64, new SecureRandom())).setStartDate(calendar.getTime()).setEndDate(calendar2.getTime());
            endDate.setKeySize(2048);
            keyPairGenerator.initialize(endDate.build());
        }
        keyPairGenerator.generateKeyPair();
    }

    @Override // ya.e
    public PrivateKey d(String str) throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        if (keyStore.containsAlias(str)) {
            return (PrivateKey) keyStore.getKey(str, null);
        }
        return null;
    }
}
