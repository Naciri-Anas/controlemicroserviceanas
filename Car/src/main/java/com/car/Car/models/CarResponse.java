package com.car.Car.models;

import com.car.Car.entities.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarResponse {

    int id;

    String brand;

    String model;

    String matricule;

    Client client;

}
