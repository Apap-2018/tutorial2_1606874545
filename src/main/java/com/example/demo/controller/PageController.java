package com.example.demo.controller;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {
	
		@RequestMapping("/viral")
		public String index() {
			return "viral";
	
		}	
		@RequestMapping("/challenge")
		public String challenge(@RequestParam(value="name")String name, Model model) {
			model.addAttribute("name",name);
			return "challenge";
		}
		
		/*@RequestMapping("/challenge/{name}")
		public String challengePath(@PathVariable String name, Model model) {
			model.addAttribute("name",name);
			return "challenge";
		}*/
		
		@RequestMapping(value= {"/challenge","challenge/{name}"})
		public String challengePath(@PathVariable Optional<String> name, Model model) {
			if(name.isPresent()) {
				model.addAttribute("name",name.get());
			}
			else {
				model.addAttribute("name","KB");
			}
			return "challenge";
		}
		
		@RequestMapping("/generator")
		public String latihan(@RequestParam(value="a",required=false)String a,
				@RequestParam(value="b", required=false)String b, Model model) {
			
			
			if(a==null&&b==null) {
				model.addAttribute("generate","hm");
				model.addAttribute("a","0");
				model.addAttribute("b","0");
			}
			
			else {
				int saveA = Integer.parseInt(a);
				int saveB = Integer.parseInt(b);
				int jumlahM = saveA;
				int kelipatan = saveB;
				String kata="h";
				String output="";
				
				if(jumlahM==0||jumlahM==1) {
					jumlahM=1;
				}
				if(kelipatan==0||kelipatan==1) {
					kelipatan=1;	
				}
				
				for(int i=0; i<jumlahM;i++) {
					kata+="m";
				}
				for (int j=0; j<kelipatan;j++) {
					output+=kata;
					output+=" ";
					
				}
				model.addAttribute("generate",output);
				model.addAttribute("a",saveA);
				model.addAttribute("b",saveB);
				
				
			}
			
			return "generator";
			
			
			
		}
		
		
		
		
	}

