package by.work.service.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class OrderDTO {
    List<BigDecimal> price = new ArrayList<>();
    List<Long> ids = new ArrayList<>();
    List<Integer> count = new ArrayList<>();
}
