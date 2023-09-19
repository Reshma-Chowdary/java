package com.reshma.JstlCustomTags;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class DbDropDown extends TagSupport {
	private String tableName;
	private String displayColumn;
	private String valueColumn;

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public void setDisplayColumn(String displayColumn) {
		this.displayColumn = displayColumn;
	}

	public void setValueColumn(String valueColumn) {
		this.valueColumn = valueColumn;
	}

	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		Statement st = null;
		ResultSet rst = null;
		String qry = null;
		Connection cn = null; // Declare connection outside try block

		try {
			// Load the PostgreSQL JDBC driver (replace with your driver)
			Class.forName("org.postgresql.Driver");

			// Establish a database connection (replace with your database details)
			cn = DriverManager.getConnection(
					"jdbc:postgresql://192.168.110.48:5432/plf_training?user=plf_training_admin&password=pff123");

			// Build the SQL query
			qry = "SELECT " + displayColumn + "," + valueColumn + " FROM " + tableName;

			// Create a statement and execute the query
			st = cn.createStatement();
			rst = st.executeQuery(qry);

			// Generate the dropdown HTML
			out.print("<select name='select'>");
			while (rst.next()) {
				String optionValue = rst.getString(valueColumn);
				String optionLabel = rst.getString(displayColumn);
				out.print("<option value='" + optionValue + "'>" + optionLabel + "</option>");
			}
			out.print("</select>");
			rst.close();
			st.close();
			cn.close();
		} catch (Exception e) {
			e.printStackTrace(); // Use a logger for better error handling
		}
		return SKIP_BODY;
	}
}
