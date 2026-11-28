package mark.via;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class Search extends Activity {
    public final void a(Intent intent) {
        Intent intent2;
        if (intent == null) {
            intent2 = new Intent(this, (Class<?>) Shell.class);
        } else {
            Intent intent3 = new Intent(intent);
            intent3.setClass(this, Shell.class);
            if (Build.VERSION.SDK_INT >= 22) {
                intent3.putExtra("mark.via.REFERER", getReferrer());
            }
            intent2 = intent3;
        }
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
