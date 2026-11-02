package org.simpleframework.xml.core;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class ConstructorScanner {
    private Signature primary;
    private Support support;
    private List<Signature> signatures = new ArrayList();
    private ParameterMap registry = new ParameterMap();

    public ConstructorScanner(Detail detail, Support support) throws ConstructorException {
        this.support = support;
        scan(detail);
    }

    private void scan(Constructor constructor) {
        SignatureScanner signatureScanner = new SignatureScanner(constructor, this.registry, this.support);
        if (signatureScanner.isValid()) {
            for (Signature signature : signatureScanner.getSignatures()) {
                if (signature.size() == 0) {
                    this.primary = signature;
                }
                this.signatures.add(signature);
            }
        }
    }

    private void scan(Detail detail) throws ConstructorException {
        Constructor[] constructors = detail.getConstructors();
        if (!detail.isInstantiable()) {
            throw new ConstructorException("Can not construct inner %s", detail);
        }
        for (Constructor constructor : constructors) {
            if (!detail.isPrimitive()) {
                scan(constructor);
            }
        }
    }

    public ParameterMap getParameters() {
        return this.registry;
    }

    public Signature getSignature() {
        return this.primary;
    }

    public List<Signature> getSignatures() {
        return new ArrayList(this.signatures);
    }
}
