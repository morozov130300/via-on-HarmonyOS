package na;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class e {
    public static void a(Context context) {
        File file = new File(context.getFilesDir(), "RESTORED_TABS");
        File file2 = new File(context.getFilesDir(), "RESTORED_TABS.json");
        if (file.exists()) {
            file.delete();
        }
        if (file2.exists()) {
            file2.delete();
        }
    }

    public static r4.g b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString("URL");
        if (strOptString.isEmpty()) {
            return null;
        }
        String strOptString2 = jSONObject.optString("TITLE");
        Bundle bundle = new Bundle();
        bundle.putString("URL", strOptString);
        if (!strOptString2.isEmpty()) {
            bundle.putString("TITLE", strOptString2);
        }
        return new r4.b(bundle);
    }

    public static k c(Context context) {
        List listF;
        Bundle bundleE;
        k kVar = new k();
        File file = new File(context.getFilesDir(), "RESTORED_TABS");
        File file2 = new File(context.getFilesDir(), "RESTORED_TABS.json");
        if (file.isFile() && (bundleE = e(file)) != null && !bundleE.isEmpty()) {
            int i10 = bundleE.getInt("cur", 0);
            int[] iArr = new int[bundleE.size()];
            int i11 = 0;
            for (String str : bundleE.keySet()) {
                if (str.startsWith("tab_")) {
                    String strSubstring = str.substring(4);
                    if (TextUtils.isDigitsOnly(strSubstring)) {
                        iArr[i11] = Integer.parseInt(strSubstring);
                        i11++;
                    }
                }
            }
            int[] iArrCopyOf = Arrays.copyOf(iArr, i11);
            Arrays.sort(iArrCopyOf);
            ArrayList arrayList = new ArrayList();
            for (int i12 = 0; i12 < i11; i12++) {
                Bundle bundle = bundleE.getBundle("tab_" + iArrCopyOf[i12]);
                if (bundle != null) {
                    arrayList.add(new r4.b(bundle));
                } else if (i10 < i12) {
                    i10--;
                }
            }
            if (!arrayList.isEmpty()) {
                kVar.e(arrayList);
                kVar.d(Math.min(arrayList.size() - 1, Math.max(i10, 0)));
                return kVar;
            }
        }
        if (file2.isFile() && (listF = f(file2)) != null && !listF.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            int size = listF.size();
            JSONObject jSONObject = (JSONObject) listF.get(size - 1);
            int iOptInt = -1;
            if (jSONObject.has("INDEX")) {
                iOptInt = jSONObject.optInt("INDEX", -1);
                size--;
            }
            for (int i13 = 0; i13 < size; i13++) {
                r4.g gVarB = b((JSONObject) listF.get(i13));
                if (gVarB != null) {
                    arrayList2.add(gVarB);
                } else if (i13 < iOptInt) {
                    iOptInt--;
                }
            }
            if (!arrayList2.isEmpty()) {
                kVar.e(arrayList2);
                kVar.d(Math.min(arrayList2.size() - 1, Math.max(iOptInt, 0)));
            }
        }
        return kVar;
    }

    public static boolean d(Context context) {
        if (new File(context.getFilesDir(), "RESTORED_TABS").isFile()) {
            return true;
        }
        return new File(context.getFilesDir(), "RESTORED_TABS.json").isFile();
    }

    public static Bundle e(File file) throws IOException {
        if (file != null && file.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    Parcel parcelObtain = Parcel.obtain();
                    int size = (int) fileInputStream.getChannel().size();
                    byte[] bArr = new byte[size];
                    fileInputStream.read(bArr, 0, size);
                    parcelObtain.unmarshall(bArr, 0, size);
                    parcelObtain.setDataPosition(0);
                    Bundle bundle = parcelObtain.readBundle(ClassLoader.getSystemClassLoader());
                    if (bundle != null) {
                        bundle.putAll(bundle);
                    }
                    parcelObtain.recycle();
                    fileInputStream.close();
                    return bundle;
                } finally {
                }
            } catch (IOException | NullPointerException e10) {
                pc.a.i(e10);
            }
        }
        return null;
    }

    public static List f(File file) throws IOException {
        if (file != null && file.exists()) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                try {
                    ArrayList arrayList = new ArrayList();
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            bufferedReader.close();
                            return arrayList;
                        }
                        if (!line.isEmpty()) {
                            arrayList.add(new JSONObject(line));
                        }
                    }
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException | NullPointerException | JSONException e10) {
                pc.a.i(e10);
            }
        }
        return null;
    }
}
