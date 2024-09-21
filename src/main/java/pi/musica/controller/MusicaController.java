package pi.musica.controller;
        
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pi.musica.exception.ResourceNotFoundException;
import pi.musica.model.Musica;
import pi.musica.repository.MusicaRepository;

@Controller
@RequestMapping("/musicas")
public class MusicaController {

    @Autowired
    private MusicaRepository musicaRepository;

    @GetMapping
    public String listarMusicas(Model model) {
        List<Musica> musicas = musicaRepository.findAll();
        model.addAttribute("musicas", musicas);
        return "listarMusicas"; // Nome do template Thymeleaf
    }

     @GetMapping("/novo")
    public String novaMusica(Model model) {
        model.addAttribute("musica", new Musica());
        return "cadastrarMusica";
    }

    @PostMapping("/novo")
    public String salvarMusica(@Valid @ModelAttribute Musica musica, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "cadastrarMusica";
        }
        musicaRepository.save(musica);
        return "redirect:/musicas"; // Redireciona para a lista após salvar
    }

    @GetMapping("/editar/{id}")
    public String editarMusica(@PathVariable Long id, Model model) {
        Musica musica = musicaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Música não encontrada com ID: " + id));
        model.addAttribute("musica", musica);
        return "editarMusica"; // Nome do template Thymeleaf
    }

    @PostMapping("/editar/{id}")
    public String salvarEdicaoMusica(@PathVariable Long id, @Valid @ModelAttribute Musica musica, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editarMusica";
        }
        Musica musicaExistente = musicaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Música não encontrada com ID: " + id));
        musicaExistente.setNome(musica.getNome());
        musicaExistente.setGenero(musica.getGenero());
        musicaExistente.setArtista(musica.getArtista());
        musicaExistente.setAnoLancamento(musica.getAnoLancamento());
        musicaRepository.save(musicaExistente);
        return "redirect:/musicas"; // Redireciona para a lista após salvar
    }

    @GetMapping("/{id}")
    public String detalhesMusica(@PathVariable Long id, Model model) {
        Musica musica = musicaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Música não encontrada"));
        model.addAttribute("musica", musica);
        return "detalhesMusica"; // Nome do template Thymeleaf
    }

    // Método para deletar (GET para evitar a remoção acidental)
    @GetMapping("/deletar/{id}")
    public String deletarMusica(@PathVariable Long id) {
        Musica musica = musicaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Música não encontrada com ID: " + id));
        musicaRepository.delete(musica);
        return "redirect:/musicas"; // Redireciona para a lista após deletar
    }
}
