package one.hdcola.AmourIncredible.mapper;

import java.util.List;
import java.util.stream.Collectors;

import one.hdcola.AmourIncredible.dto.ScenarioDto;
import one.hdcola.AmourIncredible.entity.Scenario;

public class ScenarioMapper {
    public static ScenarioDto toDto(Scenario scenario) {
        ScenarioDto scenarioDto = new ScenarioDto();
        scenarioDto.setId(scenario.getId());
        scenarioDto.setName(scenario.getName());
        scenarioDto.setDescription(scenario.getDescription());
        scenarioDto.setPrompt(scenario.getPrompt());
        return scenarioDto;
    }

    public static Scenario toEntity(ScenarioDto scenarioDto) {
        Scenario scenario = new Scenario();
        scenario.setId(scenarioDto.getId());
        scenario.setName(scenarioDto.getName());
        scenario.setDescription(scenarioDto.getDescription());
        scenario.setPrompt(scenarioDto.getPrompt());
        return scenario;
    }

    public static List<ScenarioDto> toDtoList(List<Scenario> scenarios) {
        return scenarios.stream().map(ScenarioMapper::toDto).collect(Collectors.toList());
    }
}
