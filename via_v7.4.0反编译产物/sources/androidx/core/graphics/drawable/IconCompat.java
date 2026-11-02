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
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: k, reason: collision with root package name */
    public static final PorterDuff.Mode f587k = PorterDuff.Mode.SRC_IN;

    /* renamed from: a, reason: collision with root package name */
    public int f588a;

    /* renamed from: b, reason: collision with root package name */
    public Object f589b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f590c;

    /* renamed from: d, reason: collision with root package name */
    public Parcelable f591d;

    /* renamed from: e, reason: collision with root package name */
    public int f592e;

    /* renamed from: f, reason: collision with root package name */
    public int f593f;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f594g;

    /* renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f595h;

    /* renamed from: i, reason: collision with root package name */
    public String f596i;

    /* renamed from: j, reason: collision with root package name */
    public String f597j;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
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
            switch (iconCompat.f588a) {
                case -1:
                    return (Icon) iconCompat.f589b;
                case 0:
                default:
                    throw new IllegalArgumentException("Unknown type");
                case 1:
                    iconCreateWithBitmap = Icon.createWithBitmap((Bitmap) iconCompat.f589b);
                    break;
                case 2:
                    iconCreateWithBitmap = Icon.createWithResource(iconCompat.i(), iconCompat.f592e);
                    break;
                case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                    iconCreateWithBitmap = Icon.createWithData((byte[]) iconCompat.f589b, iconCompat.f592e, iconCompat.f593f);
                    break;
                case 4:
                    iconCreateWithBitmap = Icon.createWithContentUri((String) iconCompat.f589b);
                    break;
                case 5:
                    if (Build.VERSION.SDK_INT < 26) {
                        iconCreateWithBitmap = Icon.createWithBitmap(IconCompat.c((Bitmap) iconCompat.f589b, false));
                        break;
                    } else {
                        iconCreateWithBitmap = b.b((Bitmap) iconCompat.f589b);
                        break;
                    }
                case 6:
                    int i10 = Build.VERSION.SDK_INT;
                    if (i10 >= 30) {
                        iconCreateWithBitmap = d.a(iconCompat.l());
                        break;
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
                            break;
                        } else {
                            iconCreateWithBitmap = b.b(BitmapFactory.decodeStream(inputStreamM));
                            break;
                        }
                    }
            }
            ColorStateList colorStateList = iconCompat.f594g;
            if (colorStateList != null) {
                iconCreateWithBitmap.setTintList(colorStateList);
            }
            PorterDuff.Mode mode = iconCompat.f595h;
            if (mode != IconCompat.f587k) {
                iconCreateWithBitmap.setTintMode(mode);
            }
            return iconCreateWithBitmap;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class b {
        public static Drawable a(Drawable drawable, Drawable drawable2) {
            return new AdaptiveIconDrawable(drawable, drawable2);
        }

        public static Icon b(Bitmap bitmap) {
            return Icon.createWithAdaptiveBitmap(bitmap);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
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

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class d {
        public static Icon a(Uri uri) {
            return Icon.createWithAdaptiveBitmapContentUri(uri);
        }
    }

    public IconCompat() {
        this.f588a = -1;
        this.f590c = null;
        this.f591d = null;
        this.f592e = 0;
        this.f593f = 0;
        this.f594g = null;
        this.f595h = f587k;
        this.f596i = null;
    }

    public IconCompat(int i10) {
        this.f590c = null;
        this.f591d = null;
        this.f592e = 0;
        this.f593f = 0;
        this.f594g = null;
        this.f595h = f587k;
        this.f596i = null;
        this.f588a = i10;
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
        w.c.c(bitmap);
        IconCompat iconCompat = new IconCompat(5);
        iconCompat.f589b = bitmap;
        return iconCompat;
    }

    public static IconCompat e(Bitmap bitmap) {
        w.c.c(bitmap);
        IconCompat iconCompat = new IconCompat(1);
        iconCompat.f589b = bitmap;
        return iconCompat;
    }

    public static IconCompat f(Context context, int i10) {
        w.c.c(context);
        return g(context.getResources(), context.getPackageName(), i10);
    }

    public static IconCompat g(Resources resources, String str, int i10) {
        w.c.c(str);
        if (i10 == 0) {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
        IconCompat iconCompat = new IconCompat(2);
        iconCompat.f592e = i10;
        if (resources != null) {
            try {
                iconCompat.f589b = resources.getResourceName(i10);
            } catch (Resources.NotFoundException unused) {
                throw new IllegalArgumentException("Icon resource cannot be found");
            }
        } else {
            iconCompat.f589b = str;
        }
        iconCompat.f597j = str;
        return iconCompat;
    }

    public static Resources j(Context context, String str) throws PackageManager.NameNotFoundException {
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
            case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
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

    public void a(Intent intent, Drawable drawable, Context context) throws PackageManager.NameNotFoundException {
        Bitmap bitmapCopy;
        b(context);
        int i10 = this.f588a;
        if (i10 == 1) {
            bitmapCopy = (Bitmap) this.f589b;
            if (drawable != null) {
                bitmapCopy = bitmapCopy.copy(bitmapCopy.getConfig(), true);
            }
        } else if (i10 == 2) {
            try {
                Context contextCreatePackageContext = context.createPackageContext(i(), 0);
                if (drawable == null) {
                    intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(contextCreatePackageContext, this.f592e));
                    return;
                }
                Drawable drawableE = o.a.e(contextCreatePackageContext, this.f592e);
                if (drawableE.getIntrinsicWidth() <= 0 || drawableE.getIntrinsicHeight() <= 0) {
                    int launcherLargeIconSize = ((ActivityManager) contextCreatePackageContext.getSystemService("activity")).getLauncherLargeIconSize();
                    bitmapCopy = Bitmap.createBitmap(launcherLargeIconSize, launcherLargeIconSize, Bitmap.Config.ARGB_8888);
                } else {
                    bitmapCopy = Bitmap.createBitmap(drawableE.getIntrinsicWidth(), drawableE.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                }
                drawableE.setBounds(0, 0, bitmapCopy.getWidth(), bitmapCopy.getHeight());
                drawableE.draw(new Canvas(bitmapCopy));
            } catch (PackageManager.NameNotFoundException e10) {
                throw new IllegalArgumentException("Can't find package " + this.f589b, e10);
            }
        } else {
            if (i10 != 5) {
                throw new IllegalArgumentException("Icon type not supported for intent shortcuts");
            }
            bitmapCopy = c((Bitmap) this.f589b, true);
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
        if (this.f588a != 2 || (obj = this.f589b) == null) {
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
            if (this.f592e != identifier) {
                Log.i("IconCompat", "Id has changed for " + strI + " " + str);
                this.f592e = identifier;
            }
        }
    }

    public int h() {
        int i10 = this.f588a;
        if (i10 == -1 && Build.VERSION.SDK_INT >= 23) {
            return a.a(this.f589b);
        }
        if (i10 == 2) {
            return this.f592e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public String i() {
        int i10 = this.f588a;
        if (i10 == -1 && Build.VERSION.SDK_INT >= 23) {
            return a.b(this.f589b);
        }
        if (i10 == 2) {
            String str = this.f597j;
            return (str == null || TextUtils.isEmpty(str)) ? ((String) this.f589b).split(":", -1)[0] : this.f597j;
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public int k() {
        int i10 = this.f588a;
        return (i10 != -1 || Build.VERSION.SDK_INT < 23) ? i10 : a.c(this.f589b);
    }

    public Uri l() {
        int i10 = this.f588a;
        if (i10 == -1 && Build.VERSION.SDK_INT >= 23) {
            return a.d(this.f589b);
        }
        if (i10 == 4 || i10 == 6) {
            return Uri.parse((String) this.f589b);
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
            return new FileInputStream(new File((String) this.f589b));
        } catch (FileNotFoundException e11) {
            Log.w("IconCompat", "Unable to load image from path: " + uriL, e11);
            return null;
        }
    }

    public void n() {
        this.f595h = PorterDuff.Mode.valueOf(this.f596i);
        switch (this.f588a) {
            case -1:
                Parcelable parcelable = this.f591d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                this.f589b = parcelable;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                Parcelable parcelable2 = this.f591d;
                if (parcelable2 != null) {
                    this.f589b = parcelable2;
                    return;
                }
                byte[] bArr = this.f590c;
                this.f589b = bArr;
                this.f588a = 3;
                this.f592e = 0;
                this.f593f = bArr.length;
                return;
            case 2:
            case 4:
            case 6:
                String str = new String(this.f590c, Charset.forName("UTF-16"));
                this.f589b = str;
                if (this.f588a == 2 && this.f597j == null) {
                    this.f597j = str.split(":", -1)[0];
                    return;
                }
                return;
            case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                this.f589b = this.f590c;
                return;
        }
    }

    public void o(boolean z10) {
        this.f596i = this.f595h.name();
        switch (this.f588a) {
            case -1:
                if (z10) {
                    throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
                }
                this.f591d = (Parcelable) this.f589b;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                if (!z10) {
                    this.f591d = (Parcelable) this.f589b;
                    return;
                }
                Bitmap bitmap = (Bitmap) this.f589b;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                this.f590c = byteArrayOutputStream.toByteArray();
                return;
            case 2:
                this.f590c = ((String) this.f589b).getBytes(Charset.forName("UTF-16"));
                return;
            case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                this.f590c = (byte[]) this.f589b;
                return;
            case 4:
            case 6:
                this.f590c = this.f589b.toString().getBytes(Charset.forName("UTF-16"));
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
        if (this.f588a == -1) {
            return String.valueOf(this.f589b);
        }
        StringBuilder sb2 = new StringBuilder("Icon(typ=");
        sb2.append(r(this.f588a));
        switch (this.f588a) {
            case 1:
            case 5:
                sb2.append(" size=");
                sb2.append(((Bitmap) this.f589b).getWidth());
                sb2.append("x");
                sb2.append(((Bitmap) this.f589b).getHeight());
                break;
            case 2:
                sb2.append(" pkg=");
                sb2.append(this.f597j);
                sb2.append(" id=");
                sb2.append(String.format("0x%08x", Integer.valueOf(h())));
                break;
            case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                sb2.append(" len=");
                sb2.append(this.f592e);
                if (this.f593f != 0) {
                    sb2.append(" off=");
                    sb2.append(this.f593f);
                    break;
                }
                break;
            case 4:
            case 6:
                sb2.append(" uri=");
                sb2.append(this.f589b);
                break;
        }
        if (this.f594g != null) {
            sb2.append(" tint=");
            sb2.append(this.f594g);
        }
        if (this.f595h != f587k) {
            sb2.append(" mode=");
            sb2.append(this.f595h);
        }
        sb2.append(")");
        return sb2.toString();
    }
}
