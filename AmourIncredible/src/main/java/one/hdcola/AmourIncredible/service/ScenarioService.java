package one.hdcola.AmourIncredible.service;

import java.util.List;

import one.hdcola.AmourIncredible.dto.ScenarioDto;

public interface ScenarioService {
    ScenarioDto create(ScenarioDto scenarioDto);

    ScenarioDto update(ScenarioDto scenarioDto);

    ScenarioDto getById(Long id);

    List<ScenarioDto> getAll();

    void delete(Long id);
}
