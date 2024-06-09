package com.carla.api.mapper;

import com.carla.api.dtos.CompensationDTO;
import com.carla.api.entities.Compensation;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CompensationMapper {

    public CompensationDTO toDTO(Compensation compensation, String[] fields) {
        CompensationDTO dto = new CompensationDTO();
        dto.setId(compensation.getId());

        for (String field : fields) {
            switch (field) {
                case "salary":
                    dto.setSalary(compensation.getSalary());
                    break;
                case "employer":
                    dto.setEmployer(compensation.getEmployer());
                    break;
                case "timestamp":
                    dto.setTimestamp(compensation.getTimestamp());
                    break;
                case "yearsAtWork":
                    dto.setYearsAtWork(compensation.getYearsAtWork());
                    break;
                case "yearsOfExperience":
                    dto.setYearsOfExperience(compensation.getYearsOfExperience());
                    break;
                case "title":
                    dto.setTitle(compensation.getTitle());
                    break;
                case "location":
                    dto.setLocation(compensation.getLocation());
                    break;
                case "signInBonus":
                    dto.setSignInBonus(compensation.getSignInBonus());
                    break;
                case "annualBonus":
                    dto.setAnnualBonus(compensation.getAnnualBonus());
                    break;
                case "annualStockBonus":
                    dto.setAnnualStockBonus(compensation.getAnnualStockBonus());
                    break;
                case "additionalComment":
                    dto.setAdditionalComment(compensation.getAdditionalComment());
                    break;
                case "gender":
                    dto.setGender(compensation.getGender());
                    break;
            }
        }

        return dto;
    }

    public List<CompensationDTO> toDTOList(List<Compensation> compensations, String[] fields) {
        return compensations.stream()
                .map(compensation -> toDTO(compensation, fields))
                .collect(Collectors.toList());
    }
}
