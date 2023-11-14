package com.kannanrameshrk;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class InterviewPanel {
	static Scanner input = new Scanner(System.in);
	Queue<Candidate> interviewQueue = new LinkedList<>();
	List<String> arr = new ArrayList();
	Timer interviewTimer = new Timer();
	
	public static void main(String[] args) {
		
		InterviewPanel ip = new InterviewPanel();
		ip.start();
	}

	private void start() {
		
		while(true) {
			 System.out.println();
			 System.out.println("Interview Panel Application");
			 System.out.println("----------------------------");
			 System.out.println("Select an option:");
	         System.out.println("1. Add candidate to the interview queue");
	         System.out.println("2. Interview next candidate");
	         System.out.println("3. Candidate name lists:");
	         System.out.println("4. interview Completed candidates");
	         System.out.println("5. Exit");

	         int choice = input.nextInt();
	         
	         switch(choice) {
	         	case 1:{
	         		System.out.println("Enter Canditate Name:");
	         		String candidateName = input.next();
	         		Candidate candidate = new Candidate(candidateName);
	         		interviewQueue.add(candidate);
	         		System.out.println(candidateName + " added to the interview queue.");
	         		
	         		 if (interviewQueue.size() == 1) {
	                        startInterviewTimer();
	                    }
	         		 
	                break;
	         	}
	         	case 2:{
	         		 if (!interviewQueue.isEmpty()) {
	         			 Candidate nextCandidate = interviewQueue.poll();
	         			arr.add(nextCandidate.getName());
	                     System.out.println("Interviewing: " + nextCandidate.getName());
	                 } else {
	                   System.out.println("No candidates in the interview queue.");
	                }
	                break;
	         	}
	         	case 3:{
	         		if(interviewQueue.isEmpty()) {
	         			System.out.println("No candidates in waiting for interview..");
	         		}else {
	         			int i=1;
		         		for(Candidate name:interviewQueue) {
		         			System.out.println(i++ +"."+ name.getName());
		         		}
	         		}
	         		break;
	         	}
	         	case 4:{
	         		if(arr.isEmpty()) {
	         			System.out.println("no candidate in finished interviw..");
	         		}else {
	         			int i=1;
	         			for(String str: arr) {
	         				System.out.println(i++ +"."+ str);
	         			}
	         		}
	         		break;
	         	}
	         	 case 5:{
	                    System.out.println("Exiting the application.");
	                    interviewTimer.cancel();
	                    System.exit(0);
	                    
	         	 }
	             default:{
	                System.out.println("Invalid choice. Please enter a valid option.");
	             }
	         }
	            
		}
		
	}

	private void startInterviewTimer() {
		
		interviewTimer.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				 if (!interviewQueue.isEmpty()) {
	                    Candidate nextCandidate = interviewQueue.poll();
	                    arr.add(nextCandidate.getName());
	                    System.out.println("Interview time limit reached for " + nextCandidate.getName() +
	                            ". Moving to the next candidate.");
	                    if (!interviewQueue.isEmpty()) {
	                        startInterviewTimer();
	                    }
	                }
				
			}
			
		}, 30000);
	}

}
