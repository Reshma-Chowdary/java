package com.reshma.JstlDropDown;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class TicketBooking extends TagSupport {
	String tableName;
	String columnName;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			Class.forName("org.postgresql.Driver");

			// Establish a database connection
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://LocalHost:5432/LocalHost?user=postgres&password=PostGres@1");

			// Define your SQL query here to retrieve data for the dropdown
			String sqlQuery = "SELECT " + columnName + " FROM " + tableName;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sqlQuery);

			// Generate the HTML for the dropdown
			out.println("<select>");
			out.println("<option disabled selected>select</option>");
			while (rs.next()) {
				String columnValue = rs.getString(columnName);
				out.println("<option value='" + columnValue + "'>" + columnValue + "</option>");
			}
			out.println("</select>");

			// Close database resources
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			throw new JspException(e);
		}
		return SKIP_BODY;
	}
}