package f2;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class o extends b6 {

    /* renamed from: c, reason: collision with root package name */
    public long f5534c;

    /* renamed from: d, reason: collision with root package name */
    public String f5535d;

    /* renamed from: e, reason: collision with root package name */
    public AccountManager f5536e;

    /* renamed from: f, reason: collision with root package name */
    public Boolean f5537f;

    /* renamed from: g, reason: collision with root package name */
    public long f5538g;

    public o(h5 h5Var) {
        super(h5Var);
    }

    @Override // f2.b6
    public final boolean j() {
        Calendar calendar = Calendar.getInstance();
        this.f5534c = TimeUnit.MINUTES.convert(calendar.get(15) + calendar.get(16), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        Locale locale2 = Locale.ENGLISH;
        this.f5535d = language.toLowerCase(locale2) + "-" + locale.getCountry().toLowerCase(locale2);
        return false;
    }

    public final long o() {
        h();
        return this.f5538g;
    }

    public final long p() {
        k();
        return this.f5534c;
    }

    public final String q() {
        k();
        return this.f5535d;
    }

    public final void r() {
        h();
        this.f5537f = null;
        this.f5538g = 0L;
    }

    public final boolean s() throws OperationCanceledException, IOException, AuthenticatorException {
        Account[] result;
        h();
        long jA = this.f5030a.a().a();
        if (jA - this.f5538g > 86400000) {
            this.f5537f = null;
        }
        Boolean bool = this.f5537f;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (o.a.a(this.f5030a.c(), "android.permission.GET_ACCOUNTS") != 0) {
            this.f5030a.d().y().a("Permission error checking for dasher/unicorn accounts");
            this.f5538g = jA;
            this.f5537f = Boolean.FALSE;
            return false;
        }
        if (this.f5536e == null) {
            this.f5536e = AccountManager.get(this.f5030a.c());
        }
        try {
            result = this.f5536e.getAccountsByTypeAndFeatures("com.google", new String[]{"service_HOSTED"}, null, null).getResult();
        } catch (AuthenticatorException e10) {
            e = e10;
            this.f5030a.d().t().b("Exception checking account types", e);
            this.f5538g = jA;
            this.f5537f = Boolean.FALSE;
            return false;
        } catch (OperationCanceledException e11) {
            e = e11;
            this.f5030a.d().t().b("Exception checking account types", e);
            this.f5538g = jA;
            this.f5537f = Boolean.FALSE;
            return false;
        } catch (IOException e12) {
            e = e12;
            this.f5030a.d().t().b("Exception checking account types", e);
            this.f5538g = jA;
            this.f5537f = Boolean.FALSE;
            return false;
        }
        if (result != null && result.length > 0) {
            this.f5537f = Boolean.TRUE;
            this.f5538g = jA;
            return true;
        }
        Account[] result2 = this.f5536e.getAccountsByTypeAndFeatures("com.google", new String[]{"service_uca"}, null, null).getResult();
        if (result2 != null && result2.length > 0) {
            this.f5537f = Boolean.TRUE;
            this.f5538g = jA;
            return true;
        }
        this.f5538g = jA;
        this.f5537f = Boolean.FALSE;
        return false;
    }
}
