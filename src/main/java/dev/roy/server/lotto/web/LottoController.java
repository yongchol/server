package dev.roy.server.lotto.web;

import dev.roy.server.lotto.domain.Lotto;
import dev.roy.server.lotto.repository.LottoRepository;
import dev.roy.server.lotto.service.LottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RestController
public class LottoController {
    @Autowired
    private LottoRepository repository;

    @Autowired
    private LottoService lottoService;

    @RequestMapping("/lotto/getNumberList")
    public List<Lotto> getNumberList() {
        return repository.findAll();
    }

    @RequestMapping("/lotto/makeNumber")
    public ModelAndView makeNumber(@Valid Lotto lotto, BindingResult result) {
        String name = lotto.getName();
        int gameCnt = lotto.getGameCnt();
        int shuffleCnt = lotto.getShuffleCnt();

        List<Lotto> lottoList = lottoService.makeLottoNumber(name, gameCnt, shuffleCnt);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("lottoList", lottoList);
        modelAndView.setViewName("result");

        return modelAndView;

    }
}