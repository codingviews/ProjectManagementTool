package com.cviews.ppmtool.web;

import com.cviews.ppmtool.model.Project;
import com.cviews.ppmtool.service.ErrorValidationService;
import com.cviews.ppmtool.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    private final ProjectService projectService;
    private final ErrorValidationService errorValidationService;

    public ProjectController(ProjectService projectService, ErrorValidationService errorValidationService) {
        this.projectService = projectService;
        this.errorValidationService = errorValidationService;
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@Valid @RequestBody Project project, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return errorValidationService.validate(bindingResult.getFieldErrors());
        }
        
        Project savedProject = projectService.saveOrUpdate(project);
        return new ResponseEntity<>(savedProject, HttpStatus.CREATED);
    }
}
