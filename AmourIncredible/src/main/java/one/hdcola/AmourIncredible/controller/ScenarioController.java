package one.hdcola.AmourIncredible.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import one.hdcola.AmourIncredible.dto.ScenarioDto;
import one.hdcola.AmourIncredible.service.ScenarioService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@AllArgsConstructor
@RestController
@RequestMapping("/api/scenarios")
public class ScenarioController {
    private ScenarioService scenarioService;

    // create
    @PostMapping("")
    public ResponseEntity<ScenarioDto> postMethodName(@RequestBody ScenarioDto scenarioDto) {
        ScenarioDto createdScenario = scenarioService.create(scenarioDto);
        return ResponseEntity.ok(createdScenario);
    }

    // update
    // getById
    @GetMapping("/{id}")
    public ResponseEntity<ScenarioDto> getMethodName(@PathVariable Long id) {
        return ResponseEntity.ok(scenarioService.getById(id));
    }

    // getAll
    @GetMapping("")
    public ResponseEntity<List<ScenarioDto>> getMethodName() {
        return ResponseEntity.ok(scenarioService.getAll());
    }

    // delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMethodName(@PathVariable Long id) {
        scenarioService.delete(id);
        return ResponseEntity.ok("Scenario deleted successfully: " + id);
    }
}
