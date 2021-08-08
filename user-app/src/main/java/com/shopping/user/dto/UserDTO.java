package com.shopping.user.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {

	private long id;

	private String firstName;

	private String lastName;

	private String subscription;
}
