package ao.com.costs.costswebapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ao.com.costs.costswebapi.domain.Project;
import ao.com.costs.costswebapi.exception.ProjectNotFoundException;
import ao.com.costs.costswebapi.service.ProjectService;


@RestController
public class ProjectController {
    
    @Autowired
    ProjectService projectService;

    @GetMapping("/project/all")
    public List<Project> getAllProjects(){
        return projectService.getAllProjects();
    }

    @GetMapping("project/{id}")
    public Project getProject(@PathVariable Long id) throws ProjectNotFoundException{
        return projectService.getSingleProject(id);
    }
}
