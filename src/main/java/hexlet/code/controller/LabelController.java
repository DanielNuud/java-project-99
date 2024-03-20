package hexlet.code.controller;

import hexlet.code.dto.*;
import hexlet.code.service.LabelService;
import hexlet.code.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/labels")
public class LabelController {

    @Autowired
    private LabelService labelService;

    @GetMapping("")
    public ResponseEntity<List<LabelDTO>> index() {
        List<LabelDTO> labels = labelService.getAll();
        return ResponseEntity.ok()
                .header("X-Total-Count", String.valueOf(labels.size()))
                .body(labels);
    }

    @GetMapping("/{id}")
    public LabelDTO show(@PathVariable Long id) {
        return labelService.getById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public LabelDTO create(
            @Valid @RequestBody LabelCreateDTO labelCreateDTO) {
        return labelService.create(labelCreateDTO);
    }

    @PutMapping("/{id}")
    public LabelDTO update(
            @PathVariable Long id,
            @Valid @RequestBody LabelUpdateDTO data) {
        return labelService.update(id, data);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        labelService.delete(id);
    }
}
