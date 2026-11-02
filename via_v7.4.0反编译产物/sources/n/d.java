package n;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import x.e;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class d extends Activity implements androidx.lifecycle.h, e.a {

    /* renamed from: e, reason: collision with root package name */
    public k.g f10041e = new k.g();

    /* renamed from: j, reason: collision with root package name */
    public androidx.lifecycle.i f10042j = new androidx.lifecycle.i(this);

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static boolean q(String[] strArr) {
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
        if (decorView == null || !x.e.d(decorView, keyEvent)) {
            return x.e.e(this, decorView, this, keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !x.e.d(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    @Override // x.e.a
    public boolean j(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        androidx.lifecycle.o.e(this);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        this.f10042j.j(Lifecycle.State.CREATED);
        super.onSaveInstanceState(bundle);
    }

    public final boolean p(String[] strArr) {
        return !q(strArr);
    }
}
