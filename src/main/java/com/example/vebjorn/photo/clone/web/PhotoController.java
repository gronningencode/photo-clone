package com.example.vebjorn.photo.clone.web;


import com.example.vebjorn.photo.clone.model.Photo;
import com.example.vebjorn.photo.clone.service.PhotoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.*;

@RestController
public class PhotoController {

    private final PhotoService photoService;

    public PhotoController(PhotoService photoservice) {
        this.photoService = photoservice;
    }


    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/photo")
    public Collection<Photo> get() {

        return photoService.get();
    }

    @GetMapping("/photo/{id}")
    public Photo get(@PathVariable String id) {
        Photo photo = photoService.get(id);
        if (photo == null) {throw new ResponseStatusException(HttpStatus.NOT_FOUND);}
        return photo;
    }

    @DeleteMapping("/photo/{id}")
    public void delete(@PathVariable String id) {
        Photo photo = photoService.remove(id);
        if (photo == null) {throw new ResponseStatusException(HttpStatus.NOT_FOUND);}
    }

    @PostMapping("/photo")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException {


        return photoService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());

    }
}
