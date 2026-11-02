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
import x7.u;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class r implements wa.a {

    /* renamed from: a, reason: collision with root package name */
    public final Fragment f13396a;

    /* renamed from: b, reason: collision with root package name */
    public final androidx.activity.result.b f13397b;

    /* renamed from: d, reason: collision with root package name */
    public wa.b f13399d;

    /* renamed from: e, reason: collision with root package name */
    public Executor f13400e = null;

    /* renamed from: c, reason: collision with root package name */
    public final c f13398c = c.a();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends FingerprintManager.AuthenticationCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AlertDialog f13401a;

        public a(AlertDialog alertDialog) {
            this.f13401a = alertDialog;
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationError(int i10, CharSequence charSequence) {
            this.f13401a.dismiss();
            if (i10 == 10 || i10 == 13) {
                r.this.k();
            } else {
                r.this.l(charSequence.toString());
            }
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationFailed() {
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
            this.f13401a.dismiss();
            r.this.m(true);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b extends BiometricPrompt.AuthenticationCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f13403a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f13404b;

        public b(String str, String str2) {
            this.f13403a = str;
            this.f13404b = str2;
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
                r.this.o(this.f13403a, this.f13404b);
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
        this.f13396a = fragment;
        this.f13397b = Build.VERSION.SDK_INT >= 21 ? fragment.y2(new e.h(), new androidx.activity.result.a() { // from class: wa.o
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                r.d(this.f13389a, (ActivityResult) obj);
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
        if (i10 < 21 || this.f13398c.b()) {
            bVar.onSuccess();
            return;
        }
        this.f13399d = bVar;
        if (i10 >= 29) {
            j(str, str2);
        } else {
            i(str, str2);
        }
    }

    public final void i(String str, String str2) {
        FingerprintManager fingerprintManagerA;
        if (Build.VERSION.SDK_INT < 23 || (fingerprintManagerA = k.a(this.f13396a.I().getSystemService("fingerprint"))) == null || !fingerprintManagerA.isHardwareDetected() || !fingerprintManagerA.hasEnrolledFingerprints()) {
            o(str, str2);
        } else {
            n(fingerprintManagerA, str);
        }
    }

    public final void j(String str, String str2) {
        Context contextI = this.f13396a.I();
        if (this.f13400e == null) {
            this.f13400e = o.a.h(contextI);
        }
        BiometricPrompt.Builder subtitle = new BiometricPrompt.Builder(contextI).setTitle(str).setSubtitle(str2);
        if (Build.VERSION.SDK_INT >= 30) {
            subtitle.setAllowedAuthenticators(33023);
        } else {
            subtitle.setDeviceCredentialAllowed(true);
        }
        subtitle.build().authenticate(new CancellationSignal(), this.f13400e, new b(str, str2));
    }

    public final void k() {
        wa.b bVar = this.f13399d;
        if (bVar == null) {
            return;
        }
        bVar.onCancel();
        this.f13399d = null;
    }

    public final void l(String str) {
        wa.b bVar = this.f13399d;
        if (bVar == null) {
            return;
        }
        bVar.a(str);
        this.f13399d = null;
    }

    public final void m(boolean z10) {
        wa.b bVar = this.f13399d;
        if (bVar == null) {
            return;
        }
        bVar.onSuccess();
        if (z10) {
            this.f13398c.c();
        }
        this.f13399d = null;
    }

    public final void n(final FingerprintManager fingerprintManager, String str) {
        Context contextI = this.f13396a.I();
        final CancellationSignal cancellationSignal = new CancellationSignal();
        final AlertDialog alertDialogCreate = new AlertDialog.Builder(contextI).setTitle(str).setMessage(u.Fh).setNegativeButton(contextI.getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: wa.p
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                r.b(this.f13390a, cancellationSignal, dialogInterface, i10);
            }
        }).create();
        alertDialogCreate.setOnShowListener(new DialogInterface.OnShowListener() { // from class: wa.q
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                r.c(this.f13392a, fingerprintManager, cancellationSignal, alertDialogCreate, dialogInterface);
            }
        });
        alertDialogCreate.show();
    }

    public final void o(String str, String str2) {
        Intent intentCreateConfirmDeviceCredentialIntent;
        if (this.f13397b == null) {
            l("Credential launcher not set");
            return;
        }
        KeyguardManager keyguardManager = (KeyguardManager) this.f13396a.I().getSystemService("keyguard");
        if (keyguardManager == null || !keyguardManager.isKeyguardSecure() || (intentCreateConfirmDeviceCredentialIntent = keyguardManager.createConfirmDeviceCredentialIntent(str, str2)) == null) {
            m(false);
        } else {
            this.f13397b.a(intentCreateConfirmDeviceCredentialIntent);
        }
    }
}
