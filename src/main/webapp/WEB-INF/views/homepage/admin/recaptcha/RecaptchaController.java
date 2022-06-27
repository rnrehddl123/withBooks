package reCAptcha;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/pro")
public class RecaptchaController {
	
	@ResponseBody
	@RequestMapping(value = "/VerifyRecaptcha", method = RequestMethod.POST)
	public int VerifyRecaptcha(HttpServletRequest request) {
		VerifyRecaptcha.setSecretKey("6LdWvKEgAAAAAHjhrYxxLFvXG_xsfgBFJW23Qm4f");
		String gRecaptchaResponse = request.getParameter("recaptcha");
	    try {
	       if(VerifyRecaptcha.verify(gRecaptchaResponse))
	          return 0; // 성공
	       else return 1; // 실패
	    } catch (Exception e) {
	        e.printStackTrace();
	        return -1; //에러
	    }
	}
}
