package Ch04_Trees_Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph_Adjacency_List {

    int noVertices;
    private Map<Project, List<Project>> adjList;

    public Graph_Adjacency_List(int noVertices){
        this.noVertices=noVertices;
        adjList=new HashMap<Project, List<Project>>();
    }

    Project addProject(String projectName){
        Project p=new Project(projectName);
        adjList.putIfAbsent(p,new ArrayList<>());
        return p;
    }

    void removeVertex(String projectName){

    }

    void addDependency(Project p1,Project p2){
        adjList.get(p1).add(p2);
        p2.indegree++;
    }

    List<Project> getConnectedProjects(Project p){
        if(!adjList.containsKey(p))
        {
            System.out.println("Project NOt Exist!");
            return null;
        }
        return adjList.get(p);
    }




}
