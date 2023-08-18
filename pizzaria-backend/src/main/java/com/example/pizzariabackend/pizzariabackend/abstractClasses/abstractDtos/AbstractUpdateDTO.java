package com.example.pizzariabackend.pizzariabackend.abstractClasses.abstractDtos;

import com.example.pizzariabackend.pizzariabackend.config.messageHandling.ErrorMessages;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public abstract class AbstractUpdateDTO {
    @NotNull(message = ErrorMessages.NOT_NULL)
    @NotBlank(message = ErrorMessages.NOT_BLANK)
    @Positive(message = ErrorMessages.POSITIVE)
    private Long id;
}
