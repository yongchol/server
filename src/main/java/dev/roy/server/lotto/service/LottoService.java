package dev.roy.server.lotto.service;

import dev.roy.server.lotto.domain.Lotto;
import dev.roy.server.lotto.repository.LottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class LottoService {

    @Autowired
    private LottoRepository repository;

    public static boolean duplicate = false;

    @Value("${lotto.round}")
    private String round;

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
            lotto.round = Integer.parseInt(round);

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

    public void updateRank(Lotto lotto) {
        List<Lotto> targetList = repository.findByEmptyRank();

        int[] answerNumber = new int[7];
        answerNumber[0] = lotto.getNumber1();
        answerNumber[1] = lotto.getNumber2();
        answerNumber[2] = lotto.getNumber3();
        answerNumber[3] = lotto.getNumber4();
        answerNumber[4] = lotto.getNumber5();
        answerNumber[5] = lotto.getNumber6();

        int cnt = 0;
        for(int i=0; i<targetList.size(); i++) {
            Lotto targetLotto = targetList.get(i);
            for(int j=0; j<6; j++) {
                if(answerNumber[j] == targetLotto.getNumber1()) {
                    cnt++;
                    continue;
                }
                else if(answerNumber[j] == targetLotto.getNumber2()) {
                    cnt++;
                    continue;
                }
                else if(answerNumber[j] == targetLotto.getNumber3()) {
                    cnt++;
                    continue;
                }
                else if(answerNumber[j] == targetLotto.getNumber4()) {
                    cnt++;
                    continue;
                }
                else if(answerNumber[j] == targetLotto.getNumber5()) {
                    cnt++;
                    continue;
                }
                else if(answerNumber[j] == targetLotto.getNumber6()) {
                    cnt++;
                    continue;
                }
            }

            System.out.println("cnt : " + cnt);
            System.out.println("lotto.getNumber1() : " + lotto.getNumber1());
            System.out.println("lotto.getNumber2() : " + lotto.getNumber2());
            System.out.println("lotto.getNumber3() : " + lotto.getNumber3());
            System.out.println("lotto.getNumber4() : " + lotto.getNumber4());
            System.out.println("lotto.getNumber5() : " + lotto.getNumber5());
            System.out.println("lotto.getNumber6() : " + lotto.getNumber6());
            System.out.println("targetLotto.getNumber1() : " + targetLotto.getNumber1());
            System.out.println("targetLotto.getNumber2() : " + targetLotto.getNumber2());
            System.out.println("targetLotto.getNumber3() : " + targetLotto.getNumber3());
            System.out.println("targetLotto.getNumber4() : " + targetLotto.getNumber4());
            System.out.println("targetLotto.getNumber5() : " + targetLotto.getNumber5());
            System.out.println("targetLotto.getNumber6() : " + targetLotto.getNumber6());

            if(cnt == 0 || cnt == 1 || cnt == 2) {
                targetLotto.setRank("FAIL");
                repository.save(targetLotto);
            }
            else if(cnt == 3) {
                targetLotto.setRank("5등");
                repository.save(targetLotto);
            }
            else if(cnt == 4) {
                targetLotto.setRank("4등");
                repository.save(targetLotto);
            }
            else if(cnt == 5) {
                targetLotto.setRank("3등");
                repository.save(targetLotto);
            }
            else if(cnt == 6) {
                targetLotto.setRank("1등");
                repository.save(targetLotto);
            }

            cnt = 0;

        }


    }


}
