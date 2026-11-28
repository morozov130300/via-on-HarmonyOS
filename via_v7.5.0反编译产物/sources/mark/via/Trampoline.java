package mark.via;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import la.s;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class Trampoline extends Activity {
    public final void a(Intent intent) {
        if (intent != null && intent.hasExtra("android.support.customtabs.extra.SESSION") && s.j().v().j()) {
            c(intent);
        } else {
            b(intent);
        }
    }

    public final void b(Intent intent) {
        Intent intent2 = new Intent(intent);
        intent2.setFlags(intent2.getFlags() & (-32769));
        intent2.setClass(this, Shell.class);
        startActivity(intent2);
        finish();
    }

    public final void c(Intent intent) {
        Intent intent2 = new Intent(intent);
        intent2.setClass(this, CustomTab.class);
        startActivity(intent2);
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(getIntent());
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a(intent);
    }
}
