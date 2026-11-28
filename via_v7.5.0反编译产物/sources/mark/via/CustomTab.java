package mark.via;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.q;
import b6.a;
import com.tuyafeng.support.utils.FragmentUtils;
import la.s;
import m8.d;
import mark.via.CustomTab;
import mark.via.browser.q4;
import na.h;
import u9.l;
import w7.v;
import x8.f;
import x8.l0;
import x8.s1;
import y.k0;
import y.r;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class CustomTab extends q {
    public static final int K = FragmentUtils.f3568a;

    public static /* synthetic */ void R(FrameLayout frameLayout) {
        k0 k0VarY = r.y(frameLayout);
        l0.k((k0VarY == null || k0VarY.e() == null) ? false : true);
    }

    public q4 S() {
        Fragment fragmentN0 = K().n0(q4.class.getName());
        if (fragmentN0 instanceof q4) {
            return (q4) fragmentN0;
        }
        return null;
    }

    public final void T(Bundle bundle) {
        if (s.o().f()) {
            FragmentUtils.l(this, h.class, h.a3(1), null);
        } else {
            K().q().u(K, q4.class, bundle, q4.class.getName()).i();
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        String strM0 = s.j().M0();
        if (TextUtils.isEmpty(strM0)) {
            super.attachBaseContext(context);
            return;
        }
        Configuration configuration = new Configuration();
        s1.p(context, configuration, strM0);
        s1.l(configuration);
        super.attachBaseContext(context.createConfigurationContext(configuration));
    }

    @Override // android.app.Activity
    public void finish() {
        if (Build.VERSION.SDK_INT < 21 || !isTaskRoot()) {
            super.finish();
        } else {
            finishAndRemoveTask();
        }
    }

    @Override // androidx.fragment.app.q, androidx.activity.ComponentActivity, n.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        Bundle extras = intent == null ? null : intent.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        l lVarJ = s.j();
        int i10 = extras.getInt("androidx.browser.customtabs.extra.COLOR_SCHEME", 0);
        if (i10 == 0) {
            lVarJ.p0(com.tuyafeng.support.utils.q.a(this));
            setTheme(lVarJ.e() ? v.f14324a : v.f14325b);
        } else {
            setTheme(i10 == 2 ? v.f14324a : v.f14325b);
        }
        super.onCreate(bundle);
        final FrameLayout frameLayout = (FrameLayout) new a(new FrameLayout(this), new FrameLayout.LayoutParams(-1, -1)).o(K).l();
        setContentView(frameLayout);
        f.f(this);
        if (intent != null) {
            extras.putString("KEY_URL", intent.getDataString());
        }
        extras.putBoolean("CUSTOM_TAB", true);
        T(extras);
        frameLayout.post(new Runnable() { // from class: w7.h
            @Override // java.lang.Runnable
            public final void run() {
                CustomTab.R(frameLayout);
            }
        });
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent == null) {
            return;
        }
        for (androidx.lifecycle.f fVar : K().A0()) {
            if ((fVar instanceof d) && ((d) fVar).Z(intent)) {
                return;
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        q4 q4VarS = S();
        if (q4VarS != null) {
            q4VarS.s8(z10);
        }
    }
}
