package one.hdcola.AmourIncredible.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import one.hdcola.AmourIncredible.dto.ScenarioDto;
import one.hdcola.AmourIncredible.entity.Scenario;
import one.hdcola.AmourIncredible.exception.ResourceNotFoundException;
import one.hdcola.AmourIncredible.mapper.ScenarioMapper;
import one.hdcola.AmourIncredible.respository.ScenarioRespository;

@Service
@AllArgsConstructor
public class ScenarioServiceImplt implements ScenarioService {
    private ScenarioRespository scenarioRespository;

    @Override
    public ScenarioDto create(ScenarioDto scenarioDto) {
        Scenario scenario = ScenarioMapper.toEntity(scenarioDto);
        Scenario savedScenario = scenarioRespository.save(scenario);
        return ScenarioMapper.toDto(savedScenario);
    }

    @Override
    public ScenarioDto update(ScenarioDto scenarioDto) {
        Scenario scenario = ScenarioMapper.toEntity(scenarioDto);
        Scenario savedScenario = scenarioRespository.save(scenario);
        return ScenarioMapper.toDto(savedScenario);
    }

    @Override
    public ScenarioDto getById(Long id) {
        Scenario scenario = scenarioRespository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Scenario not found:" + id));
        return ScenarioMapper.toDto(scenario);
    }

    @Override
    public List<ScenarioDto> getAll() {
        List<Scenario> scenarios = scenarioRespository.findAll();
        return ScenarioMapper.toDtoList(scenarios);
    }

    @Override
    public void delete(Long id) {
        scenarioRespository.deleteById(id);
    }

}
