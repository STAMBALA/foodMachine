package com.food.machine.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.food.machine.entity.UserDataEntity;
import com.food.machine.practices.JsonToJavaObject;
import com.food.machine.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

//@Slf4j
@SuppressWarnings("ALL")
@RestController
@RequestMapping("/food")
public class FoodMachineController {

    @Autowired
    UserServiceImpl userServiceImpl;

    private static final Logger log = LoggerFactory.getLogger(FoodMachineController.class);

    @PostMapping("/id")
    public ResponseEntity<UserDataEntity> createPersons(@RequestBody UserDataEntity userdataEntity) {
        UserDataEntity createdPersons = userServiceImpl.savePersons(userdataEntity);
        log.info("Data saved");
        return new ResponseEntity<>(createdPersons, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public UserDataEntity getByUserId(@PathVariable String id) {
        log.info("data fetched with id " + id);
        return userServiceImpl.getByUserId(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDataEntity>> getAllData() {
        log.info("Method executed successfully");
        return ResponseEntity.ok(userServiceImpl.getAllData());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDataEntity> updateItem(@PathVariable String id, @RequestBody UserDataEntity userDataEntity) {
        Optional<UserDataEntity> optionalItem = userServiceImpl.updateItem(id, userDataEntity);
        if (optionalItem.isPresent()) {
            log.info("Data updated successfully");
            return ResponseEntity.ok(optionalItem.get());
        } else {
            log.info("No data found");
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable String id) {
        boolean isDeleted = userServiceImpl.deleteUser(id);
        if (isDeleted) {
            return ResponseEntity.ok("Item deleted successfully.");
        } else {
            return ResponseEntity.status(404).body("Item not found.");
        }
    }

    @GetMapping("/jsondata")
    public List<JsonToJavaObject> getJsonData() {
        String filePath = "D:/Akhil/file.json";
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFile = new File(filePath);
        List<JsonToJavaObject> jsonDataList = null;
        try {
            jsonDataList = objectMapper.readValue(jsonFile,
                    objectMapper.getTypeFactory().constructCollectionType(List.class, JsonToJavaObject.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonDataList;
    }
}
