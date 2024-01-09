package com.reynn.basicspringredis.model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author Renauldi Albarqawy
 * @Date 09/01/2024
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee implements Serializable {

    @Serial
    private static final long serialVersionUID = -7817224776021728682L;

    private Integer empId;
    private String empName;
    private Double empSalary;
}
