package com.carla.api.controllers;

import com.carla.api.dtos.CompensationDTO;
import com.carla.api.entities.Compensation;
import com.carla.api.mapper.CompensationMapper;
import com.carla.api.services.CompensationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/compensation_data")
public class CompensationController {

    private String[] defaultCompensationValues = new String[] {
            "id", "salary", "employer", "location", "yearsAtWork", "yearsOfExperience", "timestamp", "title",
            "location", "signInBonus", "annualBonus", "annualStockBonus", "gender", "additionalComment" };

    @Autowired
    private CompensationService compensationService;

    @Autowired
    private CompensationMapper compensationMapper;

    @GetMapping
    public ResponseEntity<List<CompensationDTO>> getCompensation(
            @RequestParam Optional<String> fields,
            @RequestParam Optional<String> sort,
            @RequestParam Optional<Integer> page,
            @RequestParam Optional<Integer> size,
            @RequestParam Map<String, String> customQuery) {

        List<CompensationDTO> dtos;
        Specification<Compensation> spec = Specification.where(null);

        if (sort.isPresent()) {
            dtos = compensationService.getCompensations(spec, sort.get().toString(), this.defaultCompensationValues,
                    page, size);
        } else if (customQuery.values().size() > 0) {
            dtos = compensationService.getCompensationsFiltered(customQuery, this.defaultCompensationValues, page,
                    size);
        } else {
            dtos = null;
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompensationDTO> getCompensationById(@PathVariable Long id,
            @RequestParam Optional<String> fields) {

        Optional<Compensation> compensation = compensationService.getCompensationById(id);
        if (compensation.isPresent()) {
            String[] fieldList = fields.map(f -> {
                if (f.contains(","))
                    return f.split(",");
                else
                    return new String[] { f };
            })
                    .orElse(this.defaultCompensationValues);

            CompensationDTO dto = compensationMapper.toDTO(compensation.get(), fieldList);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}