package Ch04_Trees_Graphs;

import java.util.HashMap;

public class Project {
    String projectName;
    int indegree=0;
    State state;
    public String getProjectName(){return this.projectName;}

    public Project(String projectName){
        this.projectName=projectName;
        this.indegree=0;
    }
}
