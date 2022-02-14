package com.stanford.week6;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class DijkstrasTest {

    Dijkstras dijkstras;

    @Test
    void runDijkstrasOnGraph() throws IOException {
        String filePath = "/Users/saketh.nandagiri/Documents/Projects/Stanford/src/main/resources/djikstra_test1.txt";
        dijkstras = new Dijkstras(filePath);
        dijkstras.computeShortestPaths();
    }

    @Test
    void runDijkstrasOnGraphOne() throws IOException {
        String filePath = "/Users/saketh.nandagiri/Documents/Projects/Stanford/src/main/resources/djikstra_test2.txt";
        dijkstras = new Dijkstras(filePath);
        dijkstras.computeShortestPaths();
    }

    @Test
    void runDijkstrasOnMainGraph() throws IOException {
        String filePath = "/Users/saketh.nandagiri/Documents/Projects/Stanford/src/main/resources/djikstra.txt";
        dijkstras = new Dijkstras(filePath);
        dijkstras.computeShortestPaths();
    }

}
