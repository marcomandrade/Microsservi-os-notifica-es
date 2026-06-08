package com.banco.consumidor.controller;

import com.banco.consumidor.model.Notificacao;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/consumidor")
@CrossOrigin(origins = "*")
public class ConsumidorController {

    private String urlProvider = "http://localhost:8080";

    private List<Notificacao> processadas = new ArrayList<>();

    @PostMapping("/processar")
    public List<Notificacao> processar() {
        RestTemplate restTemplate = new RestTemplate();

        Notificacao[] naoLidas = restTemplate.getForObject(
            urlProvider + "/notificacoes/nao-lidas",
            Notificacao[].class
        );

        if (naoLidas == null) {
            return processadas;
        }

        for (Notificacao n : naoLidas) {
            processadas.add(n);
            restTemplate.put(urlProvider + "/notificacoes/" + n.getId() + "/marcar-lida", null);
        }

        return processadas;
    }

    @GetMapping("/processadas")
    public List<Notificacao> listarProcessadas() {
        return processadas;
    }
}
