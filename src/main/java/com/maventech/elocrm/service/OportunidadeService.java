package com.maventech.elocrm.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maventech.elocrm.model.Oportunidade;
import com.maventech.elocrm.model.enums.StatusOportunidade;
import com.maventech.elocrm.repository.OportunidadeRepository;

@Service
public class OportunidadeService {

    @Autowired
    private OportunidadeRepository oportunidadeRepository;

    // Atualiza o status e aplica regra de negócio opcional
    public Optional<Oportunidade> atualizarStatus(Long id, StatusOportunidade novoStatus) {
        Optional<Oportunidade> oportunidadeExistente = oportunidadeRepository.findById(id);

        if (oportunidadeExistente.isPresent()) {
            Oportunidade oportunidade = oportunidadeExistente.get();
            oportunidade.setStatus(novoStatus);

            // Exemplo de regra: se a oportunidade for FECHADA, arredondar o valor potencial
            if (novoStatus == StatusOportunidade.FECHADA && oportunidade.getValorPotencial() != null) {
                BigDecimal valorCorrigido = oportunidade.getValorPotencial()
                        .setScale(2, java.math.RoundingMode.HALF_UP);
                oportunidade.setValorPotencial(valorCorrigido);
            }

            oportunidadeRepository.save(oportunidade);
            return Optional.of(oportunidade);
        }

        return Optional.empty();
    }
}
