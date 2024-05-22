package com.vmieres.msrepair.dto;

import java.util.List;
import lombok.Data;

@Data
public class RepairDto {
    List<String> repairs;
    String registration;
    boolean bonus;
}
