package f2;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.gc;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class n7 implements Application.ActivityLifecycleCallbacks {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ o7 f5530e;

    public n7(o7 o7Var) {
        this.f5530e = o7Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0073  */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onActivityCreated(Activity activity, Bundle bundle) throws Throwable {
        n7 n7Var;
        h5 h5Var;
        Uri uri;
        try {
            this.f5530e.f5030a.d().v().a("onActivityCreated");
            Intent intent = activity.getIntent();
            if (intent == null) {
                h5Var = this.f5530e.f5030a;
            } else {
                gc.b();
                Uri data = null;
                if (this.f5530e.f5030a.z().B(null, i3.H0)) {
                    Uri data2 = intent.getData();
                    if (data2 != null && data2.isHierarchical()) {
                        uri = data2;
                        if (uri == null && uri.isHierarchical()) {
                            this.f5530e.f5030a.N();
                            String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
                            String str = ("android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra)) ? "gs" : "auto";
                            String queryParameter = uri.getQueryParameter("referrer");
                            n7Var = this;
                            try {
                                try {
                                    this.f5530e.f5030a.f().z(new m7(n7Var, bundle == null, uri, str, queryParameter));
                                    h5Var = n7Var.f5530e.f5030a;
                                } catch (RuntimeException e10) {
                                    e = e10;
                                    n7Var.f5530e.f5030a.d().r().b("Throwable caught in onActivityCreated", e);
                                    h5Var = n7Var.f5530e.f5030a;
                                    h5Var.K().y(activity, bundle);
                                }
                            } catch (Throwable th) {
                                th = th;
                                n7Var.f5530e.f5030a.K().y(activity, bundle);
                                throw th;
                            }
                        } else {
                            h5Var = this.f5530e.f5030a;
                        }
                    }
                    Bundle extras = intent.getExtras();
                    if (extras != null) {
                        String string = extras.getString("com.android.vending.referral_url");
                        if (!TextUtils.isEmpty(string)) {
                            data = Uri.parse(string);
                        }
                    }
                } else {
                    data = intent.getData();
                }
                uri = data;
                if (uri == null) {
                    h5Var = this.f5530e.f5030a;
                }
            }
        } catch (RuntimeException e11) {
            e = e11;
            n7Var = this;
        } catch (Throwable th2) {
            th = th2;
            n7Var = this;
            n7Var.f5530e.f5030a.K().y(activity, bundle);
            throw th;
        }
        h5Var.K().y(activity, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        this.f5530e.f5030a.K().z(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        this.f5530e.f5030a.K().A(activity);
        u9 u9VarM = this.f5530e.f5030a.M();
        u9VarM.f5030a.f().z(new n9(u9VarM, u9VarM.f5030a.a().b()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        u9 u9VarM = this.f5530e.f5030a.M();
        u9VarM.f5030a.f().z(new m9(u9VarM, u9VarM.f5030a.a().b()));
        this.f5530e.f5030a.K().B(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.f5530e.f5030a.K().C(activity, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}
