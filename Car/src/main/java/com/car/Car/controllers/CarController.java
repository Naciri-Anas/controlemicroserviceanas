package com.car.Car.controllers;

import com.car.Car.models.CarResponse;
import com.car.Car.repositories.CarRepository;
import com.car.Car.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/car")
@RequiredArgsConstructor
public class CarController {

    private final CarService cs;

    @GetMapping("/test")
    public String test(){
        return "Working";
    }

    @GetMapping
    public List<CarResponse> findAll(){
        return cs.findAll();
    }

    @GetMapping("/{id}")
    public CarResponse findById(@PathVariable("id") int id) throws Exception{
        return cs.findByID(id);
    }
}
