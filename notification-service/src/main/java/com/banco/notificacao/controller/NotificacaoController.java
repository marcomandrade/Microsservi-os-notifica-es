package com.banco.notificacao.controller;

import com.banco.notificacao.model.Notificacao;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/notificacoes")
@CrossOrigin(origins = "*")
public class NotificacaoController {

    private List<Notificacao> lista = new ArrayList<>();
    private int proximoId = 1;

    @PostMapping
    public Notificacao criar(@RequestBody Notificacao notificacao) {
        notificacao.setId(proximoId);
        notificacao.setLida(false);
        proximoId++;
        lista.add(notificacao);
        return notificacao;
    }

    @GetMapping
    public List<Notificacao> listarTodas() {
        return lista;
    }

    @GetMapping("/nao-lidas")
    public List<Notificacao> listarNaoLidas() {
        List<Notificacao> naoLidas = new ArrayList<>();
        for (Notificacao n : lista) {
            if (!n.isLida()) {
                naoLidas.add(n);
            }
        }
        return naoLidas;
    }

    @PutMapping("/{id}/marcar-lida")
    public String marcarLida(@PathVariable int id) {
        for (Notificacao n : lista) {
            if (n.getId() == id) {
                n.setLida(true);
                return "Notificação marcada como lida";
            }
        }
        return "Notificação não encontrada";
    }
}
