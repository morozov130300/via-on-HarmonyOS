package z8;

import android.app.ActivityOptions;
import android.os.Build;
import java.lang.reflect.Field;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class d {
    public static int a() throws NoSuchFieldException, SecurityException {
        try {
            Field declaredField = ActivityOptions.class.getDeclaredField("MODE_BACKGROUND_ACTIVITY_START_ALLOW_ALWAYS");
            declaredField.setAccessible(true);
            return declaredField.getInt(null);
        } catch (IllegalAccessException | NoSuchFieldException e10) {
            throw new RuntimeException("Background start mode cannot be found.", e10);
        }
    }

    public static void b(ActivityOptions activityOptions) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 34) {
            return;
        }
        if (i10 <= 35) {
            activityOptions.setPendingIntentBackgroundActivityStartMode(1);
        } else {
            activityOptions.setPendingIntentBackgroundActivityStartMode(a());
        }
    }
}
