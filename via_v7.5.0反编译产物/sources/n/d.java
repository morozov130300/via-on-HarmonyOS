package n;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.lifecycle.Lifecycle;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class d extends Activity implements androidx.lifecycle.j, y.e.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public k.g f10406c = new k.g();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public androidx.lifecycle.k f10407e = new androidx.lifecycle.k(this);

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static boolean p(String[] strArr) {
        if (strArr != null && strArr.length > 0) {
            String str = strArr[0];
            str.getClass();
            switch (str) {
                case "--translation":
                    if (Build.VERSION.SDK_INT >= 31) {
                        return true;
                    }
                    break;
                case "--contentcapture":
                    return Build.VERSION.SDK_INT >= 29;
                case "--autofill":
                    return Build.VERSION.SDK_INT >= 26;
            }
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !y.e.d(decorView, keyEvent)) {
            return y.e.e(this, decorView, this, keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !y.e.d(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    @Override // y.e.a
    public boolean l(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public final boolean o(String[] strArr) {
        return !p(strArr);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        androidx.lifecycle.q.e(this);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        this.f10407e.j(Lifecycle.State.CREATED);
        super.onSaveInstanceState(bundle);
    }
}
