package mark.via.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.RemoteViews;
import mark.via.Shell;
import x7.p;
import x7.r;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class SearchWidgetProvider extends AppWidgetProvider {

    /* renamed from: a, reason: collision with root package name */
    public static final int f10029a;

    static {
        f10029a = Build.VERSION.SDK_INT >= 23 ? 201326592 : 134217728;
    }

    public final PendingIntent a(Context context) {
        Intent intent = new Intent(context, (Class<?>) Shell.class);
        intent.setAction("mark.via.SEARCH");
        intent.setPackage(context.getPackageName());
        return PendingIntent.getActivity(context, 0, intent, f10029a);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        super.onUpdate(context, appWidgetManager, iArr);
        PendingIntent pendingIntentA = a(context);
        for (int i10 : iArr) {
            if (i10 != 0) {
                RemoteViews remoteViews = new RemoteViews(context.getPackageName(), r.E);
                remoteViews.setOnClickPendingIntent(p.B, pendingIntentA);
                appWidgetManager.updateAppWidget(i10, remoteViews);
            }
        }
    }
}
