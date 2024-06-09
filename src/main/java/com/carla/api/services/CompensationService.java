package com.carla.api.services;

import com.carla.api.dtos.CompensationDTO;
import com.carla.api.entities.Compensation;
import com.carla.api.mapper.CompensationMapper;
import com.carla.api.repositories.CompensationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CompensationService {

    @Autowired
    private CompensationRepository compensationRepository;
    private CompensationMapper compensationMapper = new CompensationMapper();

    public List<CompensationDTO> getCompensationsFiltered(Map<String, String> customQuery, String[] fields,
            Optional<Integer> page,
            Optional<Integer> offset) {
        Compensation comp = new Compensation();

        int counter = 0;
        customQuery.forEach((k, v) -> {
            fields[counter] = k;

            if (k.equals("id")) {
                comp.setId(Long.parseLong(v));
            }
            if (k.equals("salary")) {
                comp.setSalary(v);
            }
            if (k.equals("employer")) {
                comp.setId(Long.parseLong(v));
            }
            if (k.equals("location")) {
                comp.setLocation(v);
            }
            if (k.equals("yearsAtWork")) {
                comp.setYearsAtWork(v);
            }
            if (k.equals("yearsOfExperience")) {
                comp.setYearsOfExperience(v);
            }
            if (k.equals("title")) {
                comp.setTitle(v);
            }
            if (k.equals("signInBonus")) {
                comp.setSignInBonus(v);
            }
            if (k.equals("annualBonus")) {
                comp.setAnnualBonus(v);
            }
            if (k.equals("annualStockBonus")) {
                comp.setAnnualStockBonus(k);
            }
            if (k.equals("gender")) {
                comp.setGender(v);
            }
            if (k.equals("additionalComment")) {
                comp.setAdditionalComment(v);
            }
            if (k.equals("timestamp")) {
                comp.setTimestamp(v);
            }
        });

        List<Compensation> compensations = compensationRepository.findAll(Example.of(comp));
        List<CompensationDTO> dtos = compensationMapper.toDTOList(compensations, fields);

        if (page.isPresent()) {
            Integer p = page.get();
            Integer s = offset.orElse(100);
            return paginate(dtos, p, s);
        }

        return dtos;
    }

    public List<CompensationDTO> getCompensations(Specification<Compensation> spec, String sortKey, String[] fields,
            Optional<Integer> page,
            Optional<Integer> offset) {
        List<Compensation> compensations = compensationRepository.findAll(spec);
        var dtos = compensationMapper.toDTOList(compensations, fields);

        if (sortKey != null)
            switch (sortKey) {
                case "salary":
                    Collections.sort(dtos, new Comparator<CompensationDTO>() {
                        @Override
                        public int compare(CompensationDTO c1, CompensationDTO c2) {
                            return Integer.compare(c1.getSalary(), c2.getSalary());
                        }
                    });
                    break;
                case "id":
                    Collections.sort(dtos, new Comparator<CompensationDTO>() {
                        @Override
                        public int compare(CompensationDTO c1, CompensationDTO c2) {
                            return Long.compare(c1.getId(), c2.getId());
                        }
                    });
                    break;
                case "yearsOfExperience":
                    Collections.sort(dtos, new Comparator<CompensationDTO>() {
                        @Override
                        public int compare(CompensationDTO c1, CompensationDTO c2) {
                            return Integer.compare(c1.getYearsOfExperience(), c2.getYearsOfExperience());
                        }
                    });
                    break;
                case "yearsAtWork":
                    Collections.sort(dtos, new Comparator<CompensationDTO>() {
                        @Override
                        public int compare(CompensationDTO c1, CompensationDTO c2) {
                            return Integer.compare(c1.getYearsAtWork(), c2.getYearsAtWork());
                        }
                    });
                    break;
            }

        if (page.isPresent()) {
            Integer p = page.get();
            Integer s = offset.orElse(100);
            return paginate(dtos, p, s);
        }

        return dtos;
    }

    public Optional<Compensation> getCompensationById(Long id) {
        return compensationRepository.findById(id);
    }

    private List<CompensationDTO> paginate(List<CompensationDTO> compensations, int page, int offset) {
        int totalPages = compensations.size() % offset == 0 ? compensations.size() / offset
                : compensations.size() / offset + 1;
        int max = page >= totalPages ? compensations.size() : offset * (page);
        int min = page > totalPages ? max : offset * (page - 1);

        return compensations.subList(min, max);
    }
}
