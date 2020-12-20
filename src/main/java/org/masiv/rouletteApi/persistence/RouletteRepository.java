package org.masiv.rouletteApi.persistence;
import org.masiv.rouletteApi.model.Roulette;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RouletteRepository extends CrudRepository<Roulette, String> {

}
