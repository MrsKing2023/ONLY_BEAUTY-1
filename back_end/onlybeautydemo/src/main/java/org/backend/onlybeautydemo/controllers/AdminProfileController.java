package org.backend.onlybeautydemo.controllers;

import org.backend.onlybeautydemo.models.AdminProfileEntity;
import org.backend.onlybeautydemo.models.dto.AdminProfileDTO;
import org.backend.onlybeautydemo.repository.AdminProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
@CrossOrigin
@RequestMapping(value = "/admin")
public class AdminProfileController {

    @Autowired
    private AdminProfileRepository adminProfileRepository;

    @PostMapping("/addProfile")
    public ResponseEntity<?> addProfile(@RequestBody AdminProfileDTO adminProfileDTO) {

        AdminProfileEntity newProfile = new AdminProfileEntity(adminProfileDTO.getFirstName(), adminProfileDTO.getLastName(), adminProfileDTO.getEmailAddress(), adminProfileDTO.getUserName(), adminProfileDTO.getPassword());

        adminProfileRepository.save(newProfile);

        return new ResponseEntity<>(adminProfileRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getUserProfiles")
    public ResponseEntity<?> getUserProfileObjects() {
        return new ResponseEntity<>(adminProfileRepository.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/removeProfile/{id}")
    public ResponseEntity<?> removeUserProfile(@PathVariable Long id) {
        Optional<AdminProfileEntity> removeProfile = adminProfileRepository.findById(id);

        if(removeProfile.isPresent()) {
            //System.out.println("Profile is present");
             adminProfileRepository.delete(removeProfile.get());
        }
        return new ResponseEntity<>(adminProfileRepository.findAll(), HttpStatus.OK);
    }

    @PutMapping("/updateProfile/{id}")
        public ResponseEntity<?> updateProfile(@PathVariable Long id, @RequestBody AdminProfileDTO adminProfileDTO) {

        Optional <AdminProfileEntity> updateUserProfile = adminProfileRepository.findById(id);

        if (updateUserProfile.isPresent()) {
            updateUserProfile.get().setFirstName(adminProfileDTO.getFirstName());
            updateUserProfile.get().setLastName(adminProfileDTO.getLastName());
            updateUserProfile.get().setEmailAddress(adminProfileDTO.getEmailAddress());
            updateUserProfile.get().setUserName(adminProfileDTO.getUserName());
            updateUserProfile.get().setPassword(adminProfileDTO.getPassword());
            adminProfileRepository.save(updateUserProfile.get());
        }
        return new ResponseEntity<>(adminProfileRepository.findAll(), HttpStatus.OK);

    }

}