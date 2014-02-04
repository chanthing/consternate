package org.chanthing.application;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MemberController {

	private Repository<MemberBean> memberRepo = new Repository<MemberBean>("org.chanthing.application.MemberBean", "MEMBER");

    @RequestMapping(method=RequestMethod.GET, value="/member")
    @ResponseBody
    public MemberBean member(@RequestParam(value="id") Long id) {
		return memberRepo.getItem(id);
    }
	
}
