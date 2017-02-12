package com.ndnu.jdbc1;

public class DBTest {

	public static void main(String[] args) {
			DBTrans dbt = new DBTrans();
			dbt.displayTableRows();
			dbt.selectEmployee(2);
	}

}
