package m7;

import kotlin.jvm.internal.h;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final a f8675a;

    static {
        a aVar;
        Object objNewInstance;
        try {
            objNewInstance = o7.a.class.newInstance();
            h.e(objNewInstance, "forName(\"kotlin.internal\u2026entations\").newInstance()");
            try {
                try {
                } catch (ClassNotFoundException unused) {
                    Object objNewInstance2 = n7.a.class.newInstance();
                    h.e(objNewInstance2, "forName(\"kotlin.internal\u2026entations\").newInstance()");
                    try {
                        try {
                            if (objNewInstance2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                            }
                            aVar = (a) objNewInstance2;
                        } catch (ClassCastException e10) {
                            ClassLoader classLoader = objNewInstance2.getClass().getClassLoader();
                            ClassLoader classLoader2 = a.class.getClassLoader();
                            if (h.a(classLoader, classLoader2)) {
                                throw e10;
                            }
                            throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader + ", base type classloader: " + classLoader2, e10);
                        }
                    } catch (ClassNotFoundException unused2) {
                        aVar = new a();
                    }
                }
            } catch (ClassCastException e11) {
                ClassLoader classLoader3 = objNewInstance.getClass().getClassLoader();
                ClassLoader classLoader4 = a.class.getClassLoader();
                if (h.a(classLoader3, classLoader4)) {
                    throw e11;
                }
                throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader3 + ", base type classloader: " + classLoader4, e11);
            }
        } catch (ClassNotFoundException unused3) {
            Object objNewInstance3 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
            h.e(objNewInstance3, "forName(\"kotlin.internal\u2026entations\").newInstance()");
            try {
                try {
                    if (objNewInstance3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                    aVar = (a) objNewInstance3;
                } catch (ClassCastException e12) {
                    ClassLoader classLoader5 = objNewInstance3.getClass().getClassLoader();
                    ClassLoader classLoader6 = a.class.getClassLoader();
                    if (h.a(classLoader5, classLoader6)) {
                        throw e12;
                    }
                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader5 + ", base type classloader: " + classLoader6, e12);
                }
            } catch (ClassNotFoundException unused4) {
                Object objNewInstance4 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                h.e(objNewInstance4, "forName(\"kotlin.internal\u2026entations\").newInstance()");
                try {
                    if (objNewInstance4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                    aVar = (a) objNewInstance4;
                } catch (ClassCastException e13) {
                    ClassLoader classLoader7 = objNewInstance4.getClass().getClassLoader();
                    ClassLoader classLoader8 = a.class.getClassLoader();
                    if (h.a(classLoader7, classLoader8)) {
                        throw e13;
                    }
                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader7 + ", base type classloader: " + classLoader8, e13);
                }
            }
        }
        if (objNewInstance == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
        }
        aVar = (a) objNewInstance;
        f8675a = aVar;
    }
}
