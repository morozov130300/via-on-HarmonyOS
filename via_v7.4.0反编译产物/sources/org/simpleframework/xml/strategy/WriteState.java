package org.simpleframework.xml.strategy;

import org.simpleframework.xml.util.WeakCache;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class WriteState extends WeakCache<WriteGraph> {
    private Contract contract;

    public WriteState(Contract contract) {
        this.contract = contract;
    }

    public WriteGraph find(Object obj) {
        WriteGraph writeGraphFetch = fetch(obj);
        if (writeGraphFetch != null) {
            return writeGraphFetch;
        }
        WriteGraph writeGraph = new WriteGraph(this.contract);
        cache(obj, writeGraph);
        return writeGraph;
    }
}
