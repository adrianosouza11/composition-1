package br.com.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import br.com.entities.Departament;
import br.com.entities.HourContract;
import br.com.entities.Worker;
import br.com.entities.enums.WorkerLevel;

public class Program {
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner keyboard = new Scanner(System.in);
		SimpleDateFormat stf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter departament's name: ");
		String departamentName = keyboard.nextLine();
		
		System.out.println("Enter worker data:");
		System.out.print("Name: ");
		String workerName = keyboard.nextLine();
		
		System.out.print("Level: ");
		String workerLevel = keyboard.nextLine();
		
		System.out.print("Base Salary: ");
		double baseSalary = keyboard.nextDouble();
		Worker worker = new Worker(workerName,WorkerLevel.valueOf(workerLevel),baseSalary,new Departament(departamentName));
		
		System.out.print("How many contracts to this worker? ");
		int n = keyboard.nextInt();
		
		for(int i=1; i <= n; i++) {
			System.out.println("Enter contract # "+i+ " Data:");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = stf.parse(keyboard.next());
			
			System.out.print("Value per hour: ");
			double valuePerHour = keyboard.nextDouble();
			
			System.out.print("Duration (hours): ");
			int hours = keyboard.nextInt();
			
			HourContract contract = new HourContract(contractDate,valuePerHour,hours);
			
			worker.addContract(contract);
		}
		
		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY)");
		String mouthAndYear = keyboard.next();
		int mouth =  Integer.parseInt(mouthAndYear.substring(0,2));
		int year =  Integer.parseInt(mouthAndYear.substring(3));
		
		System.out.println("Name: "+worker.getName());
		System.out.println("Departament: "+worker.getDepartament().getName());
		System.out.println("Income: "+mouthAndYear+ " :" + String.format("%.2f", worker.income(year,mouth)));
		
		
		keyboard.close();
	}
}
