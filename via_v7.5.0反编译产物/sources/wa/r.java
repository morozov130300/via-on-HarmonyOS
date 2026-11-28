package wa;

import android.R;
import android.app.AlertDialog;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.biometrics.BiometricPrompt;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.CancellationSignal;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.Fragment;
import java.util.concurrent.Executor;
import w7.u;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class r implements wa.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f14399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.activity.result.b f14400b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public wa.b f14402d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Executor f14403e = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f14401c = c.a();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b extends BiometricPrompt.AuthenticationCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f14406a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f14407b;

        public b(String str, String str2) {
            this.f14406a = str;
            this.f14407b = str2;
        }

        @Override // android.hardware.biometrics.BiometricPrompt.AuthenticationCallback
        public void onAuthenticationError(int i10, CharSequence charSequence) {
            if (i10 == 11 || i10 == 14) {
                r.this.m(false);
                return;
            }
            if (i10 == 10 || i10 == 13) {
                r.this.k();
            } else if (i10 == 12) {
                r.this.o(this.f14406a, this.f14407b);
            } else {
                r.this.l(charSequence.toString());
            }
        }

        @Override // android.hardware.biometrics.BiometricPrompt.AuthenticationCallback
        public void onAuthenticationFailed() {
            r.this.l(null);
        }

        @Override // android.hardware.biometrics.BiometricPrompt.AuthenticationCallback
        public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult authenticationResult) {
            r.this.m(true);
        }
    }

    public r(Fragment fragment) {
        this.f14399a = fragment;
        this.f14400b = Build.VERSION.SDK_INT >= 21 ? fragment.w2(new e.h(), new androidx.activity.result.a() { // from class: wa.o
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                r.d(this.f14392a, (ActivityResult) obj);
            }
        }) : null;
    }

    public static /* synthetic */ void b(r rVar, CancellationSignal cancellationSignal, DialogInterface dialogInterface, int i10) {
        rVar.getClass();
        cancellationSignal.cancel();
        rVar.k();
    }

    public static /* synthetic */ void c(r rVar, FingerprintManager fingerprintManager, CancellationSignal cancellationSignal, AlertDialog alertDialog, DialogInterface dialogInterface) {
        rVar.getClass();
        fingerprintManager.authenticate(null, cancellationSignal, 0, rVar.new a(alertDialog), null);
    }

    public static /* synthetic */ void d(r rVar, ActivityResult activityResult) {
        rVar.getClass();
        if (activityResult.b() == -1) {
            rVar.m(true);
        } else {
            rVar.l(null);
        }
    }

    @Override // wa.a
    public void a(String str, String str2, wa.b bVar) {
        if (bVar == null) {
            return;
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 21 || this.f14401c.b()) {
            bVar.onSuccess();
            return;
        }
        this.f14402d = bVar;
        if (i10 >= 29) {
            j(str, str2);
        } else {
            i(str, str2);
        }
    }

    public final void i(String str, String str2) {
        FingerprintManager fingerprintManagerA;
        if (Build.VERSION.SDK_INT < 23 || (fingerprintManagerA = k.a(this.f14399a.G().getSystemService("fingerprint"))) == null || !fingerprintManagerA.isHardwareDetected() || !fingerprintManagerA.hasEnrolledFingerprints()) {
            o(str, str2);
        } else {
            n(fingerprintManagerA, str);
        }
    }

    public final void j(String str, String str2) {
        Context contextG = this.f14399a.G();
        if (this.f14403e == null) {
            this.f14403e = o.a.h(contextG);
        }
        BiometricPrompt.Builder subtitle = new BiometricPrompt.Builder(contextG).setTitle(str).setSubtitle(str2);
        if (Build.VERSION.SDK_INT >= 30) {
            subtitle.setAllowedAuthenticators(33023);
        } else {
            subtitle.setDeviceCredentialAllowed(true);
        }
        subtitle.build().authenticate(new CancellationSignal(), this.f14403e, new b(str, str2));
    }

    public final void k() {
        wa.b bVar = this.f14402d;
        if (bVar == null) {
            return;
        }
        bVar.onCancel();
        this.f14402d = null;
    }

    public final void l(String str) {
        wa.b bVar = this.f14402d;
        if (bVar == null) {
            return;
        }
        bVar.a(str);
        this.f14402d = null;
    }

    public final void m(boolean z10) {
        wa.b bVar = this.f14402d;
        if (bVar == null) {
            return;
        }
        bVar.onSuccess();
        if (z10) {
            this.f14401c.c();
        }
        this.f14402d = null;
    }

    public final void n(final FingerprintManager fingerprintManager, String str) {
        Context contextG = this.f14399a.G();
        final CancellationSignal cancellationSignal = new CancellationSignal();
        final AlertDialog alertDialogCreate = new AlertDialog.Builder(contextG).setTitle(str).setMessage(u.fi).setNegativeButton(contextG.getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: wa.p
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                r.b(this.f14393a, cancellationSignal, dialogInterface, i10);
            }
        }).create();
        alertDialogCreate.setOnShowListener(new DialogInterface.OnShowListener() { // from class: wa.q
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                r.c(this.f14395a, fingerprintManager, cancellationSignal, alertDialogCreate, dialogInterface);
            }
        });
        alertDialogCreate.show();
    }

    public final void o(String str, String str2) {
        Intent intentCreateConfirmDeviceCredentialIntent;
        if (this.f14400b == null) {
            l("Credential launcher not set");
            return;
        }
        KeyguardManager keyguardManager = (KeyguardManager) this.f14399a.G().getSystemService("keyguard");
        if (keyguardManager == null || !keyguardManager.isKeyguardSecure() || (intentCreateConfirmDeviceCredentialIntent = keyguardManager.createConfirmDeviceCredentialIntent(str, str2)) == null) {
            m(false);
        } else {
            this.f14400b.a(intentCreateConfirmDeviceCredentialIntent);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends FingerprintManager.AuthenticationCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AlertDialog f14404a;

        public a(AlertDialog alertDialog) {
            this.f14404a = alertDialog;
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationError(int i10, CharSequence charSequence) {
            this.f14404a.dismiss();
            if (i10 == 10 || i10 == 13) {
                r.this.k();
            } else {
                r.this.l(charSequence.toString());
            }
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
            this.f14404a.dismiss();
            r.this.m(true);
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationFailed() {
        }
    }
}
