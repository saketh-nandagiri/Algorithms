package com.stanford.week6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Dijkstras {
    Graph graph = new Graph();
    List<Vertex> visitedVertices;
    int[] shortestPaths;
    MinHeap<Vertex> minHeapVertices = new MinHeap();

    public Dijkstras(String filePath) throws IOException {
        buildGraph(filePath);
        visitedVertices = new ArrayList<>();
        visitedVertices.add(graph.getVertexList().get(0));
        shortestPaths = new int[graph.getVertexList().size()];
        shortestPaths[0] = 0;
        buildVerticesHeap();
    }

    public void computeShortestPaths() {
        Vertex vertex;
        while (visitedVertices.size() != graph.getVertexList().size()) {
           vertex = minHeapVertices.poll();
           visitedVertices.add(vertex);
           shortestPaths[vertex.getValue() - 1] = vertex.getCalculatedDistance();
           adjustHeap(vertex);
        }
    }

    private void adjustHeap(Vertex vertex) {
        // here we'll remove elements and add them back.
        Vertex targetVertex;
        for (Edge edge : vertex.getEdges()) {
            targetVertex = edge.getEndingVertex();
            if (visitedVertices.indexOf(targetVertex) > -1)
                continue;
            minHeapVertices.remove(targetVertex);
            int newCalculatedDistance = shortestPaths[vertex.getValue() - 1] + edge.getEdgeLength();
            if (newCalculatedDistance < targetVertex.getCalculatedDistance()) {
                targetVertex.setCalculatedDistance(newCalculatedDistance);
            }
            minHeapVertices.add(targetVertex);
        }
    }

    private void buildVerticesHeap() {
        setUpBaseline();
    }

    private void setUpBaseline() {
        List<Vertex> verticesToAdd = new ArrayList<>();
        Vertex v;

        IntStream.rangeClosed(1, graph.getVertexList().size() - 1)
                .forEach(index -> {
                    Vertex vertex = graph.getVertexList().get(index);
                    vertex.setCalculatedDistance(1000000);
                    verticesToAdd.add(vertex);
                });

        Vertex startVertex = visitedVertices.get(0);
        startVertex.getEdges().stream().forEach(edge -> {
            int previous = edge.getEndingVertex().getCalculatedDistance();
            int current = edge.getEdgeLength();
            if (current < previous)
                edge.getEndingVertex().setCalculatedDistance(current);
        });

        for (Vertex vertex : verticesToAdd) {
            minHeapVertices.add(vertex);
        }
    }

    private void buildGraph(String filePath) throws IOException {
        graph.buildGraph(filePath);
    }
}
