package a;

import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PrintAttributes f0a;

    /* JADX INFO: renamed from: a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class C0000a extends PrintDocumentAdapter.LayoutResultCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PrintDocumentAdapter f1a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ File f2b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f3c;

        /* JADX INFO: renamed from: a.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public class C0001a extends PrintDocumentAdapter.WriteResultCallback {
            public C0001a() {
            }

            @Override // android.print.PrintDocumentAdapter.WriteResultCallback
            public void onWriteFinished(PageRange[] pageRangeArr) {
                super.onWriteFinished(pageRangeArr);
            }
        }

        public C0000a(PrintDocumentAdapter printDocumentAdapter, File file, String str) {
            this.f1a = printDocumentAdapter;
            this.f2b = file;
            this.f3c = str;
        }

        @Override // android.print.PrintDocumentAdapter.LayoutResultCallback
        public void onLayoutFinished(PrintDocumentInfo printDocumentInfo, boolean z10) {
            this.f1a.onWrite(new PageRange[]{PageRange.ALL_PAGES}, a.this.b(this.f2b, this.f3c), new CancellationSignal(), new C0001a());
        }
    }

    public a(PrintAttributes printAttributes) {
        this.f0a = printAttributes;
    }

    public final ParcelFileDescriptor b(File file, String str) {
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, str);
        try {
            file2.createNewFile();
            return ParcelFileDescriptor.open(file2, 805306368);
        } catch (Exception e10) {
            tc.a.f(e10, "Failed to open ParcelFileDescriptor", new Object[0]);
            return null;
        }
    }

    public void c(PrintDocumentAdapter printDocumentAdapter, File file, String str) {
        printDocumentAdapter.onLayout(null, this.f0a, null, new C0000a(printDocumentAdapter, file, str), null);
    }
}
