package by.work.service.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderDTO {
    List<Double> price = new ArrayList<>();
    List<Integer> count = new ArrayList<>();
}
