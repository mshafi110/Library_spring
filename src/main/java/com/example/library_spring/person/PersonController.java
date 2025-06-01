package com.example.library_spring.person;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/library")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PersonController {





}
