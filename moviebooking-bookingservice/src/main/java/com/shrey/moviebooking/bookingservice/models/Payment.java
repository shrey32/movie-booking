package com.shrey.moviebooking.bookingservice.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.shrey.moviebooking.bookingservice.enums.PaymentMethod;
import com.shrey.moviebooking.bookingservice.enums.PaymentStatus;

/**
 * 
 * @author Shrey
 *
 */
@Entity
@Table(name = "payments")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Payment extends DBEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "amount")
	private double amount;

	@Column(name = "paymentMethod")
	@Enumerated(EnumType.STRING)
	private PaymentMethod paymentMethod = PaymentMethod.CREDIT_CARD;

	@Column(name = "paymentStatus")
	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus = PaymentStatus.UNPAID;

	@Column(name = "offerId")
	private long offerId;

	@Column(name = "bookingId")
	private long bookingId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public long getOfferId() {
		return offerId;
	}

	public void setOfferId(long offerId) {
		this.offerId = offerId;
	}

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

}
