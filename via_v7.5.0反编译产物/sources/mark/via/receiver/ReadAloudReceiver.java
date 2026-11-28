package mark.via.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import mark.via.service.ReadAloudService;
import org.simpleframework.xml.strategy.Name;
import tc.a;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class ReadAloudReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action == null || !action.startsWith("mark.via.receiver.ReadAloudReceiver")) {
            return;
        }
        a.a("receive action: %s", action);
        Intent intent2 = new Intent(context.getApplicationContext(), (Class<?>) ReadAloudService.class);
        intent2.setAction(action);
        intent2.putExtra(Name.MARK, intent.getStringExtra(Name.MARK));
        o.a.l(context, intent2);
    }
}
