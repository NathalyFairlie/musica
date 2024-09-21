package pi.musica.controller;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pi.musica.model.Musica;
import pi.musica.repository.MusicaRepository;

@RestController
@RequestMapping("/api/musicas")
public class MusicaControllerRest {

    @Autowired
    private MusicaRepository musicaRepository;

    @GetMapping
    public ResponseEntity<List<Musica>> listarMusicas() {
        List<Musica> musicas = musicaRepository.findAll();
        return ResponseEntity.ok(musicas);
    }

    @PostMapping
    public ResponseEntity<Musica> criarMusica(@Valid @RequestBody Musica musica) {
        Musica novaMusica = musicaRepository.save(musica);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaMusica);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Musica> obterMusica(@PathVariable Long id) {
        return musicaRepository.findById(id)
                .map(musica -> ResponseEntity.ok(musica))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Musica> atualizarMusica(@PathVariable Long id, @Valid @RequestBody Musica musicaAtualizada) {
        return musicaRepository.findById(id)
                .map(musicaExistente -> {
                    musicaExistente.setNome(musicaAtualizada.getNome());
                    musicaExistente.setGenero(musicaAtualizada.getGenero());
                    musicaExistente.setArtista(musicaAtualizada.getArtista());
                    musicaExistente.setAnoLancamento(musicaAtualizada.getAnoLancamento());
                    Musica musicaSalva = musicaRepository.save(musicaExistente);
                    return ResponseEntity.ok(musicaSalva);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMusica(@PathVariable Long id) {
        if (musicaRepository.existsById(id)) {
            musicaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
