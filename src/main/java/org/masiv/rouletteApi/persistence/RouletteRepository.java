package org.masiv.rouletteApi.persistence;
import org.masiv.rouletteApi.model.Roulette;
import org.springframework.data.repository.CrudRepository;
public interface RouletteRepository extends CrudRepository<Roulette, String> {

}
