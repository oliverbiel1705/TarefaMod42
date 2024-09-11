package com.gabdev.msClient.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor @NoArgsConstructor @Builder
@Document(collection = "client")
public class Client {
    @Id
    private String id;

    @NotEmpty
    @Size(min = 3, max = 50)
    private String name;

    @NotNull
    private Long tel;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @Size(min = 3, max = 50)
    private String address;
}
