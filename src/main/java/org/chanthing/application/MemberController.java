package org.chanthing.application;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MemberController {

    @RequestMapping(method=RequestMethod.GET, value="/member")
    @ResponseBody
    public MemberBean member(@RequestParam(value="id") Long id) {
	MemberBean theMember = new MemberBean();

	return theMember;
    }
	
}
