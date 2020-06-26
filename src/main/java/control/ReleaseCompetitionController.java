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
	 * ���ܣ���������
	 * mapping:Controller/releaseCompetition
	 * ������competitionName��chargePersonId��competitionInfo��CompetitionTime��
	 * 		registrationTimeStart��registrationTimeEnd��checkUser��
	 * ����ֵ��msg,flag*/
	@ResponseBody
	@RequestMapping("releaseCompetition")
	public String releaseCompetition(@RequestBody Competition competition) {
		return releaseCompetition.releaseCompetition(competition);
	}
	/**
	 * ���ܣ���˾�������
	 * mapping:Controller/competitionExamine
	 * ������auditeason��competitionId,state ��ͨ��Ϊ999
	 * ����ֵ��msg,flag*/
	@ResponseBody
	@RequestMapping("competitionExamine")
	public String  examine(@RequestBody HashMap<String, Object> hasmap) {
		return releaseCompetition.examine(hasmap);
	}
}
