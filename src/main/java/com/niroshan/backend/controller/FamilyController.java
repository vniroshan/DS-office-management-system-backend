package com.niroshan.backend.controller;

import com.niroshan.backend.exception.ResourceNotFoundException;
import com.niroshan.backend.model.Family;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.niroshan.backend.repository.FamilyRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin
@RestController
@RequestMapping("/api/v1/")
public class FamilyController<family> {

    @Autowired
    private FamilyRepository familyRepository;

    //get all families
    @GetMapping("/families")
    public List<Family> getAllFamilies() {


        return familyRepository.findAll();
    }

    //Create Family rest api

    @PostMapping("/families")
    public Family createFamily(@RequestBody Family family) {
        return familyRepository.save(family);
    }

    //Get family by id rest api
    @GetMapping("/families/{id}")
    public ResponseEntity <Family> getFamilyById(@PathVariable Long id){
    Family family = familyRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Family not exit with id:"+id));
   return ResponseEntity.ok(family);
    }

    //Update family rest api
    @PutMapping("/families/{id}")
    public ResponseEntity<Family> updateFamily(@PathVariable Long id,@RequestBody Family familyDetails) {
        Family family = familyRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Family not exit with id:"+id));
    family.setFirstName(familyDetails.getFirstName());
    family.setLastName(familyDetails.getLastName());
    family.setEmailId(familyDetails.getEmailId());

    Family updatedFamily= familyRepository.save(family);
    return ResponseEntity.ok(updatedFamily);
    }

    //Delete family rest api
    @DeleteMapping("/families/{id}")
    public ResponseEntity <Map<String,Boolean>>deleteFamily(@PathVariable Long id) {
        Family family = familyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Family not exit with id:" + id));
        familyRepository.delete(family);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}