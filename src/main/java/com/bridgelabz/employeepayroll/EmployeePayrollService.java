package com.bridgelabz.employeepayroll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {

	
	public static List<EmployeePayroll> employeePayrollList;
	
	public EmployeePayrollService() {}
	
	public EmployeePayrollService(List<EmployeePayroll> employeePayrollList) {
		this.employeePayrollList = employeePayrollList;
	}
	
	public static void main(String[] args) {
		employeePayrollList = new ArrayList<>();
		
		EmployeePayrollService eps = new EmployeePayrollService(employeePayrollList);
		Scanner consoleInputReader = new Scanner(System.in);
		 eps.readEmployeePayrollData(consoleInputReader);
	     eps.writeEmployeePayrollData(IOService.CONSOLE_IO);
		
	}
	
	private void readEmployeePayrollData(Scanner consoleInputReader) {
		System.out.println("Enter Employee Id: ");
		int id = consoleInputReader.nextInt();
		System.out.println("Enter Employee Name :");
		String name = consoleInputReader.next();
		System.out.println("Enter Employee Salary :");
		double salary = consoleInputReader.nextDouble();
		
		employeePayrollList.add(new EmployeePayroll(id, name, salary));
	}
	
	public void writeEmployeePayrollData(IOService ioService) {
		//System.out.println("\nWriting Employee Payroll Roaster to Console\n" + employeePayrollList);
		if (ioService.equals(IOService.CONSOLE_IO)) {
            System.out.println(employeePayrollList);
        } else if (ioService.equals(IOService.FILE_IO)) {
        	new PayrollFileIOService().writeData(employeePayrollList);
        }
    }
	
	public void printData(IOService ioService) {
		if(ioService.equals(IOService.FILE_IO)) {
			new PayrollFileIOService().printData();
		}
	}
	
	public long countEnteries(IOService ioService) {
		if(ioService.equals(IOService.FILE_IO)) {
			return new PayrollFileIOService().countEntries();
		}
		return  0;
	}
	
	
	
}
