package com.google.android.gms.internal.measurement;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class v8 {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f3850a = Logger.getLogger(m8.class.getName());

    /* renamed from: b, reason: collision with root package name */
    public static final String f3851b = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";

    public static q8 a(Class cls) {
        String str;
        ClassLoader classLoader = v8.class.getClassLoader();
        if (cls.equals(q8.class)) {
            str = f3851b;
        } else {
            if (!cls.getPackage().equals(v8.class.getPackage())) {
                throw new IllegalArgumentException(cls.getName());
            }
            str = String.format("%s.BlazeGenerated%sLoader", cls.getPackage().getName(), cls.getSimpleName());
        }
        try {
            try {
                try {
                    try {
                        n.g.a(Class.forName(str, true, classLoader).getConstructor(null).newInstance(null));
                        throw null;
                    } catch (InstantiationException e10) {
                        throw new IllegalStateException(e10);
                    }
                } catch (IllegalAccessException e11) {
                    throw new IllegalStateException(e11);
                }
            } catch (NoSuchMethodException e12) {
                throw new IllegalStateException(e12);
            } catch (InvocationTargetException e13) {
                throw new IllegalStateException(e13);
            }
        } catch (ClassNotFoundException unused) {
            Iterator it = ServiceLoader.load(v8.class, classLoader).iterator();
            ArrayList arrayList = new ArrayList();
            while (it.hasNext()) {
                try {
                    n.g.a(it.next());
                    throw null;
                } catch (ServiceConfigurationError e14) {
                    f3850a.logp(Level.SEVERE, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", "Unable to load ".concat(cls.getSimpleName()), (Throwable) e14);
                }
            }
            if (arrayList.size() == 1) {
                return (q8) arrayList.get(0);
            }
            if (arrayList.size() == 0) {
                return null;
            }
            try {
                return (q8) cls.getMethod("combine", Collection.class).invoke(null, arrayList);
            } catch (IllegalAccessException e15) {
                throw new IllegalStateException(e15);
            } catch (NoSuchMethodException e16) {
                throw new IllegalStateException(e16);
            } catch (InvocationTargetException e17) {
                throw new IllegalStateException(e17);
            }
        }
    }
}
