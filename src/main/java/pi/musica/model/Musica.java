package pi.musica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O Nome é obrigatório.")
    @Size(min = 2, message = "O Nome deve conter pelo menos 2 caracteres.")
    private String nome;

    @NotBlank(message = "O gênero é obrigatório.")
    @Size(min = 2, message = "O gênero deve conter pelo menos 2 caracteres.")
    private String genero;

    private String artista;

    @Min(value = 1500, message = "O ano deve ser maior ou igual a 1895.")
    private int anoLancamento;

    // Construtor padrão
    public Musica() {
    }

    // Construtor com parâmetros
    public Musica(String nome, String genero, String artista, int anoLancamento) {
        this.nome = nome;
        this.genero = genero;
        this.artista = artista;
        this.anoLancamento = anoLancamento;
    }

    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
}
