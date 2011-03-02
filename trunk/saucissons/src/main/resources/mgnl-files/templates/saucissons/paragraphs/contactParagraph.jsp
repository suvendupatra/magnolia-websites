<%@ taglib prefix="cms" uri="cms-taglib"%>
<%@ taglib prefix="cmsu" uri="cms-util-taglib"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="blossom-taglib" prefix="blossom" %>

<cms:editBar />
<h4>${content.title}</h4>
<div class="rightbg">
	<p><cms:out nodeDataName="bodyText" /></p>
	
	<c:if test="${not empty errorMessage}">
		<c:forEach items="${errorMessage}" var="msg">
			<p style="color:red;">${msg}</p>
		</c:forEach>
	</c:if>
	
	<form action="?" method="POST">
		<blossom:pecid-input />
		
		<table style="margin:0px 10px;">
			<tr>
				<td width="25%"><strong>Name</strong></td>
				<td width="75%"><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td><strong>Email address</strong></td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td><strong>State</strong></td>
				<td><select name="state">
					<option value=""></option>
					<option value="NSW">NSW</option>
					<option value="ACT">ACT</option>
					<option value="VIC">VIC</option>
					<option value="QLD">QLD</option>
					<option value="SA">SA</option>
					<option value="TAS">TAS</option>
					<option value="WA">WA</option>
					<option value="NT">NT</option>
					<option value="Other">Other</option>
				</select></td>
			</tr>
			<tr>
				<td><strong>Enquiry Type</strong></td>
				<td><select name="enquirytype">
					<option value=""></option>
					<option value="Price">Price enquiry</option>
					<option value="General">General enquiry</option>
					<option value="Feedback">Feedback</option>
					<option value="Marketing">Marketing enquiry</option>
					<option value="Media">Sponsorship / Media enquiry</option>
				</select></td>
			</tr>
			<tr>
				<td><strong>Message</strong></td>
				<td><textarea name="message" class="text" cols="60" rows="6"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Send Email" /></td>
			</tr>
		</table>
	</form>
</div>