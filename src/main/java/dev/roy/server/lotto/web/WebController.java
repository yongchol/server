package dev.roy.server.lotto.web;

import dev.roy.server.lotto.domain.Lotto;
import dev.roy.server.lotto.service.LottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class WebController {

    @Autowired
    LottoService lottoService;

    @RequestMapping(value="/",method = RequestMethod.GET)
    public String home(Model model){
        model.addAttribute("lotto", new Lotto());
        return "index";
    }

    @RequestMapping(value="/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping("/view/admin")
    public String viewAll(Model model) throws Exception {
        List<Lotto> lottoList = lottoService.getLottoNumberList(true, "");
        model.addAttribute("lottoList", lottoList);
        return "view";
    }

    @RequestMapping(value="/search",method = RequestMethod.GET)
    public String search(Model model){
        model.addAttribute("lotto", new Lotto());
        return "search";
    }

    @RequestMapping("/view")
    public String view(@Valid Lotto lotto, Model model) {
        String name = lotto.getName();
        boolean adminYn = false;List<Lotto> lottoList = lottoService.getLottoNumberList(false, name);
        model.addAttribute("lottoList", lottoList);
        return "view";
    }

    @RequestMapping(value="/register",method = RequestMethod.GET)
    public String register(){
        return "register";
    }

    @ResponseBody
    @RequestMapping(value="/greeting",method = RequestMethod.GET)
    public String Greeting(){
        return "Message From SpringBoot Service - Hello World!";
    }
}
