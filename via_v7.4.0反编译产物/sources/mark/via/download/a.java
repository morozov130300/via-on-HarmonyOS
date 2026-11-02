package mark.via.download;

import android.content.Context;
import android.content.Intent;
import mark.via.service.DownloadService;
import org.simpleframework.xml.strategy.Name;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class a {
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
            pc.a.b(e10);
        }
    }
}
