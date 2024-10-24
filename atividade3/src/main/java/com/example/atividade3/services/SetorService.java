package com.example.atividade3.services;

import com.example.atividade3.dto.SetorDTO;

public interface SetorService {
    void adicionar(SetorDTO setor);
    SetorDTO buscarSetorId(Integer id);
}
