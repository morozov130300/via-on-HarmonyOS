package androidx.core.graphics.drawable;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import org.chromium.support_lib_boundary.ProcessGlobalConfigConstants;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final PorterDuff.Mode f490k = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f493c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Parcelable f494d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f495e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f496f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ColorStateList f497g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f498h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f499i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f500j;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class a {
        public static int a(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.a(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getResId", null).invoke(obj, null)).intValue();
            } catch (IllegalAccessException e10) {
                Log.e("IconCompat", "Unable to get icon resource", e10);
                return 0;
            } catch (NoSuchMethodException e11) {
                Log.e("IconCompat", "Unable to get icon resource", e11);
                return 0;
            } catch (InvocationTargetException e12) {
                Log.e("IconCompat", "Unable to get icon resource", e12);
                return 0;
            }
        }

        public static String b(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.b(obj);
            }
            try {
                return (String) obj.getClass().getMethod("getResPackage", null).invoke(obj, null);
            } catch (IllegalAccessException e10) {
                Log.e("IconCompat", "Unable to get icon package", e10);
                return null;
            } catch (NoSuchMethodException e11) {
                Log.e("IconCompat", "Unable to get icon package", e11);
                return null;
            } catch (InvocationTargetException e12) {
                Log.e("IconCompat", "Unable to get icon package", e12);
                return null;
            }
        }

        public static int c(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.c(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getType", null).invoke(obj, null)).intValue();
            } catch (IllegalAccessException e10) {
                Log.e("IconCompat", "Unable to get icon type " + obj, e10);
                return -1;
            } catch (NoSuchMethodException e11) {
                Log.e("IconCompat", "Unable to get icon type " + obj, e11);
                return -1;
            } catch (InvocationTargetException e12) {
                Log.e("IconCompat", "Unable to get icon type " + obj, e12);
                return -1;
            }
        }

        public static Uri d(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.d(obj);
            }
            try {
                return (Uri) obj.getClass().getMethod("getUri", null).invoke(obj, null);
            } catch (IllegalAccessException e10) {
                Log.e("IconCompat", "Unable to get icon uri", e10);
                return null;
            } catch (NoSuchMethodException e11) {
                Log.e("IconCompat", "Unable to get icon uri", e11);
                return null;
            } catch (InvocationTargetException e12) {
                Log.e("IconCompat", "Unable to get icon uri", e12);
                return null;
            }
        }

        public static Drawable e(Icon icon, Context context) {
            return icon.loadDrawable(context);
        }

        public static Icon f(IconCompat iconCompat, Context context) {
            Icon iconCreateWithBitmap;
            switch (iconCompat.f491a) {
                case ProcessGlobalConfigConstants.UI_THREAD_STARTUP_MODE_DEFAULT /* -1 */:
                    return (Icon) iconCompat.f492b;
                case 0:
                default:
                    throw new IllegalArgumentException("Unknown type");
                case 1:
                    iconCreateWithBitmap = Icon.createWithBitmap((Bitmap) iconCompat.f492b);
                    break;
                case 2:
                    iconCreateWithBitmap = Icon.createWithResource(iconCompat.i(), iconCompat.f495e);
                    break;
                case 3:
                    iconCreateWithBitmap = Icon.createWithData((byte[]) iconCompat.f492b, iconCompat.f495e, iconCompat.f496f);
                    break;
                case 4:
                    iconCreateWithBitmap = Icon.createWithContentUri((String) iconCompat.f492b);
                    break;
                case 5:
                    iconCreateWithBitmap = Build.VERSION.SDK_INT < 26 ? Icon.createWithBitmap(IconCompat.c((Bitmap) iconCompat.f492b, false)) : b.b((Bitmap) iconCompat.f492b);
                    break;
                case 6:
                    int i10 = Build.VERSION.SDK_INT;
                    if (i10 >= 30) {
                        iconCreateWithBitmap = d.a(iconCompat.l());
                    } else {
                        if (context == null) {
                            throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + iconCompat.l());
                        }
                        InputStream inputStreamM = iconCompat.m(context);
                        if (inputStreamM == null) {
                            throw new IllegalStateException("Cannot load adaptive icon from uri: " + iconCompat.l());
                        }
                        if (i10 < 26) {
                            iconCreateWithBitmap = Icon.createWithBitmap(IconCompat.c(BitmapFactory.decodeStream(inputStreamM), false));
                        } else {
                            iconCreateWithBitmap = b.b(BitmapFactory.decodeStream(inputStreamM));
                        }
                    }
                    break;
            }
            ColorStateList colorStateList = iconCompat.f497g;
            if (colorStateList != null) {
                iconCreateWithBitmap.setTintList(colorStateList);
            }
            PorterDuff.Mode mode = iconCompat.f498h;
            if (mode != IconCompat.f490k) {
                iconCreateWithBitmap.setTintMode(mode);
            }
            return iconCreateWithBitmap;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class b {
        public static Drawable a(Drawable drawable, Drawable drawable2) {
            return new AdaptiveIconDrawable(drawable, drawable2);
        }

        public static Icon b(Bitmap bitmap) {
            return Icon.createWithAdaptiveBitmap(bitmap);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class c {
        public static int a(Object obj) {
            return ((Icon) obj).getResId();
        }

        public static String b(Object obj) {
            return ((Icon) obj).getResPackage();
        }

        public static int c(Object obj) {
            return ((Icon) obj).getType();
        }

        public static Uri d(Object obj) {
            return ((Icon) obj).getUri();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class d {
        public static Icon a(Uri uri) {
            return Icon.createWithAdaptiveBitmapContentUri(uri);
        }
    }

    public IconCompat() {
        this.f491a = -1;
        this.f493c = null;
        this.f494d = null;
        this.f495e = 0;
        this.f496f = 0;
        this.f497g = null;
        this.f498h = f490k;
        this.f499i = null;
    }

    public static Bitmap c(Bitmap bitmap, boolean z10) {
        int iMin = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMin, iMin, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(3);
        float f10 = iMin;
        float f11 = 0.5f * f10;
        float f12 = 0.9166667f * f11;
        if (z10) {
            float f13 = 0.010416667f * f10;
            paint.setColor(0);
            paint.setShadowLayer(f13, 0.0f, f10 * 0.020833334f, 1023410176);
            canvas.drawCircle(f11, f11, f12, paint);
            paint.setShadowLayer(f13, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f11, f11, f12, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - iMin)) / 2.0f, (-(bitmap.getHeight() - iMin)) / 2.0f);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f11, f11, f12, paint);
        canvas.setBitmap(null);
        return bitmapCreateBitmap;
    }

    public static IconCompat d(Bitmap bitmap) {
        x.c.c(bitmap);
        IconCompat iconCompat = new IconCompat(5);
        iconCompat.f492b = bitmap;
        return iconCompat;
    }

    public static IconCompat e(Bitmap bitmap) {
        x.c.c(bitmap);
        IconCompat iconCompat = new IconCompat(1);
        iconCompat.f492b = bitmap;
        return iconCompat;
    }

    public static IconCompat f(Context context, int i10) {
        x.c.c(context);
        return g(context.getResources(), context.getPackageName(), i10);
    }

    public static IconCompat g(Resources resources, String str, int i10) {
        x.c.c(str);
        if (i10 == 0) {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
        IconCompat iconCompat = new IconCompat(2);
        iconCompat.f495e = i10;
        if (resources != null) {
            try {
                iconCompat.f492b = resources.getResourceName(i10);
            } catch (Resources.NotFoundException unused) {
                throw new IllegalArgumentException("Icon resource cannot be found");
            }
        } else {
            iconCompat.f492b = str;
        }
        iconCompat.f500j = str;
        return iconCompat;
    }

    public static Resources j(Context context, String str) {
        if ("android".equals(str)) {
            return Resources.getSystem();
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 8192);
            if (applicationInfo != null) {
                return packageManager.getResourcesForApplication(applicationInfo);
            }
            return null;
        } catch (PackageManager.NameNotFoundException e10) {
            Log.e("IconCompat", String.format("Unable to find pkg=%s for icon", str), e10);
            return null;
        }
    }

    public static String r(int i10) {
        switch (i10) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    public void a(Intent intent, Drawable drawable, Context context) {
        Bitmap bitmapCopy;
        b(context);
        int i10 = this.f491a;
        if (i10 == 1) {
            bitmapCopy = (Bitmap) this.f492b;
            if (drawable != null) {
                bitmapCopy = bitmapCopy.copy(bitmapCopy.getConfig(), true);
            }
        } else if (i10 == 2) {
            try {
                Context contextCreatePackageContext = context.createPackageContext(i(), 0);
                if (drawable == null) {
                    intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(contextCreatePackageContext, this.f495e));
                    return;
                }
                Drawable drawableE = o.a.e(contextCreatePackageContext, this.f495e);
                if (drawableE.getIntrinsicWidth() <= 0 || drawableE.getIntrinsicHeight() <= 0) {
                    int launcherLargeIconSize = ((ActivityManager) contextCreatePackageContext.getSystemService("activity")).getLauncherLargeIconSize();
                    bitmapCopy = Bitmap.createBitmap(launcherLargeIconSize, launcherLargeIconSize, Bitmap.Config.ARGB_8888);
                } else {
                    bitmapCopy = Bitmap.createBitmap(drawableE.getIntrinsicWidth(), drawableE.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                }
                drawableE.setBounds(0, 0, bitmapCopy.getWidth(), bitmapCopy.getHeight());
                drawableE.draw(new Canvas(bitmapCopy));
            } catch (PackageManager.NameNotFoundException e10) {
                throw new IllegalArgumentException("Can't find package " + this.f492b, e10);
            }
        } else {
            if (i10 != 5) {
                throw new IllegalArgumentException("Icon type not supported for intent shortcuts");
            }
            bitmapCopy = c((Bitmap) this.f492b, true);
        }
        if (drawable != null) {
            int width = bitmapCopy.getWidth();
            int height = bitmapCopy.getHeight();
            drawable.setBounds(width / 2, height / 2, width, height);
            drawable.draw(new Canvas(bitmapCopy));
        }
        intent.putExtra("android.intent.extra.shortcut.ICON", bitmapCopy);
    }

    public void b(Context context) {
        Object obj;
        if (this.f491a != 2 || (obj = this.f492b) == null) {
            return;
        }
        String str = (String) obj;
        if (str.contains(":")) {
            String str2 = str.split(":", -1)[1];
            String str3 = str2.split("/", -1)[0];
            String str4 = str2.split("/", -1)[1];
            String str5 = str.split(":", -1)[0];
            if ("0_resource_name_obfuscated".equals(str4)) {
                Log.i("IconCompat", "Found obfuscated resource, not trying to update resource id for it");
                return;
            }
            String strI = i();
            int identifier = j(context, strI).getIdentifier(str4, str3, str5);
            if (this.f495e != identifier) {
                Log.i("IconCompat", "Id has changed for " + strI + " " + str);
                this.f495e = identifier;
            }
        }
    }

    public int h() {
        int i10 = this.f491a;
        if (i10 == -1 && Build.VERSION.SDK_INT >= 23) {
            return a.a(this.f492b);
        }
        if (i10 == 2) {
            return this.f495e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public String i() {
        int i10 = this.f491a;
        if (i10 == -1 && Build.VERSION.SDK_INT >= 23) {
            return a.b(this.f492b);
        }
        if (i10 == 2) {
            String str = this.f500j;
            return (str == null || TextUtils.isEmpty(str)) ? ((String) this.f492b).split(":", -1)[0] : this.f500j;
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public int k() {
        int i10 = this.f491a;
        return (i10 != -1 || Build.VERSION.SDK_INT < 23) ? i10 : a.c(this.f492b);
    }

    public Uri l() {
        int i10 = this.f491a;
        if (i10 == -1 && Build.VERSION.SDK_INT >= 23) {
            return a.d(this.f492b);
        }
        if (i10 == 4 || i10 == 6) {
            return Uri.parse((String) this.f492b);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    public InputStream m(Context context) {
        Uri uriL = l();
        String scheme = uriL.getScheme();
        if ("content".equals(scheme) || "file".equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(uriL);
            } catch (Exception e10) {
                Log.w("IconCompat", "Unable to load image from URI: " + uriL, e10);
                return null;
            }
        }
        try {
            return new FileInputStream(new File((String) this.f492b));
        } catch (FileNotFoundException e11) {
            Log.w("IconCompat", "Unable to load image from path: " + uriL, e11);
            return null;
        }
    }

    public void n() {
        this.f498h = PorterDuff.Mode.valueOf(this.f499i);
        switch (this.f491a) {
            case ProcessGlobalConfigConstants.UI_THREAD_STARTUP_MODE_DEFAULT /* -1 */:
                Parcelable parcelable = this.f494d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                this.f492b = parcelable;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                Parcelable parcelable2 = this.f494d;
                if (parcelable2 != null) {
                    this.f492b = parcelable2;
                    return;
                }
                byte[] bArr = this.f493c;
                this.f492b = bArr;
                this.f491a = 3;
                this.f495e = 0;
                this.f496f = bArr.length;
                return;
            case 2:
            case 4:
            case 6:
                String str = new String(this.f493c, Charset.forName("UTF-16"));
                this.f492b = str;
                if (this.f491a == 2 && this.f500j == null) {
                    this.f500j = str.split(":", -1)[0];
                    return;
                }
                return;
            case 3:
                this.f492b = this.f493c;
                return;
        }
    }

    public void o(boolean z10) {
        this.f499i = this.f498h.name();
        switch (this.f491a) {
            case ProcessGlobalConfigConstants.UI_THREAD_STARTUP_MODE_DEFAULT /* -1 */:
                if (z10) {
                    throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
                }
                this.f494d = (Parcelable) this.f492b;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                if (!z10) {
                    this.f494d = (Parcelable) this.f492b;
                    return;
                }
                Bitmap bitmap = (Bitmap) this.f492b;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                this.f493c = byteArrayOutputStream.toByteArray();
                return;
            case 2:
                this.f493c = ((String) this.f492b).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.f493c = (byte[]) this.f492b;
                return;
            case 4:
            case 6:
                this.f493c = this.f492b.toString().getBytes(Charset.forName("UTF-16"));
                return;
        }
    }

    public Icon p() {
        return q(null);
    }

    public Icon q(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return a.f(this, context);
        }
        throw new UnsupportedOperationException("This method is only supported on API level 23+");
    }

    public String toString() {
        if (this.f491a == -1) {
            return String.valueOf(this.f492b);
        }
        StringBuilder sb2 = new StringBuilder("Icon(typ=");
        sb2.append(r(this.f491a));
        switch (this.f491a) {
            case 1:
            case 5:
                sb2.append(" size=");
                sb2.append(((Bitmap) this.f492b).getWidth());
                sb2.append("x");
                sb2.append(((Bitmap) this.f492b).getHeight());
                break;
            case 2:
                sb2.append(" pkg=");
                sb2.append(this.f500j);
                sb2.append(" id=");
                sb2.append(String.format("0x%08x", Integer.valueOf(h())));
                break;
            case 3:
                sb2.append(" len=");
                sb2.append(this.f495e);
                if (this.f496f != 0) {
                    sb2.append(" off=");
                    sb2.append(this.f496f);
                }
                break;
            case 4:
            case 6:
                sb2.append(" uri=");
                sb2.append(this.f492b);
                break;
        }
        if (this.f497g != null) {
            sb2.append(" tint=");
            sb2.append(this.f497g);
        }
        if (this.f498h != f490k) {
            sb2.append(" mode=");
            sb2.append(this.f498h);
        }
        sb2.append(")");
        return sb2.toString();
    }

    public IconCompat(int i10) {
        this.f493c = null;
        this.f494d = null;
        this.f495e = 0;
        this.f496f = 0;
        this.f497g = null;
        this.f498h = f490k;
        this.f499i = null;
        this.f491a = i10;
    }
}
