package com.ejogajog.setup.service.setup.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Table(name = "trip")
public class Trip extends BaseEntity {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private long id;

	@NotNull
	private double fromLatitude;

    @NotNull
	private double toLatitude;

	@NotNull
	private double fromLongitude;

	@NotNull
	private double toLongitude;

}