package com.example.pizzariabackend.pizzariabackend.dtos.in.orderDtos;

import com.example.pizzariabackend.pizzariabackend.config.messageHandling.ErrorMessages;
import com.example.pizzariabackend.pizzariabackend.config.validation.RegexValidation;
import com.example.pizzariabackend.pizzariabackend.entities.Flavor;
import com.example.pizzariabackend.pizzariabackend.entities.OtherProduct;
import com.example.pizzariabackend.pizzariabackend.entities.Pizza;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderDTO {
    @NotBlank(message = ErrorMessages.NOT_BLANK)
    @NotNull(message = ErrorMessages.NOT_NULL)
    @Size(max = 50, message = ErrorMessages.MAX_50)
    @Pattern(regexp = RegexValidation.NAME, message = ErrorMessages.NAME)
    private String collaboratorName;
    @CPF
    private String collaboratorCpf;
    @NotBlank(message = ErrorMessages.NOT_BLANK)
    @NotNull(message = ErrorMessages.NOT_NULL)
    @Size(max = 50, message = ErrorMessages.MAX_50)
    @Pattern(regexp = RegexValidation.NAME, message = ErrorMessages.NAME)
    private String customerName;
    @Pattern(regexp = RegexValidation.TELEPHONE, message = ErrorMessages.TELEPHONE)
    private String customerTelephoneNumber;
    @NotEmpty(message = ErrorMessages.NOT_EMPTY)
    private List <Flavor> flavors;
    private List<OtherProduct> otherProducts;
    @NotEmpty(message = ErrorMessages.NOT_EMPTY)
    private List<Pizza> pizzas;
    @Enumerated (EnumType.STRING)
    private com.example.pizzariabackend.pizzariabackend.entities.Size size;
    private boolean delivery;
}
