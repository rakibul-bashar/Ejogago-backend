package com.ejogajog.setup.service.setup.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ejogajog.setup.service.constant.RoleType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Table(name = "roles")
public class Role extends BaseEntity {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private long id;

    @Enumerated(EnumType.STRING)
	@Column(length = 20)
	private RoleType name;


}