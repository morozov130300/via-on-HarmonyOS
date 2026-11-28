package k9;

import java.io.File;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public File f7221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f7222b;

    public a(File file, String str) {
        this.f7221a = file;
        this.f7222b = str;
    }

    public File a() {
        return this.f7221a;
    }

    public String b() {
        return this.f7222b;
    }

    public a(File file) {
        this.f7221a = file;
        this.f7222b = file.getName();
    }
}
