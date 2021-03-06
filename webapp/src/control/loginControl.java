package control;

import moudel.Utilisateur;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class loginControl {
//    @RequestMapping("")
//    public String index(Model model){
//        System.out.println("casear bta");
//       /// System.out.println(model.getAttribute("email"));
//        return "index.jsp";
//    }

    @RequestMapping("/login")
    public String login(@RequestParam("email")String email, @RequestParam("password")String password, MockHttpSession session ){
       List<Utilisateur>comptes=(new Utilisateur()).login(email,password );
       if (comptes.size()==0)
           return "login";
       else if (comptes.size()==1){
           session.setAttribute("user", comptes.get(0));
           return "/"+comptes.get(0).getType()+"HomePage";}
        return comptes.toString();

    }
    @RequestMapping("/loginpage")
    public String loginpage(){
        return "login";
    }
    @RequestMapping("/")
    public String Accueil(){
        return "index";
    }
}
