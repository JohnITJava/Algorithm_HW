package Lesson7;

import Lesson3.Queue;
import Lesson3.Stack;

import java.util.ArrayList;

public class Graph {

    private class Vertex {
        char label;
        boolean wasVisited;

        public Vertex(char label) {
            this.label = label;
            this.wasVisited = false;
        }

        @Override
        public String toString() {
            return ""+ label;
        }
    }

    //Максимальное кол-во вершин
    private final int MAX_VERTICES;
    //Массив этих вершин
    private Vertex[] vertices;
    //Матрица смежности
    private int[][] adjMatrix;
    //Текущеекол-во вершин
    private int size;

    public Graph(int maxVertices) {
        this.MAX_VERTICES = maxVertices;
        vertices = new Vertex[MAX_VERTICES];
        adjMatrix = new int[MAX_VERTICES][MAX_VERTICES];
        this.size = 0;
    }

    //Добавление вершины
    public void addVertex(char label){
        vertices[size++] = new Vertex(label);
    }

    //Добавление связей-ребер
    public void addEdge(char startCh, char endCh){
        int start = -1;
        int end = -1;
        for (int i = 0; i < size; i++) {
            if (vertices[i].label == startCh) start = i;
            if (vertices[i].label == endCh) end = i;
            if (start >= 0 && end >=0) break;
        }
        adjMatrix[start][end] = 1;
        //adjMatrix[end][start] = 1;
    }

    //Добавление связей-ребер
    public void addEdge(int start, int end){
        adjMatrix[start][end] = 1;
        //adjMatrix[end][start] = 1;
    }

    //Написать вершину
    public void printVertex(int vertex){
        System.out.print(vertices[vertex] + " ");
    }

    //Возвращает непосещенную вершину графа
    private int getUnvisitedVertex(int ver){
        for (int i = 0; i < size; i++) {
            if (adjMatrix[ver][i] == 1 && !vertices[i].wasVisited)
                return i;
        }
        return -1;
    }

    private void resetFlags() {
        for (int i = 0; i < size; i++) {
            vertices[i].wasVisited = false;
        }
    }

    public void depthTravers() {
        Stack stack = new Stack(MAX_VERTICES);
        vertices[0].wasVisited = true;
        printVertex(0);
        stack.insert(0);
        while (!stack.isEmpty()) {
            int v = getUnvisitedVertex(stack.peek());
            if (v == -1) {
                stack.remove();
            } else {
                vertices[v].wasVisited = true;
                printVertex(v);
                stack.insert(v);
            }
        }
        resetFlags();
    }

    public int getNumChar(char vertex){
        for (int i = 0; i < size; i++) {
            if (vertices[i].label == vertex) return i;
        }
        return -1;
    }

    public void widthTravers() {
        Queue queue = new Queue(MAX_VERTICES);
        vertices[0].wasVisited = true;
        printVertex(0);
        queue.insert(0);
        while (!queue.isEmpty()) {
            int vCurr = queue.remove();
            int vNext;
            while ((vNext = getUnvisitedVertex(vCurr)) != -1) {
                vertices[vNext].wasVisited = true;
                printVertex(vNext);
                queue.insert(vNext);
            }
        }
        resetFlags();

    }

    public void getDiffRoutes(char startCh, char endCh){
        ArrayList<String> arrayRoutes = new ArrayList<>();
        int routeKind = 0;

        resetFlags();
        int visitCount = 0;
        int startPoint = getNumChar(startCh);
        int endPoint = getNumChar(endCh);

        Queue queue = new Queue(MAX_VERTICES);
        vertices[startPoint].wasVisited = true;
        queue.insert(startPoint);
        arrayRoutes.add(vertices[startPoint].toString());

        while (!queue.isEmpty()) {
            int vCurr = queue.remove();
            int vNext;
            while ((vNext = getUnvisitedVertex(vCurr)) != -1) {
                vertices[vNext].wasVisited = true;
                visitCount++;
                queue.insert(vNext);
                    arrayRoutes.add(arrayRoutes.get(routeKind) + vertices[vNext].toString());
            }

            if (visitCount > size - 1) {vertices[endPoint].wasVisited = true;} else vertices[endPoint].wasVisited = false;
            routeKind++;
        }

        System.out.println(arrayRoutes);

        displayMinRoute(arrayRoutes, startCh, endCh);
    }

    //Нарисовать минимальный маршрут
    private void displayMinRoute(ArrayList<String> routes, char startCh, char endCh){

        //В этот массив будем загонять пути, содержащие нашу точку
        ArrayList<String> routesWithEPoint = new ArrayList<>();

        //Массив содержащий кол-во ребер для каждого маршрута до конечной точки
        int[] edgeCount;

        //Выделяем массив с наличием необходимых наших вершин
        for (int i = 0; i < routes.size(); i++) {
            if (routes.get(i).contains(String.valueOf(endCh)) && routes.get(i).contains(String.valueOf(startCh))) routesWithEPoint.add(routes.get(i));
        }

        edgeCount = new int[routesWithEPoint.size()];

        //Считаем для каждого найденного маршрута кол-во ребер
        for (int i = 0; i < routesWithEPoint.size(); i++) {
            for (int j = 0; j < routesWithEPoint.get(i).length(); j++) {
                if (routesWithEPoint.get(i).charAt(j) == endCh) edgeCount[i] = j;
            }
        }

        //Поиск и вывод минимального маршрута
        int min = edgeCount[1];
        int minIndex = 0;
        for (int i = 0; i < edgeCount.length; i++) {
            if (edgeCount[i] < min) {min = edgeCount[i]; minIndex = i;}
        }


        System.out.println("Минимальный маршрут от "+ startCh + " до " + endCh + " = " + min);
        for (int i = 0; i < routesWithEPoint.get(minIndex).length(); i++) {
            if (routesWithEPoint.get(minIndex).charAt(i) == endCh) {System.out.print(routesWithEPoint.get(minIndex).charAt(i) + "\n"); break;}
            else System.out.print(routesWithEPoint.get(minIndex).charAt(i) + "->");
        }


        //System.out.println(routesWithEPoint.get(minIndex));
    }

}
