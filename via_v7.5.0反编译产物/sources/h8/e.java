package h8;

import android.content.Context;
import android.content.Intent;
import mark.via.service.ReadAloudService;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class e {
    public static void a(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) ReadAloudService.class);
        intent.setAction("mark.via.receiver.ReadAloudReceiver.PAUSE");
        if (str != null) {
            intent.putExtra(Name.MARK, str);
        }
        o.a.l(context, intent);
    }

    public static void b(Context context, String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) ReadAloudService.class);
        intent.setAction("mark.via.receiver.ReadAloudReceiver.PLAY");
        intent.putExtra(Name.MARK, str);
        o.a.l(context, intent);
    }

    public static void c(Context context, String str, int i10) {
        if (str == null || str.isEmpty()) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) ReadAloudService.class);
        intent.setAction("mark.via.receiver.ReadAloudReceiver.PLAY");
        intent.putExtra(Name.MARK, str);
        intent.putExtra("index", i10);
        o.a.l(context, intent);
    }

    public static void d(Context context) {
        Intent intent = new Intent(context, (Class<?>) ReadAloudService.class);
        intent.setAction("mark.via.receiver.ReadAloudReceiver.STOP");
        o.a.l(context, intent);
    }
}
