// package clinix.com.clinix_sistema_usuarios.model;

// import com.fasterxml.jackson.annotation.JsonFormat;
// import jakarta.persistence.*;
// import jakarta.validation.constraints.Email;
// import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.Size;
// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.NoArgsConstructor;

// import java.time.LocalDateTime;

// @Entity
// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// public class Usuario {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     //@Column(nullable = false)
//     @NotBlank(message = "O nome é obrigatório.")
//     private String nome;

//     @NotBlank(message = "O nome de usuário é obrigatório.")
//     //@Column(unique = true, nullable = false)
//     private String nomeUsuario;

//     private String CPF;

//     private String RG;

//     private boolean enabled = true;

//     @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
//     private LocalDateTime dataCadastro;

//     @Email(message = "Por favor, insira um email válido.")
//     @NotBlank(message = "O email é obrigatório.")
//     //@Column(unique = true, nullable = false)
//     private String email;

//     @Size(max = 60)
//     @NotBlank(message = "A senha é obrigatória e não pode estar vazia.")
//     private String senha;

//     public Usuario(String nome, String nomeUsuario, String email, String senha, String cpf, String rg) {
//         this.nome = nome;
//         this.nomeUsuario = nomeUsuario;
//         this.email = email;
//         this.senha = senha;
//         this.dataCadastro = LocalDateTime.now();
//         this.enabled = true;
//         this.CPF = cpf;
//         this.RG = rg;
//     }

// }