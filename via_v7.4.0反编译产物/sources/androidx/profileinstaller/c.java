package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.util.Log;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.Executor;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final InterfaceC0019c f1103a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final InterfaceC0019c f1104b = new b();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements InterfaceC0019c {
        @Override // androidx.profileinstaller.c.InterfaceC0019c
        public void a(int i10, Object obj) {
        }

        @Override // androidx.profileinstaller.c.InterfaceC0019c
        public void b(int i10, Object obj) {
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b implements InterfaceC0019c {
        @Override // androidx.profileinstaller.c.InterfaceC0019c
        public void a(int i10, Object obj) {
            Log.d("ProfileInstaller", i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? i10 != 5 ? "" : "DIAGNOSTIC_PROFILE_IS_COMPRESSED" : "DIAGNOSTIC_REF_PROFILE_DOES_NOT_EXIST" : "DIAGNOSTIC_REF_PROFILE_EXISTS" : "DIAGNOSTIC_CURRENT_PROFILE_DOES_NOT_EXIST" : "DIAGNOSTIC_CURRENT_PROFILE_EXISTS");
        }

        @Override // androidx.profileinstaller.c.InterfaceC0019c
        public void b(int i10, Object obj) {
            String str;
            switch (i10) {
                case 1:
                    str = "RESULT_INSTALL_SUCCESS";
                    break;
                case 2:
                    str = "RESULT_ALREADY_INSTALLED";
                    break;
                case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                    str = "RESULT_UNSUPPORTED_ART_VERSION";
                    break;
                case 4:
                    str = "RESULT_NOT_WRITABLE";
                    break;
                case 5:
                    str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                    break;
                case 6:
                    str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                    break;
                case 7:
                    str = "RESULT_IO_EXCEPTION";
                    break;
                case 8:
                    str = "RESULT_PARSE_EXCEPTION";
                    break;
                case 9:
                default:
                    str = "";
                    break;
                case 10:
                    str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                    break;
                case 11:
                    str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                    break;
            }
            if (i10 == 6 || i10 == 7 || i10 == 8) {
                Log.e("ProfileInstaller", str, (Throwable) obj);
            } else {
                Log.d("ProfileInstaller", str);
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: androidx.profileinstaller.c$c, reason: collision with other inner class name */
    public interface InterfaceC0019c {
        void a(int i10, Object obj);

        void b(int i10, Object obj);
    }

    public static boolean b(File file) {
        return new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat").delete();
    }

    public static void c(Context context, Executor executor, InterfaceC0019c interfaceC0019c) {
        b(context.getFilesDir());
        f(executor, interfaceC0019c, 11, null);
    }

    public static boolean d(PackageInfo packageInfo, File file, InterfaceC0019c interfaceC0019c) throws IOException {
        File file2 = new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat");
        if (!file2.exists()) {
            return false;
        }
        try {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file2));
            try {
                long j10 = dataInputStream.readLong();
                dataInputStream.close();
                boolean z10 = j10 == packageInfo.lastUpdateTime;
                if (z10) {
                    interfaceC0019c.b(2, null);
                }
                return z10;
            } finally {
            }
        } catch (IOException unused) {
            return false;
        }
    }

    public static void e(PackageInfo packageInfo, File file) throws IOException {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat")));
            try {
                dataOutputStream.writeLong(packageInfo.lastUpdateTime);
                dataOutputStream.close();
            } finally {
            }
        } catch (IOException unused) {
        }
    }

    public static void f(Executor executor, final InterfaceC0019c interfaceC0019c, final int i10, final Object obj) {
        executor.execute(new Runnable() { // from class: j0.g
            @Override // java.lang.Runnable
            public final void run() {
                interfaceC0019c.b(i10, obj);
            }
        });
    }

    public static boolean g(AssetManager assetManager, String str, PackageInfo packageInfo, File file, String str2, Executor executor, InterfaceC0019c interfaceC0019c) throws IOException {
        androidx.profileinstaller.b bVar = new androidx.profileinstaller.b(assetManager, executor, interfaceC0019c, str2, "dexopt/baseline.prof", "dexopt/baseline.profm", new File(new File("/data/misc/profiles/cur/0", str), "primary.prof"));
        if (!bVar.e()) {
            return false;
        }
        boolean zM = bVar.h().l().m();
        if (zM) {
            e(packageInfo, file);
        }
        return zM;
    }

    public static void h(Context context) throws PackageManager.NameNotFoundException {
        i(context, new j0.f(), f1103a);
    }

    public static void i(Context context, Executor executor, InterfaceC0019c interfaceC0019c) throws PackageManager.NameNotFoundException {
        j(context, executor, interfaceC0019c, false);
    }

    public static void j(Context context, Executor executor, InterfaceC0019c interfaceC0019c, boolean z10) throws PackageManager.NameNotFoundException {
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        ApplicationInfo applicationInfo = applicationContext.getApplicationInfo();
        AssetManager assets = applicationContext.getAssets();
        String name = new File(applicationInfo.sourceDir).getName();
        boolean z11 = false;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            File filesDir = context.getFilesDir();
            if (!z10 && d(packageInfo, filesDir, interfaceC0019c)) {
                Log.d("ProfileInstaller", "Skipping profile installation for " + context.getPackageName());
                e.c(context, false);
                return;
            }
            Log.d("ProfileInstaller", "Installing profile for " + context.getPackageName());
            if (g(assets, packageName, packageInfo, filesDir, name, executor, interfaceC0019c) && z10) {
                z11 = true;
            }
            e.c(context, z11);
        } catch (PackageManager.NameNotFoundException e10) {
            interfaceC0019c.b(7, e10);
            e.c(context, false);
        }
    }

    public static void k(Context context, Executor executor, InterfaceC0019c interfaceC0019c) throws PackageManager.NameNotFoundException, IOException {
        try {
            e(context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0), context.getFilesDir());
            f(executor, interfaceC0019c, 10, null);
        } catch (PackageManager.NameNotFoundException e10) {
            f(executor, interfaceC0019c, 7, e10);
        }
    }
}
