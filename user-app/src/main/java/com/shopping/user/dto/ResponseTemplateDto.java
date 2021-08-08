package com.shopping.user.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseTemplateDto {

	private UserDTO user;

	private SubscriptionDTO subscription;
}
