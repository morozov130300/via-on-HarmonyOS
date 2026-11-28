package n6;

import android.graphics.Canvas;
import android.text.Layout;
import android.text.Spanned;
import android.widget.TextView;
import h6.j;
import h6.k;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class e {
    public static int a(Canvas canvas, CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            Layout layoutC = j.c(spanned);
            if (layoutC != null) {
                return layoutC.getWidth();
            }
            TextView textViewA = k.a(spanned);
            if (textViewA != null) {
                return (textViewA.getWidth() - textViewA.getPaddingLeft()) - textViewA.getPaddingRight();
            }
        }
        return canvas.getWidth();
    }
}
