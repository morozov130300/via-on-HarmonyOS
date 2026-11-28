package org.simpleframework.xml.core;

import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
class ScannerFactory {
    private final Cache<Scanner> cache = new ConcurrentCache();
    private final Support support;

    public ScannerFactory(Support support) {
        this.support = support;
    }

    public Scanner getInstance(Class cls) {
        Scanner objectScanner;
        Scanner scannerFetch = this.cache.fetch(cls);
        if (scannerFetch != null) {
            return scannerFetch;
        }
        Detail detail = this.support.getDetail(cls);
        if (this.support.isPrimitive(cls)) {
            objectScanner = new PrimitiveScanner(detail);
        } else {
            objectScanner = new ObjectScanner(detail, this.support);
            if (objectScanner.isPrimitive() && !this.support.isContainer(cls)) {
                objectScanner = new DefaultScanner(detail, this.support);
            }
        }
        this.cache.cache(cls, objectScanner);
        return objectScanner;
    }
}
