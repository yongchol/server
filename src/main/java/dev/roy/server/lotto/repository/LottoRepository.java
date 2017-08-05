package dev.roy.server.lotto.repository;
import dev.roy.server.lotto.domain.Lotto;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface LottoRepository extends MongoRepository<Lotto, String> {
    public List<Lotto> findByName(String name);

    @Query("{'rank':'N/A'}")
    public List<Lotto> findByEmptyRank();

}
