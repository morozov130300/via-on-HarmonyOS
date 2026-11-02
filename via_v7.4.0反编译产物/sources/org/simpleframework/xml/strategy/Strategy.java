package org.simpleframework.xml.strategy;

import java.util.Map;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.NodeMap;
import org.simpleframework.xml.stream.OutputNode;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public interface Strategy {
    Value read(Type type, NodeMap<InputNode> nodeMap, Map map);

    boolean write(Type type, Object obj, NodeMap<OutputNode> nodeMap, Map map);
}
