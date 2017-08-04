package dev.roy.server.lotto.repository;
import dev.roy.server.lotto.domain.Lotto;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LottoRepository extends MongoRepository<Lotto, String> {
    public List<Lotto> findByName(String name);

}
