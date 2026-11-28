package x8;

import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.Base64;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class x3 {
    public static String a(Context context) {
        String strM0 = la.s.j().M0();
        if (!TextUtils.isEmpty(strM0)) {
            Configuration configuration = new Configuration(context.getResources().getConfiguration());
            s1.p(context, configuration, strM0);
            context = context.createConfigurationContext(configuration);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("panelTitle", context.getString(w7.u.Wg));
        linkedHashMap.put("targetLanguage", context.getString(w7.u.yg));
        linkedHashMap.put("provider", context.getString(w7.u.Xg));
        linkedHashMap.put("autoTranslateSite", context.getString(w7.u.f14164o1));
        linkedHashMap.put("translate", context.getString(w7.u.f14079i0));
        linkedHashMap.put("cancel", context.getString(R.string.cancel));
        linkedHashMap.put("restoreOriginal", context.getString(w7.u.f14323zb));
        linkedHashMap.put("translationStartFailed", context.getString(w7.u.mh));
        linkedHashMap.put("translationFailed", context.getString(w7.u.dh));
        linkedHashMap.put("translationPaused", context.getString(w7.u.gh));
        linkedHashMap.put("openTranslationSettings", context.getString(w7.u.G9));
        linkedHashMap.put("settingsDragHint", context.getString(w7.u.lh));
        linkedHashMap.put("providerTestIdle", context.getString(w7.u.ih));
        linkedHashMap.put("providerTestTesting", context.getString(w7.u.kh));
        linkedHashMap.put("providerTestSuccess", context.getString(w7.u.jh));
        linkedHashMap.put("providerTestError", context.getString(w7.u.hh));
        linkedHashMap.put("translationLoading", context.getString(w7.u.eh));
        linkedHashMap.put("translationComplete", context.getString(w7.u.Zg));
        linkedHashMap.put("displayMode", context.getString(w7.u.ah));
        linkedHashMap.put("translationOnly", context.getString(w7.u.fh));
        linkedHashMap.put("bilingual", context.getString(w7.u.Yg));
        return Base64.encodeToString(new JSONObject(linkedHashMap).toString().getBytes(StandardCharsets.UTF_8), 2);
    }

    public static String b(Context context) {
        return new JSONObject(c6.x1.f2137a.e(a(context))).toString();
    }
}
