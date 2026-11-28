package g2;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class o extends b6 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f5150c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f5151d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AccountManager f5152e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Boolean f5153f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f5154g;

    public o(h5 h5Var) {
        super(h5Var);
    }

    @Override // g2.b6
    public final boolean j() {
        Calendar calendar = Calendar.getInstance();
        this.f5150c = TimeUnit.MINUTES.convert(calendar.get(15) + calendar.get(16), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        Locale locale2 = Locale.ENGLISH;
        this.f5151d = language.toLowerCase(locale2) + "-" + locale.getCountry().toLowerCase(locale2);
        return false;
    }

    public final long o() {
        h();
        return this.f5154g;
    }

    public final long p() {
        k();
        return this.f5150c;
    }

    public final String q() {
        k();
        return this.f5151d;
    }

    public final void r() {
        h();
        this.f5153f = null;
        this.f5154g = 0L;
    }

    public final boolean s() {
        h();
        long jA = this.f4646a.a().a();
        if (jA - this.f5154g > 86400000) {
            this.f5153f = null;
        }
        Boolean bool = this.f5153f;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (o.a.a(this.f4646a.c(), "android.permission.GET_ACCOUNTS") != 0) {
            this.f4646a.d().y().a("Permission error checking for dasher/unicorn accounts");
            this.f5154g = jA;
            this.f5153f = Boolean.FALSE;
            return false;
        }
        if (this.f5152e == null) {
            this.f5152e = AccountManager.get(this.f4646a.c());
        }
        try {
            Account[] result = this.f5152e.getAccountsByTypeAndFeatures("com.google", new String[]{"service_HOSTED"}, null, null).getResult();
            if (result != null && result.length > 0) {
                this.f5153f = Boolean.TRUE;
                this.f5154g = jA;
                return true;
            }
            Account[] result2 = this.f5152e.getAccountsByTypeAndFeatures("com.google", new String[]{"service_uca"}, null, null).getResult();
            if (result2 != null && result2.length > 0) {
                this.f5153f = Boolean.TRUE;
                this.f5154g = jA;
                return true;
            }
            this.f5154g = jA;
            this.f5153f = Boolean.FALSE;
            return false;
        } catch (AuthenticatorException e10) {
            e = e10;
            this.f4646a.d().t().b("Exception checking account types", e);
        } catch (OperationCanceledException e11) {
            e = e11;
            this.f4646a.d().t().b("Exception checking account types", e);
        } catch (IOException e12) {
            e = e12;
            this.f4646a.d().t().b("Exception checking account types", e);
        }
    }
}
