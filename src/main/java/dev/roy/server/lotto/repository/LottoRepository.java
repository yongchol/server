package dev.roy.server.lotto.repository;
import dev.roy.server.lotto.domain.Lotto;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface LottoRepository extends MongoRepository<Lotto, String> {

}
