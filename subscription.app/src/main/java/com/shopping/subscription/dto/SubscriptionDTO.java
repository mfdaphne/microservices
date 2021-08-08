package com.shopping.subscription.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SubscriptionDTO {

	private long id;

	private String subscriptionName;

	private double cost;
}
