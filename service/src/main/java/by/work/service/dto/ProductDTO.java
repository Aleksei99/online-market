package by.work.service.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductDTO {
    List<Long> productsID = new ArrayList<>();
}
