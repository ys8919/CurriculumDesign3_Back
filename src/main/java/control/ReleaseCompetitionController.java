package control;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Competition;
import service.ReleaseCompetitionInterface;
import service.impl.ReleaseCompetitionService;

@CrossOrigin
@RequestMapping("Controller")
@Controller
public class ReleaseCompetitionController {
	@Resource
	private ReleaseCompetitionInterface releaseCompetition;
	/**
	 * 功能：发布竞赛
	 * mapping:Controller/releaseCompetition
	 * 参数：competitionName，chargePersonId，competitionInfo，CompetitionTime，
	 * 		registrationTimeStart，registrationTimeEnd，checkUser，
	 * 返回值：msg,flag*/
	@ResponseBody
	@RequestMapping("releaseCompetition")
	public String releaseCompetition(@RequestBody Competition competition) {
		return releaseCompetition.releaseCompetition(competition);
	}
	/**
	 * 功能：审核竞赛发布
	 * mapping:Controller/competitionExamine
	 * 参数：auditeason，competitionId,state 不通过为999
	 * 返回值：msg,flag*/
	@ResponseBody
	@RequestMapping("competitionExamine")
	public String  examine(@RequestBody HashMap<String, Object> hasmap) {
		return releaseCompetition.examine(hasmap);
	}
}
