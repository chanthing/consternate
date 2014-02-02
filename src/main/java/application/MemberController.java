package application;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MemberController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(method=RequestMethod.GET, value="/member")
    public @ResponseBody MemberBean member(
					@RequestParam(value="handle") String handle) {
	MemberBean theMember = new MemberBean();

	theMember.setHandle(handle);
	return theMember;
    }
	
}
