package kotlin.jvm.internal;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.reflect.KVisibility;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class CallableReference implements u7.b, Serializable {
    public static final Object NO_RECEIVER = NoReceiver.f8291e;

    /* renamed from: e, reason: collision with root package name */
    public transient u7.b f8290e;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private final String signature;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class NoReceiver implements Serializable {

        /* renamed from: e, reason: collision with root package name */
        public static final NoReceiver f8291e = new NoReceiver();

        private NoReceiver() {
        }

        private Object readResolve() {
            return f8291e;
        }
    }

    public CallableReference() {
        this(NO_RECEIVER);
    }

    public CallableReference(Object obj) {
        this(obj, null, null, null, false);
    }

    public CallableReference(Object obj, Class cls, String str, String str2, boolean z10) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z10;
    }

    @Override // u7.b
    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    @Override // u7.b
    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    public u7.b compute() {
        u7.b bVar = this.f8290e;
        if (bVar != null) {
            return bVar;
        }
        u7.b bVarComputeReflected = computeReflected();
        this.f8290e = bVarComputeReflected;
        return bVarComputeReflected;
    }

    public abstract u7.b computeReflected();

    @Override // u7.a
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    public String getName() {
        return this.name;
    }

    public u7.d getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        return this.isTopLevel ? j.c(cls) : j.b(cls);
    }

    @Override // u7.b
    public List<Object> getParameters() {
        return getReflected().getParameters();
    }

    public u7.b getReflected() {
        u7.b bVarCompute = compute();
        if (bVarCompute != this) {
            return bVarCompute;
        }
        throw new KotlinReflectionNotSupportedError();
    }

    @Override // u7.b
    public u7.f getReturnType() {
        getReflected().getReturnType();
        return null;
    }

    public String getSignature() {
        return this.signature;
    }

    @Override // u7.b
    public List<Object> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // u7.b
    public KVisibility getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // u7.b
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // u7.b
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // u7.b
    public boolean isOpen() {
        return getReflected().isOpen();
    }

    @Override // u7.b
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }
}
