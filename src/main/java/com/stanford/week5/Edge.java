package com.stanford.week5;

public class Edge {

    private Vertex startingVertex;
    private Vertex endingVertex;

    public void setStartingVertex(Vertex startingVertex) {
        this.startingVertex = startingVertex;
    }

    public Edge(Vertex startingVertex, Vertex endingVertex) {
        this.startingVertex = startingVertex;
        this.endingVertex = endingVertex;
    }

    public Vertex getStartingVertex() {
        return startingVertex;
    }

    public Vertex getEndingVertex() {
        return endingVertex;
    }

    public void setEndingVertex(Vertex v1) {
        this.endingVertex = v1;
    }
}
