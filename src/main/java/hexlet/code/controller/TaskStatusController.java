package hexlet.code.controller;

import hexlet.code.dto.TaskStatusCreateDTO;
import hexlet.code.dto.TaskStatusDTO;
import hexlet.code.dto.TaskStatusUpdateDTO;
import hexlet.code.service.TaskStatusService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/task_statuses")
public class TaskStatusController {

    @Autowired
    private TaskStatusService taskStatusService;

    @GetMapping(path = "")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<TaskStatusDTO>> index() {
        List<TaskStatusDTO> taskStatuses = taskStatusService.getAll();
        return ResponseEntity.status(HttpStatus.OK)
                .header("X-Total-Count", String.valueOf(taskStatuses.size()))
                .body(taskStatuses);
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    TaskStatusDTO show(@PathVariable Long id) {
        return taskStatusService.findById(id);
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    TaskStatusDTO create(@Valid @RequestBody TaskStatusCreateDTO taskStatusCreateDTO) {
        return taskStatusService.create(taskStatusCreateDTO);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    TaskStatusDTO update(@PathVariable Long id, @Valid @RequestBody TaskStatusUpdateDTO taskStatusUpdateDTO) {
        return taskStatusService.update(taskStatusUpdateDTO, id);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void destroy(@PathVariable Long id) {
        taskStatusService.delete(id);
    }
}
