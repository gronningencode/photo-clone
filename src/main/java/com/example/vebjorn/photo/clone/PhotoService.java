package com.example.vebjorn.photo.clone;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PhotoService {
    private Map<String, Photo> db = new HashMap<>(){{
        put("1", new Photo("1", "hello.jpg"));
    }};
}
