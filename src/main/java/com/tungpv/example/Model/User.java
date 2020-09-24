package com.tungpv.example.Model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @JsonProperty
    private Integer id;

    @JsonProperty
    private String fullName;

    @JsonProperty
    private String email;

}
