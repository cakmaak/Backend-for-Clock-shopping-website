package com.Saat.Entity;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    @NotBlank(message = "İsim boş olamaz")
    private String isim;

    @NotBlank(message = "soyİsim boş olamaz")
    private String soyisim;

    @NotBlank(message = "Telefon numarası boş olamaz")
    private String telno;

    @Email(message = "Geçerli bir e-mail giriniz")
    private String email;

    @Size(min = 6, message = "Şifre en az 6 karakter olmalı")
    private String password;
}
