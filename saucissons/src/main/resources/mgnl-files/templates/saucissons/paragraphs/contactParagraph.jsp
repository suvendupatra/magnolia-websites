<%@ taglib prefix="cms" uri="cms-taglib"%>
<%@ taglib prefix="cmsu" uri="cms-util-taglib"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="blossom-taglib" prefix="blossom" %>

<cms:editBar />
<h4>${content.title}</h4>
<p><cms:out nodeDataName="bodyText" /></p>

<c:if test="${not empty errorMessage}">
	<c:forEach items="${errorMessage}" var="msg">
		<p style="color:red;">${msg}</p>
	</c:forEach>
</c:if>

<form action="?" method="POST">
	<blossom:pecid-input />
	<p>Name</p>
	<input type="text" name="name" />
	<p>Email address</p>
	<input type="text" name="email" />
	<p>State</p>
	<select name="state">
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
	</select>
	<p>Enquiry Type</p>
	<select name="enquirytype">
		<option value=""></option>
		<option value="price">Price enquiry</option>
		<option value="general">General enquiry</option>
		<option value="feedback">Feedback</option>
		<option value="marketing">Marketing enquiry</option>
		<option value="media">Sponsorship/media enquiry</option>
	</select>
	<p>Message</p>
	<textarea name="message" class="text"></textarea>
	<input type="submit" value="Send Email" />
</form>