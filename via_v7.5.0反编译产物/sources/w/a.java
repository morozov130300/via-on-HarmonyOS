package w;

import android.os.Build;
import android.text.Html;
import android.text.Spanned;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: w.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class C0152a {
        public static Spanned a(String str, int i10) {
            return Html.fromHtml(str, i10);
        }

        public static Spanned b(String str, int i10, Html.ImageGetter imageGetter, Html.TagHandler tagHandler) {
            return Html.fromHtml(str, i10, imageGetter, tagHandler);
        }

        public static String c(Spanned spanned, int i10) {
            return Html.toHtml(spanned, i10);
        }
    }

    public static Spanned a(String str, int i10) {
        return Build.VERSION.SDK_INT >= 24 ? C0152a.a(str, i10) : Html.fromHtml(str);
    }
}
