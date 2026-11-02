package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class ClassScanner {
    private Function commit;
    private Function complete;
    private NamespaceDecorator decorator = new NamespaceDecorator();
    private Order order;
    private Function persist;
    private Function replace;
    private Function resolve;
    private Root root;
    private ConstructorScanner scanner;
    private Support support;
    private Function validate;

    public ClassScanner(Detail detail, Support support) {
        this.scanner = new ConstructorScanner(detail, support);
        this.support = support;
        scan(detail);
    }

    private void commit(Method method) {
        if (this.commit == null) {
            this.commit = getFunction(method);
        }
    }

    private void commit(Detail detail) {
        Namespace namespace = detail.getNamespace();
        if (namespace != null) {
            this.decorator.set(namespace);
        }
    }

    private void complete(Method method) {
        if (this.complete == null) {
            this.complete = getFunction(method);
        }
    }

    private void definition(Detail detail) {
        if (this.root == null) {
            this.root = detail.getRoot();
        }
        if (this.order == null) {
            this.order = detail.getOrder();
        }
    }

    private Function getFunction(Method method) {
        boolean zIsContextual = isContextual(method);
        if (!method.isAccessible()) {
            method.setAccessible(true);
        }
        return new Function(method, zIsContextual);
    }

    private boolean isContextual(Method method) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        if (parameterTypes.length == 1) {
            return Map.class.equals(parameterTypes[0]);
        }
        return false;
    }

    private void method(Detail detail) {
        Iterator<MethodDetail> it = detail.getMethods().iterator();
        while (it.hasNext()) {
            method(it.next());
        }
    }

    private void method(MethodDetail methodDetail) {
        Annotation[] annotations = methodDetail.getAnnotations();
        Method method = methodDetail.getMethod();
        for (Annotation annotation : annotations) {
            if (annotation instanceof Commit) {
                commit(method);
            }
            if (annotation instanceof Validate) {
                validate(method);
            }
            if (annotation instanceof Persist) {
                persist(method);
            }
            if (annotation instanceof Complete) {
                complete(method);
            }
            if (annotation instanceof Replace) {
                replace(method);
            }
            if (annotation instanceof Resolve) {
                resolve(method);
            }
        }
    }

    private void namespace(Detail detail) {
        NamespaceList namespaceList = detail.getNamespaceList();
        Namespace namespace = detail.getNamespace();
        if (namespace != null) {
            this.decorator.add(namespace);
        }
        if (namespaceList != null) {
            for (Namespace namespace2 : namespaceList.value()) {
                this.decorator.add(namespace2);
            }
        }
    }

    private void persist(Method method) {
        if (this.persist == null) {
            this.persist = getFunction(method);
        }
    }

    private void replace(Method method) {
        if (this.replace == null) {
            this.replace = getFunction(method);
        }
    }

    private void resolve(Method method) {
        if (this.resolve == null) {
            this.resolve = getFunction(method);
        }
    }

    private void scan(Detail detail) {
        DefaultType override = detail.getOverride();
        Class type = detail.getType();
        while (type != null) {
            Detail detail2 = this.support.getDetail(type, override);
            namespace(detail2);
            method(detail2);
            definition(detail2);
            type = detail2.getSuper();
        }
        commit(detail);
    }

    private void validate(Method method) {
        if (this.validate == null) {
            this.validate = getFunction(method);
        }
    }

    public Function getCommit() {
        return this.commit;
    }

    public Function getComplete() {
        return this.complete;
    }

    public Decorator getDecorator() {
        return this.decorator;
    }

    public Order getOrder() {
        return this.order;
    }

    public ParameterMap getParameters() {
        return this.scanner.getParameters();
    }

    public Function getPersist() {
        return this.persist;
    }

    public Function getReplace() {
        return this.replace;
    }

    public Function getResolve() {
        return this.resolve;
    }

    public Root getRoot() {
        return this.root;
    }

    public Signature getSignature() {
        return this.scanner.getSignature();
    }

    public List<Signature> getSignatures() {
        return this.scanner.getSignatures();
    }

    public Function getValidate() {
        return this.validate;
    }
}
