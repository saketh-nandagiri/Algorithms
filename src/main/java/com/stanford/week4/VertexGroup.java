package com.stanford.week4;

import java.util.List;

public class VertexGroup {

    Vertex v;
    List<Vertex> vertices;
    List<Edge> edges;


    public VertexGroup(Vertex v1, Vertex v2) {
        this.v = new Vertex();
        vertices.add(v1);
        vertices.add(v2);
    }

    public void addVertexToGroup(Vertex v) {
        this.vertices.add(v);
    }


    public void addEdgesToVertexGroup(Vertex v1, Vertex v2) {

    }
}
