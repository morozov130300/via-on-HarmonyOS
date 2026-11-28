package mark.via.download;

import android.content.Context;
import android.content.Intent;
import mark.via.service.DownloadService;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class k {
    public static void a(Context context, long j10) {
        Intent intent = new Intent(context, (Class<?>) DownloadService.class);
        intent.setAction("mark.via.receiver.DownloadReceiver.PAUSE");
        intent.putExtra(Name.MARK, j10);
        e(context, intent);
    }

    public static void b(Context context, long j10) {
        Intent intent = new Intent(context, (Class<?>) DownloadService.class);
        intent.setAction("mark.via.receiver.DownloadReceiver.REDOWNLOAD");
        intent.putExtra(Name.MARK, j10);
        e(context, intent);
    }

    public static void c(Context context, long j10) {
        Intent intent = new Intent(context, (Class<?>) DownloadService.class);
        intent.setAction("mark.via.receiver.DownloadReceiver.RESUME");
        intent.putExtra(Name.MARK, j10);
        e(context, intent);
    }

    public static void d(Context context) {
        Intent intent = new Intent(context, (Class<?>) DownloadService.class);
        intent.setAction("mark.via.receiver.DownloadReceiver.PAUSE_ALL");
        e(context, intent);
    }

    public static void e(Context context, Intent intent) {
        try {
            o.a.l(context, intent);
        } catch (IllegalStateException e10) {
            tc.a.b(e10);
        }
    }
}
