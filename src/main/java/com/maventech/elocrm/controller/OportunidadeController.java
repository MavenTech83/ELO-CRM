package com.maventech.elocrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.maventech.elocrm.model.Oportunidade;
import com.maventech.elocrm.repository.OportunidadeRepository;

import jakarta.validation.Valid;

	@RestController
	@RequestMapping("/oportunidades")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public class OportunidadeController {	
	
		 	@Autowired
		    private OportunidadeRepository oportunidadeRepository;

		   // @Autowired
		  //  private OportunidadeService oportunidadeService;// A Service a Nadia que vai fazer?
		 	
		 	@GetMapping
		    public ResponseEntity<List<Oportunidade>> getAll() {
		        return ResponseEntity.ok(oportunidadeRepository.findAll());
	
}
		 	
		 	@GetMapping("/{id}")
		    public ResponseEntity<Oportunidade> getById(@PathVariable Long id) {
		        return oportunidadeRepository.findById(id)
		                .map(resposta -> ResponseEntity.ok(resposta))
		                .orElse(ResponseEntity.notFound().build());
		 	}
		 	
		    @GetMapping("/descricao/{descricao}")
		     public ResponseEntity<List<Oportunidade>> getByDescricao(@PathVariable String descricao) {
		            return ResponseEntity.ok(oportunidadeRepository.findByDescricaoContainingIgnoreCase(descricao));
		        }   
		    @PostMapping
		    public ResponseEntity<Oportunidade> postOportunidade(@Valid @RequestBody Oportunidade oportunidade) {
		        // Garante que é um novo registro
		        oportunidade.setId(null);

		        // Arredonda valor monetário (BigDecimal)
		        if (oportunidade.getValorPotencial() != null) {
		            oportunidade.setValorPotencial(
		                oportunidade.getValorPotencial().setScale(2, java.math.RoundingMode.HALF_UP)
		            );
		        }

		        Oportunidade novaOportunidade = oportunidadeRepository.save(oportunidade);
		        return ResponseEntity.status(HttpStatus.CREATED).body(novaOportunidade);      
		    }
		    @PutMapping
		    public ResponseEntity<Oportunidade> put(@Valid @RequestBody Oportunidade oportunidade) {
		        return oportunidadeRepository.findById(oportunidade.getId())
		                .map(registro -> {
		                    oportunidade.setValorPotencial(
		                        oportunidade.getValorPotencial().setScale(2, java.math.RoundingMode.HALF_UP)
		                    );
		                    return ResponseEntity.ok(oportunidadeRepository.save(oportunidade));
		                })
		                .orElse(ResponseEntity.notFound().build());
		    }
		    
		    @DeleteMapping("/{id}")
	        public ResponseEntity<?> deleteCategoria(@PathVariable Long id) {
	        	return oportunidadeRepository.findById(id)
	        			.map(resposta -> {
	        				oportunidadeRepository.deleteById(id);
	        				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	        			})
	        			.orElse(ResponseEntity.notFound().build());
	        			
	        			}
	}
