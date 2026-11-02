package mark.via.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import mark.via.service.ReadAloudService;
import org.simpleframework.xml.strategy.Name;
import pc.a;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
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
