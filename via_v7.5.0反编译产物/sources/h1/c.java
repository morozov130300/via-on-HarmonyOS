package h1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f5619c = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f5621b;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f5622a = "";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List f5623b = new ArrayList();

        public c a() {
            return new c(this.f5622a, Collections.unmodifiableList(this.f5623b));
        }

        public a b(List list) {
            this.f5623b = list;
            return this;
        }

        public a c(String str) {
            this.f5622a = str;
            return this;
        }
    }

    public c(String str, List list) {
        this.f5620a = str;
        this.f5621b = list;
    }

    public static a c() {
        return new a();
    }

    public List a() {
        return this.f5621b;
    }

    public String b() {
        return this.f5620a;
    }
}
