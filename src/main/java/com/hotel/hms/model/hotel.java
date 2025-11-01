package com.hotel.hms.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;

	@NotBlank(message = "Guest name cannot be blank")
	@Size(min = 4, max = 50, message = "Guest name must be between 2 and 50 characters")
	private String guestName;

	@NotNull(message = "Room number cannot be null")
	@Min(value = 4, message = "Room number must be at least 1")
	@Max(value = 5000, message = "Room number cannot exceed 500")
	private Integer roomNumber;

	@NotBlank(message = "Payment status cannot be blank")
	private String paymentStatus;

	private LocalDateTime createdAt;

	private LocalDateTime modifiedAt;

	@PrePersist
	protected void atCreation() {
		LocalDateTime now = LocalDateTime.now();
		this.createdAt = now;
		this.modifiedAt = now;
	}

	@PreUpdate
	protected void atUpdation() {
		this.modifiedAt = LocalDateTime.now();
	}

}
