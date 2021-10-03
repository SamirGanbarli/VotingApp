package com.company.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.company.entity.Candidate;
import com.company.entity.Voter;
import com.company.repository.CandidateRepo;
import com.company.repository.VoterRepo;

@Controller
public class VoterController {

	@Autowired
	VoterRepo voterRepo;

	@Autowired
	CandidateRepo candidateRepo;

	@GetMapping("/")
	public String login() {

		return "login.html";

	}

	@PostMapping("/getlogined")
	public String getlogin(String name, Model model, HttpSession session) {

		Voter voter = voterRepo.findByVoterName(name);
		session.setAttribute("voter", voter);

		if (!voter.getHasVoted()) {

			List<Candidate> candidatelist = candidateRepo.findAll();

			model.addAttribute("candidatelist", candidatelist);

			return "dovote.html";

		} else {
			return "voted.html";
		}
	}

	@GetMapping("/vote")
	public String justvote(int id, HttpSession session) {

		Voter v = (Voter) session.getAttribute("voter");

		v.setHasVoted(true);

		Candidate candidate = candidateRepo.findById(id);

		candidate.setNumberOfVotes(candidate.getNumberOfVotes() + 1);

		candidateRepo.save(candidate);
		voterRepo.save(v);
		
		return "voted.html";

	}
}
