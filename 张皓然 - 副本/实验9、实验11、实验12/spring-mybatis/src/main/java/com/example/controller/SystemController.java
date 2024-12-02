package com.example.controller;

import com.example.config.Utils;
import com.example.entity.Course;
import com.example.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/system")
@CrossOrigin(origins = "*")
public class SystemController {



    @PostMapping("/login")
    public boolean login(@RequestBody Map<String,String> map) throws Exception {
        System.out.println("login 中map=="+map);
        String username = map.get("username");
        String password = map.get("password");
        if (username.equals("admin")
                && password.equals("admin")) {
            return true;
        }
        return false;
    }
}