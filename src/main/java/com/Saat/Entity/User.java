package com.Saat.Entity;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity

@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(nullable = false,name = "isim")
	private String isim;
	
	@Column(nullable = false,name = "soyisim")
	private String soyisim;
	 
	
	@Column(nullable = false,unique = true,name = "telno")
	private String telno;
	
	
	@Column(nullable = false,unique = true,name = "email")
	private String email;
	
	@Column(nullable = false,name = "password")
	private String password;
	
	
	
	
	@Column(name = "kayittarihi")
	private LocalDateTime kayittarihi;
	
	@PrePersist
    protected void onCreate() {
        kayittarihi = LocalDateTime.now();
    }

}
