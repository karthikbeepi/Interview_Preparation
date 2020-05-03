package Google_Leetcode;

import java.util.ArrayList;

public class MinCostEmployee {

	class Employee{
		int hiringCost, salary, severance, noOfMonths;
		public Employee(int h, int s, int sever) {
			hiringCost = h;
			salary = s;
			severance = sever;
		}
		public int costToCompany(int n) {
			return hiringCost + severance + (salary*n);
		}
	}
	ArrayList<Employee> arr = new ArrayList<MinCostEmployee.Employee>();
	
	int dp[][];
	
	public void addEmployee(int h, int s, int sev) {
		arr.add(new Employee(h, s, sev));
	}
	
	public static void main(String[] args) {

		MinCostEmployee obj = new MinCostEmployee();
		
		obj.addEmployee(100, 10, 0);
		obj.addEmployee(150, 20, 0);
		obj.addEmployee(200, 5, 0);
		obj.addEmployee(500, 1, 0);

		int cost = obj.findCostForN(10, 2);
		
		System.out.println("Min cost: "+cost);
		
	}

	private int findCostForN(int numberOfMonths, int minNumEmpl) {
		
		if(numberOfMonths==0)
			return 0;
		
		dp = new int[arr.size()][minNumEmpl+1];
		
		for(int i=0; i<arr.size(); i++)
			for(int j=0; j<minNumEmpl+1; j++)
				dp[i][j] = -1;
		dp[0][1] = arr.get(0).costToCompany(numberOfMonths);
		for(int i=1; i<arr.size(); i++)
			dp[i][1] = (dp[i-1][1]<arr.get(i).costToCompany(numberOfMonths)) ? dp[i-1][1]: arr.get(i).costToCompany(numberOfMonths);
		
		return findMinCost(arr.size()-1, numberOfMonths, minNumEmpl);
	}

	private int findMinCost(int employee, int noOfMonths, int minNumEmp) {

		if(employee+1==minNumEmp)
		{
			int sum =0;
			for(int i=0; i<=employee; i++)
				sum+= arr.get(i).costToCompany(noOfMonths);
			return sum;
		}
				
		if (minNumEmp==0)
			return 0;
	
		if(dp[employee][minNumEmp]==-1) {
			int withCost = arr.get(employee).costToCompany(noOfMonths) + findMinCost(employee-1, noOfMonths, minNumEmp-1);
			int withOutCost = findMinCost(employee-1, noOfMonths, minNumEmp);
			if (withCost<withOutCost)
				dp[employee][minNumEmp] = withCost;
			else
				dp[employee][minNumEmp] = withOutCost;
		}
		
		return dp[employee][minNumEmp];
	}

}
