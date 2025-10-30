package com.maventech.elocrm.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maventech.elocrm.model.Oportunidade;
import com.maventech.elocrm.repository.OportunidadeRepository;

@Service
public class OportunidadeService {

    @Autowired
    private OportunidadeRepository oportunidadeRepository;

    // Regra de negócio: atualiza o status e permite ajuste de valor se necessário
    public Optional<Oportunidade> atualizarStatus(Long id, Boolean novoStatus) {
        Optional<Oportunidade> oportunidadeExistente = oportunidadeRepository.findById(id);

        if (oportunidadeExistente.isPresent()) {
            Oportunidade oportunidade = oportunidadeExistente.get();
            oportunidade.setStatus(novoStatus);

            // Exemplo de regra: se a oportunidade for fechada, garantir arredondamento
            if (Boolean.TRUE.equals(novoStatus) && oportunidade.getValorPotencial() != null) {
                BigDecimal valorCorrigido = oportunidade.getValorPotencial().setScale(2, java.math.RoundingMode.HALF_UP);
                oportunidade.setValorPotencial(valorCorrigido);
            }

            oportunidadeRepository.save(oportunidade);
            return Optional.of(oportunidade);
        }

        return Optional.empty();
    
    }
}