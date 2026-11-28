package mark.via.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.RemoteViews;
import mark.via.Shell;
import w7.p;
import w7.r;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class SearchWidgetProvider extends AppWidgetProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f10393a;

    static {
        f10393a = Build.VERSION.SDK_INT >= 23 ? 201326592 : 134217728;
    }

    public final PendingIntent a(Context context) {
        Intent intent = new Intent(context, (Class<?>) Shell.class);
        intent.setAction("mark.via.SEARCH");
        intent.setPackage(context.getPackageName());
        return PendingIntent.getActivity(context, 0, intent, f10393a);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        super.onUpdate(context, appWidgetManager, iArr);
        PendingIntent pendingIntentA = a(context);
        for (int i10 : iArr) {
            if (i10 != 0) {
                RemoteViews remoteViews = new RemoteViews(context.getPackageName(), r.D);
                remoteViews.setOnClickPendingIntent(p.A, pendingIntentA);
                appWidgetManager.updateAppWidget(i10, remoteViews);
            }
        }
    }
}
