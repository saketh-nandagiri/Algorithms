package com.stanford.week6;

public class Edge {
    private Vertex startingVertex;
    private Vertex endingVertex;
    private int edgeLength;

    public Edge(Vertex startingVertex, Vertex endingVertex, int edgeLength) {
        this.startingVertex = startingVertex;
        this.endingVertex = endingVertex;
        this.edgeLength = edgeLength;
    }

    public Vertex getStartingVertex() {
        return startingVertex;
    }

    public Vertex getEndingVertex() {
        return endingVertex;
    }

    public int getEdgeLength() {
        return edgeLength;
    }
}
