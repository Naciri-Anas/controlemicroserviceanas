package com.car.Car.services;

import com.car.Car.entities.Car;
import com.car.Car.entities.Client;
import com.car.Car.models.CarResponse;
import com.car.Car.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.expression.ExpressionException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository cr;
    private final RestTemplate restTemplate;
    private final String URL="http://localhost:8888/SERVICE-CLIENT";

    private CarResponse mapToCarResponse(Car car, Client[] clients){
        Client foundClient = Arrays.stream(clients)
                .filter(client -> {
                    return (client.getId() == car.getClient_id());
                })
                .findFirst()
                .orElse(null);
        return CarResponse.builder()
                .id(car.getId())
                .brand(car.getBrand())
                .client(foundClient)
                .matricule(car.getMatricule())
                .model(car.getModel())
                .build();

    }

    public List<CarResponse> findAll(){
        List<Car> cars = cr.findAll();
        ResponseEntity<Client[]> response =
                restTemplate.getForEntity(URL+"/api/client", Client[].class);
        Client[] clients = response.getBody();
        return cars.stream().map((Car car) ->
                mapToCarResponse(car, clients)).toList();
    }

    public CarResponse findByID(int id) throws Exception{

        Car car = cr.findById(id).orElseThrow(
                ()-> new Exception("Invalid car ID.")
        );

        Client client = restTemplate.getForObject(URL+"/api/client", Client.class);

        return CarResponse.builder()
                .id(car.getId())
                .brand(car.getBrand())
                .client(client)
                .matricule(car.getMatricule())
                .model(car.getModel())
                .build();
    }

}
