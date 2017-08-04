package dev.roy.server.lotto.service;

import dev.roy.server.lotto.domain.Lotto;
import dev.roy.server.lotto.repository.LottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class LottoService {

    @Autowired
    private LottoRepository repository;

    public static boolean duplicate = false;

    public List<Lotto> makeLottoNumber(String name, int gameCnt, int shuffleCnt) {
        List<Integer> numbers = new ArrayList<Integer>();

        String userName = name;
        int makeCnt = gameCnt;
        int randomCnt = shuffleCnt;

        List<Lotto> lottoList = new ArrayList<Lotto>();

        for(int i=1; i<= makeCnt; i++) {
            numbers = getNormalNumber(randomCnt);//로또번호 6개생성

            Lotto lotto = new Lotto();
            lotto.name = userName;

            lotto.number1 = numbers.get(0);
            lotto.number2 = numbers.get(1);
            lotto.number3 = numbers.get(2);
            lotto.number4 = numbers.get(3);
            lotto.number5 = numbers.get(4);
            lotto.number6 = numbers.get(5);

            Calendar calendar = Calendar.getInstance();
            java.util.Date date = calendar.getTime();
            String today = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));

            lotto.date = today;
            lotto.rank = "N/A";

            lotto = repository.save(lotto);

            lottoList.add(lotto);

        }

        return lottoList;

    }


    public List<Integer> getNormalNumber(int cnt) {
        List<Integer> numberCards = new ArrayList<Integer>();

        for(int i=1;i<=45;i++) {
            numberCards.add(i);
        }
        for(int i=1; i<= cnt; i++) {
            Collections.shuffle(numberCards);
        }

        List<Integer> picked = numberCards.subList(0,6);
        Collections.sort(picked);

        return picked;
    }

    public List<Lotto> getLottoNumberList(boolean adminYn, String name) {
        if(adminYn) {
            return repository.findAll();
        }
        else {
            return repository.findByName(name);
        }
    }


}
