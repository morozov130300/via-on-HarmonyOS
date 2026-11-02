package z8;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.util.Size;
import java.io.IOException;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class t3 {
    /* JADX WARN: Removed duplicated region for block: B:27:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x004f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap a(Context context, Uri uri) {
        ContentResolver contentResolver;
        Exception exc;
        long j10;
        int columnIndex;
        if (context == null || uri == null || (contentResolver = context.getContentResolver()) == null) {
            return null;
        }
        try {
            Cursor cursorQuery = contentResolver.query(uri, new String[]{"_id"}, null, null, null);
            if (cursorQuery != null) {
                try {
                    j10 = (!cursorQuery.moveToFirst() || (columnIndex = cursorQuery.getColumnIndex("_id")) < 0) ? 0L : cursorQuery.getLong(columnIndex);
                    if (cursorQuery != null) {
                        try {
                            cursorQuery.close();
                        } catch (Exception e10) {
                            exc = e10;
                            exc.printStackTrace();
                            if (j10 <= 0) {
                            }
                        }
                    }
                } finally {
                }
            }
        } catch (Exception e11) {
            exc = e11;
            j10 = 0;
            exc.printStackTrace();
            if (j10 <= 0) {
            }
        }
        if (j10 <= 0) {
            return null;
        }
        return MediaStore.Images.Thumbnails.getThumbnail(contentResolver, j10, 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x007b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0075 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Drawable b(Context context, Uri uri) throws Throwable {
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        Drawable drawable;
        ParcelFileDescriptor parcelFileDescriptor;
        String path;
        ApplicationInfo applicationInfo;
        ParcelFileDescriptor parcelFileDescriptor2 = null;
        drawableLoadIcon = null;
        drawableLoadIcon = null;
        Drawable drawableLoadIcon = null;
        ParcelFileDescriptor parcelFileDescriptor3 = null;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                if ("file".equals(uri.getScheme())) {
                    path = uri.getPath();
                    parcelFileDescriptor = null;
                } else {
                    parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r");
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        try {
                            parcelFileDescriptor = parcelFileDescriptorOpenFileDescriptor;
                            path = "/proc/self/fd/" + parcelFileDescriptorOpenFileDescriptor.getFd();
                        } catch (Exception unused) {
                            if (parcelFileDescriptorOpenFileDescriptor != null) {
                                return null;
                            }
                            try {
                                parcelFileDescriptorOpenFileDescriptor.close();
                                return null;
                            } catch (Exception unused2) {
                                return null;
                            }
                        } catch (Throwable th) {
                            parcelFileDescriptor2 = parcelFileDescriptorOpenFileDescriptor;
                            th = th;
                            if (parcelFileDescriptor2 != null) {
                                try {
                                    parcelFileDescriptor2.close();
                                } catch (Exception unused3) {
                                }
                            }
                            throw th;
                        }
                    } else {
                        parcelFileDescriptor = parcelFileDescriptorOpenFileDescriptor;
                        path = null;
                    }
                }
                if (path != null) {
                    try {
                        PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(path, 0);
                        if (packageArchiveInfo != null && (applicationInfo = packageArchiveInfo.applicationInfo) != null) {
                            applicationInfo.sourceDir = path;
                            applicationInfo.publicSourceDir = path;
                            drawableLoadIcon = applicationInfo.loadIcon(packageManager);
                        }
                    } catch (Exception unused4) {
                        parcelFileDescriptorOpenFileDescriptor = parcelFileDescriptor;
                        if (parcelFileDescriptorOpenFileDescriptor != null) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        parcelFileDescriptor2 = parcelFileDescriptor;
                        if (parcelFileDescriptor2 != null) {
                        }
                        throw th;
                    }
                }
                drawable = drawableLoadIcon;
                parcelFileDescriptor3 = parcelFileDescriptor;
            } else {
                drawable = null;
            }
            if (parcelFileDescriptor3 != null) {
                try {
                    parcelFileDescriptor3.close();
                } catch (Exception unused5) {
                }
            }
            return drawable;
        } catch (Exception unused6) {
            parcelFileDescriptorOpenFileDescriptor = null;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x004f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap c(Context context, Uri uri) {
        ContentResolver contentResolver;
        Exception exc;
        long j10;
        int columnIndex;
        if (context == null || uri == null || (contentResolver = context.getContentResolver()) == null) {
            return null;
        }
        try {
            Cursor cursorQuery = contentResolver.query(uri, new String[]{"_id"}, null, null, null);
            if (cursorQuery != null) {
                try {
                    j10 = (!cursorQuery.moveToFirst() || (columnIndex = cursorQuery.getColumnIndex("_id")) < 0) ? 0L : cursorQuery.getLong(columnIndex);
                    if (cursorQuery != null) {
                        try {
                            cursorQuery.close();
                        } catch (Exception e10) {
                            exc = e10;
                            exc.printStackTrace();
                            if (j10 <= 0) {
                            }
                        }
                    }
                } finally {
                }
            }
        } catch (Exception e11) {
            exc = e11;
            j10 = 0;
            exc.printStackTrace();
            if (j10 <= 0) {
            }
        }
        if (j10 <= 0) {
            return null;
        }
        return MediaStore.Video.Thumbnails.getThumbnail(contentResolver, j10, 1, null);
    }

    public static Bitmap d(Context context, Uri uri, int i10, int i11, boolean z10) {
        ContentResolver contentResolver;
        if (context == null || uri == null || (contentResolver = context.getContentResolver()) == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 29) {
            return z10 ? a(context, uri) : c(context, uri);
        }
        try {
            return contentResolver.loadThumbnail(uri, new Size(i10, i11), null);
        } catch (IOException unused) {
            return null;
        }
    }
}
