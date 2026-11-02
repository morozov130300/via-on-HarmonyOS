package k5;

import android.net.Uri;
import java.io.File;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a implements o {
    @Override // k5.o
    public c a(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("File uri can not be null or empty");
        }
        Uri uri = Uri.parse(str);
        if (uri == null || uri.getPath() == null) {
            throw new IllegalArgumentException("Invalid uri string");
        }
        return d.d(new File(uri.getPath()));
    }
}
