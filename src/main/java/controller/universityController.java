package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pojo.UniversityDTO;
import service.universityService;

import java.util.Arrays;
import java.util.List;

@RestController
public class universityController {

        private final service.universityService universityService;

        @Autowired
        public universityController(universityService universityService) {
            this.universityService = universityService;
        }

        @GetMapping("/universities")
        public List<UniversityDTO> fetchUniversities(@RequestParam List<String> countries) {
//            List<String> domains = Arrays.asList("pku.edu");
//            List<String> webpage= Arrays.asList("http://pku.edu");
//            return Arrays.asList(new UniversityDTO("China", "Peking University", domains,webpage ));
            return universityService.uniByCountries(countries);
        }

        @GetMapping("/universities/all")
        public List<UniversityDTO> allUniversities(){
            return universityService.getAllUniversities();
        }



}
