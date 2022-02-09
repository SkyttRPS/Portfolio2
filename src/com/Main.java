public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph();
        Vertex a = new Vertex("Eskildstrup");
        Vertex b = new Vertex("Haslev");
        Vertex c = new Vertex("Holbæk");
        Vertex d = new Vertex("Jægerspris");
        Vertex e = new Vertex("Kalundborg");
        Vertex f = new Vertex("Korsør");
        Vertex g = new Vertex("Køge");
        Vertex h = new Vertex("Maribo");
        Vertex i = new Vertex("Næstved");
        Vertex j = new Vertex("Ringsted");
        Vertex k = new Vertex("Nykøbing F");
        Vertex l = new Vertex("Vordingborg");
        Vertex m = new Vertex("Roskilde");
        Vertex n = new Vertex("Slagelse");
        Vertex o = new Vertex("Sorø");
        Vertex p = new Vertex("Nakskov");

        // Adding a Vertex at each location
        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);
        graph.addVertex(d);
        graph.addVertex(e);
        graph.addVertex(f);
        graph.addVertex(g);
        graph.addVertex(h);
        graph.addVertex(i);
        graph.addVertex(j);
        graph.addVertex(k);
        graph.addVertex(l);
        graph.addVertex(m);
        graph.addVertex(n);
        graph.addVertex(o);
        graph.addVertex(p);

        // Adding an edge between all the requested locations
        graph.addEdge(a, h, 28);
        graph.addEdge(a, k, 13);
        graph.addEdge(a, l, 25);
        graph.addEdge(b, f, 60);
        graph.addEdge(b, g, 24);
        graph.addEdge(b, i, 25);
        graph.addEdge(b, j, 19);
        graph.addEdge(b, m, 47);
        graph.addEdge(b, n, 48);
        graph.addEdge(b, o, 34);
        graph.addEdge(b, l, 40);
        graph.addEdge(c, d, 34);
        graph.addEdge(c, e, 44);
        graph.addEdge(c, f, 66);
        graph.addEdge(c, j, 36);
        graph.addEdge(c, m, 32);
        graph.addEdge(c, n, 46);
        graph.addEdge(c, o, 34);
        graph.addEdge(d, f, 94);
        graph.addEdge(d, g, 58);
        graph.addEdge(d, j, 56);
        graph.addEdge(d, m, 33);
        graph.addEdge(d, n, 74);
        graph.addEdge(d, o, 63);
        graph.addEdge(e, j, 62);
        graph.addEdge(e, m, 70);
        graph.addEdge(e, n, 39);
        graph.addEdge(e, o, 51);
        graph.addEdge(f, i, 45);
        graph.addEdge(f, n, 20);
        graph.addEdge(g, i, 45);
        graph.addEdge(g, j, 28);
        graph.addEdge(g, m, 25);
        graph.addEdge(g, l, 60);
        graph.addEdge(h, p, 27);
        graph.addEdge(h, k, 26);
        graph.addEdge(i, m, 57);
        graph.addEdge(i, j, 26);
        graph.addEdge(i, n, 37);
        graph.addEdge(i, o, 32);
        graph.addEdge(i, l, 28);
        graph.addEdge(j, m, 31);
        graph.addEdge(j, o, 15);
        graph.addEdge(j, l, 58);
        graph.addEdge(n, o, 14);
        graph.PrintGraph();
        graph.MSTPrims();
    }
}
