package k5;

import android.net.Uri;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
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
