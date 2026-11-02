package z8;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.PowerManager;
import android.provider.Settings;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import java.lang.reflect.Field;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class n3 {
    public static boolean a(Context context) {
        return Build.VERSION.SDK_INT < 36 || context.getResources().getConfiguration().smallestScreenWidthDp < 600;
    }

    public static int b(Context context) throws SecurityException {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return 255;
        }
        for (Field field : powerManager.getClass().getDeclaredFields()) {
            if ("BRIGHTNESS_ON".equals(field.getName())) {
                try {
                    field.setAccessible(true);
                    return ((Integer) field.get(powerManager)).intValue();
                } catch (IllegalAccessException | SecurityException unused) {
                    return 255;
                }
            }
        }
        return 255;
    }

    public static int c(Context context) {
        try {
            Resources resources = context.getResources();
            return resources.getInteger(resources.getIdentifier("config_screenBrightnessSettingMinimum", "integer", "android"));
        } catch (Exception unused) {
            return 0;
        }
    }

    public static float d(Context context) throws SecurityException {
        int i10 = Settings.System.getInt(context.getContentResolver(), "screen_brightness", 10);
        int iB = b(context);
        return (i10 - c(context)) / (iB - r3);
    }

    public static float e(Context context) {
        return g6.f.a(context).getWindow().getAttributes().screenBrightness;
    }

    public static int f(Context context) {
        Display display = Build.VERSION.SDK_INT >= 30 ? context.getDisplay() : g6.f.a(context).getWindowManager().getDefaultDisplay();
        if (display == null) {
            return -1;
        }
        int rotation = display.getRotation();
        if (rotation == 0) {
            return 1;
        }
        if (rotation == 2) {
            return 9;
        }
        if (rotation == 1) {
            return 0;
        }
        return rotation == 3 ? 8 : -1;
    }

    public static boolean g(Context context) {
        return h(context) && pa.r.j().v().m();
    }

    public static boolean h(Context context) {
        return (!context.getResources().getBoolean(x7.l.f13670a) || g6.o.f() || g6.o.g()) ? false : true;
    }

    public static void i(Context context, int i10) {
        Activity activityA = g6.f.a(context);
        if (activityA == null || !a(context) || activityA.getRequestedOrientation() == i10) {
            return;
        }
        activityA.setRequestedOrientation(i10);
    }

    public static void j(Context context, float f10) {
        Window window = g6.f.a(context).getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = f10;
        window.setAttributes(attributes);
    }
}
