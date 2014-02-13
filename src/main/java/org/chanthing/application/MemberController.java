package org.chanthing.application;

import java.util.concurrent.atomic.AtomicLong;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;;


@Controller
public class MemberController {

	private MemberRepository memberRepo = new MemberRepository();

	@RequestMapping(method=RequestMethod.GET, value="/member")
	@ResponseBody
	public MemberList getAllMembers() {
		return  memberRepo.getAllItems();
	}

    @RequestMapping(method=RequestMethod.GET, value="/member/{id}")
    @ResponseBody
    public MemberBean getMemberById(@PathVariable Long id) {
		return memberRepo.getItemById(id);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/member/{id}")
    @ResponseBody
    public void deleteMemberById(@PathVariable Long id) {
		memberRepo.deleteItemById(id);
    }

	@RequestMapping(method=RequestMethod.POST, value="/member") 
	@ResponseBody
	public MemberBean addMember(MemberBean member) {
		Long id = null;
		id = memberRepo.addItem(member);
		member.setId(id);
		return member;
	}

	@RequestMapping(method=RequestMethod.PUT, value="/member/{id}") 
	@ResponseBody
	public MemberBean updateMember(@PathVariable Long id, MemberBean member) {
		member.setId(id);
		memberRepo.updateItem(member);
		return member;
	}
	
}
