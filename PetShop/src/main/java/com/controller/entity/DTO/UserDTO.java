package com.controller.entity.DTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDTO {
	private String userName;
    private boolean enable;
    private String activeToken;
    private Date dateCreated;
    private Integer authID; // Trường này cần thiết
   
}
