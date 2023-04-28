package com.avanade.ad_e_d.dragons.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserGameDTO implements Serializable {

    private String name;

    private Long characterId;

}
