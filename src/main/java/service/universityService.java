package service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pojo.UniversityDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class universityService {
    private final RestTemplate restTemplate;

    public universityService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<UniversityDTO> uniByCountryName(String country){
        System.out.println(country);
        String url = "http://universities.hipolabs.com/search?country=" + country;
        ResponseEntity<UniversityDTO[]> response = restTemplate.getForEntity(url, UniversityDTO[].class);
        System.out.println(response.getStatusCode());
        return Arrays.asList(response.getBody());
    }

    public List<UniversityDTO> uniByCountries (List<String> countries){
        List<UniversityDTO> ret = new ArrayList<>();
        for(String country : countries){
            System.out.println("here!");
            ret.addAll(uniByCountryName(country));
        }
        return ret;
    }

    public List<UniversityDTO> getAllUniversities() {
        String url = "http://universities.hipolabs.com/search";
        ResponseEntity<UniversityDTO[]> response = restTemplate.getForEntity(url, UniversityDTO[].class);

        return Arrays.asList(response.getBody());
    }
}
