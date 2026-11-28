package org.simpleframework.xml.core;

import java.util.List;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Version;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
interface Scanner extends Policy {
    Caller getCaller(Context context);

    Function getCommit();

    Function getComplete();

    Decorator getDecorator();

    Instantiator getInstantiator();

    String getName();

    Order getOrder();

    ParameterMap getParameters();

    Function getPersist();

    Function getReplace();

    Function getResolve();

    Version getRevision();

    Section getSection();

    Signature getSignature();

    List<Signature> getSignatures();

    Label getText();

    Class getType();

    Function getValidate();

    Label getVersion();

    boolean isEmpty();

    boolean isPrimitive();

    @Override // org.simpleframework.xml.core.Policy
    boolean isStrict();
}
