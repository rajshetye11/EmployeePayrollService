package com.bridgelabz.employeepayroll;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class EmployeePayrollServiceTest {
	@Test
	public void givenEmployeeWhenWrittenToFileShouldMatchEmployeeEntries() {
		EmployeePayroll[] arrayOfEmps= {
				new EmployeePayroll(1,"Jeff Bezos",100000.0),
				new EmployeePayroll(2,"Bill Gates",200000.0),
				new EmployeePayroll(3,"Mark Zuckerberg",300000.0)
		};
		EmployeePayrollService eps;
		eps=new EmployeePayrollService(Arrays.asList(arrayOfEmps));
		eps.writeEmployeePayrollData(IOService.FILE_IO);
    	eps.printData(IOService.FILE_IO);
		long entries=eps.countEnteries(IOService.FILE_IO);
		Assert.assertEquals(3, entries);
	
	}
	
	
}
